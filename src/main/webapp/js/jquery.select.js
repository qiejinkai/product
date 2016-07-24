
(function($){
	
	var datachangeFn = function(e){
		
		$(this).uiselect();
		
	};
	
	$.fn.uiselect = function(){
		
		
		for(var i=0;i<this.size();i++){
			
			var el = this.eq(i);
			
			if(el.attr("nouiselect")){
				continue;
			}
			
			(function(el){
			
			var rowCount = 6;
			var itemHeight = 38;
			var skipFirst = false;
			
			if(el.attr("rowCount")){
				rowCount = parseInt(el.attr("rowCount"));
			}
			
			if(el.attr("itemHeight")){
				itemHeight = parseInt(el.attr("rowCount"));
			}
			
			if(el.attr("skipFirst")){
				skipFirst = el.attr("skipFirst") == "true";
			}
			
			
			
			
			el.unbind("datachange",datachangeFn);
			
			var view = el.data("view");
			var width = el.width();
			
			if(el.attr("elwidth")){
				width = el.attr("elwidth");
			}
			
			var inited = true;
			
			if(!view){
				view = $('<div class="ui_select"><a class="cur"><em class="ui_select_ico"></em><span class="text"></span></a><div class="pop"></div></div>');
				view.css({"width":width + "px"}).insertBefore(el);
				el.hide().data("view",view);
				inited = false;
			}
			
			var text = $(".text",view);
			var pop = $(".pop",view);
			var text_a=$(".cur",view);
			text.text($("option[value='"+el.val()+"']",el).text());
			
			pop.html("");
			
			var options = $("option",el);
			
			var count = skipFirst ? options.size() - 1 : options.size();
			
			rowCount = Math.min(rowCount,count);
			
			var columnCount = count % rowCount ? parseInt(count / rowCount) + 1 : parseInt(count / rowCount);
			
			var index = skipFirst? 1 : 0;
			
			var itemWidth = width - 2;
			
			if(el.attr("itemWidth")){
				itemWidth = el.attr("itemWidth");
			}
			
			pop.css({"width": (columnCount * itemWidth) + "px","height":(rowCount * itemHeight) + "px"});
			
			for(var c=0;c <columnCount;c ++){
				
				var ul = $(document.createElement("ul")).css({"width":itemWidth+"px","height":(rowCount * itemHeight) + "px"}).appendTo(pop);
				
				if(c){
					ul.addClass("extend");
				}
				
				for(var r=0;r<rowCount && index < options.size();r++){
					
					var option = options.eq(index);
					var li = $("<li style='width:"+(itemWidth-1)+"px;'><a></a></li>");
					var a = $("a",li);
					
					li.attr("data-value",option.val());
					a.text(option.text());
					
					li.appendTo(ul);
					
					index ++;
				}
				
			}
			
			var hidePopId = false;
			
			var hidePopFn = function(){
				
				if(hidePopId){
					window.clearTimeout(hidePopFn);
					hidePopId = false;
				}
				
				pop.hide();
			};
			
			text_a.unbind("click").unbind("mouseout")
			.bind("click",function(e){
				if(hidePopId){
					window.clearTimeout(hidePopId);
					hidePopId = false;
				}
				pop.show();
			})
			.bind("mouseout",function(e){
				if(hidePopId){
					window.clearTimeout(hidePopId);
				}
				hidePopId = window.setTimeout(hidePopFn,200);
			});
			
			pop.unbind("mouseover").unbind("mouseout")
			.bind("mouseover",function(e){
				if(hidePopId){
					window.clearTimeout(hidePopId);
					hidePopId = false;
				}
			})
			.bind("mouseout",function(e){
				if(hidePopId){
					window.clearTimeout(hidePopId);
				}
				hidePopId = window.setTimeout(hidePopFn,200);
			});
			
			$("li",pop).bind("click",function(e){
				el.val($(this).attr("data-value")).trigger("change");
				pop.hide();
				
			});
			
			el.bind("datachange",datachangeFn);
			
			el.unbind("change.ui").bind("change.ui",function(e){
				text.text($("option[value='"+el.val()+"']",el).text());
				pop.hide();
			});
			
			})(el);
		}
		
		return this;
	};
	
	$(function(){
		
		
		$("select").uiselect();
		
	});
	
})(jQuery);
