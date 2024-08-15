package org.example.presonalprogecthabr;


import org.example.presonalprogecthabr.tests.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Wait {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(Wait.class));
    private WebDriverWait wait;
    private final int secondsToWait;

    public static Wait myWait(int seconds) {
        return new Wait(seconds);
    }

    public Wait(int seconds) {
        this.secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public WebElement clickable(WebElement element) {
        LOG.info("Waiting " + secondsToWait + " second(-s) until the element becomes clickable " + element.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visible(WebElement element) {
        LOG.info("Waiting " + secondsToWait + " second(-s) until the element becomes visible " + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Alert alertIsPresented() {
        LOG.info("Waiting " + secondsToWait + " second(-s) until the alert appears");
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement locatorVisible(By element) {
        LOG.info("Waiting " + secondsToWait + " second(-s) until the locator appears");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

