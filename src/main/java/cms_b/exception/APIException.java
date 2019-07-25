package cms_b.exception;

public class APIException extends BasicRuntimeException{
	private static final long serialVersionUID = 1L;
	private ErrorType errorType;
	
	public APIException(ErrorType errorStatus) {
		super(errorStatus.getMessage());
		this.errorType = errorStatus;
	}
	@Override
	public Integer getCode() {
	  return this.errorType.getCode();
	}
}
