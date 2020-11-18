
		<div class="sidebar sidebar-style-2">			
			<div class="sidebar-wrapper scrollbar scrollbar-inner">
				<div class="sidebar-content">
					<div class="user">
						<div class="avatar-sm float-left mr-2">
					
					 <img class="avatar-img rounded-circle"
				 
				 src="data:image/jpg;base64,<%=session.getAttribute("user")%>"
				 onerror="this.src='<c:url value='/resources/img/user-default.jpg'/>'"
				 />
					
					
					
						</div>
						<div class="info">
							<a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									<%=session.getAttribute("username")%>
									<span class="user-level">Administrator</span>
									<span class="caret"></span>
								</span>
							</a>
							<div class="clearfix"></div>

							<div class="collapse in" id="collapseExample">
								<ul class="nav">
									<li>
										<a href="editUserreg?userId=<%=session.getAttribute("userId")%>">
											<span class="link-collapse">My Profile</span>
										</a>
									</li>
								
								</ul>
							</div>
						</div>
					</div>
					<ul class="nav nav-primary">
						<li class="nav-item active">
							<a data-toggle="collapse" href="#dashboard" class="collapsed" aria-expanded="false">
								<i class="fas fa-home"></i>
								<p>Dashboard</p>
								<span class="caret"></span>
							</a>
							
						</li>
						<li class="nav-section">
							<span class="sidebar-mini-icon">
								<i class="fa fa-ellipsis-h"></i>
							</span>
							<h4 class="text-section">Components</h4>
						</li>
						
						<li class="nav-item" hidden="true" id="MangeVehic">
							<a data-toggle="collapse" href="#fmanv">
								<i class="fas fa-pen-square"></i>
								<p>Vehicle Information</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="fmanv">
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
							<a data-toggle="collapse" href="#eqmana" >
								<i class="fas fa-pen-square"></i>
								<p>Testing Equipments</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="eqmana">
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
							<a data-toggle="collapse" href="#testConfig">
								<i class="fas fa-pen-square"></i>
								<p>Test Configurations</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="testConfig">

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
							<a data-toggle="collapse" href="#cuntrySet">
								<i class="fas fa-pen-square"></i>
								<p>Country Specific</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="cuntrySet">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
				<a class="collapse-item fontst-sb-it" href="countryMaster" hidden="true" id="countryMaster">Country specific settings</a>	
			</div>
		</div>
	</li>

	<!-- Corporate information -->

	<li class="nav-item"  hidden="true" id="CorporateInfo">
							<a data-toggle="collapse" href="#corPoinfo">
								<i class="fas fa-pen-square"></i>
								<p>Corporate information</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="corPoinfo">

			<div class="bg-white py-2 collapse-inner rounded" >
				
				<a class="collapse-item fontst-sb-it" href="businessPartner" hidden="true" id="businessPartner">Business partner</a>	
				<a class="collapse-item fontst-sb-it" href="#" hidden="true" id="CorporateCalendar">Partner Corporate Calendar</a>
				<a class="collapse-item fontst-sb-it" href="vehicleRegTypes" hidden="true" id="vehicleRegTypes">Lane Registration Types</a>
			</div>
		</div>
	</li>





<!-- Inspection Profile Mgmt -->

			
	<li class="nav-item"  hidden="true" id="InspectionProfileMgmt">
							<a data-toggle="collapse" href="#testPoint">
								<i class="fas fa-pen-square"></i>
								<p>Test Profiles</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="testPoint">
			
			<div class="bg-white py-2 collapse-inner rounded">
<!-- 				<h6 class="collapse-header">Create Test Profile</h6> -->
<!-- 				<a class="collapse-item fontst-sb-it" href="#"  hidden="true" id="testProfile">Test Profile</a>  -->
				<a class="collapse-item fontst-sb-it" href="testProfile" hidden="true" id="limitValues">Test Profile</a>

<!-- 				<h6 class="collapse-header">Create VI Profile</h6> -->
				<a class="collapse-item fontst-sb-it" href="profileMaster"  hidden="true" id="profileMaster">VI Profile</a>
				<a class="collapse-item fontst-sb-it" href="ProfileStages"  hidden="true" id="ProfileStages">VI Stages</a> 
				<a class="collapse-item fontst-sb-it" href="stageitems"  hidden="true" id="stageitems">VI Stage Items</a> 
				<a class="collapse-item fontst-sb-it" href="ProfileItemsStatus"  hidden="true" id="ProfileItemsStatus">VI Item Status</a> 
				<a class="collapse-item fontst-sb-it" href="itemremarks" hidden="true" id="itemremarks">VI Status Remarks</a>
<!--  				<h6 class="collapse-header"></h6> -->
				<a class="collapse-item fontst-sb-it" href="testCategory"  hidden="true" id="testCategory">Test Categories</a>
			</div>
		</div>
	</li>


	<!-- Center Organization -->

	<li class="nav-item"  hidden="true" id="TestCent">
							<a data-toggle="collapse" href="#inspCenter">
								<i class="fas fa-pen-square"></i>
								<p>Inspection Centers</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="inspCenter">
			<div class="bg-white py-2 collapse-inner rounded">
					<a class="collapse-item fontst-sb-it" href="centerType"  hidden="true" id="centerType">Centers Organization</a> 
					<a class="collapse-item fontst-sb-it" href="CMaster"  hidden="true" id="CMaster">Inspection Centers</a>
					<a class="collapse-item fontst-sb-it" href="equipmentmaster"  hidden="true" id="equipmentmaster">Equipment Allocation</a>
					<a class="collapse-item fontst-sb-it" href="equipmentreport"  hidden="true" id="equipmentreport">Equipments List</a>
					
<!-- 				<h6 class="collapse-header"></h6> -->
				<a class="collapse-item fontst-sb-it" href="testLanes"  hidden="true" id="testLanes">Lane Types</a> 
				<a class="collapse-item fontst-sb-it" href="createNewTestLanes"  hidden="true" id="createNewTestLanes">Test Lanes Configuration</a>
				<!-- <a class="collapse-item fontst-sb-it" href="TestLaneDetails">Test Lane Details</a> -->
			</div>
		</div>
	</li>

<!-- Customer Relationship -->

	<li class="nav-item"  hidden="true" id="CRM">
							<a data-toggle="collapse" href="#crmf">
								<i class="fas fa-pen-square"></i>
								<p>Customer Relationship</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="crmf">
		
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="newCustomer" hidden="true" id="newCustomer">Corporate Customers</a> 
			</div>
		</div>
	</li>
		
	<li class="nav-item"  hidden="true" id="VehicleInspection">
							<a data-toggle="collapse" href="#vehicleInspectionf">
								<i class="fas fa-pen-square"></i>
								<p>Vehicle Inspection</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="vehicleInspectionf">
		
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="appointment" id="appointment">Make Appointment</a>
				<a class="collapse-item fontst-sb-it" href="vehicleInformation" hidden="true" id="vehicleInformation">Gate Entry</a>
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
		
	<li class="nav-item"  hidden="true" id="Finance">
							<a data-toggle="collapse" href="#Financef">
								<i class="fas fa-pen-square"></i>
								<p>Vehicle Inspection</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="Financef">
		
		
			<div class="bg-white py-2 collapse-inner rounded">
<!-- 				  	<h6 class="collapse-header">General:</h6> -->
				<a class="collapse-item fontst-sb-it" href="taxConfiguration" hidden="true" id="taxConfiguration">Tax Settings</a>
<!-- 					<h6 class="collapse-header">Accounts Receivables:</h6> -->
				
				<a class="collapse-item fontst-sb-it" href="vehicalRecCOPY" hidden="true" id="vehicalRecCOPY">Reprint Receipts</a>
				<a class="collapse-item fontst-sb-it" href="vehicalRecCancel" hidden="true" id="vehicalRecCancel">Receipt Cancel</a>
				<a class="collapse-item fontst-sb-it" href="vehicalInvCOPY"  id="vehicalInvCOPY">Reprint Credit Invoice</a>
				<a class="collapse-item fontst-sb-it" href="vehicalInvCancel"  hidden="true" hidden="true" id="vehicalInvCancel">Invoice Cancel</a>
				<a class="collapse-item fontst-sb-it" href="revenueStatementPrivew" hidden="true" id="revenueStatementRpt">Revenue Statement</a>
				<a class="collapse-item fontst-sb-it" href="invoiceSummaryReport" hidden="true" id="invoiceSummaryReport">Invoice Summary Report</a>
				<a class="collapse-item fontst-sb-it" href="incomingPayment"  hidden="true" id="incomingPayment">Incoming Payment</a>				
				<a class="collapse-item fontst-sb-it" href="reprintIncomingReceipt" hidden="true" id="reprintIncomingReceipt">Reprint Incoming Receipt</a>	
				<a class="collapse-item fontst-sb-it" href="incomingReceiptSummary" hidden="true" id="incomingReceiptSummary">Incoming Receipt Summary</a>
				<a class="collapse-item fontst-sb-it" href="ageAnalysisReport" hidden="true"  id="ageAnalysisReport">Age Analysis Report</a>
<!-- 					<h6 class="collapse-header">Accounts Payables:</h6> -->
				<a class="collapse-item fontst-sb-it" href="outgoingPayments"  hidden="true" id="outgoingPayments">Outgoing Payments</a>
				<a class="collapse-item fontst-sb-it" href="reprintOutgoingPayments" hidden="true"  id="reprintOutgoingPayments">Reprint Outgoing Payments</a>
				<a class="collapse-item fontst-sb-it" href="OutgoingPaymentsDetailsReport"  hidden="true" id="OutgoingPaymentsDetailsReport">Outgoing Payments Report</a>
				<a class="collapse-item fontst-sb-it" href="chequePrint"  hidden="true" id="chequePrint">Cheque Print</a>
			</div>
		</div>
	</li>

<!-- User Management -->

	<li class="nav-item"  hidden="true" id="UserManag">
							<a data-toggle="collapse" href="#UserManagf">
								<i class="fas fa-pen-square"></i>
								<p>User Management</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="UserManagf">
		
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item fontst-sb-it" href="userLevel" hidden="true" id="userLevel">User Categories</a> 
				<a class="collapse-item fontst-sb-it" href="register" hidden="true" id="register" >User Registration </a>
				<!--<a class="collapse-item fontst-sb-it" href="editUserreg"  hidden="true" id="editUserreg">Edit Users</a>-->
			</div>
		</div>
	</li>

				
				
				
				
					</ul>
				</div>
			</div>
		</div>
		
		
	
		
