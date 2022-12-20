import java.util.List;
import java.util.ArrayList;

public final class ModuloMap<V> implements LongKeyMap<V> {
	private int m_mapSize = 0;
	private List[] m_valuesList; 
	private List[] m_keysList;
	private int maxListLong = 0;
	
	public ModuloMap(final int tableSize){
		this.m_valuesList = new ArrayList[tableSize];
		this.m_keysList = new ArrayList[tableSize];
	}
	
	public final int getMaxListSize(){
		return this.maxListLong;
	}
	
	@Override
	public final boolean put(long key, V value){
		if (contains(key)) {//Exception
			return false;
		}
		final int idx = (int)(key % this.m_valuesList.length);
		if(this.m_keysList[idx] == null) {
			this.m_keysList[idx] = new ArrayList<Long>();
		}
		this.m_keysList[idx].add(key);
		if( this.maxListLong < this.m_keysList[idx].size() ) {
				this.maxListLong = this.m_keysList[idx].size();
			}
		if(this.m_valuesList[idx] == null) {
			this.m_valuesList[idx] = new ArrayList<V>();
		}
		this.m_valuesList[idx].add(value);
		++this.m_mapSize;
		return true;
	}
	
	@Override
	public final V getValue(final long key) {
		if(m_mapSize == 0) {
			return null; // *******
		}
		final int idx = (int)(key % this.m_valuesList.length);
		final int idx2 = this.m_keysList[idx].indexOf(key);
		V returnedValue = (V)this.m_valuesList[idx].get(idx2);
		return returnedValue;
	}
	
	@Override
	public final boolean contains(long key) {
		if(m_mapSize == 0) {// **
			return false;
		}
		final int idx = (int)(key % this.m_valuesList.length);
		try { // if null return false
			return this.m_keysList[idx].contains(key);
		}
		catch(NullPointerException ex) {
			return false;
		}
	}
	
	@Override
	public final int size() {
		return this.m_mapSize;
	}
	
	@Override
	public final boolean isEmpty() {
		return this.m_mapSize == 0;
	}
}