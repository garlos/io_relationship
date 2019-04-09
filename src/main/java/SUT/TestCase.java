package SUT;

public class TestCase {

    private int testId;

    private int _inp_StaffType;
    private int _inp_WorkHour;
    private int _inp_Quality;
    private int _inp_Age;

    private int _out_Salary;
    private boolean _out_ExReward;


    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int get_inp_StaffType() {
        return _inp_StaffType;
    }

    public void set_inp_StaffType(int _inp_StaffType) {
        this._inp_StaffType = _inp_StaffType;
    }

    public int get_inp_WorkHour() {
        return _inp_WorkHour;
    }

    public void set_inp_WorkHour(int _inp_WorkHour) {
        this._inp_WorkHour = _inp_WorkHour;
    }

    public int get_inp_Quality() {
        return _inp_Quality;
    }

    public void set_inp_Quality(int _inp_Quality) {
        this._inp_Quality = _inp_Quality;
    }

    public int get_inp_Age() {
        return _inp_Age;
    }

    public void set_inp_Age(int _inp_Age) {
        this._inp_Age = _inp_Age;
    }

    public int get_out_Salary() {
        return _out_Salary;
    }

    public void set_out_Salary(int _out_Salary) {
        this._out_Salary = _out_Salary;
    }

    public boolean is_out_ExReward() {
        return _out_ExReward;
    }

    public void set_out_ExReward(boolean _out_ExReward) {
        this._out_ExReward = _out_ExReward;
    }
}
