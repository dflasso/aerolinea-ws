package ec.edu.espe.monster.aerolineacondor.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status; 
	private String userMsg;
	private String debugMsg;
	private Map<String, String> moreInfo;
	
	public BadRequestException(HttpStatus status, String userMsg, String debugMsg, Map<String, String> moreInfo, Throwable ex) {
		super();
		this.status = status;
		this.userMsg = userMsg;
		this.debugMsg = debugMsg;
		this.moreInfo = moreInfo;
		log.error("[BadRequestException]:  HttpStatus: "+ status.toString() + "\n userMsg: " +userMsg + "\n debugMsg: " +  debugMsg + "\n Exception " + ex.getMessage());
	}

	public BadRequestException(HttpStatus status, String userMsg, String debugMsg, Map<String, String> moreInfo) {
		super();
		this.status = status;
		this.userMsg = userMsg;
		this.debugMsg = debugMsg;
		this.moreInfo = moreInfo;
	}

	public HttpStatus getStatus() {
		return status;
	}


	public String getUserMsg() {
		return userMsg;
	}


	public String getDebugMsg() {
		return debugMsg;
	}


	public Map<String, String> getMoreInfo() {
		return moreInfo;
	}
	
	
	
}
