package ca.ualberta.cs.lonelytwitter.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;


public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testDoubleTweet() {
		
		TweetListModel list = new TweetListModel();
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		
		list.addTweet(t);
		
		try {
			list.addTweet(t2);
		} 
		catch(IllegalArgumentException e) {
			assertNotNull("Did not add double tweet", e);
		}
		
	}
	
	public void testNewTweet() {
		
		TweetListModel list = new TweetListModel();
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Not Hello");
		
		list.addTweet(t);
		
		try {
			list.addTweet(t2);
		} 
		catch(IllegalArgumentException e) {
			assertNotNull("Did not add double tweet", e);
		}
		
	}
	
	public void testCountZero() {
		
		TweetListModel list = new TweetListModel();
		int count = 1;
		count = list.getCount();
		assertEquals("Count is correct for zero", 0, count);
	}
	
	public void testCountOne() {
		
		TweetListModel list = new TweetListModel();
		int count = 0;
		Tweet t = new Tweet("Hello");
		list.addTweet(t);
		count = list.getCount();
		assertEquals("Count is correct for one", 1, count);
	}
	
	public void testCountFour() {
		
		TweetListModel list = new TweetListModel();
		int count = 0;
		Tweet t1 = new Tweet("Hello1");
		Tweet t2 = new Tweet("Hello2");
		Tweet t3 = new Tweet("Hello3");
		Tweet t4 = new Tweet("Hello4");
		list.addTweet(t1);
		list.addTweet(t2);
		list.addTweet(t3);
		list.addTweet(t4);
		count = list.getCount();
		assertEquals("Count is correct for four", 4, count);
	}
	
	public void testTweetCheckPresent() {
		
		boolean present;
		
		TweetListModel list = new TweetListModel();
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		
		list.addTweet(t);
		
		present = list.hasTweet(t2);
		
		assertEquals("Tweet present", true, present);
	}
	
	public void testTweetCheckNotPresent() {
		
		boolean present;
		
		TweetListModel list = new TweetListModel();
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Not Hello");
		
		list.addTweet(t);
		
		present = list.hasTweet(t2);
		
		assertEquals("Tweet not present", false, present);
	}
	
	public void testTweetRemoval() {
		
		boolean present;
		
		TweetListModel list = new TweetListModel();
		Tweet t1 = new Tweet("Hello");
		Tweet t2 = new Tweet("Not Hello");
		
		list.addTweet(t1);
		list.addTweet(t2);
		
		present = list.hasTweet(t1);
		assertEquals("Tweet1 present", true, present);
		
		list.removeTweet(t1);
		
		present = list.hasTweet(t1);
		assertEquals("Tweet1 not present", false, present);
		
		present = list.hasTweet(t2);
		assertEquals("Tweet2 present", true, present);
	}
	
	public void testSortList() {

		
		TweetListModel list = new TweetListModel();
		Tweet t1 = new Tweet("Hello1");
		Tweet t2 = new Tweet("Hello2");
		Tweet t3 = new Tweet("Hello3");
		
		list.addTweet(t1);
		list.addTweet(t2);
		list.addTweet(t3);
		
		AbstractTweet[] newList = list.getTweets();
		
		assertEquals("Works1", t1.getTweetBody(), newList[0].getTweetBody());
		assertEquals("Works2", t2.getTweetBody(), newList[1].getTweetBody());
		assertEquals("Works3", t3.getTweetBody(), newList[2].getTweetBody());
		
	}
	
}









