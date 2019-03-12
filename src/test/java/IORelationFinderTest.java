import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class IORelationFinderTest {

    @Test
    public void ioRelFinder() throws IOException {
        ArrayList<TestSuite> content;
        String fileName = "DataSet.csv";
        CsvOperation csv = new CsvOperation();
        content = csv.readData(fileName);
        IORelationFinder ioRFinder = new IORelationFinder(content);
        ioRFinder.extractSpecifiedRecords();
    }
}