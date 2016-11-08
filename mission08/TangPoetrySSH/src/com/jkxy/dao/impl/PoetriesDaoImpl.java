package com.jkxy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jkxy.dao.IPoetriesDao;
import com.jkxy.entity.Poetries;
import com.jkxy.entity.common.PageModel;

@Transactional
@Repository
public class PoetriesDaoImpl implements IPoetriesDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	@Override
	public int count(String hql) {
		Long temp = (Long) getSession().createQuery(hql).uniqueResult();
		int count = 0;
		if (temp != 0) {
			count = temp.intValue();
		}
		return count;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Poetries> findByPager(int pageNo, int pageSize, String hql) {

		// 获取结果
		PageModel<Poetries> pModel = new PageModel<>(pageNo, pageSize);
		pModel.setDatas((List<Poetries>) getSession().createQuery(hql).setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list());
		// 生成查询数量的hql
		String countHql = hql.replaceFirst("a", "count(a)").replaceFirst("fetch", "");
		// 获取记录数
		pModel.setRecordCount(count(countHql));
		return pModel;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
