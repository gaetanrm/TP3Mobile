const express = require('express');
const app     = express();
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use(function (req, res, next) {
    res.setHeader('Access-Control-Allow-Headers', '*');
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
    res.setHeader('Content-type', 'application/json');
    next();
});

const MongoClient = require('mongodb').MongoClient;
const ObjectID    = require('mongodb').ObjectId;
const url         = "mongodb://localhost:27017";

MongoClient.connect(url, {useNewUrlParser: true}, (err, client) => {
    let db = client.db("Android");

    console.log("Webservice REST for Android app");
    console.log("Tabs: form");

    app.get("/form/_id/:valeur", (req,res) => {
            let val = req.params.valeur;
            console.log("/form" + "/_id" + "/" + val);
            try {
                let s = {"_id": ObjectID(val)} ;
                returnvalue = [] ;
                
                db.collection("form").find(s).toArray((err, documents) => {
                    res.end(JSON.stringify(documents[0]));
		});
            } catch(e) {
                console.log("Erreur sur /form" + "/_id" + "/" + val +" : "+ e);
                res.end(JSON.stringify([]));
            }
        });
});

// Port d'écoute
app.listen(8888);
