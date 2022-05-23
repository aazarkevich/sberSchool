package sberSchool.homeWork11;

import java.util.LinkedList;
import java.util.Queue;

public class FixedThreadPool implements ThreadPool {
    private Queue<Runnable> queue = new LinkedList<>();
    private volatile boolean isRunning = true;
    private int countThread;

    public FixedThreadPool(int countThread) {
        this.countThread = countThread;
    }

    @Override
    public void start() {
        for (int i = 0; i < countThread; i++) {
            new Thread(() -> {
                while (isRunning) {
                    task().run();
                }
            }).start();
        }
    }

    @Override
    public synchronized void execute(Runnable runnable) {
        queue.add(runnable);
        notifyAll();
    }

    public void stop() {
        isRunning = false;
    }

    private synchronized Runnable task() {
        while (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
