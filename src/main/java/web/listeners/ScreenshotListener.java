package web.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import web.tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult){
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        takeScreenshot(driver, iTestResult);
    }
    private static void takeScreenshot(WebDriver driver, ITestResult iTestResult){
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        String screenshotName = iTestResult.getName()+"_"+date.toString()
                .replace(":","_").replace(" ","_");

        try {
            FileUtils.copyFile(tempFile, new File("./Screenshot/"+screenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}