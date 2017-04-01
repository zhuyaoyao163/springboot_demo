<#-- 取得 应用的绝对根路径 -->
<#assign basePath=request.contextPath>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/webjarslocator/bootstrap/bootstrap.min.css">
    <script src="/webjarslocator/jquery/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body style="padding: 20px;">
<div class = "col-xs-12 col-sm-6 col-md-4 col-lg-3">
    <form role = "form" id="pageForm" method="post" action="${basePath}/carCondition/addCheckOrder" >
        <div class = "form-group">
            <label for = "carNo">车号</label>
            <input type = "text" class = "form-control" id = "carNo" name = "carNo"
                   placeholder = "请输入车号"></input>
        </div>
        <div class = "form-group">
            <label for = "importance">重要度</label>
            <select id = "importance" name = "importance"  class = "form-control">
            <#list IMPORTANCE_LIST as importance>
                <option value="${importance.code}">${importance.desc}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "frequency">频次</label>
            <input type="text" class="form-control" id = "frequency" name = "frequency"
                   placeholder = "请输入频次"></input>
        </div>
        <div class = "form-group">
            <label for = "foldingFrequency">折频次</label>
            <input type="text" class="form-control" id = "foldingFrequency" name = "foldingFrequency"
                   placeholder = "请输入折频次"></input>
        </div>
        <div class = "form-group">
            <label for = "resDepartmentId">责任工位</label>
            <select id = "resDepartmentId" name = "resDepartmentId" class = "form-control"  onchange="initPage();">
            <#list departments as department>
                <option <#if defaultDepartment.id == department.id> selected="selected" </#if> value="${department.id}">${department.departmentName}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "resUserId">责任人</label>
            <select id = "resUserId" name = "resUserId" class = "form-control">
            <#list defaultUsers as user>
                <option value="${user.id}">${user.userName}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "resDepartmentLeaderId">责任工位长</label>
            <select id = "resDepartmentLeaderId" name = "resDepartmentLeaderId" class = "form-control">
                <option selected="selected" value="${defaultLeader.id}">${defaultLeader.userName}</option>
            </select>
        </div>
        <div class = "form-group">
            <label for = "process">发生过程</label>
            <select id = "process" name = "process" class = "form-control">
            <#list PROCESS_LIST as process>
                <option value="${process.code}">${process.desc}</option>
            </#list>
            </select>
        </div>

        <div class = "form-group">
            <label for = "defect">缺陷类别</label>
            <select id = "defect" name = "defect" class = "form-control">
            <#list DEFECT_LIST as defect>
                <option value="${defect.code}">${defect.desc}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "checkNum">台数</label>
            <input type="text" class="form-control" id = "checkNum" name = "checkNum"
                   placeholder = "请输入台数"></input>
        </div>
        <div class = "form-group">
            <label for = "defectDesc">缺陷描述</label>
            <input type="text" class="form-control" id = "defectDesc" name = "defectDesc" rows="3" ></input>
        </div>
        <div class = "form-group">
            <label for = "idCard">请上传身份证</label>
            <input type = "button" id = "idCard" class="btn btn-link" onclick="chooseImage();"></input>
        </div>
        <div class="form-group">
            <button type = "submit" class="btn-info btn-lg">提交</button>
        </div>
        <input type="hidden" id="appId" value="${jssdk.appId}">
        <input type="hidden" id="timestamp" value="${jssdk.timestamp}">
        <input type="hidden" id="nonceStr" value="${jssdk.nonceStr}">
        <input type="hidden" id="signature" value="${jssdk.signature}">
    </form>
</div>
</body>
<script type="text/javascript">

    var appId = $("#appId").val();
    var timestamp = $("#timestamp").val();
    var nonceStr = $("#nonceStr").val();
    var signature = $("#signature").val();
    wx.config({
        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: appId, // 必填，公众号的唯一标识
        timestamp: timestamp, // 必填，生成签名的时间戳
        nonceStr: nonceStr, // 必填，生成签名的随机串
        signature: signature,// 必填，签名，见附录1
        jsApiList: ['chooseImage','uploadImage','previewImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    function chooseImage() {
        wx.chooseImage({
            count: 9, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                uploadImage(localIds);
            }
        });
    }
    function uploadImage(localIds) {
        var arr = new Array();
        var serverArr = new Array();
        if (localIds instanceof Array) {
            arr = localIds;
        } else {
            arr[0] = localIds;
        }
        for (var i = 0;i<arr.length; i++){
            wx.uploadImage({
                localId: arr[i], // 需要上传的图片的本地ID，由chooseImage接口获得
                isShowProgressTips: 1, // 默认为1，显示进度提示
                success: function (res) {
                    var serverId = res.serverId; // 返回图片的服务器端ID

                    var param = {"serverId" : serverId};
                    var url = $("#pageForm").attr('action');
                    url = url.substring(0,url.lastIndexOf("/") + 1) + "downLoadImage";
                    $.ajax({
                        type: 'post',
                        url: url,
                        data: param,
                        dataType: "json",
                        success: function(data){
                            if(data.code == 1){
                                alert(data.msg);
                            }
                        },
                        fail: function (data) {
                            alert(data.msg);
                        }
                    });

                }
            });
        }


    }
    function initPage(){
        var url = $("#pageForm").attr('action');
        url = url.substring(0,url.lastIndexOf("/") + 1) + "initPage";
        var id = $("#resDepartmentId").val();
        param = {"id":id };
        $.ajax({
            type: 'post',
            url: url,
            data: param,
            dataType: "json",
            success: function(data) {
                if(data.code == 1) {
                    var departmentVo = data.data;
                    var users = departmentVo.users;
                    $("#resUserId").empty();
                    var option = null;
                    for (var i = 0 ; i < users.length ; i++){
                        option = $("<option>").val(users[i].id).text(users[i].userName);
                        $("#resUserId").append(option);
                    }
                    $("#resDepartmentLeaderId").empty();
                    option = $("<option>").val(departmentVo.department.departmentLeaderId).text(departmentVo.departmentLeaderName);
                    $("#resDepartmentLeaderId").append(option);
                }
            },
            fail:function (data) {
                alert(data.msg);
            }
        });
    }
</script>
</html>