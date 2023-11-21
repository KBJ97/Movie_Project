var reset = ''

        if( reset == 'Y' || location.pathname == '/booking' ){
            history.replaceState('','',location.href);
        }

      var _init = {
          cache	: Date.now(),
          path	: '/static/pc/js/'
      };

      document.write(
          '<script th:src="'+_init.path+'ui.common.js?v='+_init.cache+'"><\/script>'+
          '<script th:src="'+_init.path+'front.js?v='+_init.cache+'"><\/script>'
      );

      //RedirectException 발생시 메시지 처리


      //링크 구분에 따라 url 이동을 한다.
      function fn_goMoveLink(link_gbn, link_url) {
          alert("준비중 입니다");
          return;
      }





$(function(){


                    $('#header .right-link .before').show();
                    $('#header .right-link .after').hide();
                    //session 관련 처리를 위한 부분
                    $.ajaxMegaBox({
                        url: '/sessionChk.do',
                        success: function(data) {
                            var loginYn = data.loginYn;
                            if(loginYn == 'Y'){
                                $('.right-link .before').hide();
                            $('.right-link .after').show();
                            }else{
                                $('.right-link .before').show();
                            $('.right-link .after').hide();
                            }
                         }
                   });




            // 웹에서만 실행 -> facebook을 로드하지 않는 템플릿에서 반복적인 오류 발생으로 hreader로 이전
            if(!MegaboxUtil.Common.isMobile() && !MegaboxUtil.Common.isApp())
                MegaboxUtil.Share.init();
        });

        //로그인 버튼
        $(document).on('click', '#moveLogin', function() {

            fn_viewLoginPopup('default','pc');

        });

        var sysCd = 'ON';

          //넷퍼넬 스킨 타입 지정
        //NetfunnelChk.setting( sysCd, MegaboxUtil.Common.isApp() );



          $(function(){
                          //닫기 버튼 클릭
                        $('.ie-update').on('click', '.close-chk .closeDl', function() {
                             if ($(":checkbox[id='one_month_no_update']:checked").length > 0) {
                                fn_setCookie("BROWDER_DL", "Y", 30);
                            }

                            $('.ie-update').hide();
                        });

                        //다시보지 않기
                         if (fn_getCookie("BROWDER_DL") == null || fn_getCookie("BROWDER_DL") == 'N') {
                            if ( $(".lt-ie9").length > 0 && $('.ie-update').length > 0 ) {
                                $('.ie-update').show();
                            }
                        }
                    });

                    $(document).ready(function() {
                                    var filmCheck = MegaboxUtil.Common.moveMovieFilmCheckGnb(); // 영화제 존재여부 체크
                                    if(filmCheck == true){
                                        $("#festivalArea").show();
                                    }else{
                                        $("#festivalArea").hide();
                                    }
                                });



 var localeCode = "kr";			   //한영 구분 코드
        $(function(){
        });

        function fn_setMeta(scnDiv) {
            var paramData = null;

            if( scnDiv == undefined ){

                switch(tmpData.tabIndx){

                case 0: //영화별
                    url = location.protocol + '//' + document.domain + '/booking/timetable';
                    paramData = {
                            'scnTitle'         : '영화별 상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagTitle'   : '영화별상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagDtls'    : '메가박스의 영화별 상영시간표를 알려드립니다.'
                            , 'metaTagKeyword' : ''
                            , 'metaTagUrl'     : url
                        };
                        break;

                case 1: //극장별
                    url = location.protocol + '//' + document.domain + '/booking/timetable';
                    paramData = {
                            'scnTitle'         : '극장별 상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagTitle'   : '극장별상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagDtls'    : '메가박스의 극장별 상영시간표를 알려드립니다.'
                            , 'metaTagKeyword' : ''
                            , 'metaTagUrl'     : url
                        };
                        break;

                case 2: //특별관
                    url = location.protocol + '//' + document.domain + '/booking/timetable';
                    paramData = {
                            'scnTitle'         : '특별관 상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagTitle'   : '특별관상영시간표 < 상영시간표 | MEET PLAY SHARE, 메가박스'
                            , 'metaTagDtls'    : '메가박스의 특별관 상영시간표를 알려드립니다.'
                            , 'metaTagKeyword' : ''
                            , 'metaTagUrl'     : url
                        };
                        break;
                }

            }else{
                url = location.protocol + '//' + document.domain + '/booking';
                paramData = {
                        'scnTitle'         : '빠른예매 < 예매 | MEET PLAY SHARE, 메가박스'
                        , 'metaTagTitle'   : '빠른예매 < 예매 | MEET PLAY SHARE, 메가박스'
                        , 'metaTagDtls'    : '메가박스에서 영화를 간편하고 빠르게 예약해보세요.'
                        , 'metaTagKeyword' : ''
                        , 'metaTagUrl'     : url
                    };
            }

            //이전버튼을 위한 현재 메타태그 정보 저장
            saveCurrentMeta();

            //URL 변경
            history.replaceState( null, null, url );

            //메타태그 설정
            settingMeta(paramData);
        }



        //좌석도로 파라메타 전달
        function fn_setSmapParam(param) {

            var netfnlAdoptAt = param[3];

            if(netfnlAdoptAt == "Y"){
                // 넷퍼넬시작
                NetFunnel_Action({action_id : "WEB_BOOKING", service_id:"service_1", skin_id:"megabox"},{
                    success:function(ev, ret){
                        //param : 좌석도 화면 구동에 필요한 상영스케줄번호
                        //scnDiv : 네비게이션 표시를 위한 진입화면 구분 playTime : 예매 > 상영시간표, brch : 극장, spclBrch : 특별관
                        var frameBokdMSeatBodyObj    = $('#frameBokdMSeat').get(0).contentWindow.document.body;	//좌석도 프레임 바디 오브젝트
                        var framePayBookingBodyObj   = $('#framePayBooking').get(0).contentWindow.document.body;	//결제화면 프레임 바디 오브젝트
                        var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
                        var innerHtml = "<span>Home</span>";
                        var smapPlaySchdlNo = param[0];
                        var scnDiv = param[1];
                        var brchNo = param[2];

                        fn_setMeta(scnDiv);

                        if("default" == scnDiv){
                            innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                            innerHtml += "<a href=\"/booking\" title=\"/빠른예매 페이지로 이동\">빠른예매</a>";
                        }
                        else if("playTime" == scnDiv){
                            innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                            innerHtml += "<a href=\"/booking/timetable\" title=\"/상영시간표 페이지로 이동\">상영시간표</a>";
                        }
                        else if("brch" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/theater/list\" title=\"/예매 페이지로 이동\">전체극장</a>";
                            innerHtml += "<a href=\"\" title=\"/극장정보\">극장정보</a>";
                        }
                        else if("TBQ" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/boutqInfoPage.do\" title=\"/부티크 페이지로 이동\">부티크</a>";
                        }
                        else if("MX" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mxInfoPage.do\" title=\"/MX 페이지로 이동\">MX</a>";
                        }
                        else if("CFT" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/comfortInfoPage.do\" title=\"/COMFORT 페이지로 이동\">COMFORT</a>";
                        }
                        else if("MKB" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/kidsInfoPage.do\" title=\"/MEGABOX KIDS 페이지로 이동\">MEGABOX KIDS</a>";
                        }
                        else if("TFC" == scnDiv){
                            innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/firstClubInfoPage.do\" title=\"/THE FIRST CLUB 페이지로 이동\">THE FIRST CLUB</a>";
                        }
                        else if("BCY" == scnDiv){
                            innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/balconyInfoPage.do\" title=\"/BALCONY 페이지로 이동\">BALCONY</a>";
                        }

                        $('#bokdContainer .inner-wrap .location').html(innerHtml);	//네비게이션 표시
                        $(frameBokdMSeatBodyObj).find(".quick-reserve h2").html('');	//좌석도 타이틀 숨김
                        $(framePayBookingBodyObj).find(".quick-reserve h2").html('');	//결제   타이틀 숨김

                        $('#bokdContainer').show();		//좌석도, 결제 컨테이너 보임
                        $('#schdlContainer').hide();	//상영시간표 컨테이너 숨김
                        $('#bokdMSeat').show();			//좌석도 보임
                        $(frameBokdMSeatBodyObj).find('#playSchdlNo').val(smapPlaySchdlNo);
                        $(frameBokdMSeatBodyObj).find('#brchNo').val(brchNo);
                        frameBokdMSeatContentObj.fn_search();	//좌석도 좌석조회

                        // 	$('#frameBokdMSeat').attr('th:src','/on/oh/ohz/PcntSeatChoi/selectPcntSeatChoi.do?playSchdlNo='+obj.attr("play-schdl-no"));
                        // 	$('#frameBokdMSeat').attr('th:src','/main');
                    },
                    bypass:function(ev, ret){
                        //넷퍼넬 초기화
                        NetFunnel_Complete();
                        //param : 좌석도 화면 구동에 필요한 상영스케줄번호
                        //scnDiv : 네비게이션 표시를 위한 진입화면 구분 playTime : 예매 > 상영시간표, brch : 극장, spclBrch : 특별관
                        var frameBokdMSeatBodyObj    = $('#frameBokdMSeat').get(0).contentWindow.document.body;	//좌석도 프레임 바디 오브젝트
                        var framePayBookingBodyObj   = $('#framePayBooking').get(0).contentWindow.document.body;	//결제화면 프레임 바디 오브젝트
                        var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
                        var innerHtml = "<span>Home</span>";
                        var smapPlaySchdlNo = param[0];
                        var scnDiv = param[1];
                        var brchNo = param[2];

                        fn_setMeta(scnDiv);

                        if("default" == scnDiv){
                            innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                            innerHtml += "<a href=\"/booking\" title=\"/빠른예매 페이지로 이동\">빠른예매</a>";
                        }
                        else if("playTime" == scnDiv){
                            innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                            innerHtml += "<a href=\"/booking/timetable\" title=\"/상영시간표 페이지로 이동\">상영시간표</a>";
                        }
                        else if("brch" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/theater/list\" title=\"/예매 페이지로 이동\">전체극장</a>";
                            innerHtml += "<a href=\"\" title=\"/극장정보\">극장정보</a>";
                        }
                        else if("TBQ" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/boutqInfoPage.do\" title=\"/부티크 페이지로 이동\">부티크</a>";
                        }
                        else if("MX" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mxInfoPage.do\" title=\"/MX 페이지로 이동\">MX</a>";
                        }
                        else if("CFT" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/comfortInfoPage.do\" title=\"/COMFORT 페이지로 이동\">COMFORT</a>";
                        }
                        else if("MKB" == scnDiv){
                            innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/kidsInfoPage.do\" title=\"/MEGABOX KIDS 페이지로 이동\">MEGABOX KIDS</a>";
                        }
                        else if("TFC" == scnDiv){
                            innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/firstClubInfoPage.do\" title=\"/THE FIRST CLUB 페이지로 이동\">THE FIRST CLUB</a>";
                        }
                        else if("BCY" == scnDiv){
                            innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                            innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/balconyInfoPage.do\" title=\"/BALCONY 페이지로 이동\">BALCONY</a>";
                        }

                        $('#bokdContainer .inner-wrap .location').html(innerHtml);	//네비게이션 표시
                        $(frameBokdMSeatBodyObj).find(".quick-reserve h2").html('');	//좌석도 타이틀 숨김
                        $(framePayBookingBodyObj).find(".quick-reserve h2").html('');	//결제   타이틀 숨김

                        $('#bokdContainer').show();		//좌석도, 결제 컨테이너 보임
                        $('#schdlContainer').hide();	//상영시간표 컨테이너 숨김
                        $('#bokdMSeat').show();			//좌석도 보임
                        $(frameBokdMSeatBodyObj).find('#playSchdlNo').val(smapPlaySchdlNo);
                        $(frameBokdMSeatBodyObj).find('#brchNo').val(brchNo);
                        frameBokdMSeatContentObj.fn_search();	//좌석도 좌석조회

                        // 	$('#frameBokdMSeat').attr('th:src','/on/oh/ohz/PcntSeatChoi/selectPcntSeatChoi.do?playSchdlNo='+obj.attr("play-schdl-no"));
                        // 	$('#frameBokdMSeat').attr('th:src','/main');
                    },
                    error:function(ev,ret){
                        //넷퍼넬 초기화
                        NetFunnel_Complete();
                        if(ret.code == '926'){
                            gfn_alertMsgBox("네트워크에 연결되어 있지 않습니다.");
                            return;
                        }else{
                            //param : 좌석도 화면 구동에 필요한 상영스케줄번호
                            //scnDiv : 네비게이션 표시를 위한 진입화면 구분 playTime : 예매 > 상영시간표, brch : 극장, spclBrch : 특별관
                            var frameBokdMSeatBodyObj    = $('#frameBokdMSeat').get(0).contentWindow.document.body;	//좌석도 프레임 바디 오브젝트
                            var framePayBookingBodyObj   = $('#framePayBooking').get(0).contentWindow.document.body;	//결제화면 프레임 바디 오브젝트
                            var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
                            var innerHtml = "<span>Home</span>";
                            var smapPlaySchdlNo = param[0];
                            var scnDiv = param[1];
                            var brchNo = param[2];

                            fn_setMeta(scnDiv);

                            if("default" == scnDiv){
                                innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                                innerHtml += "<a href=\"/booking\" title=\"/빠른예매 페이지로 이동\">빠른예매</a>";
                            }
                            else if("playTime" == scnDiv){
                                innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                                innerHtml += "<a href=\"/booking/timetable\" title=\"/상영시간표 페이지로 이동\">상영시간표</a>";
                            }
                            else if("brch" == scnDiv){
                                innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml += "<a href=\"/theater/list\" title=\"/예매 페이지로 이동\">전체극장</a>";
                                innerHtml += "<a href=\"\" title=\"/극장정보\">극장정보</a>";
                            }
                            else if("TBQ" == scnDiv){
                                innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/boutqInfoPage.do\" title=\"/부티크 페이지로 이동\">부티크</a>";
                            }
                            else if("MX" == scnDiv){
                                innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mxInfoPage.do\" title=\"/MX 페이지로 이동\">MX</a>";
                            }
                            else if("CFT" == scnDiv){
                                innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/comfortInfoPage.do\" title=\"/COMFORT 페이지로 이동\">COMFORT</a>";
                            }
                            else if("MKB" == scnDiv){
                                innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/kidsInfoPage.do\" title=\"/MEGABOX KIDS 페이지로 이동\">MEGABOX KIDS</a>";
                            }
                            else if("TFC" == scnDiv){
                                innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/firstClubInfoPage.do\" title=\"/THE FIRST CLUB 페이지로 이동\">THE FIRST CLUB</a>";
                            }
                            else if("BCY" == scnDiv){
                                innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                                innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                                innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/balconyInfoPage.do\" title=\"/BALCONY 페이지로 이동\">BALCONY</a>";
                            }

                            $('#bokdContainer .inner-wrap .location').html(innerHtml);	//네비게이션 표시
                            $(frameBokdMSeatBodyObj).find(".quick-reserve h2").html('');	//좌석도 타이틀 숨김
                            $(framePayBookingBodyObj).find(".quick-reserve h2").html('');	//결제   타이틀 숨김

                            $('#bokdContainer').show();		//좌석도, 결제 컨테이너 보임
                            $('#schdlContainer').hide();	//상영시간표 컨테이너 숨김
                            $('#bokdMSeat').show();			//좌석도 보임
                            $(frameBokdMSeatBodyObj).find('#playSchdlNo').val(smapPlaySchdlNo);
                            $(frameBokdMSeatBodyObj).find('#brchNo').val(brchNo);
                            frameBokdMSeatContentObj.fn_search();	//좌석도 좌석조회

                            // 	$('#frameBokdMSeat').attr('th:src','/on/oh/ohz/PcntSeatChoi/selectPcntSeatChoi.do?playSchdlNo='+obj.attr("play-schdl-no"));
                            // 	$('#frameBokdMSeat').attr('th:src','/main');
                        }
                    }
                });
            }else{
                //param : 좌석도 화면 구동에 필요한 상영스케줄번호
                //scnDiv : 네비게이션 표시를 위한 진입화면 구분 playTime : 예매 > 상영시간표, brch : 극장, spclBrch : 특별관
                var frameBokdMSeatBodyObj    = $('#frameBokdMSeat').get(0).contentWindow.document.body;	//좌석도 프레임 바디 오브젝트
                var framePayBookingBodyObj   = $('#framePayBooking').get(0).contentWindow.document.body;	//결제화면 프레임 바디 오브젝트
                var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
                var innerHtml = "<span>Home</span>";
                var smapPlaySchdlNo = param[0];
                var scnDiv = param[1];
                var brchNo = param[2];

                fn_setMeta(scnDiv);

                if("default" == scnDiv){
                    innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                    innerHtml += "<a href=\"/booking\" title=\"/빠른예매 페이지로 이동\">빠른예매</a>";
                }
                else if("playTime" == scnDiv){
                    innerHtml += "<a href=\"/booking\" title=\"/예매 페이지로 이동\">예매</a>";
                    innerHtml += "<a href=\"/booking/timetable\" title=\"/상영시간표 페이지로 이동\">상영시간표</a>";
                }
                else if("brch" == scnDiv){
                    innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml += "<a href=\"/theater/list\" title=\"/예매 페이지로 이동\">전체극장</a>";
                    innerHtml += "<a href=\"\" title=\"/극장정보\">극장정보</a>";
                }
                else if("TBQ" == scnDiv){
                    innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/boutqInfoPage.do\" title=\"/부티크 페이지로 이동\">부티크</a>";
                }
                else if("MX" == scnDiv){
                    innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mxInfoPage.do\" title=\"/MX 페이지로 이동\">MX</a>";
                }
                else if("CFT" == scnDiv){
                    innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/comfortInfoPage.do\" title=\"/COMFORT 페이지로 이동\">COMFORT</a>";
                }
                else if("MKB" == scnDiv){
                    innerHtml += "<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml += "<a href=\"/on/oh/ohc/BrchSpecial/kidsInfoPage.do\" title=\"/MEGABOX KIDS 페이지로 이동\">MEGABOX KIDS</a>";
                }
                else if("TFC" == scnDiv){
                    innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/firstClubInfoPage.do\" title=\"/THE FIRST CLUB 페이지로 이동\">THE FIRST CLUB</a>";
                }
                else if("BCY" == scnDiv){
                    innerHtml +="<a href=\"/theater/list\" title=\"/극장 페이지로 이동\">극장</a>";
                    innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/mainPage.do\" title=\"/특별관 페이지로 이동\">특별관</a>";
                    innerHtml +="<a href=\"/on/oh/ohc/BrchSpecial/balconyInfoPage.do\" title=\"/BALCONY 페이지로 이동\">BALCONY</a>";
                }

                $('#bokdContainer .inner-wrap .location').html(innerHtml);	//네비게이션 표시
                $(frameBokdMSeatBodyObj).find(".quick-reserve h2").html('');	//좌석도 타이틀 숨김
                $(framePayBookingBodyObj).find(".quick-reserve h2").html('');	//결제   타이틀 숨김

                $('#bokdContainer').show();		//좌석도, 결제 컨테이너 보임
                $('#schdlContainer').hide();	//상영시간표 컨테이너 숨김
                $('#bokdMSeat').show();			//좌석도 보임
                $(frameBokdMSeatBodyObj).find('#playSchdlNo').val(smapPlaySchdlNo);
                $(frameBokdMSeatBodyObj).find('#brchNo').val(brchNo);
                frameBokdMSeatContentObj.fn_search();	//좌석도 좌석조회

                // 	$('#frameBokdMSeat').attr('th:src','/on/oh/ohz/PcntSeatChoi/selectPcntSeatChoi.do?playSchdlNo='+obj.attr("play-schdl-no"));
                // 	$('#frameBokdMSeat').attr('th:src','/main');
            }
        }

        //좌석도에서 이전 버튼 클릭
        function fn_goPrePagePcntSeatChoi() {

            // 넷퍼넬 초기화
            NetFunnel_Complete();

            var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
            $('#bokdContainer').hide();		//좌석도, 결제 컨테이너 보임
            $('#schdlContainer').show();	//상영시간표 컨테이너 숨김

            //결제에서 예매이동 처리 추가
            $('#bokdMSeat').hide();			//좌석도 숨김
            $('#bokdMPayBooking').hide();
            $('#frameBokdMSeat').attr("th:src", "/on/oh/ohz/PcntSeatChoi/selectPcntSeatChoi.do"); //좌석도 화면초기화
            $('#framePayBooking').attr("th:src", "/on/oh/ohz/PayBooking/completeSeat.do"); //결제화면 초기화

            //이전 메타태그 정보로 설정 (preMetaFormat:전역변수)
            settingMeta(preMetaFormat);
            //URL 변경
            history.replaceState( null, null, preMetaFormat.metaTagUrl );
        }

        //좌석도에서 다음 버튼 클릭
        function fn_goNextPagePcntSeatChoi(param) {
            //로그인 여부 체크
            fn_validLoginAt(param);
            //데이터 보정 체크
            //fn_validLoginAt();
            //오입력 체크
            //블랙리스트 체크
            //결제로이동
        }


        //결제화면으로로 파라메타 전달 및 화면 이동
        function fn_setBookingParamMove(options) {

            var framePayBookingBodyObj    = $('#framePayBooking').get(0).contentWindow.document.body;	//결제화면 프레임 바디 오브젝트
            var framePayBookingContentObj = $('#framePayBooking').get(0).contentWindow;

            //좌석도에서 세팅한 param 값
            var playSchdlNo   = options.playSchdlNo;	//상영스케쥴
            var seatOccupText = options.seatOccupText;	//좌석/티켓 상세정보
            var totalAmt      = options.totalAmt;		//총금액

            $(framePayBookingBodyObj).find('#playSchdlNo').val(playSchdlNo);
            $(framePayBookingBodyObj).find('#seatOccupText').val(seatOccupText);
            $(framePayBookingBodyObj).find('#totalAmt').val(totalAmt);

            framePayBookingContentObj.completeSeat();
            $('#bokdMPayBooking').show();
            //프레임 높이 자동 조정
            calcFrameHeight($('#bokdMPayBooking'), $('#framePayBooking'));

            $('#bokdMSeat').hide();  //좌석도 숨김

        }

        //결제화면에서 이전 버튼 클릭
        function fn_goPrePagePayBooking() {
            var framePayBookingContentObj = $('#framePayBooking').get(0).contentWindow;
            var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
            $('#bokdMPayBooking').hide();
            $('#framePayBooking').attr("th:src", "/on/oh/ohz/PayBooking/completeSeat.do"); //결제화면 초기화
            $('#bokdMSeat').show();	//좌석도 표시
            $("html,body").scrollTop(0);

            frameBokdMSeatContentObj.fn_display_init();
        }

        //결제화면에서 이전 버튼 클릭 및 블랙리스트 팝업
        function fn_altBlackgoPrePagePayBooking(blackListParam) {
            var framePayBookingContentObj = $('#framePayBooking').get(0).contentWindow;
            var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
            $('#bokdMPayBooking').hide();
            $('#framePayBooking').attr("th:src", "/on/oh/ohz/PayBooking/completeSeat.do"); //결제화면 초기화
            $('#bokdMSeat').show();	//좌석도 표시
            $("html,body").scrollTop(0);

            frameBokdMSeatContentObj.fn_display_init();

            frameBokdMSeatContentObj.shwoBlackListPopup(blackListParam);
        }

        //결제화면에서 오류 발생시 좌석도로 이동(기선점 존재, 시간 초과 등)
        function fn_goPrePageInitSeat(msg) {
            var framePayBookingContentObj = $('#framePayBooking').get(0).contentWindow;
            $('#bokdMPayBooking').hide();
            $('#framePayBooking').attr("th:src", "/on/oh/ohz/PayBooking/completeSeat.do"); //결제화면 초기화

            //좌석도 초기화
            var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
            frameBokdMSeatContentObj.fn_search('N');  //새로 조회 및 최초진입 팝업 띄우지 않음
            $('#bokdMSeat').show();	//좌석도 표시
            $("html,body").scrollTop(0);

            if (msg != null && msg != "") {
                gfn_alertMsgBox("결제가능 시간이 초과되어<br/> 좌석선택부터 다시 진행바랍니다.");
            }

            frameBokdMSeatContentObj.fn_display_init();
        }

        //프레임 height 자동조정 : 결제만 적용가능
        function calcFrameHeight(divObj, frameObj) { //div obj, frame obj
            var frameBodyObj = $(frameObj).get(0).contentWindow.document.body;	//프레임 바디 오브젝트
            var height = $(frameObj).contents().find('.inner-wrap').outerHeight();
            $(divObj).height(height + 130);
            $(frameObj).height(height + 130);
        }

        //로그인여부 체크
        function fn_validLoginAt(param){
            $.ajaxMegaBox({
                url    : "/on/oh/ohg/MbLogin/selectLoginSession.do",
                //data   : JSON.stringify(paramData),
                success: function(result){
                    var loginAt = result.resultMap.result;	//로그인 여부

                    //비로그인 상태
                    if(loginAt  == "N"){
                        //로그인 팝업 표시
                        fn_viewLoginPopup('SimpleBokdM','pc','Y',JSON.stringify(param));
                    }
                    //로그인 상태
                    else {
                        //데이터 보정 체크
                        fn_validDataRevisn(param);
                    }
                }
            });
        }

        //데이터 보정 체크
        function fn_validDataRevisn(param){

            fn_vlaidBlackList(param);

        // 	$.ajaxMegaBox({
        //         url    : "/on/oh/ohg/MbLogin/selectDataRevisn.do",
        //         //data   : JSON.stringify(paramData),
        //         success: function(result){
        //         	var dataRevisnAt = result.resultMap.result;	//로그인 여부
        //         	//자료보정대상
        // 			if(dataRevisnAt  == "Y"){
        // 				//자료 보정 안내 메세지 표시
        // 				var arguments=result.resultMap.birthDe+' / '+result.resultMap.mblpTelno;
        // 				var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;	//좌석도 프레임 컨텐츠 오브젝트
        // 				frameBokdMSeatContentObj.shwoDataRevisnPopup(arguments,param);
        //  			}
        //  			//자료보정대상아님
        //  			else {
        //  				//블랙리스트 체크
        // 				fn_vlaidBlackList(param);
        //  			}
        //         }
        //     });
        }

        //블랙리스트 체크
        function fn_vlaidBlackList(param){


            var paramData = { BokdCnt : param.bokdCnt
                            , BokdBrch : param.brchNo
                            };

        // 	//좌석수 param
            $.ajaxMegaBox({
                url    : "/on/oh/ohg/MbLogin/selectBlackList.do",
                data   : JSON.stringify(paramData),
                success: function(result){
                    var dataBlackListAt = result.resultMap.result;
                    //블랙리스트 대상
                    if(dataBlackListAt  == "Y"){
                        //블랙리스트 안내 메세지 표시
                        var frameBokdMSeatContentObj = $('#frameBokdMSeat').get(0).contentWindow;
                        var blackListParam = { Msg: result.resultMap.Msg }
                        frameBokdMSeatContentObj.shwoBlackListPopup(blackListParam);
                    }
                    //블랙리스트 비 대상
                    else {
                        //결제로 이동
                         fn_setBookingParamMove(param);
                    }
                }
            });
        }

        //페이지 이동
        function fn_mvPage(page){
            $("#bokdMForm").attr("method","post");
            $("#bokdMForm").attr("action",page);
            $("#bokdMForm").submit();
        }

        //언어변환
        function setLangChg(){
            if(localeCode == "en"){
                location.href="/booking?megaboxLanguage=kr";
            }
            else {
                location.href="/booking?megaboxLanguage=en";
            }
        }


        //페이지 리로드
        function fn_bokdReload(page){
            fn_goPrePagePcntSeatChoi();
        }


 // Tab Index
        var tabIdx = 01 -1;

        // 최초 1번 조회 여부 Index로 관리함
        var arrTab = [0, 0, 0];

        $(function() {

            // 화면준비
            $(document).ready(function(){

                // 요청 탭 조회
                $('#contents div.tab-list a').eq(tabIdx).click();
            });

            // 이벤트 버블현상 공통 제거
            $('#contents').on('click', 'a', function(e) {

                if (($(this).attr('href') || '').indexOf('/') == -1) {
                    e.preventDefault();
                }
            });

            // 로그인 버튼
            $(document).on('click', '#moveLogin', function() {

                fn_viewLoginPopup('default','pc');
            });

            // 선호극장
            $('#favorBrch').on('click', function() {

                if ($(this).hasClass('on')) {

                    gfn_confirmMsgBox('등록된 선호극장을 삭제하시겠습니까?', fn_chgFavor);

                } else {

                    fn_chgFavor('N');
                }
            });

            // Tab 선택
            $('#contents div.tab-list a').click(function() {

                var index = $('#contents div.tab-list a').index(this);

                // 최초 접근 일때 서버에서 조회해 옴
                if (arrTab[index] == 0) {

                    switch(index){
                    case 0 : fn_brchInfo();     break; //극장정보
                    case 1 : fn_callSchedule(); break; //상영시간표
                    case 2 : fn_callPrice();    break; //관람료
                    }

                    arrTab[index] = 1;
                }

                // 메타테그/네비게인션 설정
                setMetaTagNNavi(index);

                // 상단으로 스크롤
                window.scrollTo(0, 0);
            });
        });

        // 선호극장 등록 및 취소
        function fn_chgFavor(deleteYn) {

            if (deleteYn == undefined) deleteYn = 'Y';

            var paramData = {'brchNo' : '0023', 'deleteYn' : deleteYn};

            $.ajaxMegaBox({
                url      : '/on/oh/ohc/Brch/updateFavorBrch.do',
                data     : JSON.stringify(paramData),
                sessionAt: true,
                success  : function (data, textStatus, jqXHR) {

                    // 결과
                    switch(data.result){
                    case 'max'   : gfn_alertMsgBox('최대 3개까지 설정 가능합니다.'); return;
                    case 'login' : gfn_alertMsgBox('로그인 해주세요.');           return;
                    }

                    switch(deleteYn){
                    case 'N' : $('.btn-like').addClass('on');    break;
                    case 'Y' : $('.btn-like').removeClass('on'); break;
                    }
                }
            });
        }

        // 극장 정보(Tab01) > 극장 정보 조회
        function fn_brchInfo() {

            var paramData = {'areaCd' : '10', 'brchNo' : '0023'};

            $.ajaxMegaBox({
                dataType : 'html',
                url      : '/on/oh/ohc/Brch/infoPage.do',
                data     : JSON.stringify(paramData),
                success  : function (data, textStatus, jqXHR) {

                    // html 설정
                    $('#tab01').html(data);

                    // 소식조회
                    fn_noticeList();
                }
            });
        }

        // 극장 정보(Tab01) > 소식 조회
        function fn_noticeList() {

            var options = {};

            // 페이징할 기본 SIZE 기본값 10
            options.recordCountPerPage = 5;

            // 호출 URL
            options.url = "/on/oh/ohc/Brch/noticeList.do";

            // 파라메터
            options.paramData = {'brchNo' : '0023'};

            // 그리기
            options.successCallBack = function( data, textStatus, jqXHR ){

                var html = '';

                // 값이 없으면 소식 영역 삭제
                if (data.list == undefined || data.list.length == 0) {
                    $('#brchNoti').remove();
                    return;
                }

                // 내용 생성
                $.each(data.list, function(i, param) {
                    var artiCn = "";
                    //param.cls = (i==0)? 'on' : '';

                    html += '<li>';
                    html += '<div class="title ">';
                    html += '	<a href="" title="'+ param.artiTitle +'">';
                    html += '		<div class="cont-tit">'+ param.artiTitle   +'</div>';
                    html += '		<p class="cont-admin">'+ param.cate2Nm     +'</p>';
                    html += '		<p class="cont-date">' + param.fstRegDtStr +'</p>';
                    html += '	</a>';
                    html += '</div>';
                    if(param.artiCn != null){
                        artiCn = $.parseHTML(param.artiCn)[0].textContent
                    }
                    html += '<div class="content" style="display:none">'+ artiCn +'</div>';
                    html += '</li>';
                });

                // 게시글 노출
                $('#tab01 .accordion-list ul').html(html);

                // 아코디언 이벤트 연결
                mbThToggle.init({target:'accordion-list'});
            };

            // page 이벤트 연결
            gfn_setPage(options);
        }

        // 상영시간표(Tab02) 조회
        function fn_callSchedule(playDe) {

            var paramData = {};
            var option    = {movieObj  : $('#tab02 > h2:last'), movieData : paramData}

            paramData.masterType = 'brch';
            paramData.brchNo     = '0023';
            paramData.brchNm     = '강남대로&#40;씨티&#41;';

            MegaboxUtil.Brch.init(option);
        }

        // 관람료(Tab03) > 관람료 조회
        function fn_callPrice() {

            var paramData = {};
            var option    = {priceObj  : $('#tab03 > h2'), brchData : paramData}

            paramData.zoneAt  = 'Y';
            paramData.brchNo  = '0023';
            paramData.brchNm  = '강남대로&#40;씨티&#41;';

            MegaboxUtil.Brch.init(option);
        }


        // 메타테그/네비게인션 설정
        function setMetaTagNNavi(index) {

            var tabNm = $('#contents .tab-layer a').eq(index).html();
            var title = tabNm + ' 페이지로 이동';

            var paramData = { 'scnTitle'     : '(강남대로(씨티))' + tabNm + ' > 전체극장 , 메가박스'
                            , 'metaTagTitle' : '(강남대로(씨티))' + tabNm + ' > 전체극장 , 메가박스'
                            , 'metaTagImg'   : 'http://image2.megabox.co.kr/mop/event.html/2018/6F/03D492-6FD4-485F-AE3F-2D3E2A41046F.jpg'};

            switch (index) {
            case 0 :
                paramData.metaTagUrl    = location.protocol + '//' + document.domain + '/theater?brchNo=0023';
                paramData.metaTagMenuId = 'ON00000038';
                paramData.metaTagDtls   = '반갑습니다. 메가박스 강남대로&#40;씨티&#41;점 입니다.';
                break;
            case 1 :
                paramData.metaTagUrl    = location.protocol + '//' + document.domain + '/theater/time?brchNo=0023';
                paramData.metaTagMenuId = 'ON00000037';
                paramData.metaTagDtls   = '반갑습니다. 메가박스 강남대로&#40;씨티&#41;점 입니다.';
                break;
            case 2 :
                paramData.metaTagUrl    = location.protocol + '//' + document.domain + '/theater/price?brchNo=0023';
                paramData.metaTagMenuId = 'ON00000039';
                paramData.metaTagDtls   = '메가박스 강남대로&#40;씨티&#41;점의 관람료를 확인하세요.';
                break;
            }

            // 메타테그 설정
            settingMeta(paramData);

            // 네비게이션 설정
            $('#schdlContainer .location a:last').attr({'href': paramData.metaTagUrl.replace('&', ''), 'title' : title}).html(tabNm);

            // URL 주소 변경
            history.replaceState( null, null, paramData.metaTagUrl );
        }

