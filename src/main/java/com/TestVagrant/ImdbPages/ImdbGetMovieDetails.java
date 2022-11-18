package com.TestVagrant.ImdbPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestVagrant.CommonActions.CommonActions;


public class ImdbGetMovieDetails extends CommonActions{

	public String imdbCountryName;
	public String imdbReleaseDate;


	@FindBy(xpath="//a[contains(@href,'tt_dt_rdat') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement releaseDate;

	@FindBy(xpath="//a[contains(@href,'country') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement country;


	public ImdbGetMovieDetails()
	{
		PageFactory.initElements(driver, this);
	}


	//verify is movie Details Displayed
	public boolean isMovieDetailsDisplayed()
	{
		//verify is this WebElemets present on the page
		return	verifyIsMovieDetailsDisplayed(country, releaseDate);		
	}

	//Fetch movie details
	public void fetchMovieDetails()
	{		
		imdbCountryName=  getMovieInfo(country, "IMDB Page" , "Country");
		imdbReleaseDate = getMovieInfo(releaseDate, "IMDB Page" , "Release Date");			

	}


}
