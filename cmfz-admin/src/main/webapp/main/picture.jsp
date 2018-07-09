<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 2018/7/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $('#dg').datagrid({
            url:"${pageContext.request.contextPath}/picture/showPicture",
            columns:[[
                {field:'pictureId',title:'标识编号',width:130},
                {field:'picturePath',title:'文件名',width:130},
                {field:'pictureDesc',title:'描述信息',width:100},
                {field:'pictureStatus',title:'轮播图状态',width:100,
                    styler: function(value,row,index){
                    if (value=="展示中"){
                        return 'color:green;font-weight:600';
                    }
                }},
                {field:'pictureDate',title:'轮播图创建时间',width:110,sortable:true},
                {field:"opt",title:'操作',width:60,formatter:function(value, row, index){
                    var opt = "<a name='mf'></a>"
                    return opt;
                }},
            ]],
            onLoadSuccess:function(data){
                $("a[name='mf']").linkbutton({
                    text:'修改',
                    iconCls:'icon-edit',

                    onClick:function(){
                        alert("修改！");
                    }
                })
            },
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
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/lunbo/' + rowData.picturePath + '" style="height:100px;width:120px"></td>' +
                        '<td style="border:0">' + '<p style="margin-left:10px"><span style="color:#600000;font-weight:600">描述: </span>' + rowData.pictureDesc + '</p>' +  '<p style="margin-left:10px"><span style="color:#600000;font-weight:600">状态: </span>' + rowData.pictureStatus + '</p>' +  '</td>' +
                    '</tr></table>';
            },
            toolbar:[{
                text:'新增轮播图',
                iconCls:'icon-add',
                handler:function(){
                    $('#dl').dialog({
                        title:'新增轮播图',
                        iconCls:'icon-add',
                        width:450,
                        height:300,
                        collapsible:true,
                        minimizable:true,
                        maximizable:true,
                        closable:true,
                        resizable:true,
                        modal:true,
                        href:"${pageContext.request.contextPath}/main/addPictureForm.jsp",
                        /*onLoad:function(){
                            $('#save').linkbutton({

                            })
                        }*/
                    });
                }
            },{
                text:'帮助',
                iconCls:'icon-help',
                handler:function(){
                    alert("帮助");
                }
            }],

        });


    });
</script>


<table id="dg"></table>
<div id="dl"></div>
