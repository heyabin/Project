package shijian;

import java.util.ArrayList;
import java.util.List;

public class Bgirl {
	//私有的监听者列表
	private List<GirlListener> listeners = new ArrayList<GirlListener>();
	//共有的向监听者列表里添加监听者的方法
	public void addGirlistener(GirlListener girlListener){
		this.listeners.add(girlListener);
	}
	//女孩的方法
	public void Girlaction(String str){
		Evevt evevt = new Evevt(str);
		for (GirlListener girlListener : listeners) {
			girlListener.look(evevt);
		}
	}
}
