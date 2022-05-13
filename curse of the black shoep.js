$(document).ready(function(){

  var Links = [];
  var Rechts = [];

  $("#add").click(function(){
    var Toevoegen = $("#txt").val();
    $(".links").text(Toevoegen);
    Links[Links.length] = Toevoegen;

    $(".links").empty();
    for(i = 0; i < Links.length; i++){
      
    }
  });
});
