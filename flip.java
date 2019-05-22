
public class flip {

    public static void main(String[] args) { 
    	new binomial();
    	
    	for(int i = 0; i < 10; i++){
    	int x= 0;
    	while (x != 10){
        // Math.random() returns a value between 0.0 and 1.0
        // so it is heads or tails 50% of the time
        double y = Math.random() * 10; 
        int z = (int)y;
    	if (z < 5) {
        	System.out.println("Heads" + " " + y +" " + z);
        	x++;
    	}
        else{  
        	System.out.println("Tails" + " " + y +" " + z);
        	x++;
        }
    }
    	}
    }
    	
}