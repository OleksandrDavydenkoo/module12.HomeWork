package Task1.FirstWay;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println("Працює 1 секунду");
                Thread.sleep(1000L);
                System.out.println("Працює 2 секунди");
                Thread.sleep(1000L);
                System.out.println("Працює 3 секунди");
                Thread.sleep(1000L);
                System.out.println("Працює 4 секунди");
                Thread.sleep(1000L);
                System.out.println("Працює 5 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 6 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 7 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 8 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 9 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 10 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 11 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 12 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 13 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 14 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 15 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 16 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 17 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 18 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 19 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 20 секунд");
                Thread.sleep(1000L);
                System.out.println("Працює 21 секунду");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5000L);
                System.out.println("Минуло 5 секунд");
                Thread.sleep(5000L);
                System.out.println("Минуло 5 секунд");
                Thread.sleep(5000L);
                System.out.println("Минуло 5 секунд");
                Thread.sleep(5000L);
                System.out.println("Минуло 5 секунд");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
    }
}