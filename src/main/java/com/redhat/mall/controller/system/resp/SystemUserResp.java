package com.redhat.mall.controller.system.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SystemUserResp {
	private String id;

	private String username;

	private Integer status;

	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date createTime;

	private String createUser;

	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date updateTime;

	private String updateUser;

	private String remark;
}
