//5
// Zhang Mingxue
// test as this
//    64 //length of L
//    5 // kinds of colors
//    R 139 // color number
//    B  1451
//    G  977
//    W 1072
//    Y 457
//
class Q5{
    static Scanner sc = new Scanner(System.in);
    static int L = sc.nextInt();
    static int number_OF_Color = sc.nextInt();
    static int totalNum = L*L;
    static int maxNum = 0;
    static String maxColor="";
    static  ArrayList<Colors> color_num= new ArrayList<>();
    static String[][] map = new String[L][L];
    public static void main(String[] args){

        for(int i = 0; i < number_OF_Color; i++) {
            color_num.add(new Colors());
            color_num.get(i).name=sc.next();
            color_num.get(i).num=sc.nextInt();
        }

        coloring();
        try{
             FileWriter fw = new FileWriter("C://Users//张明学//Desktop//AY20_MBDS_questions//Question 5//output_5");
             String str= "";
             for (int i = 0; i < L; i++) {
                 for (int j = 0; j < L; j++){
                         str += map[i][j]+" ";
                     }
                 str = str+"\n";
                }
            fw.write(str);
            fw.close();
        }catch (Exception e) {
             e.printStackTrace();
        }

    }


    public static void coloring() {
        for (int i =0; i<color_num.size();i++) {
            if (color_num.get(i).num>maxNum) {
                maxNum = color_num.get(i).num;
                maxColor =  color_num.get(i).name;
            }
        }
        //index of the number of maxColor
        int index=0;
        for(int i = 0; i<color_num.size();i++) {
            if (color_num.get(i).name.equals(maxColor)) {
                index = i;
                break;
            }
        }
        //The largest number of color is exactly half of the odd number
        if (L % 2 ==1 && color_num.get(index).num == Math.ceil((totalNum * 0.5))) {
            int restI = 0;
            int restJ = 0;
            int totalRestNum = totalNum;
            int temp =0 ;
            for (int i = 0; i<L; i +=1) {
                for (int j = 0 +temp; j<L;j+=2){
                    map[i][j]= maxColor;
                }
                if (temp == 1) {
                    temp =0;
                }else{
                    temp =1;
                }
            }

            for(int k= 0;k<color_num.size();k++) {
                if (color_num.get(k).name.equals(maxColor))
                    return;
                int restNum = color_num.get(k).num;
                boolean newColor = true;
                temp = 1;

                for (int i = 0; i<L;i+=1) {
                    for (int j = 0+temp;j<L;j+=2) {
                        if(newColor){
                            newColor = false;
                            i = restI;
                            j = restJ;
                            continue;
                        }
                        if (restNum == 0) {
                            i = totalNum;
                            j = totalNum;
                            break;
                        }
                        map[i][j] = color_num.get(k).name;
                        restNum--;
                        totalRestNum--;
                        restI = i;
                        restJ = j;
                        // if More than half, fill in the color from scratch
                        if (totalRestNum == Math.ceil(0.5 * totalNum) - 1) {
                            temp = 1;
                            i = 0;
                            j = 0 + temp;
                            map[i][j] = color_num.get(k).name;
                            restNum--;
                            totalRestNum--;
                            restI = i;
                            restJ = j;
                            continue;
                        }
                    }
                    if (temp == 1) {
                        temp = 0;
                    } else {
                        temp = 1;
                    }
                }
            }

        }else if (maxNum > Math.ceil(totalNum*0.5)) { //penalty cases
            int temp = 1;
            boolean first = true;
            for (int i = 0; i < L; i += 1) {
                for (int j = 0; j < L; j += 2) {
                    if ((i % 2 == 0 && first) || (i % 2 == 1 && !first)) {
                        temp = 0;
                    } else {
                        temp = 1;
                    }
                    map[i][j + temp] = maxColor;
                }
            }

            int restNum = maxNum - (int)Math.floor(totalNum * 0.5);
            first = false;
            int restI = 0;
            int restJ = -2;
            temp = 0;
            for (int i = 0; i < L; i += 1) {
                for (int j = 0; j < L; j += 2) {
                    if (restNum == 0) {
                        break;
                    }
                    if ((i % 2 == 0 && first) || (i % 2 == 1 && !first)) {
                        temp = 0;
                    } else {
                        temp = 1;
                    }
                    map[i][j + temp] = maxColor;
                    restNum--;
                    restI = i;
                    restJ = j;
                }
            }
            //put other color
            for (int k =0; k<color_num.size();k++) {
                if (color_num.get(k).name.equals(maxColor))
                    return;
                else {
                    restNum = color_num.get(k).num;
                    boolean newColor = true;
                    temp = 0;
                    for (int i = 0; i < L; i += 1) {
                        for (int j = 0; j < L; j += 2) {
                            if ((i % 2 == 0 && first) || (i % 2 == 1 && !first)) {
                                temp = 0;
                            } else {
                                temp = 1;
                            }
                            if (newColor) {
                                newColor = false;
                                i = restI;
                                j = restJ;
                                continue;
                            }
                            if (restNum == 0) {
                                i = L;
                                j = L;
                                break;
                            }
                            map[i][j + temp] = color_num.get(k).name;
                            restNum--;
                            restI = i;
                            restJ = j;
                        }
                    }
                }
            }

        }else {
            //Less than 50%
            int restI = 0;
            int restJ = 0 - 2;
            int totalRestNum = totalNum;
            int temp = 0;
            boolean first = true;
            // There will be no penalty, first put a color, just put it directly
            for (int k =0; k<color_num.size();k++) {
                int restNum = color_num.get(k).num;
                Boolean newColor = true;
                // Fill in other colors
                for (int i = 0; i < L; i += 1) {
                    for (int j = 0; j < L; j += 2) {
                        if ((i % 2 == 0 && first) || (i % 2 == 1 && !first)) {
                            temp = 0;
                        } else {
                            temp = 1;
                        }
                        // If it is a new color, use the previous position and continue to put
                        if (newColor) {
                            //console.log('new color', restI, restJ);
                            newColor = false;
                            i = restI;
                            j = restJ;
                            // restI and restJ are the previous position, continue is to find the next position
                            continue;
                        }
                        // Run out, jump out of the loop
                        if (restNum == 0) {
                            i = totalNum;
                            j = totalNum;
                            break;
                        }
                        map[i][j + temp] = color_num.get(k).name;
                        restNum--;
                        totalRestNum--;
                        restI = i;
                        restJ = j;
                        // if More than half, fill in the color from scratch
                        if (totalRestNum == Math.floor(0.5 * totalNum) && i != 0) {
                            first = false;
                            if (restNum > 0) {
                                i = 0;
                                j = 0;
                                map[i][j + temp] = color_num.get(k).name;
                                restNum--;
                                totalRestNum--;
                                restI = 0;
                                restJ = 1;
                            } else {//If more than half, and the color is consumed, the next color starts from 0,1
                                restI = 0;
                                restJ = -2;
                            }
                        }
                    }
                }
            }
        }
    }
}
