package hw11;

import org.junit.Test;
import sberSchool.homeWork11.FixedThreadPool;
import sberSchool.homeWork11.ScalableThreadPool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolTest {

    @Test
    public void fixedThreadPoolTest() {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(5);
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            int finalI = i;
            Runnable runnable = () -> System.out.println("Task " + finalI);
            runnableList.add(runnable);
        }
        fixedThreadPool.execute(() -> System.out.println("start"));
        fixedThreadPool.start();
        for (Runnable r: runnableList) {
            fixedThreadPool.execute(r);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixedThreadPool.stop();
    }

    @Test
    public void scalableThreadPollTest() {
        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(5,10);
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            int finalI = i;
            Runnable runnable = () -> System.out.println("Task " + finalI);
            runnableList.add(runnable);
        }
        scalableThreadPool.execute(() -> System.out.println("start"));
        scalableThreadPool.start();

        for (Runnable r: runnableList) {
            scalableThreadPool.execute(r);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scalableThreadPool.stop();
    }
}
