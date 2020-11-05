    
function Filevalidation() { 
        const fi = document.getElementById('itemImage');
        const pro = document.getElementById('profile').value;
        const st = document.getElementById('visualProfileStageID').value;
        const iname = document.getElementById('itemName').value;
        const isno = document.getElementById('serialNo').value;
        
        // Check if any file is selected. 
        if (fi.files.length > 0) { 
            for (const i = 0; i <= fi.files.length - 1; i++) { 
  
                const fsize = fi.files.item(i).size; 
                const file = Math.round((fsize / 1024)); 
                // The size of the file. 
                if (file >= 4096) { 
                    alert( 
                      "File too Big, please select a file less than 4mb");
                    return false;
                } 
            } 
        }
        if(iname=="" || isno=="" || pro == "" || st == "")
        	{
        	}
        else{
	        if (fi.files.length == 0) {
	        
	        	if (confirm("You not choose an item image...!\n Are you sure to continue ? "))
	        		{}
	        	else
	        		{
	        		 	return false;
	        		}
	        	
	        }
        }
    } 