

`curl -s -i -X POST -d '{"login":"vasya","password":"1234"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/login`


POST http://localhost:8080/rest/login
Content-Type: application/json

{
"login": "vasya",
"password": "1234"
}

###
curl -s http://localhost:8080/rest/users/100000?token=er3Gpfn5Eb  | json_pp


GET http://localhost:8080/rest/users/100000?token=vy6efgKp2f
Accept: application/json






GET http://localhost:8080/rest/users?token=vy6efgKp2f
Accept: application/json





POST http://localhost:8080/rest/users
Content-Type: application/json

{
"login": "vasya2",
"password": "1234",
"firstName": "vasilii2",
"lastName": "pupkin2"
}