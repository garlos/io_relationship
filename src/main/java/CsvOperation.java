import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvOperation {

    public void saveData(ArrayList inSet, String[][] outSet) throws IOException {

        File file = new File("DataSet.csv");
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
        bw.write("No,StaffType,WorkHours,Quality,Age,Salary,Ex-Reward");
        bw.newLine();
        for (int i = 0; i < inSet.size(); i++) {
            bw.write(String.valueOf(i + 1) + "," +
                    inSet.get(i).toString()
                            .replaceAll("\\[", "")
                            .replaceAll("\\]", "") + "," +
                    outSet[i][0] + "," +
                    outSet[i][1]
            );
            bw.newLine();
        }
        bw.close();
        fw.close();
    }


    public List<List<String>> readData() throws IOException {
        String file = "DataSet.csv";
        String line;
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return records;
    }
}
