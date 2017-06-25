package com.qfedu.bigweb.service;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.PageModel;

public interface MessageService {

	PageModel<Message> getMessagesByPage(int page, int size);
}
