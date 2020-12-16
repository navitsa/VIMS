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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="build.css">
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
							<h4 class="page-title">User Categories</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
									Create a User Level
								</li>
								
								
							</ul>
						</div>
				
						
				<div class="container-fluid">

				

					<form:form action="saveUserLevel" method="post" modelAttribute="userLevel" id="form1">
						<div class="row">
							<div class="col-xl-6 col-md-6 mb-4">

								<div class="card shadow mb-4 border-left-primary">
									<div class="card-body">
									
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

										<div class="form-group row">
											<div class="col-lg">
												<label for="level">User level <span
													class="required text-danger">*</span></label>
												<form:input id="level" class="form-control form-control-sm"
													path="dsc" required="true" />
												<form:errors path="dsc" class="bg-danger text-white" />
												<form:input class="form-control" id="levelId" path="ulid"
													type="hidden" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-6">
												<label for="home">User Home <span
													class="required text-danger">*</span></label>
												<form:select class="custom-select custom-select-sm"
													path="roleID.roleID" required="true" id="home">
													<form:option value=""> --SELECT--</form:option>
													<c:forEach items="${getAllRoleCombo}" var="urol">
														<form:option value="${urol.roleID}">${urol.roleName}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg">
												<form:textarea path="remarks" class="form-control" placeholder="Remarks" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg">

												<label>Status</label> <br>
												<form:radiobutton path="status" value="ACTIVE"
													checked="checked" />
												Active
												<form:radiobutton path="status" value="INACTIVE" />
												Inactive

											</div>
										</div>
										
										<input type="submit" class="btn btn-success" value="Add User Level" />
										<input type="reset" class="btn btn-warning" value="Clear" /><br><br>

										<div class="table-responsive">
											<div class="table-wrapper">
												<table id="tableLevel"
													class="table table-striped table-bordered table-sm">
													<thead>
														<tr>
															<th>User level</th>
															<th>User Home</th>
															<th>Remarks</th>
															<th>Status</th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${userlist}" var="level">
															<tr>

																<td>${level.dsc}</td>
																<td>${level.roleID.roleName}</td>
																<td>${level.remarks}</td>
																<td>${level.status}</td>
																<td><a
																	href="userLevelEdit?ulid=${level.ulid}"><i
																		class="fas fa-pen"></i></a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>

									</div>
								</div>

							</div>

							<div class="col-xl col-md-6 mb-4">
								<div class="card shadow mb-4">
									<div class="card-body">

<!-- 												<table id="tableLevel" -->
<!-- 													class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"> -->
<!-- 													<thead> -->
<!-- 														<tr> -->
<!-- 															<th>Role</th>														 -->
<!-- 															<th>Status</th> -->
<!-- 															<th></th> -->
<!-- 														</tr> -->
<!-- 													</thead> -->
<!-- 													<tbody> -->
<%-- 														<c:forEach items="${roleList}" var="rolelist"> --%>
<!-- 															<tr> -->

<%-- 																<td>${rolelist.roleName}</td> --%>
<!-- 																<td> -->
																
<!-- 																      <div class="checkbox checkbox-success"> -->
<!--                         <input id="check5" class="styled" type="checkbox" > -->
                     
<!--                     </div> -->
																
																
																
<!-- 																</td> -->
																
<!-- 															</tr> -->
<%-- 														</c:forEach> --%>
<!-- 													</tbody> -->
<!-- 												</table> -->




<form:form modelAttribute="levelManage" id="form2">
											<label class="text-gray-900">To assign a user-level role, please use the grid below</label>
											<table>
												<tr valign="top">
													<td><select id="s" size="14" class="custom-select"
														name="removesroleID" multiple>
															<c:forEach items="${roleList}" var="role">
																<option value="${role.roleID}">${role.roleName}</option>
															</c:forEach>
													</select></td>
													<td valign="center"><br>
													<br> <a href="#"
														onclick="if (!window.__cfRLUnblockHandlers) return false; listbox_moveacross('s', 'd')"
														data-cf-modified-46ada2dfb40708e7bf43261c-="">&gt;&gt;</a> <br />
													<br /> <a href="#"
														onclick="if (!window.__cfRLUnblockHandlers) return false; listbox_moveacross('d', 's')"
														data-cf-modified-46ada2dfb40708e7bf43261c-="">&lt;&lt;</a></td>
													<td><select id="d" size="14" class="custom-select"
														name="sroleID" style="width: 200px;" multiple required>
															<%-- <c:forEach items="${assignRoleList}" var="role"> --%>
															<%-- <option value = "${role.roleID}">${role.roleName}</option> --%>
															<%-- </c:forEach> --%>
													</select></td>
												</tr>
											</table>
										</form:form>

									</div>
								</div>
							</div>
						</div>
					</form:form>
					<!-- 1 row end -->

					<div class="row">
						<div class="col-xl col-md-6 mb-4"></div>
					</div>
					<!-- 2 row end -->

				</div>
							
	
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script>
		function listbox_moveacross(sourceID, destID) {
			var src = document.getElementById(sourceID);
			var dest = document.getElementById(destID);
		
			for(var count=0; count < src.options.length; count++) {
		
				if(src.options[count].selected == true) {
						var option = src.options[count];
		
						var newOption = document.createElement("option");
						newOption.value = option.value;
						newOption.text = option.text;
						newOption.selected = true;
						try {
								 dest.add(newOption, null); //Standard
								 src.remove(count, null);
								 
						
								 
						 }catch(error) {
								 dest.add(newOption); // IE only
								 src.remove(count);
						 }
						count--;
				}
			}
		}
	</script>
	
	<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js" data-cf-settings="46ada2dfb40708e7bf43261c-|49" defer=""></script>
	
</body>
</html>