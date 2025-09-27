package Com.Ejada.Core.Helpers;

import org.openqa.selenium.*;

public class ActionHelper {

    int waitTime = 50;

    public boolean waitForExistence(WebElement element, int nTimes, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= nTimes) {
            try {
                //don't sleep the first try
                if (count > 1) {
                    Thread.sleep(1000);
                }
                if (element.isDisplayed()) {
                    highlightElement(element, driver);
                    isExist = true;
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }

    public boolean waitForExistence(WebElement element, String elementName, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= waitTime) {
            try {
                //don't sleep the first try
                if (count > 1) {
                    Thread.sleep(1000);
                }
                if (element.isDisplayed()) {
                    highlightElement(element, driver);
                    isExist = true;
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }


    public void highlightElement(WebElement element, WebDriver driver) {
        try {
            if (element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
        }
    }

    public void clickElement(WebElement element) {
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
                element.click();
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (ElementNotInteractableException e) {
                continue;
            } catch (InterruptedException e) {
            }
        }
    }

    public void setText(WebElement element, Keys keys) {
        for (int i = 0; i < 30; i++) {
            try {
                //element.clear();
                element.sendKeys(keys);
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (InvalidElementStateException e) {
                continue;
            }
        }
    }

    public void setText(WebElement element, String value) {
        for (int i = 0; i < 40; i++) {
            try {
                element.clear();
                element.sendKeys(value);
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (InvalidElementStateException e) {
                continue;
            }
        }
    }



    public void setText(WebElement element, String value, String elementName, WebDriver driver) {
        waitForExistence(element, elementName, driver);
        setText(element, value);
    }


    public String getStringFromElement(WebElement element, String startingString) {
        String value = element.getText();
        value = value.substring(value.indexOf(startingString) + 1);
        System.out.println("New Value ----------------->" + value);
        return value.trim();
    }

    public void clickElement(WebElement element, String elementName, WebDriver driver) {
        waitForExistence(element, elementName, driver);
        element.click();
    }




}
