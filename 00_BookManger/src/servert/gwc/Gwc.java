package servert.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import sun.security.action.PutAllAction;

public class Gwc implements IGwc{
	
	private Map<Integer, GwcItem> books = new Hashtable<Integer, GwcItem>();
	
	public void add(GwcItem gwcItem) {
		//ԭ�����ﳵ�������Ʒ
		  Set<Integer> keys = books.keySet();
		  if (keys.contains(gwcItem.getBookId())) {
			   GwcItem item =  books.get(gwcItem.getBookId());
			   item .setNum(item.getNum()+1);
		 //ԭ�����ﳵ���û����Ʒ
		  }else {
			books.put(gwcItem.getBookId(), gwcItem);
		}
		
	}
	//ȫ��ɾ��
	public void clear() {
		books.clear();
		
	}
    //�õ���Ա�۸�
	public float getOldHyPrices() {
	float sum = 0;
	Collection<GwcItem> values =  books.values();
		for (GwcItem gwcItem : values) {
			 sum+= gwcItem.getPrice()* gwcItem.getNum();
		}
		return sum;
	}
	//�õ���ͨ�۸�
	public float getOldPrices() {
		float sum = 0;
		Collection<GwcItem> values =  books.values();
			for (GwcItem gwcItem : values) {
				 sum+= gwcItem.getHyprice() * gwcItem.getNum();
			}
			return sum;
		}
    //ɾ��ĳ����Ʒ
	public void remove(int id) {
		books.remove(id);
		
	}
	//�޸���Ʒ����
	public void updataItemNum(int id, int num) {
		GwcItem item  =  books.get(id);
		    item.setNum(num);
		    books.put(id, item);
		
	}
	//�õ���Ʒ����
	public Collection<GwcItem> getItemNum() {
		return books.values();
	}
	//�Żݼ�Ǯ
	public float getYhPrices() {
		return this.getOldPrices() - this.getOldHyPrices();
	}
}
