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
        /*.aui-card-list-header{*/
            /*border-bottom: 0.1rem solid #009688;*/
        /*}*/
        .aui-list label {
            font-size: 14px;
        }
    .aui-bar-btn-item.aui-active {
            background-color: #009688;
            color: #ffffff;
        }
        .aui-bar-btn-item{
            border-color: #009688;
            color: #009688;
        }

    </style>
</head>
<body  >
<header class="aui-bar aui-bar-nav" style="background-color: white;color: #008B8B">
    <a class="aui-pull-left aui-btn" style="color: #008B8B;" href="javascript:location.reload();">
        <span class="aui-iconfont aui-icon-left"  style="color: #008B8B;"></span>&nbsp;
<#--<header class="aui-bar aui-bar-nav" style="background-color: white;color: black">-->
    <#--<a class="aui-pull-left aui-btn" style="color: black;" href="javascript:location.reload();">-->
        <#--<span class="aui-iconfont aui-icon-left"  style="color: black;"></span>&nbsp;-->

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
    <#--<div>-->
        <#--<span style="color: #009688;">&nbsp;&nbsp;&nbsp;回收价格:</span>-->
        <#--<span style="float:right;color: #009688;">xxxxx手机</span>-->
        <#--&lt;#&ndash;<span style="float:right;color: #009688;">:回收价格</span>&ndash;&gt;-->
    <#--</div>-->

    <div style="font-size: 3rem;color: #FF5722;" class="aui-col-xs-10">
    <#--<div style="font-size: 3rem;color: black;" class="aui-col-xs-10">-->
        <span> ￥</span><span>${estimatePrice}</span>
        <span style="font-size: 1rem;">.00</span>
    </div>

    <div style="" class="aui-col-xs-2">
    <span style="">
        <p><div class="aui-btn aui-btn-block aui-btn-sm" style="font-size: 0.1rem;height: 1rem;line-height: 1rem;    border-radius: 0.1rem;padding: 0px;right: 0.3rem;top: 2.5rem;color: white;background-color: #009688;;">重新估价</div></p>
        <#--color: white;background-color: #009688;-->
    </span>
    </div>
</header>


<div class="aui-card-list" >
    <div class="aui-card-list-header">
        <div class="aui-bar aui-bar-btn" style="width:80%;">
            <div class="aui-bar-btn-item aui-active">上门回收</div>
            <div class="aui-bar-btn-item">店面回收</div>
            <div class="aui-bar-btn-item">快递回收</div>
        </div>
    </div>
    <div class="aui-card-list-content">
        <ul class="aui-list aui-select-list">
            <li class="aui-list-item answer-box" style="line-height: 44px" id="recyle_0">
                <ul class="aui-list aui-form-list" style="width: 100%">
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">

                                <div class="aui-dot"></div>
                            </div>
                            <div class="aui-list-item-input">
                                <input type="text" placeholder="Name">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Password
                            </div>
                            <div class="aui-list-item-input">
                                <input type="password" placeholder="Password">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Number
                            </div>
                            <div class="aui-list-item-input">
                                <input type="number" placeholder="Number">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Radio
                            </div>
                            <div class="aui-list-item-input">
                                <label><input class="aui-radio" type="radio" name="demo1" checked> 选项一</label>
                                <label><input class="aui-radio" type="radio" name="demo1"> 选项二</label>
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Select
                            </div>
                            <div class="aui-list-item-input">
                                <select>
                                    <option>Option1</option>
                                    <option>Option2</option>
                                    <option>Option3</option>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
            <li class="aui-list-item answer-box" style="line-height: 44px" id="recyle_0">
                <ul class="aui-list aui-form-list" style="width: 100%">
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">

                                <div class="aui-dot"></div>
                            </div>
                            <div class="aui-list-item-input">
                                <input type="text" placeholder="Name">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Password
                            </div>
                            <div class="aui-list-item-input">
                                <input type="password" placeholder="Password">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Number
                            </div>
                            <div class="aui-list-item-input">
                                <input type="number" placeholder="Number">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Radio
                            </div>
                            <div class="aui-list-item-input">
                                <label><input class="aui-radio" type="radio" name="demo1" checked> 选项一</label>
                                <label><input class="aui-radio" type="radio" name="demo1"> 选项二</label>
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Select
                            </div>
                            <div class="aui-list-item-input">
                                <select>
                                    <option>Option1</option>
                                    <option>Option2</option>
                                    <option>Option3</option>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
            <li class="aui-list-item answer-box" style="line-height: 44px" id="recyle_0">
                <ul class="aui-list aui-form-list" style="width: 100%">
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">

                                <div class="aui-dot"></div>
                            </div>
                            <div class="aui-list-item-input">
                                <input type="text" placeholder="Name">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Password
                            </div>
                            <div class="aui-list-item-input">
                                <input type="password" placeholder="Password">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Number
                            </div>
                            <div class="aui-list-item-input">
                                <input type="number" placeholder="Number">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Radio
                            </div>
                            <div class="aui-list-item-input">
                                <label><input class="aui-radio" type="radio" name="demo1" checked> 选项一</label>
                                <label><input class="aui-radio" type="radio" name="demo1"> 选项二</label>
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-label">
                                Select
                            </div>
                            <div class="aui-list-item-input">
                                <select>
                                    <option>Option1</option>
                                    <option>Option2</option>
                                    <option>Option3</option>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
        </ul>
    </div>
    <#--<div class="aui-card-list-footer aui-text-center">-->
        <#--底部-->
    <#--</div>-->
</div>


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