package edu.jxau.service.match;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import edu.jxau.service.match.support.MatchResult;

public class ThesisMatcherTest {

	@Test
	public void testThesisMatcher() throws IOException {
		String document = "伍嘉宇 20111415 毕业论文二稿-修改意见.doc";
		Matcher m = new ThesisMatcher(document);
		MatchResult mr = m.matches("伍嘉宇 20111415 毕业论文二稿-修改意见.doc");
		System.out.println(mr.getRate());
	}

	@Test
	public void testMatchesString() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchesStringRules() {
		fail("Not yet implemented");
	}

}
