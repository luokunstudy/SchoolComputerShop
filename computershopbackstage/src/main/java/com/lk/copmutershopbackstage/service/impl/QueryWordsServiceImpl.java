package com.lk.copmutershopbackstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Words;
import com.lk.computershopbackstage.bean.WordsExample;
import com.lk.computershopbackstage.dao.WordsMapper;
import com.lk.copmutershopbackstage.service.QueryWordsService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 下午9:17:30 
* 类说明 
*/
@Service
public class QueryWordsServiceImpl implements QueryWordsService{
	@Autowired
	WordsMapper wordsMapper;

	@Override
	public List<Words> selectByExample(WordsExample example) {
	  List<Words> listallwords = wordsMapper.selectByExample(null);
		return listallwords;
	}

	@Override
	public List<Words> selectwordsgoodsId(Integer goodsId) {
		List<Words> listgoodsId =  wordsMapper.selectwordsgoodsId(goodsId);
		return listgoodsId;
  }

	@Override
	public int deleteByPrimaryKey(Integer wordsId) {
		wordsMapper.deleteByPrimaryKey(wordsId);
		return 0;
	}
}
