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
       
       
  
       
     #calendar {
    max-width: 100%;
    margin: 0 auto;
  }
       
       
       
</style>
   <link href='resources/assets/calender_lib/main.css' rel='stylesheet' />
<script src='resources/assets/calender_lib/main.js'></script> 	
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
							<div class="col-xl-4 col-lg-4">
								 <h2 class="text-white pb-2 fw-bold">Calibration Calendar</h2>
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
				
				<div class="card shadow page-inner mt--2">	
					<div class="container-fluid">
		
			
  				<div id='calendar'></div>
	
					</div>	
				</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    
    var centerid='<%=session.getAttribute("centerid")%>';
    $.ajax({
        type: 'GET',
        url: "getequmentCalendar",
        data: {"centerID" : centerid},
        success: function(data){  
    
	
//     		for(var i=0; i<data.length; i++){
    	    	  
//     	        {
//     	          title: 'All Day Event',
//     	          start: '2020-09-02'
//     	        }
    	        
    	       var todayDate = new Date().toISOString().slice(0,10);  
						
					var date2 = new Date(todayDate); 
    	        
    	        
//     	    		}
                   var events = [];
               	for(var i=0; i<data.length; i++){  
                    events.push({
                    	color: '#32cffa',   // a non-ajax option
                    	textColor: '#ffffff', // a non-ajax option
                        title:'('+data[i].eqModelID.eqTypeID.eqType+') '+data[i].serialNo,
                        start: data[i].lastCalibrationDate // will be parsed
                    });   		
               		
           		var date1 = new Date(data[i].nextCalibrationDate);	
     
           		

           		
           		
			      //  var nx=(date1 - date2);
               		
               		if((date1 - date2)<0){
                    events.push({
                    	color: '#ed0505',   // a non-ajax option
                    	textColor: '#ffffff', // a non-ajax option
                        title:'('+data[i].eqModelID.eqTypeID.eqType+') '+data[i].serialNo,
                        start: data[i].nextCalibrationDate // will be parsed
                    });
              
               	}else{
                    events.push({
                    	color: '#66edb0',   // a non-ajax option
                    	textColor: '#0004fa', // a non-ajax option
                        title:'('+data[i].eqModelID.eqTypeID.eqType+') '+data[i].serialNo,
                        start: data[i].nextCalibrationDate // will be parsed
                    });
               		
               		
               	}
               	}
    
    

    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialDate: todayDate,
      editable: false,
      selectable: true,
      businessHours: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: events
    });

    
    
    
    calendar.render();
    
    
  },
  error:function(){
    //  alert("error");
  }

});
    
  });

</script>

</body>
</html>