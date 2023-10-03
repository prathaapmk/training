$(document).ready(function(){
  /* $("button").click(function(){
     $.get("/bin/training/test.txt", function(data, status){
       alert("Data: " + data + "\nStatus: " + status);
     });
   });*/

  var url = "/bin/training/test";
  //document.getElementById("resoucerTypeId").value+".txt";
  console.log("url"+url);
  $("button").click(function(){
    $.get(url, function(data, status){
      alert("Data: " + data + "\nStatus: " + status);
    });
  });
});