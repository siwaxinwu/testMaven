package threadTest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    int n;


    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if (n < 1 ){
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        return f1.join() + f2.join();
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        for (int i = 0; i < 10; i++) {
            ForkJoinTask<Integer> submit = forkJoinPool.submit(new Fibonacci(i));
            System.out.println(submit.get());
        }
    }

}
