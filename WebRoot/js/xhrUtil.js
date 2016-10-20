function getXhr() {
	var xmlHttp;
	// firefox, opera 8.0+, safari
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// IE
		try{
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");				
			}catch(e){
				alert("your browser not support AJAX!");
				return null;
			}
		}
	}
	return xmlHttp;
}