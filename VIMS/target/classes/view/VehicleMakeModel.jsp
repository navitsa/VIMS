<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
        <h4 class="modal-title">Vehicle Make</h4>
      </div>
      <div class="modal-body">
       
     <form  method="post"  enctype="multipart/form-data" id="formMake" >
       
      
       			<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="vm">Vehicle Make</label>
																	<input class="form-control" name="vehicleMake"id="vm" />
																	
																</div>
															</div>
															<div class="col-sm-2"></div>
														

														</div>
														
														
												<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Make Logo</label> <input type="file"
																		class="file" accept="image/*" name="makeLogo"/>
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="Choose Logo..." id="file" disabled>
																		<div class="input-group-append">
																			
																			
																			<button type="button" class="browse btn btn-primary" >Browse</button>
																		</div>
																	</div>

																</div>
															</div>




															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remark">Remarks</label>
																	<input type="text" name="remark" class="form-control" />
																	
																</div>
															</div>
														</div>

								<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																	
																			
																			
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																	
																	</div>

																</td>

			<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
<!-- 																		<button type="button" class="btn btn-info" data-dismiss="modal" onclick="getMakeV()">Close</button> -->
																	</div>

																</td>




															</tr>
														</table>
					
														
       </form>
       
       
       
      </div>
      <div class="modal-footer">
      <div class="col-sm-7 mb-1 mb-sm-3">
	<button type="button" class="btn btn-success" data-dismiss="modal" onclick="saveMakeV()">Add Vehicle Make</button>
	
			<button type="button" class="btn btn-info" data-dismiss="modal" onclick="getMakeV()">Close</button>
		</div>																
      </div>
    </div>

  </div>
</div>


















