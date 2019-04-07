import org.junit.Test;
import java.io.IOException;


public class IORelationFinderTest {

    @Test
    public void ioRelFinder() throws IOException {
        String fileName = "DataSet.csv";
        String[] fields = CsvOperation.readCsvFields(fileName).split(",");
        System.out.println(InOutIndexRecognizer.inOutRecognizer(fields).get(1));
    }
}