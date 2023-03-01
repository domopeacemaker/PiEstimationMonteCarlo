package ejercicio7;
public class Maestro implements Runnable{

	SequentialPiEstimation s[];
	double pi,totalPoints=0,point_in_circle=0;
	int nThreads;
	
	public Maestro(SequentialPiEstimation s[],int nThreads) {
		// TODO Auto-generated constructor stub
		this.s=s;
		pi=0;
		this.nThreads=nThreads;
	}
	public synchronized void getTotalPoints() {
		for(int i =0;i<nThreads;i++) {
			totalPoints+=s[i].getTotalPoints();
		}
	}
	public synchronized void getPointsInCircle() {
		for(int i =0;i<nThreads;i++) {
			point_in_circle+=s[i].getInsideCirclePoints();
		}
	}
	public synchronized void calcularPi() {
		
		pi=4*(point_in_circle/totalPoints);
	}
	@Override
	public void run() {
		while(true) {
			getPointsInCircle();
			getTotalPoints();
			calcularPi();
			 double absoluteError = Math.abs(Math.PI -pi);
		        System.out.println("- Estimated Pi value: " + pi + "\n" +
		                "  + Absolute error with \"actual\" Pi value: " + absoluteError + "\n" +
		                "  + Generated " + totalPoints + " random points");
		        
		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
