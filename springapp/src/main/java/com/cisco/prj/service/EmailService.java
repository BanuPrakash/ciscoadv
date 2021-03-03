package com.cisco.prj.service;

public class EmailService {
	private String protocol;
	private int port;

	public EmailService(String proto, int port) {
		this.protocol = proto;
		this.port = port;
	}

	public String getDetails() {
		return this.protocol + ":" + port;
	}
}