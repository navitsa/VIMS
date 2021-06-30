<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.error1 {
	color: red;
	font-size: 12px
}

.fontcolor {
	color: blue;
}
</style>
<style type="text/css">
.imagePreview {
	width: 100%;
	height: 180px;
	background-position: center center;
	background:
		url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
	background-color: #fff;
	background-size: cover;
	background-repeat: no-repeat;
	display: inline-block;
	box-shadow: 0px -3px 6px 2px rgba(0, 0, 0, 0.2);
}

.btn-primary {
	display: block;
	border-radius: 0px;
	box-shadow: 0px 4px 6px 2px rgba(0, 0, 0, 0.2);
	margin-top: -5px;
}

.imgUp {
	margin-bottom: 15px;
}

.del {
	position: absolute;
	top: 0px;
	right: 15px;
	width: 30px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	background-color: rgba(255, 255, 255, 0.6);
	cursor: pointer;
}

.imgAdd {
	width: 30px;
	height: 30px;
	border-radius: 50%;
	background-color: #4bd7ef;
	color: #fff;
	box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.2);
	text-align: center;
	line-height: 30px;
	margin-top: 0px;
	cursor: pointer;
	font-size: 15px;
}

input[type="radio"] {
	margin: 0 10px 0 10px;
}

div.groove {
	border-style: ridge;
	
	height: 200px;
	width: 100%;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->
			<%@include file="../WEB-INF/jsp/logoHeader.jsp"%>
			<!-- End Logo Header -->
			<!-- Navbar Header -->
			<%@include file="../WEB-INF/jsp/navbar.jsp"%>
			<!-- End Navbar -->
		</div>
		<!-- Sidebar -->
		<%@include file="../WEB-INF/jsp/slideBar.jsp"%>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="page-header">
						<h4 class="page-title">User Controller</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>


						</ul>
					</div>
					<div class="row">
						<div class="col-xl-7">
							<div class="card shadow mb-4">
								<form action="saveuserActive" method="post">
									<div class="card-body">
										<div class="row">
											<div class="col-6">

												<c:if test="${success ==1}">
													<div class="alert alert-success alert-dismissible">
														<button type="button" class="close" data-dismiss="alert">&times;</button>
														<strong>Success!</strong> Data Successfully Saved.
													</div>
												</c:if>
												<c:if test="${success ==0}">
													<div class="alert alert-danger alert-dismissible">
														<button type="button" class="close" data-dismiss="alert">&times;</button>
														<strong>Warning!</strong>Something went wrong ! Please try
														again!
													</div>
												</c:if>


												<div class="form-group">
													<div class="row">
														<div class="col-12">
															<label for="ct">User <span
																class="required text-danger">*</span></label> <select
																class="custom-select custom-select-sm" name="userId"
																required="true" id="ct">
																<option value="">Select User</option>
																<c:forEach items="${getUser}" var="user">
																	<option value="${user.userId}">${user.userName}</option>
																</c:forEach>
															</select>
														</div>
													</div>
												</div>


												<div class="form-group">
													<div class="row">
														<div class="col-7">
															<img class="zoom imagePreview"
																src="<c:url value='/resources/img/user-default.jpg'/>"
																id="preview" class="img-thumbnail"
																name="userId.user_Img">

														</div>
														<div class="col-1">
															<label  id="userName"></label>
														</div>

													</div>
												</div>
											</div>
										</div>
										</br>

										<div class="form-group row">
											<div class="col-sm-10">
												<label>User Status</label>
												<div class="col-sm-2"></div>

												<div class="btn-group btn-group-toggle form-control"
													data-toggle="buttons">
													<label class="btn btn-outline-success btn-sm active">
														<input id="status" name="status" 
														onfocus="geGlaccountByPrimaryAccount(this.value);"
														type="radio" value="ACTIVE" checked>Active
													</label> <label class="btn btn-outline-primary btn-sm"> <input
														id="status" name="status"
														onfocus="geGlaccountByPrimaryAccount(this.value);"
														type="radio" value="INACTIVE">Inactive
													</label>

												</div>

											</div>

											<div style="margin-top: 20px" class="groove">
												
												<div class="form-group">
													<div class="row">
														<div class="col-12">
												<label  for="formButton"> I need reset user Password</label>  <input style="margin-left:20px" type="checkbox" id="formButton"  >

															<input class="form-control"
																style="display: none; margin-top: 10px" type="password"
																id="form1" name="password">

														</div>
													</div>
													
												</div>
											</div>

											<div class="col-sm-2"></div>
											<div class="col-sm-3"></div>

										</div>

										<br>


										<button type="submit" class="btn btn-success mr-2"
											style="width: 150px;">Save</button>
										<button type="reset" class="btn btn-warning mr-2"
											style="width: 150px;">Clear</button>

									</div>
								</form>
							</div>
						</div>

						<div class="col-mb-4">
							<div class="">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div class="form-group">
											<div class="row">

												<div class="col-6">
													<c:if test="${employeeView != null }">
														<embed type="application/pdf"
															src="data:application/pdf;headers=filename%3D;base64,${employeeView}"
															style="height: 300px; width: 400px">
														</embed>
													</c:if>
												</div>

											</div>
										</div>





									</div>

								</div>

							</div>


						</div>


					</div>







				</div>

			</div>
			<%@include file="../WEB-INF/jsp/footer.jsp"%>
		</div>
	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

  <script>
   
    document.getElementById("ct").addEventListener("keyup", function(event){
  
      document.getElementById('userName').textContent = this.value;
    });
  </script>

	<script>
		$(document).ready(function() {
			$("#formButton").click(function() {
				$("#form1").toggle();
		
			});
		});
	</script>

	<script defer
		src="resources/js/form-validation/create-new-user-form.js"
		type="text/javascript"></script>

	<script type="text/javascript">
		$(document).on("click", ".browse", function() {
			var file = $(this).parents().find(".file");
			file.trigger("click");
		});
		$('input[type="file"]').change(function(e) {
			var fileName = e.target.files[0].name;
			$("#file").val(fileName);

			var reader = new FileReader();
			reader.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("preview").src = e.target.result;
			};
			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		})
	</script>


</body>
</html>
