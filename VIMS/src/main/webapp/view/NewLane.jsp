<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>
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
						<h4 class="page-title">Create New Lanes</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>
							<li class="nav-item"><a href="#"></a></li>

						</ul>
					</div>


					<div
						class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
						<div class="col-xl-5 col-md-6mb-4">
							<div class="card border-left-primary shadow h-200 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
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

											<form:form action="saveLaneHead" method="post"
												modelAttribute="saveLaneHead" id="formTestLane">

												<div class="form-group row">

													<form:input class="form-control fontst " path="centerID"
														value='<%=session.getAttribute("centerid")%>'
														onchange="setProgress();" hidden="true" id="icenterId"
														required="sd" />
													<form:input class="form-control form-control-user"
														path="testLaneHeadId" placeholder="Enter ID" hidden="true"
														readonly="true" />


													<div class="col-sm-12">

														<progress max=100></progress>
														<span id="progress_percent">0</span>%


													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Lane Type</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control form-control-user fontst"
															path="laneID">
															<form:option value="">- Select Lane Type -</form:option>
															<c:forEach items="${alllanes}" var="lane1">
																<form:option value="${lane1.laneId}">${lane1.lane}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Lane</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															path="laneName" placeholder="Enter Lane" />
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Lane Capacity</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															type="number" path="laneCap"
															placeholder="Enter Lane capacity" min="1" max="99" />
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Select Gate</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control form-control-user fontst"
															path="gateID.gateID">
															<form:option value="">- Select Gate -</form:option>
															<c:forEach items="${alllgates}" var="gate">
																<form:option value="${gate.gateID}">${gate.gateName}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Maha PC IP Address</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															path="mahaPcIp" placeholder="Enter IP" />
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Maha FTP Path</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															path="mahaFtpPath" placeholder="Enter FTP Path" />
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">AVL PC IP Address</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															path="avlPcIp" placeholder="Enter PC IP" />
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">AVL FTP Path</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control form-control-user fontst"
															path="avlFtpPath" placeholder="Enter FTP Path" />
													</div>
												</div>



												<table>
													<tr>
														<td>
															<div class="col-sm-7 mb-1 mb-sm-3">
																<input type="submit" class="btn btn-primary btn-sm"
																	value="Save">
															</div>
														</td>


														<td>
															<div class="col-sm-7 mb-1 mb-sm-3">
																<input type="reset" class="btn btn-primary btn-sm"
																	value=" Clear ">
															</div>

														</td>

														<td></td>






													</tr>
												</table>
												<br>
												<br>
												<br>
												<br>
												<br>
											</form:form>


										</div>

									</div>
								</div>
							</div>
						</div>






						<div class="col-xl-6 col-md-6mb-4">
							<div class="card  shadow ">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">

											<table id="eqTypeTable"
												class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar tabStyle"
												cellspacing="0">

												<thead>
													<tr>
														<th>Lane Type</th>
														<th>Lane</th>
														<th>Lane Capacity</th>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tbody id="myTable">
													<c:forEach items="${allLaneHead}" var="allLaneHead">
														<tr>
															<td><div>${allLaneHead.laneID.lane}</div></td>
															<td><div>${allLaneHead.laneName}</div></td>
															<td><div>${allLaneHead.laneCap}</div></td>

															<td><div>
																	<a class="btn btn-primary btn-sm"
																		href="TestLaneDetails?id=${allLaneHead.testLaneHeadId}">Configure
																		Lanes</a>
																</div></td>

															<td><a
																href="editLaneHead?id=${allLaneHead.testLaneHeadId}"><i
																	class="material-icons">&#xE254;</i></a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>

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
		function setProgress() {

			var str = document.getElementById("icenterId").value;
			if (str == "") {
				return;
			} else {
				$.ajax({
					type : 'GET',
					url : "setProgress",
					data : {
						"centerID" : str
					},
					success : function(data) {

						// var x = document.getElementById("makeImg");

						$('#progress_percent').text(data);
						$('progress').attr({
							value : data,
							max : 100
						});
					},
					error : function() {
						// alert("No Return Make Logo");
					}

				});
			}
		}

		function progress() {

			$('#progress_percent').text(0);
			$('progress').attr({
				value : 0,
				max : 100
			});

		}
	</script>

</body>
</html>
