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
							<h4 class="page-title">Document Check</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Capture License Plate</a>
								</li>
							
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Document Check</a>
								</li>
							</ul>
						</div>
				
								<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9 col-md-6mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
										<input type="hidden" value='<%=session.getAttribute("vehicleAutoConfig")%>' id="autoValue" >
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
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>
													<form:form action="savaCheckDocument" method="post"
														modelAttribute="documentmodel">


														<div class="form-group row">
			
															<div class="col-sm-12">
																
													



																<div class="row">
																	<div class="col-sm-3">
																		<table id="ocrdetails"
																			class="table1 myTable table table-sm table-wrapper-scroll-y my-custom-scrollbar"
																			style="height: 112px;">
																			<tbody id="ocrdetailstbody">

																			</tbody>
																		</table>

																	</div>
																	<div class="col-sm-4">

																		<%-- 			             		<c:if test = "${imgVe == null}"> --%>
																		<img src="data:image/jpg;base64,${imgVe}"
																			class="capCam" id="results" /> <input
																			class="form-control textred" id="ocid" name="ocid"
																			value="${ocid}" type="hidden" />
																		<%-- 			             		</c:if>	 --%>

																	</div>
																	<div class="col-sm-5">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<input class="form-control textred"
																					name="vecNo" value="${vecNo}" id="vno"
																					placeholder="Licence Plate NO..."
																					
																					readonly="true" />
																				
																			</div>
																		</div>
																	
																		<div class="row">
																			<div class="col-sm-6">
																				
																			</div>
																			<div class="col-sm-5">
																			<input class="form-control form-control-sm"
																			name="curMi" id="curMi" value="${curMi}" hidden="true"/>
																		<input class="form-control form-control-sm"
																			name="id" id="id" value="${id}" hidden="true"/>
																			</div>


																	
																		</div>
																	</div>
																</div>







															</div>
														</div>
										
													

													<table id="eqTypeTable" 
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0" style="height: 200px;">
	
														<thead>
															<tr>
																<th>Document ID</th>
																<th>Description</th>
																<th>Remarks</th>
																<th>Status</th>
																
															</tr>
														</thead>
														<tbody id="myTable">
														 
															<c:forEach items="${documentlist}"
																var="doc" varStatus="i"> <%--Loop Status --%>
																<tr>
																	<td><div><input class="form-control form-control-sm textfi" type="text" name="docid"  readOnly="true" value="${doc.documentid}" /></div></td>
																	<td><div>${doc.description}</div></td>
																	<td><div>${doc.remarks}</div></td>
																	<td><div>
<!-- 																<select class="custom-select"name="docStatus"  > -->
<!-- 																		<option value="N/A">N/A</option> -->
<!-- 																		<option value="OK">OK</option> -->
<!-- 																		<option value="Not OK">Not OK</option> -->
<!-- 																	</select>		 -->
																
																	
												<div class="btn-group btn-group-toggle" data-toggle="buttons">
									  <label class="btn btn-outline-success btn-sm">
							    <input type="radio" name="docStatus" id="option1" value="OK" > OK
									  </label>
									  <label class="btn btn-outline-primary btn-sm">
									    <input type="radio" name="docStatus" id="option2" value="Not OK" > Not OK
									  </label>
									  <label class="btn btn-outline-info btn-sm">
									    <input type="radio" name="docStatus" id="option3" value="N/A" > N/A
									  </label>
									</div>
												
																	
																	</div></td>
																	
																</tr>
															</c:forEach>
														</tbody>
													</table>

 

														<table>
															<tr>
															
															
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3 justify-content-end">
																		<input type="submit" class="btn btn-success"
																			value="Continue">
																	</div>
																</td>
															</tr>
														</table>
														</form:form>
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
takeAutoNo();
	function takeAutoNo() {
		 
//		 var str = document.getElementById("ocrid").value;
//		 var y=0;
//		 if(str!=""){
//			 y=str;					 
//		 }
//		document.getElementById("lice-msg").style.display = "none";
//		document.getElementById("loader").style.display = "block";
//		document.getElementById("cam-click").style.display = "none";
			
		
//		var jsonfile={id:y,mthod:meth};
	var autoValue=document.getElementById('autoValue').value;

	if(autoValue.split("-")[0].substring(1,1)=="0"){

		$.ajax({

		    type: 'POST',
		    url: "takeOcrNo", 
		    data: {"method":"docStatus"},
	       success: function(data){
	       	
//	            var slctSubcat=$('#ocrdetails'), option="";
//	            slctSubcat.empty();
//	            selected_option = "  <tr><td></td></tr>"
//	            slctSubcat.append(selected_option);
	       	
	      	$("#ocrdetails tbody").empty();
				for(var i=0; i<data.length; i++){
				
					var markup =  "<tr data-folder='ghjgh'><td>"+ data[i].ocrVid+ "</td>"
			           // +"<td><img src=data:image/jpg;base64,"+ data[i].noimage+" style='height:20px; width:30px;'></td>"
			            +"<td style='display:none;'>"+ data[i].noimage+"</td>"
			            +"<td style='display:none;'>"+ data[i].ocrid+"</td>"
			            +"<td style='display:none;'>"+ data[i].vehicletype+"</td>"
			            +"</tr>";
						
			            //;
			            $("#ocrdetails tbody").append(markup);
	          	 }
	       	
	       	
	   
	  	
	     	
	       },
	       error:function(){
	       	alert("Error");
	       }
		 });
	}

//		});

	}



    	var table = document.getElementsByTagName("table")[0];
     	var tbody = table.getElementsByTagName("tbody")[0];
     	tbody.onclick = function (e) {
     	    e = e || window.event;
     	    var data = [];
     	    var target = e.srcElement || e.target;
     	    while (target && target.nodeName !== "TR") {
     	        target = target.parentNode;
     	    }
     	    if (target) {
     	        var cells = target.getElementsByTagName("td");
     	        for (var i = 0; i < cells.length; i++) {
     	            data.push(cells[i].innerHTML);
     	        }
     	    }
     			document.getElementById('vno').value = data[0];
     			//document.getElementById('ocid').value = data[2];
     		//	getVMasterData(data[0]);
     			//document.getElementById('results').src = "data:image/jpg;base64,"+data[1];

     	};
    </script>

</body>
</html>