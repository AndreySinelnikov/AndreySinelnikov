package com.epam.tc.hw4.experimental;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public abstract class BaseStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;


    protected BaseStep(WebDriver webDriver, Properties props) {
        homePage = new HomePage(webDriver, props.getProperty("homepage_url"));
        differentElementsPage = new DifferentElementsPage(webDriver, props.getProperty("elements_page_url"));
    }

}
