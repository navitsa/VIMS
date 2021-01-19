<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
	.vidSty{
	font-family: Arial, Helvetica, sans-serif;	
	font-size:30px;
	font-weight: bold;
	color: #02d41b;	
	}
	
	
	    .textred{
       font-family: Arial, Helvetica, sans-serif;
        border: 0px solid #b30000;
		font-size:14px;
		font-weight:bold;
       	text-align:center;
       	color: #2c03fc;	
     
       }  
	      .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
           height: 30px;
         }
         .l-fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 5px;
          margin-top: 0px;
         }
        .iconali{
        	position: absolute; 
  			top: 6px;
			right:-7px;
        
        }
        .capCam{

  			height: 100px;
  			width: 210px;	
		}
		.cursiz{
		font-family: Arial, Helvetica, sans-serif;
        font-size: 12px;
		width: 48px;	
		color: #ff8000;
		
		}
		.amt{
		font-family: Arial, Helvetica, sans-serif;
       font-size: 12px;
       width:60px;
		color: blue;
		text-align: right;
		}

	   .iconstyle{		
  			width: 7%;
  			color:blue';
       }
       .icon-pre-ve{
        width: 150%;
  		
       
       }	
</style>
	
</head>
<body onload="checkStatusofDropdowns();">
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
								 <h2 class="text-white pb-2 fw-bold">Repair</h2>
							</div>
							<div class="col-xl-2 col-lg-2">
								
							</div>
							<div class="ml-md-auto py-2 py-md-4">
							  
							
							</div>
						
							<div class="ml-md-auto py-2 py-md-4">
							</div>
						</div>
					</div>
				</div>
				
				<div class="page-inner mt--5">	
					<div class="container-fluid">

							<div class="col-xl-12 col-md-6mb-4">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">

<form:form  modelAttribute="equipmentsRepair" method="POST" enctype="multipart/form-data" id="eqRepair"> 
			<div class=" row">
				<div class="col-sm-7">
					<div class="form-group row">
						<div class="col-sm-3">	
						<label>Ticket No</label>
							<form:select class="form-control fontst" required="Required" path="ticketNo.ticketNo" onchange="getOpenTicketDetails(this.value);"     
								 id="tldid">
								<form:option value="000">--SELECT--</form:option>
								<c:forEach items="${openTicket}" var="openTicket">
									<form:option value="${openTicket.ticketNo}">${openTicket.ticketNo} </form:option>
								</c:forEach>
							</form:select>	
					
					</div>
								<div class="col-sm-3">	
							<label>Job No</label>
					<form:input  path="jobNo" class="form-control"/>
						
					</div>
					</div>
									<div class="form-group row">
					<div class="col-sm-3">	
						<label>Maintenance Cost</label>
						<form:input type="number" path="maintenanceCost" class="form-control"/>	
					</div>
					<div class="col-sm-3">	
						<label>Labor Cost</label>
						<form:input type="number" path="laboCost" class="form-control"/>	
					</div>
				</div>
					
							<div class="form-group row">

					<div class="col-sm-6">
						<label >Remarks</label>
						<form:textarea path="remarks" class="form-control"/>
					</div>
					<div class="col-sm-6">
						
					</div>
				</div>
				</div>
				<div class="col-sm-5">
					
																				<table id="eqCallRepair"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																<th>Repair ID</th>
																<th>Ticket No</th>
																<th>Job No</th>
																<th>Repair Date</th>
																<th>Maintenance Cost</th>
																<th>Labor Cost</th>													
																<th>Remarks</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allRepair}"
																var="rep">
																<tr>
																	<td><div>${rep.idRepair}</div></td>
																	<td><div>${rep.ticketNo.ticketNo}</div></td>
																	<td><div>${rep.jobNo}</div></td>
																	<td><div>${rep.repairDate}</div></td>
																	<td><div>${rep.maintenanceCost}</div></td>
																	<td><div>${rep.laboCost}</div></td>
																	<td><div>${rep.remarks}</div></td>	
<!-- 																	<td><a -->
<%-- 																		href="editEqType?id=${equipmenttype.eqTypeID}"><i --%>
<!-- 																			class="material-icons">&#xE254;</i></a></td> -->
																</tr>
															</c:forEach>
														</tbody>
													</table>
	
				
				</div>
			</div>
				


	
		
				
				
				

<!-- 	<div class="form-group row"> -->
<!-- 		<div class="col-sm-12"> -->
<!-- 			<h2 style="color: #ff0516; font-family: Arial, Helvetica, sans-serif;">Close this Issue will auto set Lane Status Active</h2> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
				<div class="form-group row">
									<div class="col-sm-6">
										<input type="button" class="btn btn-success"
																			value="Save" onclick="saveRepair()">
									
									</div>
									<div class="col-sm-6">
<!-- 										<input type="button" class="btn btn-warning" -->
<!-- 																			onclick="clear1()" value="CLEAR"> -->
									
									</div>
						</div>		
				
				
				
				
			
		
		
</form:form>
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
<script type="text/javascript">
		function saveRepair() {
			
			var request_method = $("#eqRepair").attr("method"); //get form GET/POST method

			// Get form
			var form = $('#eqRepair')[0];

			// Create an FormData object
			var data = new FormData(form);

			//alert("Error "+form_data);
			$.ajax({

				url : "saveRepair",
				type : request_method,
				enctype : 'multipart/form-data',
				data : data,
				processData : false,
				contentType : false,
				cache : false,

				success : function(data) {
				
					if (data == "0") {
						swal("Good job!", "You clicked the button!", {
							icon : "error",
							buttons : {
								confirm : {
									className : 'btn btn-danger'
								}
							},
						});
						
						

					} else {
						swal("Successfuly Save!","" ,{
							icon : "success",
							buttons : {
								confirm : {
									className : 'btn btn-success'
								}
							},
						});
					}
					document.getElementById("eqRepair").reset();
				},
				error : function(e) {
					swal("Good job!", "You clicked the button! err", {
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
					
				}
			});

		}
		</script>
</body>
</html>