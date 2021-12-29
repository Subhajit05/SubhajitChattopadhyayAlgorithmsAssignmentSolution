package Service;
import java.util.Scanner;

public class CodingAssignmentAlgo {

	static double []sp;
	boolean indicator;
	
	public static void mergePrice(double sp[], int beg, int mid, int end ) {
		
		int firstHalf = mid - beg + 1;
		int lastHalf = end - mid;
		
		double left[] = new double[firstHalf];
		double right[] = new double[lastHalf];
		
		for(int i = 0; i < firstHalf; i++) 
			
			left[i] = sp[beg + i];
		
			for (int j = 0; j < lastHalf; j++) 
				right[j] = sp[mid+j+1];
		
			
		int k =beg;
		int i = 0, j = 0;
		
		while(i < firstHalf && j < lastHalf ) {
			if (left[i] <= right[j]) {
			 sp[k] = left[i];
			 i++;
			} else {
				sp[k] = right[j];
				j++;
			}
			k++;
		}
			
		while (i < firstHalf) {
			sp[k] = left[i];
			i++;
			k++;
		}
		
		while (j < lastHalf) {
			sp[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void sortPrice(double sp[], int beg,  int end ){
		if (beg < end) {
			int mid = (beg + end)/2;
			
			sortPrice(sp, beg, mid);
			sortPrice(sp,mid + 1,end);
			
			mergePrice(sp, beg, mid, end);
			
		}
			
	}
	
	public static void DescendingSort(double[]sp) {
		
		sortPrice(sp, 0, sp.length-1);
		
		int n = sp.length;
		
		for(int i = 0; i <n/2; i++) {
			
			double temp = sp[i];
			
			sp[i] = sp[n-i-1];
			sp[n-i-1]=temp;
			
		}
	
		
	}
	
	public  static void PrintArray(double sp[]) {
	
		int n = sp.length;
		for (int i =0; i < n ; i++) {
			System.out.println(sp[i]);
	}
	}	
	
	public  static void PrintArray1(String sp[]) {
		
		int n = sp.length;
		for (int i =0; i < n ; i++) {
			System.out.println(sp[i]);
		}
	}
	
	public static void IncreasingPriceTrend(double []sp, String []response) {
		int counter=0;
		
		for(int i = 0; i < response.length; i++) {
			if (response[i].matches("true")){
				counter ++;
			} 

		}
		
		System.out.println("No of conutries who price has increased is" +" " + counter);
	}

	
	public static void DecreasingPriceTrend(double []sp, String []response) {
		int counter1=0;
		
		for(int i = 0; i < response.length; i++) {
			if (response[i].matches("false")){
				counter1 ++;
			} 

		}
		
		System.out.println("No of conutries who price has decreased is" +" " + counter1);
	}
	
	

	public static void  searchValue(double []sp) {
		
		sortPrice(sp,0,sp.length-1);
		PrintArray(sp);
		
		System.out.println("Enter the value to be searched");
		
		Scanner sc = new Scanner(System.in);
		
		double value = sc.nextDouble();
		
		int left = 0;
		int right = sp.length-1;
		int mid = left + (right - left)/2;
		
		while (left <= right) {
			
			if(value < sp[mid]) {
				 right = mid-1;
			} else if (value > sp[mid]) {
				left = mid +1;
			} else {
				System.out.println("Search Value" + " " + value + "is found at index"+" " + mid);
				break;
			}
			
			mid = left + (right - left)/2;
			
		}
		
		if (left > right) {
			System.out.println("Value not found");
		}
		
	}		
	
	public static void main(String []args) {
		
		System.out.println("Enter the number of stocks whose data needs to be captured");
		
		Scanner nos = new Scanner(System.in);
		
		int stocks = nos.nextInt();
		
		double sp [] = new double [stocks];
		String response[] = new String[stocks];
		
		for(int i = 0; i < stocks; i++) {
			
			System.out.println("Enter stock prices for" + " " + (stocks-i) +" " + "stocks");
			
			Scanner pr = new Scanner(System.in);
			double price = pr.nextDouble();
			
			sp[i] = price;
			
			System.out.println("Indicate whether share price increased from yesterday");
			
			Scanner flag = new Scanner(System.in);
			String trend = flag.next();
			
			response[i] = trend;
	
		}
		
		
		System.out.println("List of options:" 
				+ "\nOption 1: Display the stock prices in an ascending oder" 
				+ "\nOption 2: Display the stock prices in a descending order" 
				+ "\nOption 3: Display the total number of companies for which stock price rose" 
				+ "\nOption 4: Display the total number of companies for which stock price decreased "
				+ "\nOption 5: Search a specific stock price"
				+ "\nOption 6: Select 0 to exit" );
		
	
		boolean  repeat = false;
		boolean  exitloop = false;
		
		while(repeat == false) { 
			
		System.out.println("please indicate what kind of information you want");
	    java.util.Scanner  choice = new Scanner(System.in);
		
		int option = choice.nextInt();
		
		switch(option){
		case 1: System.out.println("Stock Prices in ascending order is as follows"); sortPrice(sp,0,sp.length-1);PrintArray(sp);break;
		case 2: System.out.println("Stock prices in descending order is as follows");DescendingSort(sp);PrintArray(sp);break;
		case 3: System.out.println("case 3"); IncreasingPriceTrend(sp,response);break;
		case 4: System.out.println("case 4");DecreasingPriceTrend(sp,response);break;
		case 5: System.out.println("case 5");searchValue(sp); break;
		case 0: repeat = true;
			}
		if (repeat == true) break;
		}
	
				
		}		
		
}
		
		
		
		




