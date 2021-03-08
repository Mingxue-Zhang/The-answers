class Q1{
    static Scanner sc = new Scanner(System.in);
    static int m = sc.nextInt();
    static int n = sc.nextInt();
    static long require_Sum = sc.nextLong();
    static long min = m - 1 + (long)((1 / 2f) * n * (n + 1));
    static long max = n * (m - 1) + (1 / 2) * m * (m + 1);
    static long sumR = 0;
    static boolean close = false;
    static ArrayList<Double> rightNumList = new ArrayList<Double>();
    public static void main(String[] args){
        long yuShu = require_Sum - min;
        for (int i = n; i > 0; i--) {
            yuShu = getData(m, i, yuShu);
            if (close == true) {
                break;
            }
        }

        ArrayList<String> endData = new ArrayList<String>();
        for (int i = 0; i < m - sumR-1;i++){
            endData.add("R");
        }
        for (int i = 0; i < n - rightNumList.size();i++){
            endData.add("D");
        }
        int t = rightNumList.size()-1;
        for (int i = 0; i < rightNumList.size(); i++) {
            if (rightNumList.get(t-i) <= 0&&i != rightNumList.size() - 1) {
                endData.add("D");
            } else {
                for (int j = 0; j < rightNumList.get(t-i); j++) {
                    endData.add("R");
                }
                if (i != rightNumList.size() - 1) {
                    endData.add("D");
                }
            }
        }
        System.out.print(require_Sum+" ");
        for (int i =0; i<endData.size();i++){
            System.out.print(endData.get(i));
        }

    }

    public static long getData( int m, int n, long sum) {
        long yushu = sum % (n-1);
        if (yushu <= 0) {
            sumR += Math.floor(sum / (n - 1));
            rightNumList.add(Math.floor(sum / (n - 1)));
            close = true;
            return 0;
        }
        rightNumList.add(Math.floor(sum / (n - 1)));
        sumR += Math.floor(sum / (n - 1));
        return yushu;
        // getData(m, n - 1, yushu);
    }
}
