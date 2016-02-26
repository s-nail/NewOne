package com.hengtiansoft.nl.common.model;

public class Head {

	public boolean success = true;
	public String errorCode = "0";
	public String msg = "成功";
	public Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static MobileReturn<Head> failedMessage(String msg) {
		Head head = new Head();
		head.setSuccess(false);
		head.setErrorCode("1");
		head.setMsg(msg);
		return new MobileReturn<Head>(head);
	}

	public static MobileReturn<Head> successMessage(String msg) {
		Head head = new Head();
		head.setMsg(msg);
		return new MobileReturn<Head>(head);
	}

	public static MobileReturn<Head> successMessage() {
		Head head = new Head();
		return new MobileReturn<Head>(head);
	}
}
