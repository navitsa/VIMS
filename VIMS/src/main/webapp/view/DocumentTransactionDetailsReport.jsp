<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.vidSty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
	color: #02d41b;
}

.textred {
	font-family: Arial, Helvetica, sans-serif;
	border: 0px solid #b30000;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #2c03fc;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 30px;
}

.l-fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 5px;
	margin-top: 0px;
}

.iconali {
	position: absolute;
	top: 6px;
	right: -7px;
}

.capCam {
	height: 100px;
	width: 210px;
}

.cursiz {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 48px;
	color: #ff8000;
}

.amt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 60px;
	color: blue;
	text-align: right;
}

.iconstyle {
	width: 7%;
	color: blue';
}

.icon-pre-ve {
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
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">Document Transaction
									Details Report</h2>
							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4"></div>

							<div class="ml-md-auto py-2 py-md-4"></div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">

						<div class="row">
							<div class="col-xl-4 col-lg-5">
								<!-- Card -->

								<form:form action="PreviewDocumentTransactionDetailsReport"
									method="POST" onsubmit="return validateForm()">

									<div class="card shadow mb-4" style="height: 70vh;">
										<div class="card-body">

											<div class="form-group row">
												<div class="col-sm-8">
													<label class="l-fontst">Document Type</label> <select
														id="selectDocumentType" name="documentType"
														class="form-control"
														onchange="getGLPostingHeadsByDocId();" required="true"><option
															value="">--SELECT--</option>
														<c:forEach items="${documentList}" var="dl">
															<option value="${dl.docid}">${dl.document}</option>
														</c:forEach></select>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-8">
													<label class="l-fontst">Document ID</label> <select
														id="selectDocumentId" name="documentId"
														class="form-control text-capitalize" required="true">
														<option value="" selected>--SELECT--</option>
													</select>
												</div>
											</div>

											<div class="form-group row">

												<div class="col-sm-8">
													<button type="submit"
														class="btn  btn-block btn-danger btn-rounded tabStyle">Generate
														Report</button>

												</div>

											</div>

										</div>
									</div>

								</form:form>


							</div>

							<div class="col-xl-8 col-lg-5">
								<div class="col-sm-12">

									<c:if test="${pdfViewEq != null }">
										<embed type="application/pdf"
											src="data:application/pdf;base64,${pdfViewEq}"
											style="height: 70vh; width: 100%">
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


	<script>
		function getGLPostingHeadsByDocId() {
			console.log("Start");
			var selectDocumentType = document
					.getElementById("selectDocumentType").value;
			if (selectDocumentType == "") {
				var selectDocumentId = $("#selectDocumentId"), option = "";
				selectDocumentId.empty();
				return;
			} else {
				$
						.ajax({
							type : 'GET',
							url : "getGLPostingHeadsByDocId",
							data : {
								"docId" : selectDocumentType
							},
							success : function(data) {
								console.log("Success");
								var selectDocumentId = $("#selectDocumentId"), option = "";
								selectDocumentId.empty();
								selected_option = "<option value='' selected>--SELECT--</option>";
								selectDocumentId.append(selected_option);
								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].docNo + "'>"
											+ data[i].docNo + "</option>";
								}
								selectDocumentId.append(option);
							},
							error : function() {
								alert("No return data");
							}
						});
			}
		}

		function validateForm() {
			var documentType = document.getElementById('selectDocumentType').value;
			var documentId = document.getElementById('selectDocumentId').value;
			if (documentType == "") {
				swal("Document Type is  empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (documentId == "") {
				swal("Document ID is empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else {
				return true;
			}
		}
	</script>

</body>
</html>