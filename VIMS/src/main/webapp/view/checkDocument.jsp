<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="checkDocumentModal" class="modal fade bd-example-modal-xl"  role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
        <h4 class="modal-title">Document Verification</h4>
      </div>
      <div class="modal-body">
       
   										<form  id="savaCheckdocid"  method="post" enctype="multipart/form-data"
														>


														<div class="form-group row">
			
															<div class="col-sm-12">
															<div class="row">

																	<div class="col-sm-5">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<input class="form-control textred"
																					name="vehNO" value="${vvid}" id="vehNO"
																					placeholder="Licence Plate NO..."
																					
																					readonly="true" />
																					<input class="form-control form-control-sm"
																			name="mocrid" id="mocrid" value="${ocid}"  type="hidden"/>
																			</div>
																		</div>
																	
																		<div class="row">
																			<div class="col-sm-6">
																				
																			</div>
																			<div class="col-sm-5">
																		
																	
																			</div>


																	
																		</div>
																	</div>
																	<div class="col-sm-3">
														

																	</div>																	
																</div>







															</div>
														</div>
										
													

													<table id="checkDocTable" 
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0" style="height: 200px;">
	
														<thead>
															<tr>
																<th>Document ID</th>
																<th>Description</th>
																<th>Remarks</th>
																<th>Status</th>
																
															</tr>
														</thead>
														<tbody id="myTable">
														 
															<c:forEach items="${documentlist}"
																var="doc" varStatus="i"> <%--Loop Status --%>
																<tr>
																	<td><div>
																	<input class="form-control form-control-sm" 	name="doc" id="doc" value="${doc.documentid}"  />
																	</div></td>
																	<td><div>${doc.description}</div></td>
																	<td><div>${doc.remarks}</div></td>
																	<td><div>
<!-- 																<select class="custom-select"name="docStatus"  > -->
<!-- 																		<option value="N/A">N/A</option> -->
<!-- 																		<option value="OK">OK</option> -->
<!-- 																		<option value="Not OK">Not OK</option> -->
<!-- 																	</select>		 -->
																
																	
												<div class="btn-group btn-group-toggle" data-toggle="buttons">
									  <label class="btn btn-outline-success btn-sm">
							    <input type="radio" name="docStatus" id="option1" value="OK" > OK
									  </label>
									  <label class="btn btn-outline-primary btn-sm">
									    <input type="radio" name="docStatus" id="option2" value="Not OK" > Not OK
									  </label>
									  <label class="btn btn-outline-info btn-sm">
									    <input type="radio" name="docStatus" id="option3" value="N/A" > N/A
									  </label>
									</div>
												
																	
																	</div></td>
																	
																</tr>
															</c:forEach>
														</tbody>
													</table>

 

														<table>
															<tr>
															
															
																<td>
<!-- 																	<div class="col-sm-7 mb-1 mb-sm-3 justify-content-end"> -->
<!-- 																		<input type="submit" class="btn btn-success" -->
<!-- 																			value="Continue"> -->
<!-- 																	</div> -->
																</td>
															</tr>
														</table>
														</form>
       
       
       
      </div>
      <div class="modal-footer">
      <div class="col-sm-7 mb-1 mb-sm-3">
	<button type="button" class="btn btn-success" data-dismiss="modal" onclick="saveCheckDocment()">Save</button>
	
			<button type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
		</div>																
      </div>
    </div>

  </div>
</div>


	 












