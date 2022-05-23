package sberSchool.homeWork12.Task1;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
//        List<Callable> callableList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            callableList.add(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return "hello " + finalI;
//                }
//            });
//        }
        Callable<String> callable = () -> "Hello";
        Task task = new Task(callable);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(task.get())).start();
        }
    }
}
