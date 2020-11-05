function getStages(str)
	{
		if (str=="") {
    		var slctSubcat=$('#visualProfileStageID'), option="";
            slctSubcat.empty();
            selected_option = "<option value='' selected>Select stage...</option>"
            slctSubcat.append(selected_option);
    	return;
  		}
  		else{
		$.ajax({
        type: 'GET',
        url: " getStagesForCombo",
        data: {"profileID" : str},
        success: function(data){
        
            var slctSubcat=$('#visualProfileStageID'), option="";
            slctSubcat.empty();
            selected_option = "<option value='' selected>Select stage...</option>"
            slctSubcat.append(selected_option);

            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].stageID + "'>"+data[i].stage + "</option>";
            }
            slctSubcat.append(option);
        },
        error:function(){
            alert("error");
        }

    });
    }
}
	
function getItem(str)
	{
		var profileID = document.getElementById("visualprofileID").value;
		if (str=="") {
    		//document.getElementById("txtHint").innerHTML="";
    		var slctSubcat=$('#visualProfileItemID'), option="";
            slctSubcat.empty();
    	return;
  		}
  		else{
		$.ajax({
        type: 'GET',
        url: "getItemsForCombo",
        data: {"profileID" : profileID,"stageID":str},
        success: function(data){
            var slctSubcat=$('#visualProfileItemID'), option="";
            slctSubcat.empty();
            selected_option = "<option value='' selected>Select item...</option>"
            slctSubcat.append(selected_option);

            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].itemId + "'>"+data[i].itemName + "</option>";
            }
            slctSubcat.append(option);
        },
        error:function(){
            alert("error");
        }

    });
    }
}
	
function getStatus(str)
	{
		var profileID = document.getElementById("visualprofileID").value;
		var stageID = document.getElementById("visualProfileStageID").value;
		if (str=="") {
    		//document.getElementById("txtHint").innerHTML="";
           	$("table tbody").empty();
    		
    	return;
  		}
  		else{
		$.ajax({
        type: 'GET',
        url: "getStatusForTable",
        data: {"profileID" : profileID , "stageID":stageID , "itemID":str},
        success: function(data){
        
        	$("table tbody").empty();
			for(var i=0; i<data.length; i++){
			
				var markup = "<tr><td>"+data[i].item.itemName+"</td><td>"+data[i].statusSerialNo+"</td><td>" + data[i].vprofileItemStatus + "</td><td></td><td><a href='editStatus?id="+data[i].profileItemStatusID+"'><i class='material-icons'>&#xE254;</i></a></td></tr>";
           		 $("table tbody").append(markup);
           	 }
        },
        error:function(){
            alert("error");
        }

    });
    }
}

function getStatusForDropDown(str)
{
	var profileID = document.getElementById("visualprofileID").value;
	var stageID = document.getElementById("visualProfileStageID").value;
	if (str=="") {
		
		var slctSubcat=$('#itemStatus'), option="";
        slctSubcat.empty();
        
        return;
        
		}
	else{
		$.ajax({
	    type: 'GET',
	    url: "getStatusForTable",
	    data: {"profileID" : profileID , "stageID":stageID , "itemID":str},
	    success: function(data){
	    
            var slctSubcat=$('#itemStatus'), option="";
            slctSubcat.empty();
            selected_option = "<option value='' selected>Select item...</option>"
            slctSubcat.append(selected_option);

            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].profileItemStatusID + "'>"+data[i].vprofileItemStatus + "</option>";
            }
            slctSubcat.append(option);
	    },
	    error:function(){
	        alert("error");
	    }
	
	});
}
}


//<c:if test = '"+data[i].itemImage+" != null'>
//<img src='data:image/jpg;base64,"+data[i]itemImageView+"'/>
//</c:if>

//<img src='data:image/jpg;base64," "<img src='data:image/jpg;base64,${data[i].itemImageView}'/>"+

function getItemForTable(str)
{
	var profileID = document.getElementById("profile").value;
	if (str=="") {
			$("table tbody").empty();
			return;
		}
	else{
		$.ajax({
	    type: 'GET',
	    url: "getItemsForCombo",
	    data: {"profileID" : profileID,"stageID":str},
	    success: function(data1){
	    	
        	$("table tbody").empty();
			for(var i=0; i<data1.length; i++){
			
				var markup = "<tr><td>"+data1[i].stage.vp.profileName+"</td><td>" + data1[i].stage.stage+ "</td><td>"+data1[i].serialNo+"</td><td>"+data1[i].itemName+"</td><td><img src='data:image/jpg;base64,"+data1[i].itemImageView+"' width='80' height='80'></td><td><a href='editStatus?id="+data1[i].itemId+"'><i class='material-icons'>&#xE254;</i></a></td></tr>";
           		 $("table tbody").append(markup);
           	 }
	    },
	    error:function(){
	        alert("error");
	    }
	
	});
}
}

function getRemarks(str)
{
	if (str=="") {
			$("table tbody").empty();
			return;
		}
	else{
		$.ajax({
	    type: 'GET',
	    url: "getRemaksforCombo",
	    data: {"statusID" : str},
	    success: function(data){
	    	
        	$("table tbody").empty();
			for(var i=0; i<data.length; i++){
			
				var markup = "<tr><td>"+data[i].is.item.itemName+"</td><td>" +data[i].is.vprofileItemStatus+ "</td><td>"+data[i].serialNo+"</td><td>"+data[i].remarks+"</td><td><a href='editRemark?id="+data[i].remarksID+"'><i class='material-icons'>&#xE254;</i></a></td></tr>";
           		 $("table tbody").append(markup);
           	 }
	    },
	    error:function(){
	        alert("error");
	    }
	
	});
}
}

//This method used in Profile Stage jsp
function getStagesForTable(str)
{
	if (str=="") {
		$("table tbody").empty();
	return;
		}
		else{
	$.ajax({
    type: 'GET',
    url: " getStagesForCombo",
    data: {"profileID" : str},
    success: function(data){
        
        $("table tbody").empty();
		for(var i=0; i<data.length; i++){
		
			var markup = "<tr><td>"+data[i].vp.profileName+"</td><td>" +data[i].stageNo+ "</td><td>"+data[i].stage+"</td><td><a href='editRemark?id="+data[i].stageID+"'><i class='material-icons'>&#xE254;</i></a></td></tr>";
       		 $("table tbody").append(markup);
       	 }
    },
    error:function(){
        alert("error");
    }

});
}
}
