
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] passengersList = {
                "passenger-1","passenger-2","passenger-3",
                "passenger-4","passenger-5","passenger-6",
                "passenger-7","passenger-8","passenger-9",
                "passenger-10","passenger-11","passenger-12",
                "passenger-13","passenger-14","passenger-15",
                "passenger-16","passenger-17","passenger-18",
                "passenger-19","passenger-20"
        };

        String[] driversList = {"Driver-A","Driver-B","Driver-C","Driver-D","Driver-E","Driver-F","Driver-G","Driver-H","Driver-I","Driver-J"};

        Semaphore passengerSemaphore = new Semaphore(0);
        Semaphore driverSemaphore = new Semaphore(1);

        int total = passengersList.length;

        CountDownLatch latch = new CountDownLatch(total * 2);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < total; i++) {
            executor.submit(new Passenger(passengersList[i], passengerSemaphore, driverSemaphore, latch));
            executor.submit(new Driver(driversList[i % driversList.length], passengerSemaphore, driverSemaphore, latch));
        }

        latch.await(); // wait for all threads to finish
        executor.shutdown();
        System.out.println("Thank you for believing and travelling with us!!!");
    }
}
