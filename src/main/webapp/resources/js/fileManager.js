const fileList=window.document.getElementById("fileList");
const btn=window.document.getElementById("btn");
let click=0;
let maxclick=1;
let param='pic';

function setParam(p){
    param=p;
}
function setMax(m){
    maxclick=m;
}

btn.addEventListener('click',function(){

    if(click>=maxclick){
        
            alert(maxclick+"개만가능")
            fileList.removeChild(btn);
           return;
    
    }

    //태그
    let d=document.createElement('div');//부모
    let label=document.createElement('label');//자식1
    let input=document.createElement('input');//자식2

    //속성
    let attclass = document.createAttribute("class");
    let attfor = document.createAttribute("for");
    let atttype= document.createAttribute("type");
    let attid=document.createAttribute("id");
    let attname=document.createAttribute("name");
    let text= document.createTextNode('이미지');
    //속성값 넣기

    //1.div부모
    attclass.value='mb-3';
    d.setAttributeNode(attclass);
    // div.classList.add('mb-3');
    

    //2-1. label
    attfor.value='files'
    attclass = document.createAttribute("class");
    attclass.value='form-label';
    // label.classList.add('form-label')
    label.setAttributeNode(attfor);
    label.setAttributeNode(attclass);
    label.appendChild(text);

    //2-2. input
    atttype.value='file';
    attclass = document.createAttribute("class");
    attclass.value='form-control'
    attid.value='files';
    attname.value=param;
    // input.classList.add('form-control')

    input.setAttributeNode(atttype);
    input.setAttributeNode(attid);
    input.setAttributeNode(attname);
    input.setAttributeNode(attclass);
    //합체
    d.appendChild(label);
    d.appendChild(input);

    fileList.prepend(d);
    click++
})

