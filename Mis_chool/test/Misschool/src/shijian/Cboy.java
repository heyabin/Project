package shijian;

public class Cboy implements GirlListener{

	@Override
	public void look(Evevt evevt) {
		if ("¶öÁË".equals(evevt.getEvebtstr())) {
			System.out.println("ÍÁ¶¹");
		}
	}

}
