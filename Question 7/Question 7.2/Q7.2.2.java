import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Q7.2.2{
    /*
    * Written by Zhang Mingxue
    * */
    static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args){
        int L1 = 4 , L2 = 8 , L3 = 5 , L4 = 9 , L5 = 6 , L6 = 7;
        String filePath = "C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//Question 7.2//input_index_7_2.txt";
        readTxtFile(filePath);
        try {
            FileWriter fw = new FileWriter("C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//output_coordinates_7_2.txt");
            fw.write("x1"+"\t"+"x2"+"\t"+"x3"+"\t"+"x4"+"\t"+"x5"+"\t"+"x6"+"\n");
            for(int i = 1; i<arrayList.size();i++) {
                int index = Integer.valueOf(arrayList.get(i));
                int x6 = (int) Math.floor(index /(L1*L2*L3*L4*L5));
                index = index-x6*(L1*L2*L3*L4*L5);
                int x5 = (int)Math.floor(index/(L1*L2*L3*L4));
                index = index-x5*(L1*L2*L3*L4);
                int x4 = (int)Math.floor(index/(L1*L2*L3));
                index = index-x4*(L1*L2*L3);
                int x3 = (int)Math.floor(index/(L1*L2));
                index = index-x3*(L1*L2);
                int x2 = (int)Math.floor(index/(L1));
                int x1 = index-x2*(L1);
                String str = x1+"\t"+x2+"\t"+x3+"\t"+x4+"\t"+x5+"\t"+x6+"\n";
                fw.write(str);

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
