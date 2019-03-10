

import java.util.*;

public class IORelationFinder {
    private List<List<String>> content;
    private ArrayList<String> tmpContent = new ArrayList<>(content.size());


    public void ioRelFinder(List<List<String>> content) {
        this.content = content;

        extractSpecifiedRecords(content);
//        relout1_in1();


    }

    public void extractSpecifiedRecords(List<List<String>> content) {

        int count = 0;
        for (int j = 1; j < content.size(); j++) {
            String str = content.get(j).get(2).trim() +
                    content.get(j).get(3).trim() +
                    content.get(j).get(4).trim();
            for (int i = j; i < content.size(); i++) {
                String tempStr = content.get(i).get(2).trim() +
                        content.get(i).get(3).trim() +
                        content.get(i).get(4).trim();
                String x1 = content.get(i).get(1);
                String out1 = content.get(i).get(5);
                if (str.equals(tempStr)) {
                    tmpContent.add(content.get(i).get(0));
                    System.out.format("No.%s:  ", tmpContent.get(count));
                    System.out.format("%s - ", content.get(i).get(2).trim());
                    System.out.format("%s - ", content.get(i).get(3).trim());
                    System.out.format("%s\n", content.get(i).get(4).trim());
                    System.out.println("------------------------");
                    count++;
                }
            }
            System.out.println("similare counts: " + count);
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