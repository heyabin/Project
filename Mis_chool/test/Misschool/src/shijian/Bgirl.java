package shijian;

import java.util.ArrayList;
import java.util.List;

public class Bgirl {
	//˽�еļ������б�
	private List<GirlListener> listeners = new ArrayList<GirlListener>();
	//���е���������б�����Ӽ����ߵķ���
	public void addGirlistener(GirlListener girlListener){
		this.listeners.add(girlListener);
	}
	//Ů���ķ���
	public void Girlaction(String str){
		Evevt evevt = new Evevt(str);
		for (GirlListener girlListener : listeners) {
			girlListener.look(evevt);
		}
	}
}
