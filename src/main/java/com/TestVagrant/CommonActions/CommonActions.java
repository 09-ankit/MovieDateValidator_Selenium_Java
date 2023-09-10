package com.TestVagrant.CommonActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.TestVagrant.Utilities.BasePage;

public class CommonActions extends BasePage {

	//Get Url
	public static void getUrl(String Url)
	{
		driver.get(Url);
	}


	//Use to verify WebPage is correctly found
	public boolean verifyPage(WebElement ElementName , String PageName)
	{		
		if(ElementName.isDisplayed())
		{
			System.out.println("Sucessfully navigated to "+ PageName);
			return true;
		}
		else
		{
			System.out.println(PageName +" Not Found !! Please check the url");
			return false;
		}			
	}

	//Search movie
	public void searchMovie(WebElement SearchBar ,String MovieName)
	{
		SearchBar.sendKeys(MovieName);
		SearchBar.sendKeys(Keys.ENTER);
	}


	//get Movie Details by Name
	//Example pass any movie details like name, country , origin , releaseDate
	public String getMovieInfo(WebElement Name , String WebPageName , String ElementName)
	{
		String name = Name.getText();
		System.out.println("Found "+ ElementName+ " name from " + WebPageName+ " is :- "+ name);
		return Name.getText();
	}


	//Verify MovieDetails present on screen by WebElement Names
	public boolean verifyIsMovieDetailsDisplayed(WebElement Element1 , WebElement Element2)
	{
		
		if(Element1.isDisplayed() ||  Element2.isDisplayed())		
		{
			return true;
		}
		else
		{
			return false;
		}	
		
	}


}
