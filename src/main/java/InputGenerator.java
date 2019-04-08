import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030

public class InputGenerator {

    private ArrayList<TestCase> testSuitesArr = new ArrayList<>();

    public ArrayList<TestCase> setInputData() {
        Integer count = 1;
        //generate sequential inputs
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 51; j++) {
                for (int w = 1; w < 21; w++) {
                    for (int z = 1; z < 46; z++) {
                        TestCase testSuite = new TestCase();
                        testSuite.setTestId(count++);
                        testSuite.setStaffType(i);
                        testSuite.setWorkHour(j + 149);
                        testSuite.setQuality(w + 69);
                        testSuite.setAge(z + 19);
                        testSuitesArr.add(testSuite);
                    }
                }
            }
        }
        return testSuitesArr;
    }
}