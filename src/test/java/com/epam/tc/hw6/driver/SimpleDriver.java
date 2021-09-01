package com.epam.tc.hw6.driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleDriver {

    public static WebDriver createRemoteChromeDriver() throws MalformedURLException {
        ChromeOptions ops = new ChromeOptions();
        return new RemoteWebDriver(new URL("http://192.168.1.109:4444/wd/hub"), ops);
    }
}
