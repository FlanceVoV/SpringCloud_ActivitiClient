<!doctype html>
<html >
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<body>
    <h1 align="center">模型列表</h1>
    <p align="center">
        <button type="button" id="addModel">新增模型</button>
    </p>
    <table cellspacing="0" cellpadding="5" align="center" id="myTable" border="1">
        <tr>
            <th>id</th>
            <th>模型名</th>
            <th>关键字</th>
            <th>操作</th>
        </tr>
    </table>

    <h1 align="center">流程定义列表</h1>
    <table cellspacing="0" cellpadding="5" align="center" id="processDefinitionTable" border="1">
        <tr>
            <th>id</th>
            <th>流程名</th>
            <th>操作</th>
        </tr>
    </table>

    <script type="text/html" id="testTemplate">
        <#-- 模型列表 -->
        <%
            var i = 0;
            for ( i; i < result.length; i++) {
        %>
            <tr>
                <td><%:=result[i].id%></td>
                <td><%:=result[i].name%></td>
                <td><%:=result[i].key%></td>
                <td>
                    <a href="http://192.168.1.128:8080/modeler/modeler.html?modelId=<%:=result[i].id%>">编辑</a>&nbsp;&nbsp;
                    <a href="javascript:" class="delete-model" data="<%:=result[i].id%>">删除</a>&nbsp;&nbsp;
                    <a href="javascript:" class="deploy-model" data="<%:=result[i].id%>">部署</a>
                </td>
            </tr>
        <%
            }
        %>
    </script>

    <script type="text/html" id="processDefinitionTemplate">
        <#-- 流程定义列表 -->
        <%
        var i = 0;
        for ( i; i < result.length; i++) {
        %>
        <tr>
            <td><%:=result[i].id%></td>
            <td><%:=result[i].name%></td>
            <td>
                <a href="javascript:" class="delete-processDefinition" data="<%:=result[i].id%>">删除</a>&nbsp;&nbsp;
            </td>
        </tr>
        <%
        }
        %>
    </script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="http://192.168.1.128:8080/resources/plugin/template/template.js"></script>
    <script type="text/javascript" src="http://192.168.1.128:8080/resources/app/model/index.js"></script>

</body>
</html>