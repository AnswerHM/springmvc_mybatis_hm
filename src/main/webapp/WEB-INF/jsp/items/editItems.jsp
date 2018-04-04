<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springmvc test 查询修改页</title>
<script type="text/javascript">
	function deleteItems(){
		// 提交form
		document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action";
		document.itemsForm.submit();
	}
	function queryItems(){
		// 提交form
		document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
	<form name="itemsForm" action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="POST" enctype="multipart/form-data"> 
		<input type="hidden" name="id" value="${itemsCustom.id }" />
		修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name" value="${itemsCustom.name }"/></td>
			</tr>
			<tr>
				<td>商品价格：</td>
				<td><input type="text" name="price" value="${itemsCustom.price }"/></td>
			</tr>
			<tr>
				<td>商品日期：</td>
				<td><input type="text" name="createTime" value="<fmt:formatDate value="${itemsCustom.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
			</tr>
			<tr>
				<td>商品图片：</td>
				<td>
					<c:if test="${itemsCustom.pic != null }">
						<img alt="图片信息" src="/pic/${itemsCustom.pic }" width=100 heigth=100 />
						<br/>
					</c:if>
					<input type="file" name="items_pic">
				</td>
			</tr>
			<tr>
				<td>商品描述：</td>
				<td><textarea rows="3" cols="3" name="detail" >${itemsCustom.detail }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>