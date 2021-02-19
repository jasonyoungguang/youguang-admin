package com.youguang.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.youguang.admin.YouguangAdminApplication;
import com.youguang.admin.dto.DeptDTO;
import com.youguang.admin.service.IDeptService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YouguangAdminApplication.class)
class DeptServiceImplTest {
	
	@Autowired
	private IDeptService deptService;
	
	@Test
	void allDepts() {
		List<DeptDTO> deptDTOS = deptService.allDepts();
		System.out.println(JSON.toJSONString(deptDTOS));
	}
}