package com.spboot.market.dto;

import java.util.Date;

public class MarketResponseDTO {
	private Date timestamp;
	private int statusCode;
	private Object data;
	private Object error;
	private String path;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "MarketResponseDTO [timestamp=" + timestamp + ", statusCode=" + statusCode + ", data=" + data
				+ ", error=" + error + ", path=" + path + "]";
	}

}
