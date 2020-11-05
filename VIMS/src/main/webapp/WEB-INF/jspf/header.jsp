<div class="row bg-white topbar mb-12 static-top shadowe" style="height:30px;">
	<div class="col-sm-1">
	</div>
	<div class="col-sm-6">
	<%=session.getAttribute("centerName")%>
	
	</div>
	<div class="col-sm-1">
	
	</div>

	<div class="col-sm-1">
		<img class="float-right" src="data:image/jpg;base64,<%=session.getAttribute("countryimg")%>" style="height:25px; width:35px; " />
	</div>
	<div class="col-sm-3">
			
	<%=session.getAttribute("country")%>
	</div>
</div>

<!-- <nav class="navbar navbar-expand navbar-light bg-white topbar mb-12 static-top shadow" style="height:30px;"> -->
<!-- 	<div class=" row"> -->
	
<!-- 	</div> -->
	
<!-- </nav> -->