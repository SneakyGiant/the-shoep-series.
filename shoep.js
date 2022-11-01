$(document).ready(function(){
  $(".shoep").hide();

  $("#img").mouseenter(function(){
    $(".shoep").show(1000);
    console.log("hello");
  });

  $("#img").mouseleave(function(){
    $(".shoep").hide(1000);
    console.log("nope");
  });
});
