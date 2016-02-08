package ca.albertlockett.alberttwitter.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ca.albertlockett.alberttwitter.service.TweetContentTransformer;
import ca.albertlockett.alberttwitter.service.TweetContentTransformerImpl;

/**
 * Custom tag for writing tweet content
 * @author albertlockett
 *
 */
public class TweetContent extends SimpleTagSupport {

	
	private TweetContentTransformer tweetContentTransformer
			= new TweetContentTransformerImpl();
	
	StringWriter sw = new StringWriter();
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(sw);
		String tweetContent = tweetContentTransformer
				.transformTweetContent(sw.toString());
		getJspContext().getOut().println(tweetContent);
	}
	
}
