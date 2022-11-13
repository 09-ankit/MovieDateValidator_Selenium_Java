package movieInfoAutomationTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utilities.BasePage;
import movieInfo.Pom.imdbMovieInfoFetch;
import movieInfo.Pom.wikiMovieInfofetch;


/*******************************************************************************************************************************
 * Test Case                : Verify Movie Details from IMDB and Wikepidea Page
 * Test Case Creation Date  : 12-Sept-2022
 * Author					: Ankit Bhattad
 * Description				: Verify and Validate Movie Origin and Release Date in Imdb and Wikepedia are same in Both Sites
 ********************************************************************************************************************************/



//**********************************************Start Test Case *******************************************************************

public class MovieDetailsCompareTest extends BasePage {
	
	wikiMovieInfofetch wiki;
	imdbMovieInfoFetch imdb;
	String wikiMovieOrigin;
	String imdbMovieOrigin;
	String wikiReleaseDate;
	String imdbReleaseDate;
	
	
	@BeforeMethod
	public void setup() {
		System.out.println("Test Case Started..");
		initialization();
		wiki = new wikiMovieInfofetch();	
		imdb = new imdbMovieInfoFetch();
	}
	
	
	@Parameters({"wikipediaURl","MovieName"})
	@Test(priority=1 , description="Get Movie details from Wikipedia Page")	
	public void wikiGetMovieDetailsTest(String wikipediaURl, String MovieName)  throws IOException, InterruptedException
	{
		
		wiki.navigateToWikiUrl(wikipediaURl);                            //sending Wikipedia URL
		boolean verifyWikiPage=wiki.verifyWikipediaPage();
		Assert.assertEquals(verifyWikiPage, true);                       // Check if successfully navigated to correct Page
		BasePage.getScreenshot("verifyPageSnapshot");                    //Capture ScreenShot
		wiki.searchWikiMoviebyName(MovieName);                          //search movie
		wiki.isMovieDetailsPageDisplayed();
		wiki.fetchMovieInfo();					                       //Fetch Movie Info
		wikiMovieOrigin=wiki.wikiCountryName;
		wikiReleaseDate=wiki.wikiReleaseDate;	
		BasePage.getScreenshot("FetchInfoSnapshot");                    //Capture ScreenShot
	}

	
	@Parameters({"ImdbUrl","MovieName"})
	@Test(priority=2 , description="Get Movie details from IMDB Page")	
	public void imdbGetMovieDetailsTest(String ImdbUrl, String MovieName) throws IOException
	{
		
		imdb.navigateToImdbUrl(ImdbUrl);					 		// Sending IMDB Url
		boolean verifyImdbPage=imdb.verifyImdbPage();
		Assert.assertEquals(verifyImdbPage, true);         			// Check if successfully navigated to correct Page
		BasePage.getScreenshot("verifyImdbPageSnapshot"); 			//Capture ScreenShot
		imdb.searchImdbMoviebyName(MovieName);			 			 //search movie
		imdb.fetchMovieInfoByImdb();                     			//Fetch Movie Info
		imdbMovieOrigin= imdb.imdbCountryName;						//Set variable as public
		imdbReleaseDate=imdb.imdbReleaseDate;
		BasePage.getScreenshot("FetchInfoImdbSnapshot");             //Capture ScreenShot
			
	}


	@Test (priority=3, description="Verify Movie Details found from Wikipedia and Imdb page are Same ")
	public void verifyMovieDetailsTest()
	{
		System.out.println("Verifying Details .....");
		
		//Verify Movie County Name
		if(wikiMovieOrigin.equalsIgnoreCase(imdbMovieOrigin))
		{
			System.out.println("Movie Country Name Found from IMDB and Wikipedia Page is as Expected");
		}
		else
		{
			System.out.println("Movie Country Name Found from IMDB and Wikipedia Page is not as Expected");
			System.out.println("Imdb Movie Country Name Found is "+ imdb.imdbCountryName + "and Wikipidea Country Name Found is "+ wiki.wikiCountryName );
		}
		
		
		//Verify Movie Release Date
		if(wikiReleaseDate.contains("December") && wikiReleaseDate.contains("17") && wikiReleaseDate.contains("2021"))
		{
			System.out.println("Movie Date  Found from IMDB and Wikipedia Page is as Expected");
		}
		else
		{
			System.out.println("Movie Release Date Found from IMDB and Wikipedia Page is not as Expected");
			System.out.println("Imdb Movie Release Date Found is " + imdb.imdbReleaseDate + " and Wikipidea Movie Release Date Found is " + wiki.wikiReleaseDate);
		}

		System.out.println("Details Verified ...");

	}

	@AfterMethod
	public void tearDown()
	{
		System.out.println("Test Case Completed..");
		closeBroswer();        //from base class use to close browser
	}

	//**********************************************End Test Case *******************************************************************
	
}
