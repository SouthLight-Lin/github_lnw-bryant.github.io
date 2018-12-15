package experiment.one;

public class BuyChicken {
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            for (int j = 0; j < 100; j++) {
                int k = 100-i-j;
                if(k%3==0){
                    if(5*i+3*j+k/3==100){
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
    }
}
