package prakt4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyExecutorService implements ExecutorService{
    final ExecutorService currentService;
    public MyExecutorService(int nThreads){
        currentService=Executors.newFixedThreadPool(nThreads);
    }
    @Override
    public void shutdown(){
        currentService.shutdown();
    }
    @Override
    public List<Runnable> shutdownNow(){
        return currentService.shutdownNow();
    }
    @Override
    public boolean isShutdown(){
        return currentService.isShutdown();
    }
    @Override
    public boolean isTerminated(){
        return currentService.isTerminated();
    }
    @Override
    public boolean awaitTermination(long timeout,TimeUnit unit) throws InterruptedException{
        return currentService.awaitTermination(timeout,unit);
    }
    @Override
    public <T> Future<T> submit(Callable<T> task){
        return currentService.submit(task);
    }
    @Override
    public <T> Future<T> submit(Runnable task,T result){
        return currentService.submit(task,result);
    }
    @Override
    public Future<?> submit(Runnable task){
        return currentService.submit(task);
    }
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException{
        return currentService.invokeAll(tasks);
    }
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,long timeout,TimeUnit unit) throws InterruptedException{
        return currentService.invokeAll(tasks,timeout,unit);
    }
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException{
        return currentService.invokeAny(tasks);
    }
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,long timeout,TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException{
        return currentService.invokeAny(tasks,timeout,unit);
    }
    @Override
    public void execute(Runnable command){
        currentService.execute(command);
    }
}