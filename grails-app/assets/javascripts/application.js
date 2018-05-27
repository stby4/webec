// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

function showNearestFields(path, lat, lon) {
    window.location.href = path + "?lat=" + lat + "&lon=" + lon;
}


$(document).ready(function () {
    $('#locate').click(function () {
        var path = window.location.protocol + "//" + window.location.host + $('#locate').attr('href');
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                showNearestFields(path, position.coords.latitude, position.coords.longitude)
            })
        } else {
            // manually enter coordinates
            alert('We could not find your location. Please enter the coordinates manually.');
            var lat = prompt('Latitude');
            var lon = prompt('Longitude');
            showNearestFields(path, lat, lon);
        }

        return false;
    })
})