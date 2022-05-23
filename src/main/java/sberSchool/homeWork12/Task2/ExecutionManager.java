package sberSchool.homeWork12.Task2;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... task);
}
