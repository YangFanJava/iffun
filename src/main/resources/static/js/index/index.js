$(function () {
    // 加载导入项目列表
    list(1);
    /**
     * 导入采购文件点击事件
     */
    $("#importPurchaseFile").click(function () {
        var index = layer.load(0, {
            shade: [0.1, '#fff'],
            offset: ['40%', '50%']
        });
        $.ajaxFileUpload({
            method: "POST",
            // url:ctx + path, //需要链接到服务器地址
            url: contextRoot + 'upload/handle.do',
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'fileWord', // 文件选择框的id属性
            dataType: 'json',//返回值类型 一般设置为json
            /*data: {
             "questionId": strquestionId,
             "studentId": strstudentId,
             "teachClassId": strteachClassId,
             "answerName": stranswerName
             },*/
            success: function (data) { //服务器成功响应处理函数
                layer.close(index);
            }
        });
    });
});
var index;
var packageOpt = {
    // 弹出框点击确定按钮时触发
    confirmSelect: function () {
        if ($(':checkbox[name="name"]:checked').size() == 0) {
            parent.layer.msg("请选择要参与的包！");
            return parent.layer;
        }
        // 获取选择的包
        var chk_name = '';
        $('input[name="name"]:checked').each(function () {
            chk_name += $(this).next('span').text() + "、";
        });
        if (chk_name) {
            chk_name = chk_name.substring(0, chk_name.length - 1);
        }
        var html = "<div>"
            + '<ul class="list-unstyled">'
            + '<li class="mt10 col-md-12 col-sm-12 col-xs-12 pl15">'
            + "<label class='col-md-12 col-sm-12 col-xs-12 padding-left-5'>提示：当前您选择的包为：<span>" + chk_name + "</span></label>"
            + '</li>'
            + '<div class="tc mt10 col-md-12 col-sm-12 col-xs-12">'
            + '<button class="btn mb20" type="button" onclick=\"packageOpt.tipConfirmSelect()\">确定</button>'
            + '<button class="btn mb20" type="button" onclick=\"packageOpt.tipCancleSelect()\">取消</button>'
            + '</div>'
            + '</ul>'
            + '</div>'
        index = parent.layer.open({
            type: 1, //页面层
            area: ['300px', '180px'], //宽高
            title: '提示',
            closeBtn: 0,
            shade: 0.01, //遮罩透明度
            moveType: 0, //拖拽风格，0是默认，1是传统拖动
            shift: 1, //0-6的动画形式，-1不开启
            offset: '160px',
            shadeClose: false,
            content: html,
        });
    },

    // 提示弹出框点击确定按钮时触发
    tipConfirmSelect: function () {
        var index = layer.load(0, {
            shade: [0.1, '#fff'],
            offset: ['40%', '50%']
        });
        // 设置表单提交地址
        $.ajax({
            url: contextRoot + "project/save.do",
            method: "post",
            dataType: "json",
            data: $("#packagesForm").serialize(),
            success: function (data) {
                if (data.status == 200) {
                    layer.close(index);
                    // 跳转页面到导航栏
                    window.location.href = contextRoot + "home/show/" + data.data;
                }
            },
            error: function () {
                layer.alert("操作失败");
            }
        });

    },

    // 提示弹出框点击取消按钮时触发
    tipCancleSelect: function () {
        layer.close(index);
    },

    // 弹出框点击取消按钮时触发
    cancleSelect: function (projectId) {
        // 操作后台删除其操作
        $.ajax({
            url: contextRoot + "project/delete/" + projectId,
            method: "get",
            dataType: "json",
            success: function (data) {
                if (data.status == 200) {
                    layer.closeAll('page');
                    // 调用页面列表回显
                    list();
                } else {
                    layer.alert("操作失败");
                }
            }
        });
    }
};

/**
 * 加载list
 */
function list(curr) {
    var index = layer.load(0, {
        shade: [0.1, '#fff'],
        offset: ['40%', '50%']
    });
    var name = $("#name").val();
    var projectNumber = $("#projectNumber").val();
    $.ajax({
        url: contextRoot + "index/list.do",
        type: "post",
        data: {
            "page": curr,
            "name": name,
            "projectNumber": projectNumber
        },
        dataTYpe: "json",
        success: function (res) {
            if (res.status == 200) {
                var obj = res.data;
                loadList(obj.list, obj.pageNum, obj.pageSize);
                loadPage(obj.pages, obj.total, obj.startRow, obj.endRow, curr);
            }
            layer.close(index);
        }
    });
}

/**
 * 分页
 * @param pages
 * @param total
 * @param start
 * @param end
 * @param current
 * @returns
 */
function loadPage(pages, total, start, end, current) {
    laypage({
        cont: $("#pagediv"),
        pages: pages,
        skin: '#2c9fA6',
        skip: true,
        total: total,
        startRow: start,
        endRow: end,
        groups: pages >= 5 ? 5 : pages,
        curr: current,
        jump: function (e, first) {
            if (!first) {
                list(e.curr);
            }
        }
    });
}

/**
 * 加载数据
 */
function loadList(data, pageNum, pageSize) {
    // 将原先的内容清空
    $("#tbody_id").empty();
    if (data != null && data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            loadData(data[i], i, pageNum, pageSize);
        }
    }
}

/**
 * 查询方法
 */
function queryByCond() {
    list(1);
}

/**
 * 重置按钮
 */
function resetAll() {
    $("#name").val("");
    $("#projectNumber").val("");
    list(1);
}

/**
 * 新增加载数据
 * @param data
 * @returns
 */
function loadData(data, index, pageNum, pageSize) {
    var html = "<tr> "
        + "  <td class='tc'>" + ((index + 1) + (pageNum - 1) * pageSize) + "</td>"
        + "  <td><a href=\"javascript:;\" onclick=\"loadProject('" + data.id + "')\">" + data.name + "</a></td>"
        + "  <td>" + data.projectNumber + "</td>"
        + "  <td>" + timestampToDate('yyyy-MM-dd hh:mm:ss', data.modifyTime) + "</td>"
    html += "</tr>";
    $("#tbody_id").append(html);
}

/**
 * 时间戳转时间格式
 * @param format
 * @param timestamp
 * @returns
 */
function timestampToDate(format, timestamp) {
    var date = new Date(timestamp);
    return date.format(format);
}

/**
 * 时间格式化
 * @param format
 * @returns
 */
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

function step() {
    window.location.href = contextRoot + "openbidlist.html";
}

/**
 * 加载项目信息
 * @param id
 */
function loadProject(id) {
    window.location.href = contextRoot + "home/show/" + id;
}