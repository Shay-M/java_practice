import java.lang.Iterable;

public interface Collection<T> extends Iterable<T> {
	void add(T obj);
	void removeAt(int idx);
	T at(int idx);
	int count();
	void insert(T obj);
	java.util.Iterator<T> iterator();
}