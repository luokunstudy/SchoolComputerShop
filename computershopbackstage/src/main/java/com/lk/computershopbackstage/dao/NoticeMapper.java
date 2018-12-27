package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Notice;
import com.lk.computershopbackstage.bean.NoticeExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
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