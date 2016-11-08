package com.jikexueyuan.dao.impl.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.jikexueyuan.dao.common.BaseDao;
import com.jikexueyuan.entity.common.PageModel;
import com.jikexueyuan.util.HibernateUtils;

public class BaseDaoImpl<T> implements BaseDao<T>{

	//子类类型
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.setClazz((Class<T>)type.getActualTypeArguments()[0]);
	}
	
	@Override
	public void save(T entity) {
		HibernateUtils.getSession().save(entity);
	}

	@Override
	public void delete(int id) {
		String hql = "delete " + clazz.getSimpleName() + " as u where u.id=" + id;
		HibernateUtils.getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public T get(Integer id) {
		return (T)HibernateUtils.getSession().get(clazz, id);
	}

	@Override
	public T load(Integer id) {
		return (T)HibernateUtils.getSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "select t from " + clazz.getSimpleName() + " t";
		return (List<T>)HibernateUtils.getSession().createQuery(hql).getResultList();
	}

	@Override
	public int totalCount() {
		String hql = "select count(t) from " + clazz.getSimpleName() + " t";
		Long temp = (Long)HibernateUtils.getSession().createQuery(hql).getSingleResult();
		int count = 0;
		if(temp != null){
			count = temp.intValue();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<T> findByPager(int pageNo, int pageSize) {
		String hql = "select t from " + clazz.getSimpleName() + " t";
		PageModel<T> pModel = new PageModel<>(pageNo, pageSize);
		pModel.setDatas((List<T>)HibernateUtils.getSession().createQuery(hql).setFirstResult((pageNo -1)* pageSize).setMaxResults(pageSize).getResultList());
		pModel.setRecordCount(totalCount());
		return pModel;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T findUnique(String sql) {
		return (T)HibernateUtils.getSession().createNativeQuery(sql, clazz).getSingleResult();
	}
}
