<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" >
	$(
		function(){
			
			var currPage='${requestScope.pager.currPage}';
			var totalPages='${requestScope.pager.totalPages}';
			if(currPage==1){
				$("#prev").removeAttr("href");
			}
			
			if(currPage==totalPages){
				$("#next").removeAttr("href");
			}
			
		}	
	
	);
	
	function del(sno){
		
		if(confirm("你确认要该行记录删除吗?")){
			location.href="doDelete/"+sno;
		}
	}

</script>
</head>
<body>
		<center>
			<a href="toAdd.do">添加学生信息</a>
			<table border="1" align="center" width="80%">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>密码</th>
					<th>出生日期</th>
					<th>年级</th>
					<th>操作</th>
					
				</tr>
				<c:forEach items="${requestScope.list }" var="s" varStatus="ss">
					
					<tr
					  <c:if test="${ss.index %2==0 }">
					  	  style="background-color:gold"
					  </c:if>
					
					>
						<td>${s.sno }</td>
						<td>${s.sname }</td>
						<td>${s.spass }</td>
						<td><fmt:formatDate value="${s.birthdate }" pattern="yyyy-MM-dd"/></td>
						<td>${s.grade.gname }</td>
						<td>
						<a href="toUpdate/${s.sno }">修改</a>
						<a href="javaScript:del('${s.sno }')">删除</a>
						</td>
					</tr>
				</c:forEach>
				
			
			</table>
			<a href="getAll.do?currPage=1">首页</a>
			&nbsp;&nbsp;
			<a id="prev" href="getAll.do?currPage=${pager.currPage-1}">上一页</a>
			&nbsp;&nbsp;
			<a id="next" href="getAll.do?currPage=${pager.currPage+1}">下一页</a>
			&nbsp;&nbsp;
		    <a href="getAll.do?currPage=${pager.totalPages }">尾页</a>
			&nbsp;&nbsp;
		
		</center>
</body>
</html>