let car = {
    brand : 'AUDI',
    price : 3000,
    info:function(){
        console.log(this.brand, this.price);
    }
}
class Student{
    #n='';
    #kor;   // '#' = private;

    //setter, getter
    set n(n){
        this.#n = n;
    }
    get n(){
        return this.#n;
    }

    set kor(kor){
        this.#kor = kor;
    }
    get kor(){
        return this.#kor;
    }
    info(){
        console.log(this.#n, this.#kor);
    }

}


const btn1 = document.getElementById('btn1');

btn1.addEventListener("click",function(){
    // console.log(car.brand);
    // car.info();

    // car.color='red';

    // console.log('for in')
    // for(let v in car){
    //     console.log(car[v])
    // }
    let s = new Student();  //클래스기 때문에 객체 생성
    s.n='iu';
    s.kor=100;
    s.eng=200;
    s.info()
    console.log(s.eng);
    console.log(s.n);
    console.log(s.kor);

})
