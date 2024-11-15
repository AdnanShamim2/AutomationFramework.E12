package practice;

public class GenericMethodPractice {
	public static void main(String[] args) {// calling function
		int prod=product(5,8);
		System.out.println(prod);
	}
	public static int product(int a,int b) //called function - generic
	{
		int c=a*b;
		return(c);
	}

}
