<?php 
    
    if(isset($_POST['submit'])) {
        
        $first = $_POST['firstName'];
        $last = $_POST['lastName'];
        $dob = $_POST['dateOfBirth'];

        $sql = "INSERT INTO opdracht_1(first_name, last_name, date_of_birth) 
        VALUES ('$first', '$last', '$dob')";

        if ($conn->query($sql) === TRUE) {
        echo "New record created successfully";
        } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
        }
    }

?>