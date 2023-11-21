/**
 * 사용자 입력데이터 유효성검증 및 중복체크
 */
$(function(){

    // 아이디 입력데이터
    const inputUid    = document.getElementsByName('uid')[0];
    const resultUid        = document.getElementsByClassName('msgId')[0];
    const btnCheckUid = document.getElementById('btnCheckUid');

    if (btnCheckUid != null)
    {
        btnCheckUid.onclick = function(){

            const uid = inputUid.value;

            // 아이디 입력값 검사
            if (!uid.match(reUid))
            {
                resultUid.innerText = '아이디는 영문, 숫자로 4~12자까지만 가능합니다.';
                resultUid.style.color = 'red';
                isUidOk = false;
                return;
            }

            $.ajax({
                url: '/cinema/member/check/uid/'+uid,
                type: 'GET',
                dataType: 'json',
                success: function(data){
                    console.log('아이디 체크=====data : ' + data);
                    if (data > 0)
                    {
                        resultUid.innerText = '이미 사용중인 아이디입니다.'
                        resultUid.style.color = 'red';
                        isUidOk = false;
                    }
                    else
                    {
                        resultUid.innerText = '사용 가능한 아이디입니다.'
                        resultUid.style.color = 'green';
                        isUidOk = true;
                    }
                }
            });

        } // btnCheckUid.onclick end
    }

    /* 이메일 입력데이터는 authEmail.js에서 진행 */

    // 휴대폰번호 입력데이터
    $('input[name=hp]').focusout(function(){

        const hp  = $(this).val();

        // 휴대폰번호 입력값 검사
        if(!hp.match(reHp))
        {
            $('.msgHp').css('color', 'red').text('유효한 휴대폰번호가 아닙니다.');
            isHpOk = false;
            return;
        }

        if (hp == sameHp)
        {
            $('.msgHp').text('');
            isHpOk = true;
            return;
        }

        $.ajax({
            url: '/cinema/member/check/hp/'+hp,
            type: 'GET',
            dataType: 'json',
            success: function(data){
                console.log('전화번호 체크=====data : ' + data);
                if (data > 0)
                {
                    $('.msgHp').css('color', 'red').text('이미 사용중인 휴대폰번호입니다.');
                    isHpOk = false;
                }
                else
                {
                    $('.msgHp').css('color', 'green').text('사용 가능한 휴대폰번호입니다.');
                    isHpOk = true;
                }
            }
        });
    });

});