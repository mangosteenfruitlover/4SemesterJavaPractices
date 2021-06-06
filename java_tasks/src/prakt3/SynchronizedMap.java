package prakt3;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SynchronizedMap<K,V> extends HashMap<K,V> implements Map<K,V>{
    private Object o= new Object();
    public SynchronizedMap(int initialCapacity,float loadFactor){
        super(initialCapacity,loadFactor);
    }

    public SynchronizedMap(int initialCapacity){
        super(initialCapacity);
    }

    public SynchronizedMap(){
        super();
    }

    public SynchronizedMap(Map<? extends K,? extends V> m){
        super(m);
    }

    @Override
    public int size(){
        synchronized(this.o){
            return super.size();
        }
    }

    @Override
    public boolean isEmpty(){
        synchronized(this.o){
            return super.isEmpty();
        }
    }

    @Override
    public V get(Object key){
        synchronized(this.o){
            return super.get(key);
        }
    }

    @Override
    public boolean containsKey(Object key){
        synchronized(this.o){
            return super.containsKey(key);
        }
    }

    @Override
    public V put(K key,V value){
        synchronized(this.o){
            return super.put(key,value);
        }
    }

    @Override
    public void putAll(Map<? extends K,? extends V> m){
        synchronized(this.o){
            super.putAll(m);
        }
    }

    @Override
    public V remove(Object key){
        synchronized(this.o){
            return super.remove(key);
        }
    }

    @Override
    public void clear(){
        synchronized(this.o){
            super.clear();
        }
    }

    @Override
    public boolean containsValue(Object value){
        synchronized(this.o){
            return super.containsValue(value);
        }
    }

    @Override
    public Set<K> keySet(){
        synchronized(this.o){
            return super.keySet();
        }
    }

    @Override
    public Collection<V> values(){
        synchronized(this.o){
            return super.values();
        }
    }

    @Override
    public Set<Entry<K,V>> entrySet(){
        synchronized(this.o){
            return super.entrySet();
        }
    }

    @Override
    public V getOrDefault(Object key,V defaultValue){
        synchronized(this.o){
            return super.getOrDefault(key,defaultValue);
        }
    }

    @Override
    public V putIfAbsent(K key,V value){
        synchronized(this.o){
            return super.putIfAbsent(key,value);
        }
    }

    @Override
    public boolean remove(Object key,Object value){
        synchronized(this.o){
            return super.remove(key,value);
        }
    }

    @Override
    public boolean replace(K key,V oldValue,V newValue){
        synchronized(this.o){
            return super.replace(key,oldValue,newValue);
        }
    }

    @Override
    public V replace(K key,V value){
        synchronized(this.o){
            return super.replace(key,value);
        }
    }

    @Override
    public V computeIfAbsent(K key,Function<? super K,? extends V> mappingFunction){
        synchronized(this.o){
            return super.computeIfAbsent(key,mappingFunction);
        }
    }

    @Override
    public V computeIfPresent(K key,BiFunction<? super K,? super V,? extends V> remappingFunction){
        synchronized(this.o){
            return super.computeIfPresent(key,remappingFunction);
        }
    }

    @Override
    public V compute(K key,BiFunction<? super K,? super V,? extends V> remappingFunction){
        synchronized(this.o){
            return super.compute(key,remappingFunction);
        }
    }

    @Override
    public V merge(K key,V value,BiFunction<? super V,? super V,? extends V> remappingFunction){
        synchronized(this.o){
            return super.merge(key,value,remappingFunction);
        }
    }

    @Override
    public void forEach(BiConsumer<? super K,? super V> action){
        synchronized(this.o){
            super.forEach(action);
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K,? super V,? extends V> function){
        synchronized(this.o){
            super.replaceAll(function);
        }
    }

    @Override
    public Object clone(){
        synchronized(this.o){
            return super.clone();
        }
    }
}
