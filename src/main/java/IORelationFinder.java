import java.util.*;

public class IORelationFinder {
    private ArrayList<TestSuite> testSuiteArr;
    private ArrayList<TestSuite> copyContent;


    public IORelationFinder(ArrayList<TestSuite> content) {

        this.testSuiteArr = content;
        this.copyContent = content;
    }

    public void extractSpecifiedRecords() {
        ArrayList<ArrayList<TestSuite>> testsuitsArrArr = new ArrayList<>();
        Integer count = 0;
        Integer cnt = 0;
        for (int j = 0; j < testSuiteArr.size(); j++) {
            for (int i = 0; i < testSuiteArr.size(); i++) {
                if ((testSuiteArr.get(i).getWorkHour().equals(testSuiteArr.get(j).getWorkHour())) &&
                        (testSuiteArr.get(i).getQuality().equals(testSuiteArr.get(j).getQuality())) &&
                        (testSuiteArr.get(i)).getAge().equals(testSuiteArr.get(j).getAge())) {
                    testsuitsArrArr.get(cnt).add(testSuiteArr.get(i));

//                    System.out.format("No.%d \\ %d - %d - %d \n",
//                            testSuiteArr.get(i).getTestId(),
//                            testSuiteArr.get(i).getWorkHour(),
//                            testSuiteArr.get(i).getQuality(),
//                            testSuiteArr.get(i).getAge());
                }
                count++;
            }
            cnt++;
            for (ArrayList b : testsuitsArrArr)
                for (Object a : b) {
                    System.out.println(a.toString());
                }
            System.out.println("-------------------------");
        }
    }
}