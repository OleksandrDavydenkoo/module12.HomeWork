package Task2;


import java.util.LinkedList;
import java.util.Queue;

public class FizzBuzz {
    private int n;
    private int current = 1;
    private Queue<String> queue = new LinkedList<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (current % 3 == 0 && current % 5 != 0) {
                    queue.add("fizz");
                    current++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void buzz() throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (current % 5 == 0 && current % 3 != 0) {
                    queue.add("buzz");
                    current++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (current % 3 == 0 && current % 5 == 0) {
                    queue.add("fizzbuzz");
                    current++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void number() throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (current % 3 != 0 && current % 5 != 0) {
                    queue.add(String.valueOf(current));
                    current++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void printResult() throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();

        boolean first = true;
        while (!queue.isEmpty()) {
            if (first) {
                System.out.print(queue.poll());
                first = false;
            } else {
                System.out.print(", " + queue.poll());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        FizzBuzz fb = new FizzBuzz(n);
        fb.printResult();
    }
}
