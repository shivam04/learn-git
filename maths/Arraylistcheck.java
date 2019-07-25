import java.util.ArrayList;
class Arraylistcheck {
	public static void main(String[] args) {
		//ArrayList<int> a = new ArrayList<int>(); //can't declare Arraylistcheck.java:4: error: unexpected type
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		int num = a.get(0);
		System.out.println(num);
		
	}
}