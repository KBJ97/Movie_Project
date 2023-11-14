//리셋 버튼
$(document).ready(function(){
   $("#resetEmail").on("click", function(e) {
     e.preventDefault();
     $(this).closest("form").find("#email").val("");
   });

   $("#resetPassword").on("click", function(e) {
     e.preventDefault();
     $(this).closest("form").find("#password").val("");
   });
});