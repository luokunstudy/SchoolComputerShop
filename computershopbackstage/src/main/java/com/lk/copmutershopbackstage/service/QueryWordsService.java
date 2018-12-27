package com.lk.copmutershopbackstage.service;

import java.util.List;

import com.lk.computershopbackstage.bean.Words;
import com.lk.computershopbackstage.bean.WordsExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 下午9:17:18 
* 类说明 
*/
public interface QueryWordsService {
	
    //查询所欲留言
    List<Words> selectByExample(WordsExample example);
    //按商品编号查
    List<Words> selectwordsgoodsId(Integer goodsId);
    //删除留言
    int deleteByPrimaryKey(Integer wordsId);  

}
