<?php
    require_once 'vendor/autoload.php';
    $servername='localhost';
    $username='aryan';
    $password='0405';
    $dbname = "endsem";
    $conn=mysqli_connect($servername,$username,$password,"$dbname");
    if(!$conn){
      die('Could not Connect MySql Server:' .mysql_error());
    }
?>