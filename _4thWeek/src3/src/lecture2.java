
public class lecture2 {
    public static void main(String[] args) {

        Task t = new Task();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(50);
            t1.interrupt();
            t2.interrupt();
            t3.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ticketMaker {

    private static ticketMaker instance = new ticketMaker();
    private int ticket = 1000;


    //    // 얼뜻보면 singleTone but, multi-thread에서 문제... ---------
    //    // private static TicketMaker instance = null;
    //
    //    //    public static TicketMaker getInstance() {
    //    //        if(instance == null) { // 동시에 null일 수가 있으므로.. 싱글톤 체크를 동시에할 수도
    //    //            instance = new TicketMaker();
    //    //        }
    //    //        return instance;
    //    //    }
    //    // ---------------------------------------------------------

    // 이렇게 싱크로나이즈를 넣으면 논리구조상 이점을 가짐 - 무슨말이야 ;;;;;;;;;;; - 코드 올려준대 ㅎㅋ...
    public static ticketMaker getInstance() {
        if(instance == null) {
            synchronized (ticketMaker.class) {
                if(instance == null) {
                    instance = new ticketMaker();
                }
            }
        }

        return instance;
    }

    public synchronized int getNextTicketNumber(){
        return ticket++; // 멀티스레드일 경우엔 어느시점에서 호출하냐에 따라 값이 바뀐다
    }

}

class Task implements Runnable {
    @Override
    public void run() {
        int count = 0;
        try {
            ticketMaker tickermaker = ticketMaker.getInstance();
            System.out.println("Thread started");
            while(true) {
                count ++;
                System.out.println(tickermaker.getNextTicketNumber());
                Thread.sleep(5);
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted" + count);
        }
    }
}