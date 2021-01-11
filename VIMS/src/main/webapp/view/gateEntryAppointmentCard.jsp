<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css"/>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
</head>
<body onload="getApposByDate('')">


					<div class="card shadow mb-4">

						<div class="card-header py-2 d-flex flex-row align-items-center">
							
							<h6 class="m-0 mr-sm-2 font-weight-bold text-primary">Upcoming Appointments</h6>

							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary btn-sm" 
								id="alertbtn" onclick="lateNotify()" >
								Alert
							</button>

							<span class="badge badge-pill badge-warning" id="noOfAppos"
								style="font-size: 15px; font-weight: 900; color: black; border-radius: 50%;">
							</span>
							
						</div>
						
						<!-- Card Body -->
						<div class="card-body  table-wrapper-scroll-y my-custom-scrollbar" style="height: 630px">

							<div class="form-group">
							    <div class="input-group date" id="datetimepicker4" data-target-input="nearest">     
							        <div class="input-group-append" data-target="#datetimepicker4" data-toggle="datetimepicker">
							            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
							        </div>
							        <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker4"/>
							    </div>
							</div>
															
							<div class="row">
								<div class="col-lg" id="appoDiv"></div>
							</div>
						</div>
						
					</div>




<script type="text/javascript">
function getApposByDate(vno){
	
	var date = $('#datetimepicker4').datetimepicker('viewDate').format('YYYY-MM-DD');
	appointmrntNo = "0";
	var count=0;

	$.ajax({
        type: 'GET',
        url: "getApposByDate", 
        data: {"selectedDate":date},
        success: function(data){
        	
            var slctSubcat=$('#appoDiv'), option="";
            slctSubcat.empty();
            
        	for(var i=0; i<data.length; i++){
        		count = count + 1;
        		
        		if(vno==data[i].vehicle_id.vehicleID){
        			 status="3";
        			 appointmrntNo=data[i].appointmentID;

        			 
        			 selected_option = "<div class='row'style='background-color: green; background: rgba(0, 128, 0, 0.3)'>"+
 					
 					"<div class='col-sm-12'>"+
 						"<div class='row'>"+
 							"<div class='col-sm-12'>"+
 								"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicle_id.vehicleID+"</div>"+
 							"</div>"+
 						"</div>"+
 						"<div class='row'>"+
 							"<div class='col-sm-12'>"+
 								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentDate+" "+data[i].appointmentTime+"</div>"+
 							"</div>"+
 						"</div>"+

 					"</div>"+
 					
 					
 					"<hr/></div>";
        			 
        		}else{
        			
        			selected_option = "<div class='row'>"+
					
					"<div class='col-sm-12'>"+
						"<div class='row'>"+
							"<div class='col-sm-12'>"+
								"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicle_id.vehicleID+"</div>"+
							"</div>"+
						"</div>"+
						"<div class='row'>"+
							"<div class='col-sm-12'>"+
								"<div style='color: #3e34fa; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentDate+" "+data[i].appointmentTime+"</div>"+
							"</div>"+
						"</div>"+
					"</div>"+
					
					
					"</div><hr/>";
        			
        		}  
            
            	 slctSubcat.append(selected_option);	
        	}
        	
         	document.getElementById('noOfAppos').innerHTML = count;

        },
        error:function(){
         //   alert("error");
        }

    });
}
</script>

<script type="text/javascript">
	var default_date=  new Date();
    $(function () {
        $('#datetimepicker4').datetimepicker({
            format: 'L',
            //minDate: moment(1, 'h')
            useCurrent:false,
            defaultDate: default_date
        });
        
        $('#datetimepicker4').on("change.datetimepicker", function (e) {
        	getApposByDate("");
          });
        
      });
 </script>
     
<script type="text/javascript">

function lateNotify() {
	$.ajax({
        type: 'GET',
        url: "getLateAppos",
        success: function(data){

        	 for(var i=0; i<data.length; i++){
        		 var v=""+data[i].appointmentID;
        		// alert(v);
        			$.notify({
        				// options
        				icon: 'flaticon-alarm-1',
        				title: 'Appointment Alert !',
        				message: data[i].vehicle_id.vehicleID + ' Vehicle has not appeared at the gate !'+ 
        						'<br> Scheduled Time : '+data[i].appointmentTime+'<br><br>'+
        						'<button class="btn btn-danger btn-sm" onclick="cancel('+v+')"><b>Cancel</b></button> '+
        						'<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal"><b>Reschedule</b></button> '+
        						'<button class="btn btn-light btn-sm"><b>Wait !</b></button>'
        			},{
        				// settings
        				element: 'body',
        				type: "info",
        				allow_dismiss: true,
        				newest_on_top: false,
        				showProgressbar: false,
        				delay: 30000,
        				timer: 1000
        			});
        	 }
        },
        error:function(){
            //alert("error");
        }

    });
	
}
setInterval(lateNotify, 60000);

function cancel(str) {
	alert(str);
}

</script>

<%@include file="../WEB-INF/jsp/commJs.jsp"%>
<script src="resources/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
  
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js"></script>


<!-- Modal -->
<div class="modal fade bd-example-modal-sm" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Vehicle No :</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group row">
					<div class="col-lg">
						<select class="form-control form-control-sm" id="vClass" onchange="findBestLane()" required>									
							<option value="">Select vehicle class...</option>
							<c:forEach items="${vClass}" var="vClass">
								<option value="${vClass.vehicleClassID}">${vClass.vehicleClass}</option>
							</c:forEach>																																		
						</select>
					</div>
					<div class="col-lg">
						<select class="form-control form-control-sm" id="testCat" onchange="findBestLane()" required>									
							<option value="">Select testing category...</option>
							<c:forEach items="${testCategory}" var="cat">
								<option value="${cat.categoryId}">${cat.categoryType}</option>
							</c:forEach>																																		
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-lg-6">
						<select class="form-control form-control-sm" onchange="getFreeTimes()" id="laneID" required>									
							<option value=""> Select lane...</option>
							<c:forEach items="${lanes}" var="lane">
								<option value="${lane.testLaneHeadId}">${lane.laneName}</option>
							</c:forEach>																																	
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Reschedule</button>
			</div>

		</div>
	</div>
</div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</body>
</html>