import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class User implements Comparable<User> {
    Set<String> user=new HashSet<>();
    String userName;
    public User(String username){
        this.userName=username;
    }

    public String getUserName(){
        return this.userName;
    }

    public void storeuser(String username){
        user.add(this.userName);
    }
    @Override
    public int compareTo(User other){
        return this.userName.compareToIgnoreCase(other.userName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userName.equalsIgnoreCase(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName.toLowerCase());
    }

    public Set<String> allUsers(){
//        System.out.println(user);
        return user;
    }

}
