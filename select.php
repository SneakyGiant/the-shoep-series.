<?php 

if($conn->connect_error){
    die("connect failed".$conn->connect_error);
}
else{
    $sql = " SELECT *, TIMESTAMPDIFF(YEAR,date_of_birth,NOW())
    AS age FROM `opdracht_1`";
}
    
$result = $conn->query($sql);

if($result->num_rows == 0 ){
    echo"<P>there are no entries</P>";
}
else{
    //var_dump($result);
    echo "<h1>B2 Database</h1>".PHP_EOL;
    echo "<table width='60%' border='2px solid black'>\n";
    echo "<tr>
            <th width='10%'> id </th>
            <th width='45%'> first name </th>
            <th width='45%'> last name </th>
            <th width='10%'> date of birth </th> 
            <th width='5%'> age </th>
          </tr>";
    
      while($row = $result->fetch_assoc()){
        echo "<tr><td>{$row['ID']}</td>";
        echo "<td>{$row['first_name']}</td>";
        echo "<td>{$row['last_name']}</td>";
        echo "<td>{$row['date_of_birth']}</td>";
        echo "<td>{$row['age']}</td>";
        echo "<td><a href='update.php?ID={$row['ID']}'>update</a>
                  <a href='delete.php?ID={$row['ID']}'>DELETE</a></td>   
        </tr>".PHP_EOL;
    }
    echo "</table>\n" ;     
}

?>