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
							<h4 class="page-title">Vehicle Receipt</h4>
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
												<div class="form-group row">
									<div class="col-sm-3">
										<h6 class="m-0 font-weight-bold text-primary">Vehicle Receipt</h6>
										</div>
										<div class="col-sm-3">
											<input class="form-control fontst" type="date" name="recDate" value="${recDate}"
											readonly 
											id="recDate"
											/>
										</div>
										<div class="col-sm-3">

											<input class="form-control fontst" type="text" name="vecno"  value="${vecno}" readonly
											id="vecno"
											 />
											</div>
										<div class="col-sm-3">
	
											<input class="form-control fontst" type="text" name="reccno" value="${reccno}" readonly
											id="reccno"
											 />									
									</div>
							</div>
						
				
							
									<div class="form-group row">
								<div class="col-sm-7">
								
							
								
							
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:500px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
								<div class="col-sm-5">
									
								<c:if test="${pdftokValue != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdftokValue}"
										style="height:500px; width:100%">
										</embed>
										</c:if>
									
								
								</div>
								</div>
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

		

</body>
</html>