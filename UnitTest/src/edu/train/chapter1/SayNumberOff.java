package edu.train.chapter1;

public class SayNumberOff {
	
	int[] persons = new int[10];
	
	// 报3人数
	int count = 0;
	
	int size = persons.length;
	
	public int numberOff() {
		int number = 0;
		int index = 0;
		while(count < size -1) {
			/*if(count == 9) {
				break;
			}*/
			if(index == size) {
				index = 0;
			}
			if(persons[index] == 1) {
				index++;
				continue;
			}
			if(number == 3) {
				persons[index] = 1;
				count++;
				number = 0;
			}
			index ++;
			number++;
		}
		for(int i = 0 ; i < size ; i ++ ){
			if(persons[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SayNumberOff sno = new SayNumberOff();
		int index = sno.numberOff();
		System.out.println("第" + (index) + "个人为最后一个");
		
	}
}
