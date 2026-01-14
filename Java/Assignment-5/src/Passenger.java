//import java.util.Scanner;
//import java.util.concurrent.Semaphore;
//
//public class Passenger  extends Thread{
//
//
//    String[] passengersList={"Keadar","Amey","Rahul","Rohit","Aditya","Keadar1","Amey1","Rahul1","Rohit1","Aditya1"};
//    Semaphore passengerSemaphore;
//    Semaphore driverSemaphore;
//    int total;
//    public Passenger(Semaphore passengerSemaphore,Semaphore driverSemaphore,int total){
//        this.passengerSemaphore=passengerSemaphore;
//        this.driverSemaphore=driverSemaphore;
//        this.total=total;
//    }
//    public void acceptPassenger(){
//        Scanner s=new Scanner(System.in);
//        System.out.println("enter passenger name:");
//        for(int i=0;i<passengersList.length;i++){
//            passengersList[i]=s.nextLine();
//        }
//    }
//    public void run(){
//
//        for(int i=0;i<passengersList.length;i++){
//
//
//
//
//            try {
//                passengerSemaphore.acquire();
//                System.out.println("-> Passenger"+ passengersList[i]);
//                Thread.sleep(2000);
//
//                driverSemaphore.release();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//}

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger implements Runnable {
    private final String name;
    private final Semaphore passengerSemaphore;
    private final Semaphore driverSemaphore;
    private final CountDownLatch latch;

    public Passenger(String name, Semaphore passengerSemaphore, Semaphore driverSemaphore, CountDownLatch latch) {
        this.name = name;
        this.passengerSemaphore = passengerSemaphore;
        this.driverSemaphore = driverSemaphore;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            passengerSemaphore.acquire();
            System.out.println("-> Passenger: " + name);
            Thread.sleep(2000); // simulate passenger entering
            driverSemaphore.release();
            latch.countDown(); // mark this task as complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

