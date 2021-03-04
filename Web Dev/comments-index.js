const functions = require("firebase-functions");
const admin = require('firebase-admin');
const cors = require('cors')({origin: "*"});
moduleCode = "None";
admin.initializeApp();

exports.getcomments = functions.https.onRequest((request, response) =>
{

    //connect to our Firestore database
    cors(request, response, () => {
        let myData = []
        admin.firestore().collection("newCollection").orderBy("time").get().then((snapshot) => {
            if(snapshot.empty) {
                console.log('No matching documents.');
                response.send('No data in database');
                return;
            }

            snapshot.forEach(doc => {
                myData.push(doc.data());
            })
            response.send(myData);
        });
    })
})


exports.postcomments = functions.https.onRequest((request, response) =>
{
    console.log("Request body", request.body);
    cors(request, response, () => {
        admin.firestore().collection("newCollection").add(request.body).then(() =>{
            response.send("Saved in the database");
        });
    });
})