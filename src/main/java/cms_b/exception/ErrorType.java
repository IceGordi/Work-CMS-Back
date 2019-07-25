package cms_b.exception;

public enum ErrorType {
	  USER_NOT_FOUND(1, "User not found"), USER_ALREADY_EXISTS(2, "User already exists"),
	  ETIQUETA_NOT_FOUND(1, "Etiqueta no encontrada"), ETIQUETA_YA_EXISTE(2, "La etiqueta ya existe");
	
	  private final int code;
	  private final String message;

	  private ErrorType(int code, String message) {
	    this.code = code;
	    this.message = message;
	  }

	  public int getCode() {
	    return code;
	  }

	  public String getMessage() {
	    return message;
	  }
}
