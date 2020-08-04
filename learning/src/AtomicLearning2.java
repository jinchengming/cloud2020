import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @outhor cm_fighting
 * @create 2020-08-04 3:19 下午
 */

public class AtomicLearning2 {

    static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; ++i) {
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; ++j) {
                        System.out.println(a.incrementAndGet());
                        Thread.sleep(500L);
                    }
                } catch (Exception var1) {
                    var1.printStackTrace();
                }

            });
            threads[i].start();
        }

    }

}
