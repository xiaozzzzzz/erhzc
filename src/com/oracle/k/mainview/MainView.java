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
	 * ����ͼ
	 */
	public void mainview() {
		System.out.println("===============================================================================================================================================");
		System.out.println("\t\t\t��ӭ���ʶ����⳵");
		System.out.println("===============================================================================================================================================");
		System.out.println("1��ע��\t2����½\t3���˳�");
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
	 * ע��
	 */
	public void register() {
		System.out.println("===============================================================================================================================================");
		System.out.println("�������û���:");
		String username=input.next();
		TUser u=ud.queryByName(username);
		if(u.getUsername()!=null) {
			System.out.println("���û����ѱ�ע��");
		}else {
			System.out.println("����������:");
			String password=input.next();
			System.out.println("�������Ա�:");
			String sex=input.next();
			System.out.println("���������֤����:");
			String id_number=input.next();
			System.out.println("�������ֻ�����:");
			String tel=input.next();
			System.out.println("�������ס��ַ:");
			String addr=input.next();
			int rows=ud.addUser(username, password, sex, id_number, tel, addr);
			if(rows==0) {
				System.out.println("ע��ʧ��");
			}else {
				System.out.println("ע��ɹ�");
			}
		}
		System.out.println("===============================================================================================================================================");
		
	}
	
	/**
	 * ��½????
	 */
	public void login() {
		System.out.println("===============================================================================================================================================");
		System.out.println("�������û���:");
		String username=input.next();
		System.out.println("����������:");
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
			System.out.println("�û������������");
		}
	}
	
	/**
	 * ��ͨ�û���ͼ
	 */
	public void view0(String username) {
		System.out.println("===============================================================================================================================================");
		System.out.println("1���鿴��������\t2�����ռ۸�����/�����ѯ����\t3���������鿴����");
		System.out.println("4������Ʒ�Ʋ鿴����\t5���鿴�����������޼�¼\t6���⳵\t7������\t0���˳�");
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
	 * ����Ա��ͼ
	 */
	public void view1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("1���鿴������Ϣ\t2���������\t3���޸�������Ϣ\t4���鿴�����û�ȫ�����޼�¼");
		System.out.println("5���鿴ָ���û����޼�¼\t6���鿴ָ���������޼�¼\t0���˳�");
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
	 * �鿴��������
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
	 * ���ռ۸��ѯ
	 */
	public void queryCarByPrice0() {
		System.out.println("===============================================================================================================================================");
		System.out.println("��ѡ������ʽ\t1������\t2������");
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
			System.out.println("û�и���ѡ��,�������:");
		}
	}
	
	/**
	 * ��������ѯ
	 */
	public void queryCarbyCategory0() {
		System.out.println("===============================================================================================================================================");
		List<TCategory> list =cgd.queryAll();
		System.out.println("id\tname");
		for(TCategory cag:list) {
			System.out.println(cag.toString());
		}
		System.out.println("��������Ҫѡ�������id:");
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
		System.out.println("��������Ҫѡ�������id:");
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
		System.out.println("�Ƿ��⳵:\t1����\t2����");
		int no=input.nextInt();
		if(no==1) {
			TUser u=ud.queryByName(username);
			int user_id=u.getId();
			System.out.println("����������id");
			int car_id=input.nextInt();
			Date day=new Date();    

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			String start_date=df.format(day);
 
			System.out.println("�Ƿ�ȷ��:\t1����\t2����");
			int num=input.nextInt();
			if(num==1) {
			int rows =rd.addRecord(user_id, car_id, start_date);
			if(rows!=0) {
				int man=cd.updateByCar(car_id, 1);
				if(man==0) {
					System.out.println("�⳵ʧ��");
					
					rd.deleteRecord(user_id,car_id);
					cd.updateByCar(car_id, 0);
				}else {
					System.out.println("�⳵�ɹ�");
				}
			}else {
				System.out.println("�⳵ʧ��");
			}
		}
	}
	}
	
	/**
	 * ����
	 */
	public void returnCar(String username) {
		System.out.println("===============================================================================================================================================");
		System.out.println("��ӭʹ�û�������");
		queryRecordByName0(username);
		System.out.println("�����붩����");
		int id=input.nextInt();
		TUser u=ud.queryByName(username);
		int user_id=u.getId();
		TRecord r=rd.queryById(id);
		int car_id=r.getCar_id();
		System.out.println("�Ƿ�ȷ�ϻ���\t1����\t2����");
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
				System.out.println("����ʧ��");
				System.out.println("��ѡ����Ҫִ�еĲ���");
			}
			else {
				System.out.println("�����ɹ�����ӭ����");
				System.out.println("�˳���½");
			}
		}else {
			System.out.println("����ʧ��");
		}
	}
	
	public void queryCar1() {
		System.out.println("===============================================================================================================================================");
		System.out.println("1��ȫ������\t2��ָ������");
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
			System.out.println("������ָ�������ĳ���");
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
		System.out.println("�����복��");
		String car_number=input.next();
		TCar c=cd.queryByCar_number(car_number);
		if(c.getCar_number()!=null) {
			System.out.println("�ó������У��������");
		}else {
			System.out.println("������Ʒ�Ʊ��");
			int brand_id=input.nextInt();
			System.out.println("�����������ͺ�");
			String model=input.next();
			System.err.println("��������ɫ");
			String color=input.next();
			System.out.println("�����������");
			int category_id=input.nextInt();
			System.out.println("�������������");
			String t_comments=input.next();
			System.out.println("�����������г���");
			double price=input.nextDouble();
			System.out.println("���������������");
			double rent=input.nextDouble();
			System.out.println("����������״̬");
			int status=input.nextInt();
			System.out.println("�����������Ƿ��ϼ�");
			int useable=input.nextInt();
			int rows=cd.addCar(car_number, brand_id, model, color, category_id, t_comments, price, rent, status, useable);
			if(rows==0) {
				System.out.println("���ʧ��");
			}else {
				System.out.println("��ӳɹ�");
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
		System.out.println("��������Ҫ�޸ĵ�����id");
		int id=input.nextInt();
		TCar c=cd.queryById(id);
		System.out.println("id\tcar_number\tbrand_id\tmodel\tcolor\tcategory_id\tt_comments\tprice\t\trent\tstatus\tuserable");
		System.out.println(c.toString());
		System.out.println("1�������\t2���Ƿ��ϼ�");
		int no=input.nextInt();
		if(no==1) {
			System.out.println("�����������");
			double rent=input.nextDouble();
			int rows=cd.updateByCar1(id, rent);
			if(rows==0) {
				System.out.println("�޸�ʧ��");
			}else {
				System.out.println("�޸ĳɹ�");
			}
		}else if(no==2){
			System.out.println("�������Ƿ��ϼܣ�0��ʾ�ϼ�\t1��ʾ�¼ܣ�");
			int useable=input.nextInt();
			int rows=cd.updateByCar2(id, useable);
			if(rows==0) {
				System.out.println("�޸�ʧ��");
			}else {
				System.out.println("�޸ĳɹ�");
			}
		}else {
			System.out.println("����ʧ��");
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
		System.out.println("��������Ҫ��ѯ���û�����");
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
		System.out.println("��������Ҫ��ѯ���������");
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
	           //System.out.println("���������="+day);   
	       } catch (ParseException e)
	       {
	           // TODO �Զ����� catch ��
	           e.printStackTrace();
	       }   
	       return day;
	   }
}
