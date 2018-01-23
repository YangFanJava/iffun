/**
 * 加载list
 */
$(function () {
    $("#handleSupOpinion").click(function () {
       list();
    });
})
function list(){
    var index = layer.load(0, {
        shade : [ 0.1, '#fff' ],
        offset : [ '40%', '50%' ]
    });
    $.ajax({
        url: "/opinionlist/insert",
        type: "post",
        dataTYpe: "json",
        success: function(res){
            var data = res.data;
            $("#total").html(data.total);
            loadOldList(data.list);
            layer.close(index);
        }
    });
}

/**
* 加载数据
*/
function loadList1(data){
    // 将原先的内容清空
    $("#cateId").empty();
    if(data != null && data.length > 0){
        for(var i = 0; i < data.length; i++){
            loadData1(data[i]);
        }
    }
}
function loadListExp(data){
    // 将原先的内容清空
    $("#cateId").empty();
    if(data != null && data.length > 0){
        for(var i = 0; i < data.length; i++){
            loadDataExp(data[i]);
        }
    }
}

function loadDataExp(data){
    var html = "<tr> "
        + "  <td>"+data.id+"</td>"
        + "  <td>"+data.relName+"</td>"
        + "  <td>"+data.status+"</td>"
    html += "</tr>";
    $("#cateId").append(html);
}
function loadData1(data){
    var html = "<tr> "
        + "  <td>"+data.id+"</td>"
        + "  <td>"+data.supplierName+"</td>"
        + "  <td>"+data.status+"</td>"
    html += "</tr>";
    $("#cateId").append(html);
}

function loadOldList(data){
    // 将原先的内容清空
    $("#supId").empty();
    if(data != null && data.length > 0){
        for(var i = 0; i < data.length; i++){
            loadOldListList(data[i]);
        }
    }
}
function loadOldListList(data){
    var html = "<tr> "
        + "  <td>"+data.id+"</td>"
        + "  <td>"+data.supplierName+"</td>"
        + "  <td>"+data.opinion+"</td>"
    html += "</tr>";
    $("#supId").append(html);
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
function loadPage(pages,total,start,end, current){
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
        jump: function(e, first){
            if(!first){
                list(e.curr);
            }
        }
    });
}

/**
 * 加载数据
 */
function loadList(data){
    // 将原先的内容清空
    $("#cateId").empty();
    if(data != null && data.length > 0){
        for(var i = 0; i < data.length; i++){
            loadData(data[i]);
        }
    }
}

/**
 * 查询方法
 */
function query(){
    list(1);
}

/**
 * 重置按钮
 */
function resetAll(){
    list(1);
}

/**
 * 新增加载数据
 * @param data
 * @returns
 */
function loadData(data){
    var html = "<tr> "
        + "  <td>"+data.id+"</td>"
        + "  <td>"+data.name+"</td>"
        + "  <td>"+data.parentId+"</td>"
    html += "</tr>";
    $("#cateId").append(html);
}

/**
 * 时间戳转时间格式
 * @param format
 * @param timestamp
 * @returns
 */
function timestampToDate(format, timestamp){
    var date = new Date(timestamp);
    return date.format(format);
}

/**
 * 时间格式化
 * @param format
 * @returns
 */
Date.prototype.format = function(fmt){
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt)) {
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}