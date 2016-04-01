package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ShareDao;
import com.websystique.springmvc.model.Share;

@Service("shareService")
@Transactional
public class ShareServiceImpl implements ShareService {

	@Autowired
	private ShareDao dao;
	
	public Share findById(int id) {
		return dao.findById(id);
	}

	public void saveShare(Share share) {
		dao.saveShare(share);
	}
	
	
	public List<Share> findAllShares() {
		return dao.findAllShares();
	}

	
}
