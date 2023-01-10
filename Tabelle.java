
public class Tabelle {
    public static void main(String[] args) {
    	String[] Fahr = {"Fahrenheit","Celsius"};
    	double[] Grad = {-20, -28.89, -10, -23.33, 0, -17.78, 20, -6.67, 30, -1.11};
		System.out.printf("%-12s|%10s\n", Fahr[0], Fahr[1]);
		System.out.printf("-----------------------\n");
    	for(int i = 0; i < Grad.length; i++) {
    		System.out.printf("%-12.0f|%10.2f\n", Grad[i++], Grad[i]);
    	}		
    }
}