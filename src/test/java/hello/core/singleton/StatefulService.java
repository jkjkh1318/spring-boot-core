package hello.core.singleton;

public class StatefulService {

    // singletone 객체에서의 stateful 공유 문제를 해결하기 위해 필드 대신 "지역변수" 사용
//    private int price; //상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name= " + name + ", price= " + price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
