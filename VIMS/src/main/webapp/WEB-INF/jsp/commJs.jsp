	<!--   Core JS Files   -->
	
	

	
	<script src="resources/assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="resources/assets/js/core/popper.min.js"></script>
	<script src="resources/assets/js/core/bootstrap.min.js"></script>

	<!-- jQuery UI -->
	<script src="resources/assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="resources/assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

	<!-- jQuery Scrollbar -->
	<script src="resources/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>


	<!-- Chart JS -->
	<script src="resources/assets/js/plugin/chart.js/chart.min.js"></script>

	<!-- jQuery Sparkline -->
	<script src="resources/assets/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

	<!-- Chart Circle -->
	<script src="resources/assets/js/plugin/chart-circle/circles.min.js"></script>

	<!-- Datatables -->
	<script src="resources/assets/js/plugin/datatables/datatables.min.js"></script>

	<!-- Bootstrap Notify -->
<!-- 	<script src="resources/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script> -->

	<!-- jQuery Vector Maps -->
	<script src="resources/assets/js/plugin/jqvmap/jquery.vmap.min.js"></script>
	<script src="resources/assets/js/plugin/jqvmap/maps/jquery.vmap.world.js"></script>

	<!-- Sweet Alert -->
	<script src="resources/assets/js/plugin/sweetalert/sweetalert.min.js"></script>

	<!-- Atlantis JS -->
	<script src="resources/assets/js/atlantis.min.js"></script>

	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="resources/assets/js/setting-demo.js"></script>
	<script src="resources/assets/js/demo.js"></script>
	
	
	<script src="resources/assets/js/file-input.js"></script>
	<!--  <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script> -->
<!-- 		<script
		src="https://cdn.datatables.net/rowgroup/1.1.1/js/dataTables.rowGroup.min.js"></script>  -->
	 
	   
	  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
	  
<!-- 	  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script> -->
	  
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
	   
	  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	  
	  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	 
	<script type="text/javascript">

	
        $(document).ready(  
        		function() { 
        			
        			var str='<%=session.getAttribute("userId")%>';
        			if(<%=session.getAttribute("userId")%>==null){
		        		Swal.fire({
		        			  icon: 'error',
		        			  title: 'Oops...',
		        			  text: 'Session Expired'
		        			  //,footer: '<a href>Why do I have this issue?</a>'
		        			});
        			window.location.href = "logout";
        			}else{
        				
					$.ajax({
			        type: 'GET',
			        url: "getUserIdRoles",
			        data: {"userid" : str},
			        success: function(data){
			        
						
			            for(var i=0; i<data.length+1; i++){
			            	if(data[i].levelManagePK.roleID.roleID!="000"){
			            document.getElementById(data[i].levelManagePK.roleID.desc.split("-")[0]).hidden = false;
			            document.getElementById(data[i].levelManagePK.roleID.desc.split("-")[1]).hidden = false;
			            	}
			            }

			        },
			        error:function(){
			            alert("User Not Assign");
			        }
			
			    });
        			 			
        		}
        			
        	}
        		
        );	
	  	


</script>
	
	
	
	
	
	
	