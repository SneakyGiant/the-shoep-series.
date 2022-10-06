<?php 
include "connect.php";

if(isset($_GET['ID'])) {
        
  $sql = "DELETE FROM opdracht_1 WHERE id='".$_GET['ID']."' ";

    if ($conn->query($sql) === TRUE) {
       header("Location: index.php");
    } else {
        echo "Error deleting record: " . $conn->error;
    }
}

?>