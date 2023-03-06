const btn = document.getElementById("btn")
const textArea= document.getElementById("textArea")
const parent = document.getElementById("parent");
const commentList=document.getElementById("commentList");

// const pageLink=document.querySelectorAll("page-link");
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
    // if(e.target.getAttribute("data-board-page")!=null)
    if(e.target.classList.contains("page-link"))
     getList(e.target.getAttribute("data-board-page"));

     e.preventDefault();
})

// pageLink.forEach(function(e){
//     console.log("p : ",p );
// })

//delete-------------------------------------------------------------------

commentList.addEventListener("click",function(e){
    let deletebtn = e.target
    if(deletebtn.classList.contains("del")){
        let xhttp= new XMLHttpRequest();// url method parametter
        xhttp.open("POST",'../bankBookComment/delete');
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+deletebtn.getAttribute("data-comment-num"));
        xhttp.addEventListener('readystatechange',function(){
            if(this.readyState==4&& this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert("삭제성공");
                    getList(page);
                }
                else{
                    alert("삭제 실패")
                }
            }
        })
    }
     
})
//------------------------------------------------------------------
//update====================================================================
commentListResult.addEventListener("click", function(e){
    let updateButton = e.target;
    if(updateButton.classList.contains("update")){
        //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = updateButton.getAttribute("data-comment-num");
        let contents = document.getElementById("contents"+num);
        // console.log(contents);
        // contents.innerHTML='<textarea name="" id="" cols="30" rows="3">'+contents.innerHTML+'</textarea>';
        contents.firstChild.removeAttribute("readonly");
        let btn = document.createElement("button");
        let attr = document.createAttribute("class");
        attr.value="btn btn-primary";
        btn.setAttributeNode(attr);
        contents.appendChild(btn);
        attr = document.createTextNode("확인");
        btn.appendChild(attr);

        btn.addEventListener("click", function(){
            console.log(contents.firstChild.value);
            console.log(num);

            let xhttp = new XMLHttpRequest();
            xhttp.open("POST", "../bankBookComment/update");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num="+num+"&contents="+contents.firstChild.value);
            xhttp.addEventListener("readystatechange", function(){
                if(this.readyState==4&&this.status==200){
                    let result = this.responseText.trim();
                    if(result>0){
                        alert('수정 성공');
                        getList(1);
                    }else {
                        alert('수정 실패');
                    }
                    
                }        
            })

        })
       
    }

    e.preventDefault();
    
});



/*
commentList.addEventListener("click",function(e){
    let updatebtn = e.target
    if(updatebtn.classList.contains("update")){
        let xhttp= new XMLHttpRequest();
        xhttp.open("GET",'../bankBookComment/update?num='+updatebtn.getAttribute("data-comment-num")+"&contents="+updatebtn.getAttribute("data-comment-contents"));
        xhttp.send();
        xhttp.addEventListener('readystatechange',function(){
            if(this.readyState==4&& this.status==200){
                commentList.innerHTML=this.responseText.trim();
            }
        })
    }
     
})
//updatelist
commentList.addEventListener("click",function(e){
    let submitbtn = e.target
    if(submitbtn.classList.contains("submitbtn")){
        let xhttp= new XMLHttpRequest();
        xhttp.open("POST",'../bankBookComment/update');
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("contents="+document.getElementById("contents").value+"&num="+submitbtn.getAttribute("data-comment-num"));
        xhttp.addEventListener('readystatechange',function(){
            if(this.readyState==4&& this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert("수정성공");
                    getList(page);
                }
                else{
                    alert("수정실패")
                }
            }
        })
    }
     
})
*/
//==================================================