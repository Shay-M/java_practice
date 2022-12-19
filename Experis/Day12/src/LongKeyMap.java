public interface LongKeyMap<T>{
	
	int size();
	boolean isEmpty();
	T getValue(long key);
	boolean contains(T value);
	void put(long key , T value);
	
	
}