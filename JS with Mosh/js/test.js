// JavaScript source code


var name= "Ashish"
alert("Hi! " + name)

document.write("<h2>Jan Parichay </h2>");

window.onload=function(){

let aadharBtn = document.getElementById('aadharBtn');
aadharBtn.addEventListener('click',loginViaAadhar);

let mobileBtn = document.getElementById('mobileBtn');
mobileBtn.addEventListener('click', loginViaMobile);


let emailBtn = document.getElementById('emailBtn');
emailBtn.addEventListener('click',loginViaEmail);

let fetchBtn = document.getElementById('fetchBtn');
fetchBtn.addEventListener('click',fetchEmployees);

function loginViaAadhar(){

    console.log("aadharBtn is clicked")
    //Instantiating an XHR   
    const xhr = new XMLHttpRequest();

    //Open the object
    xhr.open('GET', 'fileToFetchDataFrom.txt', true )

    
    //What to do on progress 
    xhr.onprogress = function(){

        console.log("Processing")
    }

    xhr.onreadystatechange = function () {
        console.log('New ready state is ', xhr.readyState)

    }

    //What to do when response is ready
     xhr.onload =  function(){
        console.log(this.responseText);
     }

     xhr.send();
    }

    
function loginViaMobile(){

    console.log("mobileBtn is clicked")
    //Instantiating an XHR   
    const xhr = new XMLHttpRequest();

    //Open the object
    xhr.open('GET', 'fileToFetchDataFrom.txt', true )
    // xhr.open('POST', 'http://dummy.restapiexample.com/api/v1/create	', true )
    // xhr.getResponseHeader('Content-type', 'application/x-www-form-urlencoded');


    //What to do on progress 
    xhr.onprogress = function(){

        console.log("Processing")
    }

    xhr.onreadystatechange = function () {
        console.log('New ready state is ', xhr.readyState)

    }
    //What to do when response is ready
     xhr.onload =  function(){

        if(this.status === 200) {
            console.log(this.responseText);
        }
        else
        {
            console.error("Something went wrong ")
        }
     }

    //  params ="name=Ashish&salary=100&age=25";

     //To send the request = IMPORTANT 
     xhr.send();

}


function loginViaEmail(){

    console.log("emailBtn is clicked")
    //Instantiating an XHR   
    const xhr = new XMLHttpRequest();

    //Open the object

    
    xhr.onreadystatechange = function () {
        console.log('New ready state is ', xhr.readyState);

    }
    xhr.open('GET', 'fileToFetchDataFrom.txt', true )

    
    //What to do on progress 
    xhr.onprogress = function(){

        console.log("Processing");
    }

    xhr.onreadystatechange = function () {
        console.log('New ready state is ', xhr.readyState);

    }

    //What to do when response is ready
     xhr.onload =  function(){
        console.log(this.responseText);
     }

     xhr.send();
} 

function fetchEmployees(){

    console.log("Fetching Employees for you...");

    const xhr = new XMLHttpRequest();

    xhr.open('GET', 'https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8', true)

        //What to do on progress 
        // xhr.onprogress = function(){

        //     console.log("Processing")
        // }
    
        // xhr.onreadystatechange = function () {
        //     console.log('New ready state is ', xhr.readyState)
    
        // }
    
    xhr.onload = function() {
        // if(this.status === 200){

            let obj = JSON.parse(this.response.text);
            console.log(obj);
        // } 



          
        // else {
        //     console.log("Some error occured");
        // }
    }   
 }

 console.log("Welcome to Ajax");
 
}

