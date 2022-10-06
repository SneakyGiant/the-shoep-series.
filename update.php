<form method="POST">
    <input type="text"  name="firstName" placeholder="first name">
    <input type="text"  name="lastName" placeholder="last name">
    <input type="date"  name="dateOfBirth" placeholder="date of birth">
    <input type="submit" name="update" value="update">
</form>


<?php 

include "connect.php";
    
if(isset($_POST['update'])) {
    
    $first = $_POST['firstName'];
    $last = $_POST['lastName'];
    $dob = $_POST['dateOfBirth'];  

    $sql = "UPDATE opdracht_1 
            set first_name='$first',last_name='$last',date_of_birth='$dob'  
            WHERE id='".$_GET['ID']."' ";    
        
    if ($conn->query($sql) === TRUE) {
        echo "Record updated successfully";
        header("Location: index.php");
        } else {
        echo "Error updating record: " . $conn->error;
        }
}

?>