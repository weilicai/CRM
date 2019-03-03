package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

//	public void add(Customer customer) {
//		this.getHibernateTemplate().save(customer);
//	}
//
//	@SuppressWarnings("all")
//	public List<Customer> findAll() {
//		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//	}
//
//	public Customer findOne(int cid) {
//		
//		return this.getHibernateTemplate().get(Customer.class, cid);
//	}
//
//	public void delete(Customer c) {
//		this.getHibernateTemplate().delete(c);
//	}
//
//	public void update(Customer customer) {
//		this.getHibernateTemplate().update(customer);
//	}
	@SuppressWarnings("all")
	public int findCount() {	
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("select count(*) from Customer");
		if(list != null && list.size() != 0) {
			Object obj = list.get(0);
			Long lobj = (long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

    @SuppressWarnings("all")
	public List<Customer> findpage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
    @SuppressWarnings("all")
	public List<Customer> findCondition(Customer customer) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
//		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//		criteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
//		 List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
}
