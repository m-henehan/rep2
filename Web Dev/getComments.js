
// GET comments

function getcomments()
{
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://us-central1-functions-83b7e.cloudfunctions.net/getcomments');

    //Track the state changes of the request
    xhr.onreadystatechange = function()
    {
        console.log("started");
        let DONE = 4; //readyState 4 means the request is done
        let OK = 200; // status 200 is a successful return
        if (xhr.readyState === DONE) {
            if (xhr.status === OK) {
                let sHTML = "";
                let data = JSON.parse(xhr.responseText);
                for (let i = 0; i < data.length; i++) {
                    sHTML += "<p> Handle: @" + data[i].handle + "<\p>";
                    sHTML += "<p> Comment: " + data[i].comment + "<\p>";
					
					var newTime = Date.now() - data[i].time;
					if(newTime/60000<1){ newTime = Math.round(newTime/1000) +" seconds ";}
					else if(newTime/1000>1 && newTime/3600000<1){ newTime = Math.round(newTime/60000) +" minutes ";}
					else if(newTime/60000>1 && newTime/86400000<1){ newTime = Math.round(newTime/3600000) +" hours ";}
					else if(newTime/3600000>1 && newTime/2592000000<1){ newTime = Math.round(newTime/86400000) +" days ";}
					else if(newTime/86400000>1 && newTime/31104000000<1){ newTime = Math.round(newTime/2592000000) +" months ";}
					else{ newTime = Math.round(newTime/31104000000) +" years ";}
					sHTML += "<p> Posted " + newTime + " ago.</p><br>";
					
                    document.getElementById("comments").innerHTML = sHTML;
                }
            } else {
                console.log('Error: ' + xhr.status);
            }
        }
    }
    xhr.send(null);
}