import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030

public class InputGenerator {

    private ArrayList<TestSuite> testSuitesArr = new ArrayList<>();

    public ArrayList<TestSuite> setInputData() {
        Integer count = 1;
        //generate Sequential inputs
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 51; j++) {
                for (int w = 1; w < 21; w++) {
                    for (int z = 1; z < 46; z++) {
                        TestSuite testSuite = new TestSuite();
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