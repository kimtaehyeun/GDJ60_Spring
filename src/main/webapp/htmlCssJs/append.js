const list = window.document.getElementById("list");
const add = window.document.getElementById("add");

add.addEventListener('click', function(){
    // list.innerHTML=li; -> 덮어쓰기

    // <li>d</li>

    let li = document.createElement('li');//새로운 엘리먼트 생성
    let text=document.createTextNode('d'); //새로운 앨리먼트에 넣을 텍스트
    li.appendChild(text);//합체



    // <li><button>click</button></li>

    let li1=document.createElement('li');
    let bt1=document.createElement('button');
    let text1=document.createTextNode('click');
    li1.appendChild(bt1);
    // bt1.appendChild(text1);
    
    
    
    
    //속성추가
    let attr = document.createAttribute("class");
    // attr.value='btn bg';
    attr.value='btn';
    attr.value=attr.value+' bg';
    
    bt1.setAttributeNode(attr);
    bt1.appendChild(text1);
    



    // list.append(li);
    // list.prepend(li1)
    // list.before(li1);
    list.after(li1);
})
