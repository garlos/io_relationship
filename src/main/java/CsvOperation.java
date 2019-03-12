import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvOperation {

    public void saveData(ArrayList<TestSuite> dSet, String fileName, String csvFields) throws IOException {

        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(csvFields);
        bw.newLine();
        for (int i = 0; i < dSet.size(); i++) {
            bw.write(dSet.get(i).getTestId().toString() + "," +
                    dSet.get(i).getStaffType().toString() + "," +
                    dSet.get(i).getWorkHour().toString() + "," +
                    dSet.get(i).getQuality().toString() + "," +
                    dSet.get(i).getAge().toString() + "," +
                    dSet.get(i).getSalary().toString() + "," +
                    dSet.get(i).getExReward().toString() + ","
            );
            bw.newLine();
        }
        bw.close();
        fw.close();
    }


    public ArrayList<TestSuite> readData(String fileName) throws IOException {
        String line;
        ArrayList<TestSuite> testSuitesArr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                TestSuite testSuite = new TestSuite();

                String[] values = line.split(",");
                testSuite.setTestId(Integer.parseInt(values[0]));
                testSuite.setStaffType(Integer.parseInt(values[1]));
                testSuite.setWorkHour(Integer.parseInt(values[2]));
                testSuite.setQuality(Integer.parseInt(values[3]));
                testSuite.setAge(Integer.parseInt(values[4]));
                testSuite.setSalary(Integer.parseInt(values[5]));
                testSuite.setExReward(Boolean.valueOf(values[6]));
                testSuitesArr.add(testSuite);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return testSuitesArr;
    }
}