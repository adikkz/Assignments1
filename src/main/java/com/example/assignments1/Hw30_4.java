package homeworks;

public class Hw30_4 {
    public static void main(String[] args) {
        Add add = new Add();
        for (int i = 0; i < 1000; i++) {
            Thread a = new Thread(add);
            a.start();
        }
        System.out.println("sum = " + add.getSum());
    }

    private static class Add implements Runnable {
        private static Integer sum = 0;

        public void run() {
            sum++;
        }

        public synchronized static Integer getSum() {
            return sum;
        }
    }
}
