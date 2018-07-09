<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 2018/7/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function(){
        $('#dg2').datagrid({
            url:"${pageContext.request.contextPath}/master/searchByPage",
            columns:[[
                {field:'masterId',title:'上师编号',width:130},
                {field:'masterName',title:'法名',width:100},
                {field:'masterPhoto',title:'头像路径',width:120},
                {field:'masterIntro',title:'上师简介',width:10,hidden:true},
            ]],
            fit:true,
            pagination:true,
            pageSize:20,
            pageList:[5,10,20,50],
            fitColumns:true,
            striped:true,
            singleSelect:true,
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/master/' + rowData.masterPhoto + '" style="height:100px;width:120px"></td>' +
                        '<td style="border:0">' + '<p style="margin-left:10px">法名:<span style="color:red;font-weight:600"> ' + rowData.masterName + '</span></p>' +  '<p style="margin-left:10px"><span style="color:#600000;font-weight:600;font-size:13px">上师简介: </span>' + rowData.masterIntro + '</p>' +  '</td>' +
                    '</tr></table>';
            },
            toolbar:'#tb',
        });

        
    });

    //添加
    function add(){
        $('#dl2').dialog({
            title:'添加上师',
            iconCls:'icon-add',
            width:450,
            height:300,
            resizable:true,
            collapsible:true,
            minimizable:true,
            maximizable:true,
            closable:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/master/addMasterForm.jsp"
        })
    }

    //修改
    function edit(){
        var selectedItem = $('#dg2').datagrid('getSelected');
        if(selectedItem==null){
            $.messager.alert('提示信息','请选择您要修改的上师！','error');
            return;
        }
        $('#dl5').dialog({
            title:'修改上师'+selectedItem.masterName+'的信息',
            iconCls:'icon-edit',
            width:450,
            height:300,
            resizable:true,
            collapsible:true,
            minimizable:true,
            maximizable:true,
            closable:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/master/editMasterForm.jsp",
            onLoad:function(){
                $('#fom5').form('load', selectedItem);
            }
        })
    }

    //导入
    function batchAdd(){
        $('#dl3').dialog({
            title:'请选择Excel文件',
            iconCls:'icon-group_add',
            width:350,
            height:200,
            resizable:true,
            collapsible:true,
            minimizable:true,
            maximizable:true,
            closable:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/master/batchAddMasterForm.jsp"
        })
    }

    //导出Excel
    function exportExcel(){
        location.href="${pageContext.request.contextPath}/master/export";
    }

    //搜索
    function qq(value) {
        $('#dg2').datagrid({
            queryParams:{
                keywords:value
            },
            url:"${pageContext.request.contextPath}/master/searchByPage",
        })
    }
</script>


<table id="dg2"></table>
<div id="dl2"></div>
<div id="dl3"></div>
<div id="dl5"></div>

<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'" onclick="add()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-disk_download',plain:true,iconAlign:'left',text:'批量导入'," onclick="batchAdd()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-disk_upload',plain:true,text:'导出Excel'" onclick="exportExcel()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'" onclick="edit()"></a>

    <div style="float: right;margin-right: 20px;">
        <input id="ss" class="easyui-searchbox" style="width:300px;height: 25px;" data-options="searcher:qq,prompt:'请输入关键字...',menu:'#mm'">
        <div id="mm" style="width:120px;">
            <div data-options="name:'name',iconCls:'icon-ok'">法名</div>
        </div>
    </div>

</div>
