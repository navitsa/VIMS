
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="VecModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
				<h4 class="modal-title">Vehicle Model</h4>
			</div>
			<div class="modal-body">
				<form method="post" id="modelForm2" onsubmit="getModelV()"
					enctype="multipart/form-data">

					<div class="form-group row">
						<div class="col-lg-6">
							<label>Vehicle Make</label> <select class="custom-select"
								id="mvehicleMakeID" name="vehicleMakeID"
								onchange="checkModel();" required="true">
								<option value="">Select Vehicle Make</option>
								<c:forEach items="${veMake}" var="partner">
									<option value="${partner.vehicleMakeID}">${partner.vehicleMake}</option>
								</c:forEach>
							</select>
						</div>


					</div>
					<div class="form-group row">
						<div class="col-lg-6">

							<label>Vehicle Class</label> <select class="custom-select"
								id="vehicleClassID" name="vehicleClassID"
								onchange="checkModel();" required>
								<option value="">Select Vehicle Class</option>
								<c:forEach items="${vclass}" var="cl">
									<option value="${cl.vehicleClassID}">${cl.vehicleClass}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<div class="col-lg-6">
							<label>Vehicle Model </label> <input
								class="form-control form-control-user" id="vehicleModel"
								name="vehicleModel" onkeyup="checkModel();" />
						</div>
					</div>

					<div class="row">

						<div class="col-sm-5">
							<div class="col-sm-60 mb-1 mb-sm-3">
								<label>Model Image</label> <input type="file" class="file"
									accept="image/*" id="modelLogo" name="modelLogo" />
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="choose image..." id="file" disabled>
									<div class="input-group-append">
										<button type="button" class="browse btn btn-primary">Browse</button>
									</div>
								</div>

							</div>
						</div>

						<div class="col-sm-5"></div>

					</div>



					<br>
					<!-- 													<input type="submit" class="btn btn-success" value="Add Model" onclick="getModelV();" /> -->
					<!-- 													<input type="reset" class="btn btn-warning" value=" Clear "> -->
					<!-- 													<button type="button" class="btn btn-info" data-dismiss="modal"  onclick="getModelV();">Close</button> -->
					<br>
					<br>

				</form>
				<div class="row">

					<div class="col-sm-3">

						<button type="button" class="btn btn-success" data-dismiss="modal"
							id="sub" onclick="saveModelV();">Add Model</button>
					</div>
					<div class="col-sm-5">

						<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
					</div>
				</div>







			</div>
			<div class="modal-footer">
				<!--         <button type="button" class="btn btn-default" data-dismiss="modal" onclick="getModel()">Close</button> -->
			</div>
		</div>

	</div>
</div>



<script type="text/javascript">
	document.getElementById("sub").style.display = "none";
	function checkModel() {

		document.getElementById("sub").style.display = "none";
		var sta = document.getElementById("vehicleModel").value;
		var mak = document.getElementById("mvehicleMakeID").value;
		var cls = document.getElementById("vehicleClassID").value;

		if (sta != "") {
			$.ajax({
				type : 'GET',
				url : "getCheckModelValue",
				data : {
					"make" : mak,
					"clas" : cls,
					"modelname" : sta
				},
				success : function(model) {

					if (model == "0") {

						document.getElementById("vehicleModel").value = "";
						document.getElementById("sub").style.display = "none";
						//alert("Model is found");	

						Swal.fire({
							icon : 'error',
							title : 'Oops...',
							text : 'Model is already found'
						//,footer: '<a href>Why do I have this issue?</a>'
						});

					} else {
						document.getElementById("sub").style.display = "block";
					}

				}

			});
		} else {
			//document.getElementById("sub").style.display = "none";
		}
	}
</script>














