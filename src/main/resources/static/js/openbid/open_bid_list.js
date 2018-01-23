$(function () {
    $("#isTemporary").click(function () {
        save();
    });

    var flag;
    $("#nextStep").click(function () {
        // 前端校验
        var tbody = $("tbody");
        $(tbody).each(function (itbody, eletbody) {
            // 获取tbody的上一个兄弟节点
            if (itbody > 0) {
                var ths = $(tbody).prev().find("tr th");
                flag = true;
                var trs = $(this).find("tr");
                $(trs).each(function (itr, eletr) {
                    if (itr < $(trs).length - 1) {
                        $(eletr).find("td").each(function (itd, eletd) {
                            if (itd > 1 && itd < 10) {
                                if (itd != 5 && itd != 6 && itd != 8) {
                                    if ($(eletd).find("input").val() == '') {
                                        layer.msg($(eletbody).attr("data-package") + "，第" + (itr + 1) + "行，" + $(ths)[itd].innerText.replace("*", "") + " 不能为空");
                                        flag = false;
                                        return false;
                                    }
                                }
                            }
                        });
                    }
                    if (!flag) {
                        return false;
                    }
                });
                if (!flag) {
                    return false;
                }
            }
        });
        if (!flag) {
            return;
        }
        save('save');
    });

    // 返回主页
    $("#backHome").click(function () {
        window.location.href = contextRoot;
    });

    /* // 金额转大写
     var packNo = $("#packNo").val();
     for (var i = 0; i <= packNo; i++) {
     //人民币大写
     $("#bidPriceUpper" + i).text(changeMoneyToChinese($("#bidPriceLower" + i).text()));
     }*/
});

/**
 * 保存数据
 * @param flag
 */
function save(flag) {
    var index = layer.load(0, {
        shade: [0.1, '#fff'],
        offset: ['40%', '50%']
    });
    if (flag == 'save') {
        $("#navNo").val(2);
        // 保存标识
        $("#flag").val(1);
    } else {
        $("#flag").val(0);
    }
    // 获取表单内容
    // 设置表单提交地址
    $.ajax({
        url: contextRoot + "project/open.do",
        method: "post",
        dataType: "json",
        data: $("#myForm").serialize(),
        success: function (data) {
            if (data.status == 200) {
                layer.close(index);
                if (flag == 'save') {
                    // 跳转页面到导航栏
                    window.location.href = contextRoot + "home/price/" + data.data.id;
                } else {
                    layer.confirm('暂存成功', {
                        btn: ['确定'] //按钮
                    }, function () {
                        window.location.reload();
                    });
                }
            }
        },
        error: function () {
            layer.alert("操作失败");
        }
    });
}

/**
 * 计算金额
 * @param obj
 */
function caculate(obj, tbody) {
    var totalPriceObj = $($(obj).parent().next().children(0));
    totalPriceObj.val("");
    // 先置为空
    //人民币大写
    $("#bidPriceUpper" + tbody).text("");
    // 人民币小写
    $("#bidPriceLower" + tbody).text("");
    if ($(obj).val() == '') {
        return;
    }
    var reg = /^[0-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
    if (!reg.test($(obj).val())) {
        layer.msg("输入格式不正确！");
        $(obj).val("");
        return;
    }

    // 获取数量
    var count = $($(obj).parent().prev().children(0)).val();
    if (count == '') {
        return;
    }
    // 计算总价
    var totalPrice = parseFloat($(obj).val() * count);
    totalPriceObj.val(totalPrice.toFixed(2));

    // 计算总金额
    // 获取金额td对象
    var alltd = $("#bidtable" + tbody + " tr");
    var bidTotalPrice = 0.00;
    var price;
    $(alltd).each(function (index, element) {
        if (index == alltd.length - 1) {
            return;
        }
        price = $(this).children().eq(9).children(0).val();
        if (price != '') {
            bidTotalPrice += parseFloat(price);
        }
    });
    //人民币大写
    var bidTotalM = changeMoneyToChinese(bidTotalPrice.toFixed(2));
    $("#bidPriceUpper" + tbody).text(bidTotalM);
    // 人民币小写
    if(bidTotalM == ''){
        $(obj).val("");
        totalPriceObj.val("");
        $("#bidPriceLower" + tbody).text("");
    } else {
        $("#bidPriceLower" + tbody).text(bidTotalPrice.toFixed(2));
    }

}