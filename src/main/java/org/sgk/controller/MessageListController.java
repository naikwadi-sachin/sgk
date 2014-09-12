package org.sgk.controller;

import java.util.List;

import org.sgk.domain.Message;
import org.sgk.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/messageList*")
public class MessageListController {

	private MessageBoardService messageBoardService;

	@Autowired
	public MessageListController(MessageBoardService messageBoardService) {
		this.messageBoardService = messageBoardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String generateList(Model model) {
		List<Message> messages = java.util.Collections.emptyList();
		messages = messageBoardService.listMessages();
		model.addAttribute("messages", messages);
		return "messageList";
	}
}
