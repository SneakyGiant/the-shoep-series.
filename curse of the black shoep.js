$(document).ready(function(){

  var Links = [];
  var Rechts = [];  

  $(".shoep").hide();

  $("#img").mouseenter(function(){
    $(".shoep").show(1000);
    console.log("crap");
  });

  $("#img").mouseleave(function(){
    $(".shoep").hide(1000);
    console.log("fuck");
  });
  $("#add").click(function(){
    var Toevoegen = $("#txt").val();
    $(".links").text(Toevoegen);
  });
});
