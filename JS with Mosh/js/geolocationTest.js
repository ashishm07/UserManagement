

window.onload = function() {

let startWatchBtn = document.getElementById('startWatchBtn');
startWatchBtn.addEventListener('click',startWatching);

let stopWatchBtn = document.getElementById('stopWatchBtn');
stopWatchBtn.addEventListener('click', stopWatching);
    
function startWatching(){

    console.log("User location is being monitored");

    const successCallback = (position) => {
        console.log(position);
    };
    
    const errorCallback = (error) => {
        console.error(error);
    };

    
    // Asks user for his/her current location
    navigator.geolocation.getCurrentPosition(successCallback, errorCallback); 

    //Updates watchId as the location changes
    const watchId = navigator.geolocation.watchPosition(successCallback,errorCallback);
    
}

function stopWatching () {

    const successCallback = (position) => {
        console.log(position);
    };
    
    const errorCallback = (error) => {
        console.error(error);
    };

    
    // Asks user for his/her current location
    navigator.geolocation.getCurrentPosition(successCallback, errorCallback); 

    //Updates watchId as the location changes
    const watchId = navigator.geolocation.watchPosition(successCallback,errorCallback);

    console.log("User location is not being monitored");
    
    //Clears watchId. Any changes to user location will get cleared.
    navigator.geolocation.clearWatch(watchId);
    
}


}
