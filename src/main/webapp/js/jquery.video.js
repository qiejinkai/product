
(function($){
	
	$.fn.video = function(url){
		
		if(url){
			
			var iframe = $(document.createElement("iframe"));
			
			iframe.css({
				"width":"100%",
				"height":"100%",
				"border-width":"0px"
			})
			.attr("allowtransparency","true")
			.attr("scrolling","no");
			
			var i = url.indexOf("youku.com");
		
			if(i >= 0){
				
				i = url.indexOf("?");
				
				if(i >=0 ){
					url = url.substr( 0,i);
				}
				
				i = url.indexOf("/id_");
				
				if(i >= 0){
					url = url.substr(i + 4);
				}
				else {
					i = url.lastIndexOf("/");
					if(i >= false){
						url = url.substr(i + 1);
					}
				}
				
				i = url.indexOf("_");
				
				if(i >= 0){
					url = url.substr( 0,i);
				}
				
				i = url.indexOf(".");
				
				if(i >= 0){
					url = url.substr( 0,i);
				}
				
				iframe.attr("src","http://player.youku.com/embed/"+url);
				
			}
			
			i = url.indexOf("tudou.com");
		
			if(i >= 0){
				
				i = url.indexOf("?");
				
				if(i >=0){
					url = url.substr( 0,i);
				}
				
				var vs = url.split("/");
				
				if(vs.length >=2){
					
					var index = vs.length - 1;
					
					url = vs[index];
					
					if(!url){
						url = vs[-- index];
					}
					
					i = url.indexOf(".");
					
					if(i >= 0){
						url = url.substr(0,i);
					}
					
					var code = url;
					var lcode = vs[ -- index];
					var type ="2";
					
					if(lcode == "view" || lcode ==""){
						lcode = "";
						type = "0";
					}
					
					iframe.attr("src","http://www.tudou.com/programs/view/html5embed.action?type="+type+"&code="+code+"&lcode="+lcode);
					
				}
			}
			
			if(! iframe.attr("src")){
				
			}
			
			this.html("");
			
			iframe.appendTo(this);
		}
		else {
			this.html("");
		}
	
		return this;
	};
	
})(jQuery);
