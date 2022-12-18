import java.util.Optional;

public final class ObjectNode {
	private final Object m_object;
	private Optional<ObjectNode> m_nextNode;

	public ObjectNode(Object object) {
		this.m_object = object;
		this.m_nextNode = Optional.empty();
	}

	public ObjectNode(Object object, ObjectNode nextNode) {
		this.m_object = object;
		this.m_nextNode = Optional.of(nextNode);
	}
 
	public final Object getObject() {
		return this.m_object;
	}

	public final Optional<ObjectNode> getNext() {
		return this.m_nextNode;
	}

	public final void setNext(ObjectNode next) {
		this.m_nextNode = Optional.of(next);
	}

	public final void clearNext() {
		this.m_nextNode = Optional.empty();
	}
}