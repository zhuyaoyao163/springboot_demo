<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/webjarslocator/bootstrap/bootstrap.min.css">
</head>
<body style="padding: 20px;">
<div class = "col-xs-12 col-sm-6 col-md-4 col-lg-3">
    <form role = "form">
        <div class = "form-group">
            <label for = "name">姓名</label>
            <input type = "text" class = "form-control" id = "name"
                   placeholder = "请输入姓名"></input>
        </div>
        <div class = "form-group">
            <label for = "tel">电话号码</label>
            <input type="text" class="form-control" id = "tel"
                   placeholder = "请输入您的电话号码"></input>
        </div>
        <div class = "form-group">
            <label for = "idCard">请上传身份证</label>
            <input type = "file" id = "idCard"></input>
        </div>
        <div class = "form-group">
            <label for = "profession">选择省份</label>
            <select id = "profession" class = "form-control">
                <#list areas as area>
                    <option value="${area.areaCode}">${area.areaName}</option>
                </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "profession">职业</label>
            <select id = "profession" class = "form-control">
                <option>软件工程师</option>
                <option>测试工程师</option>
                <option>硬件工程师</option>
                <option>质量分析师</option>
            </select>
        </div>
        <div class="form-group">
            <button type = "submit" class="btn-info btn-lg">提交</button>
        </div>
    </form>
</div>
</body>
</html>