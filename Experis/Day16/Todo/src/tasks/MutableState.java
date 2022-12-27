package tasks;

public class MutableState {
    private boolean m_isCompleted = false;

    protected final void setIsCompleted(boolean m_isCompleted) {
        this.m_isCompleted = m_isCompleted;
    }

    public final boolean isCompleted() {
        return m_isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        m_isCompleted = isCompleted;
    }
}
