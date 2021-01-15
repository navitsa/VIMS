<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
	.vidSty{
	font-family: Arial, Helvetica, sans-serif;	
	font-size:30px;
	font-weight: bold;
	color: #02d41b;	
	}
	
	
	    .textred{
       font-family: Arial, Helvetica, sans-serif;
        border: 0px solid #b30000;
		font-size:14px;
		font-weight:bold;
       	text-align:center;
       	color: #2c03fc;	
     
       }  
	      .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
           height: 30px;
         }
         .l-fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 5px;
          margin-top: 0px;
         }
        .iconali{
        	position: absolute; 
  			top: 6px;
			right:-7px;
        
        }
        .capCam{

  			height: 100px;
  			width: 210px;	
		}
		.cursiz{
		font-family: Arial, Helvetica, sans-serif;
        font-size: 12px;
		width: 48px;	
		color: #ff8000;
		
		}
		.amt{
		font-family: Arial, Helvetica, sans-serif;
       font-size: 12px;
       width:60px;
		color: blue;
		text-align: right;
		}

	   .iconstyle{		
  			width: 7%;
  			color:blue';
       }
       .icon-pre-ve{
        width: 150%;
  		
       
       }	
</style>
	
</head>
<body onload="checkStatusofDropdowns();">
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->
				<%@include file="../WEB-INF/jsp/logoHeader.jsp"%>
			<!-- End Logo Header -->
			<!-- Navbar Header -->
				<%@include file="../WEB-INF/jsp/navbar.jsp"%>
			<!-- End Navbar -->
		</div>
		<!-- Sidebar -->
			<%@include file="../WEB-INF/jsp/slideBar.jsp"%>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								 <h2 class="text-white pb-2 fw-bold">Ticket Close</h2>
							</div>
							<div class="col-xl-2 col-lg-2">
								
							</div>
							<div class="ml-md-auto py-2 py-md-4">
							  
							
							</div>
						
							<div class="ml-md-auto py-2 py-md-4">
							</div>
						</div>
					</div>
				</div>
				
				<div class="page-inner mt--5">	
					<div class="container-fluid">

							<div class="col-xl-12 col-md-6mb-4">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">

<form:form action="saveCloseTicket" modelAttribute="closeTicket" method="POST" enctype="multipart/form-data" > 
		<div class=" row">
			<div class="col-sm-7">

		
				<div class="form-group row">
					<div class="col-sm-3">	
						<label>Issue Tickets</label>
							<form:select class="form-control fontst" path="ticketNo.ticketNo" onchange="getOpenTicketDetails(this.value);"     
								 id="tldid">
								<form:option value="000">--SELECT--</form:option>
								<c:forEach items="${openTicket}" var="openTicket">
									<form:option value="${openTicket.ticketNo}">${openTicket.issue} </form:option>
								</c:forEach>
							</form:select>	
					
					</div>
					<div class="col-sm-3">	
							<label>supervised By</label>
						<form:select class="form-control fontst" path="userId.userId"
												required="Required" id="users" >
							<form:option value="">--SELECT--</form:option>
							<c:forEach items="${calibrationUsercombo}" var="use">
							<form:option value="${use.userId}">${use.userName}</form:option>
							</c:forEach>
							</form:select>
						
					</div>
				
				<div class="col-sm-3">
				
				<label >Close Time</label>
						<form:input type="time" path="closeTime" class="form-control"/>
				
				</div>
				
				
				
				
				</div>
				
				<div class="form-group row">

					<div class="col-sm-6">
						<label >Remarks</label>
						<form:textarea path="remarks" class="form-control"/>
					</div>
					<div class="col-sm-6">
						
					</div>
				</div>
	
				<div class="form-group row">
									<div class="col-sm-6">
										<input type="submit" class="btn btn-success"
																			value="Save">
									
									</div>
									<div class="col-sm-6">
<!-- 										<input type="button" class="btn btn-warning" -->
<!-- 																			onclick="clear1()" value="CLEAR"> -->
									
									</div>
						</div>		
				
				
				
				
			</div>
			<div class="col-sm-5">
				
				<div class="row table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar">
					<div class="col-lg" id="ticketDetails"></div>
				</div>

			
			</div>
		</div>	
</form:form>


					</div>	
				</div>
				
			</div>	

					</div>	
				</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script type="text/javascript">
		function getOpenTicketDetails(etr) {
            var slctSubcat=$('#ticketDetails'), option="";
            slctSubcat.empty();
			$.ajax({

			    type: 'POST',
			    url: "getOpenTicketDetails",
			    data: {"ticketNo":etr},
		        success: function(data){
		          
		            slctSubcat.empty();
		    
		            
		            var selected1="";
		            
		            
		            if(data.testLaneHeadId!=null){
		            	
		            	selected1=selected1+"<div class='row'>"+
							"<div class='col-sm-12'>"+
								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 14px'> Lane : "+data.testLaneHeadId.laneName+"</div>"+
							"</div>"+
						"</div>"+
						
						"<div class='row'>"+
							"<div class='col-sm-12'>"+
								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>Time/Status : "+data.laneIssueTime+" / "+data.laneStatus+"</div>"+
							"</div>"+
						"</div><hr/>";
		            }
		            
		            if(data.equipmentID!=null){
		            	
		            	selected1=selected1+"<div class='row'>"+
						"<div class='col-sm-12'>"+
						"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 14px'> Equipment : "+data.equipmentID.serialNo+"</div>"+
					"</div>"+
				"</div>"+
				
				"<div class='row'>"+
					"<div class='col-sm-12'>"+
						"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>Time/Status : "+data.equipmentIssueTime+" / "+data.eqIsWorking+"</div>";
		            }
		            
		            
		            
		        
		
		        		selected_option = "<div class='row'style=''>"+
	 					
	 					"<div class='col-sm-12'>"+
	 					
 						"<div class='row'>"+
 							"<div class='col-sm-12'>"+
 								"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 27px'> Ticket No/Issue : "+data.ticketNo+" / "+data.issue+"</div>"+
 							"</div>"+
 						"</div>"+
		        		
		        		
	 						"<div class='row'>"+
	 							"<div class='col-sm-12'>"+
	 								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 18px'> Issue Type : "+data.issueType+"</div>"+
	 							"</div>"+
	 						"</div>"+
	 						
	 						"<div class='row'>"+
	 							"<div class='col-sm-12'>"+
	 								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 15px'> Date/Time     : "+data.issueDate+"  "+data.issueTime+"</div>"+
	 							"</div>"+
	 						"</div><hr/>"+
	 						
	 						
	 						selected1+
	 						
 						
							"</div>"+
						"</div>"+			
	 						
	 						
	 						
	 						
	 						
	 						
	 						
	 						

	 					"</div>"+
	 					
	 					
	 					"<hr/></div>";
		        		
		        		
		            	 slctSubcat.append(selected_option);	
		            	 
		    	         
		        	

			        	
			        },
			        error:function(){
			        //	alert("Error");
			        }
				 });
		        		
		        		
		        		
		}
</script>
</body>
</html>