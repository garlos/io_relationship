import java.util.*;

public class IORelationFinder {
    private ArrayList<TestSuite> testSuiteArr;


    public IORelationFinder(ArrayList<TestSuite> content) {

        this.testSuiteArr = content;
    }

    public void extractSpecifiedRecords() {

            for (int i = 0; i < testSuiteArr.size(); i++) {
                System.out.println(testSuiteArr.get(i).getTestId());
            }
    }
}
