

public final class LinkedMediaIterator implements MediaIterator {

    private MediaNode head;
    // private MediaNode pointer;

    public LinkedMediaIterator(MediaNode mediaNode) {
        head = mediaNode;
    }

    @Override
    public boolean hasNext() {
//        if (head.getNext().isPresent()) {
        if (head != null) {
            return true;
        }
        return false;
    }

    @Override
    public Media next() {
        Media returnedMedia = head.getMedia();
        if (head.getNext().isPresent()) { //? incompatible types: java.util.Optional<MediaNode> cannot be converted to MediaNode
            head = head.getNext().get();
        }


        return returnedMedia;
    }


}