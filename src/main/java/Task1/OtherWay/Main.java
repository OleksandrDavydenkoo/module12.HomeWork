package Task1.OtherWay;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread timeThread = new Thread(() -> {
            try {
                while (true) {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60;
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) % 60;
                    long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);

                    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    System.out.println(timeString);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        timeThread.start();

        Thread messageThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        messageThread.start();
    }
}
