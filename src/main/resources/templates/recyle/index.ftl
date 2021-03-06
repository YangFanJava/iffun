<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-手机选择</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/aui/aui-slide.css" />

    <style type="text/css">
        .aui-content-padded {
            padding: 0.75rem;
            background-color: #ffffff;
            margin-top: 0.75rem;
        }
        .aui-text-info {
            color: #009688 !important;
        }
        .aui-bar-nav.aui-bar-light .aui-iconfont {
            color: #009688;
        }
        .aui-bar-light {
            color: #009688;
        }
        .aui-text-danger {
            color: #009688 !important;
        }
    </style>
</head>
<body  >

<div class="aui-searchbar" id="search" style="    background-color: #f5f5f5;" >
    <div class="aui-searchbar-input aui-border-radius" style="margin: 0 0.8rem;"  >
        <i class="aui-iconfont aui-icon-search" ></i>
        <input type="search" placeholder="请输入搜索内容"  id="search-input">
        <div class="aui-searchbar-clear-btn">
            <i class="aui-iconfont aui-icon-close"></i>
        </div>
    </div>
    <div class="aui-searchbar-btn" tapmode>取消</div>
</div>
<header class="aui-bar aui-bar-nav aui-bar-light" id="returnDiv" style="display: none;">
    <a class="aui-pull-left aui-btn" href="javascript:location.reload();;">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title" >商品列表</div>
</header>

<section class="aui-content-padded"  id="bannerBox" style="padding: 0rem">
    <div id="banner">
        <div class="aui-slide-wrap" >
            <div class="aui-slide-node bg-dark">
                <img src="http://imgsrc.baidu.com/forum/pic/item/acaf2edda3cc7cd92649c2f93501213fb80e91ae.jpg" />
            </div>
            <div class="aui-slide-node bg-dark">
                <img src="http://imgsrc.baidu.com/forum/pic/item/acaf2edda3cc7cd92649c2f93501213fb80e91ae.jpg" />
            </div>
            <div class="aui-slide-node bg-dark">
                <img src="http://imgsrc.baidu.com/forum/pic/item/acaf2edda3cc7cd92649c2f93501213fb80e91ae.jpg" />
            </div>
        </div>
        <div class="aui-slide-page-wrap"><!--分页容器--></div>
    </div>
</section>





<section class="aui-content-padded aui-refresh-content" id="searchProduct" hidden>
<#--要搜索的内容为：<span class="aui-text-info" id="search-keywords"></span>-->


    <div class="aui-card-list">
        <div class="aui-card-list-header">
            <div>
                <i class="aui-iconfont aui-icon-mobile aui-text-danger"></i>
                <#--<span class="aui-text-danger">有关"<span style="color: red" id="search-keywords"></span>"的商品</span>-->
                <span class="aui-text-danger">有关"<span style="color: #009688" id="search-keywords"></span>"的商品</span>
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

<section class="aui-content-padded" style="    padding: 0.5rem 0.1rem 0rem;" >
    <div class="aui-card-list" id="searchProduct">
        <div class="aui-card-list-header">
            <div>
                <i class="aui-iconfont aui-icon-mobile aui-text-danger"></i>
                <span class="aui-text-danger">热门手机</span></div>
            <i class="aui-iconfont aui-icon-more"></i>
        </div>
        <div class="aui-card-list-content">
            <ul class="aui-list aui-media-list" >
                <#list hot as hotPhone>
                    <#list hotPhone.prices as price >
                        <li class="aui-list-item aui-list-item-middle">
                            <div class="aui-media-list-item-inner">
                                <div class="aui-list-item-media" style="width: 3rem;">
                                    <input name="priceId" hidden value="${price.id}" >
                                    <#if price.image?default("")?trim?length gt 1>
                                        <img src="${price.image}" >
                                    <#elseif hotPhone.iamges?default("")?trim?length gt 1>
                                        <#list hotPhone.iamges?split(",") as name>
                                            <#if name_index == 0 >
                                                <img src="${name}" >
                                            </#if>
                                        </#list>
                                    <#else>
                                        <img src="${defaultImage}">
                                    </#if>
                                </div>
                                <div class="aui-list-item-inner aui-list-item-arrow">
                                    <div class="aui-list-item-text">
                                        <input name="priceId" hidden value="${price.id}" >
                                        <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1 " style="width: 60%">${price.version}</div>
                                        <div class="aui-list-item-right">已回收100</div>
                                    </div>
                                    <div class="aui-list-item-text">
                                        最高回收价格 ${price.recoverPrice}
                                    </div>
                                </div>
                            </div>
                        </li>
                    </#list>
                </#list>
            </ul>
        </div>
        <div class="aui-card-list-footer aui-text-center">
            <p  onclick="getMorePhone">
                查看更多
            </p>
        </div>
    </div>
</section>

<section class="aui-content-padded"  style="     padding: 0.5rem 0.1rem 0rem;">

    <div class="aui-card-list" id="searchProduct">
        <div class="aui-card-list-header">
            <div>
                <i class="aui-iconfont aui-icon-comment aui-text-danger"></i>
                <span class="aui-text-danger">最新评论</span></div>
            <i class="aui-iconfont aui-icon-more"></i>
        </div>
        <div class="aui-card-list-content "  id="aui-slide2">
            <div class="aui-slide-wrap">
                <#list comments as com>
                    <div class="aui-slide-node aui-slide-node-middle aui-slide-node-center">
                    <div class="aui-card-list" style="    width: 100%;
                                                                height: 100%;
                                                                margin: 0px;
                                                                padding: 0px;">
                        <div class="aui-card-list-header aui-card-list-user aui-border-b">
                            <div class="aui-card-list-user-avatar">
                                <img src="http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJmSEccyuUB9DxNMia4U8C7QQia8ebl6Qt3tXj6ibWMf4hWrJYhkKkVHBNHhpq453QQRJ0B4mtmMHOKQ/132" class="aui-img-round" />
                            </div>
                            <div class="aui-card-list-user-name">
                                <div>${com.userName?substring(0,1)}***</div>
                                <small>${com.createtime?string("yyyy-MM-dd HH:mm:ss")}</small>
                            </div>
                            <div class="aui-card-list-user-info">${com.userAddress}</div>
                        </div>
                        <div class="aui-card-list-content-padded" style="    height: 150px;">
                            ${com.text}
                        </div>
                        <div class="aui-card-list-footer aui-row-padded" style="     position: absolute;  width: 100%;   bottom: 0.3rem;">
                            <div class="aui-col-xs-8">
                                通过
                            ${com.recyleType}
                                回收
                            </div>
                            <div class="aui-col-xs-4">
                                <img style="height: 1.0rem;width: 0.9rem;display: inline;vertical-align: middle;" src="${com.productImage}">
                                ${com.productName}
                            </div>
                        </div>
                    </div>
                </div>
                </#list>
            </div>
        </div>
    </div>
</section>

</body>
<script type="text/javascript" src="/js/aui/api.js" ></script>
<script type="text/javascript" src="/js/aui/aui-slide.js"></script>
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
                    //隐藏搜索框  显示返回页
                    $("#search").hide();
                    $("#returnDiv").show();
                    $("#bannerBox").hide();


                    if(r.code == '0'){
                        var defaultImage = '${defaultImage}';
                        toast.hide();
                        var text = "";
                        $("#search-keywords").html(keywords);
                        $.each(r.list,function(i,product){
                            $.each(product.prices,function(j,price){
                                text += '<li class="aui-list-item aui-list-item-middle"><div class="aui-media-list-item-inner"><div class="aui-list-item-media" style="width: 3rem;">';
                                text += '<input name="priceId" hidden value="'+price.id+'" >'
                                text += '<img src="'+(price.image?price.image:(product.images?product.images.split(",")[0]:defaultImage)) + '" ></div><div class="aui-list-item-inner aui-list-item-arrow"><div class="aui-list-item-text">';
                                text += '<div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1" style="width: 60%">'+price.version+'</div>';
//                                +(price.version.length>9?(price.version.slice(0,9)+'...'):price.version)
                                text += '<div class="aui-list-item-right">已回收100</div>';
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



    var slide3 = new auiSlide({
        container:document.getElementById("banner"),
        // "width":300,
        "height":180,
        "speed":500,
        "autoPlay": 3000, //自动播放
        "loop":true,
        "pageShow":true,
        "pageStyle":'line',
        'dotPosition':'center'
    })

    var slide2 = new auiSlide({
        container:document.getElementById("aui-slide2"),
        // "width":300,
        "height":240,
        "speed":300,
        "autoPlay": 0, //自动播放
        "pageShow":false,
        "loop":true,
        "pageStyle":'dot',
        'dotPosition':'center'
    })

</script>