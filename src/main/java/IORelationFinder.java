import java.util.*;

public class IORelationFinder {
    private ArrayList<TestSuite> testSuiteArr;
    private ArrayList<TestSuite> copyContent;


    public IORelationFinder(ArrayList<TestSuite> content) {

        this.testSuiteArr = content;
        this.copyContent = content;
    }

    public void extractSpecifiedRecords() {

        Integer count = 0;
        for (int j = 0; j < testSuiteArr.size(); j++) {
            for (int i = j; i < testSuiteArr.size(); i++) {
                if ((testSuiteArr.get(i).getWorkHour().equals(testSuiteArr.get(i + 1).getWorkHour())) &&
                        (testSuiteArr.get(i).getQuality().equals(testSuiteArr.get(i + 1).getQuality())) &&
                        (testSuiteArr.get(i)).getAge().equals(testSuiteArr.get(i + 1).getAge())) {
                    System.out.format("No. %d \\ %d - %d - %d ",
                            testSuiteArr.get(i).getTestId(),
                            testSuiteArr.get(i).getWorkHour(),
                            testSuiteArr.get(i).getQuality(),
                            testSuiteArr.get(i).getAge());
                }
                count++;
            }
        }
    }
}