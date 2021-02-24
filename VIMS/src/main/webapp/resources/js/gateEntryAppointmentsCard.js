function getApposByDate(vno){
	
	var date="";
	appointmrntNo = "0";
	var count=0;

	$.ajax({
        type: 'GET',
        url: "viewAppointmentsAtGate", 
        data: {"selectedDate":date},
        success: function(data){
        	
            var slctSubcat=$('#appoDiv'), option="";
            slctSubcat.empty();
            
        	for(var i=0; i<data.length; i++){
        		count = count + 1;
        		if(data[i].pushStatus==true || data[i].pushStatus==false){
        			selected_option = "<div class='row'>"+
    				
    				"<div class='col-sm-12'>"+
    					"<div class='row'>"+
    						"<div class='col-sm-12'>"+
    							"<div style='font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicleNo+" "+data[i].cusName+"</div>"+
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
        		else{
        			selected_option = "<div class='row'>"+
    				
    				"<div class='col-sm-12'>"+
    					"<div class='row'>"+
    						"<div class='col-sm-12'>"+
    							"<div style='font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicleNo+" "+data[i].cusName+"</div>"+
    						"</div>"+
    					"</div>"+
    					"<div class='row'>"+
    						"<div class='col-sm-12'>"+
    							"<div style='color: #3e34fa; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentDate+" "+data[i].appointmentTime+" <span class='badge badge-primary'>ONLINE</span></div>"+
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
        }

    });
}

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

function lateNotify() {
	
	$.ajax({
        type: 'GET',
        url: "getLateAppos",
        success: function(data){

        	 for(var i=0; i<data.length; i++){
        			$.notify({
        				// options
        				icon: 'flaticon-alarm-1',
        				title: 'Appointment Alert !',
        				message: data[i].vehicleNo + ' Vehicle has not appeared at the gate !'+ 
        						'<br> Scheduled Time : '+data[i].appointmentTime+'<br><br>'+
        						'<button class="btn btn-danger btn-sm" onclick="cancel(`'+data[i].appointmentID+'`)"><b>Cancel</b></button> '+
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
setInterval(getApposByDate, 30000);

function cancel(str) {
	
	$.ajax({
        type: 'GET',
        url: "cancelling",
        data: {"appoID":str},
        success: function(data){
        	alert("Successfully Cancelled !");
        },
        error:function(){
            //alert("error");
        }

    });
}

function reschedule(str) {
	$.ajax({
        type: 'GET',
        url: "rescheduling",
        data: {"appoID":str,"date":reshDate,"time":reshTime},
        success: function(data){
        },
        error:function(){
            //alert("error");
        }

    });
}
