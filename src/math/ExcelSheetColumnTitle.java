package math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution4 sl = new solution4();
		System.out.print(sl.convertToTitle(1000000001));
	}

}

class solution4 {
	// 理解错误。。。。
	public String convertToTitle1(int n) {
		String sim = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String res = "";
		int i = 0;
		int j = (n - 1) % 26;// (n-1)为了好读取字符串
		while (i + 1 <= (n - 1) / 26)// 这里（n-1)是为了保证26的整数倍输出正确
										// 因为i标记的事总位数-1
		{
			res += sim.charAt(i % 26);// 对26取余，保证超出26位是依然能输出
			i++;
		}
		res += sim.charAt(j);
		return res;
	}

	public String convertToTitle(int n) {
		// String sim = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String res = "";
		while (n > 0) {
			// res = sim.charAt((n-1)%26)+res;
			// 计算结果为int类型，表示asc2码值，强制转换为char
			char c = (char) ((n - 1) % 26 + 'A');
			res = c + res;
			n = (n - 1) / 26;
		}
		return res;

	}
}
