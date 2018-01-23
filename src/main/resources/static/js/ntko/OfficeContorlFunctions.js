var OFFICE_CONTROL_OBJ;//控件对象
var IsFileOpened;      //控件是否打开文档
var fileType;
var fileTypeSimple;
// 初始化文档
function intializePage(fileName) {
    OFFICE_CONTROL_OBJ = document.getElementById("TANGER_OCX");
    // initCustomMenus();
    NTKO_OCX_OpenDoc(fileName);
}

/**
 * 从word文档中读取内容并传递给inputname
 * @param BookMarkName
 * @param inputname
 * @constructor
 */
function ReadFromDoc(BookMarkName, inputname) {
    var inputname = "";
    var elObj = document.forms[0].elements(inputname);
    if (!elObj) {
        alert("HTML的form中没有此输入域：" + inputname);
    }
    elObj.value = OFFICE_CONTROL_OBJ.ActiveDocument.Content.Text;
    alert(elObj.value);
}

/**
 * 从word文档中读取指定书签内容并传递给inputname
 * @param BookMarkName
 * @param inputname
 * @constructor
 */
function ReadBookMarkFromDoc(BookMarkName, inputname) {
    var inputname = "";
    /*var elObj = document.forms[0].elements(inputname);
     if(!elObj){
     alert("HTML的form中没有此输入域：" + inputname);
     }*/
    var bkmkObj = OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks("SYS_1", "SYS_1_1");
    alert(bkmkObj)
    // bkmkObj.Select();
}

function onPageClose() {
    if (!OFFICE_CONTROL_OBJ.activeDocument.saved) {
        if (confirm("文档修改过,还没有保存,是否需要保存?")) {
            saveFileToUrl();
        }
    }
}
function NTKO_OCX_OpenDoc(filePath) {
    filePath = $("#filePath").val();
    var fileName = $("#fileName").val();
    // 编码
    filePath = encodeURIComponent(filePath);
    fileName = encodeURIComponent(fileName);
    OFFICE_CONTROL_OBJ.Menubar = true;
    OFFICE_CONTROL_OBJ.Caption = "( 双击可放大 ! )";
    if (fileName) {
        OFFICE_CONTROL_OBJ.BeginOpenFromURL(
            contextRoot + "upload/readFile.html?filePath=" + filePath + "&fileName=" + fileName, //处理后台打开的URL地址
            true, //是否显示进度条
            false, //是否只读打开
            "word.document" //文档类型
        );
    }
}

/**
 * 加载文档完毕后的函数
 * @param str
 * @param doc
 * @constructor
 */
var bookMarkName = "BID_PRICE_TABLE";
function OnComplete3(str, doc) {
    var makePricePath = $("#makePricePath").val();
    makePricePath = encodeURIComponent(makePricePath);
    var fileType = $("#fileType").val();
    // 替换报价一览表和价格构成表
    // TANGER_OCX_DoPaiBan(contextRoot + "/upload/readFile.html?filePath=" + makePricePath);
    //loadWord("BID_PRICE_TABLE_START", "BID_PRICE_TABLE_END", contextRoot + "/upload/readFile.html?filePath=" + makePricePath);
    /*try {
     var BookMarkName = "BID_PRICE_TABLE_START";
     if (!OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks.Exists(BookMarkName)) {
     alert("Word 模板中不存在名称为：\"" + BookMarkName + "\"的书签！");
     return;
     }
     var projectNo = OFFICE_CONTROL_OBJ.GetBookMarkValue("BID_PRICE_TABLE_START");
     alert(projectNo)
     var doc = OFFICE_CONTROL_OBJ.ActiveDocument;
     doc.BookMarks(BookMarkName).Select();
     OFFICE_CONTROL_OBJ.AddTemplateFromURL(contextRoot + "/upload/readFile.html?filePath=" + makePricePath);
     }catch (err) {
     alert("错误：" + err.number + ":" + err.description);
     }*/
    // 如果文件保护则先取消保护让用户可编辑
    if(fileType == 1){
        OFFICE_CONTROL_OBJ.ActiveDocument.UnProtect("jdcg$810");
    }
    var sel = OFFICE_CONTROL_OBJ.ActiveDocument.Application.Selection;
    if (OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks.Exists(bookMarkName)) {
        // 将光标定位到书签BID_PRICE_TABLE
        sel.GoTo(-1, 0, 0, bookMarkName);
        //在书签的位置添加一个空格
        // sel.TypeText(" ");
        //获取addtemp对象
        // var shuq1=OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks("BID_PRICE_TABLE_START");
        //获取插入空格的range对象
        // var rang=OFFICE_CONTROL_OBJ.ActiveDocument.Range(shuq1.Start+1,shuq1.End+1);
        //选择定位到空格对象
        //rang.Select();
        //在空格处插入一个临时标签
        //var shuq2=OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Add("temp",rang);
        //将光标定位到addtemp书签
        //shuq1.Select();
        //将指定的word文件中的内容插入到当前光标处
        OFFICE_CONTROL_OBJ.AddTemplateFromURL(contextRoot + "upload/readFile.html?filePath=" + makePricePath, false, true);
        //将插入的word文本生成一个Range对象
        //var text=OFFICE_CONTROL_OBJ.ActiveDocument.Range(shuq1.End,shuq2.Start);
        //对插入的内容进行相关的字体设置
        /*text.Font.Size = 16;
         text.Font.Name="仿宋_GB2312";
         text.Font.Color=255;*/
        //将光标定位到临时书签，然后删除空格和临时书签
        /*shuq2.Select();
         sel.TypeBackspace();
         shuq2.Delete();*/
    } else {
        alert("当前没有" + bookMarkName + "书签！");
    }

}

/**
 *
 * @param type 2
 * @param code 0
 * @param html ok
 */
function addtemplatefromurl(type, code, html){
    if(html == 'ok'){
        doProtect(bookMarkName);
    }
}

/**
 * 替换文档
 * @param begin
 * @param end
 * @param url
 */
function loadWord(begin, end, url) {
    OFFICE_CONTROL_OBJ.ActiveDocument.Range(OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Item(begin).Range.End,
        OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Item(end).Range.Start).Select();
    /* obj.ActiveDocument.Application.Selection.Editors.Add(-1);  *///增加可编辑区域
    OFFICE_CONTROL_OBJ.AddTemplateFromURL(url, false, true);
}

/**
 * 保存文件到系统
 */
function saveFile(flag) {
    // 获取项目编号和供应商名称
    var projectNumber = $("#projectNumber").val();
    var suppliername = $("#suppliername").val();
    var projectId = $("#projectId").val();
    var fileName = projectNumber + "_" + suppliername + ".doc";
    result = OFFICE_CONTROL_OBJ.SaveToURL(contextRoot + "upload/save_file.do",//提交到的url地址
        "upLoadFile",//文件域的id，类似<input type=file id=upLoadFile 中的id
        "",          //与控件一起提交的参数如："p1=a&p2=b&p3=c"
        fileName,    //上传文件的名称，类似<input type=file 的value
        "MyFile"    //与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
    );
}
/**
 * SaveToURL回调函数
 * @param type
 * @param code
 * @param html
 * @constructor
 */
function OnComplete2(type, code, html) {
    if (html != null && html != '') {
        var params = html.split(",");
        if (params[0] == 200 && params[2] == 0) {
            alert("暂存成功");
        }
        if (params[0] == 200 && params[2] == 1) {
            // 进入绑定指标页面
            window.location.href = contextRoot + "home/bind_tender/" + params[1];
        }
    }
}

function setFileOpenedOrClosed(bool) {
    IsFileOpened = bool;
    fileType = OFFICE_CONTROL_OBJ.DocType;
}
function trim(str) { //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
function saveFileToUrl() {
    var myUrl = document.forms[0].action;
    var fileName = document.all("fileName").value;
    var result;
    if (IsFileOpened) {
        switch (OFFICE_CONTROL_OBJ.doctype) {
            case 1:
                fileType = "Word.Document";
                break;
            case 2:
                fileType = "Excel.Sheet";
                break;
            case 3:
                fileType = "PowerPoint.Show";
                break;
            case 4:
                fileType = "Visio.Drawing";
                break;
            case 5:
                fileType = "MSProject.Project";
                break;
            case 6:
                fileType = "WPS Doc";
                break;
            case 7:
                fileType = "Kingsoft Sheet";
                break;
            default :
                fileType = "unkownfiletype";
        }
        result = OFFICE_CONTROL_OBJ.saveToURL(myUrl,//提交到的url地址
            "upLoadFile",//文件域的id，类似<input type=file id=upLoadFile 中的id
            "fileType=" + fileType,          //与控件一起提交的参数如："p1=a&p2=b&p3=c"
            fileName,    //上传文件的名称，类似<input type=file 的value
            0    //与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
        );
        result = trim(result);
        document.all("statusBar").innerHTML = "服务器返回信息:" + result;
        alert(result);
        window.close();
    }
}
function saveFileAsHtmlToUrl() {
    var myUrl = "upLoadHtmlFile.jsp";
    var htmlFileName = document.all("fileName").value + ".html";
    var result;
    if (IsFileOpened) {
        result = OFFICE_CONTROL_OBJ.PublishAsHTMLToURL("upLoadHtmlFile.jsp", "uploadHtml", "htmlFileName=" + htmlFileName, htmlFileName);
        result = trim(result);
        document.all("statusBar").innerHTML = "服务器返回信息:" + result;
        alert(result);
        window.close();
    }
}
function saveFileAsPdfToUrl() {
    var myUrl = "upLoadPdfFile.jsp";
    var pdfFileName = document.all("fileName").value + ".pdf";
    if (IsFileOpened) {
        OFFICE_CONTROL_OBJ.PublishAsPdfToURL(myUrl, "uploadPdf", "PdfFileName=" + pdfFileName, pdfFileName, "", "", true, false);
    }
}
function testFunction() {
    alert(IsFileOpened);
}
function addServerSecSign() {
    var signUrl = document.all("secSignFileUrl").options[document.all("secSignFileUrl").selectedIndex].value;
    if (IsFileOpened) {
        if (OFFICE_CONTROL_OBJ.doctype == 1 || OFFICE_CONTROL_OBJ.doctype == 2) {
            try {
                alert("正式版本用户请插入EKEY！\r\n\r\n此为电子印章系统演示功能，请购买正式版本！");
                OFFICE_CONTROL_OBJ.AddSecSignFromURL("ntko", signUrl);
            }
            catch (error) {
            }
        }
        else {
            alert("不能在该类型文档中使用安全签名印章.");
        }
    }
}
function addLocalSecSign() {
    if (IsFileOpened) {
        if (OFFICE_CONTROL_OBJ.doctype == 1 || OFFICE_CONTROL_OBJ.doctype == 2) {
            try {
                OFFICE_CONTROL_OBJ.AddSecSignFromLocal("ntko", "");
            }
            catch (error) {
            }
        }
        else {
            alert("不能在该类型文档中使用安全签名印章.");
        }
    }
}
function addEkeySecSign() {
    if (IsFileOpened) {
        if (OFFICE_CONTROL_OBJ.doctype == 1 || OFFICE_CONTROL_OBJ.doctype == 2) {
            try {
                OFFICE_CONTROL_OBJ.AddSecSignFromEkey("ntko");
            }
            catch (error) {
            }
        }
        else {
            alert("不能在该类型文档中使用安全签名印章.");
        }
    }
}
function addHandSecSign() {
    if (IsFileOpened) {
        if (OFFICE_CONTROL_OBJ.doctype == 1 || OFFICE_CONTROL_OBJ.doctype == 2) {
            try {
                OFFICE_CONTROL_OBJ.AddSecHandSign("ntko");
            }
            catch (error) {
            }
        }
        else {
            alert("不能在该类型文档中使用安全签名印章.");
        }
    }
}

function addServerSign(signUrl) {
    if (IsFileOpened) {
        try {
            OFFICE_CONTROL_OBJ.AddSignFromURL("ntko",//印章的用户名
                signUrl,//印章所在服务器相对url
                100,//左边距
                100,//上边距 根据Relative的设定选择不同参照对象
                "ntko",//调用DoCheckSign函数签名印章信息,用来验证印章的字符串
                3,  //Relative,取值1-4。设置左边距和上边距相对以下对象所在的位置 1：光标位置；2：页边距；3：页面距离 4：默认设置栏，段落
                100,//缩放印章,默认100%
                1);   //0印章位于文字下方,1位于上方

        }
        catch (error) {
        }
    }
}

function addLocalSign() {
    if (IsFileOpened) {
        try {
            OFFICE_CONTROL_OBJ.AddSignFromLocal("ntko",//印章的用户名
                "",//缺省文件名
                true,//是否提示选择
                100,//左边距
                100,//上边距 根据Relative的设定选择不同参照对象
                "ntko",//调用DoCheckSign函数签名印章信息,用来验证印章的字符串
                3,  //Relative,取值1-4。设置左边距和上边距相对以下对象所在的位置 1：光标位置；2：页边距；3：页面距离 4：默认设置栏，段落
                100,//缩放印章,默认100%
                1);   //0印章位于文字下方,1位于上方
        }
        catch (error) {
        }
    }
}
function addPicFromUrl(picURL) {
    if (IsFileOpened) {
        if (OFFICE_CONTROL_OBJ.doctype == 1 || OFFICE_CONTROL_OBJ.doctype == 2) {
            try {
                OFFICE_CONTROL_OBJ.AddPicFromURL(picURL,//图片的url地址可以时相对或者绝对地址
                    false,//是否浮动,此参数设置为false时,top和left无效
                    100,//left 左边距
                    100,//top 上边距 根据Relative的设定选择不同参照对象
                    1,  //Relative,取值1-4。设置左边距和上边距相对以下对象所在的位置 1：光标位置；2：页边距；3：页面距离 4：默认设置栏，段落
                    100,//缩放印章,默认100%
                    1);   //0印章位于文字下方,1位于上方

            }
            catch (error) {
            }
        }
        else {
            alert("不能在该类型文档中使用安全签名印章.");
        }
    }
}
function addPicFromLocal() {
    if (IsFileOpened) {
        try {
            OFFICE_CONTROL_OBJ.AddPicFromLocal("",//印章的用户名
                true,//缺省文件名
                false,//是否提示选择
                100,//左边距
                100,//上边距 根据Relative的设定选择不同参照对象
                1,  //Relative,取值1-4。设置左边距和上边距相对以下对象所在的位置 1：光标位置；2：页边距；3：页面距离 4：默认设置栏，段落
                100,//缩放印章,默认100%
                1);   //0印章位于文字下方,1位于上方
        }
        catch (error) {
        }
    }
}

function TANGER_OCX_AddDocHeader(strHeader) {
    if (!IsFileOpened) {
        return;
    }
    var i, cNum = 30;
    var lineStr = "";
    try {
        for (i = 0; i < cNum; i++) lineStr += "_";  //生成下划线
        with (OFFICE_CONTROL_OBJ.ActiveDocument.Application) {
            Selection.HomeKey(6, 0); // go home
            Selection.TypeText(strHeader);
            Selection.TypeParagraph(); 	//换行
            Selection.TypeText(lineStr);  //插入下划线
            // Selection.InsertSymbol(95,"",true); //插入下划线
            Selection.TypeText("★");
            Selection.TypeText(lineStr);  //插入下划线
            Selection.TypeParagraph();
            //Selection.MoveUp(5, 2, 1); //上移两行，且按住Shift键，相当于选择两行
            Selection.HomeKey(6, 1);  //选择到文件头部所有文本
            Selection.ParagraphFormat.Alignment = 1; //居中对齐
            with (Selection.Font) {
                NameFarEast = "宋体";
                Name = "宋体";
                Size = 12;
                Bold = false;
                Italic = false;
                Underline = 0;
                UnderlineColor = 0;
                StrikeThrough = false;
                DoubleStrikeThrough = false;
                Outline = false;
                Emboss = false;
                Shadow = false;
                Hidden = false;
                SmallCaps = false;
                AllCaps = false;
                Color = 255;
                Engrave = false;
                Superscript = false;
                Subscript = false;
                Spacing = 0;
                Scaling = 100;
                Position = 0;
                Kerning = 0;
                Animation = 0;
                DisableCharacterSpaceGrid = false;
                EmphasisMark = 0;
            }
            Selection.MoveDown(5, 3, 0); //下移3行
        }
    }
    catch (err) {
        alert("错误：" + err.number + ":" + err.description);
    }
    finally {
    }
}

function insertRedHeadFromUrl(headFileURL) {
    if (OFFICE_CONTROL_OBJ.doctype != 1)//OFFICE_CONTROL_OBJ.doctype=1为word文档
    {
        return;
    }
    OFFICE_CONTROL_OBJ.ActiveDocument.Application.Selection.HomeKey(6, 0);//光标移动到文档开头
    OFFICE_CONTROL_OBJ.addtemplatefromurl(headFileURL);//在光标位置插入红头文档
}
function openTemplateFileFromUrl(templateUrl) {
    OFFICE_CONTROL_OBJ.openFromUrl(templateUrl);
}
function doHandSign() {
    /*if(OFFICE_CONTROL_OBJ.doctype==1||OFFICE_CONTROL_OBJ.doctype==2)//此处设置只允许在word和excel中盖章.doctype=1是"word"文档,doctype=2是"excel"文档
     {*/
    OFFICE_CONTROL_OBJ.DoHandSign2(
        "ntko",//手写签名用户名称
        "ntko",//signkey,DoCheckSign(检查印章函数)需要的验证密钥。
        0,//left
        0,//top
        1,//relative,设定签名位置的参照对象.0：表示按照屏幕位置插入，此时，Left,Top属性不起作用。1：光标位置；2：页边距；3：页面距离 4：默认设置栏，段落（为兼容以前版本默认方式）
        100);
    //}
}
function SetReviewMode(boolvalue) {
    if (OFFICE_CONTROL_OBJ.doctype == 1) {
        OFFICE_CONTROL_OBJ.ActiveDocument.TrackRevisions = boolvalue;//设置是否保留痕迹
    }
}

function setFilePrint(boolvalue) {
    OFFICE_CONTROL_OBJ.fileprint = boolvalue;//是否允许打印
}
function setFileNew(boolvalue) {
    OFFICE_CONTROL_OBJ.FileNew = boolvalue;//是否允许新建
}
function setFileSaveAs(boolvalue) {
    OFFICE_CONTROL_OBJ.FileSaveAs = boolvalue;//是否允许另存为
}

function setIsNoCopy(boolvalue) {
    OFFICE_CONTROL_OBJ.IsNoCopy = boolvalue;//是否禁止粘贴
}
//验证文档控件自带印章功能盖的章
function DoCheckSign() {
    if (IsFileOpened) {
        var ret = OFFICE_CONTROL_OBJ.DoCheckSign
        (
            false, /*可选参数 IsSilent 缺省为FAlSE，表示弹出验证对话框,否则，只是返回验证结果到返回值*/
            "ntko"//使用盖章时的signkey,这里为"ntko"
        );//返回值，验证结果字符串
        //alert(ret);
    }
}
//设置工具栏
function setToolBar() {
    OFFICE_CONTROL_OBJ.ToolBars = !OFFICE_CONTROL_OBJ.ToolBars;
}
//控制是否显示所有菜单
function setMenubar() {
    OFFICE_CONTROL_OBJ.Menubar = !OFFICE_CONTROL_OBJ.Menubar;
}
//控制”插入“菜单栏
function setInsertMemu() {
    OFFICE_CONTROL_OBJ.IsShowInsertMenu = !OFFICE_CONTROL_OBJ.IsShowInsertMenu;
}
//控制”编辑“菜单栏
function setEditMenu() {
    OFFICE_CONTROL_OBJ.IsShowEditMenu = !OFFICE_CONTROL_OBJ.IsShowEditMenu;
}
//控制”工具“菜单栏
function setToolMenu() {
    OFFICE_CONTROL_OBJ.IsShowToolMenu = !OFFICE_CONTROL_OBJ.IsShowToolMenu;
}

//自定义菜单功能函数
function initCustomMenus() {
    var myobj = OFFICE_CONTROL_OBJ;

    for (var menuPos = 0; menuPos < 3; menuPos++) {
        myobj.AddCustomMenu2(menuPos, "菜单" + menuPos + "(&" + menuPos + ")");
        for (var submenuPos = 0; submenuPos < 10; submenuPos++) {
            if (1 == (submenuPos % 3)) //主菜单增加分隔符。第3个参数是-1是在主菜单增加
            {
                myobj.AddCustomMenuItem2(menuPos, submenuPos, -1, false, "-", true);
            }
            else if (0 == (submenuPos % 2)) //主菜单增加子菜单，第3个参数是-1是在主菜单增加
            {
                myobj.AddCustomMenuItem2(menuPos, submenuPos, -1, true, "子菜单" + menuPos + "-" + submenuPos, false);
                //增加子菜单项目
                for (var subsubmenuPos = 0; subsubmenuPos < 9; subsubmenuPos++) {
                    if (0 == (subsubmenuPos % 2))//增加子菜单项目
                    {
                        myobj.AddCustomMenuItem2(menuPos, submenuPos, subsubmenuPos, false,
                            "子菜单项目" + menuPos + "-" + submenuPos + "-" + subsubmenuPos, false, menuPos * 100 + submenuPos * 20 + subsubmenuPos);
                    }
                    else //增加子菜单分隔
                    {
                        myobj.AddCustomMenuItem2(menuPos, submenuPos, subsubmenuPos, false,
                            "-" + subsubmenuPos, true);
                    }
                    //测试禁用和启用
                    if (2 == (subsubmenuPos % 4)) {
                        myobj.EnableCustomMenuItem2(menuPos, submenuPos, subsubmenuPos, false);
                    }
                }
            }
            else //主菜单增加项目，第3个参数是-1是在主菜单增加
            {
                myobj.AddCustomMenuItem2(menuPos, submenuPos, -1, false, "菜单项目" + menuPos + "-" + submenuPos, false, menuPos * 100 + submenuPos);
            }

            //测试禁用和启用
            if (1 == (submenuPos % 4)) {
                myobj.EnableCustomMenuItem2(menuPos, submenuPos, -1, false);
            }
        }
    }
}
