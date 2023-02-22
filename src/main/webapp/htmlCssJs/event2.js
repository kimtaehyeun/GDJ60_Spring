const b1 = window.document.getElementById("b1");
const p1 = window.document.getElementById("p1");

const b2 = window.document.getElementById("b2");
const p2 = window.document.getElementById("p2");

const google = window.document.getElementById("google");

//Element가 가지고 있는 기본 동작(event, a, submit,,,)을 중단 
google.addEventListener("click",function(event){
    console.log("google Click");
    event.preventDefault();
    //return false;
})
//캡쳐링과 중단
b1.addEventListener('click', function(e){
    console.log('button click');
    console.log(e);
},true);

p1.addEventListener("click",function(event){
    console.log('div click');
    console.log(event);
    event.stopPropagation();
},true);

//버블링과 중단.
b2.addEventListener('click', function(e){
    console.log('button click');
    console.log(e);
    // e.stopPropagation();
    console.log("button this : ", this );
},false);

p2.addEventListener("click",function(event){
    console.log('div click');
    console.log(event);
    console.log("currentTarget : ", event.currentTarget);
    console.log("target : ", event.target);
    console.log("this : ",this);
},false);