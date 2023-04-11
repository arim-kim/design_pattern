public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');

        AbstractDisplay d2 = new StringDisplay("Hello, World.");

        d1.display();
        d2.display();
    }
}

abstract class AbstractDisplay {
    //open, print, close classes are abstract methods
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0;i < 5; i++) {
            print();
        }
        close();
    }
}

class CharDisplay extends AbstractDisplay{
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}

class StringDisplay extends AbstractDisplay{
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    void printLine(){
        System.out.print("+");
        for(int i =0; i<string.getBytes().length; i++) System.out.print("-");
        System.out.println("+");
    }
}