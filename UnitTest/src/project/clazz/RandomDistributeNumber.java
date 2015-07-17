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
		list.add(new MemberDefine("л־��"));
		list.add(new MemberDefine("�賿"));
		list.add(new MemberDefine("�º���"));
		list.add(new MemberDefine("���ĺ�"));
		list.add(new MemberDefine("������"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("���"));
		list.add(new MemberDefine("������"));
		list.add(new MemberDefine("�ܺ�ΰ"));
		list.add(new MemberDefine("л��Ȫ"));
		list.add(new MemberDefine("������"));
		list.add(new MemberDefine("���Ļ�"));
		list.add(new MemberDefine("������"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("���ķ�"));
		list.add(new MemberDefine("֣����"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("֣���"));
		list.add(new MemberDefine("�Ӽκ�"));
		list.add(new MemberDefine("�Ʊ�"));
		list.add(new MemberDefine("Ҷ����"));
		list.add(new MemberDefine("����ΰ"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("��ҳ��"));
		list.add(new MemberDefine("ţ��"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("������"));
		list.add(new MemberDefine("��ǿ"));
		list.add(new MemberDefine("Ԭ��"));
		list.add(new MemberDefine("����Ȩ"));
		list.add(new MemberDefine("����"));
		list.add(new MemberDefine("����"));
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
