import java.util.Optional;

public class ObjNode {
    private final Object m_obj;
    private Optional<ObjNode> m_nextNode;

    public ObjNode(Object obj) {
        this.m_obj = obj;
        this.m_nextNode = Optional.empty();
    }

    public ObjNode(Object obj, ObjNode nextNode) {
        this.m_obj = obj;
        this.m_nextNode = Optional.of(nextNode);
    }

    public final Object getObject() {
        return this.m_obj;
    }

    public final Optional<ObjNode> getNext() {
        return this.m_nextNode;
    }

    public final void setNext(ObjNode next) {
        this.m_nextNode = Optional.of(next);
    }

    public final void clearNext() {
        this.m_nextNode = Optional.empty();
    }


}
