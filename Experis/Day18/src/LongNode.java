import java.util.Optional;

public final class LongNode implements Comparable<Long> {


    private Optional<LongNode> m_left = Optional.empty();
    private Optional<LongNode> m_right = Optional.empty();
    private Optional<Long> m_date = Optional.empty();

    public LongNode(final Long date) {
        m_date = Optional.of(date);
    }
    public void setLeft(Optional<LongNode> left) {
        this.m_left = left;
    }

    public void setRight(Optional<LongNode> right) {
        this.m_right = right;
    }

    public Optional<LongNode> getLeft() {
        return m_left;
    }

    public Optional<LongNode> getRight() {
        return m_right;
    }


    @Override
    public int compareTo(final Long dateFromOther) {
        return m_date.get().compareTo(dateFromOther);
    }
}
