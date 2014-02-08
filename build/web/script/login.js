
function checkLogin(){
		
    var username	=	document.getElementById("username").value;
    var password	=	document.getElementById("password").value;
		
    var specialCharacters = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_0123456789";
				
    // validation for username //
		
    if(username == "" || username == null){
				
        alert("User name should not be empty");
				
        return false;
    }
    else{
				
        if(specialCharacters.indexOf(username.charAt(0)) >= 0){
					
            alert("Enter a valid user name");
					
            document.getElementById("username").value = "";
					
            return false;
        }
				
        if(username.length<5 || username.length>10)
        {
            alert("User name should between 5 to 10 characters");
						
            document.getElementById("username").value = "";

            return false;
        }

    }
		
    // validation for password

    if(password == "" || password == null){
				
        alert("Password should not be empty");
				
        return false;
    }
    else{
				
        if(!/^[a-zA-Z0-9]+$/.test(password)){
					
            alert("Enter a valid password, Accepts only alphanumeric characters");
					
            document.getElementById("password").value = "";
					
            return false;
        }
				
        if(password.length<5 || password.length>10)
        {
            alert("Password should between 5 to 10 characters");
						
            document.getElementById("password").value = "";

            return false;
        }

    }	
			
    return true;
}

