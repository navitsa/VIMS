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
<body >
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
								 <h2 class="text-white pb-2 fw-bold">Equipment Service</h2>
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

		<form:form action="saveEquipmentsService" modelAttribute="equipmentsService" method="POST" enctype="multipart/form-data" > 
		<div class=" row">
			<div class="col-sm-7">
				<div class=" row">
						<div class="col-sm-6">
							<div class="form-group row">
								<div class="col-sm-6">
									<label class="l-fontst">Schedule Date</label>
									<form:input class="form-control fontst" type="date" path="servicesDate" 
							 		required="true"	id="servicesDate" onchange="getSerVDate();getServiceDate(this.value);"></form:input>
								</div>
								<div class="col-sm-6">
									<label>Equipment Type</label>
									<select class="form-control"   onchange="getSerVDate()" id="eqtype">
									<option value="">--SELECT--</option>
									<c:forEach items="${eqTypeCmbfor}" var="eq1">
									<option value="${eq1.eqTypeID}">${eq1.eqType}</option>
									</c:forEach>
									</select>
								</div>
							</div>	
							<div class="form-group row">
								<div class="col-sm-6">
										<label class="l-fontst">Serviced Date</label>
										<form:input class="form-control fontst" type="date" path="servicedDate" 
										 required="true"	id="servicedDate" onchange="setDate();"></form:input>
								</div>
			
								<div class="col-sm-6">
									<label >Service Inspector</label>
									<form:select class="form-control fontst" path="userId.userId"
												required="Required" id="users" >
									<form:option value="">--SELECT--</form:option>
									<c:forEach items="${calibrationUsercombo}" var="use">
									<form:option value="${use.userId}">${use.userName}</form:option>
									</c:forEach>
									</form:select>
								</div>	
							</div>
							<div class="form-group row">
								<div class="col-sm-6">
										<label class="l-fontst">Next Service Date</label>
										<form:input class="form-control fontst" type="date" path="nextServicesDate" 
										 required="true"	id="nextServicesDate" ></form:input>
								</div>
			
			
									
							</div>	
							<div class="form-group">
								<div class="row">
									<div class="col-7">
<%-- 										<img  class="zoom imagePreview"  src="<c:url value='/resources/img/user-default.jpg'/>" id="preview" class="img-thumbnail">		 --%>
										<label class="btn btn-primary">Upload Services Report<input type="file"  accept="application/pdf"
												class="uploadFile img" value="Upload Pdf" style="width: 0px;height: 0px;overflow: hidden;"  accept="image/*" id="user_Img"
												name="servicesReport"></label>
									</div>
								</div>
							</div>
									
						</div>
						<div class="col-sm-6">
							<div class="form-group row">
								<div class="col-sm-8">
									<label>Equipment</label>
									<form:select class="form-control" path="equipmentID.equipmentID" required="Required" size="14"  id="eqid" onchange="setDate();">
										<form:option value="equipmentID.equipmentID">--SELECT--</form:option>
									</form:select>
								</div>
							</div>
			
			
						</div>
				</div>
			
		
		

	

	
		
				
		
		
		
		
		
		
		
		
		
		
			</div>
			<div class="col-sm-5">
		
		
															<table id="eqservicesTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																<th>Service ID</th>
																<th>Equipment</th>
																<th>Service Date</th>
																<th>Service Date</th>
																<th>Next Service Date</th>
																
																<th>Service Inspector</th>
																<th>Remarks</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allEquipmentsService}"
																var="calibration">
																<tr>
																	<td><div>${calibration.eSalID}</div></td>
																	<td><div>${calibration.equipmentID.serialNo}</div></td>
																	<td><div>${calibration.servicesDate}</div></td>
																	<td><div>${calibration.servicedDate}</div></td>
																	<td><div>${calibration.nextServicesDate}</div></td>
																	<td><div>${calibration.userId.userName}</div></td>
																	<td><div>${calibration.remarks}</div></td>	
<!-- 																	<td><a -->
<%-- 																		href="editEqType?id=${equipmenttype.eqTypeID}"><i --%>
<!-- 																			class="material-icons">&#xE254;</i></a></td> -->
																</tr>
															</c:forEach>
														</tbody>
													</table>
		
		
		
		
		
		
			</div>
		</div>
		<div class="form-group row">
									<div class="col-sm-6">
										<input type="submit" class="btn btn-success"
																			value="Save">
									
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
	
	
	function getSerVDate(){
		var servicesDate=document.getElementById("servicesDate").value;
		var eqtype=document.getElementById("eqtype").value;
		//alert(calibrationDate);
		 		$.ajax({

		 		    type: 'POST',
		 		    url: "getEquipmentServices", 
		 		   data: {"eqtype" : eqtype,"servicesDate" : servicesDate},
		 	        success: function(data){
			            var slctSubcat=$('#eqid'), option="";
			            slctSubcat.empty();
			            option="<option value=''>--SELECT--</option>"
			            for(var i=0; i<data.length; i++){
			                option = option + "<option value='"+data[i].equipmentID+ "'>"+data[i].serialNo + "</option>";
			               
			            }
			            slctSubcat.append(option);
		 	        	
		 	        },
		 	        error:function(data){
		 	        //	alert(data.responseText);
			           
		 	        }
		 		 });
		 		}	
		 		
	</script>
<script type="text/javascript">
//set next cal date
function setDate() {
	
	var d1 = document.getElementById("servicedDate").value;
	var str = document.getElementById("eqid").value;
	

	
	
	if(d1 == "") {
		//$("#nextCalDate").empty();
		$("#nextServicesDate").val("");
		return;
	}else if(str == "") {
		//$("#nextCalDate").empty();
		$("#nextServicesDate").val("");
		return;
	} else {
		
		
				$.ajax({
					type : 'GET',
					url : "getNextCalDate",
					data : {"id" : str,"date":d1,"typ":"SER"},
					success : function(data) {				    
					var someFormattedDate = data;
					document.getElementById('nextServicesDate').value = someFormattedDate;
					
					
					},
					error : function() {
						alert("error");
					}
		
				});
				
	}
	
	
	
}

	function getServiceDate(str){
	
		document.getElementById('servicedDate').value = str;
	
	}
		
	</script>
</body>
</html>