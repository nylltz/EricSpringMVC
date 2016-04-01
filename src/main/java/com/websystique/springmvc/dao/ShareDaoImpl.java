package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Share;

@Repository("shareDao")
public class ShareDaoImpl extends AbstractDao<Integer, Share> implements ShareDao {

	public Share findById(int id) {
		return getByKey(id);
	}

	public void saveShare(Share share) {
		persist(share);
	}

	@SuppressWarnings("unchecked")
	public List<Share> findAllShares() {
		Criteria criteria = createEntityCriteria();
		return (List<Share>) criteria.list();
	}


}
