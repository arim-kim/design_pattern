//public class practice {
//    public static void main(String[] args) {
//
//        TicketMaker ticketMaker = TicketMaker.getInstance();
//
//        int ticket1 = ticketMaker.getNextTicketNumber();
//        int ticket2 = ticketMaker.getNextTicketNumber();
//
//        System.out.println(ticket1);
//        System.out.println(ticket2);
//
//    }
//}
//
//
//// single 스레드일때는 상관이 없음 - multi thread 환경일때 (서순이 뒤집힐 수 있다.)
//class TicketMaker{
//
//    private static ticketMaker instance = new ticketMaker();
//    private int ticket = 1000;
//
//    public static ticketMaker getInstance() {
//        return instance;
//    }
//
//    // 이렇게 쓰면 멀티 스레드 환경에서 문제 --------------------------
//    //    public int getNextTicketNumber(){
//    //        return ticket++; // 멀티스레드일 경우엔 어느시점에서 호출하냐에 따라 값이 바뀐다
//    //    }
//    // ---------------------------------------------------------
//
//    // 해결법 1 - sync
//    public synchronized int getNextTicketNumber(){
//        return ticket++; // 멀티스레드일 경우엔 어느시점에서 호출하냐에 따라 값이 바뀐다
//    }
//
//
//    // 얼뜻보면 singleTone but, multi-thread에서 문제... ---------
//    // private static TicketMaker instance = null;
//
//    //    public static TicketMaker getInstance() {
//    //        if(instance == null) {
//    //            instance = new TicketMaker();
//    //        }
//    //        return instance;
//    //    }
//    // ---------------------------------------------------------
//
//}
