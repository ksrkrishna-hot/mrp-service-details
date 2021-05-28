package com.citi.membership.enrollment.model;



public class ClientInfo {

	private String clientId;
	private String channelId;
	private String reqId;
	private String msgTs;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getMsgTs() {
		return msgTs;
	}
	public void setMsgTs(String msgTs) {
		this.msgTs = msgTs;
	}
	
	
}
