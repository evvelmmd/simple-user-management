$(function () {
    getAllCountries();
    getCities();
})

function getAllCountries() {
    let countryList = $("#country_dropdown");
    $.ajax({
        url: "http://localhost:8080/api/country",
        success: function (countries) {
            $("#country_dropdown").empty();
            countryList.append(`<option value="">Olke Sechin</option>`)
            countries.forEach(country => countryList.append(`<option value="${country.id}">${country.name}</option>`));
        }
    });
}

function addCity() {
    let countryId = $("#country_dropdown").val();
    let cityName = $("#city_name").val();
    $.ajax({
        url: `http://localhost:8080/api/country/city/${countryId}/${cityName}`,
        type: "POST",
        success: function () {
            getCities();
            alert("Elave edildi.");
        }
    });
}

function addCountry() {
    let countryName = $("#country_name").val();
    $.ajax({
        url: `http://localhost:8080/api/country/${countryName}`,
        type: "POST",
        success: function () {
            getAllCountries();
            alert("Elave edildi.");
        }
    });
}

function getCities() {
    let countryId = $("#country_dropdown").val();
    let cityList = $("#city_dropdown");
    $.ajax({
        url: `http://localhost:8080/api/country/cities/${countryId}`,
        type: "GET",
        success: function (cities) {
            cityList.empty();
            cities.forEach(city => cityList.append(`<option value="${city.id}">${city.name}</option>`));
        }
    });
}

function updateCountry() {
    let countryId = $("#country_dropdown").val();
    let newName = $("#new_name").val();
    if (!newName){ alert("input bosh ola bilmez");return}

        $.ajax({
            url: `http://localhost:8080/api/country/${countryId}?newName=${newName}`,
            type: "PUT",
            success: function () {
                alert("Deyisdirildi");
                getAllCountries();
            }
        });

}


function updateCity() {
    let cityId = $("#city_dropdown").val();
    let newName = $("#new_cityName").val();
    if (!newName) {alert("input bosh ola bilmez"); return}
        $.ajax({
            url: `http://localhost:8080/api/country/city/${cityId}?newName=${newName}`,
            type: "PUT",
            success: function () {
                alert("Elave edildi");
                getCities();
            }
        });

}

function deleteCountry() {
    let countryId = $("#country_dropdown").val();

    if (confirm("Silim?:)"))
        $.ajax({
            url: `http://localhost:8080/api/country/${countryId}`,
            type: "Delete",
            success: function () {
                alert("Silindi");
                getAllCountries();
            }
        });
}

function deleteCity() {
    let cityId = $("#city_dropdown").val();

    if (confirm("Silim?:)"))
        $.ajax({
            url: `http://localhost:8080/api/country/city/${cityId}`,
            type: "Delete",
            success: function () {
                alert("Silindi");
                getCities();
            }
        });

}
