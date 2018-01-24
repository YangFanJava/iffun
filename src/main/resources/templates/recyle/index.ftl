<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-手机选择</title>
    <!-- 引入 CSS -->
    <link media="all" href="/frozenui/css/frozen.css" rel="stylesheet">

    <!-- 引入 JS -->
    <script src="/frozenui/lib/zepto.min.js"></script>

    <!-- 特效组件需要另外引用 -->
    <script src="/frozenui/js/effect/cover.js"></script>
</head>
<body>





<div id="header">
    <ul class="ui-list ui-list-text ui-border-tb" >
        <li class="ui-border-t">
            <div class="ui-searchbar-wrap ui-border-b" style="width: 100%">
                <div class="ui-searchbar ui-border-radius">
                    <i class="ui-icon-search"></i>
                    <div class="ui-searchbar-text">搜索手机</div>
                    <div class="ui-searchbar-input"><input value="" type="tel" id="search" placeholder="请输入手机型号" autocapitalize="off"></div>
                    <i class="ui-icon-close"></i>
                </div>
                <button class="ui-searchbar-cancel">取消</button>
            </div>
        </li>
    </ul>
</div>


<div id="typebox">





</div>



<div id="seacchbox">
    <ul class="ui-list ui-list-text ui-border-tb" id="phone-list">

        <li class="ui-border-t">
            <div class="ui-list-info">
                <h4>标题标题标题标题标题标题标</h4>
            </div>
            <div class="ui-list-action">
                <img src="https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg" >
            </div>
        </li>
        <li class="ui-border-t">
            <div class="ui-list-info">
                <h4>标题标题标题标题标题标题标</h4>
            </div>
            <div class="ui-list-action">
                <img src="https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg" >
            </div>
        </li>
        <li class="ui-border-t">
            <div class="ui-list-info">
                <h4>标题标题标题标题标题标题标</h4>
            </div>
            <div class="ui-list-action">
                <img src="https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg" >
            </div>
        </li>
        <li class="ui-border-t">
            <div class="ui-list-info">
                <h4>标题标题标题标题标题标题标</h4>
            </div>
            <div class="ui-list-action">
                <img src="https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg" >
            </div>
        </li>
    </ul>
</div>

<!-- <script src="http://i.gtimg.cn/vipstyle/frozenjs/1.0.1/frozen.js?_bid=304"></script> -->
<script src="/frozenui/js/frozen.js"></script>
<script type="text/javascript">
    $('.ui-searchbar').tap(function(){
        $('.ui-searchbar-wrap').addClass('focus');
        $('.ui-searchbar-input input').focus();

//        $("#seacchbox").show(200);
    });
    $('.ui-searchbar-cancel').tap(function(){
        $('.ui-searchbar-wrap').removeClass('focus');
        showList(true);
//        $("#seacchbox").hide(100);
    });

    var lastSearchText = "";

    $('#search').on('input propertychange',function (e) {
                if (e.type === "input" || e.orignalEvent.propertyName === "value") {
                    if(this.value != lastSearchText){
                        lastSearchText = this.value;
                        showList();
                    }
                }
            })



    var hotPhone = [
        {
            "name":"小米6(6G/64G 移动定制版)",
            "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
        },
        {
            "name":"iphone 6s(6G/64G 移动定制版)",
            "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
        },
        {
            "name":"华为 mate10 6s(6G/64G 移动定制版)",
            "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
        },
    ]


    var el ;

    function showList(ishot) {
        el=$.tips({
            content:'温馨提示内容',
            stayTime:1000,
            type:"success"
        })
        el.on("tips:hide",function(){
            console.log("tips hide");
        })



        var phoneList = [];
        if($("#search").val() == ''||ishot){
            phoneList = hotPhone;
            flushData(phoneList);
        }else{
            phoneList = [
                {
                    "name":"cc 小米6(6G/64G 移动定制版)",
                    "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
                },
                {
                    "name":"cc iphone 6s(6G/64G 移动定制版)",
                    "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
                },
                {
                    "name":"cc 华为 mate10 6s(6G/64G 移动定制版)",
                    "img":"https://img12.360buyimg.com/n2/jfs/t13399/327/344341150/113696/7a6cb3b1/5a27a423Nc9f0bcea.jpg!q95.jpg"
                },
            ];
            flushData(phoneList);
//            $.ajax("")
        }
    }
    function flushData(phoneList) {
        var innerList = "";
        for( var i = 0,length = phoneList.length;i<length;i++){
            innerList +='<li class="ui-border-t"><div class="ui-list-info"><h4>'+phoneList[i].name+'</h4></div><div class="ui-list-action">'
                    +'<img src="'+phoneList[i].img+'" ></div></li>';
        }
        $("#phone-list").html(innerList);
    }

    showList();
    
</script>
</body>
</html>