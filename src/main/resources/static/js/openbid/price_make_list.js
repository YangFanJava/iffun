$(function () {

    // 上一步
    $("#lastStep").click(function () {
        // 获取项目id
        var projectId = $("#projectId").val();
        buttonOpt.lastStep(projectId);
    });

    // 暂存
    $("#isTemporary").click(function () {
        buttonOpt.save();
    });

    // 下一步
    $("#nextStep").click(function () {
        // 前端校验
        var parents = $(".isparent");
        var flag = true;
        $(parents).each(function (index, element) {
            var parentId = $(element).children("input:first-child").val();
            var childsByPid = $("[data-parentid="+parentId+"]");
            if(childsByPid != undefined && childsByPid.length == 0){
                // 无子节点时
                // 判断单价输入是否等于价格组成之和
                var tds = $(element).find("td");
                var unitPrice = 0.00;
                $(tds).each(function (ind, ele) {
                    // 计算单价
                    if (ind >= 7 && ind <= 18) {
                        var val = $(this).find("input").val();
                        if (val != '') {
                            unitPrice += parseFloat(val);
                        }
                    }
                });
                var existUnitPrice = $(element).find("td").eq(6).find("input").val();
                if(unitPrice.toFixed(2) != parseFloat(existUnitPrice).toFixed(2)){
                    var pname = $(element).find("td").eq(1).children("input:first-child").val();
                    layer.msg($(element).parent().attr("data-package") + " [" + pname + "] 价格组成输入之和不等于单价");
                    flag = false;
                    return false;
                }
            }else {
                // 有子节点时
                // 获取父节点单价
                var existUnitPrice = $(element).find("td:eq(6) input").val();
                // 获取父节点总价
                var existTotalPrice = $(element).find("td:eq(5) input").val();
                // 判断子节点单价之和、总价之和是否等于父节点
                // 获取子节点单价相加
                var unitPriceTotal = 0.00;
                var totalPriceTotal = 0.00;
                $(childsByPid).each(function (index, eles) {
                    var unitPrice = $(eles).find("td:eq(6) input").val();
                    var totalPrice = $(eles).find("td:eq(5) input").val();
                    if(unitPrice != ''){
                        unitPriceTotal += parseFloat(unitPrice);
                    }
                    if(totalPrice != ''){
                        totalPriceTotal += parseFloat(totalPrice);
                    }
                });
                if(parseFloat(existUnitPrice).toFixed(2) != unitPriceTotal.toFixed(2)){
                    var pname = $(element).find("td").eq(1).children("input:first-child").val();
                    layer.msg($(element).parent().attr("data-package") + " [" + pname + "] 子项单价之和不等于父项单价");
                    flag = false;
                    return false;
                }
                if(parseFloat(existTotalPrice).toFixed(2) != totalPriceTotal.toFixed(2)){
                    var pname = $(element).find("td").eq(1).children("input:first-child").val();
                    layer.msg($(element).parent().attr("data-package") + " [" + pname + "] 子项总价之和不等于父项总价");
                    flag = false;
                    return false;
                }
            }
        });
        if(!flag){
            return;
        }
        buttonOpt.save('save');
    });

});

/**
 * 按钮全局操作函数集
 * @type {{lastStep: buttonOpt.lastStep}}
 */
var buttonOpt = {
    /**
     * 上一步
     * @param projectId
     */
    lastStep: function (projectId) {
        // 跳转页面到上一步
        skip(1, projectId);
    },
    /**
     * 保存和暂存
     * @param flag
     */
    save: function (flag) {
        var index = layer.load(0, {
            shade: [0.1, '#fff'],
            offset: ['40%', '50%']
        });
        if (flag == 'save') {
            // 进入第三步
            $("#navNo").val(3);
            // 保存标识
            $("#flag").val(1);
        } else {
            $("#flag").val(0);
        }
        // 前端校验
        // 获取表单内容
        // 设置表单提交地址
        $.ajax({
            url: contextRoot + "project/price.do",
            method: "post",
            dataType: "json",
            data: $("#myForm").serialize(),
            success: function (data) {
                if (data.status == 200) {
                    layer.close(index);
                    if (flag == 'save') {
                        // 进入编制标书页面
                        window.location.href = contextRoot + "home/make_tender/" + data.data.id;
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
}

/**
 * 计算金额
 * @param obj
 */
function caculate(obj, tbody) {
    //var totalPriceObj = $($(obj).parent().next().children(0));
    //totalPriceObj.val("");
    //人民币大写
    //$("#bidPriceUpper" + tbody).text("");
    // 人民币小写
    //$("#bidPriceLower" + tbody).text("");
    // 行单价置为空
    /*$($(obj).parent().parent()).each(function (index, element) {
        $(this).find("td").eq(6).find("input").val("");
        $(this).find("td").eq(5).find("input").val("");
    });*/

    var reg = /^[0-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
    if ($(obj).val() != '' && !reg.test($(obj).val())) {
        layer.msg("输入格式不正确！");
        $(obj).val("");
        return;
    }

    // 遍历表格，计算数据
    // 获取金额td对象
    // 总价 第6列
    // 单价 第7列
    // 8 9 10 11 12 13 14 15 16 17 18 19列相加得7列
    // 第7列 * 第5列 = 第6列
    /*var unitPrice = 0.00;
    // 计算单价
    $($(obj).parent().parent()).each(function (index, element) {
        $($(this).find("td")).each(function (ind, ele) {
            if (ind >= 7 && ind <= 18) {
                var val = $(this).find("input").val();
                if (val != '') {
                    unitPrice += parseFloat(val);
                }
            }
        });
        if (unitPrice != 0) {
            $(this).find("td").eq(6).find("input").val(unitPrice);
            // 计算总价
            var count = $(this).find("td").eq(4).find("input").val();
            if (count != '') {
                $(this).find("td").eq(5).find("input").val(unitPrice * count);
            }
        }
    });*/

    // 计算货物总价
    //caculateTotal(tbody);

}

/**
 * 计算金额
 * @param obj
 */
function caculateChild(obj, tbody) {
    //var totalPriceObj = $($(obj).parent().next().children(0));
    //totalPriceObj.val("");
    //人民币大写
    //$("#bidPriceUpper" + tbody).text("");
    // 人民币小写
    //$("#bidPriceLower" + tbody).text("");
    // 行单价置为空
    if($(obj).parents("tr").find("td:eq(4) input").val() == ''){
        $(obj).val("");
        layer.msg("请先输入数量");
        return;
    }
    $($(obj).parent().parent()).each(function (index, element) {
        $(this).find("td").eq(6).find("input").val("");
        $(this).find("td").eq(5).find("input").val("");
    });

    var reg = /^[0-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
    if ($(obj).val() != '' && !reg.test($(obj).val())) {
        layer.msg("输入格式不正确！");
        var tdIndex = $(obj).parent().index() - 2;
        var parentId = $(obj).parents("tr").attr("data-parentid");
        $("." + parentId).parent().find("td:eq(" + tdIndex + ")").children("input:first-child").val("");
        $(obj).val("");
        return;
    }

    // 遍历表格，计算数据-- 横排数据计算
    // 获取金额td对象
    // 总价 第6列
    // 单价 第7列
    // 8 9 10 11 12 13 14 15 16 17 18 19列相加得7列
    // 第7列 * 第5列 = 第6列
    var unitPrice = 0.00;
    // 计算单价
    $($(obj).parent().parent()).each(function (index, element) {
        $($(this).find("td")).each(function (ind, ele) {
            if (ind >= 7 && ind <= 18) {
                var val = $(this).find("input").val();
                if (val != '') {
                    unitPrice += parseFloat(val);
                }
            }
        });
        if (unitPrice != 0.00) {
            unitPrice = unitPrice.toFixed(2);
            $(this).find("td").eq(6).find("input").val(unitPrice);
            // 计算总价
            var count = $(this).find("td").eq(4).find("input").val();
            if (count != '') {
                $(this).find("td").eq(5).find("input").val((unitPrice * count).toFixed(2));
            }
        }
    });
    var tdIndex = $(obj).parent().index() - 2;
    caculateRowTotal(obj, tdIndex);


    // 计算货物总价
    //caculateTotal(tbody);

}

/**
 * 计算每一列的总值
 * @param obj
 * @param tdIndex
 */
function caculateRowTotal(obj, tdIndex){
    // 遍历表格，计算数据-- 竖排数据计算
    var rowTotal = 0.00;
    var currClass = $(obj).parents("tr").attr("class");
    $("." + currClass).each(function (index, element) {
        // 根据索引计算每一列的总和并赋值
        var value = $(element).find("td:eq(" + tdIndex + ")").children("input:first-child").val();
        if(value != ''){
            rowTotal += parseFloat(value);
        }
    });
    var parentId = $(obj).parents("tr").attr("data-parentid");
    if(rowTotal != 0.00){
        $("." + parentId).parent().find("td:eq(" + tdIndex + ")").children("input:first-child").val(rowTotal);
    } else {
        $("." + parentId).parent().find("td:eq(" + tdIndex + ")").children("input:first-child").val("");
    }
}

/**
 * 计算个包货物总价
 * @param tbody
 */
function caculateTotal(tbody) {
    var pTotalPrice = 0.00;
    var price;
    // 计算货物总价
    var alltd = $("#bidtable" + tbody + " tr");
    $(alltd).each(function (index, element) {
        if (index == alltd.length - 1) {
            return;
        }
        price = $(this).find("td").eq(5).children(0).val();
        if (price != '') {
            pTotalPrice += parseFloat(price);
        }
    });
    //人民币大写
    $("#bidPriceUpper" + tbody).text(changeMoneyToChinese(pTotalPrice.toFixed(2)));
    // 人民币小写
    $("#bidPriceLower" + tbody).text(pTotalPrice.toFixed(2));
}

/**
 * 动态添加子项
 * @param obj
 */
function addTr(obj, flag1, flag2, packageId) {

    var flag = flag1 + "-" + flag2;
    // 获取是否有子项
    var parentId = $($(obj).parent().parent().children("input:first-child")).val();
    // 获取tr自定义属性parent-id=""的大小
    var trs = $(obj).parent().parent().parent().children("tr");
    var index = 0;
    var indexNum = 1;
    var trIndex;
    $(trs).each(function (ind, element) {
        var data = $(this).attr("data-parentid");
        if (data != undefined && data == parentId) {
            index += 1;
            indexNum += 1;
            trIndex = $(this);
        }
    });

    // 判断是不是第一次添加子项
    // 第一次添加将父级设置为空且不可输入
    if(indexNum < 2){
        var signaleTr = $(obj).parent().parent().children("td");
        $(signaleTr).each(function (index, ele) {
            if(index > 6 && index < signaleTr.length - 1){
                $(ele).children("input:first-child").val("");
                $(ele).children("input:first-child").prop("readonly", true);
            }
        });
    }

    // 拼接tr
    var html = "<tr class='newtr" + flag + "' data-isnewadd='true' data-parentid=" + parentId + ">"
        + "<input type='hidden' value='" + parentId + "' name='details[" + parentId + "].list[" + index + "].pId' data-parentid=" + parentId + "/>"
        + "<input type='hidden' value='" + packageId + "' name='details[" + parentId + "].list[" + index + "].packageId'/>"
        + "<td class='info div-center'><span>(" + indexNum + ")</span></td>"
        + "<td><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].pname' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].sizeNo' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].item' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].purchaseCount' onkeyup='caculate(this)' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].totalPrice' readonly='readonly' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].unitPrice' readonly='readonly' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].materialFee'onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].outsourcingFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].makefFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].fuelFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].discardFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].manageFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].profit' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].taxes' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].repairsFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].installFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].technologyFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><input type='text' class='mb0 border0' name='details[" + parentId + "].list[" + index + "].transpotFee' onkeyup='caculateChild(this," + flag1 + ")' value=''/></td>"
        + "<td class='p0'><a href=\"javascript:;\" onclick=\"deleteTr(this, " + flag1 + ")\">删除</a></td>"
    html += "</tr>";

    if (index > 0) {
        // 获取最后一个等于data-parentid属性的tr
        $(trIndex).after(html);
    } else {
        // 添加子项
        $(obj).parent().parent().after(html);
    }
}

/**
 * 删除tr操作
 * @param obj
 */
function deleteTr(obj, tbody) {
    var isnewadd = $(obj).parent().parent().attr("data-isnewadd");
    var index1 = layer.confirm('您确认删除吗？', {
        btn: ['是', '否'] //按钮
    }, function () {
        var currClass = $(obj).parents("tr").attr("class");
        // 获取父tr的属性
        var parentId = $(obj).parents("tr").attr("data-parentid");
        $(obj).parents("tr").remove();
        if (isnewadd) {
            deleteTrAfterOrder(currClass);
            resetParentInput(currClass, parentId);
            // 重算每一列的值
            for (var i = 7; i < 19; i++){
                caculateRowTotal(obj, i);
            }
            //caculateTotal(tbody);
        } else {
            var index = layer.load(0, {
                shade: [0.1, '#fff'],
                offset: ['40%', '50%']
            });
            // 请求后台删除现有的数据
            // 获取要删除的id
            var id = $($(obj).parent().parent().children("input:first-child")).val();
            $.ajax({
                url: contextRoot + "project/delete_detail/" + id,
                method: "get",
                dataType: "json",
                success: function (data) {
                    if (data.status == 200) {
                        layer.close(index);
                        // 重新排序
                        deleteTrAfterOrder(currClass);
                        //caculateTotal(tbody);
                        resetParentInput(currClass, parentId);
                        // 重算每一列的值
                        for (var i = 7; i < 19; i++){
                            caculateRowTotal(obj, i);
                        }
                    }
                },
                error: function () {
                    layer.alert("操作失败");
                }
            });
        }
        layer.close(index1);
    }, function () {
        layer.close(index1);
    });
}

/**
 * 重新排序
 * @param currClass
 */
function deleteTrAfterOrder(currClass) {
    var indexCount = 1;
    var indexNum = 0;
    $("." + currClass).each(function (index, ele) {
        // 开始重新排序
        // 获取所有的列
        // 获取第一列序号
        // tr下的input
        $(this).children("input").each(function (ind, ele) {
            var data = $(ele).attr("name");
            if (data != undefined && data != '') {
                var curr = data.replace(/list\[\d+\]/, "list[" + indexNum + "]");
                $(ele).attr("name", curr);
            }
        });
        // tr下的td
        $(this).find("td").each(function (index, ele) {
            if (index > 0) {
                var data = $(this).find("input:first").attr("name");
                if (data != undefined && data != '') {
                    var curr = data.replace(/list\[\d+\]/, "list[" + indexNum + "]");
                    $(this).find("input:first").attr("name", curr);
                }
            } else {
                $(this).html("(" + indexCount + ")");
            }
        })
        indexCount++;
        indexNum++;
    });
}

/**
 * 子节点删除完后父节点input框可输入
 * @param currClass 每个父节点下子节点的class属性
 * @param parentId 父id
 */
function resetParentInput(currClass, parentId){
    var currClassDelAfter = $("." + currClass);
    if(currClassDelAfter == undefined || (currClassDelAfter != undefined && currClassDelAfter.length == 0)){
        var signaleTr = $("." + parentId).parent().children("td");
        $(signaleTr).each(function (index, ele) {
            if(index > 6 && index < signaleTr.length - 1){
                // $(ele).children("input:first-child").val("");
                $(ele).children("input:first-child").prop("readonly", false);
            }
        });
    }
}
function cmp(x, y) {
// If both x and y are null or undefined and exactly the same
    if (x === y) {
        return true;
    }

// If they are not strictly equal, they both need to be Objects
    if (!( x instanceof Object ) || !( y instanceof Object )) {
        return false;
    }

//They must have the exact same prototype chain,the closest we can do is
//test the constructor.
    if (x.constructor !== y.constructor) {
        return false;
    }

    for (var p in x) {
        //Inherited properties were tested using x.constructor === y.constructor
        if (x.hasOwnProperty(p)) {
            // Allows comparing x[ p ] and y[ p ] when set to undefined
            if (!y.hasOwnProperty(p)) {
                return false;
            }

            // If they have the same strict value or identity then they are equal
            if (x[p] === y[p]) {
                continue;
            }

            // Numbers, Strings, Functions, Booleans must be strictly equal
            if (typeof( x[p] ) !== "object") {
                return false;
            }

            // Objects and Arrays must be tested recursively
            if (!Object.equals(x[p], y[p])) {
                return false;
            }
        }
    }

    for (p in y) {
        // allows x[ p ] to be set to undefined
        if (y.hasOwnProperty(p) && !x.hasOwnProperty(p)) {
            return false;
        }
    }
    return true;
};