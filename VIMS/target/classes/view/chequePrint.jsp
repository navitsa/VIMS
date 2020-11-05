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
				
									<div class="container-fluid">

<div class="row">				
	<div class="col-xl-3 col-lg-5" >			
					<!-- Card -->
			<form:form action="chequePreview"  method="POST">		
					<div class="card shadow mb-4" style="height:600px;">
						<div class="card border-left-primary shadow h-100 py-2" >
							<div class="card-header py-2">
								<h6 class="m-0 font-weight-bold text-primary">Cheque Print</h6>
							</div>
							<div class="card-body">
								

							<div class="form-group row">
										<div class="col-sm-12">
										<label class="l-fontst">Cheque Account No</label>
											<input class="form-control fontst" type="text" name="accno" 
											onchange=""
											id="recDate"
											/>	
										</div>
									
										
							</div>
							<div class="form-group row">
										<div class="col-sm-12">
										<label class="l-fontst">Due Date</label>
											<input class="form-control fontst" type="text" name="duedate" 
											onchange=""
											id="recDate"
											/>	
										</div>
									
										
							</div>
							<div class="form-group row">
										<div class="col-sm-12">
										<label class="l-fontst">Amount</label>
											<input class="form-control fontst" type="text" name="amount" 
											onchange=""
											id="recDate"
											/>	
										</div>
									
										
							</div>
							
<!-- 							<div class="form-group row"> -->
<!-- 										<div class="col-sm-12"> -->
<!-- 													<input type="checkbox" class="form-control custom-control-input fontst fontstc" id="withCheck" name="repStatu" value="INACTIVE" onclick="customerCredit()"> -->
<!-- 								    				<label class="custom-control-label l-fontst fontstc" for="withCheck">With Cancel</label> -->
<!-- 										</div> -->
									
										
<!-- 							</div> -->
								
							<br>	
							<hr>								
							<div class="form-group row">
								
									<div class="col-sm-12">
									<button type="submit" class="btn  btn-block btn-danger btn-rounded tabStyle" >Print Preview</button>
<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
									</div>		
							
								</div>
					

							</div>
							<!-- End of card body -->
						</div>
					</div>
		</form:form>
		</div>

		<div class="col-xl-9 col-lg-5">			
			<div class="col-sm-12">
					<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:600px; width:100%">
										</embed>
										</c:if>
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

	
</body>
</html>