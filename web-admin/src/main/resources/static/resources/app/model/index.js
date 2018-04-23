/**
 * Created by Shadow on 2018/04/18.
 * index页面aJax方法
 */
var $myTableObj = $("#myTable");
var $processDefinitionTable = $("#processDefinitionTable");

$.get("http://192.168.1.128:8010/activiti/models/getModels",{token:123},function(data) {
    var tpl = document.getElementById("testTemplate").innerHTML;
    var res = window.template(tpl,{result:data.resultData.list});
    $("#myTable").append($(res));
});

var getProcessDefinitionData = function() {
    $.get("http://192.168.1.128:8010/activiti/deployments/getDeployments",{token:1},function(data) {
        var tpl = document.getElementById("processDefinitionTemplate").innerHTML;
        var res = window.template(tpl,{result:data.resultData.list});
        var $processDefinitionObj =  $("#processDefinitionTable");
        $processDefinitionObj.find("tr:gt(0)").remove();
        $processDefinitionObj.append($(res));
    });
};

getProcessDefinitionData();

//新增一个模型
$("#addModel").click(function() {
    $.get("http://192.168.1.128:8010/activiti/models/createModel",{token:123},function(data) {
        console.log(data);
        window.location.href = "http://192.168.1.128:8080/modeler/modeler.html?modelId=" + data.id;
    })
});
//删除一个模型
$myTableObj.on("click",".delete-model",function() {
    var $thisObj = $(this);
    $.get("http://192.168.1.128:8010/activiti/models/deleteOne/" + $thisObj.attr("data") + "?token=123",function(data) {
        console.log(data);
        $thisObj.parents("tr").remove();
    });
});
//部署一个模型
$myTableObj.on("click",".deploy-model",function() {
    var $thisObj = $(this);
    $.post("http://192.168.1.128:8010/activiti/models/" + $thisObj.attr("data") + "/deployment?token=1",function(data) {
        console.log(data);
        getProcessDefinitionData();
    });
});

//删除一个流程定义
$processDefinitionTable.on("click",".delete-processDefinition",function() {
    var $thisObj = $(this);
    $.get("http://192.168.1.128:8010/activiti/deployments/deleteOne/" + $thisObj.attr("data") + "?token=123",function(data) {
        if(data.sucess === "true") {
            $thisObj.parents("tr").remove();
        } else {
            alert("");
        }
    });
});