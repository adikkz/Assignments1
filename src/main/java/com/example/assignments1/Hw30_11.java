package homeworks;

public class Hw30_11 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (Integer.class){
                    System.out.println("Integer is Synchronaized from thread 1");

                    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

                    synchronized (String.class){
                        System.out.println("String is Synchronaized from thread 1");
                    }}
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (String.class){
                    System.out.println("String is Synchronaized from thread 2");

                    try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();
                    }
                    synchronized (Integer.class){
                        System.out.println("Integer is Synchronaized from thread 2");
                    }
                }}
        };
        t1.start();
        t2.start();
    }
}
