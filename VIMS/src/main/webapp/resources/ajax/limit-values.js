/**
 * 
 */
function getTestPoints(str)
	{
		if (str=="") {
    		var dropDown = $('#testPointSelect'), option="";
    		dropDown.empty();
    		return;
  		}
  		else{
			$.ajax({
	        type: 'GET',
	        url: "getTestPointsByTestTypeID",
	        data: {"typeID" : str},
	        success: function(data){

				var dropDown=$('#testPointSelect'), option="";
				dropDown.empty();
				selected_option = "<option></option>"
				dropDown.append(selected_option);
	
	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].testPointID + "'>"+data[i].testPointName + "</option>";
	            }
	            dropDown.append(option);
	            getTestParameters(str);
	        },
	        error:function(){
	            alert("error");
	        }
	
	    });
    }
}

function getTestParameters(str)
{

	if (str=="") {
		var dropDown = $('#testPara'), option="";
		dropDown.empty();
        //selected_option = "<option value='' selected>Select test parameter...</option>"
        //dropDown.append(selected_option);
	return;
		}
		else{
			$.ajax({
	        type: 'GET',
	        url: "get_para_by_test_type_id",
	        data: {"typeID" : str},
	        success: function(data){
	        
	            var dropDown=$('#testPara'), option="";
	            dropDown.empty();
				selected_option = "<option></option>"
				dropDown.append(selected_option);
	            
	            if(data.length<=0){
	            	document.getElementById("testPara").disabled=true;
	            	//document.getElementById("testAngle").disabled=true;
	            }
	            else{
	            	document.getElementById("testPara").disabled=false;
	            	//document.getElementById("testAngle").disabled=false;
	            }
	
	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].testParameterId + "'>"+data[i].paraName + "</option>";
	                
	            }
	            dropDown.append(option);
	        },
	        error:function(){
	            alert("error");
	        }
	
	    });
	}
}

function getTestAngles(str)
{

	if (str=="") {
		var dropDown = $('#testAngle'), option="";
		dropDown.empty();
        selected_option = "<option value='' selected>Select parameter position...</option>"
        dropDown.append(selected_option);
	return;
		}
		else{
			$.ajax({
	        type: 'GET',
	        url: "getTestAnglesByTestPara",
	        data: {"paraID" : str},
	        success: function(data){
	        
	            var dropDown=$('#testAngle'), option="";
	            dropDown.empty();
	            selected_option = "<option value='' selected>Select parameter position...</option>"
	            dropDown.append(selected_option);
	            
	            if(data.length<=0){
	            	document.getElementById("testAngle").disabled=true;
	            	getTestCodes(str);
	            }
	            else{
	            	document.getElementById("testAngle").disabled=false;
	            }
	
	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].paraAngleID + "'>"+data[i].angleName + "</option>";
	                
	            }
	            dropDown.append(option);
	        },
	        error:function(){
	            alert("error");
	        }
	
	    });
	}
}

function getTestCodes(str)
{
	var typeID = document.getElementById("testType").value;
	var pointID = document.getElementById("testPoint").value;
	var code="";
	
	//alert(str+" "+typeID+" "+pointID);
	
	$.ajax({
        type: 'GET',
        url: "getTestCodes",
        data: {"typeID":typeID, "pointID":pointID,"paraID":str},
        success: function(data){
            
            for(var i=0; i<data.length; i++){
                
            	//alert(data[i].code);
            	document.getElementById("paraCode").value = data[i].code;
            	code = code + data[i].code;
            }
            
            document.getElementById("code").innerHTML = code;
        },
        error:function(){
            alert("error");
        }

    });
}

function getTestCodes2(str)
{
	var typeID = document.getElementById("testType").value;
	var pointID = document.getElementById("testPoint").value;
	var paraID = document.getElementById("testPara").value;
	var code = "";
	
	//alert(str+" "+typeID+" "+pointID);
	
	$.ajax({
        type: 'GET',
        url: "getTestCodes2",
        data: {"typeID":typeID, "pointID":pointID,"paraID":paraID, "angleID":str},
        success: function(data){
            
            for(var i=0; i<data.length; i++){
                
            	//alert(data[i].code);
            	document.getElementById("paraCode").value = data[i].code;
            	code = code + data[i].code;
            }
            
            document.getElementById("code").innerHTML = code;
        },
        error:function(){
            alert("error");
        }

    });
}

function getTestCodes3(str)
{
	var typeID = document.getElementById("testType").value;
	var code = "";
	
	$.ajax({
        type: 'GET',
        url: "getTestCodes3",
        data: {"typeID":typeID, "pointID":str},
        success: function(data){
            
            for(var i=0; i<data.length; i++){
                
            	document.getElementById("paraCode").value = data[i].code;
            	code = code + data[i].code + " ";
            }
            
            document.getElementById("code").innerHTML = code;
        },
        error:function(){
            alert("error");
        }

    });
}

function getTestCodes4(str)
{
	if (str=="") {
		var dropDown = $('#paraCode'), option="";
		dropDown.empty();
        //selected_option = "<option value='' selected>Select code...</option>"
        //dropDown.append(selected_option);
        
        return;
	}else{
		
		$.ajax({
			type: 'GET',
			url: "getTestCodes4",
			data: {"typeID" : str},
			success: function(data){
        
				var dropDown=$('#paraCode'), option="";
				dropDown.empty();
				selected_option = "<option></option>"
				dropDown.append(selected_option);

	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].ck_paraCodeId.code+"'>"+data[i].ck_paraCodeId.code+" - "+data[i].testPoint.testPointName+" "+data[i].ck_paraCodeId.testParameter.paraName+" "+data[i].testParameterAngle.angleName+"</option>";
	            }
	            dropDown.append(option);
			},
			error:function(){
				//alert("error");
			}

		});
	}
}
