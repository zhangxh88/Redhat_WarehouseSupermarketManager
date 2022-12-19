package com.redhat.mall.service;

import com.redhat.mall.controller.system.resp.SystemUserResp;
import com.redhat.mall.domain.SystemUser;

import java.util.List;
import java.util.Map;

public interface SystemUserService {
    public SystemUserResp findById(String id);

    public List<SystemUserResp> findAllList(Map<String, Object> paramMap);

    public long count(Map<String, Object> paramMap);

    public List<SystemUserResp> findListByPage(Map<String, Object> paramMap);

    public void save(SystemUser systemUser);

    public void update(SystemUser systemUser);

    public void deleteById(String id);
}
