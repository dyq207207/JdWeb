$(function () {
    var flag = 0;
    //改变边框颜色
    $('.form-list').hover(function () {
        $(this).css("border", "1px #666666 solid");
    }, function () {
        $(this).css("border", "1px #cccccc solid");
    });

    var re = /[^\w\u4e00-\u9fa5]/g;//数字、字母（不分大小写）、汉字、下划线
    var reNum = /[^\d]/g;//纯数字
    //对用户名进行验证
    $('#username').focus(function () {//当鼠标聚焦
        $('.form-validate').eq(0).html('<i class="i-def point"></i><span>支持中文、字母、数字、“-”“_”的组合，4-20个字符</span>');
    });
    // 键盘输入
    $('#username').blur(function () {
        // 含有非法字符
        if (re.test(this.value)) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">格式错误，仅支持汉字、字母、数字、“-”“_”的组合</span>');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        } else {
            $('.form-list').eq(0).css('border', 'solid 1px #ddd');
            $('.form-validate').eq(0).html('<i class="i-def point"></i><span>支持中文、字母、数字、“-”“_”的组合，4-20个字符</span>');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        }
    });
    // 鼠标没有聚焦在输入框
    $('#username').blur(function () {
        // 不能为空


        $.ajax({
            url: "http://localhost:8080/checkUserName",
            type: "post",
            data: {
                'userName': $("input[name='username']").val()
            },
            dataType: "json",
            success: function (data) {
                if (data == true) {
                    if (this.value.length < 4) {
                        $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">长度只能在4-20个字符之间</span>');
                        $('.form-list').eq(0).find('.i-status').css('display', 'none');
                        return flag = -1;
                    } else {
                        $('.form-validate').eq(0).html('<i class="i-def error" style="background-position: 0px -117px;">' +
                            '</i><span style="color: #c5c5c5">该用户名可以使用</span>');
                        $('.form-list').eq(0).find('.i-status').css('display', 'none');
                        $('.form-validate').eq(1).html("");
                    }

                } else if (data == false) {
                    $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">该用户名已被注册</span>');
                    $('.form-list').eq(0).find('.i-status').css('display', 'none');
                    $('.form-validate').eq(1).html("");

                }

            }

        })


        if (this.value == "") {
            $('.form-validate').eq(0).html('');
            $('.form-list').eq(0).css('border', 'solid 1px #ddd');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        }
        // 长度超过20个字符
        else if (this.value.length > 20) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">长度只能在4-20个字符之间</span>');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        }
        // 长度少于4个字符
        else if (this.value.length < 4) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">长度只能在4-20个字符之间</span>');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        }
        // 不可以为纯数字
        else if (!reNum.test(this.value)) {
            $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">用户不能是纯数字,请重新输入</span>');
            $('.form-list').eq(0).find('.i-status').css('display', 'none');
        }
        // 成功之后应该显示的内容
        else {
            $('.form-list').eq(0).append('<i class="i-status"></i>');
            $('.form-list').eq(0).css('border', 'solid 1px #ddd');
            $('.form-validate').eq(0).html('');
            $('.form-list').eq(0).find('.i-status').css('display', 'block');
        }
    });

    // 设置密码
    var pwd_reg1 = /^(?![a-zA-Z]+$)(?!\d+$)(?![\W_]+$)\S{6,10}$/;//数字、字母、加字符 6到10
    var pwd_reg2 = /^(?![a-zA-Z]+$)(?!\d+$)(?![\W_]+$)\S{11,20}$/;//数字、字母、加字符 11到20
    var reChar = /[^a-zA-Z]/g;//纯字母
    $('#password').focus(function () {
        $('.form-validate').eq(1).html('<i class="i-def point"></i><span>建议使用字母、数字和符号两种及以上的组合，6-20个字符</span>');
    });
    // 键盘输入
    $('#password').blur(function () {
        // 匹配至少有两种字符组合6-10,安全性为适中
        if ($(this).val().match(pwd_reg1)) {
            $('.form-validate').eq(1).html('<i class="i-def point2"></i><span>安全强度适中，可以使用三种以上的组合来提高安全强度</span>');
            $('.form-list').eq(1).append('<i class="i-status"></i>');
            $('.form-list').eq(1).find('.i-status').css('display', 'block');
        }
        // 匹配至少有两种字符组合11-20,安全性为安全
        else if ($(this).val().match(pwd_reg2)) {
            $('.form-validate').eq(1).html('<i class="i-def point3"></i><span>你的密码很安全</span>');
            $('.form-list').eq(1).append('<i class="i-status"></i>');
            $('.form-list').eq(1).find('.i-status').css('display', 'block');
        }
        // 如果为纯数字或者纯字母安全性的判断
        else if (!reNum.test(this.value) || !reChar.test(this.value)) {
            // 纯数字或密码为六位但小于10位安全性为弱
            if (this.value.length > 5) {
                $('.form-validate').eq(1).html('<i class="i-def point4"></i><span>有被盗风险,建议使用字母、数字和符号两种及以上组合</span>');
                $('.form-list').eq(1).append('<i class="i-status"></i>');
                $('.form-list').eq(1).find('.i-status').css('display', 'block');
            }
            // 纯数字或密码为十位以上安全性为适中
            if (this.value.length > 10) {
                $('.form-validate').eq(1).html('<i class="i-def point2"></i><span>安全强度适中，可以使用三种以上的组合来提高安全强度</span>');
                $('.form-list').eq(1).append('<i class="i-status"></i>');
                $('.form-list').eq(1).find('.i-status').css('display', 'block');
            }
            // 小于六位则不能构成密码
            if (this.value.length < 6) {
                $('.form-validate').eq(1).html('<i class="i-def point"></i><span>建议使用字母、数字和符号两种及以上的组合，6-20个字符</span>');
                $('.form-list').eq(1).find('.i-status').css('display', 'none');
            }
        } else {
            $('.form-validate').eq(1).html('<i class="i-def point"></i><span>建议使用字母、数字和符号两种及以上的组合，6-20个字符</span>');
            $('.form-list').eq(1).find('.i-status').css('display', 'none');
        }
    });
    // 密码的失焦的长度判断
    $('#password').blur(function () {
        // 失焦之后为空时显示的内容
        if ($(this).val() == "") {
            $('.form-validate').eq(1).html('');
            $('.form-list').eq(1).css('border', 'solid 1px #ddd');
            $('.form-list').eq(1).find('.i-status').css('display', 'none');
        }
        // 失焦时长度小于六时显示的内容
        else if (this.value.length < 6) {
            $('.form-validate').eq(1).html('<i class="i-def error"></i><span class="feifa">长度只能在6-20个字符之间</span>');
            return flag = -1;
        } else {
            $('.form-list').eq(1).css('border', 'solid 1px #ddd');
        }
    });

    // 确认密码设置
    $('#Repassword').focus(function () {//鼠标聚焦
        $('.form-validate').eq(2).html('<i class="i-def point"></i><span>请再次输入密码</span>');
    });
    // 鼠标离开
    $('#Repassword').blur(function () {
        // 如果再次密码为空时显示的内容
        if ($(this).val() == "") {
            $('.form-validate').eq(2).html('');
            $('.form-list').eq(2).css('border', 'solid 1px #ddd');
            $('.form-list').eq(2).find('.i-status').css('display', 'none');
        }
        // 判断两次密码是否一致
        else if ($(this).val() != $("#password").val()) {
            $('.form-validate').eq(2).html('<i class="i-def error"></i><span class="feifa">两次密码输入不一致</span>');
            return flag = -1;
        } else {
            $('.form-list').eq(2).css('border', 'solid 1px #ddd');
            $('.form-list').eq(2).append('<i class="i-status"></i>');
            $('.form-list').eq(2).find('.i-status').css('display', 'block');
            $('.form-validate').eq(2).html('');
        }
    });

    // 邮箱的正则表达式判断
    var emali_reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    // 邮箱得到焦点显示的内容
    $('#email').focus(function () {
        $('.form-validate').eq(3).html('<i class="i-def point"></i><span>验证完成后，你可以用该邮箱登录</span>');
    });
    // 邮箱失去焦点
    $('#email').blur(function () {
        if ($(this).val() == "") {
            $('.form-validate').eq(3).html('<a href="#">邮箱验证</a>');
            $('.form-list').eq(3).find('.i-status').css('display', 'none');
        }
        // 判断输入的是不是邮箱
        else if (!$(this).val().match(emali_reg)) {
            $('.form-validate').eq(3).html('<i class="i-def error"></i><span class="feifa">格式有误</span>');
            $('.form-list').eq(3).find('.i-status').css('display', 'none');
            return flag = -1;
        } else {
            $('.form-list').eq(3).css('border', 'solid 1px #ddd');
            $('.form-list').eq(3).append('<i class="i-status"></i>');
            $('.form-list').eq(3).find('.i-status').css('display', 'block');
            $('.form-validate').eq(3).html('');
        }
    });


    var telephone = sessionStorage.getItem("telephone");
    $(".form-next").click(function () {
        if (flag != -1) {
            $.ajax({
                url: "http://localhost:8080/insert",
                type: "post",
                data: {
                    'userName': $("input[name='username']").val(),
                    'password': $("input[name='password']").val(),
                    'email': $("input[name='email']").val(),
                    'telephone': telephone,
                },
                dataType: "json",
                success: function (data) {
                    if (data == true) {
                        alert("注册成功");
                    } else {
                        $('.form-validate').eq(0).html('<i class="i-def error"></i><span class="feifa">该用户名已被注册</span>');
                        $('.form-list').eq(0).css('border', 'solid 1px #e22');
                        $('.form-list').eq(0).find('.i-status').css('display', 'none');
                    }
                }

            })
        }

    });
    $('.feachBtn').click(function() {
    let count = 60;
    const countDown = setInterval(() => {
        if (count === 0) {
        $('.feachBtn').text('重新发送').removeAttr('disabled');
        $('.feachBtn').css({
            background: '#ff9400',
            color: '#fff',
        });
        clearInterval(countDown);
    }
        else {
        $('.feachBtn').attr('disabled', true);
        $('.feachBtn').css({
            background: '#d8d8d8',
            color: '#707070',
        });
        $('.feachBtn').text(count + '秒后可重新获取');
    }
    count--;
},
    1000);
});

});


