
const contact = {
    name: "Kurtis Fleming",
    website: "https://www.linkedin.com/in/kurtfleming",
    email: "kurtis.fleming@hmrc.gov.uk"
}
const about = {
    title: "Data Standardisation API",
    desc: "Data Standardisation API proof-of-concept",
    version: "V1.0.0"
}

function getAboutContactInfo() {
    return alert(about.title
        + "\n" + about.desc
        + "\n" + "Version: "
        + about.version
        + "\n\nContact: "
        + contact.name
        + "\nWebsite: "
        + contact.website
        + "\nEmail: "
        + contact.email);
}

function fullStandardise() {

    let xhr = new XMLHttpRequest();
    let url = new URL('http://localhost:8080/full-standardise');
    var term = document.getElementById('rawDataText').value;

    url.searchParams.set('term', `${term}`);

    xhr.open('GET', url, true);

    xhr.send();

    xhr.onload = function () {
        let standardisedDataElement = document.getElementById('standardisedDataBox');
        let standardisersApplied = document.getElementById('standardiserList');

        //Parse API response
        let apiResponse = JSON.parse(xhr.response);

        //Display parsed value of 'output'
        standardisedDataElement.innerHTML = apiResponse.output;

        //Add standardiser name to 'standardisers applied' HTML list
        standardisersApplied.innerHTML = "<li>" + standardiserToApply + "</li>";
    };

}

function singleStandardise() {

    let xhr = new XMLHttpRequest();
    let url = new URL('http://localhost:8080/single-standardise');
    var standardiserToApply = document.querySelector('input[name = "standardisers"]:checked').value;
    var term = document.getElementById('rawDataText').value;

    url.searchParams.set('term', `${term}`);
    url.searchParams.set('standardiserInput', `${standardiserToApply}`);

    xhr.open('GET', url, true);

    if (standardiserToApply != null) {  //Test if radio button was selected
        xhr.send();
    } else {
        alert('No standardiser selected');
    };

    xhr.onload = function () {
        let standardisedDataElement = document.getElementById('standardisedDataBox');
        let standardisersApplied = document.getElementById('standardiserList');

        //Parse API response
        let apiResponse = JSON.parse(xhr.response);

        //Display parsed value of 'output'
        standardisedDataElement.innerHTML = apiResponse.output;

        //Add standardiser name to 'standardisers applied' HTML list
        standardisersApplied.innerHTML = "<li>" + standardiserToApply + "</li>";
    };
}


function multipleStandardise() {

    let xhr = new XMLHttpRequest();
    let url = new URL('http://localhost:8080/multiple-standardise');

    //logic to get term, 'checked' checkbox standardiser values.
    let term = document.getElementById('rawDataText').value;

    let checked = Array.from(document.querySelectorAll('[name=standardisers]:checked'));
    let standardisers = checked.map(el => el.value);



    //Converting objects into JSON
    stndJson = JSON.stringify(standardisers);
    termJson = JSON.stringify(term);

    // open request
    xhr.open('POST', url);

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader('Content-Type', 'application/json');

    //create JSON payload.
    const json = `{
        "term": ${termJson},
        "standardisers": ${stndJson}
    }`;

    xhr.send(json);

    xhr.onload = function () {

        console.log(xhr.response);

        let standardisedDataElement = document.getElementById('standardisedDataBox');
        var standardisersApplied = document.getElementById('standardiserList');

        //Parse API response
        var apiResponse = JSON.parse(xhr.responseText);

        //Display parsed value of 'output'
        standardisedDataElement.innerHTML = apiResponse.output;

        //Reset HTML list
        standardisersApplied.innerHTML = "";

        //Add standardiser name to 'standardisers applied' HTML list
        for (let ch of checked) {
            standardisersApplied.innerHTML += "<li>" + ch.value + "</li>";
        }
    };
}

function resetPage() {
    document.getElementById('standardiserRadio').reset();
    document.getElementById('rawDataText').value = "";
    document.getElementById('standardisedDataBox').textContent = "";
    document.getElementById('standardiserList').innerHTML = "";
}

function loadAuditPage() {

    location.assign("http://localhost:8080/audit.html");

}
