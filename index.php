<!-- lo que se conecta a tu base de datos -->

<?php
if (isset($_POST["amiiboSeries"])) {
    $amiiboSeries = $_POST["amiiboSeries"];
    $gameSeries= $_POST["gameSeries"];
    $foto=$_POST["foto"];
    $releaseEu=$_POST["releaseEu"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "aev4";
    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
    if (!$conexion) {
        echo "Error en la conexion a MySQL: " . mysqli_connect_error();
        exit();
    }
    $sql = "INSERT INTO amiibo (amiiboSeries,gameSeries,foto,releaseEu) VALUES ('".$amiiboSeries."','".$gameSeries."','".$foto."','".$releaseEu."')" ;
    if (mysqli_query($conexion, $sql)) {
        echo "Datos extraidos con exito";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
    }
}
?>