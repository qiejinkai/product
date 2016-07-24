$(function () {

    var hash = window.location.hash;
    if (hash == "#bankcard") {

        $('.bank_change_tit span').eq(1).addClass("selected").siblings("span").removeClass("selected");
        $("#content_2").show().siblings(".add_card_txt").hide();
    }

    $('.bank_change_tit span').bind('click', function () {
        $(this).addClass("selected").siblings('span').removeClass("selected");
        $('#content_' + $(this).attr('rel')).show().siblings('.add_card_txt').hide();

    });

    // 解绑银行卡
    $(".fix_grey_bg").hide();
    $(".pop_wrap").hide();

    $('.close').click(function(){
        $('.fix_grey_bg').hide();
        $('.pop_wrap').hide();
    });

    $(".del").click(function(){
        $(".fix_grey_bg").show();
        $(".pop_wrap").show();
        var objectId=$(this).attr("objectId");
        $(".delsub").attr("id",objectId);
    })
    $(".delsub").click(function(){
        var objectId=$(".delsub").attr("id");

        if (!objectId) {
            $.tip('选择有误');
        }else{
            $.ajax({
                url:"/api/reward/me/wallet/bankcard/remove",
                type:"get",
                data:{objectId:objectId},
                success:function(e){
                    var o=eval("("+e+")");
                    if(o.error){
                        $.tip(o.error);
                        window.location.reload();
                    }else{
                        //alert("解绑成功");
                        window.location.reload();
                    }
                }
            })
        }
    })

    var cancelFunction = function () {
        $('.dialog_content input[name=objectId]').val('');
        $('.mask').hide();
        $('.dialog').hide();
    };
    $('.dialog_close').click(cancelFunction);
    $('.cancel_btn').click(cancelFunction);

    $('.alipay_list').bind('click', function () {
        objectId = $(this).attr("objectId");
        var type = $(this).attr("payType");
        var dialog= $('.dialog');
        if (type == "alipay") {
            dialog.find("h1")[0].innerHTML='您确定要解绑该支付宝账号吗?';
        } else {
            dialog.find("h1")[0].innerHTML='您确定要解绑该银行卡吗?';
        }
        if (!objectId) {
            alert('选择有误');
        }
        $('.dialog_content input[name=objectId]').val(objectId);
        $('.mask').show();
        dialog.show();
    });


});
