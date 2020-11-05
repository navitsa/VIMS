<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>User Profile</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>
	
	<style>
	#levelForm #levelId {
		width: 40%;
	}
	
	#levelForm #level {
		width: 50%;
	}
	
	#levelForm label {
		font-weight: bold;
	}
	</style>
</head>
<body id="page-top" onload="getUserInfo()">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>


				<!-- Begin Page Content -->
				<div class="container-fluid">
					<h1 class="h3 mb-4 text-gray-800">User Profile</h1>
					<!-- Page Heading -->
					<div class="container">
						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<div class="col-xl-8 col-md-6mb-4 ">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<form:form action="saveuserEdit" method="post"
													modelAttribute="editUser" id="levelForm"
													onsubmit="return formValidation()"
													enctype="multipart/form-data">
													<div class="border border-primary ">
														<div class="col-sm-12 mb-1 mb-sm-3">
															<div class="row">
																<div class="col-6">

																	<%-- 																	<img src="data:image/jpg;base64,${user_Img}" width="90" --%>
																	<!-- 																		height="80" id="mydemo1" class="img-thumbnail" -->
																	<!-- 																		style="width: 200px; height: 200px"> -->


																	<c:if test="${editUser.user_Img != null}">
																		<img src="data:image/jpg;base64,${user_Img}" id="mydemo1"
																			class="img-thumbnail" width="60" height="60">
																	</c:if>
																	<img src="" id="mydemo1" class="img-thumbnail"
																		width="60" height="60">
																</div>

																<div class="col-6 mydemo">


																	<div class="row">


																		<div class="col-6">
																			<br> <label>User ID </label>

																		</div>
																		<div class="col-6">
																			<br>
																			<form:input
																				class="form-control form-control-user mr-1"
																				id="userid" path="userId" onfocusout="getUserInfo()"
																				value="${editUser.userId}" readOnly="true" />
																		</div>

																	</div>
																	<div class="row">

																		<div class="col-6">
																			<br> <label>Name:</label> <br> <label>Level:</label>
																			<br> <label>Employee ID:</label> <br> <label>Partner:</label>
																		</div>
																		<div class="col-6">
																			<br> <label id="userNameold"></label> <br>
																			<label id="text2"></label> <br> <label
																				id="text3"></label> <br>
																			<form:input path="ulid.ulid" type="hidden"
																				id="userLevelID" />
																			<label id="partner"></label>
																		</div>

																	</div>




																</div>


															</div>
														</div>

													</div>

													<br>
													<div class="border border-primary ">
														<div class="col-sm-12 mb-1 mb-sm-3 ">
															<div class="row">


																<div class="col-4">
																	<label>New User Name</label>
																	<form:input class="form-control form-control-user"
																		path="userName" id="userName"
																		onfocusout="getUserNameDetails()" />
																</div>
															</div>

														</div>

														<div class="col-sm-12 mb-1 mb-sm-3">
															<label>User Image</label>
															<div class="row">


																<div class="col-6">
																	<input type="file" class="file"
																		id="user_Img" name="user_Img">
																	<div class="input-group my-3">
																		<input type="text"
																			class="form-control form-control form-control-user"
																			disabled placeholder="Upload User Image " id="file">
																		<div class="input-group-append">
																			<button type="button" class="browse btn btn-primary">Browse</button>
																		</div>
																		<br>

																	</div>
																</div>
																<div class="col-3">
																	<div class="ml-2 col-sm-6">
																		<%-- <c:if test="${editUser.user_Img != null}"> --%>
																		<%--	<img src="data:image/jpg;base64,${imguser}" --%>
																		<!-- 			id="preview" class="img-thumbnail" width="200" -->
																		<!-- height="300"> -->
																		<%-- </c:if> --%>
																		<!-- 	<img src="" id="mydemo1" class="img-thumbnail" -->
																		<!-- 	width="200" height="300"> -->

																	</div>
																</div>
															</div>

														</div>
														<div class="col-sm-6 mb-1 mb-sm-3">
															<label>Employee ID</label>
															<form:input class="form-control form-control-user"
																id="empId" path="empId" />
														</div>
														<div class="col-sm-6 mb-1 mb-sm-3">
				
														</div>
														<div class="col-sm-6 mb-1 mb-sm-3">
															<label>Current Password</label> <input name="cpassword"
																type="password" class="form-control"
																placeholder="Enter Password " id="p1">
														</div>
														<div class="col-sm-6 mb-1 mb-sm-3">
															<label>New Password</label>
															<form:input path="" type="password" class="form-control"
																placeholder="Enter Password " id="p2" name="p2" />
														</div>
														<div class="col-sm-6 mb-1 mb-sm-3">
															<label>Confirm Password</label>
															<form:input path="password" type="password"
																class="form-control" placeholder="Enter Password "
																name="p3" onkeyup="checkPW()" id="p3" />
														</div>
													</div>
													<table align="center">
														<tr></tr>
														<tr>

															<td style="font-style: italic; color: red;">${mseg}</td>
														</tr>
													</table>
													<div class="col-sm-7 mb-1 mb-sm-3 mt-2">
														<table>
															<tr>
																<td><input type="submit"
																	class="btn btn-primary btn-sm mr-2" value="Submit" /></td>
																<td><input type="reset"
																	class="btn btn-primary btn-sm mr-2" value="Clear" /></td>


															</tr>
														</table>



													</div>
												</form:form>

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

	</div>
	<!-- End of Page Content -->


	</div>
	<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>

	</div>
	<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@include file="logoutModel.jsp"%>



	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/resources/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/resources/js/sb-admin-2.min.js'/>"></script>

	<!-- Page level plugins -->
	<script src="<c:url value='/resources/vendor/chart.js/Chart.min.js'/>"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value='/resources/js/demo/chart-area-demo.js'/>"></script>
	<script src="<c:url value='/resources/js/demo/chart-pie-demo.js'/>"></script>
	<!-- --image browser -->
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
				document.getElementById("mydemo1").src = e.target.result;
			};
			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		})

		function getUserInfo() {
			//load previoues details of user
			var str = document.getElementById("userid").value;
			getLogo(str);
			if (str == "") {

				$("#mydemo").empty();
				return;
			} else {
				$
						.ajax({
							type : 'GET',
							url : "getUserdetails",
							data : {
								"userid" : str
							},
							success : function(data) {
								$("#userNameold").empty();
								$("#userName").empty();
								$("#text2").empty();
								$("#text3").empty();
								$("#partner").empty();

								//append username
								var textU = data.userName + "<br>";
								$("#userNameold").append(textU);

								//append  user level
								var textl = data.ulid.dsc + "<br>";
								$("#text2").append(textl);

								//append employee id
								var texte = +data.empId + "<br>";
								$("#text3").append(texte);

								//append partner id
								var pid = data.partner_ID.partner_Name + "<br>";
								$("#partner").append(pid);

								//get values to the field when load the page
								document.getElementById("userName").value = data.userName;

								document.getElementById("userLevelID").value = data.ulid.ulid;

								document.getElementById("partner_ID").value = data.partner_ID.partner_ID;

								document.getElementById("empId").value = data.empId;

							},
							error : function() {
								alert("Data Not Found");
							}

						});
			}
		}
		//check user name already have or not in db
		function getUserNameDetails(str) {
			//var x = document.getElementById("userName");
			alert(str);
			$
					.ajax({
						type : 'GET',
						url : "editUname",
						data : {
							"userName" : str
						},
						success : function(data) {

							if (confirm("This Name is already saved...!\nDo you want to edit this User Information ?\nPlease Click OK...!")) {
								txt = "You pressed OK!";
								location.reload(true);
								//window.location.href = "editUname?userName="+ x.value;
							} else {
								txt = "You pressed Cancel!";
							}

						},
						error : function() {
							//alert("error");
						}

					});
		}
		//check password equality
		function checkPW() {
			var p2 = document.getElementById('p2').value;
			var p3 = document.getElementById('p3').value;

			if (p3 == p2) {
				document.getElementById("p3").style.border = "thin solid  #45b39d";//#7dcea0
				document.getElementById("p3").style.color = " #45b39d ";
				document.getElementById("p3").innerHTML = "passwords are not matched";
			} else {
				document.getElementById("p3").style.border = "thin solid  #cd6155";
				document.getElementById("p3").style.color = "#cd6155";
			}

		}

		//get Image
		function getLogo(str) {

			if (str == "") {

				return;
			} else {
				$.ajax({
					type : 'GET',
					url : "getImage",
					data : {
						"userid" : str
					},
					success : function(data) {

						//delete previous selected value
						//document.getElementById("file").src = data.user_Img;

						var img = $('#mydemo1'), value = "";
						img.empty();

						var x = document.getElementById("mydemo1");
						x.setAttribute("src", "data:image/jpg;base64," + data
								+ "");
						x.setAttribute("width", "150");
						x.setAttribute("height", "150");
						x.setAttribute("alt", "User Image");
						// document.body.appendChild(x);
						document.getElementById("mydemo1").appendChild(x);

					},

					error : function() {
						alert("Error");
					}

				});
			}
		}
		//validation for passwords field
		function formValidation() {
			var password1 = document.forms["levelForm"]["p2"];
			var password2 = document.forms["levelForm"]["p3"];

			if (password1.value == "") {
				window.alert("Please enter New password.");
				password1.focus();
				return false;
			}
			if (password2.value == "") {
				window.alert("Please enter Confirm passworsd.");
				password2.focus();
				return false;
			}
			return true;
		}
	</script>


</body>
</html>