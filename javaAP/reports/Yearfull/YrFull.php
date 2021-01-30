
<?php  
error_reporting (E_ALL ^ E_NOTICE);
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "java";



// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
    $yr = $_POST['year'];
    $yt = (int)$yr;
    //echo "<p>Month - ", $mon ,"        Year - ",$yr, "<p>";


$p=array();
$sql = "SELECT * FROM product";
$result = $conn->query($sql);
    
$i=0;
if ($result->num_rows > 0) {
 // echo "<table style='border: solid 1px black;'><tr><th>ID</th><th>No Of Items</th><th>No Of Packed Samples</th><th>Date</th></tr><caption>Stock Details</caption>";
  // output data of each row
  while($row = $result->fetch_assoc()) {
   // echo $row["P_ID"];
    $p[$i]=$row["P_ID"];
    $i++;  
  }
  //echo $p[2];
} else {
  echo "0 results";
}
 $dispsqA=array();
$disssqA=array();
$pspsA=array();

 $disA=array();
$psA=array();
$reA=array();
$inoA=array();
for ($x = 0; $x <$i; $x++) {    
    
    $ino=0;
    $dis=0;
    $ps=0;
    $re=0;
    $dispsq=0;
    $disssq=0;
    $psps=0;


    $sql1 = "SELECT * FROM report WHERE P_ID ='$p[$x]' and Year ='$yt' " ; 

    $result = $conn->query($sql1);


    if ($result->num_rows > 0) {

      while($row = $result->fetch_assoc()) {

         if(($row["Activity"]=="DISPATCH")){
           $dis+=$row["Quantity"];
          $dispsq+=$row["PS_Quantity"];
           $disssq+= $row["SS_Quantity"];



      }
        if(($row["Activity"]=="INVOICE")){
           $ino+=$row["Quantity"];

      }
        if(($row["Activity"]=="PURCHASE")){
           $ps+=$row["Quantity"];
            $psps+=$row["PS_Quantity"];

      }
       if(($row["Activity"]=="RETURN")){
           $re+=($row["R_S_Quantity"]+$row["R_G_Quantity"]);

      } 
       
}
  // echo $ino, "<br>";
    } else {
          echo "0 results";
    }
    
     $dispsqA[$x]=$dispsq;
    $disssqA[$x]=$disssq;
    $pspsA[$x]= $psps;
    
     $disA[$x]=$dis;
    $psA[$x]=$ps;
    $reA[$x]=$re;
    $inoA[$x]=$ino;

}
    //$p[]
$conn->close();

    $dataPoints1 = array(
	array("label"=> $p[0], "y"=> $psA[0]),
	array("label"=> $p[1], "y"=> $psA[1]),
	array("label"=> $p[2], "y"=> $psA[2]),
	array("label"=> $p[3], "y"=> $psA[3]),
	array("label"=> $p[4], "y"=> $psA[4]),
	array("label"=> $p[5], "y"=> $psA[5])
);
$dataPoints2 = array(
	array("label"=> $p[0], "y"=> $disA[0]),
	array("label"=> $p[1], "y"=> $disA[1]),
	array("label"=> $p[2], "y"=> $disA[2]),
	array("label"=> $p[3], "y"=> $disA[3]),
	array("label"=> $p[4], "y"=> $disA[4]),
	array("label"=> $p[5], "y"=> $disA[5]),
);
$dataPoints3 = array(
	array("label"=> $p[0], "y"=> $inoA[0]),
	array("label"=> $p[1], "y"=>$inoA[1]),
	array("label"=> $p[2], "y"=> $inoA[2]),
	array("label"=> $p[3], "y"=> $inoA[3]),
	array("label"=> $p[4], "y"=> $inoA[4]),
	array("label"=> $p[5], "y"=> $inoA[5]),
);
$dataPoints4 = array(
	array("label"=> $p[0], "y"=> $reA[0]),
	array("label"=> $p[1], "y"=> $reA[1]),
	array("label"=> $p[2], "y"=> $reA[2]),
	array("label"=> $p[3], "y"=> $reA[3]),
	array("label"=> $p[4], "y"=> $reA[4]),
	array("label"=> $p[5], "y"=> $reA[5]),
);
        
?>



<!DOCTYPE HTML>
<html>
<head>  
<script>
window.onload = function () {
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2",
	title:{
		text: " Annually Report"
	},
	axisY:{
		includeZero: true
	},
	legend:{
		cursor: "pointer",
		verticalAlign: "center",
		horizontalAlign: "right",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "column",
		name: "Purcheseed",
		indexLabel: "{y}",
		yValueFormatString: "#0.##",
		showInLegend: true,
		dataPoints: <?php echo json_encode($dataPoints1, JSON_NUMERIC_CHECK); ?>
	},{
		type: "column",
		name: "Dispatched",
		indexLabel: "{y}",
		yValueFormatString: "#0.##",
		showInLegend: true,
		dataPoints: <?php echo json_encode($dataPoints2, JSON_NUMERIC_CHECK); ?>
	},{
		type: "column",
		name: "Invoiceed",
		indexLabel: "{y}",
		yValueFormatString: "#0.##",
		showInLegend: true,
		dataPoints: <?php echo json_encode($dataPoints3, JSON_NUMERIC_CHECK); ?>
	},{
		type: "column",
		name: "Returned",
		indexLabel: "{y}",
		yValueFormatString: "#0.##",
		showInLegend: true,
		dataPoints: <?php echo json_encode($dataPoints4, JSON_NUMERIC_CHECK); ?>
	}]
});
chart.render();
 
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
}
</script>
     
      <script src="../styles/a.js"></script>
        <style>
        .b{
  border:0;
  background: #00e6ac;
  display: block;
  margin: 20px ;
  text-align: center;
  border: 4px solid #0077b3;
  padding: 14px 40px;
  outline: none;
  color: black;
  border-radius: 20px;
  cursor: pointer;
font-weight: bold;
font-size: 16px;
    
}
.b:hover{
  background: #2ecc71;
}
    </style>
</head>
<body class="g">
  
    <input class="b" type="button" name="" id="b1" value="back" onclick="goBack()">
   <?php 
        
    $yr = $_POST['year'];
    $yt = (int)$yr;
    echo " Year - ",$yr, "<h4>";
    ?>   
<div id="chartContainer" style="height: 500px; width: 75%;"></div>
    
    
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    
    
    <?php
     error_reporting (E_ALL ^ E_NOTICE);
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "java";
    


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
$mon = $_POST['month'];
$yr = $_POST['year'];
$p=array();
$sql = "SELECT * FROM product";
$result = $conn->query($sql);
    
$i=0;
if ($result->num_rows > 0) {
 // echo "<table style='border: solid 1px black;'><tr><th>ID</th><th>No Of Items</th><th>No Of Packed Samples</th><th>Date</th></tr><caption>Stock Details</caption>";
  // output data of each row
  while($row = $result->fetch_assoc()) {
   // echo $row["P_ID"];
    $p[$i]=$row["P_ID"];
    $i++;  
  }
  //echo $p[2];
} else {
  echo "0 results";
}
 $dispsqA=array();
$disssqA=array();
$pspsA=array();

    
 $disA=array();
$psA=array();
$reA=array();
$inoA=array();
    
 $disV=array();
$psV=array();
$reV=array();
$inoV=array();    
for ($x = 0; $x <$i; $x++) {    
    
    $ino=0;
    $dis=0;
    $ps=0;
    $re=0;
    $inov=0;
    $disv=0;
    $psv=0;
    $rev=0;
    $dispsq=0;
    $disssq=0;
    $psps=0;


    $sql1 = "SELECT * FROM report WHERE P_ID ='$p[$x]' and Year ='2021' " ; 

    $result = $conn->query($sql1);


    if ($result->num_rows > 0) {

      while($row = $result->fetch_assoc()) {

         if(($row["Activity"]=="DISPATCH")){
           $dis+=$row["Quantity"];
          $dispsq+=$row["PS_Quantity"];
           $disssq+= $row["SS_Quantity"];
             $disv+=$row["Quantity"]*$row["Price"];


      }
        if(($row["Activity"]=="INVOICE")){
           $ino+=$row["Quantity"];
           $inov+= $row["Quantity"]*$row["Price"];

      }
        if(($row["Activity"]=="PURCHASE")){
           $ps+=$row["Quantity"];
            $psps+=$row["PS_Quantity"];
            $psv+= $row["Quantity"]*$row["Price"];

      }
       if(($row["Activity"]=="RETURN")){
           $re+=($row["R_S_Quantity"]+$row["R_G_Quantity"]);
         $rev+=($row["R_S_Quantity"]+$row["R_G_Quantity"])*$row["Price"];
      } 
       
}
   //echo $ino, "<br>";
    } else {
          echo "0 results";
    }
    
     $dispsqA[$x]=$dispsq;
    $disssqA[$x]=$disssq;
    $pspsA[$x]= $psps;
    
     $disA[$x]=$dis;
    $psA[$x]=$ps;
    $reA[$x]=$re;
    $inoA[$x]=$ino;
    
    $disV[$x]=$disv;
    $psV[$x]=$psv;
    $reV[$x]=$rev;
    $inoV[$x]=$inov;


}
     $disT=0;
       $psT=0;
       $reT=0;
       $inoT=0;
    for($k=0;$k<$i;$k++){
        $disT+=$disV[$k];
       $psT+=$psV[$k];
       $reT+=$reV[$k];
       $inoT+= $inoV[$k];
        
    }
    
  echo "<h2> All Details </h2>";
  echo  "<p> Total Purchesed Value : ",$psT,"<br>Total Dispatched Value : ",$disT,"<br>Total Invoiced Value : ",$inoT,"<br>Total Returned Value : ",$reT;
    
    
   for($j=0;$j<$i;$j++){
      
        echo " <br><h3>Product ID :",$p[$j],"</h3>Purchesed Value : ",$psV[$j]," <br>Dispatched Value : ",$disV[$j]," <br>Invoiced Value : ",$inoV[$j], " <br>Returned Value : ",$reV[$j]," <br>Purchesed Packed Samples Quantity : ",$pspsA[$j]," <br>Dispatched Packed Samples Quantity : " , $dispsqA[$j]," <br>Dispatched Sotck Samples Quantity : ",$disssqA[$j];
   } 
    //$p[]
$conn->close();


        
?>


</body>
</html>













