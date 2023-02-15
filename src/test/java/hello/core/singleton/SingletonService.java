package hello.core.singleton;

public class SingletonService {

    //외부에서 접근 불가능한 단 하나의 클래스 객체 인스턴스를 생성한다
    private static final SingletonService instance = new SingletonService();

    //클래스 객체 인스턴스를 가져올 수 있는 유일한 메소드
    public static SingletonService getInstance(){
        return instance;
    }

    //private으로 외부에서 클래스 인스턴스 생성을 막는다
    private SingletonService(){

    }

}
