﻿// 请勿修改，否则可能出错
var userAgent = navigator.userAgent,
    rMsie = /(msie\s|trident.*rv:)([\w.]+)/,
    rFirefox = /(firefox)\/([\w.]+)/,
    rOpera = /(opera).+version\/([\w.]+)/,
    rChrome = /(chrome)\/([\w.]+)/,
    rSafari = /version\/([\w.]+).*(safari)/;
var browser;
var version;
var ua = userAgent.toLowerCase();
function uaMatch(ua) {
    var match = rMsie.exec(ua);
    if (match != null) {
        return {browser: "IE", version: match[2] || "0"};
    }
    var match = rFirefox.exec(ua);
    if (match != null) {
        return {browser: match[1] || "", version: match[2] || "0"};
    }
    var match = rOpera.exec(ua);
    if (match != null) {
        return {browser: match[1] || "", version: match[2] || "0"};
    }
    var match = rChrome.exec(ua);
    if (match != null) {
        return {browser: match[1] || "", version: match[2] || "0"};
    }
    var match = rSafari.exec(ua);
    if (match != null) {
        return {browser: match[2] || "", version: match[1] || "0"};
    }
    if (match != null) {
        return {browser: "", version: "0"};
    }
}
var browserMatch = uaMatch(userAgent.toLowerCase());
if (browserMatch.browser) {
    browser = browserMatch.browser;
    version = browserMatch.version;
}
//document.write(browser);
/*
 谷歌浏览器事件接管
 */
/*function OnComplete2(type, code, html) {
    //alert(type);
    //alert(code);
    //alert(html);
    //alert("SaveToURL成功回调");
}*/
//页面上重写了，所以需要注释如果需要回调请在页面上重写此方法
/*function OnComplete(type,code,html)
 {
 //alert("BeginOpenFromURL成功回调");
 }*/
function publishashtml(type, code, html) {
    //alert(html);
    //alert("Onpublishashtmltourl成功回调");
}
function publishaspdf(type, code, html) {
//alert(html);
//alert("Onpublishaspdftourl成功回调");
}
function saveasotherurl(type, code, html) {
//alert(html);
    alert("SaveAsOtherformattourl成功回调");
}
function dowebget(type, code, html) {
//alert(html);
//alert("OnDoWebGet成功回调");
}
function webExecute(type, code, html) {
//alert(html);
//alert("OnDoWebExecute成功回调");
}
function webExecute2(type, code, html) {
//alert(html);
//alert("OnDoWebExecute2成功回调");
}
function FileCommand(TANGER_OCX_str, TANGER_OCX_obj) {
    if (TANGER_OCX_str == 3) {
        alert("不能保存！");
        TANGER_OCX_OBJ.CancelLastCommand = true;
    }
}
function CustomMenuCmd(menuPos, submenuPos, subsubmenuPos, menuCaption, menuID) {
    alert("第" + menuPos + "," + submenuPos + "," + subsubmenuPos + "个菜单项,menuID=" + menuID + ",菜单标题为\"" + menuCaption + "\"的命令被执行.");
}
var classidx64 = "A64E3073-2016-4baf-A89D-FFE1FAA10EE0";

var classid = "A64E3073-2016-4baf-A89D-FFE1FAA10EC0";
var codebase = contextRoot + "/static/js/ntko/OfficeControl.cab";
var codebase64 = contextRoot + "/static/js/ntko/OfficeControlx64.cab";
if (browser == "IE") {
    //alert(window.navigator.platform);
    //alert(navigator.userAgent);
    if (window.navigator.platform == "Win32") {
        //alert(32);
        document.write('<!-- 用来产生编辑状态的ActiveX控件的JS脚本-->   ');
        document.write('<!-- 因为微软的ActiveX新机制，需要一个外部引入的js-->   ');
        document.write('<object id="TANGER_OCX" classid="clsid:' + classid + '"');
        document.write('codebase="' + codebase + '" width="100%" height="100%">   ');
        document.write('<param name="IsUseUTF8URL" value="-1">   ');
        document.write('<param name="IsUseUTF8Data" value="-1">   ');
        document.write('<param name="BorderStyle" value="1">   ');
        document.write('<param name="BorderColor" value="14402205">   ');
        document.write('<param name="TitlebarColor" value="15658734">   ');
        document.write('<param name="ekeytype" value="14">   ');


        document.write('<param name="ProductCaption" value="后勤保障部采购管理局"> ');
        document.write('<param name="ProductKey" value="AB579623F5B4E11E5F61C06579A21F8446416FB7">');


        document.write('<param name="TitlebarTextColor" value="0">   ');
        document.write('<param name="MenubarColor" value="14402205">   ');
        document.write('<param name="MenuButtonColor" VALUE="16180947">   ');
        document.write('<param name="MenuBarStyle" value="3">   ');
        document.write('<param name="MenuButtonStyle" value="7">   ');
        document.write('<param name="WebUserName" value="NTKO">   ');
        document.write('<param name="Caption" value="NTKO OFFICE文档控件示例演示 http://www.ntko.com">   ');
        document.write('<SPAN STYLE="color:red">32不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</SPAN>   ');
        document.write('</object>');
    }
    if (window.navigator.platform == "Win64") {
        //alter(64);
        document.write('<!-- 用来产生编辑状态的ActiveX控件的JS脚本-->   ');
        document.write('<!-- 因为微软的ActiveX新机制，需要一个外部引入的js-->   ');
        document.write('<object id="TANGER_OCX" classid="clsid:' + classidx64 + '"');
        document.write('codebase="' + codebase64 + '" width="100%" height="100%">    ');
        document.write('<param name="IsUseUTF8URL" value="-1">   ');
        document.write('<param name="IsUseUTF8Data" value="-1">   ');
        document.write('<param name="BorderStyle" value="1">   ');
        document.write('<param name="BorderColor" value="14402205">   ');
        document.write('<param name="TitlebarColor" value="15658734">   ');
        document.write('<param name="isoptforopenspeed" value="0">   ');
        document.write('<param name="TitlebarTextColor" value="0">   ');


        document.write('<param name="ProductCaption" value="后勤保障部采购管理局"> ');
        document.write('<param name="ProductKey" value="AB579623F5B4E11E5F61C06579A21F8446416FB7">');


        document.write('<param name="MenubarColor" value="14402205">   ');
        document.write('<param name="MenuButtonColor" VALUE="16180947">   ');
        document.write('<param name="MenuBarStyle" value="3">   ');
        document.write('<param name="MenuButtonStyle" value="7">   ');
        document.write('<param name="WebUserName" value="NTKO">   ');
        document.write('<param name="Caption" value="NTKO OFFICE文档控件示例演示 http://www.ntko.com">   ');
        document.write('<SPAN STYLE="color:red">64不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</SPAN>   ');
        document.write('</object>');

    }

}
else if (browser == "firefox") {
    /*var curWwwPath=window.document.location.href;
     var pathName=window.document.location.pathname;
     var pos=curWwwPath.indexOf(pathName);
     var localhostPaht=curWwwPath.substring(0,pos);
     document.write(localhostPaht);*/
    document.write('<object id="TANGER_OCX" type="application/ntko-plug"  codebase="' + codebase + '#version=5,0,3,9" width="100%" height="100%" ForOnSaveToURL="OnComplete2" ForOnSaveAsOtherFormatToUrl="saveasotherurl" ForOnBeginOpenFromURL="OnComplete" ForOndocumentopened="OnComplete3"');

    document.write('ForOnpublishAshtmltourl="publishashtml"');
    document.write('ForOnpublishAspdftourl="publishaspdf"');
    document.write('ForOnDoWebGet="dowebget"');
    document.write('ForOnDoWebExecute="webExecute"');
    document.write('ForOnDoWebExecute2="webExecute2"');
    document.write('ForOnFileCommand="FileCommand"');
    document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
    document.write('ForOnAddTemplateFromURL="addtemplatefromurl"');
    document.write('_IsUseUTF8URL="-1"   ');


    document.write('_ProductCaption="后勤保障部采购管理局" ');
    document.write('_ProductKey="AB579623F5B4E11E5F61C06579A21F8446416FB7"');


    document.write('_IsUseUTF8Data="-1"   ');
    document.write('_BorderStyle="1"   ');
    document.write('_BorderColor="14402205"   ');
    document.write('_MenubarColor="14402205"   ');
    document.write('_MenuButtonColor="16180947"   ');
    document.write('_MenuBarStyle="3"  ');
    document.write('_MenuButtonStyle="7"   ');
    document.write('_WebUserName="NTKO"   ');
    document.write('clsid="{' + classid + '}" >');
    document.write('<SPAN STYLE="color:red">尚未安装NTKO Web FireFox跨浏览器插件。请点击<a href="javascript:downloadNtko();">安装组件</a></SPAN>   ');
    document.write('</object>   ');
} else if (browser == "chrome") {
    document.write('<object id="TANGER_OCX" clsid="{' + classid + '}"  ForOnSaveToURL="OnComplete2" ForOnBeginOpenFromURL="OnComplete" ForOndocumentopened="OnComplete3"');
    document.write('ForOnpublishAshtmltourl="publishashtml"');
    document.write('ForOnpublishAspdftourl="publishaspdf"');
    document.write('ForOnSaveAsOtherFormatToUrl="saveasotherurl"');
    document.write('ForOnDoWebGet="dowebget"');
    document.write('ForOnDoWebExecute="webExecute"');
    document.write('ForOnDoWebExecute2="webExecute2"');
    document.write('ForOnFileCommand="FileCommand"');
    document.write('ForOnAddTemplateFromURL="addtemplatefromurl"');

    document.write('_ProductCaption="后勤保障部采购管理局" ');
    document.write('_ProductKey="AB579623F5B4E11E5F61C06579A21F8446416FB7"');


    document.write('ForOnCustomMenuCmd2="CustomMenuCmd"');
    document.write('codebase="' + codebase + '" width="100%" height="100%" type="application/ntko-plug" ');
    document.write('_IsUseUTF8URL="-1"   ');
    document.write('_IsUseUTF8Data="-1"   ');
    document.write('_BorderStyle="1"   ');
    document.write('_BorderColor="14402205"   ');
    document.write('_MenubarColor="14402205"   ');
    document.write('_MenuButtonColor="16180947"   ');
    document.write('_MenuBarStyle="3"  ');
    document.write('_MenuButtonStyle="7"   ');
    document.write('_WebUserName="NTKO"   ');
    document.write('_Caption="NTKO OFFICE文档控件示例演示 http://www.ntko.com">    ');
    document.write('<SPAN STYLE="color:red">尚未安装NTKO Web Chrome跨浏览器插件。请点击<a href="javascript:downloadNtko();">安装组件</a></SPAN>   ');
    document.write('</object>');
} else if (Sys.opera) {
    alert("sorry,ntko web印章暂时不支持opera!");
} else if (Sys.safari) {
    alert("sorry,ntko web印章暂时不支持safari!");
}

/**
 * Auth:Easong
 * 异步下载ntko安装包
 */
function downloadNtko() {
    // 加载等待框
    loading = layer.load(1);
    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('method', 'post');
    form.attr('action', contextRoot + 'download/ntkoDownload.do');
    $('body').append(form);
    form.submit();
    layer.close(loading);
}