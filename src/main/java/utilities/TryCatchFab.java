package utilities;

public class TryCatchFab {
	private int maxTries=3;

	public void execute(Runnable steps) {
		int attempt=0;
		while(attempt<maxTries) {

			try {
				steps.run();
				System.out.println("Step executed successfully");	
				return;
			}catch(Exception e) {
				attempt++;
				System.out.println("Step failed : "+e.getMessage());
				if(attempt<=maxTries) {
					System.out.println("Max retries reached. Failing step.");
				}else {
					System.out.println("Retrying. (Attempt"+ attempt+")");
				}			
			}
		}
	}
}
