package servert.gwc;

import java.util.Collection;

public interface IGwc {
	//���ﳵ�����һ����Ʒ(1,��Ʒ������,���һ��.2,��Ʒ����,������һ)
	public  abstract void add(GwcItem  gwcItem);
	//ɾ�����ﳵ�е�ĳ����Ʒ 
	public  abstract void remove(int id);
	//��չ��ﳵ�е�������Ʒ
	public abstract void clear();
	//�޸Ĺ��ﳵ��ĳ����Ʒ������
	public void updataItemNum(int id,int num);
    //�õ�������Ʒ�ü���
	public Collection<GwcItem> getItemNum();
	//�õ�ԭʼ�ܼ�
	public float getOldPrices();
	//�õ���Ա��
	public float getOldHyPrices();
}
