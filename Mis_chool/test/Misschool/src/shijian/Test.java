package shijian;

public class Test {
	public static void main(String[] args) {
		Bgirl bgirl = new Bgirl();
		Rboy rboy = new Rboy();
		Cboy cboy = new Cboy();
		bgirl.addGirlistener(cboy);
		bgirl.addGirlistener(rboy);
		bgirl.Girlaction("ถ๖มห");
	}
}
