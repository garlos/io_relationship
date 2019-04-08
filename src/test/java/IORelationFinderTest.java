import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;


public class IORelationFinderTest {

    @Test
    public void ioRelFinder() throws IOException {
        ArrayList<TestCase> testSuitesArr = new ArrayList<>();
//        ArrayList<TestCase> testSuites = new ArrayList<>();
        String filePath = "DataSet.csv";
//        testSuites = CsvOperation.readCsvData(filePath);

//        InOutIndexRecognizer.fieldsRecognizer();
        testSuitesArr = CsvOperation.readCsvData(filePath);
//        System.out.println(testSuitesArr.get(130000).getTestId());



//        IORelationFinder ioRelationFinder = new IORelationFinder(testSuitesArr);
//        ArrayList<Integer> testID = ioRelationFinder.redundantTestCaseSelector();
//        for (int i = 0; i < testID.size(); i++) {
//            System.out.format("No. %d - Test ID: %d\n", i, testID.get(i));
//        }
    }
}