package com.oracle.gdms.service;

import java.util.List;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsTypeEntity;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * ��ҳ��ʾ��Ʒ����
	 * @param pageNumber ��ǰҳ��
	 * @param rows ÿҳ��������¼
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);

	
	/**
	 * ����ָ��ID����Ʒ
	 * @param goodsid
	 * @return �ɹ���ϢΪ�մ���ʧ��Ϊ��Ϣ����
	 */
	String pushGoods(int goodsid);


	/**
	 * ����һ����Ʒ��¼
	 * @param goods
	 * @return ��Ӱ�������
	 */
	int add(GoodsEntity goods);


	/**
	 * ���ݹؼ���������Ʒ��¼����ҳ��ʾ
	 * @param kw �ؼ���
	 * @param p ҳ��
	 * @param rows ÿҳ����
	 * @return
	 */
	PageModel<GoodsModel> findByKeywords(String kw, int p, int rows);


	/**
	 * ��ѯ���ݽ��е�����Excel����
	 * @param kw
	 * @return
	 */
	List<GoodsModel> findByKeywords(String kw);

	
	/**
	 * ɾ��һ����Ʒ���ݣ�����״̬��
	 * @param gid
	 */
	void delete(String[] gid);
	
	/**
	 * ������Ʒid�޸�һ����Ʒ��¼
	 * @param gid
	 */
	int update(GoodsEntity goods);

	/**
	 * ��ѯ������Ʒ���
	 * @param gid
	 */
	List<GoodsTypeEntity> findAllType();

	/**
	 * ������Ʒid�޸���Ʒ����id
	 * @param gid
	 */
	int updateType(GoodsEntity goods);


	/**
	 * ������Ʒ���Ͳ�ѯ��������������Ʒ
	 * @param gid
	 */
	List<GoodsModel> findByType(int gtid);



}
