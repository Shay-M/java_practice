/*
public abstract class MediaCollection {


    public void add(Media media) {

    }

    public void insert(Media media) { // like add but at beginning

    }

    public void removeAt(int idx) {

    }

    public Media at(int idx) {
        return null;
    }

    public int count() {
        return 0;
    }

    public MediaIterator iterator() {
        return null;
    }

}*/


public interface Collection {

    public void add(Media media);

    public void insert(Media media);

    public void removeAt(int idx);

    public Media at(int idx);

    public int count();

    public Iterator iterator();

}