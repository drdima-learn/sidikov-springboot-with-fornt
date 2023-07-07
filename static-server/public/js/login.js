function login(login, password){
    console.log(login + " " + password);
    let json = '{"login":"'+login + '","password":"'+password+'"}';
    console.log(json);
    $.ajax({
        url: 'http://localhost:8080/rest/login',
        type: 'post',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: json,
        success: function (data, textStatus, request){
            console.log('data back')
            const token = data["value"];
            document.cookie = "Auth-Token=" + token
            if (token !== null){
                window.location = '/users.html';
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error:", errorThrown, jqXHR, textStatus);
        }
    });
}