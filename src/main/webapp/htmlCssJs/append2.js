const d1=document.getElementById("d1");//div
// const del=document.getElementById("del");//button
const d1_1=document.getElementById("d1_1");
// const d2= document.getElementById("d2");
const result= document.getElementById("result");//div
const add = document.getElementById("add");//button

let count=0;

const dels=document.getElementsByClassName("dels");

result.addEventListener("click",function(e){
    // console.log(e.currentTarget,e.target);
    console.log("currunt : ",e.currentTarget);
    console.log("target : ",e.target);
    // console.log(e.target.classList.contains("dels"));
    if(e.target.classList.contains('dels')){
        let id=e.target.getAttribute("data-delete-id");
        document.getElementById(id).remove();
        console.log('delete : ',id);
    }
    
})

add.addEventListener("click", function(){
    let d=document.createElement("div");//버튼각각div
    let btn= document.createElement("button");//delete버튼

    let n=document.createTextNode("delete");//버튼text

    let attr=document.createAttribute("class");//class넣기
    attr.value="dels";
    btn.setAttributeNode(attr);

    attr=document.createAttribute("data-delete-id");//data-속성 넣기.
    attr.value='del'+count;
    btn.setAttributeNode(attr);


    attr=document.createAttribute("id");    //id넣기
    attr.value='del'+count;
    d.setAttributeNode(attr);
    count++;

    
    //합체
    btn.appendChild(n);
    d.appendChild(btn);
    result.append(d);
})






d1.addEventListener("click",function(){
    // d1.removeChild(d1_1);
    d2.remove();

})