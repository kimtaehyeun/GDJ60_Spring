const btn = document.getElementById("btn")
const textArea= document.getElementById("textArea")




btn.addEventListener("click",function(){
    
    let xhttp= new XMLHttpRequest();// url method parametter
    xhttp.open("POST",'../bankBookComment/add'); 
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("contents="+textArea.value+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));//파라미터 넣기
    xhttp.addEventListener('readystatechange',function(){
        if(this.readyState==4&& this.status==200){
           if(this.responseText.trim()==1){
            alert("댓글등록")
            getList();
           } 
           else{
            alert("댓글 실패")
           }
           
        }
    })
    
})
function getList(){
let xhttp= new XMLHttpRequest();// url method parametter
xhttp.open("GET",'../bankBookComment/list?bookNumber='+btn.getAttribute('data-book-bookNumber'));
xhttp.send();
xhttp.addEventListener('readystatechange',function(){
    if(this.readyState==4&& this.status==200){
        
        document.getElementById("commentList").innerHTML=this.responseText.trim();
    }
})
}