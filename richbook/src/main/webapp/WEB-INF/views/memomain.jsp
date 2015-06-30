<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memo</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	function openContent() {
		$('.mw_layer').addClass('open');

		$('#layer').html();

		location.href = "#layer";

	}

	jQuery(function($) {

		var layerWindow = $('.mw_layer');

		// ESC Event

		$(document).keydown(function(event) {

			if (event.keyCode != 27)
				return true;

			if (layerWindow.hasClass('open')) {

				layerWindow.removeClass('open');

			}

			return false;

		});

		// Hide Window

		layerWindow.find('>.bg').mousedown(function(event) {

			layerWindow.removeClass('open');

			return false;

		});

	});
</script>

<style type="text/css">
table, td, th {
	border: 1px solid green;
}

th {
	background-color: green;
	color: white;
}

html, body {
	height: 100%;
	margin: 0
}

.mw_layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	z-index: 10000;
	width: 100%;
	height: 100%
}

.mw_layer.open {
	display: block
}

.mw_layer .bg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50)
}

#layer {
	position: absolute;
	top: 40%;
	left: 40%;
	width: 400px;
	height: 180px;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 2px solid #555;
	background: #fff;
	font-size: 12px;
	font-family: Tahoma, Geneva, sans-serif;
	color: #767676;
	line-height: normal;
	white-space: normal
}
</style>
</head>
<body>
	<fieldset>
	<legend>MEMO</legend>
	TODAY:${nowDate }
	<table border="1">
		<c:forEach items="${MemoList }" var="MemoList">
			<tr>
				<td>
				<!-- 오늘과 기한날을 비교해서 색으로 표현  -->
				<font 
				<c:if test="${nowDate > MemoList.memoDate }"> color="red"</c:if>
				<c:if test="${nowDate <= MemoList.memoDate }"> color="blue"</c:if>
				>
				
			
					 ${MemoList.content }<font size="2">(${MemoList.regdate })</font>
					 </font>
						
					<c:if test="${!empty MemoList.memoDate }">
						<!-- 만약 기한 값이 없으면 기한을 표기하지 않음 -->
						 &nbsp;&nbsp;-기한:${MemoList.memoDate }
					</c:if>

					<button
						onclick="location.href='MemoDel.do?memoNo=${MemoList.memoNo}'">삭제
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>



		<div class="mw_layer">
			<div class="bg"></div>
			<div id="layer">
				<!-- 이 사이에 작성을 하면 팝업의 내용이 들어간다.  -->

				<form action="MemoInsert.do">
					<table>
						<tr>
							<th colspan="2">입력</th>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea rows="2" cols="40" name="content"
									required="required"></textarea></td>
						</tr>
						<tr>
							<td>기한 설정</td>
							<td><input type="date" name="memoDate"> *필수 입력 아닙니다.</td>
						</tr>
					</table>
					<input type="submit" value="입력완료">
				</form>

			</div>
		</div>
		<!-- <a href="#layer" onclick="openContent()">aaaa</a> -->
		<button onclick="openContent()">작성</button>
	</fieldset>
</body>
</html>