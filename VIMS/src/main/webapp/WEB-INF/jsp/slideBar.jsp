
<div class="sidebar sidebar-style-2">
	<div class="sidebar-wrapper scrollbar scrollbar-inner">
		<div class="sidebar-content">
			<div class="user">
				<div class="avatar-sm float-left mr-2">

					<img class="avatar-img rounded-circle"
						src="data:image/jpg;base64,<%=session.getAttribute("user")%>"
						onerror="this.src='<c:url value='/resources/img/user-default.jpg'/>'" />



				</div>
				<div class="info">
					<a data-toggle="collapse" href="#collapseExample"
						aria-expanded="true"> <span> <%=session.getAttribute("username")%>
							<span class="user-level">Administrator</span> <span class="caret"></span>
					</span>
					</a>
					<div class="clearfix"></div>

					<div class="collapse in" id="collapseExample">
						<ul class="nav">
							<li><a
								href="editUserreg?userId=<%=session.getAttribute("userId")%>">
									<span class="link-collapse">My Profile</span>
							</a></li>
							<li><a href="#" data-toggle="modal"
								data-target="#logoutModal"> <span class="link-collapse">Logout</span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<ul class="nav nav-primary">
				<li class="nav-item active">
					<!-- 							<a data-toggle="collapse" href="Dashboard" > --> <a
					href="Dashboard"> <i class="fas fa-home"></i>
						<p>Dashboard</p></a> <!-- 							</a> -->

				</li>
				<!-- 						<li class="nav-section"> -->
				<!-- 							<span class="sidebar-mini-icon"> -->
				<!-- 								<i class="fa fa-ellipsis-h"></i> -->
				<!-- 							</span> -->
				<!-- 							<h4 class="text-section">Components</h4> -->
				<!-- 						</li> -->

				<li class="nav-item" hidden="true" id="MangeVehic"><a
					data-toggle="collapse" href="#fmanv"> <i
						class="fas fa-pen-square"></i>
						<p>Vehicle Information</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="fmanv">
						<div class="bg-white py-2 collapse-inner rounded">
							<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
							<a class="collapse-item fontst-sb-it" href="vehicleCategory"
								hidden="true" id="vehicleCategory">Vehicle Category</a> <a
								class="collapse-item fontst-sb-it" href="vehicleClasss"
								hidden="true" id="vehicleClasss">Vehicle Class</a> <a
								class="collapse-item fontst-sb-it" href="vehicleMake"
								hidden="true" id="vehicleMake">Vehicle Makes </a> <a
								class="collapse-item fontst-sb-it" href="vehiclemodel1"
								hidden="true" id="vehiclemodel1">Vehicle Models</a> <a
								class="collapse-item fontst-sb-it" href="document" hidden="true"
								id="document">Add Document</a>
						</div>
					</div></li>



				<!-- Test Configurations -->
				<li class="nav-item" hidden="true" id="TestConfig"><a
					data-toggle="collapse" href="#testConfig"> <i
						class="fas fa-pen-square"></i>
						<p>Test Configurations</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="testConfig">

						<div class="bg-white py-2 collapse-inner rounded">
							<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
							<a class="collapse-item fontst-sb-it" href="testTYPE"
								hidden="true" id="testTYPE">Test Types</a> <a
								class="collapse-item fontst-sb-it" href="testPoints"
								hidden="true" id="TestPoint">Test Points</a> <a
								class="collapse-item fontst-sb-it" href="#" hidden="true"
								id="TestPrameters">Test Parameters & Directions</a>

						</div>
					</div></li>


				<!-- Country Specific  -->
				<li class="nav-item" hidden="true" id="CountrySp"><a
					data-toggle="collapse" href="#cuntrySet"> <i
						class="fas fa-pen-square"></i>
						<p>Country Specific</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="cuntrySet">
						<div class="bg-white py-2 collapse-inner rounded">
							<!-- 				<h6 class="collapse-header">Main Components:</h6> -->
							<a class="collapse-item fontst-sb-it" href="countryMaster"
								hidden="true" id="countryMaster">Country Specific Settings</a>
						</div>
					</div></li>

				<!-- Corporate information -->

				<li class="nav-item" hidden="true" id="CorporateInfo"><a
					data-toggle="collapse" href="#corPoinfo"> <i
						class="fas fa-pen-square"></i>
						<p>Corporate Information</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="corPoinfo">

						<div class="bg-white py-2 collapse-inner rounded">

							<a class="collapse-item fontst-sb-it" href="businessPartner"
								hidden="true" id="businessPartner">Business Partners</a> <a
								class="collapse-item fontst-sb-it" href="#" hidden="true"
								id="CorporateCalendar">Partner Corporate Calendar</a> <a
								class="collapse-item fontst-sb-it" href="vehicleRegTypes"
								hidden="true" id="vehicleRegTypes">Lane Registration Types</a> <a
								class="collapse-item fontst-sb-it" href="laneAllocation"
								hidden="true" id="laneAllocation">Lane Allocation</a> <a
								class="collapse-item fontst-sb-it" href="createGate"
								id="createGate" hidden="true">Create Gate</a>
						</div>
					</div></li>





				<!-- Inspection Profile Mgmt -->


				<li class="nav-item" hidden="true" id="InspectionProfileMgmt">
					<a data-toggle="collapse" href="#testPoint"> <i
						class="fas fa-pen-square"></i>
						<p>Test Profiles</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="testPoint">

						<div class="bg-white py-2 collapse-inner rounded">
							<!-- 				<h6 class="collapse-header">Create Test Profile</h6> -->
							<!-- 				<a class="collapse-item fontst-sb-it" href="#"  hidden="true" id="testProfile">Test Profile</a>  -->
							<a class="collapse-item fontst-sb-it" href="parameterCode"
								hidden="true" id="parameterCode">Parameter Code</a> <a
								class="collapse-item fontst-sb-it" href="testLimitRule"
								hidden="true" id="testLimitRule">Test Limit Rule</a> <a
								class="collapse-item fontst-sb-it" href="testProfile"
								hidden="true" id="limitValues">Test Profile</a>

							<!-- 				<h6 class="collapse-header">Create VI Profile</h6> -->
							<a class="collapse-item fontst-sb-it" href="profileMaster"
								hidden="true" id="profileMaster">VI Profile</a> <a
								class="collapse-item fontst-sb-it" href="ProfileStages"
								hidden="true" id="ProfileStages">VI Stages</a> <a
								class="collapse-item fontst-sb-it" href="stageitems"
								hidden="true" id="stageitems">VI Stage Items</a> <a
								class="collapse-item fontst-sb-it" href="ProfileItemsStatus"
								hidden="true" id="ProfileItemsStatus">VI Item Status</a> <a
								class="collapse-item fontst-sb-it" href="itemremarks"
								hidden="true" id="itemremarks">VI Status Remarks</a>
							<!--  				<h6 class="collapse-header"></h6> -->
							<a class="collapse-item fontst-sb-it" href="testCategory"
								hidden="true" id="testCategory">Test Categories</a>
						</div>
					</div>
				</li>


				<!-- Center Organization -->

				<li class="nav-item" hidden="true" id="TestCent"><a
					data-toggle="collapse" href="#inspCenter"> <i
						class="fas fa-pen-square"></i>
						<p>Inspection Centers</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="inspCenter">
						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item fontst-sb-it" href="centerType"
								hidden="true" id="centerType">Centers Organization</a> <a
								class="collapse-item fontst-sb-it" href="CMaster" hidden="true"
								id="CMaster">Inspection Centers</a> <a
								class="collapse-item fontst-sb-it" href="equipmentreport"
								hidden="true" id="equipmentreport">Equipments List</a>

							<!-- 				<h6 class="collapse-header"></h6> -->
							<a class="collapse-item fontst-sb-it" href="testLanes"
								hidden="true" id="testLanes">Lane Types</a> <a
								class="collapse-item fontst-sb-it" href="createNewTestLanes"
								hidden="true" id="createNewTestLanes">Test Lanes
								Configuration</a>
							<!-- <a class="collapse-item fontst-sb-it" href="TestLaneDetails">Test Lane Details</a> -->
						</div>
					</div></li>

				<!-- Customer Relationship -->

				<li class="nav-item" hidden="true" id="CRM"><a
					data-toggle="collapse" href="#crmf"> <i
						class="fas fa-pen-square"></i>
						<p>Customer Relationship</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="crmf">

						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item fontst-sb-it" href="newCustomer"
								hidden="true" id="newCustomer">Corporate Customers</a>
						</div>
					</div></li>

				<li class="nav-item" hidden="true" id="VehicleInspection"><a
					data-toggle="collapse" href="#vehicleInspectionf"> <i
						class="fas fa-pen-square"></i>
						<p>Vehicle Inspection</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="vehicleInspectionf">
						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item fontst-sb-it" href="appointment"
								hidden="true" id="appointment">Make Appointment</a> <a
								class="collapse-item fontst-sb-it" href="vehicleInformation"
								hidden="true" id="vehicleInformation">Gate Entry</a> <a
								class="collapse-item fontst-sb-it" href="laneEntryView"
								hidden="true" id="laneEntryView">Lane Entry</a> <a
								class="collapse-item fontst-sb-it" href="vehicleMaster"
								hidden="true" id="vehicleMaster">Vehicle Master</a> <a
								class="collapse-item fontst-sb-it" href="visualChecklist"
								hidden="true" id="visualChecklist">Perform Visual Inspection</a>
							<a class="collapse-item fontst-sb-it" href="visualInspectReports"
								hidden="true" id="getReport">Issue VI Report</a> <a
								class="collapse-item fontst-sb-it" href="testValueFile"
								hidden="true" id="testValueFile">Issue Test Report</a> <a
								class="collapse-item fontst-sb-it" href="previousTestReports"
								hidden="true" id="reprintTestReport">Reprint Test Report</a> <a
								class="collapse-item fontst-sb-it" href="VehicleReportPreview"
								hidden="true" id="vehicalDetailRpt">Vehicle Lane Entry
								Status</a>

						</div>
					</div></li>

				<!-- Finance & Accounting -->
				<li class="nav-item" hidden="true" id="Finance"><a
					data-toggle="collapse" href="#Financef"> <i
						class="fas fa-pen-square"></i>
						<p>Finance & Accounting</p> <span class="caret"></span>
				</a>
					<div class="nav-section collapse" id="Financef">


						<h6 class="text-section">General:</h6>
						<a class="collapse-item fontst-sb-it" href="newCustomer"
							hidden="true" id="newCustomer">Corporate Customers</a> <a
							class="collapse-item fontst-sb-it" href="taxConfiguration"
							hidden="true" id="taxConfiguration">Tax Settings</a> <a
							class="collapse-item fontst-sb-it" href="chartOfAccounts"
							id="chartOfAccounts">Chart of Accounts</a> <a
							class="collapse-item fontst-sb-it" href="GLAccountMapping"
							id="GLAccountMapping">GL Account Mapping</a> <a
							class="collapse-item fontst-sb-it" href="createBank"
							id="createBank">Bank</a> <a class="collapse-item fontst-sb-it"
							href="createBankBranch" id="createBankBranch">Bank Branch</a> <a
							class="collapse-item fontst-sb-it" href="partnerBankAccount"
							id="partnerBankAccount">Partner Bank Account</a> <a
							class="collapse-item fontst-sb-it" href="journalVoucher"
							id="journalVoucher">Journal Voucher</a>





						<p class="text-section">Account Receivables:</p>
						<a class="collapse-item fontst-sb-it" href="incomingPayment"
							hidden="true" id="incomingPayment">Incoming Payment</a> <a
							class="collapse-item fontst-sb-it" href="vehicalRecCOPY"
							hidden="true" id="vehicalRecCOPY">Reprint Receipt</a> <a
							class="collapse-item fontst-sb-it" href="vehicalInvCOPY"
							id="vehicalInvCOPY">Reprint Credit Invoice</a> <a
							class="collapse-item fontst-sb-it" href="reprintIncomingReceipt"
							hidden="true" id="reprintIncomingReceipt">Reprint Payment
							Receipt</a> <a class="collapse-item fontst-sb-it"
							href="vehicalRecCancel" hidden="true" id="vehicalRecCancel">Cancel
							Receipt</a> <a class="collapse-item fontst-sb-it"
							href="vehicalInvCancel" hidden="true" hidden="true"
							id="vehicalInvCancel">Cancel Invoice</a> <a
							class="collapse-item fontst-sb-it" href="invoiceSummaryReport"
							hidden="true" id="invoiceSummaryReport">Invoice Summary
							Report</a> <a class="collapse-item fontst-sb-it"
							href="incomingReceiptSummary" hidden="true"
							id="incomingReceiptSummary">Incoming Receipt Summary</a>


						<h6 class="text-section">Account Payable:</h6>
						<a class="collapse-item fontst-sb-it" href="outgoingPayments"
							hidden="true" id="outgoingPayments">Outgoing Payments</a> <a
							class="collapse-item fontst-sb-it" href="reprintOutgoingPayments"
							hidden="true" id="reprintOutgoingPayments">Reprint Outgoing
							Payments</a> <a class="collapse-item fontst-sb-it"
							href="OutgoingPaymentsDetailsReport" hidden="true"
							id="OutgoingPaymentsDetailsReport">Outgoing Payments Report</a> <a
							class="collapse-item fontst-sb-it" href="chequePrint"
							hidden="true" id="chequePrint">Cheque Print</a> <a
							class="collapse-item fontst-sb-it" href="APInvoice"
							id="APInvoice" hidden="true">AP Invoice</a><a
							class="collapse-item fontst-sb-it" href="APInvoiceSummaryReport"
							id="APInvoiceSummaryReport" hidden="true">AP Invoice Summary
							Report</a><a class="collapse-item fontst-sb-it"
							href="APInvoiceAgeAnalysisReport" id="APInvoiceAgeAnalysisReport"
							hidden="true">AP Invoice Age Analysis Report</a><a
							class="collapse-item fontst-sb-it" href="APInvoiceBalanceReport"
							id="APInvoiceBalanceReport" hidden="true">AP Invoice Balance
							Report</a><a class="collapse-item fontst-sb-it"
							href="APInvoicePaymentHistoryReport"
							id="APInvoicePaymentHistoryReport" hidden="true">AP Invoice
							Payment History Report</a>
						<h6 class="text-section">Financials:</h6>
						<a class="collapse-item fontst-sb-it"
							href="revenueStatementPrivew" hidden="true"
							id="revenueStatementRpt">Revenue Statement</a> <a
							class="collapse-item fontst-sb-it" href="ageAnalysisReport"
							hidden="true" id="ageAnalysisReport">Age Analysis Report</a> <a
							class="collapse-item fontst-sb-it" href=trialBalance
							id="trialBalance">Trial Balance</a> <a
							class="collapse-item fontst-sb-it" href="profitsAndLoss"
							id="profitsAndLoss">Profit & Loss(P&L)</a> <a
							class="collapse-item fontst-sb-it" href="glTranctionReport"
							id="glTranctionReport">GL Tranction Report</a><a
							class="collapse-item fontst-sb-it"
							href="DocumentTransactionDetailsReport"
							id="DocumentTransactionDetailsReport" hidden="true">Document
							Transaction Details Report</a><a class="collapse-item fontst-sb-it"
							href="VendorGLTransactionReport" id="VendorGLTransactionReport"
							hidden="true">Vendor GL Transaction Report</a><a class="collapse-item fontst-sb-it"
							href="CustomerGLTransactionReport" id="CustomerGLTransactionReport"
							hidden="true">Customer GL Transaction Report</a>
					</div></li>

				<li class="nav-item" hidden="true" id="Equipment"><a
					data-toggle="collapse" href="#Equipmentf"> <i
						class="fas fa-pen-square"></i>
						<p>Equipment</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="Equipmentf">

						<a class="collapse-item fontst-sb-it" href="equipmenttype"
							hidden="true" id="equipmenttype">Equipment Types</a> <a
							class="collapse-item fontst-sb-it" href="equipmentmake"
							hidden="true" id="equipmentmake">Equipment Makes</a> <a
							class="collapse-item fontst-sb-it" href="equipmentmodel"
							hidden="true" id="equipmentmodel">Equipment Models</a> <a
							class="collapse-item fontst-sb-it" href="equipmentmaster"
							hidden="true" id="equipmentmaster">Equipment Allocation</a>

					</div></li>




				<!-- User Management -->

				<li class="nav-item" hidden="true" id="UserManag"><a
					data-toggle="collapse" href="#UserManagf"> <i
						class="fas fa-pen-square"></i>
						<p>User Management</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="UserManagf">

						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item fontst-sb-it" href="userLevel"
								hidden="true" id="userLevel">User Categories</a> <a
								class="collapse-item fontst-sb-it" href="registerVtest"
								hidden="true" id="register">User Registration </a>
							<a class="collapse-item fontst-sb-it" href="registerEmp"
								hidden="true" id="registerEmp">Employee Registration</a>
								<a class="collapse-item fontst-sb-it" href="userActiveInactive"
								hidden="true" id="userActiveInactive">User Active / Inactive
							</a> <a href="#" data-toggle="modal" data-target="#dbbakModal"
								hidden="true" id="dbbak"> <span class="link-collapse">DBBakup</span>
							</a>

							<!--<a class="collapse-item fontst-sb-it" href="editUserreg"  hidden="true" id="editUserreg">Edit Users</a>-->
						</div>
					</div></li>
				<!-- Admin Panel -->
				<li class="nav-item" hidden="true" id="adminPanel"><a
					data-toggle="collapse" href="#adminPan"> <i
						class="fas fa-pen-square"></i>
						<p>Admin Panel</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="adminPan">


						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item fontst-sb-it" href="esin" hidden="true"
								id="esin">ES_IN Create</a> <a class="collapse-item fontst-sb-it"
								href="esout" hidden="true" id="esout">ES_OUT Create</a>

						</div>
					</div></li>
				<!-- maintenance -->

				<li class="nav-item" id="maintenance" hidden="true"><a
					data-toggle="collapse" href="#eMaintenance"> <i
						class="fas fa-pen-square"></i>
						<p>Maintenance</p> <span class="caret"></span>
				</a>
					<div class="nav-section collapse" id="eMaintenance">

						<!-- 			<div class="bg-white py-2 collapse-inner rounded"> -->
						<a class="collapse-item fontst-sb-it" href="maintenanceDashboard"
							id="maintenanceDashboard">Maintenance Dashboard</a> <a
							class="collapse-item fontst-sb-it" href="MaintanceCalander"
							id="MaintanceCalander">Maintaince Calendar</a>



						<h6 class="text-section">Calibration :</h6>
						<a class="collapse-item fontst-sb-it" href="calibrationSchedule"
							id="calibrationSchedule" hidden="true">Calibration Schedule</a> <a
							class="collapse-item fontst-sb-it" href="calibrationCalendar"
							id="calibrationCalendar" hidden="true">Calibration Calendar</a> <a
							class="collapse-item fontst-sb-it" href="equipmentsCalibration"
							id="equipmentsCalibration" hidden="true">Equipment
							Calibration</a> <a class="collapse-item fontst-sb-it"
							href="equipmentsCalibrationRpt" id="equipmentsCalibrationRpt"
							hidden="true">Calibration Report</a>


						<h6 class="text-section">Service :</h6>
						<a class="collapse-item fontst-sb-it" href="serviceSchedule"
							id="serviceSchedule" hidden="true">Service Schedule</a> <a
							class="collapse-item fontst-sb-it" href="serviceCalendar"
							id="serviceCalendar" hidden="true">Service Calendar</a> <a
							class="collapse-item fontst-sb-it" href="equipmentsService"
							id="equipmentsService" hidden="true">Equipment Service</a> <a
							class="collapse-item fontst-sb-it" href="equipmentsServiceRpt"
							id="equipmentsServiceRpt" hidden="true">Service Report</a>

						<h6 class="text-section">Incident :</h6>
						<a class="collapse-item fontst-sb-it" href="issueTicket"
							id="issueTicket" hidden="true">Issue Ticket</a> <a
							class="collapse-item fontst-sb-it" href="incidentReport"
							id="incidentReport" hidden="true">Incident Report</a> <a
							class="collapse-item fontst-sb-it" href="closeTicket"
							id="closeTicket" hidden="true">Ticket Close</a> <a
							class="collapse-item fontst-sb-it" href="statusTicketReport"
							id="statusTicketReport" hidden="true">Ticket Status Report</a> <a
							class="collapse-item fontst-sb-it" href="downTimeReport"
							id="downTimeReport" hidden="true">Down Time Report</a>

						<h6 class="text-section">Repair :</h6>
						<a class="collapse-item fontst-sb-it" href="jobCard" id="jobCard"
							hidden="true">Issue Job Card</a> <a
							class="collapse-item fontst-sb-it" href="repair" id="repair"
							hidden="true">Repair</a> <a class="collapse-item fontst-sb-it"
							href="equipmentRepairReport" id="equipmentRepairReport"
							hidden="true">Repair Report</a>

						<h6 class="text-section">Inventory :</h6>
						<a class="collapse-item fontst-sb-it"
							href="SupplierMaster" id="SupplierMaster"
							hidden="true">Supplier</a><a class="collapse-item fontst-sb-it"
							href="ItemMaster" id="ItemMaster"
							hidden="true">Item</a>
						<!-- 			</div> -->
					</div></li>


				<!-- HRM -->

				<li class="nav-item" hidden="true" id="hrm"><a
					data-toggle="collapse" href="#hrmSubMenu"> <i
						class="fas fa-pen-square"></i>
						<p>HRM</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="#hrmSubMenu">
						<div class="bg-white py-2 collapse-inner rounded">

							<h6 class="text-section">Company Details :</h6>

							<a class="collapse-item fontst-sb-it" href="companyMasterPage"
								hidden="true" id="companyMasterPage">Company</a>



							<h6 class="text-section">Personal Details :</h6>

							<a class="collapse-item fontst-sb-it" href="nationalityMaster"
								hidden="true" id="nationalityMaster">Nationality</a> <a
								class="collapse-item fontst-sb-it" href="religionMaster"
								hidden="true" id="religionMaster">Religion</a> <a
								class="collapse-item fontst-sb-it" href="employeeIdDocument"
								hidden="true" id="employeeIdDocument">Employee Document</a> <a
								class="collapse-item fontst-sb-it" href="dependentTypeMaster"
								hidden="true" id="dependentTypeMaster">Dependent Type</a> <a
								class="collapse-item fontst-sb-it" href="membershipInformation"
								hidden="true" id="membershipInformation">Membership Types</a> <a
								class="collapse-item fontst-sb-it" href="employeeType"
								hidden="true" id="employeeType">Employee Type</a> <a
								class="collapse-item fontst-sb-it" href="employeeCategory"
								hidden="true" id="employeeCategory">Employee Category</a> <a
								class="collapse-item fontst-sb-it" href="languageMaster"
								hidden="true" id="languageMaster">Language</a> <a
								class="collapse-item fontst-sb-it" href="qualificationMaster"
								hidden="true" id="qualificationMaster">Qualification Type</a> <a
								class="collapse-item fontst-sb-it" href="skillMaster"
								hidden="true" id="skillMaster">Skill Type</a> <a
								class="collapse-item fontst-sb-it" href="extraActivityType"
								hidden="true" id="extraActivityType">Extra Activity Type</a> <a
								class="collapse-item fontst-sb-it" href="jobPmaster"
								hidden="true" id="jobPmaster">Job Profile</a> <a
								class="collapse-item fontst-sb-it" href="jobDetails"
								hidden="true" id="jobDetails">Job Profile Details</a> <a
								class="collapse-item fontst-sb-it" href="designationmaster"
								hidden="true" id="designationmaster">Designation</a> <a
								class="collapse-item fontst-sb-it" href="salaryGrades"
								hidden="true" id="salaryGrades">Salary Grade</a> <a
								class="collapse-item fontst-sb-it" href="salaryRange"
								hidden="true" id="salaryRange">Salary Range</a> <a
								class="collapse-item fontst-sb-it" href="departmentMaster"
								hidden="true" id="departmentMaster">Department</a> <a
								class="collapse-item fontst-sb-it" href="bank" hidden="true"
								id="bank">Bank</a> <a class="collapse-item fontst-sb-it"
								href="bankInfor" hidden="true" id="bankInfor">Bank Branch</a>



							<h6 class="text-section">Employee Details :</h6>

							<a class="collapse-item fontst-sb-it" href="register"
								hidden="true" id="register">Register</a>



							<h6 class="text-section">Pay Details :</h6>

							<a class="collapse-item fontst-sb-it" href="payAddDeductTypes"
								hidden="true" id="payAddDeductTypes">Set Allowance Types</a> <a
								class="collapse-item fontst-sb-it" href="setting" hidden="true"
								id="setting">Setting</a> <a class="collapse-item fontst-sb-it"
								href="createPayPeriod" hidden="true" id="createPayPeriod">Pay
								Periods</a> <a class="collapse-item fontst-sb-it" href="Paycodes"
								hidden="true" id="Paycodes">Pay Codes</a> <a
								class="collapse-item fontst-sb-it" href="employeeSalaryMaster"
								hidden="true" id="employeeSalaryMaster">Employee Salary</a> <a
								class="collapse-item fontst-sb-it"
								href="getEmployeeSalaryDetailsPage" hidden="true"
								id="getEmployeeSalaryDetailsPage">Allocate Allowances Yearly</a>

							<a class="collapse-item fontst-sb-it"
								href="getEmpMonthSalaryDetailsPage" hidden="true"
								id="getEmpMonthSalaryDetailsPage">Allocate Allowances
								Monthly</a> <a class="collapse-item fontst-sb-it"
								href="getProcessPayrollPage" hidden="true"
								id="getProcessPayrollPage">Salary Process</a> <a
								class="collapse-item fontst-sb-it" href="getSalaryMonthEnd"
								hidden="true" id="getSalaryMonthEnd">Month End</a> <a
								class="collapse-item fontst-sb-it" href="processPayRollReport"
								hidden="true" id="processPayRollReport">PaySlip</a> <a
								class="collapse-item fontst-sb-it" href="getSalaryAnalyzer"
								hidden="true" id="getSalaryAnalyzer">Salary Analyze</a> <a
								class="collapse-item fontst-sb-it" href="getFTDReport"
								hidden="true" id="getFTDReport">Fixed Transaction details</a>



							<h6 class="text-section">Time and Attendance :</h6>

							<a class="collapse-item fontst-sb-it" href="ShiftMaster"
								hidden="true" id="ShiftMaster">Shifts</a> <a
								class="collapse-item fontst-sb-it" href="ShiftAllocation"
								hidden="true" id="ShiftAllocation">Shift Allocation</a> <a
								class="collapse-item fontst-sb-it" href="AllocatedShifts"
								hidden="true" id="AllocatedShifts">Allocated Shifts</a> <a
								class="collapse-item fontst-sb-it" href="EmployeeAttendance"
								hidden="true" id="EmployeeAttendance">Manual Employee
								Attendance</a> <a class="collapse-item fontst-sb-it"
								href="AttendanceLog" hidden="true" id="AttendanceLog">Attendance
								Log</a> <a class="collapse-item fontst-sb-it"
								href="EmployeeAttendanceApproval" hidden="true"
								id="EmployeeAttendanceApproval">Attendance Approval</a> <a
								class="collapse-item fontst-sb-it" href="AttendanceReport"
								hidden="true" id="AttendanceReport">Attendance Report</a> <a
								class="collapse-item fontst-sb-it" href="AttendanceSheet"
								hidden="true" id="AttendanceSheet">Attendance Sheet</a> <a
								class="collapse-item fontst-sb-it" href="AttendanceRevise"
								hidden="true" id="AttendanceRevise">Attendance Revise</a> <a
								class="collapse-item fontst-sb-it"
								href="AttendanceReviseApproval" hidden="true"
								id="AttendanceReviseApproval">Revise Approval</a> <a
								class="collapse-item fontst-sb-it" href="ShiftDetailReport"
								hidden="true" id="ShiftDetailReport">Shift Detail Report</a>



							<h6 class="text-section">Leave Details :</h6>

							<a class="collapse-item fontst-sb-it" href="calanderOpen"
								hidden="true" id="calanderOpen">Calendar</a> <a
								class="collapse-item fontst-sb-it" href="leaveTypes"
								hidden="true" id="leaveTypes">Leave Types</a> <a
								class="collapse-item fontst-sb-it" href="employeeEntitlements"
								hidden="true" id="employeeEntitlements">Employee
								Entitlements</a> <a class="collapse-item fontst-sb-it"
								href="applyLeaves" hidden="true" id="applyLeaves">Apply for
								Leave</a> <a class="collapse-item fontst-sb-it" href="leaveApplied"
								hidden="true" id="leaveApplied">Approval of Leave</a>



							<h6 class="text-section">Reports Details :</h6>

							<a class="collapse-item fontst-sb-it" href="employeeReport"
								hidden="true" id="employeeReport">Employee Report</a> <a
								class="collapse-item fontst-sb-it" href="censusReport"
								hidden="true" id="censusReport">Census Report</a> <a
								class="collapse-item fontst-sb-it" href="contactReport"
								hidden="true" id="contactReport">Employee Contact Report</a> <a
								class="collapse-item fontst-sb-it" href="dependentReport"
								hidden="true" id="dependentReport">Dependent Report</a> <a
								class="collapse-item fontst-sb-it" href="qualificationReport"
								hidden="true" id="qualificationReport">Qualification Report</a>

							<a class="collapse-item fontst-sb-it" href="skillReport"
								hidden="true" id="skillReport">Skill Report</a> <a
								class="collapse-item fontst-sb-it" href="employeeContactListing"
								hidden="true" id="employeeContactListing">Employee Contact
								Listing</a> <a class="collapse-item fontst-sb-it"
								href="employeeListingRpt" hidden="true" id="employeeListingRpt">Employee
								Listing Report</a> <a class="collapse-item fontst-sb-it"
								href="leaveSummaryReport" hidden="true" id="leaveSummaryReport">Leave
								Summary Report</a>


						</div>
					</div></li>


			</ul>
		</div>
	</div>
</div>




