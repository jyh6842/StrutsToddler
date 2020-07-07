<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var flag = true;
			$('input[type=file]').each(function(idx, inputTag){ // 인덱스랑 인풋태그를 가져온다.
				if(!/\.(jpg|jpeg|png|gif)$/.test($(inputTag).val().toLowerCase())){ // \. 를 통해서 .이라는 의미로 가져올수 있게 한다.
					alert('이미지 파일 대상 업로드'); 
					flag = false;
				}
			});
			return flag;
		});
	});
</script>
</head>
<body>
<!-- 
	클라이언트의 파일 업로드 처리 : 쿼리스트링 전송 방식 - POST
						  content type = multipart/form-data
						  <form/>
						  ajax
						  * 바이너리 스트리밍을 통한 서버 전송 처리
						    (폼 필드 - mem_id, mem_pass, ...
						           파일)
 -->
<form action="${pageContext.request.contextPath }/file/fileUpload.do"
	method="post" 
	enctype="multipart/form-data"> <!-- application/x-www-form-urlencoded 그냥 일반 전송 처리 파일 업로드를 하기 위해서는 multipart/form-data 써야한다. -->
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mem_id"/></td>
		</tr>
		<tr>
		<tr>
			<td>패스워드</td>
			<td><input type="text" name="mem_pass"/></td>
		</tr>
		<tr>
			<td>성명</td>
			<td><input type="text" name="mem_name"/></td>
		</tr>
		<tr>
			<td>파일1</td>
			<td><input type="file" name="files"/></td>
		</tr>
		<tr>
			<td>파일2</td>
			<td><input type="file" name="files"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="전송"/></td>
		</tr>
	</table>
</form>
<img alt="" src="/files/${param.fileName }" 
	onclick="javascript:location.href='${pageContext.request.contextPath}/file/fileDownload.do?fileName=${param.fileName }'">
</body>
</html>