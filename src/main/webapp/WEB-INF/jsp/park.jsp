<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="${park.name}" />
</c:import>

<%-- begin variables --%>
<c:url var="imageUrl" value="img/parks/${park.imageUrl}" />

	<%-- today weather variables --%>
	<c:url var="todaysWeatherUrl" value="img/weather/${todaysWeather.imageUrl}" />
	<c:choose>
		<c:when test="${unitCharacter == 'F'}">
			<c:set var="todaysHigh" value="${todaysWeather.high}"/>
			<c:set var="todaysLow" value="${todaysWeather.low}"/>
		</c:when>
		<c:otherwise>
			<c:set var="todaysHigh" value="${(todaysWeather.high - 32) * 0.5556}"/>
			<c:set var="todaysLow" value="${(todaysWeather.low - 32) * 0.5556}"/>
		</c:otherwise>
	</c:choose>
<c:url var="parkUrl" value="/park">
	<c:param name="code" value="${park.parkCode}" />
</c:url>
<c:url var="setUnitUrl" value="/setUnit"/>
<%-- end variables --%>

<div class="parallax" style="background-image: url(${imageUrl})">
</div>

<div class="container park-container">
	<div>
		<h2>
			<c:out value="${park.name}" />
			<small class="text-muted"> <c:out value="${park.state}" />
			</small>
		</h2>
	</div>
	<div>
		<h5>
			Founded in
			<c:out value="${park.yearFounded}" />
		</h5>
	</div>
	<div>
		<p>
			<c:out value="${park.description}" />
		</p>
	</div>

	<div>
		<blockquote class="blockquote">
			<p>
				<c:out value="${park.quote}" />
			</p>
			<footer class="blockquote-footer">
				<c:out value="${park.quoteSource}" />
			</footer>
		</blockquote>
	</div>
	<div>
		<p>Key Stats about <c:out value="${park.name}"/>:</p>
		<ul>
			<li>Acres: <fmt:formatNumber type = "number" value = "${park.acreage}" /></li>
			<c:if test="${park.elevation > 0}">
				<li>Elevation: <fmt:formatNumber type = "number" value = "${park.elevation}"/> ft.</li>
			</c:if>
			<li>Miles of Trail: <c:out value="${park.milesOfTrail}"/></li>
			<c:if test="${park.campsites > 0}">
				<li>Campsites: <fmt:formatNumber type = "number" value = "${park.campsites}"/></li>
			</c:if>
			<li>Annual Visitors: <fmt:formatNumber type = "number" value = "${park.annualVisitorCount}"/></li>
			<c:choose>
				<c:when test="${park.entryFee > 0}">
					<li>Entry Fee: $<c:out value="${park.entryFee}"/></li>
				</c:when>
				<c:otherwise>
					<li>Entry Fee: Free!</li>
				</c:otherwise>
			</c:choose>
			<li>Number of Animal Species: <c:out value="${park.numberOfAnimalSpecies}"/></li>
		</ul>
	</div>
	<hr>
	<div class="weather">
		<h4><c:out value="${park.name}"/> Weather</h4>
		<div class="row">
			<div class="col-md-4 today-weather">
				<h5>Today</h5>
				<img src="${todaysWeatherUrl}" class="img-fluid weather-img"/>
				<p>
					High: 
					<fmt:formatNumber type="number" maxFractionDigits = "0" value="${todaysHigh}"/>°<c:out value="${unitCharacter}"/> 
					<br/>
					Low: 
					<fmt:formatNumber type="number" maxFractionDigits = "0" value="${todaysLow}"/>°<c:out value="${unitCharacter}"/></p>
				<p class="recommendation"><strong>Recommendation:</strong> <c:out value="${todaysWeather.recommendation}"/></p>
			</div>
			<div class="col-md-8">
				<div class="row">
					<c:forEach var="weather" items="${futureWeather}">
					
						<%-- begin variables --%>
						<c:url var="weatherImage" value="img/weather/${weather.imageUrl}" />
						<c:choose>
							<c:when test="${unitCharacter == 'F'}">
								<c:set var="thisHigh" value="${weather.high}" />
								<c:set var="thisLow" value="${weather.low}" />
							</c:when>
							<c:otherwise>
								<c:set var="thisHigh" value="${(weather.high - 32) * 0.5556}" />
								<c:set var="thisLow" value="${(weather.low - 32) * 0.5556}" />
							</c:otherwise>
						</c:choose>
						<%-- end variables --%>
						
						<div class="col-3 future-weather">
							<p><strong>${weather.dayOfWeek}</strong></p>
							<img src="${weatherImage}" class="img-fluid weather-img"/>
							<p>High: <fmt:formatNumber type="number" maxFractionDigits = "0" value="${thisHigh}"/>°<c:out value="${unitCharacter}"/>
								<br/>
								Low: <fmt:formatNumber type="number" maxFractionDigits = "0" value="${thisLow}"/>°<c:out value="${unitCharacter}"/>
							</p>
						</div>
					</c:forEach>
				</div>
				<form method="post" action="${setUnitUrl}" id="unit-form">
					<div class="form-group">
			    			<label for="unit">Choose unit:</label>
			    			<select class="form-control" name="unit">
			    				<c:choose>
			    					<c:when test="${unitCharacter == 'F'}">
			    						<option value="f">Fahrenheit</option>
			      					<option value="c">Celsius</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="c">Celsius</option>
			    						<option value="f">Fahrenheit</option>
			    					</c:otherwise>
			    				</c:choose>
			    			</select>
			    			<input type="hidden" name="code" value="${park.parkCode}"/>
			    			<button id="unit-form-submit" type="submit" class="btn btn-success">Update</button>
			  		</div>
				</form>
			</div>
		</div>
		
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"></c:import>