import java.util.*;

public class IORelationFinder {
    private ArrayList<TestCase> testSuiteArr;


    public IORelationFinder(ArrayList<TestCase> content) {

        this.testSuiteArr = content;
    }

    public ArrayList<Integer> relationChecker() {

        Integer inputCompare;
        Integer outputCompare;
        ArrayList<Integer> selectedTestCases = new ArrayList<>();

        inputCompare = testSuiteArr.get(0).getStaffType();
        outputCompare = testSuiteArr.get(0).getSalary();

        selectedTestCases.add(testSuiteArr.get(0).getTestId());

        for (int i = 0; i < testSuiteArr.size(); i++) {
            if (!inputCompare.equals(testSuiteArr.get(i).getStaffType())) {
                if (!outputCompare.equals(testSuiteArr.get(i).getSalary())) {
                    selectedTestCases.add(testSuiteArr.get(i).getTestId());
                    inputCompare = testSuiteArr.get(i).getStaffType();
                    outputCompare = testSuiteArr.get(i).getSalary();
                }
            }
        }
        return selectedTestCases;
    }

    public ArrayList<Integer> redundantTestCaseSelector() {
        Integer input1;
        Integer input2;
        ArrayList<Integer> selectedTestCases = new ArrayList<>();

        input1 = testSuiteArr.get(0).getStaffType();
        input2 = testSuiteArr.get(0).getWorkHour();

        selectedTestCases.add(testSuiteArr.get(0).getTestId());

        for (int i = 0; i < testSuiteArr.size(); i++) {
            if ((input1.equals(testSuiteArr.get(i).getStaffType()) &&
                    (input2.equals(testSuiteArr.get(i).getWorkHour()))
            )) {
                selectedTestCases.add(testSuiteArr.get(i).getTestId());
            }
            else{
                input1 = testSuiteArr.get(i).getStaffType();
                input2 = testSuiteArr.get(i).getWorkHour();
            }
        }
        return selectedTestCases;
    }

}

