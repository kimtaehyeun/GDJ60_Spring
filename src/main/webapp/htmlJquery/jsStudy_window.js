const btn1=document.getElementById('btn1');
btn1.addEventListener("click",function(){
    window.open("./new.html",'test','width=800,height=400, top=100, left=200');
    clearInterval(d);
})

//setTimeout
setTimeout(function(){
    alert("timeout")
},1000)//setTimeout(실행해야할 Callback함수, 얼마나 시간이 흐른뒤에 사용할지)

let d = setInterval(function(){
    console.log("setInterval")

},1000);




// while(true){
//     for(let i=0; i<10000; i++){
//         console.log("while")
//     }
// }