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
						<h4 class="page-title">User Profile</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>


						</ul>
					</div>
					<div class="col-xl-5 col-md-6mb-4 ">

						<form:form action="saveuserEdit" method="post"
							modelAttribute="editUser" id="levelForm"
							onsubmit="return formValidation()" enctype="multipart/form-data">
							<div class="border border-primary ">
								<div class="col-sm-12 mb-1 mb-sm-3">
									<div class="row">
										<div class="col-4">

											<c:if test="${editUser.user_Img != null}">
												<img src="data:image/jpg;base64,${user_Img}" id="mydemo1"
													class="img-thumbnail" width="60" height="60">
											</c:if>
											<img src="" id="mydemo1" class="img-thumbnail" width="60"
												height="60"> <label class="btn btn-primary">Upload
												Photo<input type="file" class="uploadFile img"
												value="Upload Photo"
												style="width: 0px; height: 0px; overflow: hidden;"
												accept="image/*" id="user_Img" name="user_Img">
											</label>


										</div>

										<div class="col-8 mydemo">


											<div class="row">



												<div class="col-6">
													<br>
													<form:input type="hidden"
														class="form-control form-control-user mr-1" id="userid"
														path="userId" onfocusout="getUserInfo()"
														value="${editUser.userId}" readOnly="true" />
												</div>

											</div>
											<div class="row">

												<div class="col-6">
													<br> <label>Name:</label> <br> <label>Level:</label>
													<br> <label>Employee ID:</label> <br> <label>Partner:</label>
												</div>
												<div class="col-6">
													<br> <label id="userNameold"></label> <br> <label
														id="text2"></label> <br> <label id="text3"></label> <br>
													<form:input path="ulid.ulid" type="hidden" id="userLevelID" />
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

										<div class="col-8">
											<label>New User Name</label>
											<form:input class="form-control form-control-user"
												path="userName" id="userName"
												onfocusout="getUserNameDetails()" />
										</div>
									</div>

								</div>


								<div class="col-sm-12 mb-1 mb-sm-3 ">
									<div class="row">

										<div class="col-8">
											<label>Current Password</label> <input name="cpassword"
												type="password" class="form-control"
												placeholder="Enter Password " id="p1">
										</div>
									</div>

								</div>


								<div class="col-sm-12 mb-1 mb-sm-3 ">
									<div class="row">

										<div class="col-8">
											<label>New Password</label>
											<form:input path="" type="password" class="form-control"
												placeholder="Enter Password " id="p2" name="p2" />
										</div>
									</div>

								</div>



								<div class="col-sm-12 mb-1 mb-sm-3 ">
									<div class="row">

										<div class="col-8">
											<label>Confirm Password</label>
											<form:input path="password" type="password"
												class="form-control" placeholder="Enter Password " name="p3"
												onkeyup="checkPW()" id="p3" />
										</div>
									</div>

								</div>

								<div class="col-sm-6 mb-1 mb-sm-3">

									<form:input class="form-control form-control-user"
										type="hidden" id="empId" path="empId" />
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
				document.getElementById("mydemo1").src = e.target.result;
			};
			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		})
		getUserInfo();
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
								//	var pid = data.partner_ID.partner_Name + "<br>";
								//	$("#partner").append(pid);
								//	alert("Data Not Found"+pid);
								//get values to the field when load the page
								document.getElementById("userName").value = data.userName;

								document.getElementById("userLevelID").value = data.ulid.ulid;

								//document.getElementById("partner_ID").value = data.partner_ID.partner_ID;

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