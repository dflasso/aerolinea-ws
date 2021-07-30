package ec.edu.espe.monster.aerolineacondor.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

	private HttpStatus status; 
	private String userMsg;
	private String debugMsg;
	private Map<String, String> moreInfo;
	
	public ApiError( String userMsg, String debugMsg) {
		super();
		this.userMsg = userMsg;
		this.debugMsg = debugMsg;
	}

	public ApiError(HttpStatus status, String userMsg, String debugMsg) {
		super();
		this.status = status;
		this.userMsg = userMsg;
		this.debugMsg = debugMsg;
	}
	
	
	public ApiError(HttpStatus status, String userMsg, Throwable debugMsg) {
		super();
		this.status = status;
		this.userMsg = userMsg;
		this.debugMsg = debugMsg.getMessage();
	}

	public ApiError(HttpStatus status) {
		super();
		this.status = status;
	}

	public ApiError(HttpStatus status, String userMsg, String debugMsg, Map<String, String> moreInfo) {
		super();
		this.status = status;
		this.userMsg = userMsg;
		this.debugMsg = debugMsg;
		this.moreInfo = moreInfo;
	}
	
	
}
