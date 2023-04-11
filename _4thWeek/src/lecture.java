public class lecture {
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

    public static ticketMaker getInstance() {
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