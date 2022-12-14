import java.util.Optional;

public class ObjNode<T> {
    private final T m_t;
    private Optional<ObjNode<T>> m_nextNode;

    public ObjNode(final T t) {
        this.m_t = (T) t;
        this.m_nextNode = Optional.empty();
    }

    public ObjNode(final T t, ObjNode<T> nextNode) {
        this.m_t = (T) t;
        this.m_nextNode = Optional.of(nextNode);
    }

    public final T getObject() {
        return this.m_t;
    }

    public final Optional<ObjNode<T>> getNext() {
        return this.m_nextNode;
    }

    public final void setNext(ObjNode<T> next) {
        this.m_nextNode = Optional.of(next);
    }

    public final void clearNext() {
        this.m_nextNode = Optional.empty();
    }


}
