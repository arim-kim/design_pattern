public class ThreeInstances {
    public static void main(String[] args) {


        try{
            ThreeInstances instances1 = ThreeInstances.getInstace();
            ThreeInstances instances2 = ThreeInstances.getInstace();
            ThreeInstances instances3 = ThreeInstances.getInstace();

            System.out.println("instance1 number : " + instances1.instaceNum);
            System.out.println("instance2 number : " + instances2.instaceNum);
            System.out.println("instance3 number : " + instances3.instaceNum);

            ThreeInstances instances4 = ThreeInstances.getInstace();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static ThreeInstances[] instances = new ThreeInstances[3];
    private static int cnt = 0;
    private int instaceNum;

    private ThreeInstances(int instaceNum){
        this.instaceNum = instaceNum;
    }


    public static synchronized ThreeInstances getInstace() throws Exception{
        if(cnt >= 3) {
            throw  new Exception("cannot create more than 3");
        }

        ThreeInstances instance= new ThreeInstances(cnt);
        instances[cnt++] = instance;
        return instance;
    }

    public int getNum(){
        return instaceNum;
    }

}
