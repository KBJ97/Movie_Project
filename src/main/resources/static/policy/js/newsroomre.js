   var sendBoo = false;
        var filePointer = new Array("X","X","X","X","X");

        $(document).ready(function(){

            $(".selectbox").selectbox();
            radiodesign();
            inputdesign();
            checkboxdesign();

            ////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////// 추가버튼 이벤트 /////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////
            $('#btn_add').click(function(e) {

                var size = $("#fileList option").length;
                if (size >= 5) {
                    alert("파일 첨부는 최대 5개까지만 가능합니다");
                    return;
                }
                ///////////////////////////////////////////
                //////////////////빈 파일값 찾기///////////
                ///////////////////////////////////////////

                for(var i=0; i<5; i++){
                    if(filePointer[i] == "X"){
                        $("#file" + (i+1)).click();
                        break;
                    }
                }
                ///////////////////////////////////////////

            });

            // 삭제버튼 이벤트
            $('#btn_del').click(function(e) {

                // 기존 select list 삭제처리
                $('#fileList option').each(function() {
                    if ($(this).is(':checked') == true){
                        var index = $("#fileList > option:selected").val();

                        filePointer[index] = "X";
                        // 기존 input 데이터 삭제처리
                        $(this).remove();

                        var idx = Number(index) + 1;

                        $("#fileDiv"+idx).html("<input type='file' id='file" + idx + "' name='upload' style='display: none;' onchange='javascript:fileChange("+ idx + ");'/>");
                    }
                });
            });
        });

        /* 대상회사 지정/미지정 체크 */
        function comDisableChk(){

            if($("input:checkbox[id='inf_com_chk']").is(":checked") == true){

                $("#inf_com_idx").selectbox("detach");
                $("#inf_com_idx").val("");
                $("#inf_com_idx").selectbox("attach");

                $("#inf_com_idx").selectbox("disable");
            }else{

                $("#inf_com_idx").selectbox("enable");
            }
        }

        /* 메일 selectbox 선택 */
        function mailSelect(){
            var mailHost = $("#inf_wb_mail3").val();
            if(mailHost != ""){
                $("#inf_wb_mail2").val(mailHost);
                $("#inf_wb_mail2").attr("readonly", true);
            }else{
                $("#inf_wb_mail2").val("");
                $("#inf_wb_mail2").attr("readonly", false);
            }
        }

        //////////////////////////////////////////////////////////////
        /////////////////////////// 첨부파일 /////////////////////////
        //////////////////////////////////////////////////////////////

        function fileChange(fileNum) {
            var fileId = "file" + fileNum;
            var filePath = $("#file"+fileNum).val();
            var filePathWord = filePath.split("\\");
            var fileName = filePathWord[filePathWord.length - 1];

            if (checkExistFile(fileName, fileNum) == true
                    && checkFileName(fileName) == true
                    && checkFileExtension(fileName) == true
                    && fileSizeCheck(fileNum) == true) {

                filePointer[(fileNum - 1)] = "Y";

                //alert(filePointer);

                var optionAdd = "<option value='" + (fileNum - 1) + "'>"+ fileName + "</option>";
                $("#fileList").append(optionAdd);


            } else {
                // 기존 input 데이터 삭제처리
                $("#fileDiv" + fileNum).html( "<input type='file' id='file" + fileNum + "' name='upload' style='display: none;' onchange='javascript:fileChange(" + fileNum + ");'/>");
            }
        }



        //////////////////////////////////////////////////////
        ////////////// 중복파일명 처리 추가 //////////////////
        //////////////////////////////////////////////////////
        function checkExistFile(fileName, fileNum) {

            var fileSize = $("#fileList option").length;
            var existFile = "";
            for (var i = 0; i < fileSize; i++) {
                existFile = $("#fileList option:eq(" + i + ")").text();

                if (existFile == fileName) {
                    alert("동일한 파일명은 등록하실 수 없습니다.");

                    return false;
                }
            }
            return true;
        }


        //////////////////////////////////////////////////////
        ////////////// 파일명 특수기호 체크 //////////////////
        //////////////////////////////////////////////////////

        function checkFileName(file){
            var fileLen = file.split("\\").length - 1;
            var fileName = file.split("\\")[fileLen];

            if (fileName != "") {
                var chktext = /[\{\}\[\]\/?,;:|\)*~`!^\+<>@\#$%&\\\=\(\'\"]/gi
                if (chktext.test(fileName)) {
                    alert("파일 이름에 '_','-'이외의 특수문자는 포함될 수 없습니다.");
                    return false;
                }else{
                    return true;
                }
            }
        }

        //////////////////////////////////////////////////////
        //////////////////파일 확장자 체크 ///////////////////
        //////////////////////////////////////////////////////
        function checkFileExtension(file) {
            var fileExt = file.substring(file.lastIndexOf('.') + 1); // 파일의 확장자
            if (fileExt.toUpperCase() == "TXT" || fileExt.toUpperCase() == "DOC" || fileExt.toUpperCase() == "DOCX"
                    || fileExt.toUpperCase() == "WMA" || fileExt.toUpperCase() == "WAV" || fileExt.toUpperCase() == "MP3" || fileExt.toUpperCase() == "AAC"
                    || fileExt.toUpperCase() == "FLAC"|| fileExt.toUpperCase() == "OGG"
                    || fileExt.toUpperCase() == "GIF" || fileExt.toUpperCase() == "JPG"  || fileExt.toUpperCase() == "JPEG" || fileExt.toUpperCase() == "PNG"
                    || fileExt.toUpperCase() == "AVI" || fileExt.toUpperCase() == "WMV"  || fileExt.toUpperCase() == "ASF"  || fileExt.toUpperCase() == "FLV"
                    || fileExt.toUpperCase() == "MPEG"|| fileExt.toUpperCase() == "MOV"  || fileExt.toUpperCase() == "MP4" || fileExt.toUpperCase() == "M4A" ){
                return true;
            } else {
                alert(fileExt + "등록 가능한 파일 확장자가 아닙니다.\n문서(TXT, DOC, DOCX), 사운드, 동영상 파일만 업로드 가능합니다.");

                return false;
            }
        }

        //////////////////////////////////////////////////////
        //////////////////파일 사이즈 체크 ///////////////////
        //////////////////////////////////////////////////////
        function fileSizeCheck(fileNum) {

            var fileId = "file" + fileNum;

            var maxSize = 20 * 1024 * 1024;//20MB
            var fileSize = document.getElementById(fileId).files[0].size;

            if (fileSize > maxSize) {
                alert("첨부파일 크기는 20MB 이내로만 등록 가능합니다.");
                return false;
            } else {
                return true;
            }
        }


        /* 신고접수 등록 */
        /*function boardRegist() {

            if(sendBoo == false){
                sendBoo = true;

                var inf_com_idx = $.trim($("#inf_com_idx").val());
                var inf_title = $.trim($("#inf_title").val());
                var inf_descript = $.trim($("#inf_descript").val());

                var inf_wb_nm = $.trim($("#inf_wb_nm").val());
                var inf_wb_tel = $("#inf_wb_tel1").val() + "." + $.trim($("#inf_wb_tel2").val()) + "." + $.trim($("#inf_wb_tel3").val());
                var inf_wb_mail = $.trim($("#inf_wb_mail1").val()) + "@" + $("#inf_wb_mail2").val();




                if($("input:checkbox[id='inf_com_chk']").is(":checked") == false){
                    if(inf_com_idx == ""){
                        sendBoo = false;
                        alert("대상 회사는 필수 선택항목 입니다.");
                        $("#inf_com_idx").focus().select();
                        return;
                    }
                }
                if(inf_title == ""){
                    sendBoo = false;
                    alert("제보 제목은 필수 입력항목 입니다.");
                    $("#inf_title").focus().select();
                    return;
                }

                if(inf_descript == ""){
                    sendBoo = false;
                    alert("제보 내용은 필수 입력항목 입니다.");
                    $("#inf_descript").focus().select();
                    return;
                }
                if(inf_wb_nm == ""){
                    sendBoo = false;
                    alert("제보자 이름은 필수 입력항목 입니다.");
                    $("#inf_wb_nm").focus().select();
                    return;
                }*/
        /*
                if($.trim($("#inf_wb_tel1").val()) == ""){
                    sendBoo = false;
                    alert("연락처는 필수 입력항목 입니다.");
                    $("#inf_wb_tel1").focus().select();
                    return;
                }
                if($.trim($("#inf_wb_tel2").val()) == ""){
                    sendBoo = false;
                    alert("연락처는 필수 입력항목 입니다.");
                    $("#inf_wb_tel2").focus().select();
                    return;
                }
                if($.trim($("#inf_wb_tel3").val()) == ""){
                    sendBoo = false;
                    alert("연락처는 필수 입력항목 입니다.");
                    $("#inf_wb_tel3").focus().select();
                    return;
                }
         */


                if($("input:checkbox[id='inf_wb_rtn1']").is(":checked") == true){
                    if($.trim($("#inf_wb_tel1").val()) == ""){
                        sendBoo = false;
                        alert("연락받으실 전화번호를 입력해주세요.");
                        $("#inf_wb_tel1").focus().select();
                        return;
                    }
                    if($.trim($("#inf_wb_tel2").val()) == ""){
                        sendBoo = false;
                        alert("연락받으실 전화번호를 입력해주세요.");
                        $("#inf_wb_tel2").focus().select();
                        return;
                    }
                    if($.trim($("#inf_wb_tel3").val()) == ""){
                        sendBoo = false;
                        alert("연락받으실 전화번호를 입력해주세요.");
                        $("#inf_wb_tel3").focus().select();
                        return;
                    }
                }

                if($("input:checkbox[id='inf_wb_rtn2']").is(":checked") == true){
                    if($.trim($("#inf_wb_mail1").val()) == ""){
                        sendBoo = false;
                        alert("연락받으실 메일주소를 입력해주세요.");
                        $("#inf_wb_mail1").focus().select();
                        return;
                    }

                    if($.trim($("#inf_wb_mail2").val()) == ""){
                        sendBoo = false;
                        alert("연락받으실 메일주소를 입력해주세요.");
                        $("#inf_wb_mail2").focus().select();
                        return;
                    }
                }


                if($.trim($("#inf_wb_mail1").val()) != "" || $.trim($("#inf_wb_mail2").val()) != ""){
                    if(mailValidate(inf_wb_mail) == false){
                        sendBoo = false;
                        alert("올바른 메일형식이 아닙니다.");
                        $("#inf_wb_mail1").focus().select();
                        return;
                    }
                }

                if($("input:checkbox[id='agreeChk1']").is(":checked") == false){
                    sendBoo = false;
                    alert("개인정보 수집 및 이용 동의는 필수항목입니다.");
                    $("#agreeChk1").focus().select();
                    return;
                }

                if($("input:checkbox[id='agreeChk2']").is(":checked") == false){
                    sendBoo = false;
                    alert("개인정보 제3자 제공 동의는 필수항목입니다.");
                    $("#agreeChk2").focus().select();
                    return;
                }

                if($("input:checkbox[id='agreeChk3']").is(":checked") == false){
                    sendBoo = false;
                    alert("개인정보 처리업무 위탁 동의는 필수항목입니다.");
                    $("#agreeChk3").focus().select();
                    return;
                }

                var answer = confirm("등록 하시겠습니까?");
                if (answer == false) {
                    sendBoo = false;
                    return;
                }

                $("#inf_wb_tel").val(inf_wb_tel);
                $("#inf_wb_mail").val(inf_wb_mail);

                var selectedCom = $("#inf_com_idx option:selected").val();
                if(selectedCom == ""){
                    $("#inf_com_nm").val("미지정");
                }else{
                    $("#inf_com_nm").val($("#inf_com_idx option:selected").text());
                }




                //////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////
                /*
                alert("file1 : " + $("#file1").val());
                alert("file2 : " + $("#file2").val());
                alert("file3 : " + $("#file3").val());
                alert("file4 : " + $("#file4").val());
                alert("file5 : " + $("#file5").val());
                */

                var formData = new FormData($("#requestForm")[0]);
                $.ajax({
                    type : 'post',
                    url : '/tp01RegistSubmit.do',
                    dataType : 'json',
                    json : "callback",
                    data : formData,
                    processData : false,
                    contentType : false,
                    success : function(data) {
                        var result = data.result;

                        if(result == "success"){
                            location.href = "/tp01End.do";
                        }else{
                            sendBoo = false;
                            alert(result);
                        }

                    },
                    error : function(error) {
                        sendBoo = false;
                        alert("처리 중 장애가 발생하였습니다.");
                        console.log(error);
                        console.log(error.status);
                    }
                });


            }else{
                alert("처리중입니다. 잠시만 기다려주세요.")
            }



        }