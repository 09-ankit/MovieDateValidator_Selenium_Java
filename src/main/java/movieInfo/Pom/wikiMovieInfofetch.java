package movieInfo.Pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.BasePage;


public class wikiMovieInfofetch extends BasePage {

	public String wikiCountryName;
	public String wikiReleaseDate;


	@FindBy(xpath="//input[@placeholder='Search Wikipedia']")
	WebElement searchBar;

	@FindBy(xpath="//table[@class='infobox vevent']/tbody/tr/th[text()='Country']/following-sibling::td")
	WebElement countryInfo;

	@FindBy(xpath="//li[contains(text(), 'December')]")
	WebElement releaseDate;

	@FindBy(xpath="//a[@title='Pushpa: The Rise']")
	WebElement movieLink;

	public wikiMovieInfofetch()
	{
		PageFactory.initElements(driver, this);
	}

	//get Url
	public void navigateToWikiUrl(String wikiURL)
	{
		driver.get(wikiURL);
	}

	//verify Page
	public boolean verifyWikipediaPage()
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
	public void searchWikiMoviebyName(String movieName)
	{
		searchBar.sendKeys(movieName);
		searchBar.sendKeys(Keys.ENTER);
		if(!countryInfo.isDisplayed())
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			movieLink.click();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//Get Movie Details from the Wikipedia page 
	public void fetchMovieInfo()
	{		
		wikiCountryName=countryInfo.getText();
		wikiReleaseDate=releaseDate.getText();
		System.out.println("Found Country Name in Wikipedia page is :- "+ wikiCountryName);
		System.out.println("Found Release Date in Wikipedia page is :- "+ wikiReleaseDate);
	}











}




