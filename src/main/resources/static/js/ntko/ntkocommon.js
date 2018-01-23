/**
 * 设置不修改的书签的内容
 * @constructor
 */
function PartProtect() {
    OFFICE_CONTROL_OBJ.Activedocument.Application.Selection.Goto(-1, 0, 0, "BID_PRICE_TABLE"); //定位书签
    OFFICE_CONTROL_OBJ.Activedocument.Application.Selection.Editors.Add(-1);  //selection代表非保护区的位置 wdEditorEveryone =-1
    OFFICE_CONTROL_OBJ.Activedocument.Protect(1, true, "123");   //密码设为：123，保护区只读
    // setShowRevisions(true);
}

/**
 * 是否设置痕迹保留
 * @param boolvalue
 * @constructor
 */
function setShowRevisions(boolevalue) {
    OFFICE_CONTROL_OBJ.ActiveDocument.TrackRevisions = true;

    if (OFFICE_CONTROL_OBJ.DocType == 1) {
        OFFICE_CONTROL_OBJ.ActiveDocument.ShowRevisions = boolevalue;//设置是否显示痕迹
    }
}

/**
 * 将不保护文档的底色去掉
 */
function deleteShade() {
    skipWordHead();
    var doc = OFFICE_CONTROL_OBJ.ActiveDocument;
    //去掉底纹 或者控件对象.ActiveDocument.FormFields.Shaded=false
    doc.ActiveWindow.View.ShadeEditableRanges = false;
}

/**
 * 跳转到文档开头
 */
function skipWordHead(){
    var doc = OFFICE_CONTROL_OBJ.ActiveDocument;
    var sel = doc.Application.Selection;
    // 跳转到文档开头
    sel.HomeKey(6);
}

/**
 * Auth:Easong
 * 设置文档部分保护
 * @param bookMarkName
 */
function doProtect(bookMarkName) {
    // 获取文档对象
    var doc = OFFICE_CONTROL_OBJ.ActiveDocument;
    var sel = doc.Application.Selection;
    var sBegin = 0;

    // 获取书签开始Range
    var bStart = doc.Bookmarks.Item(bookMarkName).Range.Start;
    // 获取书签结束Range
    var bEnd = doc.Bookmarks.Item(bookMarkName).Range.End;
    // 选择文档到尾部
    sel.Endkey(6);
    docEnd = sel.Start;

    sel.SetRange(sBegin, bStart);
    sel.Editors.Add(-1);

    sel.SetRange(bEnd, docEnd);
    sel.Editors.Add(-1);
    // 3：只读
    doc.Protect(3, 0, "jdcg$810");
    // 底色去掉
    deleteShade();
}

function TANGER_OCX_DoPaiBan(URL) {
    try {
        //选择对象当前文档的所有内容
        var curSel = OFFICE_CONTROL_OBJ.ActiveDocument.Application.Selection;
        //TANGER_OCX_SetMarkModify(false);
        curSel.WholeStory();
        curSel.Cut();
        //插入模板
        OFFICE_CONTROL_OBJ.AddTemplateFromURL(URL);
        var BookMarkName = "BID_PRICE_TABLE";
        if (!OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks.Exists(BookMarkName)) {
            alert("Word 模板中不存在名称为：\"" + BookMarkName + "\"的书签！");
            return;
        }
        var bkmkObj = OFFICE_CONTROL_OBJ.ActiveDocument.BookMarks(BookMarkName);
        var saverange = bkmkObj.Range;
        saverange.Paste();
        OFFICE_CONTROL_OBJ.ActiveDocument.Bookmarks.Add(BookMarkName, saverange);
        TANGER_OCX_SetMarkModify(true);
    }
    catch (err) {
        alert("错误：" + err.number + ":" + err.description);
    }
}

/**
 * 无痕迹修改
 * @param boolvalue
 * @constructor
 */
function TANGER_OCX_SetMarkModify(boolvalue) {
    TANGER_OCX_SetReviewMode(boolvalue);
    TANGER_OCX_EnableReviewBar(!boolvalue);
}