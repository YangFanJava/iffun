var zTreeObj;
var setting = {
    async : {
        enable : true,
        dataType:"json",
        url : contextRoot + "/ztree/category",
        type:"get",
        autoParam : ["id"]
    },
    data :{
        simpleData : {
            enable : true,
            idKey : "id",// 结点的id,对应到Json中的id
            pIdKey : "pId",// 结点的pId,对应到Json中的parentId
            rootPId : 0, // 根节点设置为0
        },
        key : {
            name : "nodeName", // 节点显示name属性，对应Json中的rootName
        }
    },
    view : {
        selectedMulti : true
        //addHoverDom : addHoverDom, // 用于当鼠标移动到节点上时，显示用户自定义控件。务必与 setting.view.removeHoverDom 同时使用
        //removeHoverDom : removeHoverDom,// 用于当鼠标移出节点时，隐藏用户自定义控件。务必与 addHoverDom 同时使用
        //dblClickExpand : false,
    },
     /*edit : {
     enable : true,
     editNameSelectAll : true, // 节点编辑名称 input 初次显示时,设置 txt 内容是否为全选状态。
     removeTitle : "删除", // 删除按钮的 Title 辅助信息
     renameTitle : "重命名" // 编辑名称按钮的 Title 辅助信息
     },*/
    callback : {
        //beforeEditName : beforeEditName,// 用于捕获节点编辑按钮的 click 事件，并且根据返回值确定是否允许进入名称编辑状态
        // beforeRemove : beforeRemove,// 用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
        // beforeRename : beforeRename, // 用于捕获节点编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新节点名称数据之前的事件回调函数，
        // 并且根据返回值确定是否允许更改名称的操作
        onCheck : onCheck // 点击节点时，显示节点详细信息
    },
    check : {
        enable : true,
        chkStyle : "checkbox",
    }
};
$(function(){
    $.fn.zTree.init($("#treeDemo"), setting);
});

function onCheck() {
    alert();
}
