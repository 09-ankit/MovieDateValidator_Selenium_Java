package com.TestVagrant.WikepideaPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestVagrant.CommonActions.CommonActions;
import com.TestVagrant.Utilities.BasePage;

public class WikipideaHomePage extends CommonActions {

	@FindBy(xpath="//input[@placeholder='Search Wikipedia']")
	WebElement searchBar;

	@FindBy(xpath="//a[@title='Pushpa: The Rise']")
	WebElement movieSelectLink;


	public WikipideaHomePage()
	{
		PageFactory.initElements(driver, this);
	}

	//get Url
	public void getWikipediaUrl(String wikiURL)
	{
		getUrl(wikiURL);
	}

	//verify Page
	public boolean IsWikipediaPageDisplayed()
	{		
		return verifyPage(searchBar, " Wikipedia Home Page");
		
	}

	//Pass movie Name 
	public void searchMovieByName(String movieName)
	{
		searchMovie(searchBar, movieName);
		movieSelectLink.click();

	}



}
