<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연성대학교 수강신청 장바구니</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<STYLE TYPE="text/css">
<!--
DIV {
	border: solid;
	margin-top: 3%;
	margin-left: 3%;
	width: 650pt;
	height: 400pt;
	overflow: scroll
}

.padding1 {
	padding-top: 5pt;
	padding-right: 5pt;
	padding-bottom: 5pt;
	padding-left: 5pt
}

.padding2 {
	position: fixed;
	top: 120px;
	right: 20px;
	width: 430pt;
	height: 400pt;
	display: inline-block;
}

.bgcolor1 {
	background-color: #BBDEFB;
}

.stuinfo_tbl {
	font-size: 15px;
}

.data_tbl {
	margin: 0 0 0 -1px;
	border-top: 2px solid #005AAB;
	width: 100%;
	border-collapse: collapse
}

.data_tbl thead th {
	padding: 6px 0;
	color: #333;
	background: #f8f8f8;
	border-bottom: 1px solid #AAA;
	border-left: 1px solid #dddee2;
	text-align: center;
}

.data_tbl tbody th {
	padding: 9px 10px 10px;
	background: #f8f8f8;
	text-align: right;
	border-bottom: 1px solid #dddee2;
}

.data_tbl td {
	padding: 9px 7px 10px;
	border-left: 1px solid #dddee2;
	border-bottom: 1px solid #dddee2;
	text-align: center;
	font-size: 12px;
	letter-spacing: -1px;
	word-break: keep-all;
}

.data_tbl .last td, .data_tbl .last th {
	border-bottom: 2px solid #AAA;
}

.data_tbl tbody tr:hover {
	background: #f6f6f6;
}

.data_tbl td.th_code {
	font-size: 11px;
	font-family: tahoma;
}

.data_tbl td.th_tit {
	color: #eee;
	font-weight: bold;
}

.data_tbl .c-btn04, .data_tbl02 .c-btn04 {
	vertical-align: middle;
}

.data_tbl .c-btn04 span, .data_tbl02 .c-btn04 span {
	vertical-align: top;
}

.data_tbl02 {
	margin: 0 0 0 -1px;
	border-top: 2px solid #005AAB;
	width: 100%;
	border-collapse: collapse
}

.data_tbl02 tbody th {
	padding: 12px 10px;
	background: #f8f8f8;
	text-align: right;
	border-bottom: 1px solid #dddee2;
}

.data_tbl02 td {
	padding: 12px 10px;
	border-left: 1px solid #dddee2;
	border-bottom: 1px solid #dddee2;
}

.data_tbl02 .last td, .data_tbl02 .last th {
	border-bottom: 2px solid #AAA;
}

.t_non {
	border-top: none
}

.inner_tbl {
	width: 100%;
	border-collapse: collapse
}

.inner_tbl tbody th {
	padding: 10px;
	background: #fafafa;
	text-align: center;
	border-bottom: 1px solid #dddee2;
}

.inner_tbl td {
	padding: 10px;
	border-left: 1px solid #dddee2;
	border-bottom: 1px solid #dddee2;
}

.data_tbl02 .inner_tbl td, .data_tbl02 .inner_tbl th {
	border-bottom: 1px solid #dddee2;
}
-->
</STYLE>

</head>
<body>
	<h1 class="bgcolor1">
		<body onresize="parent.resizeTo(1920,1080)"
			onload="parent.resizeTo(1920,1080)">
			<IMG
				SRC="${pageContext.request.contextPath}/resources/images/YSUicon.ico"
				WIDTH="120" ALIGN="MIDDLE">
			<FONT SIZE="8" FACE="Malgun Gothic"> 연성대학교 수강신청 장바구니</FONT>
			<table border="2" width="300" height="100" align="right"
				class="stuinfo_tbl">
				<tr>
					<th>과</th>
					<th>학년</th>
					<th>반</th>
					<th>이름</th>
				</tr>
				<tr>
					<td>${stdInfo.department}</td>
					<td>${stdInfo.hak}</td>
					<td>${stdInfo.ban}</td>
					<td>${stdInfo.name}</td>
				</tr>
			</table>
	</h1>
	<form action="subreg" method="post">
		<span style="float: right"><input name="logout" type="submit"
			value="로그아웃"> </span>
	</form>
	<div id="div11" class="padding2">
		<!-- 시간표테이블  -->
		<center>
			<b> 시 간 표 </b>
		</center>
		<table id="timeTable" border="1" class="table-light data_tbl">
			<colgroup>
				<col width="75px">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th width="75px" scope="col"></th>
					<th width="75px" scope="col">월</th>
					<th width="75px" scope="col">화</th>
					<th width="75px" scope="col">수</th>
					<th width="75px" scope="col">목</th>
					<th width="75px" scope="col">금</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1교시<br> 0 9 : 3 0 - 1 0 : 2 0
					</td>
					<td id="mon1"></td>
					<td id="tue1"></td>
					<td id="wen1"></td>
					<td id="thu1"></td>
					<td id="fri1"></td>
				</tr>
				<tr>
					<td>2교시<br> 1 0 : 3 0 - 1 1 : 2 0
					</td>
					<td id="mon2"></td>
					<td id="tue2"></td>
					<td id="wen2"></td>
					<td id="thu2"></td>
					<td id="fri2"></td>
				</tr>
				<tr>
					<td>3교시<br> 1 1 : 3 0 - 1 2 : 2 0
					</td>
					<td id="mon3"></td>
					<td id="tue3"></td>
					<td id="wen3"></td>
					<td id="thu3"></td>
					<td id="fri3"></td>
				</tr>
				<tr>
					<td>4교시<br> 1 2 : 3 0 - 1 3 : 2 0
					</td>
					<td id="mon4"></td>
					<td id="tue4"></td>
					<td id="wen4"></td>
					<td id="thu4"></td>
					<td id="fri4"></td>
				</tr>
				<tr>
					<td>5교시<br> 1 3 : 3 0 - 1 4 : 2 0
					</td>
					<td id="mon5"></td>
					<td id="tue5"></td>
					<td id="wen5"></td>
					<td id="thu5"></td>
					<td id="fri5"></td>
				</tr>
				<tr>
					<td>6교시<br> 1 4 : 3 0 - 1 5 : 2 0
					</td>
					<td id="mon6"></td>
					<td id="tue6"></td>
					<td id="wen6"></td>
					<td id="thu6"></td>
					<td id="fri6"></td>
				</tr>
				<tr>
					<td>7교시<br> 1 5 : 3 0 - 1 6 : 2 0
					</td>
					<td id="mon7"></td>
					<td id="tue7"></td>
					<td id="wen7"></td>
					<td id="thu7"></td>
					<td id="fri7"></td>
				</tr>
				<tr>
					<td>8교시<br> 1 6 : 3 0 - 1 7 : 2 0
					</td>
					<td id="mon8"></td>
					<td id="tue8"></td>
					<td id="wen8"></td>
					<td id="thu8"></td>
					<td id="fri8"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="padding1">
		<center>장바구니</center>
		<table class="data_tbl"
			summary="코드, 과정명, 요일, 시간, 강의기간, 정원, 수강료, 강사명을 나타낸 표입니다.">
			<colgroup>
				<col width="75px">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th rowspan="2" scope="col">코드</th>
					<th rowspan="2" scope="col">교과목명</th>
					<th rowspan="2" scope="col">학점</th>
					<th rowspan="2" scope="col">분반</th>
					<th rowspan="2" scope="col">요일</th>
					<th rowspan="2" scope="col">강의시간</th>
					<th rowspan="2" scope="col">교수명</th>
					<th rowspan="2" scope="col">장바구니신청인원</th>
					<th rowspan="2" scope="col">정원</th>
					<th rowspan="2" scope="col">이수구분</th>
					<th rowspan="2" scope="col">교과목수준</th>
					<th rowspan="2" scope="col">취소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${basketList}">
					<form action="subbasket" method="post">
						<tr>
							<td><input type="text" value="${item.kmId}"
								name="deletebasket"
								style="border: 0; background-color: transparent; text-align: center; width: 100%;"
								readonly /></td>
							<td>${item.kmName}</td>
							<td>${item.kmHak}</td>
							<td>${item.kmBan}</td>
							<td>${item.kmDay}</td>
							<td>${item.kmTime}</td>
							<td>${item.kmProf}</td>
							<td>${item.kmCountBasket}</td>
							<td>${item.kmLimit}</td>
							<td>${item.kmIsu}</td>
							<td>${item.kmGrade}</td>
							<td><button type="submit"
									class="btn btn-sm btn-primary btn-block">장바구니취소</button></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="padding1" id="div1">
		<center>개설강좌</center>
		<table class="data_tbl"
			summary="코드, 과정명, 요일, 시간, 강의기간, 정원, 수강료, 강사명을 나타낸 표입니다.">
			<colgroup>
				<col width="75px">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th rowspan="2" scope="col">코드</th>
					<th rowspan="2" scope="col">교과목명</th>
					<th rowspan="2" scope="col">학점</th>
					<th rowspan="2" scope="col">분반</th>
					<th rowspan="2" scope="col">강의시간</th>
					<th rowspan="2" scope="col">요일</th>
					<th rowspan="2" scope="col">교수명</th>
					<th rowspan="2" scope="col">장바구니신청인원</th>
					<th rowspan="2" scope="col">정원</th>
					<th rowspan="2" scope="col">이수구분</th>
					<th rowspan="2" scope="col">교과목수준</th>
					<th rowspan="2" scope="col">신청</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${subjectList}">
					<form action="subbasket" method="post">
						<tr>
							<td><input type="text" value="${item.kmId}"
								name="insertbasket"
								style="border: 0; background-color: transparent; text-align: center; width: 100%;"
								readonly /></td>
							<td>${item.kmName}</td>
							<td>${item.kmHak}</td>
							<td>${item.kmBan}</td>
							<td>${item.kmDay}</td>
							<td>${item.kmTime}</td>
							<td>${item.kmProf}</td>
							<td>${item.kmCountBasket}</td>
							<td>${item.kmLimit}</td>
							<td>${item.kmIsu}</td>
							<td>${item.kmGrade}</td>
							<td><button type="submit" onclick="div1.reload"
									class="btn btn-sm btn-primary btn-block">장바구니담기</button></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 시간표에 과목명 넣는 스크립트 -->
	<script type="text/javascript">
		(function() {
			var listDay = new Array(); // 강의요일 배열
			var listStartTime = new Array(); // 강의시작교시 배열
			var listEndTime = new Array(); // 강의마지막교시 배열
			var listSubjectName = new Array(); // 과목이름 배열
			var listProfessorName = new Array(); // 교수이름 배열
			var listDivision = new Array(); // 전공/교양여부 배열
			var color = new Array("#dc3545", "#fd7e14", "#ffc107", "#28a745",
					"#007bff", "#20c997", "#17a2b8", "#e83e8c", "#6610f2"); // 배경색 배열

			<c:forEach var="result" items="${baskettimeTable}"> // result 라는 이름으로 timeTable 세션의 리스트를 받아옴
			var jsonDay = new Object(); // Object 형으로 강의요일 자료를 담을 객체 생성
			var jsonStartTime = new Object(); // Object 형으로 강의시작교시 자료를 담을 객체 생성
			var jsonEndTime = new Object(); // Object 형으로 강의마지막교시 자료를 담을 객체 생성
			var jsonSubjectName = new Object(); // Object 형으로 과목이름 자료를 담을 객체 생성
			var jsonProfessorName = new Object(); // Object 형으로 교수이름 자료를 담을 객체 생성
			var jsonDivision = new Object(); // 

			jsonDay = "${result.day}"; // jsonDay 객체에 강의요일 저장
			jsonStartTime = "${result.startTime}"; // jsonStartTime 객체에 강의시작시간 저장
			jsonEndTime = "${result.endTime}"; // jsonEndTime 객체에 강의마지막시간 저장
			jsonSubjectName = "${result.kmName}"; // jsonSubjectName 객체에 과목이름 저장
			jsonProfessorName = "${result.profName}"; // jsonProfessorName 객체에 교수이름 저장
			jsonDivision = "${result.kmIsu}";

			listDay.push(jsonDay); // listDay 배열에 강의요일 입력
			listStartTime.push(jsonStartTime); // listStartTime 배열에 강의시작시간 입력
			listEndTime.push(jsonEndTime); // listEndTime 배열에 강의마지막시간 입력
			listSubjectName.push(jsonSubjectName); // listSubjectName 배열에 과목이름 입력
			listProfessorName.push(jsonProfessorName); // listProfessorName 배열에 교수이름 입력
			listDivision.push(jsonDivision);
			</c:forEach>

			var tdid; // 시간표 각 칸의 아이디를 참조하기 위한 변수
			var day; // 강의요일을 변수로 저장하기 위한 객체
			var intTdid = 0; // 강의교시를 변수로 저장하기 위한 객체
			var timena = 0; // 강의소요시간 계산을 위한 객체

			for (var i = 0; i < listDay.length; i++) { // listDay와 나머지 배열의 length는 같음. 배열의 길이만큼 반복문 실행
				parseInt(listEndTime[i]); // 강의마지막시간 Integer
				parseInt(listStartTime[i]); // 강의시작시간 Integer
				timena = listEndTime[i] - listStartTime[i]; // 강의소요시간 - 1
				switch (listDay[i]) { // 강의요일 변수에 저장(각 td의 id에 맞는 값으로)
				case "월": // 월 >> mon
					day = "mon";
					break;
				case "화": // 화 >> tue
					day = "tue";
					break;
				case "수": // 수 >> wen
					day = "wen";
					break;
				case "목": // 목 >> thu
					day = "thu";
					break;
				case "금": // 금 >> fri
					day = "fri";
					break;
				default: // 기본값
					day = "";
					break;
				}

				for (var j = 0; j <= timena; j++) { // 강의소요시간만큼 반복문 실행 
					intTdid = parseInt(listStartTime[i]) + j; // 해당과목 교시 (시작교시~마지막교시 까지 증가함)
					tdid = day + intTdid; // 각 td의 id 형식으로 변수저장 ( ex)mon1, fri5 )
					var addTable = document.getElementById(tdid); // 해당과목의 요일과 교시와 일치하는 td를 addTable로 지정
					/*for (var k = 0; k < listDivision.length; k++) {
					   if (listDivision[i].indexOf("전공") != -1) { // td에 과목별 배경색 설정
					      if (listDivision[i].indexOf("필수") != -1) {
					      addTable.bgColor = color[0]; // 전공선택
					      } else {
					         addTable.bgColor = color[1]; // 전공필수
					      }
					   } else {
					       addTable.bgColor = color[2]; // 교양
					   }
					}*/
					addTable.style.background = color[i];
					//addTable.style.opacity = "0.8"; // td 색 투명도 설정
					addTable.innerHTML = "<b>" + listSubjectName[i]
							+ "</b><br>교수 : " + listProfessorName[i]; // td에 과목이름, 교수이름 입력
				}
			}
		})()
	</script>
</body>
</html>