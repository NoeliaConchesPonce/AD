// programa los scripts

function getGroupInfo() {
    let nombre = document.getElementById('nombre').value;
    axios
        .get("https://www.amiiboapi.com/api/amiibo/?name=" + nombre)
        .then(response => {
            document.getElementById('amiiboSeries').textContent = response.data.amiibo[0].amiiboSeries;
            document.getElementById('gameSeries').textContent = response.data.amiibo[0].gameSeries;
            document.getElementById('foto').src = response.data.amiibo[0].foto;
            document.getElementById('releaseEu').textContent = response.data.amiibo[0].release.eu;
        })
        .catch(error => {
            console.error(error);
        });
};
function guardarDatos() {
    let amiiboSeries = document.getElementById('amiiboSeries').textContent;
    let gameSeries = document.getElementById('gameSeries').textContent;
    let foto = document.getElementById('foto').src;
    let releaseEu = document.getElementById('releaseEu').textContent;
    


    $.ajax({
        type: "POST",
        url: "./index.php",
        data: {
            amiiboSeries: amiiboSeries, gameSeries: gameSeries,
            foto: foto, releaseEu: releaseEu
        },
        success: function () {
            alert("He guardado los datos extraidos");
        },
        error: function () {
            alert("Error");
        }
    });
}