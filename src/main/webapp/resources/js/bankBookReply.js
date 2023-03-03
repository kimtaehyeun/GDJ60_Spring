const btn = document.getElementById("btn")
const textArea= document.getElementById("textArea")
const parent = document.getElementById("parent");
const commentList=document.getElementById("commentList");
let page=1;
getList(page);
btn.addEventListener("click",function(){
    
    let xhttp= new XMLHttpRequest();// url method parametter
    xhttp.open("POST",'../bankBookComment/add'); 
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("contents="+textArea.value+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));//파라미터 넣기
    xhttp.addEventListener('readystatechange',function(){
        if(this.readyState==4&& this.status==200){
           if(this.responseText.trim()==1){
            alert("댓글등록")
            getList(page);
           } 
           else{
            alert("댓글 실패")
           }
           
        }
    })
    
})

function getList(page){
    let xhttp= new XMLHttpRequest();// url method parametter
    xhttp.open("GET",'../bankBookComment/list?bookNumber='+btn.getAttribute('data-book-bookNumber')+"&page="+page);
    xhttp.send();
    xhttp.addEventListener('readystatechange',function(){
        if(this.readyState==4&& this.status==200){
            
            commentList.innerHTML=this.responseText.trim();
        }
    })
}
commentList.addEventListener("click",function(e){
    if(e.target.getAttribute("data-board-page")!=null)
     getList(e.target.getAttribute("data-board-page"));
})