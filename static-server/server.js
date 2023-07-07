console.log("hello");

let express = require('express');
let cookieParser = require('cookie-parser');
let app=express();
app.use(cookieParser());

//app.get('/users.html', function (req, res, next){
app.get('/users.html', (req, res, next) => {
    let token = req.cookies['Auth-Token'];
    if (token==undefined || token==null){
        res.redirect('/login.html')
    }
    next();
});
app.use(express.static('public'));
app.listen(80);
console.log('Server started');