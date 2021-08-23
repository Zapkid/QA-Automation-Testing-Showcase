package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("----------------- Starting Execution ---------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("----------------- Ending Execution ---------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO implement this...
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("----------- Skipping Test:" + test.getName() + " -------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("----------- Starting Test:" + test.getName() + " -------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Passed -------------");

        if(!platform.equalsIgnoreCase("api")) {
            try { // Stop Recording
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if(file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to Delete File");
        }
    }


    public void onTestFailure(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Failed -------------");

        if(!platform.equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
//                System.out.println("Video recording saved successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot("Failed", "png");
        }
    }

}
