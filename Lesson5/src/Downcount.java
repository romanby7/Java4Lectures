public class Downcount {

    private int count;

    public Downcount(int count) {
        this.count = count;
    }

    public void run() {
        while (count > 0) {
            System.out.println(count);
            count--;
        }
    }

    public void runRecursion() {
        doRun(count);
    }

    private void doRun(int count) {
        if (count <= 0) {
            return;
        }
        else {
            System.out.println(count);
            doRun(--count);
        }
    }

    public static void main(String[] args) {
//        new Downcount(5).run();
        new Downcount(5).runRecursion();
    }
}
