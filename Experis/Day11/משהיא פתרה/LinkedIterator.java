import java.util.Optional;

public final class LinkedIterator<T> implements java.util.Iterator<T> {
	private Optional<ObjectNode> m_head;
	
	public LinkedIterator(ObjectNode m_head) {
		this.m_head = Optional.of(m_head);
	}
	
	public final boolean hasNext() {
		if(this.m_head == null) {
			return false;
		}
		return this.m_head.isPresent();
	}
	
	public final T next() {
		Object returnObj = this.m_head.get().getObject();
		if (this.m_head.get().getNext().isPresent()) {
			this.m_head = this.m_head.get().getNext();
		}
		else {
			this.m_head = Optional.empty();
		}
		return (T)returnObj;
	}
}

