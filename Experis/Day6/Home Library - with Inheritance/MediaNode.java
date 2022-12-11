import java.util.Optional;

public final class MediaNode {
	private final Media m_media;
	private Optional<MediaNode> m_nextNode;

	public MediaNode(Media media) {
		this.m_media = media;
		this.m_nextNode = Optional.empty();
	}

	public MediaNode(Media media, MediaNode nextNode) {
		this.m_media = media;
		this.m_nextNode = Optional.of(nextNode);
	}
 
	public final Media getMedia() {
		return this.m_media;
	}

	public final Optional<MediaNode> getNext() {
		return this.m_nextNode;
	}

	public final void setNext(MediaNode next) {
		this.m_nextNode = Optional.of(next);
	}

	public final void clearNext() {
		this.m_nextNode = Optional.empty();
	}
}
