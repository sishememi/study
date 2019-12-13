// 자바스크립트에서 객체를 생성.
// 콜벡함수에서 ajax 객체를 매개변수로 전달 방법.
var ajax = {} //객체
ajax.xhr = {} //객체2
//ajax.xhr.Request 객체 생성자 구현
//멤버변수  : url,params,callback,method,req
//멤버메서드 : send,getXmlHttpRequest,onStateChange
ajax.xhr.Request = function(url,params,callback,method){ //생성자
	this.url = url;
	this.params = params;
	this.callback = callback;
	this.method = method;
	this.send(); //send메서드 호출
}
//prototype : 멤버 구현.
ajax.xhr.Request.prototype = { 
		getXmlHttpRequest : function(){ //ajax 객체를 생성
			if(window.ActionXObject){
				try{
					 return new ActionXObject("Msxml2.XMLHTTP");
				}catch(e){
					try{
						return new ActionXObject("Microsoft.XMLHTTP");
					}catch(e2){return null;}
				}
			}else if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return null;
			}
		},
	send:function(){ //send 메서드 구현
		//this.req : ajax 객체 저장(전달)
		this.req = this.getXmlHttpRequest();
		var httpMethod = this.method?this.method:"GET";
		if(httpMethod != "GET" && httpMethod != "POST"){
			httpMethod = "GET";
		}
		var httpParams = (this.params == null || this.params == '')?null:this.params;
		var httpUrl = this.url;
		if(httpMethod == 'GET' && httpParams != null){
			httlUrl = httlUrl + "?" + httpParams;
		}
		//ajax 준비
		this.req.open(httpMethod,httpUrl,true);
		this.req.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); //서버에 전송을 하기 위한 Header 정보 설정
		//this : ajax.xhr.Request 객체
		var request = this;
		//onreadystatechange : 콜벡함수 등록(상태가 변경될때마다 자동으로 호출되는 함수)
		//call : 매개변수 설정
		this.req.onreadystatechange = function(){
			request.onStateChange.call(request);//onStateChange 호출시 request를 전달.
		}
		this.req.send(httpMethod=="POST"?httpParams:null);
	},
	onStateChange : function(){
		this.callback(this.req);//this.req = ajax객체 전달. 콜백함수 호출시 ajax 객체 전달.
	}
}