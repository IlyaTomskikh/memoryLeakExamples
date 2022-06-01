package threadlocal;

public class Leaks {
    public static void main(String[] args) {
        new Thread(() -> {
            for (var i = 0; i < 100_000; ++i) {
                LeakThroughThreadLocals t = null;
                try {
                    t = new LeakThroughThreadLocals(i);
                    t.printId();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                } finally {
                    if (t != null) t.getThreadLocal().remove();
                    else System.out.println("t == null");
                }
            }
        }).start();
    }
}

class LeakThroughThreadLocals {
    private final int ID;
    private final int[] arr;
    private final ThreadLocal<LeakThroughThreadLocals> threadLocal;

    public LeakThroughThreadLocals(int ID) {
        this.ID = ID;
        arr = new int[1000000];
        threadLocal = new ThreadLocal<>();
        threadLocal.set(this);
    }

    public void printId() {
        System.out.println(threadLocal.get().ID + "; len of an array = " + arr.length);
    }

    public ThreadLocal<LeakThroughThreadLocals> getThreadLocal() {
        return threadLocal;
    }

}


/*
var t = new LeakThroughThreadLocals(i);
                t.printId();
 */


/*
LeakThroughThreadLocals t = null;
                try {
                    t = new LeakThroughThreadLocals(i);
                    t.printId();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                } finally {
                    if (t != null) t.getThreadLocal().remove();
                    else System.out.println("t == null");
                }
 */

/*
LeakThroughThreadLocals t = null;
                try {
                    t = new LeakThroughThreadLocals(i);
                    t.printId();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                } finally {
                    if (t != null) t.nullThreadLocal();
                    else System.out.println("t == null");
                }
 */