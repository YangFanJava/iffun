<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-手机选择</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">

    <style type="text/css">
        .aui-content-padded {
            padding: 0.75rem;
            background-color: #ffffff;
            margin-top: 0.75rem;
        }
    </style>
</head>
<body  >

<div class="aui-searchbar" id="search">
    <div class="aui-searchbar-input aui-border-radius">
        <i class="aui-iconfont aui-icon-search"></i>
        <input type="search" placeholder="请输入搜索内容" id="search-input">
        <div class="aui-searchbar-clear-btn">
            <i class="aui-iconfont aui-icon-close"></i>
        </div>
    </div>
    <div class="aui-searchbar-btn" tapmode>取消</div>
</div>


<section class="aui-content-padded aui-refresh-content" id="searchProduct" hidden>
<#--要搜索的内容为：<span class="aui-text-info" id="search-keywords"></span>-->


    <div class="aui-card-list">
        <div class="aui-card-list-header">
            <div>
                <i class="aui-iconfont aui-icon-mobile aui-text-danger"></i>
                <span class="aui-text-danger">有关"<span style="color: red" id="search-keywords"></span>"的商品</span>
            </div>
            <i class="aui-iconfont aui-icon-more"></i>
        </div>
        <div class="aui-card-list-content">
            <ul class="aui-list aui-media-list" id="searchResultBox">
            </ul>
        </div>
        <#--<div class="aui-card-list-footer aui-text-center">-->
            <#--查看更多-->
        <#--</div>-->
    </div>
</section>

<section class="aui-content-padded" >
    <div class="aui-card-list" id="searchProduct">
        <div class="aui-card-list-header">
            <div>
                <i class="aui-iconfont aui-icon-mobile aui-text-danger"></i>
                <span class="aui-text-danger">热门手机</span></div>
            <i class="aui-iconfont aui-icon-more"></i>
        </div>
        <div class="aui-card-list-content">
            <ul class="aui-list aui-media-list" >
                <li class="aui-list-item aui-list-item-middle">
                    <div class="aui-media-list-item-inner">
                        <div class="aui-list-item-media" style="width: 3rem;">
                            <img src="http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg" >
                        </div>
                        <div class="aui-list-item-inner aui-list-item-arrow">
                            <div class="aui-list-item-text">
                                <div class="aui-list-item-title aui-font-size-14">AUI</div>
                                <div class="aui-list-item-right">08:00</div>
                            </div>
                            <div class="aui-list-item-text">
                                www.auicss.com
                            </div>
                        </div>
                    </div>
                </li>
                <li class="aui-list-item aui-list-item-middle">
                    <div class="aui-media-list-item-inner">
                        <div class="aui-list-item-media" style="width: 3rem;">
                            <img src="http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg" >
                        </div>
                        <div class="aui-list-item-inner aui-list-item-arrow">
                            iphoneX
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="aui-card-list-footer aui-text-center">
            查看更多
        </div>
    </div>
</section>
</body>
<script type="text/javascript" src="/js/aui/api.js" ></script>
<script type="text/javascript" src="/js/aui/aui-toast.js" ></script>
<!-- 引入 JS -->
<script src="/js/jquery.min.js"></script>
<script type="text/javascript">
    apiready = function(){
        api.parseTapmode();
    }
    var toast = new auiToast({
    })
    var searchBar = document.querySelector(".aui-searchbar");
    var searchBarInput = document.querySelector(".aui-searchbar input");
    var searchBarBtn = document.querySelector(".aui-searchbar .aui-searchbar-btn");
    var searchBarClearBtn = document.querySelector(".aui-searchbar .aui-searchbar-clear-btn");
    if(searchBar){
        searchBarInput.onclick = function(){
            searchBarBtn.style.marginRight = 0;
        }
        searchBarInput.oninput = function(){
            if(this.value.length){
                searchBarClearBtn.style.display = 'block';
                searchBarBtn.classList.add("aui-text-info");
                searchBarBtn.textContent = "搜索";
            }else{
                searchBarClearBtn.style.display = 'none';
                searchBarBtn.classList.remove("aui-text-info");
                searchBarBtn.textContent = "取消";
            }
        }
    }
    searchBarClearBtn.onclick = function(){
        this.style.display = 'none';
        searchBarInput.value = '';
        searchBarBtn.classList.remove("aui-text-info");
        searchBarBtn.textContent = "取消";
    }

    searchBarBtn.onclick = function(){
        var keywords = searchBarInput.value;
        console.log(keywords);
        if(keywords.length){
            searchBarInput.blur();
            toast.loading({
                title:"获取数据中...",
                duration:2000
            },function(ret){
                $.post("/weixin/phone/byName",{ "keyword":keywords },function (r) {
                    if(r.code == '0'){
                        var defaultImage = 'http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg';
                        toast.hide();
                        var text = "";
                        $("#search-keywords").html(keywords);
                        $.each(r.list,function(i,product){
                            $.each(product.prices,function(j,price){
                                text += '<li class="aui-list-item aui-list-item-middle"><div class="aui-media-list-item-inner"><div class="aui-list-item-media" style="width: 3rem;">';
                                text += '<input name="priceId" hidden value="'+price.id+'" >'
                                text += '<img src="'+(price.image?price.image:(product.images?product.images.split(",")[0]:defaultImage)) + '" ></div><div class="aui-list-item-inner aui-list-item-arrow"><div class="aui-list-item-text">';
                                text += '<div class="aui-list-item-title aui-font-size-14">'+(price.version.length>9?(price.version.slice(0,9)+'...'):price.version)+'</div>';
                                text += '<div class="aui-list-item-right">已回收：100</div>';
                                text += '</div><div class="aui-list-item-text">最高回收价格'+price.recoverPrice+'</div></div></div></li>';
                            })
                        });
                        if(text  ==  ''){
                            text = '    <li style="color: #7e7975;font-family:&quot;宋体&quot;;font-size:11px;">很抱歉，暂时没有发现“'+keywords+'”的产品。。</li>' +
                                    '<li style="color: #7e7975;font-family: &quot;宋体&quot;;font-size: 11px;">请检查关键字或者联系我们的工作人员进行线下交流哦。</li>'+
                                            '<li style="color: #7e7975;font-family: &quot;宋体&quot;;font-size: 11px;">联系方式:135912321321</li>' +
                                    '<li style="color: #7e7975;font-family: &quot;宋体&quot;; font-size: 11px; ">门店地址:xx路xx号xxxx手机专卖店</li>';
                        }
                        $("#searchResultBox").html(text);

                        $("#searchProduct").show();
                        //重新绑定事件
                        initLiBindEvent();
                    }else{
                        toast.hide();
                    }
                })
            });
            //第一次查询  填充搜索列表并显示 。
            //TODO 显示等待页面

        }else{
            this.style.marginRight = "-"+this.offsetWidth+"px";
            searchBarInput.value = '';
            searchBarInput.blur();
        }
    }


    function initLiBindEvent() {
        $("li").click(function () {
            var priceId =  $(this).find("input[name='priceId']").val();
            location.href = "/weixin/recyle/estimate?priceId="+priceId;
        });
    }


    initLiBindEvent();


</script>