const files = window.document.getElementById("files");
const fileAddbtn = window.document.getElementById("fileAddbtn");
const fileList=window.document.getElementById("fileList");
const deletebtn = window.document.getElementById("deletebtn");
const dels = window.document.getElementsByClassName("dels")
let count = 1;
let max = 3;
let param ='files'
let deleteatt=0;



function setMax(m){
    max=m;
}

fileList.addEventListener("click",function(e){
    if(e.target.classList.contains('dels')){
        let id=e.target.getAttribute("data-delete");
        document.getElementById(id).remove();

    }

})
fileAddbtn.addEventListener("click",function(e){


    if(count>=max){
        alert(max+'개만 가능')
        
        return;
    }
    
    //태그 3개 만들기
    let d=document.createElement('div');
    let label=document.createElement('label');
    let input= document.createElement('input');
    let button = document.createElement("button");
    let text = document.createTextNode("X");
    
    //속성
    let att = document.createAttribute("class");

    //1. 부모
    att.value='mb-3';
    d.setAttributeNode(att);

    //2. label
    att = document.createAttribute('for');
    att.value='files'
    label.setAttributeNode(att);

    att = document.createAttribute('class');
    att.value='form-label'
    label.setAttributeNode(att);

    //3. input
    att = document.createAttribute('type');
    att.value='file'
    input.setAttributeNode(att);
    
    att = document.createAttribute('class');
    att.value='form-control'
    input.setAttributeNode(att);
    
    att = document.createAttribute('id');
    att.value='files'+count
    input.setAttributeNode(att);

    att = document.createAttribute('name');
    att.value='files'
    input.setAttributeNode(att);
    
    att = document.createAttribute('data-delete');
    att.value=count;
    input.setAttributeNode(att);
    //delete 패턴

    att = document.createAttribute("class");
    att.value='dels';
    button.setAttributeNode(att);

    att = document.createAttribute('type');
    att.value='button'
    button.setAttributeNode(att);
    
    att = document.createAttribute('id');
    att.value=count
    button.setAttributeNode(att);
    button.appendChild(text);

    


    //합체
    d.appendChild(label);
    d.appendChild(input);
    d.appendChild(button);
    fileList.prepend(d);
    count++
})
