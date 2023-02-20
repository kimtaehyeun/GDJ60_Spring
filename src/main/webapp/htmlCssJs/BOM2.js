const btn=document.getElementById("btn");
let r1=document.getElementById("r1");
let c1=document.getElementById("c1");
let table= document.getElementById("table");


const select=document.getElementById("s1");
const check=document.getElementById("s2");
const options=document.getElementsByClassName("options");//배열의 변수명(배열과유사함)
const radios=document.getElementsByName("r1");

const ch=document.getElementsByClassName("ch");
    for(let i=0; i<ch.length;i++){
    ch[i].addEventListener("click",function(){
        console.log(this.checked);
        for(let j=0; j<ch.length; j++){
            ch[j].checked=this.checked;
        }
    })
}

s1.addEventListener("click",function(){
    for(let i=0;i<options.length;i++){
        if(options[i].selected){
            console.log(options[i].value);
            break;
        }
    }
})
s2.addEventListener("click",function(){
    for(let i=0; i<radios.length;i++){
        if(radios[i].checked){
            console.log(radios[i].value);
            break;
        }
    }
})

btn.addEventListener("click",function(){
    
    
    let result='';
    for(let i=0; i<r1.value*1;i++){
        result=result+"<tr>";
        for(let j=0; j<c1.value*1;j++){
            result=result+"<td></td>";
        }
        result=result+"</tr>";
    }
    table.innerHTML=result;
})