/**
 * 
 */
function getRemarks(str,str2)
	{
	
		if (str=="") {return;}
  		else{
		$.ajax({
        type: 'GET',
        url: " getRemarks",
        data: {"statusID" : str},
        success: function(data){

        	$('#formCheck'+str2).empty();
            for(var i=0; i<data.length; i++){
                //alert(data[i].remarks);
                var checkBox = "<input type='checkbox' class='form-check-input' id='exampleCheck1"+str2+"+"+i+"' " +
                		"name='checklistDetail["+str2+"].remark.remarksID' value='"+data[i].remarksID+"'>";
                var label = "<label class='form-check-label' for='exampleCheck1"+str2+"+"+i+"'>"+data[i].remarks+"</label><br>"
                $('#formCheck'+str2).append(checkBox);
                $('#formCheck'+str2).append(label);
            }
            
        },
        error:function(){
            alert("error");
        }

    });
    }
}