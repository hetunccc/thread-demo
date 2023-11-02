import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*实现线程的三种方法
*   实现 Runnable 接口；
    实现 Callable 接口；
    继承 Thread 类。*/
public class App {

    /*  Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；
        类可能只要求可执行就行，继承整个 Thread 类开销过大。
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());

        MyThread mt = new MyThread();
        mt.start();
    }
}
