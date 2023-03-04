package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter //lombok의 annotation
@Setter //lombok의 annotation
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(13);
        System.out.println(helloLombok.getAge());

        helloLombok.setName("aasd");
        System.out.println(helloLombok.getName());
    }
}
