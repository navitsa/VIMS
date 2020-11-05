<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Online appointments</title>
<!-- head -->
<%@include file="../WEB-INF/jspf/head.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/font-awesome.min.css">

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
						<div class="col-xl-6 col-md-6 mb-4">
						
			              <div class="card shadow mt-4 border-left-primary">
			                <div class="card-body">
			                	<a href="getOnlineAppointments" class="btn btn-success">get online appointments</a>
			                </div>
			              </div>
			              
						</div>						
					</div>
					<!-- 1 row end -->

					
				</div>
				<!-- End of Page Content -->

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

	<!-- Logout Modal-->
	<%@include file="logoutModel.jsp"%>



	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"
		type="text/javascript"></script>
	<script
		src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"
		type="text/javascript"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/resources/vendor/jquery-easing/jquery.easing.min.js'/>"
		type="text/javascript"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/resources/js/sb-admin-2.min.js'/>"
		type="text/javascript"></script>

	<!-- Page level plugins -->

	<!-- Page level custom scripts -->



</body>
</html>