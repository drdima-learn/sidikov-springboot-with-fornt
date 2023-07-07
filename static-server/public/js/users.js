$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/rest/users?token=" + getToken(),
        type: "GET",
        dataType: "json",
        success: function(response) {
            var userList = $("#user-list");
            $.each(response, function(index, user) {
                var listItem = $("<li>").text(user.id + " - " + user.login + " - " + user.firstName);
                userList.append(listItem);
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error:", errorThrown);
        }
    });
});

function getToken(){
    return getCookie("Auth-Token");
}

function getCookie(key) {
    var cookies = document.cookie.split(';');
    for(var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].trim();
        if (cookie.indexOf(key + '=') === 0) {
            return cookie.substring(key.length + 1);
        }
    }
    return null;
}