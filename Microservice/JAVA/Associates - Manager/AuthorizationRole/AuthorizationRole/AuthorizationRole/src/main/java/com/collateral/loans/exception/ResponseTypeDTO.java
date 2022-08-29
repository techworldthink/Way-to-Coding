package com.collateral.loans.exception;

import java.time.LocalDateTime;

public class ResponseTypeDTO {
    private String errMsg;
    private LocalDateTime timestamp;
    private Integer status;
    
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

    
}
