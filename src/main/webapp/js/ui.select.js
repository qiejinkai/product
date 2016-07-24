$(function(){	
	var els = $("select[data-value]");
	for(var i=0;i<els.size();i++) {
	
		var el =els.eq(i);
	
		//$("option[value='"+el.attr("data-value")+"']",el).attr('selected','selected');
		el.val(el.attr("data-value"));
		el.uiselect();
	}
	
});
