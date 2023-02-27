// 딜리트 버튼 누르면 메서드는 포스트로 바꿈

const frm= window.document.getElementById("frm");
const del = window.document.getElementById("del");

del.addEventListener("click",function(){
    frm.setAttribute("action","./delete")

    // let attr = document.createAttribute("method");
    // attr.value='post'
    // frm.setAttributeNode(attr);
    // del.setAttribute("type","submit");
    let check=window.confirm("정말 삭제 하시겠습니까?");
    if(check){
     
    frm.setAttribute("action","delete");
    frm.setAttribute("method","post");
    frm.submit();
   
    }    
})

