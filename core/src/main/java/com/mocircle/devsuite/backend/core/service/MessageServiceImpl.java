package com.mocircle.devsuite.backend.core.service;

import org.springframework.stereotype.Service;

import com.mocircle.devsuite.backend.core.model.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public Message getMessage() {
		Message msg = new Message();
		msg.setTitle("Normal Message");
		msg.setBody("This is a test msg.");
		msg.setTimestamp(System.currentTimeMillis());
		return msg;
	}

	@Override
	public Message getSecuredMessage(String userName) {
		Message msg = new Message();
		msg.setTitle("Secured Message");
		msg.setBody(userName + " requested this message.");
		msg.setTimestamp(System.currentTimeMillis());
		return msg;
	}

}
