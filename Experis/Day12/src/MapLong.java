import Collection.ArrayCollection_long;
import Collection.Iterator;
import java.util.ArrayList;
import java.util.List;
public class MapLong<T> implements LongKeyMap<T>{
	//final private long[] keyArr ={ };
	final private ArrayCollection_long m_keysArr;
	final private List<T> m_valueList;

	public MapLong() {
	m_keysArr = new ArrayCollection_long();
	m_valueList = new ArrayList<T>();
	}

	@Override
	final public int size() {
		return m_keysArr.count();
	}

	@Override
	final public boolean isEmpty(){ 
		return m_valueList.isEmpty();
	}

	@Override
	final public T getValue(final long keyToFind) {
		//? make it for (key:m_keysArr)
		Iterator keyIto = m_keysArr.iterator();
		java.util.Iterator<T> valueIto = m_valueList.iterator();
		while (keyIto.hasNext() && valueIto.hasNext()) {
			final long key = keyIto.next();
			final T value = valueIto.next();
			if (key == keyToFind) {
				return value;
			}
		}
		// ? return valueList.get((int) keysArr.at((int) key)); //? keyArr (int) keysArr.get((int) key)
		throw new IllegalArgumentException("Key not found!");
	}

	@Override
	final public boolean contains(final T value)  {
//		try {
//			// T findedT = keyArr[(int)key];
			
//			return true;
//		}
//		catch (IndexOutOfBoundsException ex) {
//			return false;
//		}		
		return m_valueList.contains(value);
	}

	@Override
	final public void put(final long key ,final T value) {
		m_keysArr.add(key);
		m_valueList.add(value);
//		valueList.add((int) keysArr.at( key) ,value);
	}

	@Override
	public boolean equals(Object obj) { // ? can't T , what instanceof?!
		if (obj instanceof LongKeyMap){
			return true; // todo
		}
		return false;
	}
}