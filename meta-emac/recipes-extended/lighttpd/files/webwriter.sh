#! /bin/bash

# First checks to see if the filesystem is writable
# Exits if it is not
if [[ ! -w /www/pages/oe_info.html ]]; then
	# Exit with 1 since it wasn't able to write a new
	# html document.
	exit 1
fi

# Structure the begining contents of the html document
read -d '' HTML << "HERE_HTML"
<!DOCTYPE html>
<html lang="en-US">
<head>
<style>

body 
{
        margin: 0 auto;
        width: 940px;
        position: relative;
        background-color: #D8D8D8
}

iframe{
        /*border: none;*/
        text-align: center;
        height:350px;
        width:600px;
}

#NavBar
{
        display: inline-block;
    text-align: center;
    list-style-type: none;
    margin: 0 auto;
    width: 940px;
    position: relative;
    padding: 0;

}

#NavBar ul 
{
    display: inline-block;
    text-align: center;
    list-style-type: none;
    margin: 0 auto;
    width: 940px;
    position: relative;
    padding: 0;
    overflow: hidden;
}

li 
{
    display: inline-block;
    text-align: center;
    float: center;
    padding: 0;
}

#NavBar a:link, #NavBar a:visited 
{
    display: block;
    width: 176px;
    font-weight: bold;
    color: #FFFFFF;
    background-color: #44661f;
    text-align: center;
    padding: 4px;
    text-decoration: none;
    text-transform: uppercase;
}

#NavBar a:hover, #NavBar a:active 
{
    background-color: #7A991A;
}

table,th,td
{
  border:1px solid green;
}

th
{
  text-align: center;
  background-color: green;
  color: white;
  padding:5px;
}

.Left 
{
  text-align: left;
}

.Center
{
  text-align: center;
}

.Font
{
  font-family: arial;
  color: black;
}

.Header
{
  font-family: arial;
  color: #44661f;
}

.Link
{
  text-decoration: none;
}

.Footer
{
  text-align: right; 
  color: black; 
  position: fixed; 
  bottom: 0px; 
  height: 30px; 
  width: 940px;
}


h1 {color: #44661f;}

.indent{
        padding-left:5em;
        font-family:"courier new";
        border: 2px solid;
        border-radius: 15px;
        border-color: #44661f;
}
</style>

<title>Welcome to EMAC Embedded Linux 5.0</title>
</head>

<body link="blue" alink="#44661f" vlink="#1f1e80">

<h1 class="Center Header">Welcome to EMAC Embedded Linux 5.0</h1>

<img src="images/EMAC_LOGO.png" alt="EMAC Logo">

<ul id="NavBar">
  <li><a href="index.html">Home</a></li>
  <li><a href="arm.html">ARM Boards</a></li>
  <li><a href="x86.html">x86 Boards</a></li>
  <li><a href="about.html">About</a></li>
  <li><a href="oe_info.html">OE_INFO</a></li>
</ul>

<hr>

<h1 align="Center">OE_INFO Output</h2>
<p>Product information:</p>
<div class="indent">

HERE_HTML

echo $HTML > /www/pages/oe_info.html
echo "<br />" >> /www/pages/oe_info.html

# If /etc/oe_info exists, then insert each line
# of the text file between opening and closing
# <p> tags
if [[ -e /etc/oe_info ]]; then
	cat /etc/oe_info | while read line; do
	echo "<p>" >> /www/pages/oe_info.html
	echo $line >> /www/pages/oe_info.html
	echo "</p>" >> /www/pages/oe_info.html
	done
fi

# Finish the rest of the html document
read -d '' HTML << "HERE_HTML"
</div>
<p>The infomation above can be found in the text file <font face="courier new">/etc/oe_info</font> on your device.</p>
<footer class="Footer">Copyright 2014, &copy EMAC, Inc. All rights reserved</footer>

</body>
</html>


HERE_HTML
echo $HTML >> /www/pages/oe_info.html
exit 0
