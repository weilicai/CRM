package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


/*	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	@SuppressWarnings("all")
	public User loginUser(User user) {
		HibernateTemplate hibernateTemplate =  this.getHibernateTemplate();
		List<User> list = (List<User>) hibernateTemplate.
		find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if(list != null && list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}

	}

	@SuppressWarnings("all")
	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
}
