package com.TestVagrant.ImdbPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePage;

public class ImdbHomePage extends BasePage{



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
		driver.get(ImdbUrl);
	}
	

	//verify page is correct
	public boolean verifyIsImdbPageDisplayed()
	{
		if(searchBar.isDisplayed())
		{
			System.out.println("Sucessfully navigated to IMDB page ");
			return true;
		}
		else
		{
			System.out.println("Navigate page is not as expected !! Please check the url");
			return false;
		}
	}


	//serach for movie
	public void searchMovieByName(String movieName)
	{
		searchBar.sendKeys(movieName);
		searchBar.sendKeys(Keys.ENTER);
		movieSelectlink.click();
	}




}
