package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import com.cucumber.commonServices.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Base {
    LoginPage loginPage;
    WebDriverWait wait;

    public SearchPage() {
        wait = new WebDriverWait(Base.getDriver(), java.time.Duration.ofSeconds(10));
        loginPage = new LoginPage();
    }

    private final By searchInput = By.id("search-input");
    private final By searchButton = By.xpath("//button[@id=\"search_btn\"]");
    private static final By product_cards = By.xpath("//div[contains(@class,'catalogueV2Repeater')]");
    private static final By products_links = By.tagName("a");
    private static final By no_result = By.xpath("//*[contains(text(),'No results') or contains(text(),'no product')]");

    public void enterSearchItem(String searchItem) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchItem);
    }

    public void clickSearchButton() {

        driver.findElement(searchButton).click();
    }

    public int getResultCount() {
        // WaitUtil waits for first card — then count all
        WaitUtil.visibility(product_cards);
        return driver.findElements(product_cards).size();
    }

    public List<String> getProductTitles() {
        // Wait for first card to appear
        WaitUtil.visibility(product_cards);

        List<WebElement> cards = driver.findElements(product_cards);
        List<String> titles = new ArrayList<>();

        for (WebElement card : cards) {
            try {
                String name = card.getText().split("\n")[0].trim().toLowerCase();
                if (!name.isEmpty()) {
                    titles.add(name);
                }
            } catch (Exception e) {
            }


        }
        System.out.println("Found " + titles.size() + " products: " + titles);
        return titles;

    }
    public boolean titlesContain(String keyword) {
        List<String> titles = getProductTitles();

        for (String title : titles) {
            if (title.contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean allTitlesContain(String keyword) {
        List<String> titles = getProductTitles();
        if (titles.isEmpty()) return false;

        for (String title : titles) {
            if (!title.contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean isNoResultsDisplayed() {
        try {
            WaitUtil.visibility(no_result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}