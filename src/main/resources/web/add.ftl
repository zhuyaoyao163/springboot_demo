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
            <label for = "carNo">车号</label>
            <input type = "text" class = "form-control" id = "carNo"
                   placeholder = "请输入车号"></input>
        </div>
        <div class = "form-group">
            <label for = "importance">重要度</label>
            <select id = "importance" class = "form-control">
            <#list IMPORTANCE_LIST as importance>
                <option value="${importance.code}">${importance.desc}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "frequency">频次</label>
            <input type="text" class="form-control" id = "frequency"
                   placeholder = "请输入频次"></input>
        </div>
        <div class = "form-group">
            <label for = "foldingFrequency">折频次</label>
            <input type="text" class="form-control" id = "foldingFrequency"
                   placeholder = "请输入折频次"></input>
        </div>
        <div class = "form-group">
            <label for = "profession">责任工位</label>
            <select id = "profession" class = "form-control">
            <#list areas as area>
                <option value="${area.areaCode}">${area.areaName}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "profession">责任人</label>
            <select id = "profession" class = "form-control">
            <#list areas as area>
                <option value="${area.areaCode}">${area.areaName}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "profession">责任工位长</label>
            <select id = "profession" class = "form-control">
            <#list areas as area>
                <option value="${area.areaCode}">${area.areaName}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "process">发生过程</label>
            <select id = "process" process = "form-control">
            <#list PROCESS_LIST as process>
                <option value="${process.code}">${process.desc}</option>
            </#list>
            </select>
        </div>

        <div class = "form-group">
            <label for = "defect">缺陷类别</label>
            <select id = "defect" class = "form-control">
            <#list DEFECT_LIST as defect>
                <option value="${defect.code}">${defect.desc}</option>
            </#list>
            </select>
        </div>
        <div class = "form-group">
            <label for = "tel">台数</label>
            <input type="text" class="form-control" id = "tel"
                   placeholder = "请输入台数"></input>
        </div>
        <div class = "form-group">
            <label for = "defectDesc">缺陷描述</label>
            <input type="text" class="form-control" id = "defectDesc" rows="3" ></input>
        </div>
        <div class = "form-group">
            <label for = "idCard">请上传身份证</label>
            <input type = "file" id = "idCard"></input>
        </div>
        <div class="form-group">
            <button type = "submit" class="btn-info btn-lg">提交</button>
        </div>
    </form>
</div>
</body>
</html>