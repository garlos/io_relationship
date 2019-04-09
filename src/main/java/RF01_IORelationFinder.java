import SUT.TestCase;

import java.util.*;

public class RF01_IORelationFinder {
    private ArrayList<TestCase> testSuiteArr;


    public RF01_IORelationFinder(ArrayList<TestCase> content) {

        this.testSuiteArr = content;
    }

    public ArrayList<Integer> relationChecker() {

        Integer inputCompare;
        Integer outputCompare;
        ArrayList<Integer> selectedTestCases = new ArrayList<>();

        inputCompare = testSuiteArr.get(0).get_inp_StaffType();
        outputCompare = testSuiteArr.get(0).get_out_Salary();

        selectedTestCases.add(testSuiteArr.get(0).getTestId());

        for (int i = 0; i < testSuiteArr.size(); i++) {
            if (!inputCompare.equals(testSuiteArr.get(i).get_inp_StaffType())) {

                if (!outputCompare.equals(testSuiteArr.get(i).get_out_Salary())) {

                    selectedTestCases.add(testSuiteArr.get(i).getTestId());
                    inputCompare = testSuiteArr.get(i).get_inp_StaffType();
                    outputCompare = testSuiteArr.get(i).get_out_Salary();
                }
            }
        }
        return selectedTestCases;
    }



}

