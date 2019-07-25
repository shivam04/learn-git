public class TestWrapper {
	public static void main(String[] args) {
		String s = "2";
		int x = Integer.parseInt(s);
		double d = Double.parseDouble("420.24");
		boolean b = new Boolean("true").booleanValue();
		System.out.println(s);
		System.out.println(x);
		System.out.println(d);
		System.out.println(b);
	}
}