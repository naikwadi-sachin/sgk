package org.sgk.service;

import java.util.List;

import org.sgk.domain.Message;

public interface MessageBoardService {
	public List<Message> listMessages();

	public void postMessage(Message message);

	public void deleteMessage(Message message);

	public Message findMessageById(Long messageId);
}
