 $(document).ready(function(){

            jQuery(window).scroll(function (){
                var sTop = parseInt(jQuery(window).scrollTop());

                var tab01 = $('.in01').offset().top-400;
                var tab02 = $('.in02').offset().top-400;
                var tab03 = $('.in03').offset().top-400;
                if(sTop<397){
                    $('.tabmenu').removeClass('on');
                }else{
                    $('.tabmenu').addClass('on');
                }

                if(sTop<457){
                    $('.totopbox').removeClass('on');
                }else{
                    $('.totopbox').addClass('on');
                }

                if(sTop<tab02){
                    $('.tabmenu').find('li').removeClass('on');
                    $('.tabmenu').find('li').eq(0).addClass('on');
                }else if(sTop<tab03){
                    $('.tabmenu').find('li').removeClass('on');
                    $('.tabmenu').find('li').eq(1).addClass('on');
                }else{
                    $('.tabmenu').find('li').removeClass('on');
                    $('.tabmenu').find('li').eq(2).addClass('on');
                }



            });

            $('.tabmenu').find('li').click(function(e){
                var thix = $(this).index()+1;
                var togoing = $('.in0'+thix).offset().top-60;

                $('html, body').stop().animate({scrollTop : togoing}, 500);
            });

            $('.gotop').click(function(e){
                $('html, body').stop().animate({scrollTop : 0}, 300);
            });

        });