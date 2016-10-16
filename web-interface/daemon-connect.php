<?php
$servername = "localhost";
$username = "root";
$password = "jman22355";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

echo "Connected successfully \n";

// Get Variables

$name = $_POST['name'];
echo $name;
echo "Hello World";

?>