const wordList = ["read","between","the","lines",];
var chosenWord = "";
var correctLetters = "";
var wrong = 0;

function chooseWord(){
  int n = Math.random()*3;
  let chosenWord = wordList[n];

  for(int i = 0; i < chosenWord.length(); i++){
    let correctLetters += "_ ";
  }
}

function check(){
  if (input.equals(chosenword) || !correctletters.contains("_")){
    document.write("correct guess"\n);
  }
}
