package edu.jxau.service.match.support;


public class MatchResult {
	
	// 匹配率
	private double rate;

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String result() {
		//DecimalFormat df = new DecimalFormat("#.##");
		return rate * 100 + "%";
	}
	
	@Override
	public String toString() {
		return "MatchResult [rate=" + rate + "]";
	}
	
}
