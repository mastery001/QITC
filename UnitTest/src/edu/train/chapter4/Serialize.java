package edu.train.chapter4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	
	private File file;
	
	public Serialize(String fileName) {
		this.file = new File(fileName);
	}

	/**
	 * 将对象序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void serialize(Object obj) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	
	/**
	 * 将对象序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public Object getSerializeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Serialize s = new Serialize("Person.txt");
		Person p = new Person();
		p.setId("20121558");
		p.setName("tjl");
		s.serialize(p);
		p = (Person) s.getSerializeObject();
		System.out.println("反序列化对象为：" + p);
		
	}
}
