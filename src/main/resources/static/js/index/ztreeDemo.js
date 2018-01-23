var zTreeObj;
var setting = {
    isSimpleData : true,              //数据是否采用简单 Array 格式，默认false
    treeNodeKey : "id",               //在isSimpleData格式下，当前节点id属性
    treeNodeParentKey : "pId",        //在isSimpleData格式下，当前节点的父节点id属性
    showLine : true,                  //是否显示节点间的连线
    checked : true                  //每个节点上是否显示 CheckBox
};

var treeNodes = [
    {
        name: "凤姐", //节点名称
        open: false,  //节点是否可以展开 凤姐家的门是开着的吗？
        isParent:true //凤姐有可能会是一个母亲吗？ 是否为文件夹
    },
    {
        name: "凤姐他妈",
        open: false,
        id: 1,             //自定义的，可有可无  编号
        url:"sdfsldfsdf",  //自定义的，可有可无  他妈家的地址，老家的地址 点一下就去老家了。
        children: [       //自定义的，可有可无  他妈的儿孙些  为什么没有他呢？
            {
                name: "凤姐他弟"
            },
            {
                name: "凤姐他妹",
                children: [{
                    name:"凤姐他妹的儿子"
                }]
            }
        ]
    }

];
$(document).ready(function () {
    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes); //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
});

var treeFunction = new Object({
    editFunction : function () {
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getSelectedNodes();
        for (var i = 0; i < nodes.length; i++){
            treeObj.editName(nodes[i]);
        }
    },

    addFunction : function(){

    }
});