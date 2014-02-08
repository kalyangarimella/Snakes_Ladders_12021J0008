

function check(){
		
    var username	=	document.getElementById("username").value;
    var password	=	document.getElementById("password").value;
    var boardName	=	document.getElementById("board").value;
		
    var specialCharacters = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";
		
    // validation for username //
		
    if(username == "" || username == null){
				
        alert("User name should not be empty");
				
        return false;
    }
    else{
				
        if(specialCharacters.indexOf(username.charAt(0)) > 0){
					
            alert("Enter a valid user name");
					
            document.getElementById("username").value = "";
					
            return false;
        }
				
        if(username.length<3 || username.length>10)
        {
            alert("User name should between 3 to 10 characters");
						
            document.getElementById("username").value = "";

            return false;
        }

    }  
			
    // validation for Board Name

    if(boardName == "select"){
					
        alert("At Least one Board should be selected");
				
        return false;
						
    }
    
    // validation for board password
			
    if(password == "" || password == null){
				
        alert("Board password should not be empty");
				
        return false;
    }
    else{				
				
        if(password.length<5 || password.length>10)
        {
            alert("Game Board password should between 5 to 10 characters");
						
            document.getElementById("password").value = "";

            return false;
        }
				
        if(!/^[a-zA-Z0-9]+$/.test(password)){
					
            alert("Password should contain only alphanumeric characters");
						
            document.getElementById("password").value = "";

            return false;
        }	

    }
			
    // validation for Pawn Color

    if(document.getElementById("radioBtn1").checked == false && document.getElementById("radioBtn2").checked == false && document.getElementById("radioBtn3").checked == false && document.getElementById("radioBtn4").checked == false){
				
        alert("Select atleast one Pawn Color");
					
        return false;					
    }		
		
    return true;
}

