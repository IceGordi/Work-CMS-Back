package cms_b.exception;

public abstract class BasicRuntimeException extends RuntimeException{
	  private static final long serialVersionUID = 1L;
	  public BasicRuntimeException(String message) {
		    super(message);
		  }
	  public abstract Integer getCode();
}
