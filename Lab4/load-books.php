<?php
    $newCount = $_POST['newCount'];           
    $servername = "localhost";
    $username = "root";
    $password = "0405";
    $dbname = "endsem";
                
    $conn = mysqli_connect($servername,$username,$password,$dbname);
                 
    $sql = "SELECT * FROM bookCatalogue LIMIT $newCount";
    $result = mysqli_query($conn, $sql);

                
    while($row= mysqli_fetch_assoc($result)){
        echo '<p>';
        echo $row['Title'];
        echo '<br>';
        echo $row['Author'];
        echo '</p>';

        
    }
                
                
?>