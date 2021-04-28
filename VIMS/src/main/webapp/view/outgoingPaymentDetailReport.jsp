<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<h4 class="page-title">Outgoing Payment Report</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>
							<li class="nav-item"><a href="#">Finance & Accounting</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>
							<li class="nav-item"><a href="#">Outgoing Payment Report</a>
							</li>
						</ul>
					</div>


					<div class="row">
						<div class="col-xl-4 col-md-6 mb-4">
							<div class="card shadow mb-4 border-left-primary">
								<div class="card-body">

									<form:form action="previewIOutgoingPaymentsDetailsReport"
										method="POST">

										<div class="form-group row">
											<div class="col-lg">
												<label class="l-fontst">From Date</label> <input
													class="form-control fontst" type="date" name="fromdate"
													onchange="" id="recDate" />
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg">
												<label class="l-fontst">To Date</label> <input
													class="form-control fontst" type="date" name="todate"
													onchange="" id="recDate" />
											</div>
										</div>

										<hr>
										<div class="form-group row">
											<div class="col-lg">
												<button type="submit"
													class="btn  btn-block btn-danger btn-rounded tabStyle">Print
													Preview</button>
											</div>
										</div>

									</form:form>
								</div>
							</div>
						</div>

						<div class="col-xl-8 col-md-6 mb-4">
							<c:if test="${pdfViewEq != null }">
								<embed type="application/pdf"
									src="data:application/pdf;base64,${pdfViewEq}"
									style="height: 600px; width: 100%">
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