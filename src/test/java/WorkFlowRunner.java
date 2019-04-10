import SUT.TestCase;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;


public class WorkFlowRunner {

    @Test
    public void workflow() throws IOException {

//Phase 1:
        System.out.println();
        System.out.println("Phase 1 is started... ");
        System.out.println();
        System.out.println("        # the SUT's TestCase.java (POJO) inputs and outputs are recognizing");
        System.out.println();
        System.out.println("Phase 1 completed.");
        System.out.println("___________________________________________");

//Phase 2:
        System.out.println();
        System.out.println("Phase 2 is started... ");
        System.out.println();
        System.out.println("        # combining input data are generating");
        System.out.println("        # a set of test suites are generated");
        System.out.println();
        ArrayList<TestCase> dSet = DS02_InputGenerator.generateInputs();
        System.out.println("Phase 2 completed.");
        System.out.println("___________________________________________");

//Phase 3:
        System.out.println("Phase 3 is started...");
        System.out.println();
        System.out.println("        # test suites are injecting to SUT");
        System.out.println("        # DataSet is generating");
        ArrayList<TestCase> dataSet = DS03_DataSetGenerator.generateDataSet(dSet);
        System.out.println();
        System.out.println("Phase 3 completed.");
        System.out.println("___________________________________________");

//Phase 4:



    }
}