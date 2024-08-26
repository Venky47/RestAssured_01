package stepDef.excelStepDef;

import io.cucumber.java.en.Given;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import verification.TestVerification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelOperations {
    TestVerification testVerification=new TestVerification();
    @Given("Read data from the excel")
    public void readDataFromTheExcel() throws IOException {
        testVerification.getData("Login");
       testVerification.testSample();
//       testVerification.addBook();

    }
}
