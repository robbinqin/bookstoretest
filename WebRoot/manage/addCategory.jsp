<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<h3>当前位置：添加分类</h3>
<form
	action="${pageContext.request.contextPath}/manage/ManageServlet?op=addCategory"
	method="post">
	<table border="1" width="438">
		<tr>
			<td>分类名称：</td>
			<td>
				<input type="text" name="name" id="name" /><span id="sname"></span>
			</td>
		</tr>
		<tr>
			<td>描述：</td>
			<td>
				<textarea rows="3" cols="60" name="description"></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" value="添加" />
</form>
<script type="text/javascript">
windows.onload=function(){
	document.getElementById("name").onblur=function(){
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("sname").innerHTML=xhr.respnoseText;
				}
			}
		}
		var nameValue=encodeURI(this.value);
		xhr.open("GET","${pageContext.request.ContextPath}/manage/ManageServlet?op=checkCategory&Name="+nameValue+"&time="+new Data().getTime());
		xhr.send(null);
	}
}
</script>
</body>
</html>
