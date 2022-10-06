<form method="POST">
    <input type="text"  name="firstName" placeholder="first name">
    <input type="text"  name="lastName" placeholder="last name">
    <input type="date"  name="dateOfBirth" placeholder="date of birth">
    <input type="submit" name="submit" value="submit">     
</form>

<?php
        
    include "connect.php";
    include "insert.php";  
    include "select.php";
        
?>
