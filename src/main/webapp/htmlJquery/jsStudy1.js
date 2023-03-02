
//css 선택자 유형
const btn1 = document.querySelector("#btn1"); //document.getElementById("btn1");
    //querySelector == querySelectAll[0]

const buttons =document.querySelectorAll(".buttons") //document.getElementsByClassName("buttons");

const d1 = document.querySelector("#di > .buttons li")

btn1.addEventListener("click",function(){
    console.log("a")
})

// for(let i=0; i<buttons.length; i++){
//     buttons[i].addEventListener("click",function(){
//         console.log("B")
//     })
// }
for(let b of buttons){
    b.addEventListener("click",function(){
        console.log("b")
    })
}