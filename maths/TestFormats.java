import java.util.Date;
public class TestFormats {
	public static void main (String[] args) {
		String s = String.format("%, d", 1000000000);
		System.out.println(s);
		String p = String.format("%,6.1f", 42.000);
		System.out.println(p);
		Date today = new Date();
		System.out.println(String.format("%tc", today));
		System.out.println(String.format("%tr", today));
		System.out.println(String.format("%tA %tB %td", today, today, today));
	}
}