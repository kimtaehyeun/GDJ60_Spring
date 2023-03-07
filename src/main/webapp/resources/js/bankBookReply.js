// const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");

const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal');

//댓글 등록---------------------------------------------------------------
$("#replyAdd").click(function(){
// replyAdd.addEventListener("click", function () {
    // console.log("num  :  " + replyAdd.getAttribute('data-book-bookNum'))
    console.log("num  :  " + $("#replyAdd").attr('data-book-bookNum'))//Jquery
    //JS에서 사용할 가상의 form태그 생성  -FormData();
    const form = new FormData();
    // form.append("contents", replyContents.value);//<form><input type="text" name="contents" value="값"></form>
    form.append("contents", $("#replyContents").val());//Jquery
    
    // form.append("bookNumber", replyAdd.getAttribute('data-book-bookNum'))//<form><input type="text" name="bookNumber" value="값"></form>
    form.append("bookNumber", $("#replyAdd").attr('data-book-bookNum'))//jquery

    fetch("../bankBookComment/add", {
        method: "POST",
        // headers: {
        //     // 'Content-Type': 'application/x-www-form-urlencoded'
        // },
        body: form//parameter
    }).then((response) => response.text())
        .then((res) => {
            if (res.trim() == 1) {
                alert('댓글이 등록 되었습니다')
                // replyContents.value = "";
                $("#replyContents").val("");
                getList(1);
            }
            else {
                alert('댓글 등록에 실패 했습니다')
            }
        }).catch(() => {
            console.log("error 발생");
        });

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNum'));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         if(this.responseText.trim()==1){
    //             alert('댓글이 등록 되었습니다')
    //             replyContents.value="";
    //             getList();
    //         }else {
    //             alert('댓글 등록에 실패 했습니다')
    //         }

    //     }
    // })

})

//----------------------------------------------------------------------------------------------------------------------------
getList(1);

function getList(page) {

    let count = 0;

    fetch("/bankBookComment/list?bookNumber=" + replyAdd.getAttribute('data-book-bookNum') + "&page=" + page, {
        method: "GET"
        //get은 head메서드와 body속성을 가질 수 없다.
    }).then((response) => { return response.text() })
        .then((res) => {
            $("#commentListResult").html(res.trim());
        })

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("GET", "/bankBookComment/list?bookNumber=" + replyAdd.getAttribute('data-book-bookNum') + "&page=" + page);


    // xhttp.addEventListener("readystatechange", function () {
    //     if (this.readyState == 4 && this.status == 200) {
    //         commentListResult.innerHTML = this.responseText.trim();
    //         count++;
    //     }
    // })

    // xhttp.send();

    //0이 출력 : 비동기 방식이기 때문


}

//page--------------------------------------------
//1. jQuery
$("#commentListResult").on("click",".page-link",function(e){
    let page = $(this).attr("data-board-page");
    getList(page);
})
//2. 일반
// commentListResult.addEventListener("click", function (e) {
//     let pageLink = e.target;
//     if (pageLink.classList.contains("page-link")) {
//         let page = pageLink.getAttribute("data-board-page");
//         getList(page);
//     }
//     e.preventDefault();

// });
//--------------------------------------------
//delete
$("#commentListResult").on("click",".del",function(e){

// commentListResult.addEventListener("click", function (e) {
    let del = e.target;
    if (del.classList.contains("del")) {
        fetch("../bankBookComment/delete", {
            method: 'POST',
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body: "num=" + del.getAttribute("data-comment-num")
            //응답 객체에서 data를 추출하는 과정
        }).then((response) => response.text()) //then(function(response){ return response.text(); })
            //추출한 data 사용
            .then((result) => {
                if (result.trim() > 0) {
                    alert('댓글이 삭제 되었습니다');
                    getList(1);
                } else {
                    alert('삭제 실패');
                }
            });




        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST", "../bankBookComment/delete");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+del.getAttribute("data-comment-num"));
        // xhttp.addEventListener("readystatechange", function(){
        //     if(this.readyState==4&&this.status==200){
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert('댓글이 삭제 되었습니다');
        //             getList(1);
        //         }else {
        //             alert('삭제 실패');
        //         }

        //     }        
        // })
    }

    e.preventDefault();

});

//update----------------------------------------------------------------------------------------------------------------

$("#commentListResult").on("click",".update",function(e){
    let num=$(this).attr("data-comment-num");
    $("#contents").val($("#contents"+num).text());
    $("#contentsConfirm").attr("data-comment-num",num);
});



$("#contentsConfirm").click(function(){

    fetch("../bankBookComment/update",{
        method: "POST",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: "num="+$(this).attr("data-comment-num")+"&contents="+$("#contents").val()
    }).then((response) => {return response.text()})
        .then((result) => {
            if (result.trim() > 0) {
                alert('수정 성공');
                $("#closeModal").click();
                getList(1);
            } else {
                alert('수정 실패');
            }
        })
        .catch(()=>{
            alert('관리자에게 문의 하세요');
        })

})

//------------------------------------------------------------------------

