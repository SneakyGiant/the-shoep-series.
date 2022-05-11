$(document).ready(function(){

  var Links = [];
  var Rechts = [];

  $("#add").click(function(){
    var Toevoegen = $("#txt").val();
    $(".links").text(Toevoegen);
  });
});
