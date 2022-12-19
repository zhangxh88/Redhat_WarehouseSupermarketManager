package com.redhat.mall.controller.system.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SystemUserUpdateReq {
	private String id;

	private String remark;
}
