{
    /*
     * Written by Zhang Mingxue
     * */
    static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args){
        int L1 = 50 , L2 = 57;
        String filePath = "C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7//Question 7.1//input_coordinates_7_1.txt";
        readTxtFile(filePath);
        try {
            FileWriter fw = new FileWriter("C://Users//张明学//Desktop//AY20_MBDS_questions//Question 7.1//output_index_7_1.txt");
            fw.write("Index"+"\n");
            for(int i = 1; i<arrayList.size();i++) {
                arrayList.get(i).split("\t");
                int index = Integer.valueOf(arrayList.get(i).split("\t")[1])*L1+Integer.valueOf(arrayList.get(i).split("\t")[0]);
                //System.out.println(index);
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
            if(file.isFile() && file.exists()){ //whether the file exist
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//
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
