package prakt3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SetSemaphore<E> extends HashSet<E> implements Set<E>{
    private final Semaphore semaphore = new Semaphore(1);

    public SetSemaphore(){
        super();
    }

    public SetSemaphore(Collection<? extends E> c){
        super(c);
    }

    public SetSemaphore(int initialCapacity,float loadFactor){
        super(initialCapacity,loadFactor);
    }

    public SetSemaphore(int initialCapacity){
        super(initialCapacity);
    }

    @Override
    public Iterator<E> iterator(){//
        return super.iterator();
    }

    @Override
    public int size(){
        try{
            semaphore.acquire();
            try{
                return super.size();
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public boolean isEmpty(){
        try{
            semaphore.acquire();
            try{
                return super.isEmpty();
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public boolean contains(Object o){
        try{
            semaphore.acquire();
            try{
                return super.contains(o);
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public boolean add(E e){
        try{
            semaphore.acquire();
            try{
                return super.add(e);
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public boolean remove(Object o){
        try{
            semaphore.acquire();
            try{
                return super.remove(o);
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public void clear(){
        try{
            semaphore.acquire();
            try{
                super.clear();
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public Object clone(){
        try{
            semaphore.acquire();
            try{
                return super.clone();
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }

    @Override
    public Spliterator<E> spliterator(){
        try{
            semaphore.acquire();
            try{
                return super.spliterator();
            }
            finally {
                semaphore.release();
            }

        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Blocked");
        }
    }
}
