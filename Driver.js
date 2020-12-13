function DriverValidation()
{
	var nm = document.forms["Driver"]["Drivername"].value;
	if(nm == "")
	{
		window.alert("Enter name");
		return false;
	}
	var re = /^[A-Za-z0-9_]/;
	len = nm.length;
	if(nm.match(re))
	{
		return true;
	}
	else
	{
		alert("Not a valid name");
		return false;
	}
}