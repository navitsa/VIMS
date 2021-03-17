<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
	.vidSty{
	font-family: Arial, Helvetica, sans-serif;	
	font-size:30px;
	font-weight: bold;
	color: #02d41b;	
	}
	
	
	    .textred{
       font-family: Arial, Helvetica, sans-serif;
        border: 0px solid #b30000;
		font-size:14px;
		font-weight:bold;
       	text-align:center;
       	color: #2c03fc;	
     
       }  
	      .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
           height: 30px;
         }
         .l-fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 5px;
          margin-top: 0px;
         }
        .iconali{
        	position: absolute; 
  			top: 6px;
			right:-7px;
        
        }
        .capCam{

  			height: 100px;
  			width: 210px;	
		}
		.cursiz{
		font-family: Arial, Helvetica, sans-serif;
        font-size: 12px;
		width: 48px;	
		color: #ff8000;
		
		}
		.amt{
		font-family: Arial, Helvetica, sans-serif;
       font-size: 12px;
       width:60px;
		color: blue;
		text-align: right;
		}

	   .iconstyle{		
  			width: 7%;
  			color:blue';
       }
       .icon-pre-ve{
        width: 150%;
  		
       
       }	
</style>
	
</head>
<body onload="checkStatusofDropdowns();">
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
					<div class="page-inner py-3">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								 <h2 class="text-white pb-2 fw-bold">Bank Branch</h2>
							</div>
							<div class="col-xl-2 col-lg-2">
								
							</div>
							<div class="ml-md-auto py-2 py-md-4">
							  
							
							</div>
						
							<div class="ml-md-auto py-2 py-md-4">
							</div>
						</div>
					</div>
				</div>
				
				<div class="page-inner mt--5">	
					<div class="container-fluid">

		
		
		<div class="col-xl-9 col-md-6mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<c:if test="${success ==1}">
														<div class="alert alert-success alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Success!</strong> Data Successfully Saved.
														</div>
													</c:if>
													<c:if test="${success ==0}">
														<div class="alert alert-danger alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>
													<form:form action="saveBranch" method="post"
														modelAttribute="branch">


															<div class="form-group row">
													
															<div class="col-sm-7">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Bank Name</label>
																	
																		<form:select class="custom-select custom-select-mb"
												id="bankid" path="bankid.bankid"
												>
												<option value=""> --SELECT--</option>
													<c:forEach items="${bankNameList}" var="t">
														<form:option value="${t.bankid}">${t.bankName}</form:option>
													</c:forEach>
											</form:select>
																	
																	
																

																</div>
															</div>
														</div>		
													<div class="form-group row">
													
															<div class="col-sm-7">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Branch Code</label>
																	<form:input class="form-control form-control-sm"
																		path="branchID" />

																</div>
															</div>
														</div>		
											<div class="form-group row">
													
															<div class="col-sm-7">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Branch Name</label>
																	<form:input class="form-control form-control-sm"
																		path="branch" />

																</div>
															</div>
														</div>	
														
													<div class="form-group row">
													
															<div class="col-sm-7">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Branch Address</label>
																	<form:input class="form-control form-control-sm"
																		path="address" />

																</div>
															</div>
														</div>				
														<div class="form-group row">
													
															<div class="col-sm-7">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>contact No</label>
																	<form:input class="form-control form-control-sm"
																		path="contactNo" />

																</div>
															</div>
														</div>	
													



														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-success"
																			value="Create New Branch">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="reset" class="btn btn-warning"
																			value=" Clear ">
																	</div>

																</td>


															</tr>
														</table>

													</form:form>

													<table id="eqTypeTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																
																<th>Bank Name</th>
																<th>Bank Code</th>
																	<th>Branch Name</th>
																		<th>Address</th>
																			<th>Contact No</th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allBankDetails}"
																var="allBankDetails">
																<tr>
																	
																<td><div>${allBankDetails.bankid.bankName}</div></td>
																<td><div>${allBankDetails.branchID}</div></td>	
																<td><div>${allBankDetails.branch}</div></td>
																<td><div>${allBankDetails.address}</div></td>
																<td><div>${allBankDetails.contactNo}</div></td>


																</tr>
															</c:forEach>
														</tbody>
													</table>

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



</body>
</html>