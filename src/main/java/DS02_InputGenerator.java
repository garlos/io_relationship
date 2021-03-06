import SUT.TestCase;

import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030

public class DS02_InputGenerator {

    private static ArrayList<TestCase> testSuitesArr = new ArrayList<>();

    public static ArrayList<TestCase> generateInputs() {

        System.out.format("        # input data are combining... \n");
        Integer count = 1;
        //generateDataSet sequential inputs
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 51; j++) {
                for (int w = 1; w < 21; w++) {
                    for (int z = 1; z < 46; z++) {
                        TestCase testSuite = new TestCase();
                        testSuite.setTestId(count++);
                        testSuite.set_inp_StaffType(i);
                        testSuite.set_inp_WorkHour(j + 149);
                        testSuite.set_inp_Quality(w + 69);
                        testSuite.set_inp_Age(z + 19);
                        testSuitesArr.add(testSuite);
                    }
                }
            }
        }

        System.out.println("        # a set of test suites generated. ");
        return testSuitesArr;
    }
}