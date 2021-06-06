package prakt4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class Work4{
    static class TestTask implements Runnable{
        private String task;
        public TestTask(String task){
            this.task=task;
        }
        @Override
        public void run(){
            System.out.println("Current Thread "+Thread.currentThread().getName()+" : "+task+" is begun");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                System.out.println("Current Thread "+Thread.currentThread().getName()+" : "+task+" is ended");
            }
        }
    }
    public static void main(String[] args){
        ExecutorService executor=new MyExecutorService(3);
        System.out.println("Initiating 4 tasks");
        executor.execute(new TestTask("Test task_1"));
        executor.execute(new TestTask("Test task_2"));
        executor.execute(new TestTask("Test task_3"));
        executor.execute(new TestTask("Test task_4"));
        System.out.println("Shutdown requested");
        executor.shutdown();
        try{
            executor.execute(new TestTask("Test task_5"));
        }catch(RejectedExecutionException e){
            System.out.println("Test task_5 rejected");
        }
        System.out.println("Shutdown done");
    }
}