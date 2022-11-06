public class SubTask3 {
    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        int i = 2;
        if(x<i || y<i){
            System.out.println("нет общего делителя");
        }
        while (i <= x && i <= y) {
            if ((x % i == 0) && (y % i== 0)){
                System.out.println("Минимальный делитель = " + i);
                break;
            }
            else{
                i++;
            }
            if((i==x || i==y) && x!=y){
                System.out.println("нет общего делителя");
            }
        }
    }
}
