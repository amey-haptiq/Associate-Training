import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Instant;

public class Message<T> implements Comparable< Message<T>> {
    Instant timestamp;
    T message;
    List<T> msg=new ArrayList<>();
    public Message(T message){
      this.timestamp=Instant.now();
      this.message=message;
    }
  // public void storeMessage(T message)  {
   //    msg.add(message);
  // }
   public T getMessage(){
        return this.message;
   }
   //public List<T> getMessages(){
   //    return msg;
 //  }



    @Override
    public int compareTo(Message<T> o) {
        return this.timestamp.compareTo(o.timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
