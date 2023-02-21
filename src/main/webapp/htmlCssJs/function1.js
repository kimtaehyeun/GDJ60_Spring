
const d1 = window.document.getElementById("d1");
//전역변수
let n='iu';
var old="iu";
//function 선언


function f1 (){
    console.log("function Test");
    console.log(n);
    var old="winter";
}

//매개변수 선언시 let, const는 생략!
        // function f2(let n1, let n2){
function f2(n1, n2){

    //지역변수
    let name='iu';
    return n1+n2;
}


//function 호출
f1();
let result= f2(1,2);
console.log(result);

//js의 단점 구조에 엄격하진 않지만 개발자가 잘찾아야함.-> typescript프로그램으로 해결
console.log(name);
// console.log(n1);

console.log("old: " + old);

// 익명함수 
//함수를 변수에 담을 수 있다.
let fun = function(){
    console.log("익명함수");
    return "fun";
}
fun();
//매개변수로 함수도 받기 가능.->함수를 매개변수로 넣을때는 변수 명으로 ()x 괄호없이 작성
function f3(f){
    console.log("f3 : ",f(),1);
}

function callback1(){
    console.log("callback1");
}
let callback2 = function(){
    console.log("callback2");
}

// 다른곳에서도 같은 함수를 사용하고 싶을 때 사용하는 익명함수.
// d1.addEventListener("click",callback1);
// d1.addEventListener("click",callback1);

//여기에서만 사용하고 싶을때 익명함수.
d1.addEventListener("click",function(){
    callback1();
    callback2();
});
