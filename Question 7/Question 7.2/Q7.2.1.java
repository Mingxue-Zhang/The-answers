import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
class Q7.2.1{
    /*
     * Written by Zhang Mingxue
     * */
    static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args){
        int L1 = 4 , L2 = 8 , L3 = 5 , L4 = 9 , L5 = 6 , L6 = 7;
        String filePath = "C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//Question 7.2//input_coordinates_7_2.txt";
        readTxtFile(filePath);
        try {
            FileWriter fw = new FileWriter("C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//output_index_7_2.txt");
            fw.write("Index"+"\n");
            for(int i = 1; i<arrayList.size();i++) {
                arrayList.get(i).split("\t");
                int index = Integer.valueOf(arrayList.get(i).split("\t")[0])+
                            Integer.valueOf(arrayList.get(i).split("\t")[1])*L1+
                            Integer.valueOf(arrayList.get(i).split("\t")[2])*L1*L2+
                            Integer.valueOf(arrayList.get(i).split("\t")[3])*L1*L2*L3+
                            Integer.valueOf(arrayList.get(i).split("\t")[4])*L1*L2*L3*L4+
                            Integer.valueOf(arrayList.get(i).split("\t")[5])*L1*L2*L3*L4*L5;
                System.out.println(index);
                fw.write(String.valueOf(index)+"\n");

            }
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readTxtFile(String filePath){
        try {
            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ 
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    arrayList.add(lineTxt);
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
