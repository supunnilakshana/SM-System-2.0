<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>َRedirect</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>

<?php
	$name=$_POST["n"];
	$pw=$_POST["p"];
      
	if($name=="admin123" and $pw=="c21484"){
         header('location: http://localhost/javaAp/main/main.html');
		//echo '<h1>login sucessfull</h1><br><br>';
		//echo '<h1><a href="menus.html">Go to Menu</a><h1><br>';
	}else{
        header('location: http://localhost/javaAp/logr.html');
		//echo '<h1>invalid user name or password</h1>';
		//echo '<h1><a href="http://localhost/apex/login.html">Try Again!! </a><h1>';
	}
	

?>

  </body>
</html>
