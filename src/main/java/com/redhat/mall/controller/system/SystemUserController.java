package com.redhat.mall.controller.system;

import com.redhat.mall.common.bean.CommonResult;
import com.redhat.mall.common.utils.CommonUtil;
import com.redhat.mall.controller.system.req.SystemUserDeleteByIdReq;
import com.redhat.mall.controller.system.req.SystemUserFindAllListReq;
import com.redhat.mall.controller.system.req.SystemUserFindByIdReq;
import com.redhat.mall.controller.system.req.SystemUserFindListByPageReq;
import com.redhat.mall.controller.system.req.SystemUserSaveReq;
import com.redhat.mall.controller.system.req.SystemUserUpdateReq;
import com.redhat.mall.controller.system.resp.SystemUserResp;
import com.redhat.mall.domain.SystemUser;
import com.redhat.mall.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 系统管理-用户管理
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
	@Autowired
	private SystemUserService systemUserService;
	
	@RequestMapping(value = "findById", method = RequestMethod.POST)
	public CommonResult<SystemUserResp> findById(@RequestBody SystemUserFindByIdReq req,
												 HttpServletRequest request,
												 HttpServletResponse response) throws Exception {
		CommonResult<SystemUserResp> result = new CommonResult<SystemUserResp>();
		result.setData(systemUserService.findById(req.getId()));
		return result;
	}

	@RequestMapping(value = "findAllList", method = RequestMethod.POST)
	public CommonResult<List<SystemUserResp>> findAllList(@RequestBody SystemUserFindAllListReq req,
													   HttpServletRequest request,
													   HttpServletResponse response) throws Exception {
		CommonResult<List<SystemUserResp>> result = new CommonResult<List<SystemUserResp>>();
		result.setData(systemUserService.findAllList(CommonUtil.convertObjToMap(req)));
		return result;
	}

	@RequestMapping(value = "findListByPage", method = RequestMethod.POST)
	public CommonResult<List<SystemUserResp>> findListByPage(@RequestBody SystemUserFindListByPageReq req,
														  HttpServletRequest request,
														  HttpServletResponse response) throws Exception {
		CommonResult<List<SystemUserResp>> result = new CommonResult<List<SystemUserResp>>();
		Map<String, Object> paramMap = CommonUtil.convertObjToMap(req);
		result.setTotal(systemUserService.count(paramMap));
		result.setData(systemUserService.findListByPage(paramMap));
		return result;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public CommonResult<Void> save(@RequestBody SystemUserSaveReq req,
								   HttpServletRequest request,
								   HttpServletResponse response) throws Exception {
		SystemUser systemUser = new SystemUser();
		CommonUtil.copyProperties(req, systemUser);
		systemUserService.save(systemUser);
		return new CommonResult<Void>();
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public CommonResult<Void> update(@RequestBody SystemUserUpdateReq req,
								   HttpServletRequest request,
								   HttpServletResponse response) throws Exception {
		SystemUser systemUser = new SystemUser();
		CommonUtil.copyProperties(req, systemUser);
		systemUserService.update(systemUser);
		return new CommonResult<Void>();
	}

	@RequestMapping(value = "deleteById", method = RequestMethod.POST)
	public CommonResult<Void> deleteById(@RequestBody SystemUserDeleteByIdReq req,
									 HttpServletRequest request,
									 HttpServletResponse response) throws Exception {
		systemUserService.deleteById(req.getId());
		return new CommonResult<Void>();
	}
}
