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
							<h4 class="page-title">Test Profiles</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
									<a href="#">Test Profilesr</a>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
									<a href="#">Mandatory Test Types</a>
								
							</ul>
						</div>
				
	
							<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9 col-md-12 mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">



	
<form name="ProfileStatusForm" id="ProfileStatusForm" action="saveProfileStatus"
					method="GET">
					<div class="modal-body">

						<div class="alert alert-success alert-dismissible" style="display: none;" id="saveMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Success!</strong> Data Successfully Saved.
						</div>
						<div class="alert alert-success alert-dismissible" style="display: none;" id="updateMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Success!</strong> Data Successfully Updated.
						</div>
						<div class="alert alert-danger alert-dismissible" style="display: none;" id="errorMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Warning!</strong>Something went wrong ! Please try
							again!
						</div>

						<div class="form-group row">
							<div class="col-lg-6">
								<select id="testProfile" class="custom-select custom-select-sm"
									required="required" name="profile_id">
									<option value="0">Select test profile...</option>
									<c:forEach items="${testProfile}" var="testProfile">
										<option value="${testProfile.testProfileID}">${testProfile.testProfileName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-6">
								<select class="custom-select custom-select-sm"
									required="required" name="type_id">
									<option value="">Select test type...</option>
									<c:forEach items="${testTypes}" var="testTypes">
										<option value="${testTypes.typeId}">${testTypes.type}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-lg">
								<div class="form-inline">
									<label for="ordering_no" class="mr-sm-2">Serial No</label>
									<select class="custom-select custom-select-sm" name="serial_no" required>
										<option value=1 selected>1</option>
										<option value=2 >2</option>
										<option value=3 >3</option>
										<option value=4 >4</option>
										<option value=5 >5</option>
										<option value=6 >6</option>
									</select>
									<a href="#" data-toggle="tooltip" 
										title="The test result report is printed in the order of serial number of the test type">
									<i class="fa fa-question-circle" style="font-size:14px"></i>
									</a>
								</div>
							</div>
						</div>

						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="mandatory"
								name="status" value=0 checked="checked"> <label
								class="custom-control-label" for="mandatory">Mandatory</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input"
								id="nonmandatory" name="status" value=1> <label
								class="custom-control-label" for="nonmandatory">Non-Mandatory</label>
						</div>
						<br>
						<br>
						<div style="height: 300px; overflow: auto;">
							<table class="table table-sm" id="profileStatus">
								<thead>
									<tr>
										<th>Profile</th>
										<th>Test Type</th>
										<th>Mandatory</th>
										<th>Serial No</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${testProfileStatus}" var="status">
										<tr>
											<td>${status.profile_id.testProfileName}</td>
											<td>${status.type_id.type}</td>
											<td><c:if test="${status.status==0}">
													<i class="fa fa-check-circle"
														style="font-size: 24px; color: green"></i>
												</c:if> <c:if test="${status.status==1}">
													<i class="fa fa-times-circle"
														style="font-size: 24px; color: red"></i>
												</c:if>
											</td>
											<td>${status.serial_no}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">Save
							changes</button>
					</div>
				</form>
	
				
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

	<script type="text/javascript">

$("#ProfileStatusForm").submit(function(event) {
    event.preventDefault(); //prevent default action 
    let post_url = $(this).attr("action"); //get form action url
    let request_method = $(this).attr("method"); //get form GET/POST method
    let form_data = $(this).serialize(); //Encode form elements for submission	
    $.ajax({
        url: post_url,
        type: request_method,
        data: form_data
      }).done(function(data) { //
        //$("#server-results").html(response);
      	//alert(data.success);
      	$("#profileStatus tbody").empty();
		for(var i=0; i<data.profile_status_list.length; i++){
			if(data.profile_status_list[i].status==0){
				var markup = "<tr><td>"+data.profile_status_list[i].profile_id.testProfileName+"</td><td>"+data.profile_status_list[i].type_id.type+"</td><td><i class='fa fa-check-circle' style='font-size: 24px; color: green'></i></td><td>"+data.profile_status_list[i].serial_no+"</td></tr>";
			}else{
				var markup = "<tr><td>"+data.profile_status_list[i].profile_id.testProfileName+"</td><td>"+data.profile_status_list[i].type_id.type+"</td><td><i class='fa fa-times-circle' style='font-size: 24px; color: red'></i></td><td>"+data.profile_status_list[i].serial_no+"</td></tr>";
			}
			
       		 $("#profileStatus tbody").append(markup);
       	 }
		if(data.success==0){
			 $('#saveMessage').show();
			 $('#updateMessage').hide();
			 $('#errorMesssage').hide();
		}else if(data.success==1){
			$('#updateMessage').show();
			$('#saveMessage').hide();
			$('#errorMesssage').hide();
		}else{
			$('#errorMesssage').show();
			$('#saveMessage').hide();
			$('#updateMessage').hide();
		}
      });
  });

</script>
</body>
</html>