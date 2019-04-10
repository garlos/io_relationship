import SUT.TestCase;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class tempRunner {

    @Test
    public void tempRun() throws IOException, IllegalAccessException {

        TestCase testCase = new TestCase();
//
        ArrayList<TestCase> testSuitesArr = DS02_InputGenerator.generateInputs();
//
        ArrayList<TestCase> dataSet = DS03_DataSetGenerator.generateDataSet(testSuitesArr);

        List<ArrayList<Integer>> inOutFieldsIndex = DS01_InOutRecognizer.recognizeInOutFields(testCase);
//        System.out.println(inOutFieldsIndex.get(0));
//        System.out.println(inOutFieldsIndex.get(1));


        List<ArrayList<Integer>> norelfields = RF01_IORelationFinder.check_IO_Relations(testCase, inOutFieldsIndex, dataSet);
        System.out.println(norelfields);
    }
}
