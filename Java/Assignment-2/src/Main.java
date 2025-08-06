import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User u;
        Message m;
        Scanner s = new Scanner(System.in);
        Map<User, List<Message>> history = new HashMap<>();
        System.out.println("You wanna join chatroom:");
        String answer=s.next();
        s.nextLine();
        if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("Answer in yes or no");
        }

        if(answer.equalsIgnoreCase("yes")) {
            while (true) {
                System.out.println("Your username:");
                String username = s.nextLine();
                if (username.trim().isEmpty() || username.equalsIgnoreCase("Exit")) {
                    break;
                }
                System.out.println("Message:");
                String message = s.nextLine();

                u = new User(username);
                m = new Message<String>(message);
                u.storeuser(username);


                history.computeIfAbsent(u, k -> new ArrayList<>()).add(m);


            }
//        System.out.println(u.allUsers());
//        System.out.println(m.getMessages());
            System.out.println(history);

            for (Map.Entry<User, List<Message>> entry : history.entrySet()) {
                System.out.println(entry.getKey().getUserName() + ":");
                for (Message m1 : entry.getValue()) {
                    System.out.println("  - " + m1.getMessage());
                }


            }
        }

    }

}