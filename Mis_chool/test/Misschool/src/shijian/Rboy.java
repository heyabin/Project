package shijian;

public class Rboy implements GirlListener{

	@Override
	public void look(Evevt evevt) {
		if ("����".equals(evevt.getEvebtstr())) {
			System.out.println("ţ��");
		}
	}
}