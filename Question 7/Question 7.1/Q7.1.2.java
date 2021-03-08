import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
class Q7.1.2{
    /*
    * Written by Zhang Mingxue
    * */
    static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args){
        int L1 = 50 , L2 = 57;
        String filePath = "C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//Question 7.1//input_index_7_1.txt";
        readTxtFile(filePath);
        try {
            FileWriter fw = new FileWriter("C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//output_coordinates_7_1.txt");
            fw.write("x1"+"\t"+"x2"+"\n");
            for(int i = 1; i<arrayList.size();i++) {
                int x1 = Integer.valueOf(arrayList.get(i)) % L1;
                int x2 = (Integer.valueOf(arrayList.get(i))-x1)/L1;
                String str = x1+"\t"+x2+"\n";
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
