package com.biz;
import java.util.Collection;

import com.po.GwcItem;

public interface IGwc {
	//向购物车中添加一件商品(1,商品不存在,添加一件.2,商品存在,数量加一)
	public  abstract void add(GwcItem  gwcItem);
	//删除购物车中的某种商品 
	public  abstract void remove(int id);
	//清空购物车中的所有商品
	public abstract void clear();
	//修改购物车中某种商品的数量
	public void updataItemNum(int id,int count);
    //得到所有商品得集合
	public Collection<GwcItem> getItemNum();
	//得到原始总价
	public float getOldPrices();
	//得到会员价
	public float getOldHyPrices();
}
