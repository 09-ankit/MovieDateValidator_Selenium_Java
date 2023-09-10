package com.TestVagrant.ImdbPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestVagrant.CommonActions.CommonActions;


public class ImdbHomePage extends CommonActions{


	//***********WebElements of ImdbHomePage ***********
	
	@FindBy(name="q")
	WebElement searchBar;

	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	WebElement movieSelectlink;


	
	public ImdbHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	

	//navigate to URL
	public void getImdbUrl(String ImdbUrl)
	{
		getUrl(ImdbUrl);
	}
	

	//verify page is correct
	public boolean IsImdbPageDisplayed()
	{
		return verifyPage(searchBar, "IMDB Home Page");
		
	}


	//serach for movie
	public void searchMovieByName(String movieName)
	{
		searchMovie(searchBar, movieName);
		movieSelectlink.click();
	}




}
