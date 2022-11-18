package com.TestVagrant.MovieInfoTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TestVagrant.ImdbPages.ImdbGetMovieDetails;
import com.TestVagrant.ImdbPages.ImdbHomePage;
import com.TestVagrant.Utilities.BasePage;
import com.TestVagrant.WikepideaPages.WikipediaGetMovieDetails;
import com.TestVagrant.WikepideaPages.WikipideaHomePage;


/*******************************************************************************************************************************
 * Test Case                : Verify Movie Details from IMDB and Wikepidea Page
 * Test Case Creation Date  : 12-Sept-2022
 * Author					: Ankit Bhattad
 * History of Modification  : 17-Sept-2022
 * Description				: Verify and Validate Movie Origin and Release Date in Imdb and Wikepedia are same in Both Sites
 ********************************************************************************************************************************/




public class MovieDetailsCompareTest extends BasePage {

	//Class objects
	WikipideaHomePage wikiHomePage;
	WikipediaGetMovieDetails wikiMovieDetails;
	ImdbHomePage imdbHomePage;
	ImdbGetMovieDetails imdbMovieDetails;

	String wikiMovieOrigin;
	String imdbMovieOrigin;
	String wikiReleaseDate;
	String imdbReleaseDate;


	@BeforeMethod
	public void setup() {
		System.out.println("Test Case Started..");
		initialization();
		wikiHomePage =new WikipideaHomePage();
		wikiMovieDetails = new WikipediaGetMovieDetails();
		imdbHomePage = new ImdbHomePage(); 
		imdbMovieDetails = new ImdbGetMovieDetails();

	}


	@Parameters({"wikipediaURl","MovieName","ImdbUrl","Month","Day","Year"})
	@Test(priority=1 , description="Get Movie details from Wikipedia Page")	
	public void wikiGetMovieDetailsTest(String wikipediaURl, String MovieName, String ImdbUrl,String month , String day , String year)  
	{
		//Get Details from Wikipedia Site
		wikiHomePage.getWikipediaUrl(wikipediaURl);                                                                  
		boolean verifyIsWikipediaPageDisplayed=wikiHomePage.IsWikipediaPageDisplayed();		
		Assert.assertEquals(verifyIsWikipediaPageDisplayed, true);                                                 	
		BasePage.getScreenshot("verifyPage");                                                         

		//Searching Movie
		wikiHomePage.searchMovieByName(MovieName);                                                                		
		boolean verifyIsMovieDisplayed=wikiMovieDetails.IsMovieDetailsDisplayed();
		Assert.assertTrue(verifyIsMovieDisplayed, "Movie Details are not Displayed from Wikipedia Page..");
		
		//Get Movie Details
		wikiMovieDetails.fetchMovieDetails();	                                                                 

		wikiMovieOrigin= wikiMovieDetails.getCountryName;
		wikiReleaseDate= wikiMovieDetails.getReleaseDate;			
		BasePage.getScreenshot("WikipediaMovieDetails");                                                             

		//Get Details from Wikipedia Site
		imdbHomePage.getImdbUrl(ImdbUrl);					 		                    
		boolean verifyIsImdbPageDisplayed=imdbHomePage.IsImdbPageDisplayed();
		Assert.assertEquals(verifyIsImdbPageDisplayed, true);         			       
		BasePage.getScreenshot("verifyImdbPage"); 			                  

		//Searching Movie
		imdbHomePage.searchMovieByName(MovieName);			 			              
		boolean verifyMovieDetailsDisplayed=imdbMovieDetails.isMovieDetailsDisplayed();
		Assert.assertTrue(verifyMovieDetailsDisplayed, "Movie Details are not Displayed from Imdb Page");

		//Get Details from Imdb Site
		imdbMovieDetails.fetchMovieDetails();	                                        

		imdbMovieOrigin= imdbMovieDetails.imdbCountryName;						                
		imdbReleaseDate=imdbMovieDetails.imdbReleaseDate;
		BasePage.getScreenshot("ImdbMovieDetails");                                      

		System.out.println("Verifying Details .....");
		//Verify Movie County Name
		boolean verifyMovieOrigin =wikiMovieOrigin.equalsIgnoreCase(imdbMovieOrigin);
		Assert.assertEquals(verifyMovieOrigin, true ,"Movie Country Name Found from IMDB and Wikipedia Page is not as Expected");			
		//Verify Date
		Assert.assertEquals(verifyDate(month,day,year), true,"Movie Release Date Found from IMDB and Wikipedia Page is not as Expected");
		System.out.println("Details Verified ...");
	}

	@AfterMethod
	public void tearDown()
	{
		System.out.println("Test Case Completed..");
		closeBroswer();                                                                         // use to close browser
	}

	
	
	

	//Verify Date from Both the Sites
	public boolean verifyDate(String month , String Day , String year)
	{
		boolean flag=false;
		//Verify Movie Release Date
		if(wikiReleaseDate.contains(month) && wikiReleaseDate.contains(Day) && wikiReleaseDate.contains(year))
		{			
			if(imdbReleaseDate.contains(month) && imdbReleaseDate.contains(Day) && imdbReleaseDate.contains(year))
			{
				System.out.println("Movie Date  Found from IMDB and Wikipedia Page is as Expected");
				flag=true;
			}			
		}
		else
		{
			System.out.println("Movie Release Date Found from IMDB and Wikipedia Page is not as Expected");
			System.out.println("Imdb Movie Release Date Found is " + imdbReleaseDate + " and Wikipidea Movie Release Date Found is " + wikiReleaseDate);
			flag=false;
		}
		return flag;
	}



}


