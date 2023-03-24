package com.spboot.market.exception;

public class ProductException extends RuntimeException {

	private String errorMsg;

	public ProductException() {
		super();
	}

	public ProductException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
