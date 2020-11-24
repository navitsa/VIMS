<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="vehicleStatusModel" class="modal fade bd-example-modal-xl"  role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
        <h4 class="modal-title">Vehicle Inspection Status</h4>
      </div>
      <div class="modal-body">

 													<table id="nf" class="table table-bordered table-wrapper-scroll-y my-custom-scrollbar" style="height: 500px">
	
														<thead >
															<tr bgcolor="#C0C0C0">
																<th></th>
																<th >Appointment</th>
																<th>License Plate</th>
																<th>Check Document</th>
																<th>Vehicle Registration</th>
																<th>Lane Entry</th>
															</tr>
														</thead>
														<tbody id="vehicleSta" >
														 
														
														</tbody>
													</table>

										
														
       
       
       
      </div>
      <div class="modal-footer">
      <div class="col-sm-7 mb-1 mb-sm-3">
	
			<button type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
		</div>																
      </div>
    </div>

  </div>
</div>


	 












