var now = new Date;
var clock = { 
		hour: now.getHours(),
		minute: now.getMinutes(),
		second: now.getSeconds(),
		run: function() {
			this.second += 1;
			if (this.second == 60) {
				this.second = 0;
				this.minute += 1;
				if (this.minute == 60) {
					this.minute = 0;
					this.hour += 1;
					if (this.hour == 24) {
						this.hour = 0;
					}
				}
			}
		},
		show: function() {
			var str = "";
			str += this.hour < 10 ? "0" : "";
			str += this.hour + ":";
			str += this.minute < 10 ? "0" : "";
			str += this.minute + ":";
			str += this.second < 10 ? "0" : "";
			str += this.second;
			document.getElementById("time").innerHTML = str;
		}
};

setInterval(function() {
	clock.show();
	clock.run();
}, 1000);



