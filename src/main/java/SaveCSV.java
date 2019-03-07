import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCSV {

    public void save(ArrayList inSet, String[][] outSet) throws IOException {

        File file = new File("test.csv");
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
        bw.write("No,StaffType,WorkHours,Ex-Works,Quality,Age,Salary,Ex-Reward");
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
}
