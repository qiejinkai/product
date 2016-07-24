$(function(){
    $(".add_form").hide();
    $(".add_address").click(function(){
        $(".edit_address").hide();
        $(".add_form").show();
    })

    $(".add").click(function(){

        var form1=$("#form1");
        var name = $('input[name=name]',form1).val();
        if (!name) {
            $.tip('请输入收件人姓名');
            return false;
        }
        var phone = $('input[name=phone]',form1).val();
        if (!phone) {
            $.tip('请输入收件人电话');
            return false;
        } else {
            var pattern = /^\d{11}$/;
            if (!pattern.test(phone)) {
                $.tip('请输入正确的电话号码');
                return false;
            }
        }
        var province = $('select[name=province]',form1).val();
        if (!province) {
            $.tip('请选择省份');
            return false;
        }
        var city = $('select[name=city]',form1).val();
        if (!city) {
            $.tip('请选择城市');
            return false;
        }
        var address = $('input[name=address]',form1).val();
        if (!address) {
            $.tip('请输入收件人详细地址');
            return false;
        }
        var zip = $('input[name=zip]',form1).val();
        if (!zip) {
            $.tip('请输入邮编');
            return false;
        } else {
            var pattern = /^\d{6}$/;
            if (!pattern.test(zip)) {
                $.tip('请输入正确的邮编');
                return false;
            }
        }

        $(this).attr("disabled","disabled");
        $("#form1").submit();

    })

    $(".edit").click(function(){
        var form2=$("#form2");
        var name = $('input[name=name]',form2).val();
        if (!name) {
            $.tip('请输入收件人姓名');
            return false;
        }
        var phone = $('input[name=phone]',form2).val();
        if (!phone) {
            $.tip('请输入收件人电话');
            return false;
        } else {
            var pattern = /^\d{11}$/;
            if (!pattern.test(phone)) {
                $.tip('请输入正确的电话号码');
                return false;
            }
        }
        var province = $('select[name=province]',form2).val();
        if (!province) {
            $.tip('请选择省份');
            return false;
        }
        var city = $('select[name=city]',form2).val();
        if (!city) {
            $.tip('请选择城市');
            return false;
        }
        var address = $('input[name=address]',form2).val();
        if (!address) {
            $.tip('请输入收件人详细地址');
            return false;
        }
        var zip = $('input[name=zip]',form2).val();
        if (!zip) {
            $.tip('请输入邮编');
            return false;
        } else {
            var pattern = /^\d{6}$/;
            if (!pattern.test(zip)) {
                $.tip('请输入正确的邮编');
                return false;
            }
        }
        $(this).attr("disabled","disabled");
        $("#form2").submit();
    })

    $(".cancel").click(function(){
        $(".edit_address").hide();
        //window.location.reload();
    })

    $(".del").click(function(){
        var objectId = $(this).attr('tag');
        var url = '/api/reward/project/invest/address/remove';
        $.get(url, {objectId: objectId}, function (res) {
            location.reload();
        })
    })

    $(".default").click(function(){
        var objectId = $(this).attr('tag');

        $.ajax({
            url:'/api/reward/project/invest/address/setDefault',
            type:'POST',
            data:{objectId:objectId},
            success:function(e){
                var o=eval("("+e+")");
                if(o.error){
                    $.tip(o.error);
                    window.location.reload();
                }else{
                    $.tip("设置成功",true);
                    window.location.reload();
                }
            }
        })
    })
})