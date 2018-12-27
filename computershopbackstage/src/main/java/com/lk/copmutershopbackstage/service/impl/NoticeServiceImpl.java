package com.lk.copmutershopbackstage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Notice;
import com.lk.computershopbackstage.bean.NoticeExample;
import com.lk.computershopbackstage.bean.Words;
import com.lk.computershopbackstage.dao.NoticeMapper;
import com.lk.computershopbackstage.dao.WordsMapper;
import com.lk.copmutershopbackstage.service.NoticeService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 下午7:33:01 
* 类说明 
*/
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper noticeMapper;

	public int insert(Notice notice) {
		noticeMapper.insert(notice);
		return 0;
	}

	@Override
	public List<Notice> selectByExample(NoticeExample example) {
	List<Notice> listallnotice =noticeMapper.selectByExample(null);
		return listallnotice;
	}

	@Override
	public List<Notice> selectnoticetime(Date wordsTime) {
	List<Notice> listnoticetime =noticeMapper.selectnoticetime(wordsTime);
		return listnoticetime;
	}

	@Override
	public List<Notice> selectnoticetitle(String wordsTitle) {
		List<Notice> listnoticetitle =	noticeMapper.selectnoticetitle(wordsTitle);
		return listnoticetitle;
	}

	@Override
	public int deleteByPrimaryKey(Integer noticeId) {
		int listnoticeId =noticeMapper.deleteByPrimaryKey(noticeId);
		return 0;
	}


  
}
