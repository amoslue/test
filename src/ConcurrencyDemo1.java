import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ConcurrencyDemo1 {
    //创建线程的方法
    public static void main(String[] args) {
        //Thread
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("this is thread1");
            }
        };
        thread1.start();

        //Runnable
        Thread thread2 = new Thread(new Runnable() {
        @Override
            public void run(){
            System.out.println("this is thread2");
        }
        });
        thread2.start();

        //Callable
        Callable<Object> objectCallable = new Callable<Object>() {
            @Override
            public String call(){
                System.out.println("this is thread3");
                return "hello";
            }
        };
        FutureTask<Object> objectFutureTask = new FutureTask<>(objectCallable);
        Thread thread3 = new Thread(objectFutureTask);
        thread3.start();


    }

}