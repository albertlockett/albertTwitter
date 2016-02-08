package ca.albertlockett.alberttwitter.service;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TweetContentTransformerImplTest {

	private TweetContentTransformerImpl target;
	
	@Before
	public void setUp() {
		target = new TweetContentTransformerImpl();
	}
	
	@Test
	public void removesAllLessThanTagFromContent() {
		String content = "Some Tweet Content with < <";
		String transformedContent = "Some Tweet Content with &lt; &lt;";
		
		Assert.assertEquals(transformedContent, 
				target.transformTweetContent(content));
		
	}
	
	@Test
	public void removesAllGreaterThanTagFromContent() {
		String content = "Some Tweet Content with > >";
		String transformedContent = "Some Tweet Content with &gt; &gt;";
		
		Assert.assertEquals(transformedContent, 
				target.transformTweetContent(content));
		
	}
}
