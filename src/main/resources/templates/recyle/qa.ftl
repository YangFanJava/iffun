<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-手机估价</title>
    <!-- 引入 CSS -->
    <link media="all" href="/css/aui/aui.css" rel="stylesheet">

    <style type="text/css">
        .aui-card-list-header{
            border-bottom: 0.1rem solid #F5F5F5;
        }
        .aui-list label {
            font-size: 14px;
        }
        .aui-bar-light {
            color: #009688;
        }
        .aui-bar-nav.aui-bar-light .aui-iconfont {
            color: #009688;
        }
        .aui-btn-info.aui-btn-outlined {
            color: #009688 !important;
            border: 1px solid #009688!important;
        }
        .aui-radio:checked, .aui-radio.aui-checked, .aui-checkbox:checked, .aui-checkbox.aui-checked {
            background-color: #009688;
            border: solid 1px #009688;
        }
    </style>
</head>
<body  >
<header class="aui-bar aui-bar-nav aui-bar-light" id="returnDiv">
    <a class="aui-pull-left aui-btn" href="javascript:location.reload();;">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title" >诚信回收</div>
</header>
<header class="aui-bar aui-bar-nav aui-bar-light"  style="border-bottom: 1rem solid #f5f5f5" >
     <div class="aui-media-list-item-inner" style="height: 5rem">
         <ul class="aui-list aui-media-list" style="width: 100%;" >
             <li class="aui-list-item aui-list-item-middle">
                 <div class="aui-media-list-item-inner">
                     <div class="aui-list-item-media" style="width: 3rem;     padding-right: 0.10rem;">
                         <#list product.images?split(",") as img>
                             <#if img_index == 0>
                                 <#--<img    src="${img}"  style="width:2.2rem;left: 0.3rem">-->
                                 <img src="http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg" >
                             </#if>
                         </#list>
                     </div>
                     <div class="aui-list-item-inner">

                     <#list product.prices as price>
                         <div class="aui-list-item-text">
                             <input type="hidden" name="priceId"       id="priceId"       value="${price.id}"/>
                             <input type="hidden" name="recoverPrice"  id="recoverPrice"  value="${price.recoverPrice?c}"/>
                             <input type="hidden" name="version"       id="version"       value="${price.version}"/>
                             <div class="aui-list-item-title aui-font-size-14 aui-ellipsis-1">
                                 <#if price.version?length gt 20>
                                    ${price.version?substring(0,17)}...
                                 <#else>
                                    ${price.version}
                                 </#if>

                             </div>
                             <div class="aui-list-item-right  aui-ellipsis-1" >已回收:100台</div>
                         </div>
                         <div class="aui-list-item-text" style="font-size: 11px">
                             最高交易价格:${price.recoverPrice}
                         </div>
                     </#list>
                 </div>
             </div>
         </li>
     </ul>
 </div>
</header>



<form id="qa">
<#list qaVo as question>
    <div class="aui-card-list" >
        <#--<div class="aui-card-list-header">-->
            <#--${question_index+1}  ${question.questionInfo}-->
        <#--</div>-->
        <div class="aui-card-list-content">
            <ul class="aui-list aui-select-list qa-box">
                <li class="aui-list-item answer-box" style="line-height: 44px">
                        ${question_index+1}  ${question.questionInfo}
                </li>
                <#list question.answers as answer>
                    <li class="aui-list-item answer-box">
                        <div class="aui-list-item-input" style="line-height: 44px">
                            <label>
                                <#if question.isMulti == 1>
                                    <input  class="aui-checkbox"  style="width: 1em;height: 1em;top: 13px"  type="checkbox" name="${question.questionInfo}" id="${answer.id}" value="${answer.score}">
                                <#else>
                                    <input  class="aui-radio"   style="width: 1em;height: 1em;top: 13px" type="radio" name="${question.questionInfo}" id="${answer.id}" value="${answer.score}">
                                </#if>
                                ${answer.answerInfo}
                            </label>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
        <#--<div class="aui-card-list-footer aui-text-center">-->
            <#--底部-->
        <#--</div>-->
    </div>
</#list>
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
        $("#submitbtn").click(function () {

            $.each($("#qa .qa-box"),function(i,e){
                if($(e).find("input[type='radio']").length>0&&$(e).find(":checked").length == 0){
                    dialog.alert({
                                title:"提示",
                                msg: "除了额外信息，所有的问题都要选择一个答案哦~",
                                buttons:['我知道啦！']
                            });
                    return false;
                }
            })



            var  priceId = $("#priceId").val();
            var  recoverPrice = $("#recoverPrice").val();
            var qaIds = [];
            var sroce = 0;
            $("#qa  input:checked").each(function (i,e) {
                qaIds.push($(e).attr("id"));
                sroce += parseInt($(e).val());
            })

            location.href= "/weixin/recyle/order?priceId="+priceId +"&qaIds="+qaIds.join(",")+"&recoverPrice="+recoverPrice + "&score="+sroce;
        });
        $(".answer-box").click(function () {
            var  input  = $(this).find("input")[0];
            if($(input).attr("type") == 'radio'){
                $(input).attr("checked","true");
            }else if($(input).attr("type") == 'checkbox'){
                if($(input).is(':checked')){
                    $(input).removeAttr("checked");
                }else{
                    $(input).prop("checked","true");
                }
            }
        })
    })


</script>