package com.lk.copmutershop.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lk.copmutershop.bean.Goods;
import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.dao.GoodsMapper;
import com.lk.copmutershop.dao.memberMapper;
import com.mysql.fabric.xmlrpc.base.Data;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月26日 上午8:59:39 
* 类说明 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
	@Autowired
	memberMapper memberMappers;
	@Autowired
	GoodsMapper goodsMapper;
	@Test
	public void testmemberCRUD() {
		/*
		 * //1.创建SpringIOC容器 ApplicationContext ioc =new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * //2.从容器中获取mapper DepartmentMapper bean =
		 * ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(memberMappers);
		// 1.插入几个会员
	//	 memberMappers.insertSelective(new member("141530435", "123456", 1, "18803836314", "2605089387@qq.com","17226"));
		// memberMappers.insertSelective(new
		// member(null,"141530411","123456",0,"13290922051","2605089387@qq.com","计算机（软件）学院","15524"));

		// 测试删除
		// memberMappers.deleteByPrimaryKey(2);
		// 测试修改
	/*	member member = new member("141530435", "123456", 1, "18803836314", "2605089387@qq.com","17226");
		memberMappers.updateByPrimaryKey(member);*/

		// departmentMapper.insertSelective(new Department(null, "开发部"));
		// 生成员工数据，测试员工插入
		// employeeMapper.insertSelective(new Employee(null, "Jerry", "M",
		// "Jerry@163.com", 1));
		// 3.批量插入，使用可以批量操作的sqlSession
		/*
		 * for(){ employeeMapper.insertSelective(new Employee(null, "Jerry",
		 * "M", "Jerry@163.com", 1)); }
		 */
		/*
		 * EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		 * for(int i =0;i<100;i++){ String uuid
		 * =UUID.randomUUID().toString().substring(0, 5)+""+i;
		 * mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@163.com",
		 * 1)); }
		 */
	}
	@Test
	public void testgoodsCRUD(){
		System.out.println(goodsMapper);
		//添加商品
		Date data = new Date();
		goodsMapper.insertSelective(new Goods(null, "141530435", "华硕", "sadadadsad132", 1, 188.63, 288.98, "线上交易",data,"无","二手电脑"));
	}
	
}
