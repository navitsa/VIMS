<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Test Parameters</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>
   
	<style>
	.error1{color:red;font-size: 12px }
		
		.header-right {
		  float: right;
		}
	</style>

</head>

<body id="page-top">

  <!-- Page Wrapper -->
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
        
        <h3>Still Developing !</h3>

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

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>
  
    <!-- Page level plugins -->


  <!-- Page level custom scripts -->
<script type="text/javascript">
$(function() {
   /*  Submit form using Ajax */
   $('#submitBtn').click(function(e) {
   
      //Prevent default submission of form
      e.preventDefault();
      
      $.post({
         url : 'saveTestParameter',
         data : $('form[name=testParameterForm]').serialize(),
         success : function(res) {
        	 
         }
      });
      
      document.getElementById('parameterName').value = '';
      document.getElementById('parameterCode').value = '';
      
   });

});
</script>

<script type="text/javascript">
	function getParametersByTestType()
	{
		var str = document.getElementById("typeId").value;
		
		if (str=="") {
           	$("table tbody").empty();
    		return;
  		}
		else{
			$.ajax({
		        type:'GET',
		        url: "get_para_by_test_type_id",
		        data: {"typeID":str},
		        success: function(data){
		        
		        	$("table tbody").empty();
					for(var i=0; i<data.length; i++){
					
						var markup = "<tr><td>"+data[i].id+"</td><td>"+data[i].testType.type+"</td><td>"+data[i].parameterName+"</td><td>"+data[i].parameterCode+"</td><td><a href='editParameter?id="+data[i].id+"'><i class='material-icons'>&#xE254;</i></a></td></tr>";
		           		$("table tbody").append(markup);
		           	 }
		        },
		        error:function(){
		            //alert("");
		        }
	
		    });
		}
	}

</script>


</body>

</html>