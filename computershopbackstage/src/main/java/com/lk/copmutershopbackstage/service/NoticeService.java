package com.lk.copmutershopbackstage.service;

import java.util.Date;
import java.util.List;

import com.lk.computershopbackstage.bean.Notice;
import com.lk.computershopbackstage.bean.NoticeExample;
import com.lk.computershopbackstage.bean.Words;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 下午7:32:12 
* 类说明 
*/
public interface NoticeService {
    //发布公告
	int insert(Notice notice); 
	//查看公告
	List<Notice> selectByExample(NoticeExample example);
	//按时间查询
	List<Notice> selectnoticetime(Date wordsTime);
	//按标题查询
	List<Notice> selectnoticetitle(String wordsTitle);
	//删除公告
	int deleteByPrimaryKey(Integer noticeId);
}
