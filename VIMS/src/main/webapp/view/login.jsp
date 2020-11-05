<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
  <title>Login</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>


</head>

<body class="">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row align-items-center justify-content-center">
              <div class="col-lg-6 d-none d-lg-block bg-gradient-light"><img alt="" src="resources/img/login_img.jpg" width="110%" height="90%"></div>
              <div class="col-lg-6 bg-gradient-light">
                <div class="p-5">
                  <div class="text-center">
                  
                  <video class="img-profile  rounded-circle" id="preview" height="150" width="150"></video>
                  
<!--                   	 <img class="img-profile  rounded-circle" -->
				 
<!-- 				 src="resources/img/user-default.jpg"  height="150" width="150" id="mydemo"/> -->
				 
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user" action="login" method="POST" modelAttribute="login">
                    <div class="form-group" >
                      <input type="text" class="form-control form-control-user" id="username"   
                      name="username" aria-describedby="emailHelp" placeholder="Enter Username..." required onchange="getUserImage(this.value)">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="exampleInputPassword" 
                      name="password" placeholder="Enter Password..." required>
                    </div>
                     <table align="center">
						<tr>
							<td style="font-style: italic; color: red;">${msg}</td>
						</tr>
					</table>
<!--                     <a href="index.html" class="btn btn-primary btn-user btn-block"> -->
<!--                       Login -->
<!--                     </a> -->
                    <button type="submit" class="btn btn-primary btn-user btn-block">Login</button>
                  </form>
                 
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>


<script type="text/javascript">


// 	function getUserImage(str)
// 	{
// 		if (str=="") {
//     		//document.getElementById("txtHint").innerHTML="";
//     		//var slctSubcat=$('#visualProfileStageID'), option="";
//             //slctSubcat.empty();
           
//     	return;
//   		}
//   		else{
// 		$.ajax({
//         type: 'GET',
//         url: "loginimage",
//         data: {"username" : str},
//         success: function(data){
//  				//delete previous selected value
//         		var img = $('#mydemo'), value="";
//             	img.empty();
  
// 			  var x = document.getElementById("mydemo");
// 			  x.setAttribute("src", "data:image/jpg;base64,"+data+"");

// 			  document.getElementById("mydemo").appendChild(x);
			  
			  
//         },
//         error:function(){
//            // alert("Image Not Found");
//         }

//     });
//     }
// }



 </script> 

<script type="text/javascript">

      let scanner = new Instascan.Scanner({ video: document.getElementById('preview') });

      scanner.addListener('scan', function (content) {

		var jsonfile={qrdata:content};
		$.ajax({

		    type: 'POST',
		    url: "QRLogin", 
		    data: jsonfile,
	        success: function(data){
	        //	alert(data);
	        	window.location.href = data;
 	
	        },
	        error:function(){
	        	alert("Not Valid ID Card");
	        }
		 });
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        

      });

      Instascan.Camera.getCameras().then(function (cameras) {

        if (cameras.length > 0) {

          scanner.start(cameras[0]);

        } else {

          console.error('No cameras found.');

        }

      }).catch(function (e) {

        console.error(e);

      });

    </script>






</body>

</html>
    