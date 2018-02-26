<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-订单详情</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">
    <link media="all" href="/css/date/mobiscroll.custom-2.17.0.min.css" rel="stylesheet">

</head>
<body  >
<header class="aui-bar aui-bar-nav" style="background-color: white;color: #008B8B">
    <a class="aui-pull-left aui-btn" style="color: #008B8B;" href="/weixin/recyle/estimat">
        <span class="aui-iconfont aui-icon-left"  style="color: #008B8B;"></span>&nbsp;
<#--<header class="aui-bar aui-bar-nav" style="background-color: white;color: black">-->
    <#--<a class="aui-pull-left aui-btn" style="color: black;" href="javascript:location.reload();">-->
        <#--<span class="aui-iconfont aui-icon-left"  style="color: black;"></span>&nbsp;-->

        <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1">
            诚信回收-订单详情
        </div>
    </a>
</header>


<div class="aui-card-list"></div>


<div class="aui-card-list">
    <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-media" style="width: 3rem;">
                        <#if info.price.image?default("")?trim?length gt 1>
                            <img src="${price.image}" >
                        <#elseif info.product.iamges?default("")?trim?length gt 1>
                            <#list info.product.iamges?split(",") as name>
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
                            <input name="priceId" hidden value="${info.price.id}" >
                            <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1 " style="width: 60%">${info.price.version}</div>
                            <#--<div class="aui-list-item-right">已回收100</div>-->
                        </div>
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-text">订单状态:已创建未回收 </div>
                            <div class="aui-list-item-text">创建时间: 2018-12-12 12-09-12 </div>
                        </div>
                    </div>
                </div>
            </li>
    </ul>
</div>



</body>
<script type="text/javascript" src="/js/aui/api.js" ></script>
<script type="text/javascript" src="/js/aui/aui-toast.js" ></script>
<script type="text/javascript" src="/js/aui/aui-dialog.js" ></script>
<!-- 引入 JS -->
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/date/mobiscroll.custom-2.17.0.min.js" ></script>
<script type="text/javascript">
    apiready = function(){
        api.parseTapmode();
    }
</script>