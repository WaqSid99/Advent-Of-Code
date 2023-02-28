import java.util.Scanner;
import java.io.File; 
import java.util.ArrayList;

class day1 {
    public static void main (String[] args) {
        int total1 = 0;  
        int total2 = 0;
        int total3 = 0;
        
        ArrayList<Integer> arr =new ArrayList<>();

        try {
            File file = new File("day1.txt");
            Scanner sc = new Scanner(file);
            int temp=0;

            while (sc.hasNextLine()){
                String data = sc.nextLine();
                if(data.length()!=0){
                    int num = Integer.parseInt(data);
                    temp+=num;
                }
                else{
                    arr.add(temp);

                    if(temp>total1){
                        total3= total2;
                        total2=total1;
                        total1=temp;
                        temp=0;
                    }
                    else if(temp>total2){
                        total3=total2;
                        total2= temp;
                        temp=0;
                    }
                    else if(temp>total3){
                        total3= temp;
                        temp=0;
                    }
                    else{
                        temp=0;
                        continue;
                    }
                }
            }
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(total1);
        System.out.println(total2);
        System.out.println(total3);
        System.out.println(total1+total3+total2);
        System.out.println();
        arr.sort(null);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }
}