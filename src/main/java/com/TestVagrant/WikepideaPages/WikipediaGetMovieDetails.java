package com.TestVagrant.WikepideaPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestVagrant.CommonActions.CommonActions;



public class WikipediaGetMovieDetails extends CommonActions {

	public String getCountryName;
	public String getReleaseDate;


	@FindBy(xpath="//table[@class='infobox vevent']/tbody/tr/th[text()='Country']/following-sibling::td")
	WebElement countryName;

	@FindBy(xpath="//li[contains(text(), 'December')]")
	WebElement releaseDate;

	public WikipediaGetMovieDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean IsMovieDetailsDisplayed()
	{
		//verify is this WebElemets present on the page
		return	verifyIsMovieDetailsDisplayed(countryName, releaseDate);			
	}


	//Get Movie Details from the Wikipedia page 
	public void fetchMovieDetails()
	{			
			getCountryName= getMovieInfo(countryName, "Wikipedia page" ,"Country");
			getReleaseDate= getMovieInfo(releaseDate, "Wikipedia page", "Release Date");
	
	}



}




