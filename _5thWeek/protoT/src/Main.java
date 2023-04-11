import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // 인스턴스 생성
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');

        // 등록
        manager.register("Strong", underlinePen);
        manager.register("warning", mbox);

        // 복제된 인스턴스가 들어옴
        Product p1 = manager.create("Strong");
        p1.use("hello, world");

    }
}

// prototype
interface Product extends Cloneable{
    abstract void use(String s);
    abstract Product createCopy();
}

// client
class Manager{
    Map<String, Product> showcase = new HashMap<>();

    void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    Product create(String protoName){
        Product p = showcase.get(protoName);
        return p.createCopy(); //MessageBox, UnderlinePen에서 반환된 Product를 반환
    }
}

class MessageBox implements Product {

    char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {

    }

    @Override
    public Product createCopy() {
        Product p =  null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}


// concretePrototype
class UnderlinePen implements Product {
    char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {

    }

    @Override
    public Product createCopy() {
        Product p =  null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}