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
        /*if (!OFFICE_CONTROL_OBJ.activeDocument.saved) {
         if (confirm("文档修改过,还没有保存,是否需要保存?")) {
         saveFile();
         }
         }*/
        skip(3, projectId);
    },
    /**
     * 保存和暂存
     * @param flag
     */
    save: function (flag) {
        if (flag == 'save') {
            // 进入第四步
            $("#navNo").val(5);
            // 保存标识
            $("#flag").val(1);
        } else {
            $("#flag").val(0);
        }

        // 保存文件
        saveFile(flag);
    }
}

/**
 * 绑定指标
 * @param id
 * @param obj this
 * @param pno 包号
 * @param bname 绑定名称
 */
function bind(id, obj, pno, bname) {
    if (typeof(OFFICE_CONTROL_OBJ.ActiveDocument) == "undefined") {
        OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "文档加载失败或者未加载文档");
        return;
    }
    var selection = OFFICE_CONTROL_OBJ.ActiveDocument.Application.Selection; //获得刚选中的书签的位置
    // var selectText = selection.Text;
    // var range = OFFICE_CONTROL_OBJ.ActiveDocument.Application.Selection.Range;
    // alert(range)
    //获取当前页码
    var page = selection.information(1);
    var afterBName = bname;
    bname = strReplace(bname);
    pno = strReplace(pno);
    var bidname = pno + "_" + bname;
    if (confirm("确定【" + afterBName + "】指标的绑定内容从第" + page + "页开始吗？")) {
        // 绑定
        OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Add(bidname);
        $.ajax({
            type: "POST",
            url: contextRoot + "mark/save_bind.do",
            data: {
                "id": id,
                "pages": page,
            },
            dataType: 'json',
            success: function (data) {
                if (data.status == 200) {
                    var siblings = $(obj).siblings();
                    // 获取当前节点的兄弟节点
                    $(obj).css("display", "none");
                    $(siblings).each(function (index, ele) {
                        $(this).css("display", "block");
                    });
                    // 绑定成功
                    OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "【" + bname + "】指标内容绑定成功");
                }
            },
            error: function (data) {
                OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "绑定失败");
            }
        });
    }
}

/**
 * 去掉特殊字符
 * @param s
 * @returns {string|XML|*}
 */
function strReplace(s) {
    s = s.replace("-", "");
    // 去掉转义字符
    s = s.replace(/[\'\"\\\/\b\f\n\r\t]/g, '');
    // 去掉特殊字符
    s = s.replace(/[\@\#\$\%\^\&\*\(\)\{\}\:\"\L\<\>\?\[\]]/);
    return s;
}

/**
 * 删除指标
 * @param id
 * @param obj this
 * @param pno 包号
 * @param bname 绑定名称
 */
function del(id, obj, pno, bname) {
    var afterBName = bname;
    bname = strReplace(bname);
    pno = strReplace(pno);
    var bidname = pno + "_" + bname;
    if (OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Exists(bidname)) {
        if (confirm("确定删除【" + afterBName + "】指标的绑定吗？")) {
            // 绑定
            $.ajax({
                type: "POST",
                url: contextRoot + "mark/update_bind.do",
                data: {
                    "id": id,
                },
                dataType: 'json',
                success: function (data) {
                    if (data.status == 200) {
                        // 获取下一个兄弟节点
                        var next = $(obj).parent().next();
                        var prev = $(obj).parent().prev();
                        $(obj).parent().css("display", "none");
                        $(next).css("display", "none");
                        $(prev).css("display", "block");

                        // 删除绑定
                        OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks.Item(bidname).Delete();
                        OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "删除绑定成功！");
                    }
                },
                error: function (data) {
                    OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "删除失败");
                }
            });
        }
    } else {
        if (defeat(id)) {
            // 获取下一个兄弟节点
            var next = $(obj).parent().next();
            var prev = $(obj).parent().prev();
            $(obj).parent().css("display", "none");
            $(next).css("display", "none");
            $(prev).css("display", "block");
            OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "删除失败，该指标未被绑定或绑定未保存,请重新绑定！", true);
        }
    }
}

/**
 * 定位指标
 * @param id
 * @param obj this
 * @param pno 包号
 * @param bname 绑定名称
 */
function local(id, obj, pno, bname) {
    bname = strReplace(bname);
    pno = strReplace(pno);
    var bidname = pno + "_" + bname;
    //判断标记是否存在
    if (OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Exists(bidname)) {
        //定位到书签内容
        OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Item(bidname).Select();
    } else {
        if (defeat(id)) {
            // 获取下一个兄弟节点
            var prev = $(obj).parent().prev();
            var prevFirst = $(obj).parent().prev().prev();
            $(obj).parent().css("display", "none");
            $(prev).css("display", "none");
            $(prevFirst).css("display", "block");
            OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "定位失败，该指标未被绑定或绑定未保存,请重新绑定！");
        }
    }
}

/**
 * 删除
 * @param id
 */
function defeat(id) {
    var flag = false;
    $.ajax({
        type: "POST",
        url: contextRoot + "mark/update_bind.do",
        async: false,
        data: {
            "id": id,
        },
        dataType: 'json',
        success: function (data) {
            if (data.status == 200) {
                flag = true;
            }
        },
        error: function (data) {
            OFFICE_CONTROL_OBJ.ShowTipMessage("提示", "删除数据操作失败");
        }
    });
    return flag;
}