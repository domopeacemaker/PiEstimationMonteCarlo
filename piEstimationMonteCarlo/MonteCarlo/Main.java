package e4;

//import java.util.Random;

public class Main {
//
    public static void main(String[] args) {
    	//int r= new Random().nextInt(1000000);
	    //int randomPointsToGenerate = r;
	    int n=10;
	    SequentialPiEstimation s[] = new SequentialPiEstimation[n];
	    for(int i=0;i<n;i++) {
	    	s[i]=new SequentialPiEstimation();
	    }
	    Thread t[]=new Thread[n];
	    for(int i=0;i<n;i++) {
	    	t[i]=new Thread(s[i]);
	    }
	    for(int i=0;i<n;i++) {
	    	t[i].start();
	    }
	    Maestro m1= new Maestro(s, n);
	    Thread M=new Thread(m1);
	    M.start();
    }
}
