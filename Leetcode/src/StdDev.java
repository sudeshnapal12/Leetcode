
public class StdDev {
	
	double std_dev2(double a[], int n) {
	    if(n == 0)
	        return 0.0;
	    double sum = 0;
	    double sq_sum = 0;
	    for(int i = 0; i < n; ++i) {
	       sum += a[i];
	       sq_sum += a[i] * a[i];
	    }
	    System.out.println("sq " + sq_sum/n);
	    double mean = sum / n;
	    double variance = sq_sum / n - mean * mean;
	    System.out.println("variance "+variance);
	    System.out.println( Math.sqrt(variance));
	    
	    double nr = n*sq_sum - sum*sum;
	    double dr = n* (n-1);
	    return Math.sqrt(nr/dr);
	    
	}
	
	// for sample variance
	double std_dev(double a[], int n) {
	    if(n == 0)
	        return 0.0;
	    int i = 0;
	    double meanSum = a[0];
	    double stdDevSum = 0.0;
	    for(i = 1; i < n; ++i) {
	        double stepSum = a[i] - meanSum;
	        double stepMean = ((i - 1) * stepSum) / i;
	        meanSum += stepMean;
	        stdDevSum += stepMean * stepSum;
	    }
	    // for poulation variance: return sqrt(stdDevSum / elements);
	    return Math.sqrt(stdDevSum / (n - 1));
	}
	
	public static void main(String[] args) {
		StdDev s = new StdDev();
		double a[] = {  152750.00, 94250.00, 98250.00, 80175.00, 72250.00, 96170.00, 89750.00, 86150.00, 66500.00, 49250.00, 73800.00, 68420.00, 55280.00, 62250.00, 44680.00, 51340.00, 50450.00, 57740.00, 68270.00, 49840.00
				, 42180.00, 48760.00, 49180.00, 47250.00, 37380.00, 36250.00, 35340.00, 37750.00, 35900.00, 39950.00, 45370.00, 43840.00, 46500.00, 39250.00, 68420.00, 64680.00, 69840.00, 37760.00
				, 46250.00, 35900.00, 35370.00, 31840.00};
		System.out.println(s.std_dev2(a, a.length));
		System.out.println(s.std_dev(a, a.length));
	}

}
