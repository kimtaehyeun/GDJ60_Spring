let d1 = document.getElementById("d1");
let input1 = document.getElementById("input1");
let input2 = document.getElementById("input2");
let input3 = document.getElementById("input3");
const btn = document.getElementById("btn");
d1.addEventListener("click",function(){
    console.log("Click");
})
d1.addEventListener("mouseenter",function(){
    console.log("MouseEnter Event");
})

input1.addEventListener("keyup",function(){
    console.log("keyup Event")
})
input2.addEventListener("focus",function(){
    console.log("focus Event")
})
input2.addEventListener("blur",function(){
    console.log("blur event")
})

input2.addEventListener("change",function(){
    console.log("chage event")
})
input3.addEventListener("change",function(){
    console.log(input3.value);
}, false)

btn.onclick=function(){
    input2.focus();
}