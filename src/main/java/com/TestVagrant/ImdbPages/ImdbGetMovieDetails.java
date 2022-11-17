package com.TestVagrant.ImdbPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePage;

public class ImdbGetMovieDetails extends BasePage{

	public String imdbCountryName;
	public String imdbReleaseDate;
	
	
	//@FindBy(xpath="//span[text()='Details']")
	//WebElement Details;
	
	@FindBy(xpath="//a[contains(@href,'tt_dt_rdat') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement releaseDate;
	
	@FindBy(xpath="//a[contains(@href,'country') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement countryInfo;
	
	
	public ImdbGetMovieDetails()
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public boolean isMovieDetailsDisplayed()
	{
		if(countryInfo.isDisplayed() &&  releaseDate.isDisplayed())		
		{
			return true;
		}
		else
		{
			return false;
		}		
		
	}
	
	//Fetch movie details
	public void fetchMovieDetails()
	{		
		
			//movieInfolink.click(); //click on 1st Link
			imdbCountryName=countryInfo.getText();
			imdbReleaseDate =releaseDate.getText();	
			System.out.println("Found Country Name in IMDB page is :- "+ imdbCountryName);
			System.out.println("Found Release Date in IMDB page is :- "+ imdbReleaseDate);			
		
	}

	
}
