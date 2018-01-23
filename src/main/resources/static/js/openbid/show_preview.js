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
        skip(4, projectId);
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
            // 进入最后一步
            $("#navNo").val(6);
            // 保存标识
            $("#flag").val(1);
        } else {
            $("#flag").val(0);
        }
        // 前端校验
        // 获取表单内容
        // 设置表单提交地址
        var projectId = $("#projectId").val();
        $.ajax({
            url: contextRoot + "project/finish.do",
            method: "post",
            dataType: "json",
            data: $("#myForm").serialize(),
            success: function (data) {
                layer.close(index);
                if (data.status == 200) {
                    if (flag == 'save') {
                        // 跳转页面到导航栏
                        window.location.href = contextRoot + "home/finish/" + projectId;
                    } else {
                        layer.confirm('暂存成功', {
                            btn: ['确定'] //按钮
                        }, function () {
                            window.location.reload();
                        });
                    }
                } else if(data.status == 400){
                    layer.alert(data.msg);
                }
            },
            error: function () {
                layer.alert("操作失败");
            }
        });
    }
}

/**
 * 下载
 * @param flag 1：开标一览表.doc
 *              1：开标一览表.pdf
 *              3：投标文档.doc
 *              4：投标文档.pdf
 * @param obj
 */
function downOpen(flag, obj) {
    // 初始化NTKO
    // OFFICE_CONTROL_OBJ = document.getElementById("TANGER_OCX");
    var fileName = $(obj).text();
    if (flag == 1) {
        // 下载开标一览表doc
        // 加载等待框
        loading = layer.load(1);
        var path = $("#makePricePath").val();
        path = encodeURIComponent(path);
        downLoadFile(path, fileName, "doc");
        layer.close(loading);
    }
    if (flag == 2) {
        // 下载开标一览表pdf
        var path = $("#makePricePath").val();
        path = encodeURIComponent(path);
        downLoadFile(path, fileName, "pdf");
    }

    if (flag == 3) {
        // 下载投标文档.doc
        var path = $("#filePath").val();
        path = encodeURIComponent(path);
        downLoadFile(path, fileName, "doc");
    }

    if (flag == 4) {
        // 下载投标文档.pdf
        var path = $("#filePath").val();
        path = encodeURIComponent(path);
        downLoadFile(path, fileName, "pdf");
    }
}

function downLoadFile(path, fileName, type) {
    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('method', 'post');
    if (type == 'doc') {
        form.attr('action', contextRoot + 'upload/readFile.do?filePath=' + path + '&fileName=' + fileName);
    } else {
        form.attr('action', contextRoot + 'download/down_load_pdf.do?filePath=' + path + '&fileName=' + fileName);
    }
    $('body').append(form);
    form.submit();
}


/**
 * 分包下载
 * @param packId
 * @param projectId
 * @param packageName
 */
function download_by_pack(packId, projectId, packageName) {
    packageName = encodeURIComponent(packageName);
    layer.open({
        type: 2, //page层
        area: ['210px', '30px'],
        title: '正在下载请稍等...',
        closeBtn: 0,
        shade: 0.01, //遮罩透明度
        moveType: 0, //拖拽风格，0是默认，1是传统拖动
        shift: 1, //0-6的动画形式，-1不开启
        shadeClose: true,
        content: contextRoot + 'download/download_by_ntko.html?packageId=' + packId + '&projectId=' + projectId + '&packageName=' + packageName
    });
}