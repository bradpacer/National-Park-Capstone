<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Survey" />
</c:import>

<c:url var="surveyResultUrl" value="/survey"/>

<div class="container">

	<h2>Park Survey</h2>
	<p class="lead">Tell us about yourself and your favorite park!</p>
	
	<form id="survey-form" method="post" action="${surveyResultUrl}">
		<div class="form-group row">
			<label for="park" class="col-4 col-form-label">Park</label>
			<div class="col-8">
				<select class="form-control" name="park">
					<c:forEach var="park" items="${parkList}">
						<option value="${park.parkCode}"><c:out value="${park.name}"/></option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-4 col-form-label">Email</label>
			<div class="col-8">
				<input type="email" class="form-control" name="email" required/>
			</div>
		</div>
		<div class="form-group row">
			<label for="state" class="col-4 col-form-label">State of Residence</label>
			<div class="col-8">
				<select class="form-control" name="state">
					<option value="AL">AL</option>
					<option value="AK">AK</option>
					<option value="AR">AR</option>
					<option value="AK">AK</option>
					<option value="CA">CA</option>
					<option value="CO">CO</option>
					<option value="CT">CT</option>
					<option value="DE">DE</option>
					<option value="FL">FL</option>
					<option value="GA">GA</option>
					<option value="HI">HI</option>
					<option value="ID">ID</option>
					<option value="IL">IL</option>
					<option value="IN">IN</option>
					<option value="IA">IA</option>
					<option value="KS">KS</option>
					<option value="KY">KY</option>
					<option value="LA">LA</option>
					<option value="ME">ME</option>
					<option value="MD">MD</option>
					<option value="MS">MS</option>
					<option value="MI">MI</option>
					<option value="MN">MN</option>
					<option value="MS">MS</option>
					<option value="MO">MO</option>
					<option value="MT">MT</option>
					<option value="NE">NE</option>
					<option value="NV">NV</option>
					<option value="NH">NH</option>
					<option value="NJ">NJ</option>
					<option value="NM">NM</option>
					<option value="NY">NY</option>
					<option value="NC">NC</option>
					<option value="ND">ND</option>
					<option value="OH">OH</option>
					<option value="OK">OK</option>
					<option value="OR">OR</option>
					<option value="PA">PA</option>
					<option value="RI">RI</option>
					<option value="SC">SC</option>
					<option value="SD">SD</option>
					<option value="TN">TN</option>
					<option value="TX">TX</option>
					<option value="UT">UT</option>
					<option value="VT">VT</option>
					<option value="VA">VA</option>
					<option value="WA">WA</option>
					<option value="WV">WV</option>
					<option value="WI">WI</option>
					<option value="WY">WY</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="activity" class="col-4 col-form-label">Activity Level</label>
			<div class="col-8">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activity" value="inactive"/> Inactive
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activity" value="sedentary"/> Sedentary
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activity" value="active"/> Active
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="activity" value="extremelyActive"/> Extremely Active
				</div>
			</div>
			
			
		</div>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-8">
				<button id="unit-form-submit" type="submit" class="btn btn-success btn-lg">Submit</button>
			</div>
		</div>
		
	</form>
</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp"></c:import>