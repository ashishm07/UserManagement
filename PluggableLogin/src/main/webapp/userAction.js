/**
 * 
 */

window.onload=function(){

let aadharBtn = document.getElementById('AddUserBtn');
aadharBtn.addEventListener('click',AddUser);

let mobileBtn = document.getElementById('DeleteUserBtn');
mobileBtn.addEventListener('click', loginViaMobile);


let emailBtn = document.getElementById('UpdateUserBtn');
emailBtn.addEventListener('click',loginViaEmail);

let fetchBtn = document.getElementById('ListUserBtn');
fetchBtn.addEventListener('click',fetchEmployees);

function AddUser(){
	xhr.open('GET', '${pageContext.request.contextPath}/myservlet', true);
}

}
