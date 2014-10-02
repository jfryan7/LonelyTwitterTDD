package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;


public class AbstractTwitterTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
		
		public AbstractTwitterTest() {
			super(LonelyTwitterActivity.class);
		}

		public void testFiveIsFive() {
			assertEquals("Five is Five", 5, 5);	
		}
		
		public void testAbstractTweet() {
			Tweet t = new Tweet("Hello");
			String actual = t.getTweetBody();
			
			Tweet t2 = new Tweet("Hello");
			
			assertEquals("Tweet body is the same","Hello", actual);
			//assertSame("Same tweets", t, t2);
			assertEquals("Same tweets", t, t2);
		}
}
