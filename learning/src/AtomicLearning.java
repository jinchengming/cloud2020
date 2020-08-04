/**
 * 描述:
 * AtomicInteger 测试
 *
 * @outhor cm_fighting
 * @create 2020-08-04 3:11 下午
 */
public class AtomicLearning {

    private static volatile int a = 0;

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(a++);
                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
    }


}
