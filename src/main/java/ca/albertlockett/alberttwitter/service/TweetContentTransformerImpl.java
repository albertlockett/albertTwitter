package ca.albertlockett.alberttwitter.service;

import org.springframework.stereotype.Service;

@Service
public class TweetContentTransformerImpl implements TweetContentTransformer {

	public String transformTweetContent(String tweetContent) {
		return removeHtmlMarkup(tweetContent);
	}
	
	
	private String removeHtmlMarkup(String tweetContent){
		String fixedContent = tweetContent.replaceAll("<", "&lt;");
		fixedContent = fixedContent.replaceAll(">", "&gt;");
		return fixedContent;
	}
	
}
