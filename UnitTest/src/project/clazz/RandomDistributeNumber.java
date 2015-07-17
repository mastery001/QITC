package project.clazz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomDistributeNumber {

	private static final List<MemberDefine> list = new ArrayList<MemberDefine>();
	
	private static final Map<Integer, Integer> number = new HashMap<Integer, Integer>();

	static {
		list.add(new MemberDefine("Ğ»Ö¾Áè"));
		list.add(new MemberDefine("Áè³¿"));
		list.add(new MemberDefine("³Âº£ÁÖ"));
		list.add(new MemberDefine("ÓàÎÄºÆ"));
		list.add(new MemberDefine("ºú½¨Çå"));
		list.add(new MemberDefine("ÑîÑ×"));
		list.add(new MemberDefine("Àî½¨»Ô"));
		list.add(new MemberDefine("ÍõêØÓî"));
		list.add(new MemberDefine("ÖÜºéÎ°"));
		list.add(new MemberDefine("Ğ»ÇåÈª"));
		list.add(new MemberDefine("ÀîÊØÒÇ"));
		list.add(new MemberDefine("ÅíÎÄ»ª"));
		list.add(new MemberDefine("êÌËÕÃÈ"));
		list.add(new MemberDefine("Áõ¸£"));
		list.add(new MemberDefine("ÖÜÎÄ·å"));
		list.add(new MemberDefine("Ö£±±Áú"));
		list.add(new MemberDefine("ÖÜÖİ"));
		list.add(new MemberDefine("Ö£Ñà·É"));
		list.add(new MemberDefine("ÖÓ¼ÎºÀ"));
		list.add(new MemberDefine("»Æ±ö"));
		list.add(new MemberDefine("Ò¶ÕñÖİ"));
		list.add(new MemberDefine("ÓàÕÂÎ°"));
		list.add(new MemberDefine("³ÂÌÎ"));
		list.add(new MemberDefine("ÁÖÍş"));
		list.add(new MemberDefine("ÕÅÒ³ºã"));
		list.add(new MemberDefine("Å£½¨"));
		list.add(new MemberDefine("ĞÜÅô"));
		list.add(new MemberDefine("×Ş×Ïö©"));
		list.add(new MemberDefine("ÍõÇ¿"));
		list.add(new MemberDefine("Ô¬¿­"));
		list.add(new MemberDefine("µËÓîÈ¨"));
		list.add(new MemberDefine("ÍõÖĞ"));
		list.add(new MemberDefine("ÍõÅå"));
	};

	public void distribute() {
		for(MemberDefine md : list) {
			md.setNumber(getInt());
		}
	}
	
	public String showNumber() {
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(MemberDefine md : list) {
			sb.append(md.getNumber() + "===" + md.getName() + "\r\n");
		}
		return sb.toString();
	}
	
	public void printToFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("member.txt")));
		bw.write(showNumber());
		bw.flush();
		bw.close();
	}
	
	public int getInt() {
		int random = (int)(Math.random() * list.size());
		if(!number.containsKey(random)) {
			number.put(random , null);
			return random;
		}
		return getInt();
	}
	
	
	public static void main(String[] args) throws IOException {
		RandomDistributeNumber rdn = new RandomDistributeNumber();
		rdn.distribute();
		rdn.printToFile();
	}
}
