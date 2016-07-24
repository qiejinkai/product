
/**
 * 行为统计
 * @param event
	define("GATHER_EVNET_JOIN","join");					// 注册
	define("GATHER_EVNET_LOGIN","login");				// 登录
	define("GATHER_EVNET_INTERVIEW","interview");		// 约谈
	define("GATHER_EVNET_SHARE","share");				// 分享
	define("GATHER_EVNET_FAV","fav");					// 收藏
	define("GATHER_EVNET_QA","qa");						// 留言
 * 
 */
function gather_event(event, fn) {
	
	var url = '';
	
	var version = '1.0.0';
	
	var ds = [];
	
	ds.push("ds=" + window.screen.width + "x" + window.screen.height);
	ds.push("dp=" + window.screen.pixelDepth);
	ds.push("cs=" + document.charset);
	
	var id = false;
	
	var cookies = document.cookie.split(";");
	
	for(var i=0;i<cookies.length;i++){
		var kv = cookies[i].split("=");
		if(kv[0] == "EFGAID") {
			id = kv[1];
			break;
		}
	}
	
	if(id === false) {
		id = (new Date()).getTime() + '' + Math.random();
	}
	
	var date = new Date();

    date.setTime(date.getTime() + 365 * 3600 * 1000);
    
	document.cookie = "EFGAID=" + id +"; path=/; expire=" + date.toGMTString();
	
	ds.push("gaid=" + id);
	ds.push("version=" + version);
	
	if(event) {
		ds.push("event=" + event);
	}

	var data = [];
	
	data.push("url=" + encodeURIComponent(window.location.href));
	data.push("referer=" + encodeURIComponent(document.referrer));
	
	var keyword = [];
	
	var metas = document.head.getElementsByTagName("meta");
	
	for(var i=0;i<metas.length;i++) {
		if(metas[i]["name"] == "keywords" || metas[i]["name"] == "keyword") {
			var v = metas[i]["content"];
			if(v) {
				keyword = v.split(/[\ ,;、，； ]/i);
			}
			
		}
	}

	if(keyword.length) {
		data.push("keyword=" + encodeURIComponent(keyword.join(' ')));
	}
	
	data.push("data=" + encodeURIComponent(ds.join('&')));
	data.push("r=" + Math.random());
	
	if(window.efgadata) {
		
		for(var key in window.efgadata) {
			data.push(key + "=" + encodeURIComponent(window.efgadata[key]));
		}
		
	}
 	
	var image = new Image();
	
	image.onerror = fn;
	image.onload = fn;
	image.src = url + '/data/gather/do?' + data.join('&');
	
}
