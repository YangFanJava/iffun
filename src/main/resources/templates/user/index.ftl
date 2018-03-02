<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-个人信息</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">
    <link media="all" href="/css/date/mobiscroll.custom-2.17.0.min.css" rel="stylesheet">

    <style type="text/css">


    </style>
</head>
<body>

<header class="aui-bar aui-bar-nav" style="
    background-color: #009688;
    font-size: 0.8rem;
">
    <div class="aui-title">&nbsp;&nbsp;用户详情 </div>

    <a class="aui-pull-left aui-btn aui-btn-outlined">
        <span class="aui-iconfont aui-icon-my"></span>
    </a>

</header>

<div class="aui-card-list" style="text-align: center;/* background-color: #fff; */background-image: url(https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1519388736524&amp;di=7b6a9bbec2c48c149b0929d5947db132&amp;imgtype=0&amp;src=http%3A%2F%2Fpic30.photophoto.cn%2F20140331%2F0008020223839613_b.jpg);">

    <div class="" style="
    width: 5rem;
    margin: 0.3rem auto 0.4rem;
">
        <img src="${info.headimgurl}" class="aui-img-round" style="
">
    </div>

    <div style="
    margin: 0rem auto;
    font-size: 0.9rem;
    color: #2F4056;
">${info.nickname}</div>
    <div style="
    color: #c2c2c2;
    margin: 0.3rem auto 0.5rem;
    font-size: 0.7rem;
">${info.province???string(info.province,"北京")} &nbsp; ${info.city???string(info.city,"北京")}</div>
</div>
<section class="aui-grid aui-margin-b-15">
    <div class="aui-row">

        <div class="aui-col-xs-6" id="toOrderList" >
            <div class="aui-badge">${orderCountData.sum-orderCountData.count}</div>
            <i class="aui-iconfont aui-icon-cart"></i>
            <div class="aui-grid-label"><div style="
    font-size: 0.8rem;
">已回收${orderCountData.count}台</div><div style="
    font-size: 0.6rem;
">赚到了${orderCountData.sumPrice}元</div></div>
        </div>
        <div class="aui-col-xs-6">
            <i class="aui-iconfont aui-icon-share"></i>
            <div class="aui-grid-label"><div style="
    font-size: 0.8rem;
">这个地放啥</div><div style="
    font-size: 0.6rem;
">没啥能放的了啊</div></div>
        </div>

    </div>
</section>


<div class="aui-content aui-margin-b-15">
    <ul class="aui-list aui-list-in">
        <li class="aui-list-header">不知道写什么</li>
        <li class="aui-list-item  aui-list-item-arrow" id="toOrderList2" >
            <div class="aui-list-item-label-icon">
                <i class="aui-iconfont aui-icon-mobile"></i>
            </div>
            <div class="aui-list-item-inner">
                回收订单
            </div>
        </li>
        <li class="aui-list-item  aui-list-item-arrow">
            <div class="aui-list-item-label-icon ">
                <i class="aui-iconfont aui-icon-cert"></i>
            </div>
            <div class="aui-list-item-inner ">
                商品订单
            </div>
        </li>

        <li class="aui-list-item  aui-list-item-arrow">
            <div class="aui-list-item-label-icon">
                <i class="aui-iconfont aui-icon-home"></i>
            </div>
            <div class="aui-list-item-inner">
                关于我们
            </div>
        </li>
    </ul>
</div>

<footer class="aui-bar aui-bar-tab" id="footer" style="    min-height: 1.85rem;">
    <footer class="aui-bar aui-bar-tab aui-row" id="footer">
        <div class="aui-btn aui-btn-success aui-btn-block aui-btn-sm" onclick="submitOrder()" style="buttom: 0px !important;">
            &lt;&lt; &nbsp;前往回收首页
        </div>
    </footer>
</footer>





<script type="text/javascript" src="/js/aui/api.js"></script>
<script type="text/javascript" src="/js/aui/aui-toast.js"></script>
<script type="text/javascript" src="/js/aui/aui-dialog.js"></script>
<!-- 引入 JS -->
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/date/mobiscroll.custom-2.17.0.min.js"></script>


<script id="">
    $(function(){
        $("#toOrderList2").click(function(){
            location.href =  "/weixin/order/toList";
        })
        $("#toOrderList").click(function(){
            location.href =  "/weixin/order/toList";
        })
    })

    function submitOrder() {
        location.href = "/weixin/index";
    }

</script>




</body>
</html>