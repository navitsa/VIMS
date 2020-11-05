//view eq model
function getEqModelLogo(str) {
			if (str == "") {
				//document.getElementById("txtHint").innerHTML="";
				//var slctSubcat=$('#visualProfileStageID'), option="";
				//slctSubcat.empty();

				return;
			} else {
				$.ajax({
					type : 'GET',
					url : "getImageModelcombo",
					data : {"eqModleid" : str},
					success : function(data) {
						//delete previous selected value
						var img = $('#mydemo'), value = "";
						img.empty();

						//var x = document.createElement("IMG");
						var x = document.getElementById("mydemo");
						x.setAttribute("src", "data:image/jpg;base64," + data
								+ "");
						//		  x.setAttribute("width", "120");
						//		  x.setAttribute("height", "120");

						// document.body.appendChild(x);
						//document.getElementById("mydemo").appendChild(x);

					},
					error : function() {
						//alert("Image Not Found");
					}

				});
			}
		}
//clear form after/before submiting 
function clear1() {
	/*Put all the data posting code here*/
	document.getElementById("eqTypeID").value = "";
	document.getElementById("eqModelID").value = "";
	document.getElementById("mydemo").value = "";
	document.getElementById("serialNo").value = "";
	document.getElementById("preview").value = "";
	document.getElementById("remarks").value = "";
	document.getElementById("eqMakeID").value = "";
	document.getElementById("mydemo").value = "";
}
//get Model related make and class
function getModel(str) {
	var eqTypeID = document.getElementById("eqTypeID").value;
		if (str == "") {

			//document.getElementById("txtHint").innerHTML="";
			var slctSubcat = $('#eqModelID'), option = "";
			slctSubcat.empty();
			return;
		} else {
			$.ajax({
						type : 'GET',
						url : "getModelcombo",
						data : {"eqTypeID" : eqTypeID, "eqMakeid" : str},
						success : function(data) {

							var slctSubcat = $('#eqModelID'), option = "";
							slctSubcat.empty();
							selected_option = "<option value='' selected>--SELECT--</option>"
							slctSubcat.append(selected_option);

							for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i].eqModelID + "'>"
										+ data[i].eqModel + "</option>";
							}
							slctSubcat.append(option);

							/* //var x = document.createElement("IMG");
							var x = document.getElementById("makeDemo");
							x.setAttribute("src", "data:image/jpg;base64,"
									+ data + "");
							//		  x.setAttribute("width", "120");
							//		  x.setAttribute("height", "120");

							// document.body.appendChild(x);
							document.getElementById("makeDemo")
									.appendChild(x); */
						},
						error : function() {
							alert("error");
						}

					});
		}
	}

//edit eq master form
function getEqMasterData() {
	var a = document.getElementById("equipmentID");
	//alert();
	$.ajax({
		type: 'GET',
		url: 'editEqMaster',
		data: {"equipmentID" : a.value},
		success: function(data) {
			if (confirm("This Equipment already saved...!\nDo you want to edit this Equipment Information ?\nPlease Click OK...!")) {
				  txt = "You pressed OK!";
				  //location.reload(true);
				  window.location.href = "editEqMaster?equipmentID="+ a.value;
				} else {
				  txt = "You pressed Cancel!";
				}
		},
		error:function() {
			//alert("error");
		}
	});
}
//get make Img
function getMakeLogo(str) {
	if(str == "") {
		return;
	} else {
		$.ajax({
	    type: 'GET',
	    url: "getMakeLogo",
	    data: {"eqMakeID" : str},
	    success: function(data){
	        	
	    	 var x = document.getElementById("makeImg");
			 
			 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
			// x.setAttribute("width", "200");
			// x.setAttribute("height", "300");
			 
			 //document.getElementById("makeImg").appendChild(x);
	    },
	    error:function(){
	       // alert("No Return Make Logo");
	    }
	
	});
	}
}
//get class related class and make
function getClass() {
	const eqMake = document.getElementById("eqMakeID").value;
	const str = document.getElementById("eqTypeID").value;
	if (str == "") {
		//document.getElementById("txtHint").innerHTML="";
		var slctSubcat = $('#eqModelID'), option = "";
		slctSubcat.empty();
		return;
		} else {
		$.ajax({
					type : 'GET',
					url : "getModelcombo",
					data : {"eqMakeid" : eqMake, "eqTypeID" : str},
					success : function(data) {

						var slctSubcat = $('#eqModelID'), option = "";
						slctSubcat.empty();
						selected_option = "<option value='' selected>--SELECT--</option>"
						slctSubcat.append(selected_option);

						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].eqModelID + "'>"
									+ data[i].eqModel + "</option>";
						}
						slctSubcat.append(option);

					},
					error : function() {
						alert("error");
					}

				});
	}
}
//set next cal date
function setDate() {
	var str = document.getElementById("eqModelID").value;
	var d1 = document.getElementById("lastCalDate").value;
	//alert(str);
	if(str == "") {
		//$("#nextCalDate").empty();
		$("#nextCalDate").val("");
		return;
	} 
	else {
		$.ajax({
			type : 'GET',
			url : "setCalDate",
			data : {"id" : str,"date":d1,"typ":"cal"},
			success : function(data) {				    
			var someFormattedDate = data;
			document.getElementById('nextCalDate').value = someFormattedDate;
			},
			error : function() {
				alert("error");
			}

		});
	}
}
//set next service date
function setSerDate() {
	var str = document.getElementById("eqModelID").value;
	var d1 = document.getElementById("lastServiceDate").value;

	if(str == "") {
		$("#nextServiceDate").empty();
		return;
	} 
	else {
		$.ajax({
				type : 'GET',
				url : "setCalDate",
				data : {"id" : str,"date":d1,"typ":"ser"},
				success : function(data) {				
			    var someFormattedDate = data;
			    document.getElementById('nextServiceDate').value = someFormattedDate;
					
			},
			error : function() {
				alert("error");
			}

		});
	}
}





