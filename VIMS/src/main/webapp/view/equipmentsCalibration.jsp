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
							<div class="col-xl-4 col-lg-4">
								 <h2 class="text-white pb-2 fw-bold">Equipment Calibration</h2>
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

		<form:form action="saveEquipmentsCalibration" modelAttribute="equipmentscalibration" method="POST" enctype="multipart/form-data" > 

		
		<div class=" row">
			<div class="col-sm-7">
					<div class=" row">
						<div class="col-sm-6">		
							<div class="form-group row">
								<div class="col-sm-6">
									<label class="l-fontst">Schedule Date</label>
									<form:input class="form-control fontst" type="date" path="calibrationDate" 
									 required="true"	id="calibrationDate" onchange="getCalibrationDate();getCalibratedDate(this.value);"></form:input>
								</div>
								<div class="col-sm-6">
									<label>Equipment Type</label>
									<select class="form-control"   onchange="getCalibrationDate();" id="eqtype">
										<option value="">--SELECT--</option>
										<c:forEach items="${eqTypeCmbfor}" var="eq1">
											<option value="${eq1.eqTypeID}">${eq1.eqType}</option>
										</c:forEach>
									</select>
								</div>				
							</div>
							<div class="form-group row">
								<div class="col-sm-6">
										<label class="l-fontst">Calibrated Date</label>
										<form:input class="form-control fontst" type="date" path="calibratedDate" 
										 required="true"	id="calibratedDate" onchange="setDate();"></form:input>
								</div>				
								<div class="col-sm-6">
									<label >Inspector/Supervised By</label>
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
									<form:radiobutton path="calabriType" value="Schedule Calibration"/>
										&nbsp;Schedule Calibration								
								</div>
								<div class="col-sm-6">
									<form:radiobutton path="calabriType" value="Calibration on Demand" />
								 &nbsp;Calibration on Demand
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
								  <h3 style="color: #ff0516; font-family: Arial, Helvetica, sans-serif;" >By Selecting on Demand Calibration will not Update Equipment Calibration Status</h3>
								</div>
							</div>
									<div class="form-group">
								<div class="row">
									<div class="col-7">
<%-- 										<img  class="zoom imagePreview"  src="<c:url value='/resources/img/user-default.jpg'/>" id="preview" class="img-thumbnail">		 --%>
										<label class="btn btn-primary">Upload Calibration Report<input type="file"  accept="application/pdf"
												class="uploadFile img" value="Upload Pdf" style="width: 0px;height: 0px;overflow: hidden;"  accept="image/*" id="user_Img"
												name="calibrationReport"></label>
									</div>
								</div>
							</div>
		
		
		
<!-- 							<input type="file" class="file" -->
<!-- 							id="calibrationReport" name="calibrationReport"  accept="application/pdf"> -->
<!-- 						<div class="input-group my-3"> -->
<!-- 							<input type="text" -->
<!-- 								class="form-control form-control form-control-user" -->
<!-- 								disabled placeholder="Upload pdf " id="file"> -->
<!-- 							<div class="input-group-append"> -->
<!-- 								<button type="button" class="browse btn btn-primary">Browse</button> -->
<!-- 							</div> -->
<!-- 							<br> -->

<!-- 						</div> -->
		
		
		
		
		
						</div>
						<div class="col-sm-6">
							<div class="form-group row">
								<div class="col-sm-8">
											<label>Equipment</label>
											<form:select class="form-control" path="equipmentID.equipmentID" required="Required" size="14" id="eqid" onchange="setDate();">
												<form:option value="equipmentID.equipmentID">--SELECT--</form:option>
											</form:select>																	
								</div>
							</div>
		
						</div>
					</div>
			
			
			
			
		

		<div class="form-group row">
						<div class="col-sm-10">
						<label >Remarks</label>
						<form:textarea path="remarks" class="form-control"/>
				</div>
		</div>
		<div class="form-group row">
						<div class="col-sm-3">	
						<label >Calibration Status</label>
						<form:select class="form-control fontst" path="calibrationStatus"
												required="Required" id="calibrationStatus" onchange="setDate();">
						<form:option value="">--SELECT--</form:option>
						<form:option value="PASS">PASS</form:option>
						<form:option value="FAIL">FAIL</form:option>
						</form:select>
					
				</div>
				<div class="col-sm-3">
						<label class="l-fontst">Next Calibration Date</label>
						<form:input class="form-control fontst" type="date" path="nextCalibratedDate" 
						 required="true"	id="nextCalibratedDate" ></form:input>
				</div>
				<div class="col-sm-3">
				
				</div>

									
		</div>	

	
		
				<div class="form-group row">
					<div class="col-sm-8">
						
						
	
				
						
						
						
						
						
					</div>
				</div>
		
		
		
		
		
		
		
		
		
		
			</div>
			<div class="col-sm-5">
		
		
															<table id="eqCalibrationTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																<th>Calibration ID</th>
																<th>Equipment</th>
																<th>Calibration Date</th>
																<th>Calibrated Date</th>
																<th>Next Calibration Date</th>
																<th>Calibration Status</th>
																
																<th>Calibration Inspector</th>
																<th>Remarks</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allCalibration}"
																var="calibration">
																<tr>
																	<td><div>${calibration.eCalID}</div></td>
																	<td><div>${calibration.equipmentID.serialNo}</div></td>
																	<td><div>${calibration.calibrationDate}</div></td>
																	<td><div>${calibration.calibratedDate}</div></td>
																	<td><div>${calibration.nextCalibratedDate}</div></td>
																	<td><div>${calibration.calibrationStatus}</div></td>
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
	
	
	function getCalibrationDate(){
		var calibrationDate=document.getElementById("calibrationDate").value;
		var eqtype=document.getElementById("eqtype").value;
		//alert(calibrationDate);
		 		$.ajax({

		 		    type: 'POST',
		 		    url: "getEquipmentCalibration", 
		 		   data: {"eqtype" : eqtype,"calibrationDate" : calibrationDate},
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
	var calibrationStatus = document.getElementById("calibrationStatus").value;
	var d1 = document.getElementById("calibratedDate").value;
	var str = document.getElementById("eqid").value;
	

	
	
	if(d1 == "") {
		//$("#nextCalDate").empty();
		$("#nextCalibratedDate").val("");
		return;
	}else if(str == "") {
		//$("#nextCalDate").empty();
		$("#nextCalibratedDate").val("");
		return;
	}else if(calibrationStatus == "") {
		$("#nextCalibratedDate").val("");
		return;
	} else if(calibrationStatus=="PASS"){
		
		
				$.ajax({
					type : 'GET',
					url : "getNextCalDate",
					data : {"id" : str,"date":d1,"typ":"CAL"},
					success : function(data) {				    
					var someFormattedDate = data;
					document.getElementById('nextCalibratedDate').value = someFormattedDate;
					
					
					},
					error : function() {
						alert("error");
					}
		
				});
				
	}else{
		
		document.getElementById('nextCalibratedDate').value = d1;
	}
	
	
	
}

	function getCalibratedDate(str){
	
		document.getElementById('calibratedDate').value = str;
	
	}
		
	</script>
</body>
</html>