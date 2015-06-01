package edu.jxau.dao;

import org.junit.Test;
import org.web.exception.DBException;

import edu.jxau.po.User;
import edu.jxau.vo.UserInfo;

public class UserInfoDaoTest {

	@Test
	public void testGetByUser() throws DBException {
		User user = new User();
		user.setU_id("20121576");
		UserInfo userInfo = new UserInfoDao().getByUser(user);
		System.out.println(userInfo);
	}

	@Test
	public void testSplit() {
		String str = "李四:67|张三:88|王五:76";
		str = str.replace(":", "-->").replace("|", "\n");
		System.out.println(str);
	}

	@Test
	public void testJudgePortCode() {
		String portCode = "331300";
		if (portCode.matches("\\d{6}")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	/**
	 * 3、写一个方法，该方法接收的参数是一个String类型的参数， 该方法让其变成大写的字符串。
	 *  例如 String str = "2312319"；
	 * public void daxie(String str) { 
	 * //代码 输出 贰叁壹贰叁壹玖 } 
	 * （提示：把大写的数字放到一个数组中
	 * 然后利用String的API去完成）
	 */
	
	@Test
	public void convertUpperCase() {
		daxie("45721");
	}
	
	public void daxie(String str){
		// 定义转换成中文的字符变量
		String chineseStr = "";
		// 定义数组，存储了每个数字对应的中文字符，从1-10
		char[] numberChinese = new char[]{'壹','贰','叁','肆','伍','陆','柒','捌','玖'};
		// 将原来的数字字符转换成char数组，即每个字符占一位
		char[] splitStrs = str.toCharArray();
		// 进行for循环
		for(int i = 0 ; i < splitStrs.length ; i ++) {
			// splitStrs[i]是获得当前的对应的数字，
			// String.valueof()方法是将char类型的数转换成String类型
			// Integer.parseInt()方法是将String类型的数字转换成int类型
			// 之后得到对应的数字，因为numberChinese这个数组中是从1-10排好了序的，
			// 所以转换成int类型的数对应的下标即是对应的中文，因为数组下标是从0开始，所以要用number-1
			int number = Integer.parseInt(String.valueOf(splitStrs[i]));
			chineseStr += numberChinese[number-1];
		}
		System.out.println(str + "转换成中文大写为：" + chineseStr);
	}
	
}
