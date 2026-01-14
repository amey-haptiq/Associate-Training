//import java.util.concurrent.Semaphore;
//
//public class Driver extends Thread{
//    String[] drivers={"abc","def","wef","wer","ght"};
//    int total;
//
//    Semaphore passengerSemaphore;
//    Semaphore driverSemaphore;
//    public Driver(Semaphore passengerSemaphore,Semaphore driverSemaphore,int total){
//        this.passengerSemaphore=passengerSemaphore;
//        this.driverSemaphore=driverSemaphore;
//        this.total=total;
//    }
//    public void run(){
//       for (int i=0;i<total;i++){
//
//           try {
//               driverSemaphore.acquire();
//               String driver=drivers[i % drivers.length];
//               System.out.println("Driver:"+driver);
//               Thread.sleep(1000);
//               passengerSemaphore.release();
//           } catch (InterruptedException e) {
//               throw new RuntimeException(e);
//           }
//       }
//    }
//}
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Driver implements Runnable {
    private final String name;
    private final Semaphore passengerSemaphore;
    private final Semaphore driverSemaphore;
    private final CountDownLatch latch;

    public Driver(String name, Semaphore passengerSemaphore, Semaphore driverSemaphore, CountDownLatch latch) {
        this.name = name;
        this.passengerSemaphore = passengerSemaphore;
        this.driverSemaphore = driverSemaphore;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            driverSemaphore.acquire();
            System.out.println("Driver: " + name);
            Thread.sleep(1000); // simulate driving
            passengerSemaphore.release();
            latch.countDown(); // mark this task as complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
