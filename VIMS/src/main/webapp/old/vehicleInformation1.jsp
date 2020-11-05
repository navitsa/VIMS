<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.navitsa.controller.VehicleController"%>
<%@ page errorPage="../WEB-INF/jspf/error.jsp" %> 
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Vehicle Information</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

	<style>
		.error1{color:red;font-size: 12px } 
		
 		form input[type="file"] { 
          display: none; 
         }
         .numberfield{width:70px;}
         .labelcol{color:black;}
         .imgalign{
           display: block;
  			margin-top: -20px;
 			 margin-right: auto;
 			 width: 80%;
          
         }
         .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 14px;
          
         }
         .fontcol{
         color: blue;
         }
         .fontcol-peo{
         color: #ff8000;
         }
         .bgred{
         color: #b30000;
         }
         
         .capCam{
  			position: absolute;
  			top: 10px;
  			right: 12px;
  			height: 180px;
  			width: 300px;	
		}
       .iconstyle{		
  			width: 10%;
  			color:blue';
       }
       .camara{
       position: relative;
       left: -23px;
       		width: 190px;
			height: 160px;
       }       
         
	</style>
	
	
	
	<style>
.lds-roller {
  display: none;
  position: relative;
  width: 80px;
  height: 80px;
  top: 37px;
  left: 20px
  
  
}
.lds-roller div {
  animation: lds-roller 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
  transform-origin: 40px 40px;
}
.lds-roller div:after {
  content: " ";
  display: block;
  position: absolute;
  width: 7px;
  height: 7px;
  border-radius: 50%;
  background: #fff;
  margin: -4px 0 0 -4px;
}
.lds-roller div:nth-child(1) {
  animation-delay: -0.036s;
}
.lds-roller div:nth-child(1):after {
  top: 63px;
  left: 63px;
}
.lds-roller div:nth-child(2) {
  animation-delay: -0.072s;
}
.lds-roller div:nth-child(2):after {
  top: 68px;
  left: 56px;
}
.lds-roller div:nth-child(3) {
  animation-delay: -0.108s;
}
.lds-roller div:nth-child(3):after {
  top: 71px;
  left: 48px;
}
.lds-roller div:nth-child(4) {
  animation-delay: -0.144s;
}
.lds-roller div:nth-child(4):after {
  top: 72px;
  left: 40px;
}
.lds-roller div:nth-child(5) {
  animation-delay: -0.18s;
}
.lds-roller div:nth-child(5):after {
  top: 71px;
  left: 32px;
}
.lds-roller div:nth-child(6) {
  animation-delay: -0.216s;
}
.lds-roller div:nth-child(6):after {
  top: 68px;
  left: 24px;
}
.lds-roller div:nth-child(7) {
  animation-delay: -0.252s;
}
.lds-roller div:nth-child(7):after {
  top: 63px;
  left: 17px;
}
.lds-roller div:nth-child(8) {
  animation-delay: -0.288s;
}
.lds-roller div:nth-child(8):after {
  top: 56px;
  left: 12px;
}
@keyframes lds-roller {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>
	
	
	
	
</head>

<body id="page-top" onload="hideContinue()">






  <!-- wrapper -->
  <div id="wrapper">
  
		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>
		
        <!-- Begin Page Content -->
        <div class="container-fluid">
   <div class="row">     
      		<div style='height: 70px;'>
 		</div>   
   </div>     
<div class="row">
   <div class="col-sm-1">
 	
 	</div>
 	<div class="col-sm-11">	             
   	<!-- Content Row -->
	<div class="row">
						
	
			<!-- Pie Chart -->
		<div class="col-xl-7">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-1 d-flex flex-row align-items-center justify-content-between">
					<i class="fa fa-camera" style='font-size:36px;color:blue'></i><h6 class="m-0 font-weight-bold text-primary">Capture License Plate</h6>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					  <div class="row">
			             	<div class="col-sm-5">
			             		<div class="camara" style="height: 300px;"><a href="#" onClick="take_snapshot()" id="cam-click" ><div class="camara" id="my_camera"></div></a></div>
			             		
			             	</div>
			             	<div class="col-sm-2">
			             	</div>
			             	<div class="col-sm-5 justify-content-end">
			             		<c:if test = "${vehImg == null}">
			             			<img src="resources/img/car-placeholder.jpg" class="capCam"  id="results"/>
			             			<input type="hidden" name="ImageData" id="ImageData"  />
			             		</c:if>
			             		<div class="lds-roller" id="loader"><div></div><div></div><div></div></div>

			            	</div>
			             </div>	
			             <div class="row">
			             	<div class="col-sm-6">
			             		<p style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; color: red;">Click on the camera to capture plate</p>
			             		<input type="hidden" class="form-control fontst" id="ocrid"/>
			             	</div>
			             	<div class="col-sm-6">
			             		<p style="font-size: 12px; font-family: Arial, Helvetica, sans-serif; color: red; display:none;" id="lice-msg">License plate not found!! Please Enter </p>
			             		
			             	</div>
			             </div>	
			             <div class="row">	
			             	<div class="col-sm-7">		
			             	
			             			
		                				<a href="#" class="" onClick="getNewNumber();">More..</a>
		                								                		
								<table id="ocrdetails" class="table-sm table-wrapper-scroll-y my-custom-scrollbar" style="height: 112px; cursor: pointer;">                	
							
							
							
								</table>
								
								
																	
			             	</div>
			             	<div class="col-sm-5">	
			             		<div class="form-group row">
			             			<div class="col-sm-12 justify-content-end">							
		                				<input class="form-control fontst bgred" id="vehicleID" placeholder="Licence Plate NO..."    onfocusout="getVMasterData(this.value)" onkeyup="this.value = this.value.toUpperCase();getVMasterData(this.value);"   />
		                			</div>
		                		</div>
		                		<div class="row">
		                		

		                		
		                			<div class="col-sm-12 justify-content-end">	
		                				<a href="#" class="btn btn-success btn-block" onClick="goToVehicleRegFrmOrNew()">Continue</a>
		                			</div>
				            	</div>									
			             	</div>
			             </div>
				</div>
			</div>
		</div>
	
		<div class="col-xl-4" hidden="true" id="vdetails">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-1 d-flex flex-row align-items-center justify-content-between">
					<i class="fa fa-car" style='font-size:36px;color:blue'></i><h6 class="m-0 font-weight-bold text-primary">Vehicle</h6>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					 <div class="row">
						<div class="col-sm-4">
							<label class="fontst">Class</label>
						</div>
						<div class="col-sm-6">	
						<label class="fontst fontcol" id="veclass"></label>	             	
<!-- 							<input class="fontst "  value="" readonly="true" id="veclass"/>			             											             		 -->
						</div>						
						<div class="col-sm-2"><br>
							<img src="" id="classImg" class="img-responsive imgalign">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<label class="fontst">Make/Model</label>
						</div>
						<div class="col-sm-8">	
							<label class="fontst fontcol" id="vMnM"></label>	   	             	
										             											             		
						</div>						
					</div>
				
					<div class="row">
						<div class="col-sm-4">
		            	<label for="engineNo" class="fontst">Engine No</label>
						</div>
						<div class="col-sm-6">
				            	<label class="fontst fontcol-peo" id="engNo"></label>  	             	
										             											             		
						</div>						
						<div class="col-sm-2"><br>
							
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
		            	<label for="engineNo" class="fontst">Chassis No</label>
						</div>
						<div class="col-sm-6">
				            	<label class="fontst fontcol-peo" id="chaNor"></label>  	             	
										             											             		
						</div>						
						<div class="col-sm-2"><br>
							
						</div>
					</div>			
				
					<div class="row">
						<div class="col-sm-4">
		            	<i class='fas fa-gas-pump'></i>
						</div>
						<div class="col-sm-6">
				            	<label class="fontst fontcol" id="fuelTyp"></label>  	             	
										             											             		
						</div>						
						<div class="col-sm-2"><br>
							
						</div>
					</div>	
									
			</div>
				<div class="card-header py-0 d-flex justify-content-between">
					<img src="resources/img/icon/vowner.png" class="iconstyle"/></i><h6 class="font-weight-bold text-primary">Current Owner</h6>
				</div>
			<div class="card-body">	
					<div class="row">
						<div class="col-sm-1">
						<i class="fas fa-user"></i>
 						</div>
 						<div class="col-sm-10">
		            	<label class="fontst fontcol" id="ownerName"></label>
						</div>
					</div>		
					<div class="row">
						<div class="col-sm-1"><i class="fa fa-phone" aria-hidden="true"></i> </div>
						<div class="col-sm-6">
		            	
		            	<label class="fontst fontcol" id="contactNo"></label>
						</div>
						
						<div class="col-sm-5">
						<a href="#" class="btn btn-info btn-sm" onClick="vehicleMaster()">Edit Vehicle</a>
						</div>
						
					</div>		
			
				
					
					
					
				</div>
			</div>
		</div>
	
	
		
	</div>
 
    </div>
   
  </div> 
   
   
   
   
   
   

        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
<%@include file="logoutModel.jsp"%>
  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>
  
    <!-- Page level plugins -->


  <!-- Page level custom scripts -->
  <script src="resources/js/file-input.js"></script>
  <script src="resources/ajax/vehicle-master.js"></script>
    
   <!-- First, include the Webcam.js JavaScript Library -->
	<script type="text/javascript" src="resources/js/webcam.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<!-- Configure a few settings and attach camera -->
	<script language="JavaScript">
	var id;
	
	
		Webcam.set({
			width: 704,
			height: 480,
// 		    crop_width: 240,
// 		    crop_height: 240,
		    image_format: 'jpeg',
		    jpeg_quality: 100,

		});
// 		Webcam.set(cv2.CAP_PROP_BRIGHTNESS,100)
		
		//Webcam.attach( '#my_camera' );
		 Webcam.attach( document.querySelector('#my_camera') );
		
		
		 document.getElementById("my_camera").style.filter = "brightness(100%)";
		// document.getElementById("my_camera").style.filter = "contrast(50%)";
		 
		 
	</script>
	
	<!-- Code to handle taking the snapshot and displaying it locally -->
	<script language="JavaScript">
	

   
	
	
	var status="0";
		
	function getNewNumber(){
		
		// take snapshot and get image data
		Webcam.snap( function(data_uri) {

			document.getElementById('results').src = data_uri;	
			document.getElementById('ImageData').value = data_uri;
			 var xy = document.getElementById("ImageData");
			 
			 
			 var str = document.getElementById("ocrid").value;
			 var y=0;
				 if(str!=""){
					 y=str;					 
				 }
				document.getElementById("lice-msg").style.display = "none";
					document.getElementById("my_camera").style.display = "none";
				document.getElementById("loader").style.display = "block";
				document.getElementById("cam-click").style.display = "none";

			
			var jsonfile={json:JSON.stringify(data_uri),id:y};
			$.ajax({

			    type: 'POST',
			    url: "getNumberMethod2", 
			    data: jsonfile,
		        success: function(data){
		        	
		        	document.getElementById('ocrid').value=data[0].id;
		        	
		            var slctSubcat=$('#ocrdetails'), option="";
		            slctSubcat.empty();
		            selected_option = "  <tr><td></td></tr>"
		            slctSubcat.append(selected_option);

		          if(data[0].number==""){
		        	  
		        	  document.getElementById("lice-msg").style.display = "block";
		        	  
		          }else if( data.length==1){
		        	  
			              document.getElementById('vehicleID').value = data[0].number;
	  					  getVMasterData(data[0].number)
	  					//  selected_option = " <a href='#' onclick='getColumnValue(this);'>"+data[0].number+"</a>";
	  					  
	  					  
	  					 
						  selected_option = "  <tr><td>"+data[0].number+"</td></tr>"
				          slctSubcat.append(selected_option);
		        	  
		          }else{
						for(var i = 0; i < data.length; i++){
							
							  selected_option = "  <tr><td>"+data[i].number+"</td></tr>"
						            slctSubcat.append(selected_option);
							
						}  
		        	  
		          }
		              
		             //  document.getElementById('vehicleID').value = data[0].number;
  					//   getVMasterData(data[0].number)
		            
 					document.getElementById("my_camera").style.display = "block";
					document.getElementById("loader").style.display = "none";
					document.getElementById("cam-click").style.display = "block";
		            slctSubcat.append(option);	  	
		      	
		        },
		        error:function(){
		        	alert("Error");
		        }
			 });
		

		} );

	}
	
	
	
	
	
	
	
		function take_snapshot() {
		
			// take snapshot and get image data
			Webcam.snap( function(data_uri) {

				document.getElementById('results').src = data_uri;	
				document.getElementById('ImageData').value = data_uri;
				 var xy = document.getElementById("ImageData");
				 
				 
				 var str = document.getElementById("ocrid").value;
				 var y=0;
 				 if(str!=""){
 					 y=str;					 
 				 }
 				document.getElementById("lice-msg").style.display = "none";
 					document.getElementById("my_camera").style.display = "none";
					document.getElementById("loader").style.display = "block";
					document.getElementById("cam-click").style.display = "none";

				
				var jsonfile={json:JSON.stringify(data_uri),id:y};
				$.ajax({

				    type: 'POST',
				    url: "saveLicensePlate", 
				    data: jsonfile,
			        success: function(data){
			        	
			        	document.getElementById('ocrid').value=data[0].id;
			        	
			            var slctSubcat=$('#ocrdetails'), option="";
			            slctSubcat.empty();
			            selected_option = "  <tr><td></td></tr>"
			            slctSubcat.append(selected_option);

			          if(data[0].number==""){
			        	  
			        	  document.getElementById("lice-msg").style.display = "block";
			        	  
			          }
			              
			               document.getElementById('vehicleID').value = data[0].number;
      					   getVMasterData(data[0].number)
			            
	 					document.getElementById("my_camera").style.display = "block";
						document.getElementById("loader").style.display = "none";
						document.getElementById("cam-click").style.display = "block";
			            slctSubcat.append(option);	  	
			      	
			        },
			        error:function(){
			        	alert("Error");
			        }
				 });
			

			} );
	
		}

		
	</script>
	
	
	
	<script type="text/javascript">
	
// 	$(document).on('click', '.box', function() {
// 		var folder = $(this).attr('data-folder');
//       	document.getElementById('vehicleID').value = folder;
//       	getVMasterData(folder)
		  
// 		});

// function getColumnValue(e){
//       //i know here is the object type but would not sure on how to change it
//       var colValue= this.dataItem($(e.currentTarget).closest("tr"));
//       //for verification purposes
//       alert(colValue);
// }


	
// 	var table = $('#ocrdetails').DataTable();
 
// $('#ocrdetails tbody').on( 'click', 'tr', function () {
//   var rowData = table.row( this ).data();
//   console.log(rowData);
//   // ... do something with `rowData`
// } );

var tbl = document.getElementById("ocrdetails");
if (tbl != null) {
    for (var i = 0; i < tbl.rows.length; i++) {
        for (var j = 0; j < tbl.rows[i].cells.length; j++)
            tbl.rows[i].cells[j].onclick = function () { getval(this); };
    }
}
function getval(cel) {
    alert(cel.innerHTML);
}



// 	 $('td').click(function(e) {
// 		    var txt = $(e.target).text();
// 		    console.log(txt);
// 		 });
	
	
	
	
	
// 	$(document).on('click', '#ocrdetails', function() {
// 		var folder = $(this).attr('#ocrdetails');
//       	document.getElementById('vehicleID').value = folder;
//       	getVMasterData(folder)
		  
// 		});
	
// 	$('#ocrdetails tr').click(function() {
// 		alert("hello"); // check if function is called
// 		var href = $(this).find("a").attr("href");
// 		if(href) {
// 			document.getElementById('vehicleID').value  = href;
// 		}
// 		});

	</script>
	
	
	

	
	<script >
	function getClassImage(str)
	{ 
		//var str = document.getElementById("vClass").value;
		
		//alert(str);
		if (str=="") {
	    	var slctSubcat=$('#cate'), option="";
	        slctSubcat.empty();
	   
		return;
		}
		else{			
			$.ajax({
	        type: 'GET',
	        url: "getVClassImage",
	        data: {"classid" : str},
	        success: function(data){
				 var x = document.getElementById("classImg");
				 
				 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
// 				 x.setAttribute("width", "60");
// 				 x.setAttribute("height", "30");
	       	
	      	
	        },
	        error:function(){

	        }

	    });
			

			
			
			
	}
	}
	

	function getMakeLogo(str)
	{
		if (str=="")
		{   
			return;
		}
		
		else
		{
				$.ajax({
			    type: 'GET',
			    url: "getImageForCombo",
			    data: {"vmake" : str},
			    success: function(data){
			        	
					 var x = document.getElementById("makeImg");
					 
					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
					 x.setAttribute("width", "60");
					 x.setAttribute("height", "30");
					 
					 //document.getElementById("makeImg").appendChild(x);
			    },
			    error:function(){
			        //alert("No Return Make Logo");
			    }
			
			});
		}
	}
	
	function getModelImage(str)
	{
		if (str=="")
		{   
			return;
		}
		
		else
		{
				$.ajax({
			    type: 'GET',
			    url: "getModelImage",
			    data: {"vehicleModelID" : str},
			    success: function(data){
			        	
					 var x = document.getElementById("modelImg");
					 
					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
					 x.setAttribute("width", "60");
					 x.setAttribute("height", "30");
					 
					 //document.getElementById("makeImg").appendChild(x);
			    },
			    error:function(){
			       // alert("No Return Model Image");
			    }
			
			});
		}
	}
	
		function getVMasterData(x) {
		//   var x = document.getElementById("vehicleID");
		 //  document.getElementById("skipbtn").style.visibility = "hidden";
		   
			if (x=="") {
	    		var slctSubcat=$('#vehicleID'), option="";
	            slctSubcat.empty();
	           
	    	return;
			}else{
				
		   $.ajax({
		        type: 'GET',
		        url: "getFindVmaster",
		        data: {"vehicleID" :x},
		        success: function(data){
		        	
		        if(data!=null){
		        	$('#veclass').text(data.vmodel.vehicleClass.vehicleClass);
		        	$('#vMnM').text( data.vmodel.vehicleMakeID.vehicleMake+' / '+data.vmodel.vehicleModel);
		        	//$('#vModel').text(data.vmodel.vehicleModel);

		        	
		        	$('#engNo').text(data.engineNo);
		        	$('#chaNor').text( data.chassisNo);
		        	$('#fuelTyp').text(data.ftype.fuel);
    	
					 getClassImage(data.vmodel.vehicleClass.vehicleClassID);
					 document.getElementById('vdetails').hidden = false;
					 
					 status="1";
					 
 

		        }else{
		        	 document.getElementById('vdetails').hidden = true;
		        	//alert("sssssssssss");
		        	 status="0";
		        }
		        	 
		        },
		        error:function(){
		        	 document.getElementById('vdetails').hidden = true;
		        	 status="0";
		        	//alert("error");
		        }
		
		    });
		   
		   
			$.ajax({
		        type: 'GET',
		        url: "getVehicleOwnerIDByVehicleID",
		        data: {"vehicleID" : x},
		        success: function(data){
		        	$('#ownerName').text(data.ownerName);
		        	$('#contactNo').text(data.contactNo);

		        },
		        error:function(){
		          //  alert("error");
		        }

		    });
		   
		   
// 			$.ajax({
// 		        type: 'GET',
// 		        url: "getTestStatusVehicleRegistation",
// 		        data: {"vehicleID" : x},
// 		        success: function(data){
		        	
// 		        	if(data!=""){
// 		        	alert("This Vehicle Allredy Test Pending");
// 		        	}

// 		        },
// 		        error:function(){
// 		          //  alert("error");
// 		        }

// 		    }); 
		   
		   
		}
		   
		}
	
		
		function vehicleMaster() {
			
			 var str = document.getElementById("ocrid").value;
			 var y=0;
				 if(str!=""){
					 y=str;					 
				 }
			
			 var vid = document.getElementById("vehicleID").value;
		window.location.href = "vehicleMaster?vehicleID="+vid+"&id="+y;
		
		
		}
		
		function goToVehicleRegFrmOrNew()
		{	var vid = document.getElementById("vehicleID").value;
		
		
		
		 var str = document.getElementById("ocrid").value;
		 var y=0;
			 if(str!=""){
				 y=str;					 
			 }
		
		
		
		
		
		
			if(status=="1"){
				
				
			window.location.href = "skipowner?vehicleID="+vid+"&id="+y;
			}else{
				
				window.location.href ="newVehicleMaster?vehicleID="+vid+"&id="+y;	
				
			}
		}
		
	
		
	</script>
	
	<script>
		function callingBatFile()
		{
			window.location.href = "callingBatFile";
		}
	</script>
	<script>
		function hideContinue() {
			 id="0";
			
		}
	</script>
	<script>
	$(document).ready(function(){
		  $("#manufactureYear").keypress(function(e){
		    var keyCode = e.which;
		    /*
		    8 - (backspace)
		    32 - (space)
		    48-57 - (0-9)Numbers
		    */
		    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
		      return false;
		    }
		  });
		  $("#registeredYear").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
			    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			  });
		  $("#engineCapacity").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
			    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			  });
	});
	</script>
	

	
</body>

</html>