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
    </style>
</head>
<body  >
<header class="aui-bar aui-bar-nav aui-bar-light"  style="border-bottom: 1rem solid #f5f5f5" >
     <div class="aui-media-list-item-inner" style="height: 5rem">
         <ul class="aui-list aui-media-list" >
             <li class="aui-list-item aui-list-item-middle">
                 <div class="aui-media-list-item-inner">
                     <div class="aui-list-item-media" style="width: 3rem;">
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
                             <div class="aui-list-item-title aui-font-size-14">${price.version}</div>
                             <div class="aui-list-item-right">已回收:100台</div>
                         </div>
                         <div class="aui-list-item-text">
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
        <div class="aui-card-list-header">
            ${question_index+1}  ${question.questionInfo}
        </div>
        <div class="aui-card-list-content">
            <ul class="aui-list aui-select-list">
                <#list question.answers as answer>
                    <li class="aui-list-item answer-box">
                        <div class="aui-list-item-input">
                            <label>
                                <#if question.isMulti == 1>
                                    <input  class="aui-checkbox"   type="checkbox" name="${question.questionInfo}" value="${answer.score}">
                                <#else>
                                    <input  class="aui-radio"  type="radio" name="${question.questionInfo}" value="${answer.score}">
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
            console.info($("#qa").serialize());
            dialog.prompt({
                title:"弹出提示",
                text:'默认内容',
                buttons:['取消','确定']
            },function(ret){
                if(ret.buttonIndex == 2){
                    dialog.alert({
                        title:"提示",
                        msg: "您输入的内容是："+ret.text,
                        buttons:['确定']
                    });
                }
            })
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