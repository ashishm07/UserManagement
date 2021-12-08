
window.onload = function (){

    
let nextBtn = document.querySelector('#nextBtn');
// let nextBtnColor = document.querySelector('#nextBtn');
let containerDiv = document.querySelector('.container');
let onclickDiv = document.querySelector('.onclick');
let spinnerWrapper = document.querySelector('.spinner-wrapper');

let myName = document.querySelector('#myName');
// let myUser = documet.querySelector('#myUser');
let name = myName.value;

if ( nextBtn!= null) {
    str = document.getElementById("nextBtn").value;
    console.log("Value is not null")
}
else{
    console.log("Value is null!!")
}

nextBtn.addEventListener('click', () =>{

    console.log('Button clicked by ' + myName.value );

    nextBtn.style.display = 'none'

    //Toggles container div
    if( containerDiv.style.display === 'none' ) {
        containerDiv.style.display = 'block';
    }
    else{
        containerDiv.style.display = 'none';
    }

    //Toggles Display text div
    if( onclickDiv.style.display === 'none' ) {
        onclickDiv.style.display = 'block';
    }
    else{
        onclickDiv.style.display = 'none';
    }


    //Toggles spinner wrapper div
    if( spinnerWrapper.style.display === 'none' ) {
        spinnerWrapper.style.display = 'block';
    }
    else{
        spinnerWrapper.style.display = 'none';
    }


    // nextBtn.innerText = 'Loading';
    spinnerWrapper.style.display = 'block';

    
    setTimeout(() => {
        // nextBtnColor.style.display = "none";
        // myUser = message.
        nextBtn.style.display = 'block'
        spinnerWrapper.style.display = 'none';
        onclickDiv.innerText = 'Hi! ' + myName.value;
        nextBtn.style.backgroundColor  = '#008000';
        nextBtn.innerText = 'Submit';
        
    }, 2000);
});

//     nextBtnColor.addEventListener('click', () => {
    // nextBtnColor.innerText = 'Submit';
    // nextBtnColor.style.backgroundColor  = '#008000';

    
    
// })

}