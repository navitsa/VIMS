<link href="resources/css/custom.css" rel="stylesheet">
<ul
	class="navbar-nav sidebar sidebar-dark accordion  scrollable-menu"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	
			<!-- Nav Item - User Information -->
		 <li class="nav-item dropdown no-arrow "><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">  
				 <img class="img-profile rounded-circle"
				 
				 src="data:image/jpg;base64,<%=session.getAttribute("user")%>"
				 onerror="this.src='<c:url value='/resources/img/user-default.jpg'/>'"
				 />
				 <span
				class="mr-2 d-none d-lg-inline text-gray-600 small"> <%=session.getAttribute("username")%>
				
		</a> 
			 <div
				class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="editUserreg?userId=<%=session.getAttribute("userId")%>"> <i
					class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
				</a> 
<!-- 				<a class="dropdown-item" href="#"> <i -->
<!-- 					class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Settings -->
<!-- 				</a> -->
<!-- 				 <a class="dropdown-item" href="#"> <i -->
<!-- 					class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Activity -->
<!-- 					Log -->
<!-- 				</a> -->
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#" data-toggle="modal"
					data-target="#logoutModal"> <i
					class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
					Logout
				</a>
			</div> 
			</li>
	
	
	
	
	
<!-- 	<a href="#" class="sidebar-brand d-flex align-items-center justify-content-center"> -->
<!-- 		<div class="sidebar-brand-icon rotate-n-15"> -->
<!-- 			<i class="fas fa-laugh-wink"></i> -->
<!-- 		</div> -->

<!-- 		<div class="sidebar-brand-text mx-3"> -->
<%-- 			<%=session.getAttribute("userLevel")%><sup></sup> --%>
<!-- 		</div> -->
   		
<!-- 	</a> -->
<input type="text" id="userLevels" value='<%=session.getAttribute("userId")%>' hidden="true">
	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item">
<!-- 		 <a class="nav-link" href="homepage"> -->
<!-- 			<i class="fas fa-fw fa-tachometer-alt"></i> Home -->
<!-- 	</a> -->

	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading"></div>

	<!-- Vehicle Information Management -->
	<li class="nav-item"  hidden="true" id="MangeVehic">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseVehicle"
			aria-expanded="true" aria-controls="collapseVehicle">
			<i class="fas fa-fw fa-cog"></i> Vehicle Information
		</a>
		<div id="collapseVehicle" class="collapse" aria-labelledby="headingVehicle" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
				<a class="collapse-item fontst-sb-it" href="vehicleClasss" hidden="true" id="vehicleClasss">Vehicle Class</a> 
				<a class="collapse-item fontst-sb-it" href="vehicleMake"  hidden="true" id="vehicleMake">Vehicle Makes </a> 
				<a class="collapse-item fontst-sb-it" href="vehiclemodel1"  hidden="true" id="vehiclemodel1">Vehicle Models</a>
				<a class="collapse-item fontst-sb-it" href="document"  hidden="true" id="document">Add Document</a>
			</div>
		</div>
	</li>

	<!-- Testing Equipment Management -->
	<li class="nav-item"  hidden="true" id="TestEqum">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseEquipments" aria-expanded="true"
			aria-controls="collapseEquipments"> <i class="fas fa-fw fa-cog"></i> Testing Equipments
		</a>
		<div id="collapseEquipments" class="collapse" aria-labelledby="headingEquipments" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
				<a class="collapse-item fontst-sb-it" href="equipmenttype"  hidden="true" id="equipmenttype">Equipment Types</a> 
				<a class="collapse-item fontst-sb-it" href="equipmentmake"  hidden="true" id="equipmentmake">Equipment Makes</a> 
				<a class="collapse-item fontst-sb-it" href="equipmentmodel"  hidden="true" id="equipmentmodel">Equipment Models</a> 

			</div>
		</div>
	</li>




<!-- Test Configurations -->
	<li class="nav-item"  hidden="true" id="TestConfig">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseTestConfigurations" aria-expanded="true"
			aria-controls="collapseEquipments"> <i class="fas fa-fw fa-cog"></i> Test Configurations
		</a>
		<div id="collapseTestConfigurations" class="collapse" aria-labelledby="headingTestConfigurations" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
				<a class="collapse-item fontst-sb-it" href="testTYPE"  hidden="true" id="testTYPE">Test Types</a>
				<a class="collapse-item fontst-sb-it" href="testPoints" hidden="true" id="TestPoint">Test Points</a>
				<a class="collapse-item fontst-sb-it" href="#" hidden="true" id="TestPrameters">Test Parameters & Directions</a>
		
			</div>
		</div>
	</li>


<!-- Country Specific  -->
	<li class="nav-item"  hidden="true" id="CountrySp">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseCountrySpecific" aria-expanded="true"
			aria-controls="collapseEquipments"> <i class="fas fa-fw fa-cog"></i>Country Specific
		</a>
		<div id="collapseCountrySpecific" class="collapse" aria-labelledby="headingCountrySpecific" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
				<a class="collapse-item fontst-sb-it" href="countryMaster" hidden="true" id="countryMaster">Country specific settings</a>	
			</div>
		</div>
	</li>

	<!-- Corporate information -->
	<li class="nav-item" hidden="true" id="CorporateInfo">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseCorporateInfo"
			aria-expanded="true" aria-controls="collapseCorporateInfo"> 
			 <i class="fas fa-fw fa-cog"></i> Corporate information
		</a>
		
		<div id="collapseCorporateInfo" class="collapse" aria-labelledby="headingCorporateInfo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded" >
				
				<a class="collapse-item fontst-sb-it" href="businessPartner" hidden="true" id="businessPartner">Business partner</a>	
				<a class="collapse-item fontst-sb-it" href="#" hidden="true" id="CorporateCalendar">Partner Corporate Calendar</a>
				<a class="collapse-item fontst-sb-it" href="vehicleRegTypes" hidden="true" id="vehicleRegTypes">Lane Registration Types</a>
			</div>
		</div>
	</li>





<!-- Inspection Profile Mgmt -->
	<li class="nav-item"  hidden="true" id="InspectionProfileMgmt"><a class="nav-link collapsed fontst-sb" href="#"
		data-toggle="collapse" data-target="#collapseInspection"
		aria-expanded="true" aria-controls="collapseInspection"> <i
			class="fas fa-fw fa-cog"></i> Test Profiles
	</a>
		<div id="collapseInspection" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Create Test Profile</h6>
<!-- 				<a class="collapse-item fontst-sb-it" href="#"  hidden="true" id="testProfile">Test Profile</a>  -->
				<a class="collapse-item fontst-sb-it" href="testProfile" hidden="true" id="limitValues">Test Profile</a>

				<h6 class="collapse-header">Create VI Profile</h6>
				<a class="collapse-item fontst-sb-it" href="profileMaster"  hidden="true" id="profileMaster">VI Profile</a>
				<a class="collapse-item fontst-sb-it" href="ProfileStages"  hidden="true" id="ProfileStages">VI Stages</a> 
				<a class="collapse-item fontst-sb-it" href="stageitems"  hidden="true" id="stageitems">VI Stage Items</a> 
				<a class="collapse-item fontst-sb-it" href="ProfileItemsStatus"  hidden="true" id="ProfileItemsStatus">VI Item Status</a> 
				<a class="collapse-item fontst-sb-it" href="itemremarks" hidden="true" id="itemremarks">VI Status Remarks</a>
 				<h6 class="collapse-header"></h6>
				<a class="collapse-item fontst-sb-it" href="testCategory"  hidden="true" id="testCategory">Test Categories</a>
			</div>
		</div>
	</li>








	<!-- Center Organization -->
	<li class="nav-item"  hidden="true" id="TestCent">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapsecenter"
			aria-expanded="true" aria-controls="collapsecenter">
			<i class="fas fa-fw fa-cog"></i> Inspection Centers
		</a>
		<div id="collapsecenter" class="collapse" aria-labelledby="headingCenter" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
					<a class="collapse-item fontst-sb-it" href="centerType"  hidden="true" id="centerType">Centers Organization</a> 
					<a class="collapse-item fontst-sb-it" href="CMaster"  hidden="true" id="CMaster">Inspection Centers</a>
					<a class="collapse-item fontst-sb-it" href="equipmentmaster"  hidden="true" id="equipmentmaster">Equipment Allocation</a>
					<a class="collapse-item fontst-sb-it" href="equipmentreport"  hidden="true" id="equipmentreport">Equipments List</a>
					
				<h6 class="collapse-header"></h6>
				<a class="collapse-item fontst-sb-it" href="testLanes"  hidden="true" id="testLanes">Lane Types</a> 
				<a class="collapse-item fontst-sb-it" href="createNewTestLanes"  hidden="true" id="createNewTestLanes">Test Lanes Configuration</a>
				<!-- <a class="collapse-item fontst-sb-it" href="TestLaneDetails">Test Lane Details</a> -->
			</div>
		</div>
	</li>

<!-- Customer Relationship -->
	<li class="nav-item" id="CRM" hidden="true">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseCrm" 
			aria-expanded="true" aria-controls="collapseCrm"> 
			<i class="fas fa-fw fa-cog"></i> Customer Relationship
		</a>
		<div id="collapseCrm" class="collapse" aria-labelledby="headingCrm" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="newCustomer" hidden="true" id="newCustomer">Corporate Customers</a> 
			</div>
		</div>
	</li>


<!-- Vehicle Inspection -->
	<li class="nav-item"  hidden="true" id="VehicleInspection">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseVehicleInspection" aria-expanded="true" aria-controls="collapseVehicleInspection">
		<i class="fas fa-fw fa-cog"></i> Vehicle Inspection
		</a>
		<div id="collapseVehicleInspection" class="collapse" aria-labelledby="headingVehicleInspection" 
		data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="appointment" id="appointment">Make Appointment</a>
				<a class="collapse-item fontst-sb-it" href="vehicleInformation" hidden="true" id="vehicleInformation">Capture License Plate</a>
				<a class="collapse-item fontst-sb-it" href="vehicleMaster" hidden="true" id="vehicleMaster">Vehicle Master</a>
				<a class="collapse-item fontst-sb-it" href="checkDocument" hidden="true" id="checkDocument">Check Document</a>
				<a class="collapse-item fontst-sb-it" href="vehicleRegistration" hidden="true" id="vehicleRegistration">Vehicle Registration</a>
				
				<a class="collapse-item fontst-sb-it" href="visualChecklist"  hidden="true" id="visualChecklist">Perform Visual Inspection</a>
				<a class="collapse-item fontst-sb-it" href="getReport"  hidden="true" id="getReport">Issue VI Report</a>
				<a class="collapse-item fontst-sb-it" href="testValueFile" hidden="true" id="testValueFile">Issue Test Report</a>
				<a class="collapse-item fontst-sb-it" href="VehicleReportPreview" id="vehicalDetailRpt">Vehicle Lane Entry Status</a>
		
			</div>
		</div>
	</li>

<!-- Finance & Accounting -->
	<li class="nav-item" hidden="true" id="Finance">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseFinance" 
			aria-expanded="true" aria-controls="collapseFinance"> 
			<i class="fas fa-fw fa-cog"></i> Finance & Accounting
		</a>

		<div id="collapseFinance" class="collapse" aria-labelledby="headingFinance" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				  	<h6 class="collapse-header">General:</h6>
				<a class="collapse-item fontst-sb-it" href="taxConfiguration" hidden="true" id="taxConfiguration">Tax Settings</a>
					<h6 class="collapse-header">Accounts Receivables:</h6>
				
				<a class="collapse-item fontst-sb-it" href="vehicalRecCOPY" hidden="true" id="vehicalRecCOPY">Reprint Receipts</a>
				<a class="collapse-item fontst-sb-it" href="vehicalRecCancel" hidden="true" id="vehicalRecCancel">Receipt Cancel</a>
				<a class="collapse-item fontst-sb-it" href="vehicalInvCOPY"  id="vehicalInvCOPY">Reprint Credit Invoice</a>
				<a class="collapse-item fontst-sb-it" href="vehicalInvCancel" hidden="true" id="vehicalInvCancel">Invoice Cancel</a>
				<a class="collapse-item fontst-sb-it" href="revenueStatementPrivew" hidden="true" id="revenueStatementRpt">Revenue Statement</a>
				<a class="collapse-item fontst-sb-it" href="invoiceSummaryReport" hidden="true" id="invoiceSummaryReport">Invoice Summary Report</a>
				<a class="collapse-item fontst-sb-it" href="incomingPayment"  hidden="true" id="incomingPayment">Incoming Payment</a>				
				<a class="collapse-item fontst-sb-it" href="reprintIncomingReceipt" hidden="true" id="reprintIncomingReceipt">Reprint Incoming Receipt</a>	
				<a class="collapse-item fontst-sb-it" href="incomingReceiptSummary" hidden="true" id="incomingReceiptSummary">Incoming Receipt Summary</a>
				<a class="collapse-item fontst-sb-it" href="ageAnalysisReport" hidden="true"  id="ageAnalysisReport">Age Analysis Report</a>
					<h6 class="collapse-header">Accounts Payables:</h6>
				<a class="collapse-item fontst-sb-it" href="outgoingPayments"  hidden="true" id="outgoingPayments">Outgoing Payments</a>
				<a class="collapse-item fontst-sb-it" href="reprintOutgoingPayments" hidden="true"  id="reprintOutgoingPayments">Reprint Outgoing Payments</a>
				<a class="collapse-item fontst-sb-it" href="OutgoingPaymentsDetailsReport"  hidden="true" id="OutgoingPaymentsDetailsReport">Outgoing Payments Report</a>
				<a class="collapse-item fontst-sb-it" href="chequePrint"   id="chequePrint">Cheque Print</a>
			</div>
		</div>
	</li>

<!-- User Management -->
	<li class="nav-item"  hidden="true" id="UserManag">
		<a class="nav-link collapsed fontst-sb" href="#" data-toggle="collapse" data-target="#collapseUserManage" 
			aria-expanded="true" aria-controls="collapseUserManage">
			<i class="fas fa-fw fa-cog"></i> User Management
		</a>
		<div id="collapseUserManage" class="collapse" aria-labelledby="headingUserManage" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="userLevel" hidden="true" id="userLevel">User Categories</a> 
				<a class="collapse-item fontst-sb-it" href="register" hidden="true" id="register" >User Registration </a>
				<!--<a class="collapse-item fontst-sb-it" href="editUserreg"  hidden="true" id="editUserreg">Edit Users</a>-->
			</div>
		</div>
	</li>































	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>



 
  <script src="resources/vendor/jquery/jquery.min.js"></script> 



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
			            	if(data[i].roleassignPK.roleID.roleID!="000"){
			            document.getElementById(data[i].roleassignPK.roleID.desc.split("-")[0]).hidden = false;
			            document.getElementById(data[i].roleassignPK.roleID.desc.split("-")[1]).hidden = false;
			            	}
			            }

			        },
			        error:function(){
			            alert("User Not Assign");
			        }
			
			    });
        			
        			
<%-- 			   		var user = <%=session.getAttribute("userId")%>	 --%>
// 			   		$.ajax(
		   					
// 			   				{ 
// 			        type: 'GET',
// 			        url: "getSession",
// 			        data: {"usr" :user},
//                     success : function(result) {
                    	
                   
//                     }
			      
			
// 			    });  		
        			
        		}
        			
        			   		
        			}
        		
        );	
	  	


</script>

	    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	    
	    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>