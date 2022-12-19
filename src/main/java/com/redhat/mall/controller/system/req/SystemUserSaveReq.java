package com.redhat.mall.controller.system.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SystemUserSaveReq {
	private String username;

	private String password;

	private String remark;
}
