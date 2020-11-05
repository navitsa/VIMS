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
							<h4 class="page-title">Credit Invoice</h4>
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

					<!-- Card -->
					<div class="card shadow mb-4">
						<div class="card border-left-primary shadow h-100 py-2">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Credit Invoice</h6>
							</div>
							<div class="card-body">
								<form:form action="vehiclInvoicePrint"  method="POST">

									<div class="form-group row">
										<div class="col-sm-3">
											<label  class="l-fontst">Invoice Date</label>
											<input class="form-control fontst" type="date" name="invDate" 
											onchange="getVechicalNo(this.value);"
											id="recDate"
											/>
										</div>
										<div class="col-sm-3">
											<label  class="l-fontst">Vehicle No</label>
											<select class="form-control form-control-user fontst"
												id="vehiNo" name="vecno"  required onchange="getInvoiceDetail(this.value);">
												<option value=""> --SELECT--</option>
														
											</select>
											</div>
										<div class="col-sm-3">
											<label  class="l-fontst">Invoice No</label>
											<select class="form-control form-control-user fontst"
												id="recno"   name="invNo" required>
												<option value=""> --SELECT--</option>
														
											</select>
											
											
											
<%-- 											<input class="form-control" type="text" name="reccno" value="${reccno}"/>									 --%>
									</div>
							</div>									
										<div class="col-sm-0">
											<label> </label>
											<button type="submit" class="btn btn-primary tabStyle">
											<i class="fas fa-download fa-sm text-white-50"></i> Print Receipt</button>																
									</div>
								</form:form>
								
								<div class="form-group row">
								<div class="col-sm-7">
								
							
								
								<br>
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:650px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
								<div class="col-sm-5">
									
								<br>
								<c:if test="${pdftokValue != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdftokValue}"
										style="height:650px; width:100%">
										</embed>
										</c:if>
									
								
								</div>
								</div>
								

					
	
								<hr>
								
				
								
								

							</div>
							<!-- End of card body -->
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

	function getVechicalNo(str) {
			if (str == "") {

				var slctSubcat = $('#vehiNo'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getVehicalDetailsByDate",
							data : {"vRdate" : str,"payTyp" : "Credit"},
							success : function(data) {
							if(data!=""){
								var slctSubcat = $('#vehiNo'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);

								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].vid.vehicleID + "'>"
											+ data[i].vid.vehicleID + "</option>";
								}
								slctSubcat.append(option);
							}else{
								alert("No Vehicle Selected Date");		
							}
							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}
	
	//get Model related make and class
	function getInvoiceDetail(vecid) {
	
		var vRdate = document.getElementById("recDate").value;

			if (vecid == "") {
				
				//document.getElementById("txtHint").innerHTML="";
				var slctSubcat = $('#recno'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getInvoiceHeadByVehicalRegID",
							data : {"vRdate" : vRdate, "vecid" : vecid,"payTyp" : "Credit"},
							success : function(data) {

								var slctSubcat = $('#recno'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);
								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].invoiceNo + "'>"
											+ data[i].invoiceNo + "</option>";
								}
								slctSubcat.append(option);

							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}
	

	
	</script>
</body>
</html>