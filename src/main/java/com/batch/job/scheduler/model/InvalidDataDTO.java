package com.batch.job.scheduler.model;

public class InvalidDataDTO {
	
	private String ouboundMessage;
	private String prgramId;
	private String messageId;
	private String smsResponse;
	private Integer sentCount;
	
	public InvalidDataDTO() {}
	
	public InvalidDataDTO(String ouboundMessage, String prgramId, String messageId, String smsResponse,
			Integer sentCount) {
		this.ouboundMessage = ouboundMessage;
		this.prgramId = prgramId;
		this.messageId = messageId;
		this.smsResponse = smsResponse;
		this.sentCount = sentCount;
	}
	
	public String getOuboundMessage() {
		return ouboundMessage;
	}
	public void setOuboundMessage(String ouboundMessage) {
		this.ouboundMessage = ouboundMessage;
	}
	public String getPrgramId() {
		return prgramId;
	}
	public void setPrgramId(String prgramId) {
		this.prgramId = prgramId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSmsResponse() {
		return smsResponse;
	}
	public void setSmsResponse(String smsResponse) {
		this.smsResponse = smsResponse;
	}
	public Integer getSentCount() {
		return sentCount;
	}
	public void setSentCount(Integer sentCount) {
		this.sentCount = sentCount;
	}

	@Override
	public String toString() {
		return "InvalidDataDTO [ouboundMessage=" + ouboundMessage + ", prgramId=" + prgramId + ", messageId="
				+ messageId + ", smsResponse=" + smsResponse + ", sentCount=" + sentCount + "]";
	}
	
}
