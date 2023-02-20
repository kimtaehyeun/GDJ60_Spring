const btn = window.document.getElementById("btn");
const btn2=window.document.getElementById("btn2");
const OKbtn= window.document.getElementById("OKbtn");


btn.addEventListener("click", function(){
    let c2 = window.document.getElementById("c2");
    console.log(c2.innerText);
    console.log(c2.innerHTML);
    // c2.innerText='test';
    c2.innerHTML='<img src="../resources/images/iu1.jpg">';
});
btn2.addEventListener("click",function(){
    let c3=window.document.getElementById("c3");
    let v= c3.title;
    v=c3.getAttribute("title");
    console.log(v);
})
OKbtn.addEventListener("click",function(){
    
    let t2=window.document.getElementById("t2");
    let va =t2.value;
    // let va=t2.getAttribute("value");
    console.log(va);
})
let c1=window.document.getElementById("c1");
// alert(c1);
// console.log(c1);
console.log(c1.innerText);
console.log(c1.innerHTML);
// c1.innerText="chageText"