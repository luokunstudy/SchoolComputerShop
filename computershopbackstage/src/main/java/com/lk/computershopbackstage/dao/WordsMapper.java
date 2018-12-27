package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Words;
import com.lk.computershopbackstage.bean.WordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordsMapper {
    long countByExample(WordsExample example);

    int deleteByExample(WordsExample example);
    
    int insertSelective(Words record);

    Words selectByPrimaryKey(Integer wordsId);

    int updateByExampleSelective(@Param("record") Words record, @Param("example") WordsExample example);

    int updateByExample(@Param("record") Words record, @Param("example") WordsExample example);

    int updateByPrimaryKeySelective(Words record);

    int updateByPrimaryKey(Words record);
    
    int insert(Words words); 
    //查询所欲留言
    List<Words> selectByExample(WordsExample example);
    //按商品编号查
    List<Words> selectwordsgoodsId(Integer goodsId);
    //删除留言
    int deleteByPrimaryKey(Integer wordsId);
}
