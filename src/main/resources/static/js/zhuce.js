$(function () {

    //改变边框颜色
    $('.form-list').hover(function () {
        $(this).css("border", "1px #666666 solid");
    }, function () {
        $(this).css("border", "1px #cccccc solid");
    });

    // 电话号码的正则表达式判断
    var phone_reg = /^1[3|4|5|7|8]\d{9}$/;
    // 电话号码得到焦点显示的内容
    $('#telphone').focus(function(){
        $('.form-validate').eq(0).html('<i class="i-def point"></i><span>完成验证后，你可以用该手机登录和找回密码</span></a>');
    });
    // 电话号码失去焦点
    $('#telphone').blur(function(){
        if ($(this).val() == "") {
            $('.form-validate').eq(0).html('');
            $('.form-list').eq(0).find('.i-status').css('display','none');
        }
        // 电话号码的长度应为11位
        else if($(this).val().length != 11) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">格式有误</span>');
            $('.form-list').eq(0).find('.i-status').css('display','none');
        }
        // 判断输入的是不是手机号码
        else if(!$(this).val().match(phone_reg)) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">格式有误</span>');
            $('.form-list').eq(0).find('.i-status').css('display','none');
        } else {
            $('.form-list').eq(0).css('border','solid 1px #ddd');
            $('.form-list').eq(0).append('<i class="i-status"></i>');
            $('.form-list').eq(0).find('.i-status').css('display','block');

        }
    });
});