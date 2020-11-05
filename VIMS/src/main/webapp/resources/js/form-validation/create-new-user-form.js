/**
 * 
 */

function validateform() {
	
	var username= document.getElementById("userName").value;
	var password = document.getElementById("pass").value;
	var conPassword = document.getElementById("conPass").value;
	
	if (username =="" || username==null) {
		alert("Username can not be blank !");
		return false;
	}
	else if (password=="" || password==null ) {
		
		alert("New Password can not be blank !");
		return false;
	}
	else if (password.length<6){
		alert("Password must be at least 6 characters long !");
		return false;
	}
	else if(conPassword =="" || conPassword == null) {
		alert("Confirm Password can not be blank !");
		return false;
	}
	else if(password!=conPassword){
		alert("Confirm Password not matched !");
		return false;
	}
}