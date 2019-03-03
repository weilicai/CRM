package cn.itcast.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.VisitDao;
@Transactional
public class VisitService {
	private VisitDao visitDao;
}
