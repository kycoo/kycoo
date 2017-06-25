package com.qfedu.bigweb.persistence;

import com.qfedu.bigweb.domain.Message;
import com.qfedu.bigweb.domain.PageModel;

public interface MessageDao {

	Integer save(Message message);
	
	PageModel<Message> findByPage(int page, int size);
}
