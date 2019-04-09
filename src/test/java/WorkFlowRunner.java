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
        System.out.println("        # input data are generating");
        System.out.println();
        ArrayList<TestCase> dSet = DS02_InputGenerator.setInputData();
        System.out.println("Phase 1 completed.");
        System.out.println("___________________________________________");

//Phase 2:
        System.out.println("Phase 2 is started...");
        System.out.println();
        System.out.println("        # DataSet is generating");
        DS03_DataSetGenerator.generate(dSet);
        System.out.println();
        System.out.println("Phase 2 completed.");
        System.out.println("___________________________________________");

//Phase 3:


    }
}