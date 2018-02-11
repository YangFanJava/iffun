<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-订单</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">

    <style type="text/css">
        .aui-card-list-header{
            border-bottom: 0.1rem solid #F5F5F5;
        }
        .aui-list label {
            font-size: 14px;
        }
    </style>
</head>
<body  >
<header class="aui-bar aui-bar-nav" style="background-color: white;color: black">
    <a class="aui-pull-left aui-btn" style="color: black;" href="javascript:location.reload();">
        <span class="aui-iconfont aui-icon-left"  style="color: black;"></span>&nbsp;
        <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1">
            <#list product.prices as price>
                "
                <#if price.version?length gt 20>
                ${price.version?substring(0,17)}...
                <#else>
                ${price.version}
                </#if>
                "
                的估价
            </#list>
        </div>
    </a>
</header>
<header class="aui-bar-light aui-row" style="border-bottom: 1rem solid #f5f5f5">
    <div>
        <span style="color: #D5D5D5;">&nbsp;&nbsp;&nbsp;回收价格:</span><span style="float:right;color: gray;">xxxxx手机</span>
    </div>

    <div style="font-size: 3rem;color: black;" class="aui-col-xs-10">
        <span> ￥</span><span>505</span>
        <span style="font-size: 1rem;">.00</span>
    </div>

    <div style="" class="aui-col-xs-2">
    <span style="">
        <p><div class="aui-btn aui-btn-block aui-btn-sm" style="font-size: 0.1rem;height: 1rem;line-height: 1rem;    border-radius: 0.1rem;padding: 0px;right: 0.3rem;top: 2.5rem;color: black;">重新估价</div></p>
    </span>
    </div>
</header>


<section class="aui-content-padded aui-refresh-content" >
    <div class="aui-bar aui-bar-btn" style="width:80%;">
        <div class="aui-bar-btn-item aui-active">Item</div>
        <div class="aui-bar-btn-item">Item</div>
        <div class="aui-bar-btn-item">Item</div>
    </div>
</section>


<form id="qa">
    <div class="aui-card-list" >
        <div class="aui-card-list-header">
            xxxxx
        </div>
        <div class="aui-card-list-content">
            <ul class="aui-list aui-select-list">
                <li class="aui-list-item answer-box" style="line-height: 44px">
                    xxxxxx
                </li>
                <li class="aui-list-item answer-box">
                    <div class="aui-list-item-input" style="line-height: 44px">
                        <label>
                            xxxxxx
                        </label>
                    </div>
                </li>
            </ul>
        </div>
        <#--<div class="aui-card-list-footer aui-text-center">-->
            <#--底部-->
        <#--</div>-->
    </div>
</form>


<div  class="aui-card-list">
    <div class="aui-card-list-content">
        <p><div class="aui-btn aui-btn-info aui-btn-block aui-btn-outlined" id="submitbtn" >提交</div></p>
    </div>
</div>

<div >




</div>


</body>
<script type="text/javascript" src="/js/aui/api.js" ></script>
<script type="text/javascript" src="/js/aui/aui-toast.js" ></script>
<script type="text/javascript" src="/js/aui/aui-dialog.js" ></script>
<!-- 引入 JS -->
<script src="/js/jquery.min.js"></script>
<script type="text/javascript">
    apiready = function(){
        api.parseTapmode();
    }
    var dialog = new auiDialog({})
    $(function () {
    })


</script>