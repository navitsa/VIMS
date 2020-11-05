<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Create New User</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>



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
					
						
						<div class="row" style="height: 472px">
							<div class="container">
							<h1 class="h3 mb-4 text-gray-800">View All Users</h1>
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<div class="col-xl-9 col-md-6mb-4 ">
										<div class="card border-left-warning shadow h-100 py-2">
											<div class="card-body">
												<div class="row no-gutters align-items-center">
													<div class="col mr-2">
												     <table class="table" style="height: 50px" >
    <thead>
      <tr style="background:  #eaecee ">
      <!--  <tr style="background:   #1b2631 ;color:  #ffffff ">-->
        <th>Employee ID</th>
        <th>Partner ID</th>
        <th>User Name</th>
        <th>Password</th>
        <th></th> 
      </tr>
      <c:forEach items="${userTable}" var="user">
      <tr>
        <td>${user.empId}</td>
        <td>${user.partnerId}</td>
        <td>${user.userName}</td>
        <td>${user.password}</td>
        <td><a href="editUser?id=${user.userId}"><button class="btn btn-info btn-rounded btn-sm my-0" style="width: 85px;">Edit</button></a></td> 
      </tr>
	</c:forEach>
    </thead>
  </table> 
    
												
													
													
																
														</div>
														
														</div>
														
														
														
														
														
														
													</div>

												</div>
											</div>
										</div>
									</div>

								</div>

							</div>



						</div>



												
				
				
		
				
					
		
	

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
	<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/resources/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/resources/js/sb-admin-2.min.js'/>"></script>

	<!-- Page level plugins -->
	<script src="<c:url value='/resources/vendor/chart.js/Chart.min.js'/>"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value='/resources/js/demo/chart-area-demo.js'/>"></script>
	<script src="<c:url value='/resources/js/demo/chart-pie-demo.js'/>"></script>
</body>
</html>