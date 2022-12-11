import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;

public final class MediaNodeExample {
	private static final Logger logger = Logger.getLogger(MediaNodeExample.class.getCanonicalName());

	public static void main(final String[] args) {
		MediaNode n1 = new MediaNode(new Media("Harry Potter", "J.K.Rolling"));

		MediaNode n2 = new MediaNode(new Media("Jungle Book", "Kipling"));
		n1.setNext(n2);

		MediaNode n3 = new MediaNode(new Media("The Little Prince", "Anton"));
		n2.setNext(n3);

		Print(n1);
	}		

	private static void Print(MediaNode node) {
		logger.log(Level.INFO, node.getMedia().getName());
		while (node.getNext().isPresent()) {
			Optional<MediaNode> next = node.getNext();
			node = next.get();
			logger.log(Level.INFO, node.getMedia().getName());
		}
	}
}
