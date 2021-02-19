<div id="dbbakModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
        <h4 class="modal-title">System Backup</h4>
      </div>
      <div class="modal-body">
       
         <div class="col-sm-7 mb-1 mb-sm-3">
			<button type="button" class="btn btn-success" data-dismiss="modal" onclick="getDBBackup()">Backup</button>
	
			<button type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
		</div>
       
       
       
      </div>
      <div class="modal-footer">
																
      </div>
    </div>

  </div>
</div>

	<script>
		function getDBBackup(){
// 			Swal.fire ({
// 				   title: 'Wait ...',
// 				   onBeforeOpen: () => {
// 				     Swal.showLoading ()
// 				   }
// 				})
				
			$.ajax({
				type : 'GET',
				url : "startDbBackup",
				success : function(data) {
				
// 					Swal.close();
					if(data=="1"){

						
					    swal("Backup created successfully!", {
						      icon: "success",
						    });
					  
					
					}else if(data=="0"){
						swal({
							  //title: "Are you sure?",
							  text: "Could not create the backup",
							  icon: "warning",
							//  buttons: true,
							//  dangerMode: true,
							});
						
					}else{
						swal({
							  //title: "Are you sure?",
							  text: "Could not create the backup",
							  icon: "warning",
							//  buttons: true,
							//  dangerMode: true,
							});
					}
					
				},
				error : function() {
// 					Swal.close();
					swal({
						  //title: "Are you sure?",
						  text: "Could not create the backup",
						  icon: "warning",
						//  buttons: true,
						//  dangerMode: true,
						});
				}

			});
		}
	
	
	</script>











