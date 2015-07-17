package project.clazz;

public class MemberDefine implements Comparable<MemberDefine> {

	private String name;

	private Integer number;

	public MemberDefine(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int compareTo(MemberDefine o) {
		if (this.number > o.number) {
			return 1;
		} else if (this.number < o.number) {
			return -1;
		}
		return 0;
	}

}
