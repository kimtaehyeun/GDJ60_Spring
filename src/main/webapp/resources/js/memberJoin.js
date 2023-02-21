const idcheck=window.document.getElementById("idcheck");
const id=window.document.getElementById("id");
//pw
const pw1 = window.document.getElementById("pw1");
const pw2 = window.document.getElementById("pw2");
const pw1check = window.document.getElementById("pw1check");
const pw2check = window.document.getElementById("pw2check");

const name1=window.document.getElementById("name");
const namecheck=window.document.getElementById("namecheck");
const address=window.document.getElementById("address");
const addresscheck=window.document.getElementById("addresscheck");
const phone=window.document.getElementById("phone");
const phonecheck=window.document.getElementById("phonecheck");
const email=window.document.getElementById("email");
const emailcheck=window.document.getElementById("emailcheck");
const btn=document.getElementById("btn");
const frm=document.getElementById("frm")
// let stack1=false;
// let stack2=false;
// let stack3=false;
// let stack4=false;
// let stack5=false;
// let stack6=false;
// let stack7=false;
let checks=[false,false,false,false,false,false,false]

//----------------색나타내기------------------------






//--------------------------------------


id.addEventListener("blur",function(){
    if(id.value==0||id.value==null){
        
        // stack1=false;
        checks[0]=false;
        
            idcheck.classList.remove("blueResult")
            idcheck.classList.add("redResult")
            
       
        idcheck.innerHTML="id를 입력해주세요"
    }
    else{
    idcheck.innerHTML="알맞은 아이디입니다."
    // stack1=true;
    checks[0]=true;
    
        idcheck.classList.remove("redResult")
        idcheck.classList.add("blueResult")
        
    
}
})


pw1.addEventListener("keyup",function(){
    if(pw1.value.length<6||pw1.value.length>12){
        pw1check.innerHTML="pw를 6자이상 12글자 이하로 입력해주세요";
        pw1check.classList.remove("blueResult")
        pw1check.classList.add("redResult")
    }
    else{
        pw1check.innerHTML="알맞은비번";
        
        pw1check.classList.remove("redResult")
        pw1check.classList.add("blueResult")
            
        
    }
})
pw1.addEventListener("blur",function(){
    if(pw1.value!=''){
        // stack2=true;
        checks[1]=true;
    }
    else{
        pw1check.innerHTML='pw는 필수입니다.'
        // stack2=false;
        checks[1]=false;
        pw1check.classList.remove("blueResult")
        pw1check.classList.add("redResult")
    }
})
pw1.addEventListener("change",function(){
    checks[2]=false;
    pw2.value="";
    
        
    
})

pw2.addEventListener("blur",function(){
    if(pw1.value==pw2.value){
        pw2check.innerHTML="확인되었습니다."
        // stack3=true;
        checks[2]=true;
        
        pw2check.classList.remove("redResult")
        pw2check.classList.add("blueResult")
            
        
    }
    else{
        pw2check.innerHTML="다시한번 확인해주세요."
        // stack3=false;
        checks[2]=false;
        pw2check.classList.remove("blueResult")
        pw2check.classList.add("redResult")
    }
})

// pw1.addEventListener("blur",function(){
//     pw2check.innerHTML="pw를 다시한번 입력해주세요"
//     pw1.addEventListener("change",function(){
//         pw2.addEventListener("blur",function(){
//             if(pw1.value==pw2.value){
//                 pw2check.innerHTML="확인되었습니다."
//                 // stack3=true;
//                 checks[2]=true;
//             }
//             else{
//                 pw2check.innerHTML="다시한번 확인해주세요."
//                 // stack3=false;
//                 checks[2]=false;

//             }
//         })
//     })
// })

name1.addEventListener("blur",function(){
    if(name1.value==0||name1.value==null){
        namecheck.innerHTML="이름를 입력해주세요"
        namecheck.classList.remove("blueResult")
        namecheck.classList.add("redResult")
        // stack4=false;
        checks[3]=false;

    }
    else{
    namecheck.innerHTML="성공"
    // stack4=true;
    checks[3]=true;
    
    namecheck.classList.remove("redResult")
    namecheck.classList.add("blueResult")
        
    
}
})
address.addEventListener("blur",function(){
    if(address.value==0||address.value==null){
        addresscheck.innerHTML="address를 입력해주세요"
        addresscheck.classList.remove("blueResult")
        addresscheck.classList.add("redResult")
        // stack5=false;
        checks[4]=false;

    }
    else{
    addresscheck.innerHTML="성공"
    // stack5=true;
    checks[4]=true;
    
    addresscheck.classList.remove("redResult")
    addresscheck.classList.add("blueResult")
        
    
}
})
phone.addEventListener("blur",function(){
    if(phone.value==0||phone.value==null){
        phonecheck.innerHTML="phone번호를 입력해주세요"
        phonecheck.classList.remove("blueResult")
        phonecheck.classList.add("redResult")
        // stack6=false;
        checks[5]=false;

    }
    else{
        phonecheck.innerHTML="성공"
    // stack6=true;
    checks[5]=true;
    
    phonecheck.classList.remove("redResult")
    phonecheck.classList.add("blueResult")
        
    
}
})
email.addEventListener("blur",function(){
    if(email.value==0||email.value==null){
        emailcheck.innerHTML="email 입력해주세요"
        emailcheck.classList.remove("blueResult")
        emailcheck.classList.add("redResult")
        // stack7=false;
        checks[6]=false;

    }
    else{
        emailcheck.innerHTML="성공"
    // stack7=true;
    checks[6]=true;
    
    emailcheck.classList.remove("redResult")
    emailcheck.classList.add("blueResult")
        
    
}
})

//button

// function f2(){
//     if(stack1==true&&stack4==true&&stack3==true&&stack2==true){
//         window.alert("전송되었습니다.");
//         btn.setAttribute("type","submit");
//     }
//     else
//         window.alert("실패");
// }
//form 전송

btn.addEventListener("click",function(){
    // if(stack1&&stack2&&stack3&&stack4&&stack5&&stack6&&stack7){
    if(!checks.includes(false)){
        window.alert("전송되었습니다.");
        frm.submit();
    }
    else{
    window.alert("전송실패")
    }
})