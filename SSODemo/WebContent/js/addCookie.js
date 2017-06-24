window.onload=function(){
	if(getcookie("SSOCookie")) return ;
	for(var i=0;i<2;i++){
	var request=new XMLHttpRequest();
	var url=document.getElementById(i);
	request.open("GET",url.value+"?addId="+document.getElementsByName("addId")[0].value,true);
	request.send();
	request.onstagechange=function(){
		if(request.readystage===4){
			if(request.status===200){
				alert("Success");
			}else{
				alert("ERROR:"+request.status);
			}
		}
	}
	}
}

function getcookie(objname){//获取指定名称的cookie的值
	var arrstr = document.cookie.split("; ");
	for(var i = 0;i < arrstr.length;i ++){
	var temp = arrstr[i].split("=");
	if(temp[0] == objname) return true
	}
	}