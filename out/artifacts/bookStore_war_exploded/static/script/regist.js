function preRegist() {
    var unameTxt = $("unameTxt");
    //用户名不能为空为1-16
    var unameReg = /[\w]{1,16}/;
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    if(!unameReg.test(uname)) {
        unameSpan.style.visibility="visible";
        return false;
    } else {
        unameSpan.style.visibility="hidden";
    }

    var pwdTxt = $("pwdTxt");
    var pwd = pwdTxt.value;
    var pwdReg = /[\d]{3,16}/;
    var pwdSpan = $("pwdSpan");
    if(!pwdReg.test(pwd)) {
        pwdSpan.style.visibility="visible";
        return false;
    } else {
        pwdSpan.style.visibility="hidden";
    }
    if($("pwdTxt2").value!=$("pwdTxt").value) {
        $("pwdSpan2").style.visibility="visible";
        return false;
    } else {
        $("pwdSpan2").style.visibility="hidden";
    }


    var eamil = $("emailTxt").value;
    var emailSpan = $("emailSpan");
    var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    if(!emailReg.test(eamil)){
        emailSpan.style.visibility="visible";
        return false;
    } else {
        emailSpan.style.visibility="hidden";
    }
    return true;
}

function $(id) {
    return document.getElementById(id);
}


//如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function ckUname(uname){
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname ;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB ;
    //发送请求
    xmlHttpRequest.send();
}

function ckUnameCB(){
    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText ;
        // {'uname':'1'}
        //alert(responseText);
        if(responseText=="{'uname':'1'}"){
            alert("用户名已经被注册");
        }
    }
}
