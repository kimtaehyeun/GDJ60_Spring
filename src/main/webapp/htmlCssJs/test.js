console.log("Hello world");

//변수 선언과 대입
//데이터타입 변수명;
let num1=1;
num1="abc";


//옛날버전에선은 var사용, Hoisting에 문제가 발생, 쓰지말것 권장
var num2 = 4;

//상수형 변수 const = (java)final
const num3=5;


let num4 =null;
//연산자
 num4= num1+num2// -,*,/,%

num4= num1>num2;    // <, <=, >=, ==, !=, === , !==

num4=1;
num4=num4+1;
num4++

num1=3;
num2='3';
num4=null;
console.log(typeof num4);


console.log(num1==num2);//값만 같으면 됨
console.log(num1===num2);//===는 값도 같고 타입도 같아야함
console.log('NUM3 : '+num3);
console.log('NUM1 : '+num1);