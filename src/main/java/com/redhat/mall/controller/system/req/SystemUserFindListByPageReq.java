package com.redhat.mall.controller.system.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SystemUserFindListByPageReq {
	private String username;

	private Integer pageIndex;

	private Integer pageSize;
}
