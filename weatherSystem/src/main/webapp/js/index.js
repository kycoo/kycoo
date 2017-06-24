 
var option = {
    title : {
        text: '未来一周气温变化',
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

var initData = function(data){
    //设置横坐标显示数据
    option.xAxis[0].data = data[0];

    //设置y值
    option.series[0].data = data[1][0];
    option.series[1].data = data[1][1];
}

 $(function(){
    var tempData=[
            [11, 11, 15, 13, 12, 13, 10,10],
            [1, -2, 2, 5, 3, 2, 0,10 ]
    ];
    var d=[weekXAxisData,tempData]
    var xData = [11, 11, 15, 13, 12, 13, 10];
    
    initData(d);
    var myChart = echarts.init(document.getElementById("chart"));
      // 为echarts对象加载数据
    myChart.setOption(option);


    $(document).on('click', '#type>li', function(event) {
        var currentTarget = event.currentTarget;
        switch(currentTarget.id){
            case "locat":
                 break;
            case "half-month":
                break;
            case "hours":
                break;
            default:
                break;
        }
        $("#type>li").removeClass('active');
        $(currentTarget).addClass('active');
    });
 }) 
var CURRENT_CITY = {
    id:"",
    name:""
}
var getCurrentCityFromCook = function(){
    CURRENT_CITY.id = $.cookes("city_id");
    CURRENT_CITY.name = $.cookes("city_name");
}
var getTodayWather = function(){

    $.getJSON('afterHalfMonth', {param1: 'value1'}, function(json, textStatus) {
            
    });


}
var search = function(){
    var cityName = $("#cityName").val();
//    alert(cityName);
}
var getAfter24HoursWeather =  function(){
    $.getJSON('/searchWeather', {cityName: CURRENT_CITY.name}, function(json, textStatus) {
            console.log(json);
            var xAxis = [];
            for(var w in json){

            }
    });
}
var getAfterHalfMonthWeather = function(){

}
var getCityWeather = function(){
	
}
