package sberSchool.homeWork12.Task1;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task<T> {
    private Callable<? extends T> callable;
    private  T rezult;
    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (rezult != null) {
            System.out.println("Cash");
            return rezult;
        }
        synchronized (callable) {
            try {
                rezult = callable.call();
                System.out.println("Execute...");
                return rezult;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Errore execute....");
            }
        }
    }
}
