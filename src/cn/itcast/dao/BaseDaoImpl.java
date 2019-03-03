package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private  Class pclass;
	public BaseDaoImpl() {
		Class clazz = this.getClass();
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		Type[] types = ptype.getActualTypeArguments();
		Class tclass = (Class) types[0];
		this.pclass = tclass;
	}

	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("all")
	public T findOne(int id) {
		return (T) this.getHibernateTemplate().get(pclass, id);
	}

	@SuppressWarnings("all")
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+pclass.getSimpleName());
	}

}
