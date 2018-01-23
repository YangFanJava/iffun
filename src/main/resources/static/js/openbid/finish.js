$(function () {
    $("#createFile").click(function () {
        var new_password = $("#new_password").val();
        var confirm_password = $("#confirm_password").val();
        if (new_password == '') {
            layer.msg("设置密码不能为空!");
            return;
        }
        if (confirm_password == '') {
            layer.msg("确定密码不能为空!");
            return;
        }
        if (new_password.length < 6 || new_password.length > 16) {
            layer.msg("密码长度为6-16位!");
            return;
        }
        if (confirm_password.length < 6 || confirm_password.length > 16) {
            layer.msg("密码长度为6-16位!");
            return;
            F
        }
        if (new_password != confirm_password) {
            layer.msg("两次密码不一致!");
            $("#new_password").val("")
            $("#confirm_password").val("");
            return;
        }

        if (!check(new_password) || !check(new_password)) {
            layer.msg("密码只能由字母和数字组成!");
            return;
        }

        // 生成文件
        buttonOpt.createFile();
    });

    /*$("#MyForm").validate({
     rules: {
     new_password: {
     required: true,
     rangelength:[6,16]
     },
     confirm_password: {
     required: true,
     equalTo: "#new_password",    //新密码的id选择器
     rangelength:[6,16]
     }
     },
     messages: {
     new_password: {
     required: "请输入新密码",
     rangelength : ""
     },
     confirm_password: {
     required: "请确认新密码",
     equalTo: "两次密码输入不一致",
     rangelength : ""
     }
     }
     });*/

});

function check(pwd) {
    var re = /^[0-9a-zA-Z]*$/g;  //判断字符串是否为数字和字母组合
    if (!re.test(pwd)) {
        return false;
    } else {
        return true;
    }
}

/**
 * 按钮全局操作函数集
 * @type {{lastStep: buttonOpt.lastStep}}
 */
var buttonOpt = {
    /**
     * 生成文件
     */
    createFile: function () {
        $("#MyForm").attr("action", contextRoot + "download/down_end.html");
        $("#MyForm").submit();
    }
}