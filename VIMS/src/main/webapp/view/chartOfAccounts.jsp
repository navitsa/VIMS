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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-4 col-lg-4">
								 <h2 class="text-white pb-2 fw-bold">Chart Of Account</h2>
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
<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
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
													<form:form action="saveGlaccount" method="post"
														modelAttribute="glaccount">

<div class="form-group row">
									<div class="col-sm-10">
										<label >Primary Account</label>
												<div class="col-sm-2"></div>			
											
												<div class="btn-group btn-group-toggle" data-toggle="buttons">
												  <label class="btn btn-outline-success btn-sm">
												    <form:radiobutton path="primaryAccount" value="Assets" onfocus="geGlaccountByPrimaryAccount(this.value);"/>Assets
												  </label>
												  <label class="btn btn-outline-primary btn-sm">
												    <form:radiobutton path="primaryAccount"  value="Liability" onfocus="geGlaccountByPrimaryAccount(this.value);" />Liability
												  </label>
												  <label class="btn btn-outline-info btn-sm">
												    <form:radiobutton path="primaryAccount" value="Expenses" onfocus="geGlaccountByPrimaryAccount(this.value);" /> Expenses
												  </label>
												  <label class="btn btn-outline-warning btn-sm">
												    <form:radiobutton path="primaryAccount"  value="Income" onfocus="geGlaccountByPrimaryAccount(this.value);" />Income
												  </label>
												  <label class="btn btn-outline-danger btn-sm">
												    <form:radiobutton path="primaryAccount"  value="Equity" onfocus="geGlaccountByPrimaryAccount(this.value);" />Equity
												  </label>
												</div>
												
										</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-3"></div>

									</div>
														<div class="form-group row">

															
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="eqTypeID">GL Account No</label>
																	<form:input class="form-control form-control-sm"
																		path="glAccNo" />

																</div>
															</div>
															
																														<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label >GL Account Name</label>
																	
																	
																	<form:input class="form-control form-control-sm"
																		path="glAccountName"  />
																</div>
															</div>
															
														</div>
														
														
														<div class="form-group row">
															<div class="col-sm-3">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label >Parent Account</label>
																	<form:select class="custom-select custom-select-mb"
																		id="parentsAccount" path="parentsAccount"
																		>
																		<form:option value=""> --SELECT--</form:option>
<%-- 																		<c:forEach items="${types}" var="t"> --%>
<%-- 																			<form:option value="${t.eqTypeID}">${t.eqType}</form:option> --%>
<%-- 																		</c:forEach> --%>
																	</form:select>
																</div>
															</div>
														</div>
														
														
														
								

								

			
														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-success"
																			value="Create Gate">
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
															<th>Primary Account</th>
															<th>Parent Account</th>
																<th>GL Account No</th>
																<th>GL Account Name</th>
																
																
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allglaccount}"
																var="glaccount">
																<tr>
																<td><div>${glaccount.primaryAccount}</div></td>
																<td><div>${glaccount.parentsAccount}</div></td>
																
																	<td><div>${glaccount.glAccNo}</div></td>
																	<td><div>${glaccount.glAccountName}</div></td>
																	
																	
																	<td><a
																		href="editGlaccount?id=${glaccount.glAccNo}"><i
																			class="material-icons">&#xE254;</i></a></td>
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
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
		<script type="text/javascript">
		
		function geGlaccountByPrimaryAccount(str)
		{   
			//alert(str);
					
				$.ajax({
		        type: 'POST',
		        url: "getglaccountByPrimary",
		        data : {"priAccount" : str},
		        success: function(data){
		        
		            var slctSubcat=$('#parentsAccount'), option="";
		            slctSubcat.empty();
		            option =  "<option value=''>Parents Account</option>";
		            for(var i=0; i<data.length; i++){
		                option = option + "<option value='"+data[i].glAccNo + "'>"+data[i].glAccountName + "</option>";
		               
		            }
		            slctSubcat.append(option);
		           
		        },
		        error:function(){
		           alert("No return vMake data");
		        }

		    });
				
			
		}
		
		
		
		</script>
	
		
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

</body>
</html>