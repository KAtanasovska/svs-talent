
import java.util.Random;
import java.util.concurrent.Callable;


public class ComplexCalculation implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Complex calculation started...");
        try {
        	Thread.sleep(3000);	
		} catch (InterruptedException e) {
		}
        System.out.println("Complex calculation completed.");

        return new Random().nextInt(10 + 1);
    }

}
