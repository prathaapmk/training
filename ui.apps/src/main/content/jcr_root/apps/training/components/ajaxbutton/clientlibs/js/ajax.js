$(document).ready(function(){
  $("button").click(function(){
    $.get("/bin/training/test.txt", function(data, status){
      alert("Data: " + data + "\nStatus: " + status);
    });
  });
});