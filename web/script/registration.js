
function checkRegistration(){
		
    var firstName	=	document.getElementById("firstName").value;
    var username	=	document.getElementById("userName").value;
    var dob		=	document.getElementById("dob").value;
    var email		=       document.getElementById("email").value; 
    var password	=	document.getElementById("password").value;
    var confirmPwd	=	document.getElementById("confirmPwd").value;
    var address		=	document.getElementById("address").value;
    var security	=	document.getElementById("security").value;
    var answer		=	document.getElementById("answer").value;
    var alternative	=	document.getElementById("alternative").value;
    var caps             =       document.regForm.ansca.value;
    
    	
    var specialCharacters = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_0123456789";
    var atpos;
    var dotpos;
    
    // validation for firstName //
		
    if(firstName == "" || firstName == null){
				
        alert("Firstname should not be empty");
				
        return false;
    }
    else{
				
        if(!/^[a-zA-Z]+$/.test(firstName)){
					
            alert("Enter a valid first name, where the first character is not a numeric or special character");
					
            document.getElementById("firstName").value = "";
					
            return false;
        }
				
        if(firstName.length<5 || firstName.length>20)
        {
            alert("Firstname should between 5 to 20 characters");
						
            document.getElementById("firstName").value = "";

            return false;
        }

    }
		
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
			
    // validation for dob //

    if(dob == "" || dob == null){
				
        alert("Please Select a Valid Date");
				
        return false;
    }	

    // validation for gender //

    if(document.getElementById("radioBtn1").checked == false && document.getElementById("radioBtn2").checked == false){
				
        alert("Select atleast any Gender");
					
        return false;					
    }
			
    // validation for email //

    if(email == "" || email == null){
				
        alert("Email should not be empty");
				
        return false;
    }
    else{
				
        atpos 	= email.indexOf("@");
        dotpos 	= email.lastIndexOf(".");
	
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
        {
            alert("Not a valid e-mail address");
					
            document.getElementById("email").value = "";
					
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
		
    // validation for Confirm Password

    if(confirmPwd == "" || confirmPwd == null){
				
        alert("Confirm password should not be empty");
				
        return false;
    }
    else{
				
        if(!/^[a-zA-Z0-9]+$/.test(confirmPwd)){
					
            alert("Enter a valid Confirm password, Accepts only alphanumeric characters");
					
            document.getElementById("confirmPwd").value = "";
					
            return false;
        }
				
        if(confirmPwd.length<5 || confirmPwd.length>10)
        {
            alert("Confirm password should between 5 to 10 characters");
						
            document.getElementById("confirmPwd").value = "";

            return false;
        }

    }	
		
    // comparing password and confirm password

    if(password.length != confirmPwd.length){
				
        alert("Confirm password is not valid");
						
        document.getElementById("confirmPwd").value = "";

        return false;	
    }

    if(password.length == confirmPwd.length){				
				
        if(password != confirmPwd){
					
            alert("Confirm password is not valid");
						
            document.getElementById("confirmPwd").value = "";

            return false;		
        }
    }	
		
    // validation for address //
		
    if(address == "" || address == null){
				
        alert("Address should not be empty");
				
        return false;
    }
    else{
				
        if(!/^[a-zA-Z0-9]+$/.test(address)){
					
            alert("Enter a valid address, Accepts alpha numeric characters, special characters like / or - or . or , ");
					
            document.getElementById("address").value = "";
					
            return false;
        }

    }
			
    // 	validation for Security Question //
		
    if(security == "select"){
					
        alert("Please select a Security Question");
				
        return false;
						
    }	

    // validation for answer //

    if(answer == "" || answer == null){
				
        alert("answer should not be empty");
				
        return false;
    }
    else{
				
        if(!/^[a-zA-Z0-9]+$/.test(answer)){
					
            alert("Enter a valid answer");
					
            document.getElementById("answer").value = "";
					
            return false;
        }
				
        if(answer.length<5 || answer.length>20)
        {
            alert("answer should between 5 to 20 characters");
						
            document.getElementById("answer").value = "";

            return false;
        }

    }
			
    // validation for alternative email //

    if(alternative == "" || alternative == null){
				
        alert("Alternative Email should not be empty");
				
        return false;
    }
    else{
				
        atpos 	= alternative.indexOf("@");
        dotpos 	= alternative.lastIndexOf(".");
	
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=alternative.length)
        {
            alert("Not a valid alternative e-mail address");
					
            document.getElementById("alternative").value = "";
					
            return false;
        }	

    }	
		
    // comparing email and alternative email
			
    if(alternative == email){
				
        alert("email and alternative e-mail should not be the same");
				
        document.getElementById("alternative").value = "";
		
        return false;
    }	
    
    // validation for captcha //
		
    if(caps == "" || caps == null){
				
        alert("CAPTCHA should not be empty");
				
        return false;
    }
   
    // validating agree //
		
    if(document.getElementById("chck").checked == false){
			
        alert("Agree to the terms and conditions");				
				
        return false;	
    }
		
    return true;
}

