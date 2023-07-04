<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹 프로그램에 대한 응답 결과 출력</div>
	<div>
		이름 : <input type="text" id="name">
		<button type="button" id="getBtn">GET 방식의 요청</button>
		<button type="button" id="postBtn">Post 방식의 요청</button>
	</div>

	<script type="text/javascript">
		//[GET방식의 요청] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
		document.getElementById("getBtn").onclick = function() {
			//입력태그의 입력값을 반환받아 저장
			var name = document.getElementById("name").value;

			// 입력값 검증
			if (name == "") { //자바스크립트에서는 null이 아닌 nullString [""]을 사용해야 함.
				document.getElementById("display").innerHTML = "이름을 입력해 주세요.";
				return;
			}

			//입력태그 초기화
			document.getElementById("name").value = "";

			//XMLHttpRequest 객체를 생성하여 저장
			var xhr = new XMLHttpRequest();

			//XMLHttpRequest객체의 준비상태가 변경될 때마다 호출될 이벤트 처리 함수 등록
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) { //XMLHttpRequest 객체에 응답결과가 전달된 경우
					if (xhr.status == 200) { // 정상 응답을 받은 경우
						document.getElementById("display").innerHTML = xhr.responseText;

					} else { // 정상적인 결과를 응답받지 못한경우 -> 상태코드 반환
						alert("error code = " + xhr.status);
					}
				}
			}
			//XMLHttpRequest 객체를 이용하여 JSP 문서를 GET 방식으로 요청
			// => GET 방식으로 웹 프로그램을 요청할 경우 질의 문자열(쿼리스트링)을 사용하여 값을 전달 함.
			name = encodeURIComponent(name);
			xhr.open("get", "data_two.jsp?name="+name, true); // true = 비동기식 요청
			xhr.send(null);
		}

		//[POST방식의 요청] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
		document.getElementById("postBtn").onclick = function() {
			//입력태그의 입력값을 반환받아 저장
			var name = document.getElementById("name").value;

			// 입력값 검증
			if (name == "") { //자바스크립트에서는 null이 아닌 nullString [""]을 사용해야 함.
				document.getElementById("display").innerHTML = "이름을 입력해 주세요.";
				return;
			}

			//입력태그 초기화
			document.getElementById("name").value = "";

			//XMLHttpRequest 객체를 생성하여 저장
			var xhr = new XMLHttpRequest();

			//XMLHttpRequest객체의 준비상태가 변경될 때마다 호출될 이벤트 처리 함수 등록
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) { //XMLHttpRequest 객체에 응답결과가 전달된 경우
					if (xhr.status == 200) { // 정상 응답을 받은 경우
						document.getElementById("display").innerHTML = xhr.responseText;

					} else { // 정상적인 결과를 응답받지 못한경우 -> 상태코드 반환
						alert("error code = " + xhr.status);
					}
				}
			}
			//문제) send 메소드를 사용하여 값 전달할 경우 [multipart/form-data]형식으로 값 전달 불가
			//=> 요청 웹 프로그램에서 request.getParameter() 메소드로 전달값 반환 불가
			//해결) 몸체부에 값을 담아 전달할 때에는 인코딩 data(문자형data)형식으로 전달하도록 함
			//=> [application/x-www-form-urlencoded] 형식으로 값이 전달되도록 리퀘스트 메세지 전달
			xhr.open("post", "data_two.jsp", true); //async 생략시 [true]로 설정되므로 생략 가능
			//리퀘스트 메세지 몸체부에 값을 전달하여 전달 = 헤더를 [application/x-www-form-urlencoded] 형식으로 변경하여 전달
			//XMLHttpRequest.setRequestHeader(header, value) : XMLHttpRequest 객체를 이용하여 
			// 프로그램 요청시 사용되는 리퀘스트 메세지의 헤더 정보를 변경하는 메서드
			//=> 리퀘스트 메세지 몸체부에 저장된 값이 문자 data로 표현되도록 설정
			//=> 반드시 open() 이후, send() 이전에 사용해야 함.
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			
			xhr.send("name=" + name); 
			
		}
	</script>
</body>
</html>
