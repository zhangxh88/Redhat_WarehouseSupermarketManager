package com.redhat.mall.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Base {
	private String id;

	private Date createTime;

	private String createUser;

	private Date updateTime;

	private String updateUser;
}
