package servert.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import sun.security.action.PutAllAction;

public class Gwc implements IGwc{
	
	private Map<Integer, GwcItem> books = new Hashtable<Integer, GwcItem>();
	
	public void add(GwcItem gwcItem) {
		//原来购物车里边有商品
		  Set<Integer> keys = books.keySet();
		  if (keys.contains(gwcItem.getBookId())) {
			   GwcItem item =  books.get(gwcItem.getBookId());
			   item .setNum(item.getNum()+1);
		 //原来购物车里边没有商品
		  }else {
			books.put(gwcItem.getBookId(), gwcItem);
		}
		
	}
	//全部删除
	public void clear() {
		books.clear();
		
	}
    //得到会员价格
	public float getOldHyPrices() {
	float sum = 0;
	Collection<GwcItem> values =  books.values();
		for (GwcItem gwcItem : values) {
			 sum+= gwcItem.getPrice()* gwcItem.getNum();
		}
		return sum;
	}
	//得到普通价格
	public float getOldPrices() {
		float sum = 0;
		Collection<GwcItem> values =  books.values();
			for (GwcItem gwcItem : values) {
				 sum+= gwcItem.getHyprice() * gwcItem.getNum();
			}
			return sum;
		}
    //删除某个商品
	public void remove(int id) {
		books.remove(id);
		
	}
	//修改商品数量
	public void updataItemNum(int id, int num) {
		GwcItem item  =  books.get(id);
		    item.setNum(num);
		    books.put(id, item);
		
	}
	//得到商品集合
	public Collection<GwcItem> getItemNum() {
		return books.values();
	}
	//优惠价钱
	public float getYhPrices() {
		return this.getOldPrices() - this.getOldHyPrices();
	}
}
