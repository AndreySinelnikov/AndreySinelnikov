package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;


    protected AbstractStep(WebDriver webDriver, Properties props) {
        homePage = new HomePage(webDriver, props.getProperty("homepage_url"));
        differentElementsPage = new DifferentElementsPage(webDriver, props.getProperty("elements_page_url"));
    }

}
