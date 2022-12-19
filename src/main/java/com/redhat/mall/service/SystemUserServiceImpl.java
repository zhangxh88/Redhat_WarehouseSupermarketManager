package com.redhat.mall.service;

import com.redhat.mall.common.constants.Constants;
import com.redhat.mall.common.utils.CommonUtil;
import com.redhat.mall.controller.system.resp.SystemUserResp;
import com.redhat.mall.dao.SystemUserMapper;
import com.redhat.mall.domain.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SystemUserServiceImpl implements SystemUserService {
	@Autowired
	private SystemUserMapper systemUserMapper;

	@Override
	public SystemUserResp findById(String id) {
		return systemUserMapper.findById(id);
	}

	@Override
	public List<SystemUserResp> findAllList(Map<String, Object> paramMap) {
		return systemUserMapper.findAllList(paramMap);
	}

	@Override
	public long count(Map<String, Object> paramMap) {
		return systemUserMapper.count(paramMap);
	}

	@Override
	public List<SystemUserResp> findListByPage(Map<String, Object> paramMap) {
		return systemUserMapper.findListByPage(paramMap);
	}

	@Transactional
	@Override
	public void save(SystemUser systemUser) {
		CommonUtil.wrapSaveObj(systemUser);
		systemUser.setStatus(Constants.Status.ENABLE);
		systemUserMapper.save(systemUser);
	}

	@Transactional
	@Override
	public void update(SystemUser systemUser) {
		CommonUtil.wrapUpdateObj(systemUser);
		systemUserMapper.update(systemUser);
	}

	@Transactional
	@Override
	public void deleteById(String id) {
		systemUserMapper.deleteById(id);
	}
}
