package edu.train.chapter3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeFormat {
	
	public void correctDate() {
		Scanner scanner = new Scanner(System.in);
		String dateSource = inputDate(scanner);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		int index = 0;
		// 若是输入日期格式错误最多只允许输入3次
		while(index < 3) {
			try {
				date = sdf.parse(dateSource);
			} catch (ParseException e) {
				System.out.println("输入的日期格式错误！");
				dateSource = inputDate(scanner);
				index++;
				continue;
			}
			break;
		}
		if(date == null) {
			throw new Error("错误！输入3次日期格式错误！系统关闭！");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		markDay(c.get(Calendar.DATE));
	}
	
	/**
	 * 标记正确的日期
	 */
	private void markDay(int day) {
		String split = "　　";
		String[] chinese = new String[]{"日" ,"一" ,"二" ,"三" ,"四" ,"五" ,"六" };
		for(int i = 0 ; i <chinese.length ; i++) {
			System.out.print(chinese[i]);
			System.out.print("　   ");
		}
		System.out.println();
		for(int i = 1 ; i < 32 ; i ++) {
			if(i > 9 ){
				split = "　";
			}
			if(i == day) {
				System.out.print("*" + i);
			}else {
				System.out.print(i);
			}
			System.out.print(split);
			// 隔7个数字换行
			if(i % 7 == 0) {
				System.out.println();
			}
			
		
		}
	}
	/**
	 * 输入日期
	 * @param scanner
	 * @return
	 */
	private String inputDate(Scanner scanner) {
		System.out.print("请输入日期（格式XXXX-XX-XX）：");
		String date = scanner.next();
		return date;
	}
	
	public static void main(String[] args) {
		new TimeFormat().correctDate();
	}
}
