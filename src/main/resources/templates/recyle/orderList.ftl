<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-订单</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">
    <link media="all" href="/css/date/mobiscroll.custom-2.17.0.min.css" rel="stylesheet">

</head>
<body  >
<header class="aui-bar aui-bar-nav" style="background-color: white;color: #008B8B">
    <a class="aui-pull-left aui-btn" style="color: #008B8B;" href="/weixin/user/index">
        <span class="aui-iconfont aui-icon-left"  style="color: #008B8B;"></span>&nbsp;
<#--<header class="aui-bar aui-bar-nav" style="background-color: white;color: black">-->
    <#--<a class="aui-pull-left aui-btn" style="color: black;" href="javascript:location.reload();">-->
        <#--<span class="aui-iconfont aui-icon-left"  style="color: black;"></span>&nbsp;-->

        <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1">
            诚信回收-我的订单
        </div>
    </a>
</header>


<div class="aui-card-list"></div>


<#if orders??  >
    <#list orders as order >
    <div class="aui-card-list">
        <div class="aui-card-list-header">
            订单号:${order.id}
            <div class="aui-list-item-right">
                <#switch order.recyleState>
                    <#case "1">
                        订单提交，等待店家处理
                        <#break>
                    <#case "5">
                        回收中
                        <#break>
                    <#case "6">
                        回收结束,等待店家付款
                        <#break>
                    <#case "7">
                        店家已打款,订单结束
                        <#break>
                    <#default>
                </#switch>
            </div>
        </div>
        <div class="aui-card-list-content-padded">
            <div class="aui-row aui-row-padded">
                <div class="aui-col-xs-4" style="text-align: center;">
                    <img style="width: 100%;max-width: 150px;margin: 0 auto;" src="http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg">
                </div>
                <div class="aui-col-xs-8">
                    <div class="aui-col-xs-12">回收方式:

                        <#if order.recyleType == "0">
                            店铺回收
                        <#elseif order.recyleType =="1">
                            快递回收
                        <#elseif order.recyleType == "2">
                            上门回收
                        </#if>

                    </div>

                    <div class="aui-col-xs-12 aui-ellipsis-1 ">估价金额:

                        <#if order.isAuditing == '1' >
                            ${order.auditingPrice}(商家评估价格)
                        <#else >
                            ${order.estimatePriceUser}(用户评估价格)
                        </#if>

                    </div>
                    <div class="aui-col-xs-12">联系人: ${order.userName} </div>
                    <div class="aui-col-xs-12 aui-ellipsis-1 ">联系方式: ${order.userPhone} </div>


                </div>
            </div>
        </div>
        <div class="aui-card-list-footer" style="width: 100%">
            &nbsp;
            <#--<div class="aui-list-item-right">-->
                <#--<p><div class="aui-btn">查看详情</div></p>-->
            <#--</div>-->
            <div class="aui-list-item-right">

                <p><div class="aui-btn seeInfo"  data-id="${order.id}">查看详情</div>
                &nbsp;<div class="aui-btn">联系客服</div></p>
            </div>
        </div>
    </div>
    </#list>
</#if>


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

    $(function () {
        $(".seeInfo").click(function () {
            location.href = "/weixin/order/toInfo?oid="+$(this).data("id");
        })
    })

</script>