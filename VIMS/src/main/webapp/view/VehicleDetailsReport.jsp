<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
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
					<div class="page-header">
							<h4 class="page-title">Vehicle Lane Entry Status</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								
								
							</ul>
						</div>
				
						
					<div class="card-body">
								<form:form action="VehicleDetailsReport"  method="POST">

									<div class="form-group row">
										<div class="col-sm-3">
											
											<input class="form-control" type="date" name="recDate" value="${recDate}"
											onchange=""
											id="recDate"
											/>
										</div>
										<div class="col-sm-5">
											<label> .</label>
											<button type="submit" class="btn btn-primary">
											<i class="fas fa-download fa-sm text-white-50"></i> Print Preview</button>																
									</div>
									
							</div>									
										
								</form:form>
								
								<div class="form-group row">
								<div class="col-sm-12">
								
							
								
								<br>
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:800px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
							
								</div>
								

					
	
								<hr>
								
				
								
								

							</div>
							
	
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>


</body>
</html>