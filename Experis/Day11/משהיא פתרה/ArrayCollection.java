import java.util.logging.Logger;
import java.util.logging.Level;

public final class ArrayCollection<T> implements Collection<T> {
	private Object[] m_objArr = new Object[0];

	@Override
	public final void add(final T obj) {
		final Object[] newObjArr =  new Object[this.m_objArr.length+1];
		System.arraycopy(this.m_objArr, 0, newObjArr, 0, this.m_objArr.length);
		newObjArr[this.m_objArr.length] = obj;
		this.m_objArr = newObjArr;
	}
	
	
	@Override
	public final void removeAt(final int idxToRemove) {
		final Object[] newObjectArr = new Object[this.m_objArr.length-1];
		System.arraycopy(this.m_objArr, 0, newObjectArr, 0, idxToRemove);
		System.arraycopy(this.m_objArr,idxToRemove+1, newObjectArr, idxToRemove, newObjectArr.length - idxToRemove);
		this.m_objArr = newObjectArr;
	}
	
	@Override
	public final T at(int idxToFind) {
		try {
			final T obj = (T)this.m_objArr[idxToFind];
			return obj;
		}
		catch (IndexOutOfBoundsException ex) {
			final Logger logger = Logger.getLogger(ArrayCollection.class.getCanonicalName());
			logger.log(Level.WARNING, "Index: " + String.valueOf(idxToFind)
				+ " doesn't exist int the collection.\n The collection contains only " +  String.valueOf(this.m_objArr.length) + " objects");			
			throw ex;
		}
	}
	
	@Override
	public final int count() {
		return this.m_objArr.length;
	}

	@Override
	public final void insert(T obj) {
		final Object[] newObjectArr = new Object[this.m_objArr.length+1];
		newObjectArr[0] = obj;
		System.arraycopy(this.m_objArr, 0, newObjectArr, 1, this.m_objArr.length);
		this.m_objArr = newObjectArr;
	}
	
	@Override
	public final java.util.Iterator<T> iterator() {
		 java.util.Iterator<T> itr = new ArrayIterator<T>(this.m_objArr);
		return itr;
	}
}