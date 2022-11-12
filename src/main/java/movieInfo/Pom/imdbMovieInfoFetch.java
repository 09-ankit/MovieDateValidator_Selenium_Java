package movieInfo.Pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePage;

public class imdbMovieInfoFetch extends BasePage{

	public String imdbCountryName;
	public String imdbReleaseDate;
	
	@FindBy(name="q")
	WebElement searchBar;
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	WebElement movieInfolink;
	
	@FindBy(xpath="//span[text()='Details']")
	WebElement Details;
	
	@FindBy(xpath="//a[contains(@href,'tt_dt_rdat') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement releaseDate;
	
	@FindBy(xpath="//a[contains(@href,'country') and @class=\"ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link\"]")
	WebElement countryInfo;
	
	
	public imdbMovieInfoFetch()
	{
		PageFactory.initElements(driver, this);
	}
	
	//navigate to URL
	public void navigateToImdbUrl(String ImdbUrl)
	{
		driver.get(ImdbUrl);
	}

	//verify page is correct
	public boolean verifyImdbPage()
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
	public void searchImdbMoviebyName(String movieName)
	{
		searchBar.sendKeys(movieName);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	//Fetch movie details
	public void fetchMovieInfoByImdb()
	{
		
		movieInfolink.click(); //click on 1st Link
		imdbCountryName=countryInfo.getText();
		imdbReleaseDate =releaseDate.getText();		
		System.out.println("Found Country Name in IMDB page is :- "+ imdbCountryName);
		System.out.println("Found Release Date in IMDB page is :- "+ imdbReleaseDate);
		
	}
	
	
	
}
