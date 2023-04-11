import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataBase dataBase1 = DataBase.getInstance();
        DataBase dataBase2 = DataBase.getInstance();

        System.out.println(dataBase1 == dataBase2); // 인스턴스가 하나인지 체크

        List<User> userList = dataBase2.getUser();
        for(User user : userList) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + "_" + user.getEmail());
        }

        User new_user = new User("alice", "smith", "rlarim722@gmail.com");
        dataBase1.addUser(new_user);

        System.out.println("added user : " + new_user.getFirstName() + " " + new_user.getLastName() + "_" + new_user.getEmail());

        System.out.println("---- all user---- ");

        for(User user : userList) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + "_" + user.getEmail());
        }
    }
}

class DataBase {

    private static volatile DataBase instance;
    List<User> userList;

    private DataBase() {
        userList = new ArrayList<>();
        userList.add(new User("airm", "kim", "ww81er@gmail.com"));
        userList.add(new User("hong", "kim", "ww71er@gmail.com"));

    }

    static DataBase getInstance(){
        if(instance == null) {
            synchronized (DataBase.class) {
                if(instance == null) {
                    instance = new DataBase();
                }
            }
        }

        return instance;
    }

    List<User> getUser(){
        return userList;
    }

    void addUser(User user){
        userList.add(user);
    }
}

class User{
    private String firstName;
    private String LastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }
}