
var option = {
    title : {
        text: '天气变化',
        subtext: '纯属虚构'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['最高气温','最低气温']
    },
    //右上角工具条
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','周日']
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel : {
                formatter: '{value} °C'
            }
        }
    ],
    series : [
        {
            name:'最高气温',
            type:'line',
            data:[],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'最低气温',
            type:'line',
            data:[],
            markPoint : {
                data : [
//                        {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                    {type : 'min', name: '周最低'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
};
var weekXAxisData = ['周一','周二','周三','周四','周五','周六','**', "-"]
var myChart;
var paint = function(data){
	if(data.length > 0){
		 //设置横坐标显示数据
	    option.xAxis[0].data = data[0];

	    //设置y值
	    option.series[0].data = data[1][0];
	    option.series[1].data = data[1][1];
	}
   
    if(myChart != undefined){
        myChart.setOption(option,true);
    }
    

}

 $(function(){
    getCurrentCityFromCook();
    // var tempData=[
    //         [11, 11, 15, 13, 12, 13, 10,10],
    //         [1, -2, 2, 5, 3, 2, 0,10 ]
    // ];
    // var d=[weekXAxisData,tempData]
    // var xData = [11, 11, 15, 13, 12, 13, 10];
    
    // paint(d);
    myChart = echarts.init(document.getElementById("chart"));
      // 为echarts对象加载数据
    //myChart.setOption(option);

    getCityWeather("");
    $(document).on('click', '#type>li', function(event) {
        var currentTarget = event.currentTarget;
        switch(currentTarget.id){
            case "locat":
                getCityWeather(CURRENT_CITY.name);
                break;
            case "half-month":
            	getAfterHalfMonthWeather();
                break;
            case "hours":
            	getAfter24HoursWeather();
                break;
            default:
                break;
        }
        $("#type>li").removeClass('active');
        $(currentTarget).addClass('active');
    });

    $(document).on('click','#search',function(){
        var name = $("#cityName").val();
        getCityWeather(name);

    })
 }) 

var CURRENT_CITY = {
    id:"",
    name:"成都"
}
var getCurrentCityFromCook = function(){
    CURRENT_CITY.id = $.cookie("cityId");
    CURRENT_CITY.name = $.cookie("cityName");
}
var setCurrentCityName  = function(name=null){
    if(name == null){
        name = $.cookie("cityName");
       
    }
     $("#currentCity").html("当前城市:"+ name)
}
var getAfter24HoursWeather =  function(){
    $("#chart").css("display","block");
    $("#today").css("display","none");
    $.getJSON('24HoursWeather', {cityName: CURRENT_CITY.name}, function(json, textStatus) {
    	if(json.length == 0){
    		alert("城市错误");
    		return;
    	}
    	var xAxis = [];
        var seriesMAX = [];
        var seriesMIN = [];
        for(var i = 0;i < json.length;i++){
        	console.log(json[i].date);
        	xAxis[i] = json[i].date;
            seriesMAX[i] = json[i].highTemp;
            seriesMIN[i] = json[i].lowTemp;
        }
        option.title.text = "24小时天气";
        paint([xAxis,[seriesMAX,seriesMIN]]); 
    });
}

var getAfterHalfMonthWeather = function(){
    $("#chart").css("display","block");
    $("#today").css("display","none");
	$.getJSON('afterHalfMonth', {cityName: CURRENT_CITY.name}, function(json, textStatus) {
			if(json.length == 0){
				alert("城市错误");
	    		return;
	    	}
            var xAxis = [];
            var seriesMAX = [];
            var seriesMIN = [];
            for(var i = 0;i < json.length;i++){
            	console.log(json[i].date);
            	xAxis[i] = json[i].date;
                seriesMAX[i] = json[i].highTemp;
                seriesMIN[i] = json[i].lowTemp;
            }
            option.title.text = "半月天气";
            paint([xAxis,[seriesMAX,seriesMIN]]);

    });
}
var getCityWeather = function(cityName){
	$("#chart").css("display","none");
    $("#today").css("display","block");

    $.getJSON('searchWeather', {cityName: cityName}, function(data, textStatus) {
    	$("#type>li").removeClass('active');
        $("#type>li").eq(0).addClass('active');
    	if( data.cityName == null ){
                alert("未找到城市");
                return;
            }
           
            $("#temp").html("天气："+data.weather);
            $("#highTemp").html("高温："+data.highTemp);
            $("#lowTemp").html("低温："+data.lowTemp);
            $("#winDirction").html("风向："+data.windDirection);
            $("#lifeRate").html("生活指数："+data.lifeRate);
            $("#weatherImg").attr("src",data.img);
            CURRENT_CITY.name = data.cityName;

            setCurrentCityName(data.cityName);
            
    });
}
