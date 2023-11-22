/**
 * 사용자 입력데이터 유효성검증
 */

// 폼 데이터 검증결과 상태변수
let isUidOk       = false;
let isPassOk      = false;
let isNameOk      = false;
let isEmailOk     = false;
let isJuminOk     = false;
let isHpOk        = false;

// 데이터 검증에 사용하는 정규표현식
const reUid     = /^[A-Za-z0-9]{4,12}$/;
const rePass    = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,12}$/;
const reName    = /^[가-힣]{2,10}$/
const reHp      = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

// 유효성검증 (Validation)
$(function(){

    // 아이디 유효성검증 후 다시 포커스해서 수정 방지
    $('input[name=uid]').keydown(function(){

        $('.msgId').css('color', 'black').text('영문, 숫자로 4~12자까지 설정해 주세요.');
        isUidOk = false;
    });

    // 비밀번호 입력값 검사
    $('input[name=pass2]').focusout(function(){

        const pass1 = $('input[name=pass1]').val();
        const pass2 = $('input[name=pass2]').val();

        if (pass1 == pass2)
        {
            if (pass1.match(rePass))
            {
                $('.msgPass2').css('color', 'green').html('<i class="fas fa-check"></i> ');
                isPassOk = true;
            }
            else
            {
                $('.msgPass2').css('color', 'red').text('비밀번호는 영문, 숫자, 특수문자 조합 8~12자리여야합니다.');
                isPassOk = false;
            }
        }
        else
        {
            $('.msgPass2').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
            isPassOk = false;
        }
    });

    // 비밀번호 유효성검증 후 다시 포커스해서 수정 방지
    $('input[name=pass1]').keydown(function(){

        $('.msgPass2').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
        isPassOk = false;
    });

    // 이름 입력값 검사
    $('input[name=name]').focusout(function(){

        const name = $(this).val();

        if (!name.match(reName))
        {
            $('.resultName').css('color', 'red').text('이름 입력은 한글로만 가능합니다.');
            isNameOk = false;
        }
        else
        {
            $('.resultName').css('color', 'green').html('<i class="fas fa-check"></i> ');
            isNameOk = true;
        }
    });


    // 주민등록번호 유효성검증
    $('input[name=birth]').on('input', function () {
        // 입력값이 숫자가 아니거나 0~9 사이의 값이 아닌 경우
        if (!/^[0-9]$/.test(this.value)) {
            this.value = this.value.replace(/[^0-9]/g, ''); // 0~9 이외의 문자 제거
        }
        validateJumin();
    });

    // gender도 추가로 설정
    $('input[name=gender]').on('input', function () {
        // 입력값이 숫자가 아니거나 1~4 사이의 값이 아닌 경우
        if (!/^[1-4]$/.test(this.value)) {
            this.value = this.value.replace(/[^1-4]/g, ''); // 1~4 이외의 문자 제거
        }
        validateJumin();
    });

    // 주민등록번호 유효성 검증 함수
    function validateJumin() {
        const birth = $('input[name=birth]').val();
        const gender = $('input[name=gender]').val();

        // 입력값이 유효한 경우
        if (isValidDate(birth) && gender.length === 1) {
            $('.msgJn').css('color', 'green').html('<i class="fas fa-check"></i> ');
            isJuminOk = true;
        } else {
            $('.msgJn').css('color', 'red').text('올바른 주민번호를 입력하세요.');
            isJuminOk = false;
        }
    };

    // 주민등록번호의 날짜 부분이 유효한지 검증하는 함수
    function isValidDate(date) {
        // 날짜가 6자리 숫자인지 확인
        if (/^\d{6}$/.test(date)) {
            const year = parseInt(date.substring(0, 2), 10);
            const month = parseInt(date.substring(2, 4), 10);
            const day = parseInt(date.substring(4, 6), 10);

            // 실제 존재하는 날짜인지 확인
            const isValidYear = year >= 00 && year <= 99;
            const isValidMonth = month >= 1 && month <= 12;
            const daysInMonth = new Date(year + 2000, month, 0).getDate();
            const isValidDay = day >= 1 && day <= daysInMonth;

            return isValidYear && isValidMonth && isValidDay;
        }

        return false;
    };

    // 휴대폰번호 유효성 검증 함수
    function formatPhoneNumber() {
        var phoneNumber = document.getElementById("hp").value.replace(/[^0-9]/g, ''); // 입력된 숫자만 추출

        // 숫자가 없으면 아무 처리하지 않음
        if (!phoneNumber) {
            return;
        }

        // 휴대폰 번호를 xxx-xxxx-xxxx 형식으로 변환
        var formattedPhoneNumber = phoneNumber.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");

        // 변환된 형식으로 다시 입력란에 적용
        document.getElementById("hp").value = formattedPhoneNumber;

        // reHp 패턴과 비교하여 일치 여부 확인
        validatePhoneNumber(formattedPhoneNumber);
    }

    function validatePhoneNumber(phoneNumber) {
        // 유효성 검사를 위해 reHp 패턴과 비교
        if (reHp.test(phoneNumber)) {
            $('.msgHp').css('color', 'green').html('<i class="fas fa-check"></i> ');
            isHpOk = true;
        } else {
            $('.msgHp').css('color', 'red').text('유효한 휴대폰번호가 아닙니다.');
            isHpOk = false;
        }
    }

    // "input" 이벤트에서 formatPhoneNumber 함수를 트리거
    $('#hp').on('input', formatPhoneNumber);

    // "focusout" 이벤트에서 유효성 검사를 트리거 ==                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         =
    $('input[name=hp]').focusout(function () {
        validatePhoneNumber($(this).val());
    });

    // 회원가입 최종 전송
    $('#formMember').submit(function(){

        if (!isUidOk)
        {
            alert('아이디를 확인하십시오.');
            return false; // 폼 전송 취소
        }
        if (!isPassOk)
        {
            alert('비밀번호를 확인하십시오.');
            return false; // 폼 전송 취소
        }
        if (!isNameOk)
        {
            alert('이름을 확인하십시오.');
            return false; // 폼 전송 취소
        }
        if (!isJuminOk) {
            alert('주민등록번호를 확인하십시오.');
            return false; // 폼 전송 취소
        }
        if (!isHpOk)
        {
            alert('전화번호를 확인하십시오.');
            return false; // 폼 전송 취소
        }

        return true; // 폼 전송 시작
    });

});