

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src = "js/jquery-3.6.0.min.js"></script>
        <script>
            $(document).ready(function() {
                var bookCount = 1;
                $("button").click(function() {
                    bookCount++;
                    $("#books").load("load-books.php", {
                        newCount: bookCount 
                    });
                });
            });
        </script>
    </head>
    <body>
        
        <div id="books">
            <p>Hello Friends</p>
            <?php
                
                $servername = "localhost";
                $username = "root";
                $password = "0405";
                $dbname = "endsem";
                
                $conn = mysqli_connect("localhost","root","0405","endsem");
                
                 
                $sql = "SELECT * FROM bookCatalogue LIMIT 1";
                $result = mysqli_query($conn, $sql);

                
                while($row= mysqli_fetch_assoc($result)){
                    echo '<p>';
                    echo $row['Title'];
                    echo '<br>';
                    echo $row['Author'];
                    echo '</p>';

                    
                }
                
                
            ?>

            
        </div>
        <button>Show more Books</button>
        
    </body>
</html>
