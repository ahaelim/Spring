package com.smhrd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.common.Criteria;
import com.smhrd.mapper.MailMapper;
import com.smhrd.model.WebMessage;


@Service
public class MailService {
	@Autowired
	MailMapper mailMapper;
	
	public void sendMail(WebMessage message) {
		mailMapper.sendMail(message);
	}
	
	public List<WebMessage> selectMail(String email) {
		List<WebMessage> messageList = mailMapper.selectMail(email);
		return messageList;
	}
	
	public void deleteAllMail(String email) {
		mailMapper.deleteAllMail(email);
	}
	public void deleteMail(int num) {
		mailMapper.deleteMail(num);
	}
	
	public List<WebMessage> selectMailPaging(String email, Criteria cri) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("cri", cri);
		
		List<WebMessage> messageList = mailMapper.selectMailPaging(map);
		return messageList;
	}
	
	public int countMail(String email) {
		int total = mailMapper.countMail(email);
	
		return total;
	}
}

