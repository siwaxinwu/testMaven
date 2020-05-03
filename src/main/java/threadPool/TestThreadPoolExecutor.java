package threadPool;



/**
 * 两种执行器的区别，submit可以接受到参数，他是ExcuterService的接口方法
 * excuter方法可以执行runable方法,可以用lambda表达式，但只针对函数式编程接口
 * executer方法是一个Excuter接口的方法
 */
public class TestThreadPoolExecutor {
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 10,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(20));
        executor.execute(()->System.out.println("hello world"));
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() {
                return "this is callable";
            }
        });
        System.out.println(future.get());


    }*/

}
