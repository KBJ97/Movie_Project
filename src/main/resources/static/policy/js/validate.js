/* claim_01.jsp(신분공개 동의여부 등 확인서) vaildation check */
function validateClaim01(){

	var ur_nm = $("#ur_nm").val().trim();
	var res_no1 = $("#res_no1").val().trim();
	var res_no2 = $("#res_no2").val().trim();
	var mobile = $("#mobile").val().trim();

	var bo_ur_nm = $("#bo_ur_nm").val().trim();
	var bo_res_no1 = $("#bo_res_no1").val().trim();
	var bo_res_no2 = $("#bo_res_no2").val().trim();
	var bo_mobile = $("#bo_mobile").val().trim();
	var bo_com_nm = $("#bo_com_nm").val().trim();
	var bo_mail1 = $("#bo_mail1").val().trim();
	var bo_mail2 = $("#bo_mail2").val().trim();
	var bo_addr_post = $("#bo_addr_post").val().trim();
	var bo_addr1 = $("#bo_addr1").val().trim();
	var bo_addr2 = $("#bo_addr2").val().trim();

	var agree1 = $("input:radio[name ='agree1']:checked").val();
	var agree2 = $("input:radio[name ='agree2']:checked").val();

	if(bo_ur_nm == ""){
		alert("성명은 필수 입력사항입니다.");
		$("#ur_nm").focus().select();
		return false;
	}else if(bo_res_no1 == ""){
		alert("주민등록번호는 필수 입력사항입니다.");
		$("#res_no1").focus().select();
		return false;
	}else if(bo_res_no2 == ""){
		alert("주민등록번호는 필수 입력사항입니다.");
		$("#res_no2").focus().select();
		return false;
	}else if(bo_mobile == ""){
		alert("연락처는 필수 입력사항입니다.");
		$("#mobile").focus().select();
		return false;
	}
	else if(bo_com_nm == ""){
		alert("소속은 필수 입력사항입니다.");
		$("#bo_com_nm").focus().select();
		return false;
	}else if(bo_mail1 == ""){
		alert("이메일은 필수 입력사항입니다.");
		$("#bo_mail1").focus().select();
		return false;
	}else if(bo_mail2 == ""){
		alert("이메일은 필수 입력사항입니다.");
		$("#bo_mail2").focus().select();
		return false;
	}else if(bo_addr_post == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#bo_addr_post").focus().select();
		return false;
	}
	else if(bo_addr1 == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#bo_addr1").focus().select();
		return false;
	}
	else if(bo_addr2 == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#bo_addr2").focus().select();
		return false;
	}
	else if(agree1 == "N"){
		//alert("신분공개 동의시에만 접수 가능합니다.");
		alert("그룹 내 조사과정 신분공개 동의시에만 접수 가능합니다.");
		return false;
	}else if(agree2 == "N"){
		//alert("신분공개 동의시에만 접수 가능합니다.");
		alert("타 조사기관 조사과정 신분공개 동의시에만 접수 가능합니다.");
		return false;
	}else{
		var answer = confirm("다음단계로 이동 하시겠습니까?");
		if (answer == true) {
			return true;
		}else{
			return false;
		}
	}
}

/* claim_01.jsp(신고서(제3자 신고용)) vaildation check */
function validateClaim02(){
	var nt_ur_nm = $("#nt_ur_nm").val().trim();
	var nt_mobile = $("#nt_mobile").val().trim();
	//var nt_addr_post = $("#nt_addr_post").val().trim();
	//var nt_addr1 = $("#nt_addr1").val().trim();
	var nt_addr2 = $("#nt_addr2").val().trim();
	var nt_purpose = $("#nt_purpose").val().trim();
	var nt_dt = $("#datepicker1").val().trim();
	var nt_place = $("#nt_place").val().trim();
	var nt_descript = $("#nt_descript").val().trim();

	if(nt_ur_nm == ""){
		alert("성명은 필수 입력사항입니다.");
		$("#nt_ur_nm").focus().select();
		return false;
	}else if(nt_mobile == ""){
		alert("연락처는 필수 입력사항입니다.");
		$("#nt_mobile").focus().select();
		return false;
	}

	else if(phoneValidate(nt_mobile) == false){
		alert("올바른 전화번호를 입력해주세요.");
		$("#nt_mobile").focus().select();
		return false;
	}

	/*else if(nt_addr_post == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#nt_addr_post").focus().select();
		return false;
	}
	else if(nt_addr1 == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#nt_addr1").focus().select();
		return false;
	}*/
	else if(nt_addr2 == ""){
		alert("주소는 필수 입력사항입니다.");
		$("#nt_addr2").focus().select();
		return false;
	}
	else if(nt_purpose == ""){
		alert("신고취지 및 이유는 필수 입력사항입니다.");
		$("#nt_purpose").focus().select();
		return false;
	}else if(nt_dt == ""){
		alert("법위반 일시는 필수 입력사항입니다.");
		$("#datepicker1").focus().select();
		return false;
	}else if(nt_place == ""){
		alert("법위반 장소는 필수 입력사항입니다.");
		$("#nt_place").focus().select();
		return false;
	}else if(nt_descript == ""){
		alert("법위반 내용은 필수 입력사항입니다.");
		$("#nt_descript").focus().select();
		return false;
	}else{
		var answer = confirm("제출 하시겠습니까?");
		if (answer == true) {
			return true;
		}else{
			return false;
		}
	}
}


//전화번호 검증
function phoneValidate(str){
	var regExp = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})?[0-9]{3,4}?[0-9]{4}$/;
	if(!regExp.test(str)) {
		//alert("올바른 전화번호를 입력하세요.");
		return false;

	}else{
		return true;
	}
}