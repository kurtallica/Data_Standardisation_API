function standardiseMethod() {

    var standardiserRadio = document.querySelector('input[name = "endpoints"]:checked').value;

    location.assign("http://localhost:8080/" + `${standardiserRadio}` + ".html");
}