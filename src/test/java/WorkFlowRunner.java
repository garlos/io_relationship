import SUT.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class WorkFlowRunner {

    @Test
    public void workflow() throws IOException {

//Phase 1:
        ArrayList<TestCase> dSet = InputGenerator.setInputData();

//Phase 2:
        DataSetGenerator.generate(dSet);

//Phase 3:

    }
}