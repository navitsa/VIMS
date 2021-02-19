<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>

    <!-- Custom styles for this page -->
    <link href="resources/css/accordion.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css" integrity="sha512-PMjWzHVtwxdq7m7GIxBot5vdxUY+5aKP9wpKtvnNBZrVv1srI8tU6xvFMzG8crLNcMj/8Xl/WWmo/oAP/40p1g==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

    
<style>
.error1{color:red;font-size: 12px }
         
.fontcolor{color: blue;}
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

	              <!-- Card style="width: 35rem; margin: 0 auto;" -->
	              <div class="card shadow mb-4">
	                <div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Visual Inspection Checklist</h6>
	                </div>
	                <div class="card-body">
	                
						<div class="accordion js-accordion">
						
						 	<form:form action="saveCheckListData" method="POST" modelAttribute="checklistMaster" id="form1" enctype="multipart/form-data">
							<div class="accordion__item js-accordion-item active">
	
							    <div class="accordion-header js-accordion-header">General Information</div> 
							  <div class="accordion-body js-accordion-body">
							    <div class="accordion-body__contents">
									
							    	<span class="bg-danger text-white">${msg}</span><br>
									<c:if test = "${pendingViVehicles == null}">
										<span class="bg-danger text-white">No Registered Vehicles for Visual Inspection</span>
									</c:if>
									
							    	<div class="form-group row">
							    		<div class="col-sm">
							    			<label for="vehicleID" class="text-gray-900"><span class="required text-danger">*</span> License Plate No.</label>
								    		<form:select path="vr.vregID" id="vehicleID" class="custom-select" required="Select a vehicle ID" onchange="getInfo()">													
												<form:option value="">License Plate #</form:option>																																			
													<c:forEach items="${pendingViVehicles}" var="pendingVehicles">
														<form:option value="${pendingVehicles.vregID}">${pendingVehicles.vid.vehicleID}</form:option>
													</c:forEach>
											</form:select>
							    		</div>
							    		<div class="col-sm">
							    			<img src="resources/img/car-placeholder.jpg" height="80"/>
							    		</div>					
									</div>
									<div class="form-group row">
										<div class="col-sm">
									 		<label for="" class="text-gray-900">Inspector :</label>
									 		<label class="fontcolor"><%=session.getAttribute("username")%></label>
										</div>
										<div class="col-sm">
									 		<label for="" class="text-gray-900">Registration No :</label>
									 		<c:if test = "${regVehicleInfo.vregID == null}">
									 			<label class="fontcolor">####</label>
									 		</c:if>
									 		<c:if test = "${regVehicleInfo.vregID != null}">
									 			<label class="fontcolor">${regVehicleInfo.vregID}</label>
								       		</c:if>								
										</div>  
								    </div>
								    <div class="form-group row">
								    	<div class="col-sm">
									 		<label for="" class="text-gray-900">Conducted On <span class="required text-danger">*</span></label>

												<div class="input-group date" id="datetimepicker1" data-target-input="nearest">
												    <form:input path="time" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
												    <form:input path="date" type="hidden" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
												     <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
												       <div class="input-group-text"><i class="fa fa-calendar"></i></div>
												     </div>
												</div>
								    	</div>
								    	<div class="col-sm">
								    		<label for="" class="text-gray-900 mt-3">Token ID :</label>
									 		<c:if test = "${regVehicleInfo.trid == null}">
									 			<label class="fontcolor">####</label>
									 		</c:if>
									 		<c:if test = "${regVehicleInfo.trid != null}">
									 			<label class="fontcolor">${regVehicleInfo.trid.trID}</label>
								       		</c:if><br>
								       		<label for="" class="text-gray-900 mt-3">Lane :</label>
								       		<label class="fontcolor">${regVehicleInfo.testLaneHeadId.laneName}</label>
								    	</div>
								    </div>
	
	<!-- 								 <label for="" class="text-gray-900 mb-2 mr-sm-2">Fuel Type <span class="required text-danger">*</span></label> -->
	<%-- 							       <form:input path="" id ="fuelType" class="form-control mb-2 mr-sm-2" readonly="true" value="${regVehicleInfo.vid.ftype.fuel}"/> --%>
											
								       <form:input path="cheklistID" type="hidden"/>
								       
								       <form:input path="partnerID" id ="partnerID" type="hidden" value="${regVehicleInfo.centermaster.partner_ID.partner_ID}"/>
								       
								       <form:input path="centerID" id ="centerID" type="hidden" value="${regVehicleInfo.centermaster.center_ID}"/>
								       
								       <form:input path="laneID" id ="laneID" type="hidden" value="${regVehicleInfo.testLaneHeadId.testLaneHeadId}"/>
								       
								       <form:input path="profileID" id ="profileID" type="hidden" value="${vProId}"/>
								       
								       <form:input path="vehicleID" type="hidden" value="${regVehicleInfo.vid.vehicleID}"/>
								       
								       <form:input path="fuelTypeID" id ="fuelTypeID" type="hidden" value="${regVehicleInfo.vid.ftype.fuelTypeID}"/>
								       
								       <form:input path="userID" type="hidden" class="form-control" value='<%=session.getAttribute("userId")%>'/>
								       
							    </div>
							    </div><!-- end of accordion body -->
							 
							  </div><!-- end of accordion item -->
	<%--  						</form:form> --%>
						  <div class="accordion__item js-accordion-item">
						  
						    <div class="accordion-header js-accordion-header">Inspection</div>
						    
						  <div class="accordion-body js-accordion-body">
						    <div class="accordion-body__contents">
						      Visually inspect and check the operation of all parts fitted to the vehicle !
						    </div>
						    	
						      <div class="accordion js-accordion">
						      
						      <form:form modelAttribute="visualChecklistDetailForm" id="form2" enctype="multipart/form-data">
						      
						      <c:set var = "proId"  value = "${vProId}"/>
						      
						      <c:forEach items="${listStages}" var="stage"> <%--Loop stages --%>
						      
						      	<c:if test = "${stage.vp.visualProfileID == proId}">
	
						        <div class="accordion__item js-accordion-item">
						           <div class="accordion-header js-accordion-header">${stage.stage}</div>
						           <div class="accordion-body js-accordion-body">
						             <div class="accordion-body__contents">
						             	
						             	<c:set var = "stageID"  value = "${stage.stageID}"/> <%-- put stage id in a variable --%>
						             	<c:forEach items="${listItems}" var="item" varStatus="z">	<%--Loop Items --%>
						             	
						              		<c:if test = "${item.stage.stageID == stageID}"> <%-- item if condition  --%>
						              		
						              		<div class="form-group row">
						              			<div class="col-sm">
						              				<strong>${item.itemName}</strong>
											     </div>
											     <div class="col-sm-2">
											       <c:if test = "${item.itemImage != null}">
											        	<img src="data:image/jpg;base64,${item.itemImageView}" width="50" height="50"/>
											       </c:if>
											     </div>
						              			<input type="hidden" name="checklistDetail[${z.index}].vcm.cheklistID" value="${checklistMaster.cheklistID}">
						              			<input type="hidden" name="checklistDetail[${z.index}].partnerID" value="${regVehicleInfo.centermaster.partner_ID.partner_ID}">
												<input type="hidden" name="checklistDetail[${z.index}].stage.stageID" value="${stage.stageID}">
												<input type="hidden" name="checklistDetail[${z.index}].item.itemId" value="${item.itemId}">
						              			
						              				<c:set var = "itemID"  value = "${item.itemId}"/> <%-- put item id in a variable --%>
						              				<div class="col-sm">
							              				<div class="btn-group btn-group-toggle" data-toggle="buttons">
								              				<c:forEach items="${listItemsStatus}" var="status"  varStatus="i"> <%--Loop Status --%>
								              				
								              					<c:if test = "${status.item.itemId == itemID}"> <%-- status if condition  --%>
			
													           		<label class="btn btn-outline-primary btn-sm">
		    															<input type="radio" name="checklistDetail[${z.index}].status.profileItemStatusID" autocomplete="off" value="${status.profileItemStatusID}" onchange="getRemarks(this.value,${z.index})">														
		    														    <c:if test = "${status.statusMark != null}">
		    																<img src="data:image/jpg;base64,${status.statusMarkView}" width="40" height="40"/>
		    															</c:if>
		    															<c:if test = "${status.statusMark == null}">
		    																${status.vprofileItemStatus}
		    															</c:if>
		    														</label>
		     
															    </c:if> <%-- End of status if condition  --%> 
															</c:forEach> <%-- End of Loop Status --%>
														</div><br>
	
														  <button class="btn btn-sm" type="button" data-toggle="collapse" data-target="#collapseExample${z.index}" aria-expanded="false" aria-controls="collapseExample">
														    <i class="fa fa-plus-circle" aria-hidden="true"></i>
														  </button>
														  
														  <button class="btn btn-sm" type="button" data-toggle="collapse" data-target="#collapseExampleb${z.index}" aria-expanded="false" aria-controls="collapseExample">
															<i class="fa fa-camera" aria-hidden="true"></i>
														  </button>
													</div>
	
						              		</div>
												
												<div id="accordion${z.index}">	  
													<div class="collapse" id="collapseExample${z.index}" data-parent="#accordion${z.index}">
														<div class="card card-body">
															  <div class="form-check" id="formCheck${z.index}">
		<!-- 													    <input type="checkbox" class="form-check-input" id="exampleCheck1"> -->
		<!-- 													    <label class="form-check-label" for="exampleCheck1">Check me out</label> -->
															  </div>
															  
													    	<textarea class="form-control" rows="3" id="comment" name="checklistDetail[${z.index}].remarkName" placeholder="Enter any remark here..."></textarea>
													    </div>
													</div>
		
													<div class="collapse" id="collapseExampleb${z.index}" data-parent="#accordion${z.index}">
														<div class="card card-body">
															<input type="file" class="form-control-file" accept="image/*" capture="user" name="checklistDetail[${z.index}].image">
															<span class="required text-danger">Rear camera will be opened on android and iOS devices</span>
													    </div>
													</div>
												</div>
						              		<hr>
						              		</c:if> <%-- End of item if condition  --%>
						              	</c:forEach> <%--End of Loop items --%>
						              	
						             </div><!-- end of sub accordion item body contents -->
						           </div><!-- end of sub accordion item body -->
						        </div><!-- end of sub accordion item -->
						        
						        </c:if> <%-- End of profile if condition  --%> 
						        
						       </c:forEach> <%--End of Loop stages --%>
						       
						      </form:form>
	
						        <div class="accordion__item js-accordion-item">
						           <div class="accordion-header js-accordion-header">Summary</div> 
						           <div class="accordion-body js-accordion-body">
						             <div class="accordion-body__contents">
						             
									 <label for="status" class="text-gray-900 mb-2 mr-sm-2">Rate the overall condition of the vehicle</label>
	<!-- 									<input type="text" name="overallstatus" class="form-control mb-2 mr-sm-2" form="form1"/> -->
										<br>
										<div class="btn-group btn-group-toggle" data-toggle="buttons">
										  <label class="btn btn-outline-success btn-sm">
										    <input type="radio" name="overallstatus" id="option1" value="Excellent" form="form1"> Excellent
										  </label>
										  <label class="btn btn-outline-primary btn-sm">
										    <input type="radio" name="overallstatus" id="option2" value="Good" form="form1"> Good
										  </label>
										  <label class="btn btn-outline-info btn-sm">
										    <input type="radio" name="overallstatus" id="option3" value="Average" form="form1"> Average
										  </label>
										  <label class="btn btn-outline-warning btn-sm">
										    <input type="radio" name="overallstatus" id="option4" value="Poor" form="form1"> Poor
										  </label>
										  <label class="btn btn-outline-danger btn-sm">
										    <input type="radio" name="overallstatus" id="option5" value="High Risk" form="form1"> High Risk
										  </label>
										</div>
										<br><br>
								       <label for="remark" class="text-gray-900 mb-2 mr-sm-2">Overall Remark</label>
										<input type="text" id="remark" name="overallremark" class="form-control" form="form1"/>
										<form:errors path="overallremark" class="bg-danger text-white"/>
	
								       
						             </div><!-- end of sub accordion item body contents -->
						           </div><!-- end of sub accordion item body -->
						        </div><!-- end of sub accordion item -->
						        					        
						      </div><!-- end of sub accordion -->
						    </div>
						    
						    </div><!-- end of accordion body -->
						    <br>
							
							<label for="" class="text-gray-900 mb-2 mr-sm-2">End on <span class="required text-danger">*</span></label>
							<input type="button" value="NOW" class="btn btn-primary btn-sm" onclick="setEndTime()"/>
	
								<div class="input-group date" id="datetimepicker2" data-target-input="nearest">
									<input type="text" name="endtime" class="form-control datetimepicker-input" data-target="#datetimepicker2" form="form1"/>
										<div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
											<div class="input-group-text"><i class="fa fa-calendar"></i></div>
										</div>
								</div><br>
							<label for="submitButton" class="required text-danger">Mandatory</label>
						    <input type="submit" value="MARK AS COMPLETE" class="btn btn-success form-control" id="submitButton" form="form1"/>
	
							</form:form>
						  </div><!-- end of accordion item -->
	
		            </div> <!-- End of card body -->
	              </div>

					
				</div>	
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
	
<%@include file="../WEB-INF/jsp/commJs.jsp"%>
<!-- Page level custom scripts -->
	<script src="resources/js/accordion.js"></script>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js"></script>

  <script>
  
  	function getPending() {
		
  		var x = document.getElementById("vehicleID");
		   $.ajax({
		    type: 'GET',
		    url: "checktPendingVehiclesAreAvailable",
		    data: {"vehicle_no" :x.value},
		    
		    success: function(data){
		    	
		    	if(data.vregID == null)
		    		alert("There is an error on vehicle registration !");
		    	else
		    		{
				    	if (confirm("To Continue Please Click Ok ! ")) {
							  txt = "You pressed OK!";
							  //location.reload(true);
							  
							  //document.getElementById("vRegID").value = data.vregID;
							  //document.getElementById("fuelType").value = data.vid.ftype.fuel;
							  //document.getElementById("fuelTypeID").value = data.vid.ftype.fuelTypeID;
							  //document.getElementById("partnerID").value = data.bpatner.partner_ID;
							  //document.getElementById("centerID").value = data.centermaster.center_ID;
							  //document.getElementById("laneID").value = data.lane.laneId;
							  
							  window.location.href = "gettingDataForVI?vehicle_no="+ x.value;
							  
							} else {
							  txt = "You pressed Cancel!";
							}
		    		}
		        	
		        },
		        error:function(){
		            alert("Warning! Something went wrong ! Please contact system administrator ! ");
		        }
		
		    });
		}
	</script>
	
	<script>
	function getInfo()
	{
		var x = document.getElementById("vehicleID");
		
		if(x.value !="")
		{
		
    	if (confirm("To Continue Please Click Ok ! ")) {
			  txt = "You pressed OK!";
			  window.location.href = "gettingDataForVI?vReg_Id="+ x.value;
			  
			} else {
			  txt = "You pressed Cancel!";
			}
		}
	}
	</script>

    <script type="text/javascript">
    	var default_date=  new Date();
        $(function () {
            $('#datetimepicker1').datetimepicker({
                useCurrent:false,
                defaultDate: default_date
            });
          });
        
        function setEndTime(){
        	var curr_date=  new Date();
            $('#datetimepicker2').datetimepicker({
                useCurrent:false,
                defaultDate: curr_date
            });
        }

    </script>


    <script type="text/javascript">
    
	    var submitForm = function(thisForm) {
	    	var form = document.getElementsByTagName("form");
	    	//form[thisForm].submit();
	    	};
	    	//window.onunload = function() { submitForm("form2"); };
    </script>
    
<c:if test = "${success ==1}">    
	<script type="text/javascript">
		Swal.fire(
			'Good job!',
			'Visual Inspection Successfully Completed!',
			'success'
		)
	</script>
</c:if>
<c:if test = "${success ==0}">
	<script type="text/javascript">
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Something went wrong!'
		})
	</script>
</c:if>

 <script src="resources/ajax/get_remarks_in_vi.js"></script>
 
</body>
</html>