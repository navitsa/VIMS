<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
.error1{color:red;font-size: 12px }
         
.fontcolor{color: blue;}
</style>
<style type="text/css">

.imagePreview {
    width: 100%;
    height: 180px;
    background-position: center center;
  background:url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
  background-color:#fff;
    background-size: cover;
  background-repeat:no-repeat;
    display: inline-block;
  box-shadow:0px -3px 6px 2px rgba(0,0,0,0.2);
}
.btn-primary
{
  display:block;
  border-radius:0px;
  box-shadow:0px 4px 6px 2px rgba(0,0,0,0.2);
  margin-top:-5px;
}
.imgUp
{
  margin-bottom:15px;
}
.del
{
  position:absolute;
  top:0px;
  right:15px;
  width:30px;
  height:30px;
  text-align:center;
  line-height:30px;
  background-color:rgba(255,255,255,0.6);
  cursor:pointer;
}
.imgAdd
{
  width:30px;
  height:30px;
  border-radius:50%;
  background-color:#4bd7ef;
  color:#fff;
  box-shadow:0px 0px 2px 1px rgba(0,0,0,0.2);
  text-align:center;
  line-height:30px;
  margin-top:0px;
  cursor:pointer;
  font-size:15px;
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
							<h4 class="page-title">Create a New User</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								
								
							</ul>
						</div>
				
				
				
		
				
				
				
				
				
				
				
			<div class="row">
				<div class="col-xl-7">
					<div class="card shadow mb-4">
						<form:form action="saveuser" method="post"
														modelAttribute="users" enctype="multipart/form-data"
														onsubmit="return validateform()">
						 <div class="card-body">
						 <div class="row">
						 		<div class="col-6">
						 		
						 											                	<c:if test = "${success ==1}">
															<div class="alert alert-success alert-dismissible">
															  <button type="button" class="close" data-dismiss="alert">&times;</button>
															  <strong>Success!</strong> Data Successfully Saved.
															</div>
														</c:if>
														<c:if test = "${success ==0}">
														  <div class="alert alert-danger alert-dismissible">
														    <button type="button" class="close" data-dismiss="alert">&times;</button>
														    <strong>Warning!</strong>Something went wrong ! Please try again!
														  </div>
														</c:if>
						 		
						 			<form:input path="empId" class="form-control" placeholder="Enter Employee ID" type="hidden" />
									<form:input class="form-control" path="userId" value="${maxUsersID.userId}" type="hidden" />

							<div class="form-group">
								<div class="row">
									<div class="col-12">
										<label for="ct">Center <span class="required text-danger">*</span></label>
										<form:select class="custom-select custom-select-sm"
																	path="center_ID.center_ID" required="true" id="ct">
										<form:option value="">Select Center</form:option>
										<c:forEach items="${getCentercombo}" var="ce">
										<form:option value="${ce.center_ID}">${ce.center}</form:option>
										</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-12">
										<label for="userlevel">User Level <span class="required text-danger">*</span></label>
										<form:select class="custom-select custom-select-sm"
											path="ulid.ulid" required="true" id="userlevel">
											<form:option value="">Select User Level</form:option>
											<c:forEach items="${userlevelcombo}" var="ul">
												<form:option value="${ul.ulid}">${ul.dsc}</form:option>
											</c:forEach>
										</form:select>
									</div>
									
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-12">
										<label for="userName">Username <span class="required text-danger">*</span></label>
										<form:input path="userName" class="form-control form-control-sm" id="userName" />

									</div>
								</div>
							</div>						
							<div class="form-group">
								<div class="row">
									<div class="col-12">
										<label for="pass">New Password <span class="required text-danger">*</span></label>
										<form:input path="password" type="password"
											class="form-control form-control-sm "
											id="pass" />

									</div>
								</div>
							</div>
						
							<div class="form-group">
								<div class="row">
									<div class="col-12">
										<label for="conPass">Confirm Password <span class="required text-danger">*</span></label> <input
											type="password" name="newpassword"
											class="form-control form-control-sm" id="conPass" />

									</div>
								</div>
							</div>

								<div class="form-group">
								<div class="row">
									<div class="col-12">
										
										<form:input path="status" class="form-control form-control-sm" id="status" value="ACTIVE" hidden="true" />

									</div>
								</div>
							</div>
							
							
							
							
							
							
							
							
							
				
													
												
																
										
														<br>

														<button type="submit" class="btn btn-success mr-2"
															style="width: 150px;">Register</button>
														<button type="reset" class="btn btn-warning mr-2"
															style="width: 150px;">Clear</button>	
						
						
						
						
								</div>
								<div class="col-6">
							<div class="form-group">
								<div class="row">
									<div class="col-7">
										<img  class="zoom imagePreview"  src="<c:url value='/resources/img/user-default.jpg'/>" id="preview" class="img-thumbnail">		
										<label class="btn btn-primary">Upload Photo<input type="file"
												class="uploadFile img" value="Upload Photo" style="width: 0px;height: 0px;overflow: hidden;"  accept="image/*" id="user_Img"
												name="user_Img"></label>
									</div>
								</div>
							</div>
								
								</div>
							</div>	
						</div>
						</form:form>
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
																		<embed type="application/pdf" src="data:application/pdf;headers=filename%3D;base64,${employeeView}"
																			style="height:300px; width:400px" >
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
