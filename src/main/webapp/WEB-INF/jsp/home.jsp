<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Home" />
</c:import>

<div class="container">
	<c:forEach var="park" items="${parkList}">
		<%-- begin variables --%>
		<c:url var="imageUrl" value="img/parks/${park.imageUrl}" />
		<c:url var="parkUrl" value="/park">
			<c:param name="code" value="${park.parkCode}" />
		</c:url>
		<%-- end variables --%>

		<div class="row park-row">
			<div class="col-sm-12 col-md-6">
				<a href="${parkUrl}"> <img src="${imageUrl}" class="img-fluid" />
				</a>
			</div>
			<div class="col-sm-12 col-md-6">
				<h2>
					<a href="${parkUrl}"> <c:out value="${park.name}" />
					</a>
				</h2>
				<p>
					<c:out value="${park.description}" />
				</p>
			</div>
		</div>
		<hr>
	</c:forEach>
</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp"></c:import>