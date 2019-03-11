import java.util.*;

public class IORelationFinder {

    private List<List<String>> content = new ArrayList<>();
    private List<List<String>> copyContent = new ArrayList<>();

    private ArrayList<String> tmpContent = new ArrayList<>();


    public void ioRelFinder(List<List<String>> content) {
        this.content = content;
        this.copyContent = content;

        extractSpecifiedRecords(this.content);
//        relout1_in1();
    }

    public void extractSpecifiedRecords(List<List<String>> content) {

        int count = 0;
        for (int j = 1; j < content.size(); j++) {
            String str = content.get(j).get(2).trim() +
                    content.get(j).get(3).trim() +
                    content.get(j).get(4).trim();
            for (int i = j; i < copyContent.size(); i++) {
                String tempStr = copyContent.get(i).get(2).trim() +
                        copyContent.get(i).get(3).trim() +
                        copyContent.get(i).get(4).trim();
                String x1 = copyContent.get(i).get(1);
                String out1 = copyContent.get(i).get(5);
                if (str.equals(tempStr)) {
                    tmpContent.add(copyContent.get(i).get(0));
                    copyContent.remove(i - 1);
                    System.out.format("%s - ", content.get(i).get(2).trim());
                    System.out.format("%s - ", content.get(i).get(3).trim());
                    System.out.format("%s\n", content.get(i).get(4).trim());
                    count++;
                }
            }
            System.out.println("copyContent Length: " + copyContent.size());
            System.out.println("Content Length: " + content.size());
            System.out.println("similar counts: " + (count / 3));
            System.out.println("------------------------");
        }
    }


//    public void relout1_in1() {
//        int count=0;
//
//        for (int j = 1; j < content.size() - 1; j++) {
//            System.out.format("period: %d\n", j);
//            for (int i = 1; i < content.size() - 1; i++) {
//                if ((!content.get(j).get(1).equals(content.get(j + 1).get(1))) &&
//                        (content.get(i).get(5).equals(content.get(i + 1).get(5)))) {
//                    count++;
//                    System.out.format("this row: %s - %s - %s\n", content.get(i).get(0),
//                            content.get(i).get(1),
//                            content.get(i).get(5));
//                }
//            }
//        }
//        System.out.format("count: %d",count );
//    }
}