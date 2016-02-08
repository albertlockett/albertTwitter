package ca.albertlockett.alberttwitter.service;

public interface TweetContentTransformer {

	/**
	 * used to transform tweet content, possibly for validation reasons or
	 * for reasons of readability
	 * @param tweetContent content of tweet to transform
	 * @return transformed tweet content
	 */
	public String transformTweetContent(String tweetContent);
	
}
