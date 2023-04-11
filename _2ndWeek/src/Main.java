public class Main {
    public static void main(String[] args) {
        Print cc = new AlterPrinter();
        cc.convertPrint();
        //UML, 이론이 중간고사
        //코테는 안하고 코드가 주어지면 특정 패턴을 구현하고 싶을때 빈칸 채우기~~~ 가 중간고사

    }
}

class Converter {
    int i = 220;
    void convert(){
        System.out.println(i);
    }
}

interface Print{
    void convertPrint();
}

// 교직 이수
class AlterPrinter extends Converter implements Print {

    @Override
    public void convertPrint() {
        Converter c = new Converter();
        c.i = 12;
        c.convert();
    }
}