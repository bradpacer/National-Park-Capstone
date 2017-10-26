<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Survey Results" />
</c:import>

<div class="container">

	<h2>Park Survey Results</h2>
	<p class="lead">Thanks for sharing! Here are the all-time most popular parks:</p>
	<c:if test="${topParks.size() == 0}">
		<p>oops</p>
	</c:if>
	
	<c:set var="rank" value="1"/>
	
	<c:forEach var="park" items="${topParks}">
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
					<a href="${parkUrl}"><c:out value="${rank}"/>) <c:out value="${park.name}" />
					</a>
				</h2>
				<p class="lead text-success font-weight-bold"><c:out value="${park.numberOfSurveys}"/> votes!</p>
				<p><c:out value="${park.description}" /></p>
			</div>
		</div>
		<hr>
		<c:set var="rank" value="${rank + 1}"/>
	</c:forEach>
	
</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp"></c:import>