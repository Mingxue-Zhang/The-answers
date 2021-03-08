class Q6{
     /*
    * Written by Zhang Mingxue
    * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("input the number of points in polygon");
        int num_Polygon  = sc.nextInt();
        System.out.println("input the number of tested points");
        int num_Point  = sc.nextInt();

        ArrayList<Point> polygon = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();

        System.out.println("input points in polygon");
        for(int i = 0; i < num_Polygon; i++) { // init Polygon
            polygon.add(new Point());
            polygon.get(i).x = sc.nextInt();
            polygon.get(i).y = sc.nextInt();
        }

        System.out.println("input the  tested points");
        for(int i = 0; i < num_Point; i++) { // init tested point
            points.add(new Point());
            points.get(i).x = sc.nextInt();
            points.get(i).y = sc.nextInt();
        }


        for(int i = 0; i < num_Point; i++) {
            if(isContained(polygon,points.get(i),num_Polygon))
                System.out.println((int)points.get(i).x +" " + (int)points.get(i).y + " Inside");
            else
                System.out.println((int)points.get(i).x +" " + (int)points.get(i).y + " Outside");

        }


    }
    public static boolean isContained (ArrayList<Point> polygon,Point points,int num_Polygon) {
        double minX,minY,maxX,maxY;
        minX=polygon.get(0).x;
        maxX=polygon.get(0).x;
        minY=polygon.get(0).y;
        maxY=polygon.get(0).y;
        for(int i = 1; i < num_Polygon; i++) {
            if(minX > polygon.get(i).x)
                minX = polygon.get(i).x;
            if(maxX < polygon.get(i).x)
                maxX = polygon.get(i).x;
            if(minY > polygon.get(i).y)
                minY = polygon.get(i).y;
            if(maxY < polygon.get(i).y)
                maxY = polygon.get(i).y;
        }
        if (points.x < minX || points.x > maxX || points.y < minY || points.y > maxY) {
            return false;
        }
        boolean c =false ,d = false;
        int i, j = 0;
        for (i = 0, j = num_Polygon-1; i < num_Polygon; j = i++) { //in or out side
            if ( ((polygon.get(i).y>points.y) != (polygon.get(j).y>points.y)) &&
                    (points.x < (polygon.get(j).x-polygon.get(i).x) * (points.y-polygon.get(i).y) / (polygon.get(j).y-polygon.get(i).y) + polygon.get(i).x))
                c = !c;

        }
        if(c)
            return true;
        for (i = 0, j = num_Polygon-1; i < num_Polygon; j = i++) { //on EDGE
            if ((((polygon.get(i).y - points.y)/ (polygon.get(i).x -points.x )) == (polygon.get(j).y - points.y)/ (polygon.get(j).x -points.x))
                    || (((polygon.get(i).y - points.y )/ (polygon.get(i).x -points.x ))==0 && ((polygon.get(j).y - points.y)/ (polygon.get(j).x -points.x ) == 0)))
                d = !d;
        }

        return d;
    }


}
