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
        .aui-radio:checked, .aui-radio.aui-checked, .aui-checkbox:checked, .aui-checkbox.aui-checked {
            background-color: #009688;
            border: solid 1px #009688;
        }

        .aui-list-item-label{
            line-height: 0.6rem !important;
            font-size: 0.6rem;
            color: #009688 !important;
        }
        .aui-list-item-inner{
            padding-top: 0rem !important;
            padding-bottom: 0rem !important;
        }
        .aui-list-item{
            padding-left: 0.35rem !important;
        }

        .inner-li{
            padding-left: 0.3rem !important;
            border-bottom: 0px solid #dddddd !important;;
        }



        /*input placeholer css*/
        input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
            color: #009688;
        }
        input:-moz-placeholder, textarea:-moz-placeholder {
            color: #009688;
        }
        input::-moz-placeholder, textarea::-moz-placeholder {
            color: #009688;
        }
        input:-ms-input-placeholder, textarea:-ms-input-placeholder {
            color: #009688;
        }


        .aui-dialog-btn{
            color: #009688;
        }
        .aui-list-item-input {
            line-height: 0.7rem !important;
            font-size: 0.7rem;
            color: #009688 !important;
        }


        input[type='radio']{
            width: 1em!important;
            height: 1em!important;
            top: 13px!important;
        }



        /*date*/
        .mbsc-mobiscroll .dwwr {
            background-color: transparent;
        }
        .dwsc .dw-sel {
            /*background: url(../img/date.png) no-repeat left center;*/
            width: 40px;
            height: 40px;
            background-size: 50% 50%;
            padding-left: 20px;
        }
        .dwsc:last-child .dw-sel {
            /*background-image: url(../img/time.png);*/
        }
        .dw-bf {
            position: relative;
        }
        .mbsc-w-p {
            width: 150px;
        }
        .dw-i {
            width: 80px;
            color: #009688;
            font-size: 0.3rem;
        }
        .dw-li {
            padding-left: 20px;
        }
        .mbsc-mobiscroll .dwwol {
            border-color: #009688;
            width: 80px;
            margin-left: 23px;
        }
        .dw-sel .dw-i,
        .mbsc-mobiscroll .dwl {
            color: black;
            font-size: 0.3rem;
        }
        .dwl{
            width: 80% !important;
        }
        .mbsc-mobiscroll .dwl {
            font-size: 0.22rem;
            width: 1.6rem;
            margin-left: 0.4rem;
        }
        .dw{
            background-color:  white !important;;
        }





        .aui-col-xs-3{
            line-height: 0.6rem !important;
            font-size: 0.6rem;
            color: #009688 !important;
            bottom: 0px;
            top: 0.9rem;
            text-align: right;
        }




    </style>
</head>
<body  >
<header class="aui-bar aui-bar-nav" style="background-color: white;color: #008B8B">
    <a class="aui-pull-left aui-btn" style="color: #008B8B;" href="/weixin/recyle/estimate?qaIds=${qaIds}&priceId=${priceId}">
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
        <a href="/weixin/recyle/estimate?priceId=${priceId}">
        <p>
            <div class="aui-btn aui-btn-block aui-btn-sm" style="font-size: 0.1rem;height: 1rem;line-height: 1rem;    border-radius: 0.1rem;padding: 0px;right: 0.3rem;top: 2.5rem;color: white;background-color: #009688;">
                重新估价
            </div>
        </p>
        </a>
        <#--color: white;background-color: #009688;-->
    </span>
    </div>
</header>


<div class="aui-card-list" >
    <div class="aui-card-list-header">
        <div class="aui-bar aui-bar-btn" style="width:80%;">
            <div data-id="recyle_0"  class="aui-bar-btn-item aui-active">上门回收</div>
            <div data-id="recyle_1" id="activeBtn"  class="aui-bar-btn-item">店面回收</div>
            <div data-id="recyle_2" class="aui-bar-btn-item">快递回收</div>
        </div>
    </div>
    <div class="aui-card-list-content">
        <ul class="aui-list aui-select-list">
            <form id="recyle_0_from" name="order">
            <li class="aui-list-item recyle-box" style="line-height: 44px" id="recyle_0">

                    <ul class="aui-list aui-form-list" style="width: 100%">
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                联系人：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="text" name="recyle_0_userName" placeholder="联系人">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                联系方式：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="number" name="recyle_0_userPhone" placeholder="联系方式">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                回收方式：
                            </div>
                            <div class=" aui-col-xs-9">
                                <label><input class="aui-radio" type="radio" name="recyle_0_recyleType" value="0" > 地铁回收</label>
                                <label><input class="aui-radio" type="radio" name="recyle_0_recyleType" value="1" checked> 上门回收</label>
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                预约时间：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input  id="date_0" type="text"  name="recyle_0_appointmentTimeStr" placeholder="预约时间">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                预约地点：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input   type="text"  name="recyle_0_appointmentAddress" placeholder="预约地点">
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
            </form>
            <form id="recyle_1_from" name="order">
            <li class="aui-list-item recyle-box" style="line-height: 44px" id="recyle_1">

                    <ul class="aui-list aui-form-list" style="width: 100%">
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                联系人：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="text" name="recyle_1_userName" placeholder="名称">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                联系方式：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="number" name="recyle_1_userPhone" placeholder="手机号">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                预约时间：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input  id="date_1" type="text" name="recyle_1_appointmentTimeStr" placeholder="预约时间">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner  ">
                            <div style="text-align: center;line-height: 30px;">
                                <div style="font-size: 0.65rem;color: #D5D5D5;text-align: left;margin-left: 0.4rem;" class="aui-ellipsis-2">
                                    订单下达后，可以直接到店回收。
                                </div>
                                <div style="width:100%;text-align: left;font-size: 0.8rem;color: orangered; margin-left: 0.4rem;">
                                    店铺地址:xxx路xxx号xxx院
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
            </form>
            <form id="recyle_2_from" name="order">
            <li class="aui-list-item recyle-box" style="line-height: 44px" id="recyle_2">

                    <ul class="aui-list aui-form-list" style="width: 100%">


                    <li class="aui-list-item">
                        <div class="aui-list-item-inner  ">
                            <p>
                            <div onclick="catEmailAddr()" class="aui-btn aui-btn-warning aui-btn-block aui-btn-outlined aui-btn-sm" >
                                点击查看邮寄地址
                            </div>
                            </p>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                姓名：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="text" name="recyle_2_userName" placeholder="联系人">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                联系方式：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="number" name="recyle_2_userPhone" placeholder="联系方式">
                            </div>
                        </div>
                    </li>
                    <li class="aui-list-item">
                        <div class="aui-list-item-inner aui-row aui-row-padded ">
                            <div class=" aui-col-xs-3">
                                快递单号：
                            </div>
                            <div class=" aui-col-xs-9">
                                <input type="number" name="recyle_2_expressCode" placeholder="快递单号">
                                <#--<div class="aui-list-item-input">-->
                                    <#--<textarea placeholder="Textarea">-->
                                <#--</div>-->
                            </div>
                        </div>
                    </li>
                </ul>

            </li>
            </form>
        </ul>
    </div>
    <#--<div class="aui-card-list-footer aui-text-center">-->
        <#--底部-->
    <#--</div>-->
</div>

<footer class="aui-bar aui-bar-tab" id="footer" style="    min-height: 1.85rem;">
    <footer class="aui-bar aui-bar-tab aui-row" id="footer">
        <div class="aui-btn aui-btn-success aui-btn-block aui-btn-sm" onclick="submitOrder()" style="buttom: 0px !important;">
            提交回收申请
        </div>
    </footer>
</footer>


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
    
    
    
    var dialog = new auiDialog({})
    $(".aui-bar-btn-item").on("click",function () {
        console.info($(this).data("id"));
        $(".aui-bar-btn-item").removeClass("aui-active");
        $(this).addClass("aui-active");

        $(".recyle-box").hide();
        $("#"+$(this).data("id")).show();

    })


    function submitOrder() {
        var id  =  $(".aui-bar-btn-item.aui-active").data("id");

        var param = {
            "priceId":"${priceId}",
            "qaUser":"${qaIds}",
            "estimatePriceUser":"${estimatePrice}"
        };

        var dangeText = "";

        var userName = $("input[name='"+id+"_userName']").val();
        if(userName&&userName != ''){
            param.userName = userName;
            var userPhone = $("input[name='"+id+"_userPhone']").val();
            if(userPhone&&userPhone.length == 11 ){
                param.userPhone = userPhone;
                var type = id.split("_")[1];
                param.recyleType = type;
                switch (type){
                        //上门回收  预约时间
                    case "0":
                        var rec_type = $("input[name='"+id+"_recyleType']:checked").val();
                        var appointmentAddress = $("input[name='"+id+"_appointmentAddress']").val();
                        if (rec_type&&appointmentAddress&&appointmentAddress!=''){
                            appointmentAddress = (rec_type == '0' ? "地铁站回收:":"上门回收:") + appointmentAddress;
                            param.appointmentAddress = appointmentAddress;
                        }else{
                            dangeText = "请填写上门回收的地址哦~";
                            break;
                        }
                        //穿透 向下判断时间
                        //到店回收
                    case "1":
                        var appointmentTimeStr = $("input[name='"+id+"_appointmentTimeStr']").val();
                        if (appointmentTimeStr&&appointmentTimeStr!=''){
                            param.appointmentTimeStr = appointmentTimeStr;
                        }else{
                            dangeText = "请选择预约时间哦~";
                        }
                        break;
                        //快递回收
                    case "2":
                        var expressCode = $("input[name='"+id+"_expressCode']").val();
                        if (expressCode&&expressCode != ''){
                            param.expressCode = expressCode;
                        }else{
                            dialog.alert({
                                title:"提示",
                                msg:'手机邮寄的时候别忘了去 个人信息>回收订单 填写快递单号哦~',
                                buttons:['确定']
                            })
                        }
                        break;
                    default:dangeText = "发生了一点小故障，请刷新下页面或者联系我们的管理员哦！";
                }
            }else{
                dangeText = "手机号码未填写或者格式错误！"
            }
        }else{
            dangeText = "用户名需要填写一下哦！";
        }


        if(dangeText != '' ){
            dialog.alert({
                title:"提示",
                msg:dangeText,
                buttons:['确定']
            })
        }


        $.post("/weixin/recyle/createOrder",param,function (r) {
            if(r.code == 0){
                dialog.alert({
                    title:"保存成功",
                    msg:"订单创建成功，请保持通话畅通，我们的工作人员会很快联系您！",
                    buttons:['确定']
                },function(ret){
                    location.href = "/weixin/order/toList";
                })
            }
        },"json")
    }



    function catEmailAddr() {
        dialog.alert({
            title:"邮寄地址",
            msg:'<div style="text-align: left">   &nbsp;&nbsp;收件人：马xxx<div><div style="text-align: left">邮政编码：1232132<div><div style="text-align: left">邮寄地址：多撒多撒很大数据库的撒谎就开打随便你吧说的就ask</div>',
            buttons:['确定']
        })
    }


    var estimateTime = "";

    $(function () {
        $("#activeBtn").click();

//
//        $('#date').mobiscroll().date({
//            theme: 'mobiscroll',
//            display: 'bottom'
//        });
        //初始化时间  如果当前12月  选择为1 月时  年份加一
        var year  = "";
        var bo = false;
        var curDate  = new Date();
        year  = curDate.getFullYear();
        if(curDate.getMonth() == 11){
            bo = true;
        }



        var dates = [];
        var getDays = function(str,day_count,format){
            if(typeof str === "number"){
                format = day_count;
                day_count = str;
                str = new Date();
            }
            var date = new Date(str);
            for(var i=0;i<=day_count;i++){
                var d = null;
                if(!format){
                    var fmt = format;
                    fmt = fmt.replace(/y{4}/,date.getFullYear());
                    fmt = fmt.replace(/M{2}/,date.getMonth()+1);
                    fmt = fmt.replace(/d{2}/,date.getDate());
                    d = fmt;
                }else{
                    if(parseInt(date.getMonth()+1)<10){
                        if(date.getDate()<10){
                            d = "0"+ parseInt(date.getMonth()+1) + "月"+"0"+date.getDate()+"日";
                        }else{
                            d ="0"+ parseInt(date.getMonth()+1) + "月" +date.getDate()+"日";
                        }
                    }else{
                        if(date.getDate()<10){
                            d = parseInt(date.getMonth()+1) + "月"+"0"+date.getDate()+"日";
                        }else{
                            d = parseInt(date.getMonth()+1) + "月" +date.getDate()+"日";
                        }
                    }


                }
                dates.push(d);
                date.setDate(date.getDate()+1);
            }
            return dates;

        };


        var hour=[];
        for(var i=0;i<24;i++){
            var c=i<10?"0"+i+":00":i+":00";
            hour.push(c);
        }

        var wheels=[
            [
                {values:getDays(30,"yyyy年MM月dd日"),label:"预约日期"}

            ],
            [
                {values:hour,label:"预约时间"}
            ]
        ];

        var j=wheels[0][0].values[1];
        var k=wheels[1][0].values[1];

        $('#date_0').mobiscroll().scroller({
            theme:'mobiscroll',
            display:'bottom',
            lang:'zh',
            showLabel:true,
            rows:3,
            wheels:wheels,
            defaultValue:[j,k],
            formatResult:function(array){
                var choseDate=array[0];
                var choseTime=array[1];
                sessionStorage.setItem("choseDate",choseDate);
                sessionStorage.setItem("choseTime",choseTime);
                estimateTime = choseDate + " " + choseTime;
                console.log(estimateTime)
            },
            onSelect:function(valueText,inst){
                if(bo && parseInt(estimateTime.substring(0,2)) == 1){
                    year = year + 1 ;
                }
                $("#date_0").val(year +"-" + estimateTime.replace("月","-").replace("日","")+":00")
            }
        });
        $('#date_1').mobiscroll().scroller({
            theme:'mobiscroll',
            display:'bottom',
            lang:'zh',
            showLabel:true,
            rows:3,
            wheels:wheels,
            defaultValue:[j,k],
            formatResult:function(array){
                var choseDate=array[0];
                var choseTime=array[1];
                sessionStorage.setItem("choseDate",choseDate);
                sessionStorage.setItem("choseTime",choseTime);
                estimateTime = choseDate + " " + choseTime;
                console.log(estimateTime)
            },
            onSelect:function(valueText,inst){
                if(bo && parseInt(estimateTime.substring(0,2)) == 1){
                    year = year + 1 ;
                }
                $("#date_1").val(year +"-" + estimateTime.replace("月","-").replace("日","")+":00")
            }
        });
    })


</script>