/**
 * 跳转页面
 * @param navNo
 * @param projectId
 */
function skip(navNo, projectId, navFlag) {
    // 点击导航校验
    if (navFlag == 0 && $("#navNo").val() < navNo) {
        layer.msg("请先完成前一项进行下一步操作");
        return;
    }
    var index = layer.load(0, {
        shade: [0.1, '#fff'],
        offset: ['40%', '50%']
    });
    var destUrl;
    if (navNo == 1) {
        destUrl = "home/show/";
    }
    if (navNo == 2) {
        destUrl = "home/price/";
    }
    if (navNo == 3) {
        destUrl = "home/make_tender/";
    }
    if (navNo == 4) {
        destUrl = "home/bind_tender/";
    }
    if (navNo == 5) {
        destUrl = "home/show_preview/";
    }
    if (navNo == 6) {
        destUrl = "home/finish/";
    }

    $.ajax({
        url: contextRoot + "project/finish.do",
        method: "post",
        dataType: "json",
        data: {
            "id": projectId,
            "navNo": navNo
        },
        success: function (data) {
            if (data.status == 200) {
                layer.close(index);
                // 跳转页面
                window.location.href = contextRoot + destUrl + projectId;
            }
        },
        error: function () {
            layer.close(index);
            layer.alert("操作失败");
        }
    });

}