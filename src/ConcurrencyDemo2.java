import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ConcurrencyDemo2 implements Runnable {
    //此时使用volatile依然无效，因为volatile不能保证原子性
    //volatile public static int count = 0;
    //synchronized (this) 也不能锁
    public static int count = 0;
    @Override
    public void run() {
        ConcurrencyDemo2 concurrencyDemo2 = new ConcurrencyDemo2();
        concurrencyDemo2.add();
    }
    public void add(){
        //System.out.println("before "+count);
    Object lock = 0;
        synchronized (ConcurrencyDemo2.class){
            for(int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                //Thread.sleep(100);
            }
        }
        //System.out.println(count);

    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ConcurrencyDemo2());
            thread.setName(String.valueOf(i));
            thread.start();
         //   System.out.println(thread.getName());

        }
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("count = "+count);
    }
}