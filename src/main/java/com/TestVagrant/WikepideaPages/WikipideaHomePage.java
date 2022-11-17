package com.TestVagrant.WikepideaPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePage;

public class WikipideaHomePage extends BasePage {

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
		driver.get(wikiURL);
	}

	//verify Page
	public boolean IsWikipediaPageDispayed()
	{
		if(searchBar.isDisplayed())
		{
			System.out.println("Sucessfully navigated to wikipedia page ");
			return true;		

		}
		else
		{
			System.out.println("Navigate page is not as expected !! Please check the url");
			return false;
		}
	}



	//Pass movie Name and press  enter   //Pushpa: The Rise
	public void searchMovieByName(String movieName)
	{
		searchBar.sendKeys(movieName);
		searchBar.sendKeys(Keys.ENTER);
		movieSelectLink.click();

	}



}
