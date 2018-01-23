$(function () {
    $("#picker").css("class", "btn");
    var $list = $("#thelist");   //
    var $btn = $("#ctlBtn");   //开始上传
    var state = 'pending',
        percentLayer = null,
        percentages = {},
        fileCount = 0,
        fileSize = 0;
    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,

        // swf文件路径
        swf: contextRoot + '/js/webuploader/Uploader.swf',

        // 文件接收服务端。
        server: contextRoot + 'upload/handle.do',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id: '#picker',
            //只能选择一个文件上传
            multiple: false
        },
        accept: {
            title: 'cgw',
            extensions: 'cgw',
        },

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,

        method: 'POST'
    });

    //上传前准备
    uploader.on('beforeFileQueued', function (file) {
        if (file.ext != "cgw") {
            layer.msg("文件格式错误，只允许上传cgw格式的文件");
            return;
        }
    });

    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {
        $list.empty();
        $list.append('<div id="' + file.id + '" class="item">' +
            '<h5 class="info">' + file.name + '</h5>' +
            '<p class="state" style="color: red">等待上传...</p>' +
            '</div>');
        percentages[file.id] = [file.size, 0];
        fileCount++;
        fileSize += file.size;

    });

    $btn.on('click', function () {
        var file = uploader.getFiles();
        if (file == '' || file == null) {
            layer.msg("请选择要上传的文件");
            return;
        }
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });

    /**
     * 开始上传
     */
    uploader.on('startUpload', function () {
        openUploadDiv();
    });
    /**
     * 打开上传进度
     */
    openUploadDiv = function () {
        var html = "<div id='statuId' class='statusBar'>" +
            "<div class='progress fl'>" +
            "<span class='text'></span>" +
            "<span class='percentage' style='width:0%'></span>" +
            "</div>" +
            "<div class='info pl10 mt5 pr10'></div>" +
            "</div>";
        percentLayer = layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            shadeClose: false,
            content: html
        });
    };

    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id);
        $li.find('p.state').text('上传中...');
        /*var $li = $('#' + file.id),
         $percent = $li.find('.progress .progress-bar');

         // 避免重复创建
         if (!$percent.length) {
         $percent = $('<div class="progress progress-striped active">' +
         '<div class="progress-bar" role="progressbar" style="width: 0%">' +
         '</div>' +
         '</div>').appendTo($li).find('.progress-bar');
         }
         $li.find('p.state').text('上传中');
         $percent.css('width', percentage * 100 + '%');*/
        var $percent = $('.progress span .percentage');
        $percent.css('width', percentage * 100 + '%');
        percentages[file.id][1] = percentage;
        updateTotalProgress();
    });

    /***
     * 总进度
     */
    function updateTotalProgress() {
        var $statusBar = $('#statuId'),
            $info = $statusBar.find('.info'),
            $progress = $statusBar.find('.progress'),
            loaded = 0,
            total = 0,
            spans = $progress.children(),
            percent;
        $.each(percentages, function (k, v) {
            total += v[0];
            loaded += v[0] * v[1];
        });

        percent = total ? loaded / total : 0;
        spans.eq(0).text(Math.round(percent * 100) + '%');
        spans.eq(1).css('width', Math.round(percent * 100) + '%');
        updateStatus();
    }

    /***
     * 更新状态
     */
    function updateStatus() {
        var text = '', stats;
        stats = uploader.getStats();
        var successNum = stats.successNum + 1;
        text = '共' + fileCount + '个（' +
            WebUploader.formatSize(fileSize) +
            '），已上传' + successNum + '个';

        if (stats.uploadFailNum) {
            text += '，失败' + stats.uploadFailNum + '个';
        }
        $("#statuId .info").html(text);
    }

    /**
     * 上传成功后触发的函数
     */
    uploader.on('uploadSuccess', function (file, data) {
        $('#' + file.id).find('p.state').text('已上传');
        // 删除文件对象
        uploader.removeFile(file, true);
        // 删除队列中的文件
        $("#" + file.id).remove();
        if (data.status == 200 || data.status == 500) {
            // 获取供应商参与包
            var packages = data.data.packages;
            // 获取项目信息
            var project = data.data.project;
            var html = "<form id='packagesForm'>"
                + "<input name='projectId' type='hidden' value='" + project.id + "'/>"
                + "<table>"
                + "<tr><td th:width='80px'>选择包：</td>"
                + "<td><br/>"
            $(packages).each(function (index, package) {
                html += "<input name='name' type='checkbox' value='" + package.id + "'/><span>" + package.name + "</span><br/>"
            });
            html += "</td>"
                + "<tr><td><td/><td>"
                + "<button class='btn mb20' type='button' onclick=\"packageOpt.confirmSelect()\">确定</button>"
                + "<button class='btn mb20' type='button' onclick=\"packageOpt.cancleSelect('" + project.id + "')\">取消</button>"
                + " </td></tr>"
            html += "</table>"
            html += "</form> ";
            // 打开包
            layer.open({
                type: 1, //页面层
                area: ['420px', '200px'], //宽高
                title: '选择包',
                closeBtn: 0,
                shade: 0.01, //遮罩透明度
                moveType: 0, //拖拽风格，0是默认，1是传统拖动
                shift: 1, //0-6的动画形式，-1不开启
                offset: '160px',
                shadeClose: false,
                content: html,
            });
        } else if (data.status == 400) {
            layer.alert(data.msg);
        }
    });

    /**
     * 上传出错时的回调
     */
    uploader.on('uploadError', function (file) {
        $('#' + file.id).find('p.state').text('上传出错');
        colsePercentLayer();
    });

    /**
     * 所有文件上传成功后调用
     */
    uploader.on('uploadFinished', function () {
        fileCount = 0;
        fileSize = 0;
        colsePercentLayer();
        //清空队列
        uploader.reset();
    });

    /**
     * 关闭上传进度框
     */
    function colsePercentLayer(){
        if (percentLayer != null) {
            layer.close(percentLayer);
        }
    }
});
