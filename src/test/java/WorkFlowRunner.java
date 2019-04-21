import SUT.TestCase;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class WorkFlowRunner {

    @Test
    public void workflow() throws IOException, IllegalAccessException {

        TestCase testCase = new TestCase();


//Phase 1:
        System.out.format("\n");
        System.out.format("Phase 1 is started... \n\n");
        List<ArrayList<Integer>> inOutFieldsIndex = DS01_InOutRecognizer.recognizeInOutFields(testCase);
        System.out.format("completed. \n");
        System.out.format("___________________________________________ \n");

//Phase 2:
        System.out.format("Phase 2 is started... \n\n");
        ArrayList<TestCase> dSet = DS02_InputGenerator.generateInputs();
        System.out.format("completed. \n");
        System.out.format("___________________________________________ \n");

//Phase 3:
        System.out.format("Phase 3 is started... \n\n");
        ArrayList<TestCase> dataSet = DS03_DataSetGenerator.generateDataSet(dSet);
        System.out.format("completed. \n");
        System.out.format("___________________________________________ \n");

//Phase 4:
        System.out.format("Phase 4 is started... \n\n");
        Map<Integer, Integer> noRelfields = RF01_IORelationFinder.check_IO_Relations(testCase, inOutFieldsIndex, dataSet);
        System.out.format("completed. \n");
        System.out.format("___________________________________________ \n");

//Phase 5:
        System.out.format("Phase 5 is started... \n\n");
        RF02_DataSetReducer.redundantTestCaseReducer(dataSet, noRelfields, inOutFieldsIndex);
        System.out.format("completed. \n");
        System.out.format("___________________________________________ \n");

    }
}