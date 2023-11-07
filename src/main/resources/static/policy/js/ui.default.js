
//input 디자인
function inputdesign(){
    $(".intt, .textarea>textarea").focus(function(){
        var t = $(this);
        t.removeClass("focus").removeClass("choice");
        t.addClass("focus");
    });
    $(".intt, .textarea>textarea").blur(function(){
        var t = $(this);
        t.removeClass("focus").removeClass("choice");
        if(!(t.val() == "" || t.val().length < 1)){
            t.addClass("choice");
        }
    });
}

//checkbox
function checkboxdesign(){
    $('.im_ch').each(function(){
        if ($(this).children('input').is(':checked')){
            $(this).addClass('on');
        }else{
            $(this).removeClass('on');
        };
    }).click(function(){
        if ($(this).hasClass('on')){
            $(this).removeClass('on').children('input').prop('checked', false);
        }else{
            $(this).addClass('on').children('input').prop('checked', true);
        }
        $(this).children('input').change();
        return false;
    });
}

//radio
function radiodesign(){
    // $(".im_ra").focus(function(){
    //     var t = $(this);
    //     if (!t.hasClass("on")) {
    //         t.removeClass("focus");
    //         t.addClass("focus");
    //     };
    // });
    $('.im_ra').each(function(){
        if ($(this).children('input:radio').is(':checked')){
            $(this).addClass('on');
        }else{
            $(this).removeClass('on');
        }
    }).click(function(){
        var radiobox = $(this).parents('.o_ra');
        radiobox.find('.im_ra').removeClass('on');
        $(this).addClass('on').children('input').prop('checked', true);
        $(this).children('input').change();
        return false;
    });
}

//input file
function inputfile(){
    var fileTarget = $('.file_input .upload_hidden');

    fileTarget.on('change', function(){ 
    if(window.FileReader){
      var filename = $(this)[0].files[0].name;
    } 
    else {
      var filename = $(this).val().split('/').pop().split('\\').pop(); 
    }


    $(this).siblings('.intt').val(filename);
    });
}
inputfile();

//ifbox
// function ifbox(){
//     var ifbox = $('.ifbox'),
//         tit = ifbox.find('.tit').find('em');

//     tit.click(function(){
//         if(!$(this).hasClass('on')) {
//             $(this).addClass('on');
//             $(this).text('닫기')
//             ifbox.find('.ovhie').slideDown(350);
//         } else {
//             $(this).removeClass('on');
//             $(this).text('열기')
//             ifbox.find('.ovhie').slideUp(350);
//         }
//     })
// }
// ifbox();

// function selcsop(){
//     var selcs = $('.selcs');
//     var selcstitle = selcs.find('p');
//     var selcsbox = selcs.find('ul');
//     var selcsli = selcs.find('li');
//     var text;
//     selcstitle.click(function(){
//         $(this).parent().find('ul').show();
//         $(this).parent('.selcs').css({'z-index':999})
//     });
//     selcs.mouseleave(function(){
//         selcsbox.hide();
//         selcs.css({'z-index':77})
//     });
//     selcsli.click(function(){
    	
//         var idx = $(this).index()+1;
//         text = $(this).html();
//         $(this).parent().parent().find('p').html(text);
//         $(this).parent().parent().find('p').removeClass();
//         $(this).parent().parent().find('p').addClass('n0'+idx);
//         selcsbox.hide();
        
//         var value;
//         var data = $(this).parent().parent().find('input');
//         var append = $(this).parent().parent().find('p').html(text).text();
//         if(append == "접수"){
//         	value = data.val() + "C002";
//         }else if(append == "검토"){
//         	value = data.val() + "C003";
//         }else if(append == "완료"){
//         	value = data.val() + "C004";
//         }else if(append == "반려"){
//         	value = data.val() + "C005";
//         }
//         data.attr("value", value);
//     });
// }
// selcsop();

//top menu
function topmenu(){
    var topmenu = $('.tab'),
        tabul = topmenu.find('>ul>li'),
        tablist = tabul.find('.tab_depth');
        tablist.hide();

    tabul.hover(function () {
        $(this).find('.tab_depth').show();
        event.stopPropagation();
    }, function () {
        tablist.hide();
    });

}


//layerpop addentrust
function addentrust(){
    var btnent = $('#add_entrust'),
        layerpop = $('.layerpop'),
        btnexit = layerpop.find('.exit');

    btnent.click(function(e){
        $('.dem').show();
        layerpop.show();
        e.preventDefault();
    });

    btnexit.click(function(e){
        $('.dem').hide();
        layerpop.hide();
    });
}

//maintab
function maintab(){
    var maintab = $('.maintab'),
        tabcontent = $('.tabcontent'),
        mainbot = tabcontent.find('.mainbot'),
        thinx = 0;

    maintab.find('.cont>ul').find('li').click(function(e){
        thinx = $(this).index();
        maintab.find('li').removeClass('on');
        $(this).addClass('on');
        mainbot.removeClass('on');
        tabcontent.find('>div').eq(thinx).addClass('on');
    });

}

