package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	public void add(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}

	@SuppressWarnings("unchecked")
	public List<LinkMan> list() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	public LinkMan findOne(int linkId) {
		return this.getHibernateTemplate().get(LinkMan.class, linkId);
	}

	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}

}
