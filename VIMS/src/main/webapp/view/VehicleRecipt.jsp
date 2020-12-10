<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	<style type="text/css">
	
			.vidSty{
			font-family: Arial, Helvetica, sans-serif;	
			font-size:30px;
			font-weight: bold;
			color: #02d41b;	
			}
	
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
			
							<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-4">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">Vehicle Receipt</h2>
								<h5 class="text-white op-7 mb-2"></h5>
							</div>
							<div class="ml-md-auto  col-md-2">
							<p class="vidSty" >${vecno}</p>	
							</div>
							<div class="col-md-2">
							<p class="vidSty" >${reccno}</p>	
							</div>
							<div class="ml-md-auto py-2 py-md-4">
								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Gate Entry</a>
								<a href="laneEntryView" class="btn btn-white btn-border btn-round mr-2">Lane Entry</a>
<!-- 								<a href="#" class="btn btn-white btn-border btn-round mr-2" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
<!-- <a  class="btn btn-secondary btn-round" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
							</div>
						</div>
					</div>
				</div>
						
			
			
			
			
				<div class="page-inner mt--5">	
			
<!-- 												<div class="form-group row"> -->
								
<!-- 										<div class="col-sm-3"> -->
<%-- 											<input class="form-control fontst" type="date" name="recDate" value="${recDate}" --%>
<!-- 											readonly  -->
<!-- 											id="recDate" -->
<!-- 											/> -->
<!-- 										</div> -->
<!-- 										<div class="col-sm-3"> -->

<%-- 											<input class="form-control fontst" type="text" name="vecno"  value="${vecno}" readonly --%>
<!-- 											id="vecno" -->
<!-- 											 /> -->
<!-- 											</div> -->
<!-- 										<div class="col-sm-3"> -->
	
<%-- 											<input class="form-control fontst" type="text" name="reccno" value="${reccno}" readonly --%>
<!-- 											id="reccno" -->
<!-- 											 />									 -->
<!-- 									</div> -->
<!-- 							</div> -->
						
				
							
									<div class="form-group row">
								<div class="col-sm-7">
								
							
								
							
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:700px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
								<div class="col-sm-5">
									
								<c:if test="${pdftokValue != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdftokValue}"
										style="height:700px; width:100%">
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