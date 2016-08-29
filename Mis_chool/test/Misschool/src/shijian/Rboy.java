package shijian;

public class Rboy implements GirlListener{

	@Override
	public void look(Evevt evevt) {
		if ("¶öÁË".equals(evevt.getEvebtstr())) {
			System.out.println("Å£Èâ");
		}
	}
}