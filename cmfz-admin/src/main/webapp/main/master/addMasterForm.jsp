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
        $('#save2').linkbutton({
            onClick:function(){
                $('#fom3').form('submit',{
                    url:"${pageContext.request.contextPath}/master/add",
                    onSubmit:function(){
                        return $(this).form('validate');
                    },
                    success:function(res){
                        if(res=="ok"){
                            $('#dl2').dialog("close");
                            $('#dg2').datagrid("reload");
                            $.messager.show({
                                title:'我的消息',
                                msg:'保存成功，此消息将在5s后关闭！',
                                timeout:5000,
                                showType:'slide',
                            });
                        }else{
                            $.messager.alert('错误提示！','保存失败，请重新尝试！','error');
                        }
                    }
                })
            }
        })

        $('#cancel2').linkbutton({
            onClick:function(){
                $('#dl2').dialog("close");
            }
        })


    });
</script>


<form method="post" id="fom3" enctype="multipart/form-data">
    <div style="text-align: center;margin-top: 40px">
        <p>法&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input class="easyui-textbox"  data-options="required:true" name="masterName" style="width:200px;"></p>
        <p>
            上师头像：<input class="easyui-filebox" name="photo" data-options="required:true,buttonText:'选择文件',buttonIcon:'icon-disk_upload',  accept:'image/*'" style="width:200px;">
        </p>
        <p>上师简介：<input class="easyui-textbox" data-options="multiline:true,width:200,height:60" name="masterIntro"><p/>
        <br/>
        <p>
            <a id="save2" class="easyui-linkbutton" data-options="text:'保存',iconCls:'icon-film_save',required:true"></a>
            <a id="cancel2" class="easyui-linkbutton" data-options="text:'取消',iconCls:'icon-cancel',required:true" style="margin-left: 20px"></a>
        </p>

    </div>
</form>