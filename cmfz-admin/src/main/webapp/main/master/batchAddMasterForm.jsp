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
        $('#save3').linkbutton({
            onClick:function(){
                $('#fom4').form('submit',{
                    url:"${pageContext.request.contextPath}/master/importData",
                    onSubmit:function(){
                        return $(this).form('validate');
                    },
                    success:function(res){
                        if(res=="ok"){
                            $('#dl3').dialog("close");
                            $('#dg2').datagrid("reload");
                            $.messager.show({
                                title:'我的消息',
                                msg:'导入成功，此消息将在5s后关闭！',
                                timeout:5000,
                                showType:'slide',
                            });
                        }else{
                            $.messager.alert('错误提示！','导入失败，请重新尝试！','error');
                        }
                    }
                })
            }
        })

        $('#cancel3').linkbutton({
            onClick:function(){
                $('#dl3').dialog("close");
            }
        })


    });
</script>


<form id="fom4" method="post" enctype="multipart/form-data">
    <div style="text-align: center;margin-top: 40px">
        <P>
            <input class="easyui-filebox" name="file" data-options="required:true,buttonText:'请选择',accept:'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel'" style="width:200px;">
        </P>
        <br/>
        <p>
            <a id="save3" class="easyui-linkbutton" data-options="text:'导入',iconCls:'icon-film_save',required:true"></a>
            <a id="cancel3" class="easyui-linkbutton" data-options="text:'取消',iconCls:'icon-cancel',required:true" style="margin-left: 20px"></a>
        </p>

    </div>
</form>
