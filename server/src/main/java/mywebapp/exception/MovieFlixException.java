package mywebapp.exception;

public class MovieFlixException extends Throwable {
	
	private String code;

	public MovieFlixException(String code,Throwable e) {
		super(e.getMessage(), e);
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
