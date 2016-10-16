<?php

////////////////////////////////////////////
// Print 1 Deimensional Associative Array //
////////////////////////////////////////////

function printArray($arrayToPrint){
	echo "<table><tr><td><b>Key</b></td><td><b>Value</b></td></tr>";
	foreach ($arrayToPrint as $key => $value) {
		echo "<tr><td>" . $key . "</td><td>" . $value . "</td></tr>";
	}
	echo "</table>";
}

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

print $_SERVER['REQUEST_METHOD'];

?>