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

$universal_id = $_REQUEST['universal-id'];
$network_hostname = $_REQUEST['network-hostname'];
$network_ext_ip = $_REQUEST['network-ext-ip'];
$network_int_ip = $_REQUEST['network-int-ip'];
$system_os = $_REQUEST['system-os'];
$system_os_ver = $_REQUEST['system-os-ver'];
$system_ram = $_REQUEST['system-ram'];

$content = file_get_contents(output.txt) . "\n";

$content =. $universal_id . "," . $network_hostname . "," . $network_ext_ip
	 . "," . $network_int_ip . "," . $system_os . "," . $system_os_ver
	  . "," . $system_ram . "\n";

file_put_contents('output.txt', $content);

?>