package learning.ds.queue;

/**
 * @author ashok
 *
 */
public class QueueFullException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5165103549696233323L;

	public QueueFullException(String message) {
		super(message);
	}

}
