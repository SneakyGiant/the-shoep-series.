$(document).ready(function(){

  var Links = [];
  var Rechts = [];
  var selectedNumber;
  var selectedList;
  var WordId;

  $("#add").click(function(){
    var Toevoegen = $("#txt").val();
    $(".links").text(Toevoegen);
    Links[Links.length] = Toevoegen;

    $(".links").empty();
    for(var i = 0; i < Links.length; i++){
      $(".links").append('<div class="word" data-list="left" data-number="'+i+'">'+Links[i]+'</div>');
    };

    $(".rechts").empty();
    for(var i = 0; i < Rechts.length; i++){
      $(".rechts").append('<div class="word" data-list="right" data-number="'+i+'">'+Rechts[i]+'</div>');
    };

    $('.word').click(function() {
        $('.selectedWord').removeClass('selectedWord');
        $(this).toggleClass('selectedWord');
        WordId = $(this).attr('id');
        selectedList = $(this).attr('data-list');
        selectedNumber = $(this).attr('data-number');
    });
  });
  
  $('#toRight').click(function() {

      if($('.word').hasClass('selectedWord') && selectedList == "left") {

          Rechts.push(Links[selectedNumber]);
          Links.splice(selectedNumber, 1);

          $('.links').empty();
          for(var i = 0; i < Links.length; i++) {
              $('.rechts').append('<div class="word" data-list="left" data-number="'+i+'">'+Links[i]+'</div>');
          };

          $('.rechts').empty();
          for(var i = 0; i < Rechts.length; i++) {
              $('.rechts').append('<div class="word" data-list="right" data-number="'+i+'">'+Rechts[i]+'</div>');
          };

          $('.word').click(function() {
              $('.selectedWord').removeClass('selectedWord');
              $(this).toggleClass('selectedWord');
              WordId = $(this).attr('id');
              selectedList = $(this).attr('data-list');
              selectedNumber = $(this).attr('data-number');
          });
      };
  });
  $('#toLeft').click(function() {

      if($('.word').hasClass('selectedWord') && selectedList == "right") {

          Links.push(Rechts[selectedNumber]);
          Rechts.splice(selectedNumber, 1);

          $('.links').empty();
          for(var i = 0; i < Links.length; i++) {
              $('.links').append('<div class="word" data-list="left" data-number="'+i+'">'+Links[i]+'</div>');
          };


          $('.rechts').empty();
          for(var i = 0; i < Rechts.length; i++) {
              $('.rechts').append('<div class="word" data-list="right" data-number="'+i+'">'+Rechts[i]+'</div>');
          };

          $('.word').click(function() {
              $('.selectedWord').removeClass('selectedWord');
              $(this).toggleClass('selectedWord');
              WordId = $(this).attr('id');
              selectedList = $(this).attr('data-list');
              selectedNumber = $(this).attr('data-number');
          });
      };
  });

});
