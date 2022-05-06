let xhr = new XMLHttpRequest();
let url = new URL('http://localhost:8080/get-all-records');

xhr.open('GET', url);

xhr.send();

xhr.onload = function () {

    let auditElement = document.getElementById('table');
    let apiResponse = JSON.parse(xhr.response); //API response to be parsed

    for (let i = 0; i < (apiResponse.output).length; i++) {
        auditElement.innerHTML += "<tr>"
            + "<td>" + apiResponse.output[i].record_id + "</td>"
            + "<td>" + apiResponse.output[i].date_time + "</td>"
            + "<td>" + apiResponse.output[i].term + "</td>"
            + "<td>" + apiResponse.output[i].standardisation_method + "</td>"
            + "<td>" + apiResponse.output[i].output_term + "</td>"
            + "</tr>";
    }

};