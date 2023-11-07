////////////////////////////////////////////////////////////
//////////////////////////파일 다운로드 ////////////////////
////////////////////////////////////////////////////////////
function downloadFile(fileFolder, fileName) {
	location.href = "/downloadFile.do?fileFolder=" + fileFolder + "&fileName=" + fileName;
}

//////////////////////////////////////////////////////////////
//////////////////////////페이징 처리 ////////////////////////
//////////////////////////////////////////////////////////////
function paging(pageNum) {
	$("#curPage").val(pageNum);
	$("#requestForm").submit();
}

//////////////////////////////////////////////////////////////
//////////////////////////검색 날짜 처리 /////////////////////
//////////////////////////////////////////////////////////////


/* 오늘 날짜를 문자열로 반환 */
function today() {
  var d = new Date();
  return getFormatDate(d);
}

/* 오늘로부터 1주일전 날짜 반환 */
function lastWeek() {
  var d = new Date();
  var dayOfMonth = d.getDate();
  d.setDate(dayOfMonth - 7);
  return getFormatDate(d);
}


/* 오늘로부터 1개월전 날짜 반환 */
function lastMonth(month) {
  var d = new Date()
  var monthOfYear = d.getMonth()
  d.setMonth(monthOfYear - month)
  return getFormatDate(d)
}

/* 날짜 객체 받아서 문자열로 리턴하는 함수 */
function getFormatDate(date){
	var year = date.getFullYear();             //yyyy
	var month = (1 + date.getMonth());         //M
	month = month >= 10 ? month : '0' + month; //MM 두자리로 저장
	var day = date.getDate();                  //d
	day = day >= 10 ? day : '0' + day;         //dd 두자리로 저장
	return  year + '-' + month + '-' + day;
}

//////////////////////////////////////////////////////////////
//////////////////////////숫자 검증 처리 /////////////////////
//////////////////////////////////////////////////////////////

/* 숫자이외값 입력 제한 (전화번호) */
function showKeyCode(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if( ( keyID >=48 && keyID <= 57 ) || ( keyID >=96 && keyID <= 105 ) || keyID == 8 || keyID == 9 || keyID == 46 || keyID == 37 || keyID == 39 ){
		return;
	}
	else{
		return false;
	}
}

/* 숫자형태 확인 (전화번호) */
function removeChar(event) {
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if ( keyID == 8 || keyID == 9 || keyID == 46 || keyID == 37 || keyID == 39 ) {
        return;

    } else {
        event.target.value = event.target.value.replace(/[^0-9]/g, "");
    }
}


//////////////////////////////////////////////////////////////
//////////////////////////메일 검증 처리 /////////////////////
//////////////////////////////////////////////////////////////
function mailValidate(mail){
	var regMail = /^(\w+)(.)(\w+)@(\w+)[.](\w+)([.](\w+)$|$)/ig
	if (mail.length < 6) return false;
	return regMail.test(mail);
}

