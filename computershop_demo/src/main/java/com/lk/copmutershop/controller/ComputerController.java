package com.lk.copmutershop.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.copmutershop.bean.Apply;
import com.lk.copmutershop.bean.Goods;
import com.lk.copmutershop.bean.Goods_need;
import com.lk.copmutershop.bean.Goods_type;
import com.lk.copmutershop.bean.Notice;
import com.lk.copmutershop.bean.Orders;
import com.lk.copmutershop.bean.Shopcart;
import com.lk.copmutershop.bean.Words;
import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.dao.ApplyMapper;
import com.lk.copmutershop.dao.GoodsMapper;
import com.lk.copmutershop.dao.Goods_needMapper;
import com.lk.copmutershop.dao.NoticeMapper;
import com.lk.copmutershop.dao.OrdersMapper;
import com.lk.copmutershop.dao.ShopcartMapper;
import com.lk.copmutershop.dao.WordsMapper;
import com.lk.copmutershop.dao.memberMapper;
import com.lk.copmutershop.service.Goods_typeService;
import com.lk.copmutershop.service.memberservice;
import com.lk.copmutershop.utils.Msg;

/**
 * @author 作者 :luokun
 * @version 创建时间：2017年10月31日 上午9:54:39 类说明
 */
@Controller
@RequestMapping("computer")
// 这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
// 这样保证了session中存在member这个对象
@SessionAttributes("memberinfo")
public class ComputerController {

	@Autowired
	memberservice memberservice;
	@Autowired
    Goods_typeService goods_typeService;
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	GoodsMapper mapper = ctx.getBean(GoodsMapper.class);
	Goods_needMapper needmapper = ctx.getBean(Goods_needMapper.class);
	memberMapper personMapper = ctx.getBean(memberMapper.class);
	ShopcartMapper shopcartMapper = ctx.getBean(ShopcartMapper.class);
	ApplyMapper applyMapper = ctx.getBean(ApplyMapper.class);
	WordsMapper wordsMapper = ctx.getBean(WordsMapper.class);
	OrdersMapper ordersMapper = ctx.getBean(OrdersMapper.class);
	ApplyMapper  ApplyMapper = ctx.getBean(ApplyMapper.class);
    NoticeMapper noticeMapper = ctx.getBean(NoticeMapper.class);
	// spring日期转换
			@InitBinder
			public void initBinder(WebDataBinder binder) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
			}
	
	// 查询所有全新电脑和二手电脑
	@RequestMapping("/listnewcomputer")
	public String listnewcomputer(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpServletRequest request, String goodsCategory, Model model,Goods_type goods_type) {
		// System.out.println("进来listnewcomputer");
		//System.out.println("pn:" + pn);
		String imagePath = request.getSession().getServletContext().getRealPath("/");
		// System.out.println(imagePath);
		String news = null;
		if (goodsCategory.equals("1")) {
			news = "全新电脑";
		} else if (goodsCategory.equals("2")) {
			news = "二手电脑";
			PageHelper.startPage(pn, 8);
			List<Goods> list = mapper.selectnewcomputer(news);
			List<String> phone = new ArrayList<>();
			for (Goods goods : list) {
				String str = goods.getGoodsPhone();
				String[] strs = str.split(",");
				goods.setGoodsPhone(strs[0]);
				phone.add(goods.getGoodsPhone());
			}
			//////////////////////////////////// 分页////////////////////////////////////
			PageInfo page = new PageInfo(list, 4);
		//	System.out.println("当前页码：" + page.getPageNum());
			model.addAttribute("pageInfo", page);
			//////////////////////////////////// 分页////////////////////////////////////
			//request.setAttribute("newcomputer", list);
			//查询商品所有类型
			List<Goods_type> listalltype = goods_typeService.getshoptype();
			request.setAttribute("alltype", listalltype);
			return "secondnewcomputer";
		}
		// 引入PageHelper分页插件
		// 在调用之前只需要调用,传入页码、以及每页的大小
		PageHelper.startPage(pn, 8);
		List<Goods> list = mapper.selectnewcomputer(news);
		List<String> phone = new ArrayList<>();
		for (Goods goods : list) {
			// System.out.println(goods.getGoodsPhone());
			String str = goods.getGoodsPhone();
			String[] strs = str.split(",");
			goods.setGoodsPhone(strs[0]);
			// System.out.println(goods.getGoodsPhone());
			phone.add(goods.getGoodsPhone());
		}
		////////////////////////////////////////////////////////////////////////////
		// 分页操作
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
		PageInfo page = new PageInfo(list, 4);
	//	System.out.println("当前页码：" + page.getPageNum());
		model.addAttribute("pageInfo", page);
		/////////////////////////////////////////////////////////////////////////
//		request.setAttribute("newcomputer", list);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "newcomputer";
	}
	// 查询所有全新电脑和二手电脑组件
	@RequestMapping(value = "listnewshop", method = RequestMethod.GET)
	public String listnewshop(HttpServletRequest request,
			@Param(value = "goodsCategory") String goodsCategory,@Param(value = "typeId") 
	        Integer typeId,Goods_type goods_type) {
		String assembly = null;
		if (goodsCategory.equals("1")) {
			assembly = "全新电脑";
		} else if (goodsCategory.equals("2")) {
			assembly = "二手电脑";
			List<Goods> list = mapper.selectnewshop(assembly, typeId);
			List<String> phone = new ArrayList<>();
			for (Goods goods : list) {
				String str = goods.getGoodsPhone();
				String[] strs = str.split(",");
				goods.setGoodsPhone(strs[0]);
				phone.add(goods.getGoodsPhone());
			}
			    request.setAttribute("newcomputer", list);
			 //查询商品所有类型
				List<Goods_type> listalltype = goods_typeService.getshoptype();
				request.setAttribute("alltype", listalltype);
			    return "fensecondnewcomputer";
		}
		List<Goods> list = mapper.selectnewshop(assembly, typeId);
		System.out.println(list);
		List<String> phone = new ArrayList<>();
		for (Goods goods : list) {
			String str = goods.getGoodsPhone();
			String[] strs = str.split(",");
			goods.setGoodsPhone(strs[0]);
			phone.add(goods.getGoodsPhone());
		}

		request.setAttribute("newcomputer", list);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "fennewcomputer";
	}

	// 查询所有电脑组件
	@RequestMapping("/listshop")
	public String listshop(HttpServletRequest request, Integer typeId,Goods_type goods_type) {
		List<Goods> list = mapper.selectshop(typeId);
		List<String> phone = new ArrayList<>();
		for (Goods goods : list) {
			String str = goods.getGoodsPhone();
			String[] strs = str.split(",");
			goods.setGoodsPhone(strs[0]);
			phone.add(goods.getGoodsPhone());
		}
		request.setAttribute("newcomputer", list);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "owncomputer";

	}

	// 模糊查询（按名称）
	@RequestMapping(value = "vagueselect", method = RequestMethod.POST)
	public String vagueselect(HttpServletRequest request, String goodsName,Goods_type goods_type) {
		List<Goods> list = mapper.vagueselect(goodsName);
		List<String> phone = new ArrayList<>();
		for (Goods goods : list) {
			String str = goods.getGoodsPhone();
			String[] strs = str.split(",");
			goods.setGoodsPhone(strs[0]);
			phone.add(goods.getGoodsPhone());
		}
		request.setAttribute("newcomputer", list);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
	    request.setAttribute("alltype", listalltype);
		return "owncomputer";
	}
	// 查询所有需求信息
	@RequestMapping("/shopneedmessage")
	public String shopneedmessage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpServletRequest request, Goods_need goods_need, Model model) {
		// 引入PageHelper分页插件
		// 在调用之前只需要调用,传入页码、以及每页的大小
		PageHelper.startPage(pn, 6);
		List<Goods_need> list = needmapper.selectByExample(null);
		// 分页操作
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
		PageInfo page = new PageInfo(list, 4);
	//	System.out.println("当前页码：" + page.getPageNum());
		model.addAttribute("pageInfo", page);
		request.setAttribute("shopneedmessage", list);
	//	System.out.println("需求信息" + list);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
	    request.setAttribute("alltype", listalltype);
		return "shopneedmessage";
	}



	// 查询个人信息
	@RequestMapping("/personal")
	public String personal(HttpServletRequest request, String account, Model model) {
		 System.out.println("查询个人信息传入前：" + account);
		member list = personMapper.selectByPrimaryKey(account);
		request.setAttribute("personal", list);
		// personMapper.updateperson(account);
		//查询商品所有类型
				List<Goods_type> listalltype = goods_typeService.getshoptype();
			    request.setAttribute("alltype", listalltype);
		return "vipcenter";

	}

	// 修改个人信息
	@RequestMapping(value = "/updatepersoninfo")
	public String updateperson(HttpServletRequest request, member member, Model model) {
		System.out.println("进入updateperson方法");
		System.out.println("修改个人信息传入前member值:" + member);
//		System.out.println(memberservice.updateByPrimaryKey(member));
		if (memberservice.updateByPrimaryKey(member)) {
			return "error";
		} else {			
	//		System.out.println("帐号" + member.getAccount());
			member = personMapper.selectByPrimaryKey(member.getAccount());
			request.setAttribute("member", member);
			model.addAttribute("member", member);
			 request.getSession().invalidate();
		//	return "vipcenter";
			return "redirect:/login.jsp"; 
		}

	}
		// 进入修改页面
	@RequestMapping("getmember")
	public String editperson(HttpServletRequest request, String account, Model model) {
//		System.out.println("进入修改页面的account" + account);
		request.setAttribute("member", personMapper.selectByPrimaryKey(account));
	//	model.addAttribute("member", personMapper.selectByPrimaryKey(account));
		return "vipPwd";

	}
	// 查看商品详情信息
	@RequestMapping("/shopinfo")
	public String shopinfo(HttpServletRequest request, Integer goodsId,Model model) {
//		System.out.println("传入前的GOODSID：" + goodsId);
		Goods goodsinfo = mapper.selectByPrimaryKey(goodsId);
//		System.out.println(goodsinfo.getGoodsPhone());
		String str = goodsinfo.getGoodsPhone();
		String[] strs = str.split(",");
		List list = (List) Arrays.asList(strs);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(list.get(i));
			request.setAttribute("phone", list);
		}
		request.setAttribute("phones", strs[0]);
		request.setAttribute("shopinfo", goodsinfo);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "shopinfo";
	}

	// 查看商品需求信息
	@RequestMapping("/shopneedinfo")
	public String shopneedinfo(HttpServletRequest request, Integer mseeageId) {
//		System.out.println("传入前的mseeageId：" + mseeageId);
		Goods_need goodsneedinfo = needmapper.selectByPrimaryKey(mseeageId);
		request.setAttribute("goodsneedinfo", goodsneedinfo);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "shopneedinfo";
	}
	//购物车信息
	@RequestMapping("shopcartinfo")
	public String shopcart(HttpServletRequest request, Integer goodsId){
		System.out.println("购物车信息 goodsId:"+goodsId);
		Goods goodsinfo = mapper.selectByPrimaryKey(goodsId);
		System.out.println(goodsinfo.getGoodsPhone());
		String str = goodsinfo.getGoodsPhone();
		String[] strs = str.split(",");
		List list = (List) Arrays.asList(strs);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(list.get(i));
			request.setAttribute("phone", list);
		}
		request.setAttribute("phones", strs[0]);
		request.setAttribute("shopcartinfo", goodsinfo);
		return "shopcart";		
	}
	//添加收藏
	@RequestMapping("/addshopcart")
	@ResponseBody
	public Msg addshopcart(Shopcart shopcart){
		System.out.println("进来了addshopcart");
		shopcartMapper.insert(shopcart);
		System.out.println("添加购物车信息："+shopcart);
		return Msg.success();	
	}
	//查询会员的购物车
	@RequestMapping("/vipshopcartinfo")
	public String shopcartinfo(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request,
			String accountId,Model model){
		PageHelper.startPage(pn, 4);
		List<Shopcart> list = shopcartMapper.selectcart(accountId);
		List<String> phone = new ArrayList<>();
		for (Shopcart goods : list) {
			String str = goods.getGoods().getGoodsPhone();
			String[] strs = str.split(",");
			goods.getGoods().setGoodsPhone(strs[0]);
            phone.add(goods.getGoods().getGoodsPhone());
		}
		PageInfo page = new PageInfo(list, 4);
		model.addAttribute("pageInfo", page);
		return "myshopcart";
	}
	//查询会员上架的商品
	@RequestMapping("/Myshoping")
	public String Myshoping(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request,
			String account,Model model){
		PageHelper.startPage(pn, 4);
	List<Goods> list =	mapper.mygoods(account);
	System.out.println("会员上架商品信息:"+list);
	List<String> phone = new ArrayList<>();
	for (Goods goods : list) {
		String str = goods.getGoodsPhone();
		String[] strs = str.split(",");
		goods.setGoodsPhone(strs[0]);
		phone.add(goods.getGoodsPhone());
	}
	PageInfo page = new PageInfo(list, 4);
	model.addAttribute("pageInfo", page);
	return "mygoods";	
	}
	
	//下架商品
	@RequestMapping("/deleteshop")
	public String deleteshop(Integer goodsId,HttpServletRequest request,String account){
		mapper.deleteByPrimaryKey(goodsId);
		System.out.println("删除时帐号"+account);
		List<Goods> list =	mapper.mygoods(account);
		System.out.println("会员上架商品信息:"+list);
		List<String> phone = new ArrayList<>();
		for (Goods goods : list) {
			String str = goods.getGoodsPhone();
			String[] strs = str.split(",");
			goods.setGoodsPhone(strs[0]);
			phone.add(goods.getGoodsPhone());
		}
		request.setAttribute("mygoods", list);
		return "mygoods";
	}
	//申请商品进入首页轮播
	@RequestMapping("/Apply")
	public String Apply(HttpServletRequest request,Integer goodsId){
		System.out.println("商品信息 goodsId:"+goodsId);
		Goods goodsinfo = mapper.selectByPrimaryKey(goodsId);
		System.out.println(goodsinfo.getGoodsPhone());
		String str = goodsinfo.getGoodsPhone();
		String[] strs = str.split(",");
		List list = (List) Arrays.asList(strs);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(list.get(i));
			request.setAttribute("phone", list);
		}
		request.setAttribute("phones", strs[0]);
		request.setAttribute("Apply", goodsinfo);	
		return "apply";		
	}
	
	//添加申请商品进入首页轮播
	@RequestMapping("/addapply")
	public String addapply(Apply apply){
		System.out.println("申请商品信息："+apply);
		applyMapper.insert(apply);
		return "successapply";
		
	}
	//立即购买
	@RequestMapping("/purchase")
	public String purchase(HttpServletRequest request,Integer goodsId){
		Goods goodsinfo =mapper.selectByPrimaryKey(goodsId);
		System.out.println("购买商品的信息:"+mapper.selectByPrimaryKey(goodsId));
		System.out.println(goodsinfo.getGoodsPhone());
		String str = goodsinfo.getGoodsPhone();
		String[] strs = str.split(",");
		List list = (List) Arrays.asList(strs);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(list.get(i));
			request.setAttribute("phone", list);
		}
		request.setAttribute("phones", strs[0]);
		request.setAttribute("purchase", goodsinfo);	
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "order";
	}
	//添加订单
	@RequestMapping("/addorder")
	public String  addorder(Orders orders,HttpServletRequest request){
		System.out.println("进到addorder了");
		System.out.println(orders.getGoodsId());
		ordersMapper.insert(orders);
		//查询商品所有类型
				List<Goods_type> listalltype = goods_typeService.getshoptype();
				request.setAttribute("alltype", listalltype);
		 return "order3";
	}
	//会员进入留言页
	@RequestMapping("/inwords")
	public String inwords(HttpServletRequest request,Integer goodsId){
	    Goods goods =mapper.selectByPrimaryKey(goodsId);	
	    request.setAttribute("goods", goods);
		return "words";
		
	}
	//会员留言
	@RequestMapping("/addwords")
	public String addwords(HttpServletRequest request,Words words,Integer goodsId,Model model){
		System.out.println("进来addwords");
		wordsMapper.insert(words);
		
		Goods goodsinfo = mapper.selectByPrimaryKey(goodsId);
		String str = goodsinfo.getGoodsPhone();
		String[] strs = str.split(",");
		List list = (List) Arrays.asList(strs);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(list.get(i));
			request.setAttribute("phone", list);
		}
		request.setAttribute("phones", strs[0]);
		request.setAttribute("shopinfo", goodsinfo);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		
		return "shopinfo";
		
	}
	//查询留言信息
	@RequestMapping("/words")
	@ResponseBody
	public Msg wordsinfo(Integer goodsId){
	//   System.out.println("进来wordsinfo里面了！！！");
	   List<Words> list = wordsMapper.selectwords(goodsId);
//	   System.out.println("留言内容"+list);
	   return Msg.success().add("words", list);
		
	}	
	//查询会员销售订单
	@RequestMapping("/querysaleorder")
	public String querysaleorder(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String account,HttpServletRequest request,Model model){
		PageHelper.startPage(pn, 4);
		List<Orders> list =ordersMapper.querysaleorder(account);	
		System.out.println(list);
		List<String> phone = new ArrayList<>();
		for (Orders goods : list) {
			String str = goods.getGoods().getGoodsPhone();
			String[] strs = str.split(",");
			goods.getGoods().setGoodsPhone(strs[0]);
            phone.add(goods.getGoods().getGoodsPhone());
		}
		PageInfo page = new PageInfo(list, 4);
		model.addAttribute("pageInfo", page);
	//	request.setAttribute("saleorder", list);
		return "mysaleorder";
	}
	//查询会员购买订单
	@RequestMapping("/querybuyorder")
	public String querybuyorder(@RequestParam(value = "pn", defaultValue = "1") Integer pn,String accountId,
			HttpServletRequest request,Model model){
		PageHelper.startPage(pn, 4);
		List<Orders> list=ordersMapper.querybuyorder(accountId);
		List<String> phone = new ArrayList<>();
		for (Orders goods : list) {
			String str = goods.getGoods().getGoodsPhone();
			String[] strs = str.split(",");
			goods.getGoods().setGoodsPhone(strs[0]);
            phone.add(goods.getGoods().getGoodsPhone());
		}
		request.setAttribute("buyorder", list);
		PageInfo page = new PageInfo(list, 4);
		model.addAttribute("pageInfo", page);
	//	request.setAttribute("saleorder", list);
		return "mybuyorder";
	}
	//访问进入主页面
	@RequestMapping("/index")
	public String Querymian(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,Integer status,
			Notice notice,Apply apply,Model model){
		//审批轮播的商品
		List<Apply> listapply = applyMapper.selectapply(1);
		request.setAttribute("applyinfo", listapply);
		//公告信息
		//每页5条	
    	PageHelper.startPage(pn, 4);
		List<Notice> listnotice = noticeMapper.selectByExample(null);
		//连续连续显示页码(1,2,3,4)
    	PageInfo pageInfo =new PageInfo(listnotice,4);
    	model.addAttribute("pageInfo",pageInfo);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "index";	
	}
	//查询所有公告
	@RequestMapping("/Queryallnotice")
	public String Queryallnotice(@RequestParam(value="pn",defaultValue="1")Integer pn,Notice notice,
			Model model,HttpServletRequest request){
		PageHelper.startPage(pn, 10);
		List<Notice> listnotice = noticeMapper.selectByExample(null);
		//连续连续显示页码(1,2,3,4)
    	PageInfo pageInfo =new PageInfo(listnotice,4);
    	model.addAttribute("pageInfo",pageInfo);
    	//查询商品所有类型
    			List<Goods_type> listalltype = goods_typeService.getshoptype();
    			request.setAttribute("alltype", listalltype);
		return "allnotice";
		
	}
	//查询公告详情
	@RequestMapping("/notice")
	public String Querynotice(HttpServletRequest request,String wordsTitle){
		System.out.println("传入标题"+wordsTitle);
		Notice listnotice =noticeMapper.selectnotice(wordsTitle);
		System.out.println(listnotice);
		request.setAttribute("notice", listnotice);
		//查询商品所有类型
		List<Goods_type> listalltype = goods_typeService.getshoptype();
		request.setAttribute("alltype", listalltype);
		return "notice";
	}
	 //注销方法
    @RequestMapping("/outLogin")
    public String outLogin(Model model,HttpServletRequest request){
    	System.out.println("进来退出登录了");
    	//通过session.invalidata()方法来注销当前的session
    	request.getSession().removeAttribute("member");//加上这句
    	request.getSession(false);
        request.getSession().invalidate();
        System.out.println(request.getAttribute("member"));
      //  return "success";
        return "redirect:/NewFile.jsp"; 
    }
}
