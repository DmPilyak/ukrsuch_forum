function validateSignIn() {
		var userName = $("#nik").val();
		var userEmail = $("#email").val();
		var userPassword = $("#pass").val();
		var userRepeatPassword = $("#repPass").val();
		var nameField = document.getElementById("nik");
		var emailField = document.getElementById("email");
		var passField = document.getElementById("pass");
		var passRepeatField = document.getElementById("repPass");
		
		var nameValid = false;
		if (userName.length >= 2) {
			nameValid = true;
			console.log(userName);
			for (var i = 0; i < userName.length - 1; i++) {
				console.log(userName[i]);
				if (userName[i] == ' '){
					nameValid = false;
					break;
				}
			}
		}
		
		var emailValid = false;
		for (var i = 0; i < userEmail.length; i++) {
			if (userEmail[i] == '@') {
				emailValid = true;
			}
			if (userEmail[i] == ' ') {
				emailValid = false;
				break;
			}
		}
		var passValid = false;
		if (userPassword.length > 4) {
			passValid = true;
			for (var i = 0; i < userPassword.length; i++) {
				if (userPassword[i] == ' ')
					passValid = false;
				break;
			}
		}
		
		var passRepeatValid = false;
		if (userRepeatPassword.length > 4 && userRepeatPassword == userPassword) {
			passReapeatValid = true;
			for (var i = 0; i < userRepeatPassword.length; i++) {
				if (userRepeatPassword[i] == ' ')
					passRepeatValid = false;
				break;
			}
		}
		
		if (userName.length == 0 || !nameValid) {
			nameField.style.border = "2px solid red";
			nameField.style.borderRadius = "5px";
			return false;
		} else
			nameField.style.border = "none";
		
		if (userEmail.length == 0 || !emailValid) {
			emailField.style.border = "2px solid red";
			emailField.style.borderRadius = "5px";
			return false;
		} else
			emailField.style.border = "none";

		if (userPassword.length == 0 || !passValid) {
			passField.style.border = "2px solid red";
			passField.style.borderRadius = "5px";
			return false;
		} else
			passField.style.border = "none";
		
		if (userRepeatPassword.length == 0 || passRepeatValid) {
			passRepeatField.style.border = "2px solid red";
			passRepeatField.style.borderRadius = "5px";
			return false;
		} else
			passRepeatField.style.border = "none";
		return true;
	}


function validateLogin() {
	var userNik = $("#nik").val();
	var userPassword = $("#pass").val();
	var nikField = document.getElementById("nik");
	var passField = document.getElementById("pass");
	var nikValid = false;
	if(userNik.length > 0){
		nikValid = true;
	}
	for (var i = 0; i < userNik.length; i++) {
		if (userNik[i] == ' ') {
			nikValid = false;
			break;
		}
	}
	var passValid = false;
	if (userPassword.length > 4) {
		passValid = true;
		for (var i = 0; i < userPassword.length; i++) {
			if (userPassword[i] == ' ')
				passValid = false;
			break;
		}
	}

	if (userNik.length == 0 || !nikValid) {
		nikField.style.border = "2px solid red";
		nikField.style.borderRadius = "5px";
		return false;
	} else
		nikField.style.border = "none";

	if (userPassword.length == 0 || !passValid) {
		passField.style.border = "2px solid red";
		passField.style.borderRadius = "5px";
		return false;
	} else
		passField.style.border = "none";
	return true;
}

function validateArticle(){
	var title = $("#title").val();
	var description = $("#textFormArea").val();
	var titleField = document.getElementById("title");
	var descriptionField = document.getElementById("textFormArea");
	
	var titleValid = false;
	var descriptionValid = false;
	
	if (title.length >= 3) {
		titleValid = true;
	}
	if (description.length >= 10) {
		descriptionValid = true;
	}
	var returnTitleVal = false;
	var returnDescriptVal = false;
	if(!titleValid){
		if(titleField.classList.contains("is-valid")){
			titleField.classList.remove("is-valid");
			titleField.classList.add("is-invalid");
		}
		else{
			titleField.classList.add("is-invalid");
		}
		var titleDiv = document.getElementById("titleArea");
		if(document.getElementById("titleFeedback") != null){
			document.getElementById("titleFeedback").remove();
		}
		titleDiv.innerHTML += "<div id='titleFeedback' class='valid-feedback mr-2 text-danger'>Введіть тему! Поле має містити не менше 3 символів!</div>";
		returnTitleVal = false;
	}
	else{
		if(titleField.classList.contains("is-invalid")){
			titleField.classList.remove("is-invalid");
			titleField.classList.add("is-valid");
			document.getElementById("titleFeedback").remove();
		}
		else{
			titleField.classList.add("is-valid");
		}
		returnTitleVal = true;
	}
	
	if(!descriptionValid){
		if(descriptionField.classList.contains("is-valid")){
			descriptionField.classList.remove("is-valid");
			descriptionField.classList.add("is-invalid");
		}
		else{
			descriptionField.classList.add("is-invalid");
		}
		var descriptDiv = document.getElementById("descriptArea");
		if(document.getElementById("descriptFeedback") != null){
			document.getElementById("descriptFeedback").remove();
		}
		descriptDiv.innerHTML += "<div id='descriptFeedback' class='valid-feedback mr-2 text-danger'>Введіть думку! Поле має містити не менше 10 символів!</div>";
		returnDescriptVal = false;
	}
	else{
		if(descriptionField.classList.contains("is-invalid")){
			descriptionField.classList.remove("is-invalid");
			descriptionField.classList.add("is-valid");
			document.getElementById("descriptFeedback").remove();
		}
		else{
			descriptionField.classList.add("is-valid");
		}
		returnDescriptVal = true;
	}
	if(!returnTitleVal || !returnDescriptVal){
		return false;
	}
	return true;
	
}

function validateCommentArticleAndComics(){
	var comment = $("#commentContent").val();
	var commentField = document.getElementById("commentContent");
	var commentValid = false;
	
	if (comment.length > 0) {
		commentValid = true;
	}
	
	if(!commentValid){
		console.log("555");
		if(commentField.classList.contains("is-valid")){
			commentField.classList.remove("is-valid");
			commentField.classList.add("is-invalid");
		}
		else{
			commentField.classList.add("is-invalid");
		}
		var commentDiv = document.getElementById("commentArea");
		if(document.getElementById("commentFeedback") != null){
			document.getElementById("commentFeedback").remove();
		}
		commentDiv.innerHTML += "<div id='commentFeedback' class='valid-feedback mr-2 text-danger'>Введіть коментар!</div>";
		return false;
	}
	else{
		if(commentField.classList.contains("is-invalid")){
			commentField.classList.remove("is-invalid");
			commentField.classList.add("is-valid");
			document.getElementById("commentFeedback").remove();
		}
		else{
			commentField.classList.add("is-valid");
		}
		return true;
	}
	return true;
}
