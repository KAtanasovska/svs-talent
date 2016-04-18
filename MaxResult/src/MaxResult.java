import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxResult {
	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();
		final Integer[] complexCalculationResult = new Integer[NUMBER_OF_OPERATIONS];
		final Future<Integer>[] complexCalculationFuture = new Future[NUMBER_OF_OPERATIONS];
		for (int i = 0; i <= NUMBER_OF_OPERATIONS - 1; i++) {

			complexCalculationFuture[i] = executorService.submit(new ComplexCalculation());
			

		}
		

		System.out.println("Waithing for all complex operations to finish...");
		
		//latch.await();
		for (int i = 0; i <= NUMBER_OF_OPERATIONS - 1; i++) {
			 complexCalculationResult[i] = complexCalculationFuture[i].get();
		}
		//
		System.out.println("All complex operations finished.");
		int max = 0;
		for (int i = 0; i < NUMBER_OF_OPERATIONS - 1; i++) {
			if (max < complexCalculationResult[i]) {
				max = complexCalculationResult[i];
			}

		}
		System.out.println("The max result is " + max);
		executorService.shutdown();

	}

}
