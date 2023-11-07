 $(document).ready(function(){
            jQuery(window).scroll(function (){
                var sTop = parseInt(jQuery(window).scrollTop());
                if(sTop<457){
                    $('.totopbox').removeClass('on');
                }else{
                    $('.totopbox').addClass('on');
                }

                $('.gotop').click(function(e){
                    $('html, body').stop().animate({scrollTop : 0}, 300);
                });
            });


        });