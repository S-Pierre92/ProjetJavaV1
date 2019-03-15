package MyException;

public class MyDBException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyDBException(String exception){
		
		super(exception);
	}
	
	public MyDBException(String exception, Throwable cause) {
		super(exception, cause);
	}

}
