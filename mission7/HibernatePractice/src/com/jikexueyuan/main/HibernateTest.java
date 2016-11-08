package com.jikexueyuan.main;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import com.jikexueyuan.entity.Poet;
import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		// 输出名字为三个字的诗人列表和诗词数量统计
		getPoetriesCount();
		// 分页输出诗人李白的所有诗词的标题
		getLibaiTitles();
		// 输入诗人名字，查询出诗词前15字简略
		getThumbnails();
	}

	public static void getPoetriesCount() {

		Session session = HibernateUtil.getSession();
		try {
			String hql = "select b.name,count(a.id) from Poetry a left join a.poet b where b.name like :name group by b.name order by count(a.id) desc";
			@SuppressWarnings("unchecked")
			List<Object[]> list = session.createQuery(hql).setParameter("name", "___").getResultList();
			System.out.println("经统计，名字为三个字的诗人作品数量如下：");
			for (Object[] objs : list) {
				String poetName = (String) objs[0];
				Long poetriesCount = (Long) objs[1];
				System.out.println("姓名：" + poetName + "\t" + "诗词数量:" + poetriesCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	public static void getLibaiTitles() {

		Session session = HibernateUtil.getSession();
		try {
			String hql = "select count(a.id) from Poetry a left join a.poet b where b.name=:name";
			@SuppressWarnings("unchecked")
			List<Object> list = session.createQuery(hql).setParameter("name", "李白").getResultList();
			Long pageCount = (Long) list.get(0) / 10 + 1;
			System.out.println("诗人李白相关的数据总共有" + pageCount + "页");
			hql = "select a.title from Poetry a left join a.poet b where b.name=:name";
			for (int i = 1; i <= pageCount; i++) {
				@SuppressWarnings("unchecked")
				List<Object> titles = session.createQuery(hql).setParameter("name", "李白").setFirstResult((i - 1) * 10)
						.setMaxResults(10).getResultList();
				System.out.println("第" + i + "页内容：");
				for (Object title : titles) {
					System.out.println("《" + (String) title + "》");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getThumbnails() {

		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSession();
		System.out.println("请输入一个诗人的名称");
		String poetName = sc.next();
		String hql = "from Poet a where a.name=:name";
		Poet poet = (Poet) session.createQuery(hql).setParameter("name", poetName).setMaxResults(1).getResultList()
				.get(0);
		System.out.println(poet.getName() + " 的所有诗词简略如下：");
		for (Poetry poetry : poet.getPoetries()) {
			String thumbnail = poetry.getContent().length() > 15 ? poetry.getContent().substring(0, 15)
					: poetry.getContent();
			System.out.println(thumbnail + "...");
		}
	}
}
