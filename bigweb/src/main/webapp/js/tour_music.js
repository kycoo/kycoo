//函数   function  object
function PlayPause(img) {
	//通过dom对象根据一个ID获取 元素标签
	var music = document.getElementById("MusicPlayer");
	//暂停的状态
	if(music.paused) {
		//播放
		music.play();
		img.src = "images/musicBtn.png";
	} else {
		//暂停
		music.pause();
		img.src = "images/musicBtnOff.png";
	}
}

