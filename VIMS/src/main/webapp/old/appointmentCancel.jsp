<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Appointment Cancel</title>
<!-- head -->
<%@include file="../WEB-INF/jspf/head.jsp"%>
<link rel="stylesheet" 
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<div class="row">
						<div class="col-xl-4 col-md-5">
							<!-- Card 1 -->
							<div class="card shadow mt-2" style="height: 600px;">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-header py-2">
										<h6 class="m-0 font-weight-bold text-primary">Appointment Cancel</h6>
									</div>
									<div class="card-body">

										<div class="form-group row">
											<div class="col-lg">
											
												<div style="overflow:hidden;">        
									            	<div class="form-group">
										                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
															<%-- <form:input path="appointmentTime" type="hidden" class="datetimepicker-input"
																data-target="#datetimepicker1"/> --%>
															<input name="appointmentDate" type="hidden" class="datetimepicker-input" 
																data-target="#datetimepicker1" id="appointmentDate"/>
										                </div>
										            </div>
												</div>
												
											</div>
										</div>
										<hr>
										<div class="form-group row">
											<div class="col-lg">
												<button type="button"
													class="btn  btn-block btn-danger btn-rounded"
													onclick="">Cancel</button>
											</div>
										</div>

									</div>
									<!-- End of card body -->
								</div>
							</div>

						</div> 
						<!-- 1 col end -->
						
						<div class="col-xl-4 col-md-5">
							<!-- Card 2 -->
							<div class="card shadow mt-2" style="height: 600px;">
								<div class="shadow h-100 py-2">
									<div class="card-header py-2">
										<h6 class="m-0 font-weight-bold text-primary" id="card2header"><span></span></h6>
									</div>
									<div class="card-body">

										<table class="table" id="tablex">
										  <tbody>
										  </tbody>
										</table>

									</div>
									<!-- End of card body -->
								</div>
							</div>
						</div>
						<!-- 2 col end -->

					</div>
					<!-- 1 row end -->

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<%@include file="logoutModel.jsp"%>
	<!-- Bootstrap core JavaScript-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->


	<!-- Page level custom scripts -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
		
<script type="text/javascript">
    $(function () { 	
        $('#datetimepicker1').datetimepicker({
            inline: true,
            sideBySide: true,
            format: 'L'
        });

        $('#datetimepicker1').on("change.datetimepicker", function (e) {
         	getPendingAppointments();
          });
    });
   
</script>

<script type="text/javascript">
	$(function () { 	
		getPendingAppointments();		
	});
</script>

<script type="text/javascript">
	function getPendingAppointments() {
		
		var date = $('#datetimepicker1').datetimepicker('viewDate').format('YYYY-MM-DD');
		$('#card2header span').text(date);
		
		$.ajax({
	    	type: 'GET',
	    	url: "getPendigAppointments",
	    	data: {"selectedDate":date},
		    success: function(x){
		    	$("#tablex tbody").empty();
	            for(var i=0; i<x.length; i++){
	            	
					var markup = "<tr><td>"+x[i].vehicle_id.vehicleID+"</td><td>"+x[i].customer_id.name+"</td><td>" + x[i].customer_id.tpno+ "</td></tr>";
	           		 $("#tablex tbody").append(markup);
	            }
		    },
		    error:function(){
		        //alert("error");
		    }
	
		});
		
	
	}
</script>



</body>
</html>