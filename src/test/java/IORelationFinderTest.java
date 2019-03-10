import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IORelationFinderTest {
    private List<List<String>> content = new ArrayList<>();

    @Test
    public void ioRelFinder() throws IOException {

        IORelationFinder ioRFinder = new IORelationFinder();
        CsvOperation csv = new CsvOperation();
        content = csv.readData();
        ioRFinder.ioRelFinder(content);
    }
}