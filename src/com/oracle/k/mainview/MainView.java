package com.oracle.k.mainview;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.oracle.k.bean.TBrand;
import com.oracle.k.bean.TCar;
import com.oracle.k.bean.TCategory;
import com.oracle.k.bean.TRecord;
import com.oracle.k.bean.TUser;
import com.oracle.k.dao.TBrandDao;
import com.oracle.k.dao.TCarDao;
import com.oracle.k.dao.TCategoryDao;
import com.oracle.k.dao.TRecordDao;
import com.oracle.k.dao.TUserDao;

public class MainView {
	Scanner input = new Scanner(System.in);
	TUserDao ud=new TUserDao();
	TBrandDao bd=new TBrandDao();
	TCategoryDao cgd=new TCategoryDao();
	TCarDao cd=new TCarDao();
	TRecordDao rd=new TRecordDao();
	
	
	/**
	 * 主视图
	 */
	public void mainview() {
		System.out.println("===============================================================================================================================================");
		System.out.println("\t\t\t欢迎访问二嗨租车");
		System.out.println("===============================================================================================================================================");
		System.out.println("1、注册\t2、登陆\t3、退出");
		switch(input.nextInt()) {
		case 1:
			register();
			mainview();
			break;
			
		case 2:
			login();
			mainview();
			break;
		case 3:
			System.exit(0);
		}
	}
	
	/**
	 * 注册
	 */
	public void register() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入用户名:");
		String username=input.next();
		TUser u=ud.queryByName(username);
		if(u.getUsername()!=null) {
			System.out.println("此用户名已被注册");
		}else {
			System.out.println("请输入密码:");
			String password=input.next();
			System.out.println("请输入性别:");
			String sex=input.next();
			System.out.println("请输入身份证号码:");
			String id_number=input.next();
			System.out.println("请输入手机号码:");
			String tel=input.next();
			System.out.println("请输入居住地址:");
			String addr=input.next();
			int rows=ud.addUser(username, password, sex, id_number, tel, addr);
			if(rows==0) {
				System.out.println("注册失败");
			}else {
				System.out.println("注册成功");
			}
		}
		System.out.println("===============================================================================================================================================");
		
	}
	
	/**
	 * 登陆????
	 */
	public void login() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入用户名:");
		String username=input.next();
		System.out.println("请输入密码:");
		String password=input.next();
		TUser u=ud.queryByName(username);
		if(u.getUsername()!=null&&u.getPassword().equals(password)) {
			if (u.getType()==0) {
				view0(u.getUsername());
			}
			else {
				view1();
			}
			
		}else {
			System.out.println("用户名或密码错误");
		}
	}
	
	/**
	 * 普通用户视图
	 */
	public void view0(String username) {
		System.out.println("===============================================================================================================================================");
		System.out.println("1、查看所有汽车\t2、按照价格升序/降序查询汽车\t3、按照类别查看汽车");
		System.out.println("4、按照品牌查看汽车\t5、查看本人所有租赁记录\t6、租车\t7、还车\t0、退出");
		System.out.println("===============================================================================================================================================");
		switch(input.next()) {
		case "1":
			queryAllCar0();
			view0(username);
			break;
		case "2":
			queryCarByPrice0();
			view0(username);
			break;
		case "3":
			queryCarbyCategory0();
			view0(username);
		case "4":
			queryCarByBrand0();
			view0(username);
		case "5":
			queryRecordByName0(username);
			view0(username);
			break;
		case "6":
			rentCar(username);
			view0(username);
			break;
		case "7":
			returnCar(username);
			view0(username);
			break;
		case "0":
			System.exit(0);
		default:
			break;
		}
	}
	
	/**
	 * 管理员视图
	 */
	public void view1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("1、查看汽车信息\t2、添加汽车\t3、修改汽车信息\t4、查看所有用户全部租赁记录");
		System.out.println("5、查看指定用户租赁记录\t6、查看指定汽车租赁记录\t0、退出");
		System.out.println("===============================================================================================================================================");
		switch(input.next()) {
		case "0":
			System.exit(0);
		case "1":
			queryCar1();
			view1();
			break;
		case "2":
			addCar();
			view1();
			break;
		case "3":
			updateCar1();
			view1();
		case "4":
			queryAllRecord();
			view1();
			break;
		case "5":
			queryRecordByName1();
			view1();
			break;
		case "6":
			queryRecordByCar1();
			view1();
			break;
		default:
			break;
				
			
		}
	}
	
	/**
	 * 查看所有汽车
	 */
	public void queryAllCar0() {
		System.out.println("===============================================================================================================================================");
		List<TCar> list =cd.queryAll0();
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent");
		for(TCar c:list) {
			System.out.println(c.toString0());
		}
	}
	
	/**
	 * 按照价格查询
	 */
	public void queryCarByPrice0() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请选择排序方式\t1、升序\t2、降序");
		if(input.nextInt()==1) {
			System.out.println("===============================================================================================================================================");
			List<TCar> list =cd.queryAllByAsc0();
			System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent");
			for(TCar c:list) {
				System.out.println(c.toString0());
			}
		}else if(input.nextInt()==2) {
			System.out.println("===============================================================================================================================================");
			List<TCar> list=cd.queryAllByDesc0();
			System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent");
			for(TCar c:list) {
				System.out.println(c.toString0());
			}
		}else {
			System.out.println("没有该项选择,排序结束:");
		}
	}
	
	/**
	 * 按照类别查询
	 */
	public void queryCarbyCategory0() {
		System.out.println("===============================================================================================================================================");
		List<TCategory> list =cgd.queryAll();
		System.out.println("id\tname");
		for(TCategory cag:list) {
			System.out.println(cag.toString());
		}
		System.out.println("请输入需要选择的类别的id:");
		List<TCar> list1=cd.queryByCategory(input.nextInt(),0);
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent");
		for(TCar c:list1) {
			System.out.println(c.toString0());
		}		
	}
	
	public void queryCarByBrand0() {
		System.out.println("===============================================================================================================================================");
		List<TBrand> list =bd.queryAll();
		System.out.println("id\tname");
		for(TBrand b:list) {
			System.out.println(b.toString());
		}
		System.out.println("请输入需要选择的类别的id:");
		List<TCar> list1=cd.queryByBrand(input.nextInt(),0);
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent");
		for(TCar c:list1) {
			System.out.println(c.toString0());
		}		
	}
	
	public void queryRecordByName0(String username) {
		System.out.println("===============================================================================================================================================");
		TUser u=ud.queryByName(username);
		int user_id=u.getId();
		List<TRecord> list=rd.queryByUser(user_id);
		System.out.println("id\tuser\tcar\tstart_date\treturn_date\tpayment");
		for(TRecord r:list) {
			System.out.println(r.toString());
		}			
	}
	
	public void rentCar(String username) {
		System.out.println("===============================================================================================================================================");
		queryAllCar0();
		System.out.println("是否租车:\t1、是\t2、否");
		int no=input.nextInt();
		if(no==1) {
			TUser u=ud.queryByName(username);
			int user_id=u.getId();
			System.out.println("请输入汽车id");
			int car_id=input.nextInt();
			Date day=new Date();    

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			String start_date=df.format(day);
 
			System.out.println("是否确认:\t1、是\t2、否");
			int num=input.nextInt();
			if(num==1) {
			int rows =rd.addRecord(user_id, car_id, start_date);
			if(rows!=0) {
				int man=cd.updateByCar(car_id, 1);
				if(man==0) {
					System.out.println("租车失败");
					
					rd.deleteRecord(user_id,car_id);
					cd.updateByCar(car_id, 0);
				}else {
					System.out.println("租车成功");
				}
			}else {
				System.out.println("租车失败");
			}
		}
	}
	}
	
	/**
	 * 还车
	 */
	public void returnCar(String username) {
		System.out.println("===============================================================================================================================================");
		System.out.println("欢迎使用还车功能");
		queryRecordByName0(username);
		System.out.println("请输入订单号");
		int id=input.nextInt();
		TUser u=ud.queryByName(username);
		int user_id=u.getId();
		TRecord r=rd.queryById(id);
		int car_id=r.getCar_id();
		System.out.println("是否确认还车\t1、是\t2、否");
		int no1=input.nextInt();
		if(no1==1&&r.getPayment()==0) {
			Date day=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String return_date=df.format(day);
			
			TCar c=cd.queryById(car_id);
			double payment= c.getRent()*getDaySub(r.getStart_date(), return_date);
			int raws=cd.updateByCar(car_id, 0);
			int rows=rd.updateRecord0(id,user_id, return_date,payment);
			if(raws==0||rows==0)
			{
				System.out.println("还车失败");
				System.out.println("请选择需要执行的操作");
			}
			else {
				System.out.println("还车成功，欢迎再来");
				System.out.println("退出登陆");
			}
		}else {
			System.out.println("操作失误");
		}
	}
	
	public void queryCar1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("1、全部汽车\t2、指定汽车");
		int no=input.nextInt();
		if(no==1) {
		System.out.println("===============================================================================================================================================");
		List<TCar> list =cd.queryAll1();
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent\tstatus\tuserable");
		for(TCar c:list) {
			System.out.println(c.toString());
		}
		}else {
			System.out.println("===============================================================================================================================================");
			System.out.println("请输入指定汽车的车牌");
			String num=input.next();
			List<TCar> list1=cd.queryAllByNum(num);
			System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent\tstatus\tuserable");
			for(TCar c:list1) {
				System.out.println(c.toString());
			}
		}
	}
	
	public void addCar() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入车牌");
		String car_number=input.next();
		TCar c=cd.queryByCar_number(car_number);
		if(c.getCar_number()!=null) {
			System.out.println("该车牌已有，不可添加");
		}else {
			System.out.println("请输入品牌编号");
			int brand_id=input.nextInt();
			System.out.println("请输入汽车型号");
			String model=input.next();
			System.err.println("请输入颜色");
			String color=input.next();
			System.out.println("请输入类别编号");
			int category_id=input.nextInt();
			System.out.println("请输入汽车简介");
			String t_comments=input.next();
			System.out.println("请输入汽车市场价");
			double price=input.nextDouble();
			System.out.println("请输入汽车日租价");
			double rent=input.nextDouble();
			System.out.println("请输入汽车状态");
			int status=input.nextInt();
			System.out.println("请输入汽车是否上架");
			int useable=input.nextInt();
			int rows=cd.addCar(car_number, brand_id, model, color, category_id, t_comments, price, rent, status, useable);
			if(rows==0) {
				System.out.println("添加失败");
			}else {
				System.out.println("添加成功");
			}
			
		}
	}
	
	public void updateCar1() {
		System.out.println("===============================================================================================================================================");
		List<TCar> list =cd.queryAll1();
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent\tstatus\tuserable");
		for(TCar c:list) {
			System.out.println(c.toString());
		}
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入需要修改的汽车id");
		int id=input.nextInt();
		TCar c=cd.queryById(id);
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent\tstatus\tuserable");
		System.out.println(c.toString());
		System.out.println("1、日租金\t2、是否上架");
		int no=input.nextInt();
		if(no==1) {
			System.out.println("请输入日租金");
			double rent=input.nextDouble();
			int rows=cd.updateByCar1(id, rent);
			if(rows==0) {
				System.out.println("修改失败");
			}else {
				System.out.println("修改成功");
			}
		}else if(no==2){
			System.out.println("请输入是否上架（0表示上架\t1表示下架）");
			int useable=input.nextInt();
			int rows=cd.updateByCar2(id, useable);
			if(rows==0) {
				System.out.println("修改失败");
			}else {
				System.out.println("修改成功");
			}
		}else {
			System.out.println("操作失败");
		}
	}
	
	public void queryAllRecord() {
		System.out.println("===============================================================================================================================================");
		List<TRecord> list=rd.queryAll();
		System.out.println("id\tuser\tcar\tstart_date\treturn_date\t payment");
		for(TRecord r:list) {
			System.out.println(r.toString());
		}
	}
	
	public void queryRecordByName1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入需要查询的用户姓名");
		String username=input.next();
		TUser u=ud.queryByName(username);
		int user_id=u.getId();
		List<TRecord> list=rd.queryByUser(user_id);
		System.out.println("id\tuser\tcar\tstart_date\treturn_date\t payment");
		for(TRecord r:list) {
			System.out.println(r.toString());
		}
	}
	
	public void queryRecordByCar1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("请输入需要查询的汽车编号");
		int car_id=input.nextInt();
		List<TRecord> list=rd.queryByCar(car_id);
		System.out.println("id\tuser\tcar\tstart_date\treturn_date\t payment");
		for(TRecord r:list){
			System.out.println(r.toString());
		}
	}
	
	
	public void queryRecordByname0(String username) {
		System.out.println("===============================================================================================================================================");
		TUser u=ud.queryByName(username);
		int user_id=u.getId();
		List<TRecord> list=rd.queryByUser0(user_id);
		System.out.println("id\tuser\tcar\tstart_date\treturn_date\t payment");
		for(TRecord r:list) {
			System.out.println(r.toString());
		}
	}
	
	public long getDaySub(String start_date,String return_date){
	       long day=0;
	       java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
	       java.util.Date beginDate;
	       java.util.Date endDate;
	       try
	       {
	           beginDate = format.parse(start_date);
	           endDate= format.parse(return_date);    
	           day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000)+1;    
	           //System.out.println("相隔的天数="+day);   
	       } catch (ParseException e)
	       {
	           // TODO 自动生成 catch 块
	           e.printStackTrace();
	       }   
	       return day;
	   }
}
