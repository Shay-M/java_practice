import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.Level;


public final class LinkedCollection<T> implements Collection<T> {
	private ObjectNode m_head;
	
	
	public LinkedCollection() {
		this.m_head = null;
	}
	
		
	@Override
	public final void add(final T obj) {
		final ObjectNode newObjectNode = new ObjectNode(obj);
		if (this.m_head == null) {
			this.m_head = newObjectNode;
		}
		else {
			Optional<ObjectNode> last = Optional.of(this.m_head);
			while (last.get().getNext().isPresent()) {
				last = last.get().getNext();
			}
			last.get().setNext(newObjectNode);			
		}
	}
	
	@Override
	public final void removeAt(final int idxToRemove) {
		if (this.m_head == null) {
			return;
		}
		Optional <ObjectNode> currObjectNode = Optional.of(this.m_head);
		if(idxToRemove == 0 && currObjectNode != null) {
			this.m_head = currObjectNode.get();
			return;
		}
		int counter = 0;
		Optional <ObjectNode> prev = Optional.empty();
		while (currObjectNode != null) {
			if (counter == idxToRemove) {
				prev.get().setNext(currObjectNode.get().getNext().get());
				return;
			}
			else {
				prev = currObjectNode;
				currObjectNode = currObjectNode.get().getNext();
				++counter;
			}
		}
		if (currObjectNode == null) {
			final Logger logger = Logger.getLogger(LinkedCollection.class.getCanonicalName());
			logger.log(Level.WARNING, "Index: " + String.valueOf(idxToRemove)
				+ " doesn't exist int the collection.\n The collection contains only " +  String.valueOf(this.count()) + " objects");	
		}
	}
	
	@Override
	public final T at(int idxToFind) {
		if (this.m_head == null || this.count() < idxToFind) {
			final Logger logger = Logger.getLogger(LinkedCollection.class.getCanonicalName());
			logger.log(Level.WARNING, "Index: " + String.valueOf(idxToFind)
				+ " doesn't exist int the collection.\n The collection contains only " +  String.valueOf(this.count()) + " objects");	
		}
		ObjectNode currObjectNode = this.m_head;
		int counter = 0;		
		while (currObjectNode.getNext() != null && counter<=idxToFind) {
			if (counter == idxToFind) {
				return (T)currObjectNode.getObject();
			}
			else {
				 currObjectNode = currObjectNode.getNext().get();
				 ++counter;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public final int count() {
		int countListSize = 1;
		Optional<ObjectNode> objectNode = Optional.of(this.m_head); 
		while(objectNode.get().getNext().isPresent()) {
			++countListSize;
			objectNode = objectNode.get().getNext();	
		}
		return countListSize;
	}
	

	@Override	
	public final void insert(T obj) {
		final ObjectNode newObjectNode = new ObjectNode(obj);
		if (this.m_head == null) {
			this.m_head = newObjectNode;
		}
		else {
			Optional<ObjectNode> prevHead = Optional.of(this.m_head); 
			newObjectNode.setNext(prevHead.get());
			this.m_head = newObjectNode;
		}
	}
	
	@Override
	public final java.util.Iterator<T> iterator() {
		java.util.Iterator<T> itr = new LinkedIterator<T>(this.m_head);
		return itr;
	}
}