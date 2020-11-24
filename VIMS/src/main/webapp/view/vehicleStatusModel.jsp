<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="vehicleStatusModel" class="modal fade bd-example-modal-xl"  role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
        <h4 class="modal-title">Vehicle Inspection Status</h4>
        								<div class="border border-success text-center" style="width:110px; height:100px;">

											<div class="rounded-circle circles-text" id="totgate" style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">Total Gate Entry</h6>
										</div>
        	
									
										<div class="px-2 pb-5 pb-md-0 text-center">
											<div id="circles-1">0</div>
											<h6 class="fw-bold mt-3 mb-0">Check Document</h6>
										</div>
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="circles-2"></div>
											<h6 class="fw-bold mt-3 mb-0">Vehicle Registration</h6>
										</div>
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="circles-3"></div>
											<h6 class="fw-bold mt-3 mb-0">Lane Entry</h6>
										</div>
									
								
        
        
      </div>
      <div class="modal-body">

 													<table id="nf" class=" table-bordered table-wrapper-scroll-y my-custom-scrollbar" style="height: 500px;">
	
														<thead >
															<tr  bgcolor="#C0C0C0" style="height: 80px;">
																<th class="col-sm-3"></th>
																<th class="col-sm-1">Appointment</th>
																<th class="col-sm-2">License Plate</th>
																<th class="col-sm-2">Check Document</th>
																<th class="col-sm-2">Vehicle Registration</th>
																<th class="col-sm-2">Lane Entry</th>
															</tr>
														</thead>
														<tbody id="vehicleSta" >
														 
														
														</tbody>
													</table>

										
														
       
       
       
      </div>
      <div class="modal-footer">
            <div class="col-sm-10 mb-10 mb-sm-10">
	
		</div>
      <div class="col-sm-2 mb-2 mb-sm-2">
	
			<button type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
		</div>																
      </div>
    </div>

  </div>
</div>


	 












