package com.TestVagrant.WikepideaPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.BasePage;


public class WikipediaGetMovieDetails extends BasePage {

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
		if(countryName.isDisplayed() &&  releaseDate.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}		
	}


	//Get Movie Details from the Wikipedia page 
	public void fetchMovieDetails()
	{		
				
			getCountryName=countryName.getText();
			getReleaseDate=releaseDate.getText();
			System.out.println("Found Country Name in Wikipedia page is :- "+ getCountryName);
			System.out.println("Found Release Date in Wikipedia page is :- "+ getReleaseDate);
	
	}



}




