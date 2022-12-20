public interface LongKeyMap<T>{
	
	int size();
	boolean isEmpty();
	T getValue(Object key);
	boolean contains(T value);
	void put(Object key , T value);
	
	
}