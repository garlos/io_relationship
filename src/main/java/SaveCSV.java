//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.util.ArrayList;
//
//public class SaveCSV {
//
//    public static void save(ArrayList in, ArrayList out) {
//        ArrayList<String> list1 = new ArrayList<>();
//        list1.add("2212");
//        list1.add("gmail.com");
//
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.add("192.168.0.175");
//        list2.add("403");
//        list2.add("192.168.0.26");
//        list2.add("1809");
//
//        File file = new File("test.csv");
//        FileWriter fw = new FileWriter(file);
//        BufferedWriter bw = new BufferedWriter(fw);
//
//        bw.write("Domain,Total");
//        bw.newLine();
//        for (int i = 0; i < list1.size(); i++) {
//            bw.write(list1.get(i + 1) + "," + list1.get(i++));
//            bw.newLine();
//        }
//        bw.write("\nApplication,Total");
//        bw.newLine();
//        for (int i = 0; i < list2.size(); i++) {
//            bw.write(list2.get(i++) + "," + list2.get(i));
//            bw.newLine();
//        }
//        bw.close();
//        fw.close();
//    }
//}
