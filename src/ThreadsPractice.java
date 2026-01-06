public class ThreadsPractice {

    public static void main(String[] args) throws InterruptedException {
        Runnable testing = new MyTask("Testing-1");
        Runnable anotherTest = new MyTask("Testing-2");

        Thread thread1 = new Thread(testing);
        Thread thread2 = new Thread(anotherTest);

        thread2.start();
        thread2.join(); // Wait for this thread to finish before going on to start thread1

        thread1.start();

    }
}

class MyTask implements Runnable {
    String name;

    public MyTask(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("Run " + i);
            System.out.println("Task " + name + " running in thread " + Thread.currentThread().getName());
        }
    }
}