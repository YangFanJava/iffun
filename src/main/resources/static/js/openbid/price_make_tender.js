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
        skip(2, projectId);
    },
    /**
     * 保存和暂存
     * @param flag
     */
    save: function (flag) {
        if (flag == 'save') {
            // 进入第四步
            $("#navNo").val(4);
            // 保存标识
            $("#flag").val(1);
        } else {
            $("#flag").val(0);
        }

        // 保存文件
        saveFile(flag);
    }
}