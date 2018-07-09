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
        $('#save').linkbutton({
            onClick:function(){
                $('#fom').form('submit',{
                    url:"${pageContext.request.contextPath}/picture/add",
                    onSubmit:function(){
                        return $(this).form('validate');
                    },
                    success:function(res){
                        if(res=="ok"){
                            $('#dl').dialog("close");
                            $('#dg').datagrid("reload");
                            $.messager.show({
                                title:'我的消息',
                                msg:'保存成功，此消息将在5s后关闭！',
                                timeout:5000,
                                showType:'slide',
                            });
                        }else{
                            $.messager.alert('错误提示！','添加失败，请重新尝试！','error');
                        }
                    }
                })
            }
        })

        $('#cancel').linkbutton({
            onClick:function(){
                $('#dl').dialog("close");
            }
        })


    });
</script>


<form method="post" id="fom" enctype="multipart/form-data">
    <div style="text-align: center;margin-top: 40px">
        <p>轮播图描述：<input class="easyui-textbox" data-options="required:true" name="desc" style="width:200px;"></p>
        <p>轮播图状态：<select id="cc" class="easyui-combobox" data-options="editable:false" name="status" style="width:200px;">
            <option value="no" selected>不展示</option>
            <option value="yes">展示</option>
        </select><p/>
        <p>
            上传轮播图：<input class="easyui-filebox" name="pic" data-options="required:true,buttonText:'选择文件',buttonIcon:'icon-disk_upload',accept:'image/*'" style="width:200px;">
        </p><br/>
        <p>
            <a id="save" class="easyui-linkbutton" data-options="text:'保存',iconCls:'icon-film_save',required:true"></a>
            <a id="cancel" class="easyui-linkbutton" data-options="text:'取消',iconCls:'icon-cancel',required:true" style="margin-left: 20px"></a>
        </p>

    </div>
</form>