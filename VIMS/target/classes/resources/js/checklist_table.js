/**
 * 
 */
  $( document ).ready(function() {
            //collapse and expand sections

            //$('.breakrow').click(function(){
			$('#tableMain').on('click', 'tr.breakrow',function(){
                $(this).nextUntil('tr.breakrow').slideToggle(200);
            });
			
	        /*$("button").click(function () {
	               var rowcount = $('table tr').length;
	               alert("No. Of Rows B ::" +rowcount);
				 
				 var stageId = [];
				 var itemID = [];
				 var statusID = [];
				 var status = [];
				 var remakID = [];
				 var remark = [];

	            });*/
        });
  
	  function showTableData() {
		  
	      document.getElementById('info').innerHTML = "";
	      var myTab = document.getElementById('tableMain');

	      var stageId = [];
	      var itemID = [];
	
	      // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
	      for (i = 1; i < myTab.rows.length; i++) {
	    	  
	          // GET THE CELLS COLLECTION OF THE CURRENT ROW.
	          var objCells = myTab.rows.item(i).cells;
	          for (j = 0; j < myTab.rows.length; i++)
	        	  {
	        	  alert("OK");
	        	  		stageID[j] = objCells.item(0);
	        	  		itemID[j] =  objCells.item(2)
	        	  		statusID[j] = document.getElementById("mySelect").value;
	        	  		document.getElementById("info").innerHTML = statusID[j];
	        	  		alert(statusID[j]);
	        	  }
	

	      }
	  }
	  
       function getRemarks(str)
		{
			if (str=="") {
				
	    		var slctSubcat=$('#cmbRemark'), option="";
	            slctSubcat.empty();
	            
           		selected_option = "<option value='' selected>--Select--</option>"
	            slctSubcat.append(selected_option);
           		
           		
	    	return;
	  		}
	  		else{
				$.ajax({
		        	type: 'GET',
		        	url: "getRemaksforCombo",
		        	data: {"statusID" : str},
		        	success: function(data){
		        
		            	var slctSubcat=$('#cmbRemark'), option="";
		            	slctSubcat.empty();
		            	
		           		selected_option = "<option value='' selected>--Select--</option>"
		            	slctSubcat.append(selected_option);
		
			            for(var i=0; i<data.length; i++){
			                option = option + "<option value='"+data[i].remarksID + "'>"+data[i].remarks + "</option>";
			            }
		            	slctSubcat.append(option);
		        	},
		        	
		       	 	error:function(){
		            alert("error");
		        	}
		
		    	});
	    	}
		}
