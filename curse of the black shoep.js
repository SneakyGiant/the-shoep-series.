$(document).ready(function(){
  $(".shoep").hide();

  $("#img").mouseenter(function(){
    $(".shoep").show(1000);
    alert("you found shoep");
    console.log("crap");
  });

  $("#img").mouseleave(function(){
    $(".shoep").hide(1000);
    console.log("fuck");
  });

alert("shoep is hidden");


});
