<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

	<a href="add">to add</a>
	<h2>用户列表</h2>
	<table>
		<thead>
			<tr>
				<td>id</td>
				<td>phone</td>
				<td>nick</td>
				<td>email</td>
				<td></td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${users }" var="user">
				<tr>
					<td>${user.value.objectId }</td>
					<td><a href="${user.value.phone}">${user.value.phone }</a></td>
					<td>${user.value.nick }</td>
					<td>${user.value.email }</td>
					<td>
	<a href="${user.phone }/delete">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
