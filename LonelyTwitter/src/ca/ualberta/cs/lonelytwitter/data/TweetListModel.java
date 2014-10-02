package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public class TweetListModel {

	private List<AbstractTweet> tweets = new ArrayList<AbstractTweet>();
	private int count = 0;

	public TweetListModel() {
	}
	
	public TweetListModel(List<AbstractTweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Appends the specified tweet to the end of this list. Throws
	 * IllegalArgumentException if it is a repeated tweet.
	 * 
	 * @param tweet
	 *            Tweet to be appended to this list
	 */
	public void addTweet(AbstractTweet tweet) {
		
		for(AbstractTweet t : tweets) {
			if( t.getTweetBody() == tweet.getTweetBody()) {
				throw new IllegalArgumentException();
			}
		}
		
		tweets.add(tweet);
	}

	/**
	 * Returns the number of tweets in this list.
	 * 
	 * @return the number of tweets in this list
	 */
	public int getCount() {
		
		for(AbstractTweet t : tweets) {
			count += 1;
		}
		
		return count;
	}

	/**
	 * Returns true if this list contains the tweet
	 * 
	 * @param tweet
	 *            Tweet whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean hasTweet(AbstractTweet tweet) {
		
		boolean present;
		
		present = tweets.contains(tweet);

		return present;
	}

	/**
	 * Removes the first occurrence of the specified tweet from this list, if it
	 * is present.
	 * 
	 * @param tweet
	 *            Tweet to be removed from this list, if present.
	 */
	public void removeTweet(AbstractTweet tweet) {
		
		boolean present;
		
		present = tweets.contains(tweet);
		
		if(present) {
			tweets.remove(tweet);
		}
	}

	/**
	 * Returns an array containing all of the tweets in this list in proper
	 * sequence.
	 * 
	 * @return an array containing the tweets of the list.
	 */
	public AbstractTweet[] getTweets() {
		
		Collections.sort(this.tweets, new Comparator<AbstractTweet>() {
			public int compare(AbstractTweet t1, AbstractTweet t2)
			{
				return t1.getTweetDate().compareTo(t2.getTweetDate());
			}
		});
		
		return this.tweets.toArray(new AbstractTweet[this.tweets.size()]);
	}

	/**
	 * Returns the list of tweets.
	 * 
	 * @return The list of tweets.
	 */
	public List<AbstractTweet> getList() {
		return tweets;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after
	 * this call returns.
	 */
	public void clear() {
		tweets.clear();
	}
}