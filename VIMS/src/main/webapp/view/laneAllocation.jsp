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
							<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">Lane Allocation</h2>
							</div>
							
							
						
							<div class="ml-md-auto py-2 py-md-4">
							</div>
						</div>
					</div>
				</div>
			
			
			
				<div class="page-inner mt--5">	
					
				 <form:form action="savelaneAllocation" modelAttribute="laneAllocation" method="POST" id="laneAllocation">		
				 	 <div class="row">	
		<div class="col-xl-5 col-lg-5">
				 	<div class="card shadow mb-12">				
						<div class="card-body">
						
						<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-9">
										<label for="manufactureYear" class="l-fontst">Lane</label>	
<!-- 												    type="hidden"         			             		 -->
										<form:input path="id"  type="hidden"/>
											
											<form:select class="form-control fontst" path="testLaneHeadId.testLaneHeadId" onchange="getLaneInspector();"     
												required="Required" id="tldid">
									
												<c:forEach items="${lanes}" var="lan">
													<form:option value="${lan.testLaneHeadId}">${lan.laneName} </form:option>
												</c:forEach>
											</form:select>	
													             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-9">
										<label  class="l-fontst">Lane Inspector</label>
															             			             		
											<form:select class="form-control fontst" path="userId.userId"
												required="Required" id="users" >
												<form:option value="">--SELECT--</form:option>
												<c:forEach items="${users}" var="use">
													<form:option value="${use.userId}">${use.userName}</form:option>
												</c:forEach>
											</form:select>			             		
									</div>
									
								</div>
							
							</div>
										
						 </div>	
						 
						 
						 <div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-9">
										<label for="manufactureYear" class="l-fontst">From Date</label>	
												             			             		
										<form:input type="date"  class="form-control form-control-sm text-primary" path="fromDate" id="fromDate" required="Required"/>
										
													             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-9">
										<label  class="l-fontst">To Date</label>
															             			             		
											<form:input type="date"  class="form-control form-control-sm text-primary" path="toDate" id="toDate" required="Required"/>
													             		
									</div>
									
								</div>
							
							</div>
										
						 </div>
						 
						 
						 		<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-8">
										<label class="l-fontst">From Time</label>	
												             			             		
										<form:input type="time"  class="form-control form-control-sm text-primary" path="fromTime" id="fromTime" required="Required"/>
										
													             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-8">
										<label  class="l-fontst">To Time</label>
															             			             		
											<form:input type="time"  class="form-control form-control-sm text-primary" path="toTime" id="toTime" required="Required"/>
													             		
									</div>
									
								</div>
							
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
						 
						 
						 			<input type="submit" class="btn btn-success" value="Save">
	
						 
				 </div>	
				 </div>	
				 				 </div>	
				 				 
				 				<div class="col-xl-7 col-lg-7"> 
				 					<div class="card shadow mb-12">				
						<div class="card-body"> 
				 				 
				 				 <table id="eqTypeTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																<th>Lane</th>
																<th>Lane Inspector</th>
																<th>Date</th>
																<th>Time</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allLaneAllocation}"
																var="lanAllo">
																<tr>
																	<td><div>${lanAllo.testLaneHeadId.laneName}</div></td>
																	<td><div>${lanAllo.userId.userName}</div></td>
																	<td><div>${lanAllo.fromDate} To ${lanAllo.toDate}</div></td>
																	<td><div>${lanAllo.fromTime} To ${lanAllo.toTime}</div></td>
																	<td><div>${lanAllo.status}</div></td>
																	<td><a
																		href="editLaneAllocation?id=${lanAllo.id}"><i
																			class="material-icons">&#xE254;</i></a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
				 				 
				 				 </div>
				 				 </div>
				 				</div> 
				 				 
				 </div>		
				</form:form>
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script type="text/javascript">

	
	
	
</script>



</body>
</html>