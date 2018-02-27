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



<div class="aui-card-list">
    <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-media" style="width: 3rem;">
                        <#if info.price.image?default("")?trim?length gt 1>
                            <img src="${info.price.image}"  style="margin: 10px 0px;" >
                        <#elseif info.product.iamges?default("")?trim?length gt 1>
                            <#list info.product.iamges?split(",") as name>
                                <#if name_index == 0 >
                                    <img src="${name}" style="margin: 10px 0px;" >
                                </#if>
                            </#list>
                        <#else>
                            <img src="${defaultImage}"  style="margin: 10px 0px;">
                        </#if>
                    </div>
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <input name="priceId" hidden value="${info.price.id}" >
                            <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1 " style="width: 60%">${info.price.version}</div>
                            <#--<div class="aui-list-item-right">已回收100</div>-->
                        </div>
                        <div class="aui-list-item-text">订单状态:
                            <#switch info.recyleState>
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
                        <div class="aui-list-item-text">创建时间: 2018-12-12 12-09-12 </div>
                    </div>
                </div>
            </li>
    </ul>
</div>


<div class="aui-card-list">
    <div class="aui-card-list-content ">
        <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">订单号: 2018-12-12 12-09-12 </div>
                        <div class="aui-list-item-text">回收类型:  </div>
                        <div class="aui-list-item-text">预约时间: 2018-12-12 12-09-12 </div>
                        <div class="aui-list-item-text">回收/预约地点: 山东省临沂市郯城县</div>
                        <div class="aui-list-item-text">订单创建时间: 2018-12-12 12-09-12 </div>
                        <div class="aui-list-item-text">最近更新时间: 2018-12-12 12-09-12 </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>


<div class="aui-card-list">
    <div class="aui-card-list-content ">
        <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">联系人: 木道人。 </div>
                        <div class="aui-list-item-text">联系方式: 13581995512 </div>
                    </div>
                </div>
            </li>
        </ul>

    </div>

    <div class="aui-card-list-footer aui-text-center" style="padding:0rem 0.75rem">
            <i class="aui-iconfont aui-icon-question"></i>对信息有疑问,点此联系店家。
    </div>

</div>


<div class="aui-card-list">
    <div class="aui-card-list-content ">
        <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">用户预约价格: 2999.oo  </div>
                        <div class="aui-list-item-text">专家检测:是  </div>
                        <div class="aui-list-item-text">专家预测价格:2800.oo  </div>
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                用户
                <#--<#list qas as >-->
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
                <div class="aui-label aui-label-success">手机进水</div>&nbsp;
            </li>
            <li class="aui-list-item">
                店家
                <div class="aui-label aui-label-warning">未检测</div>
            </li>
        </ul>
    </div>
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