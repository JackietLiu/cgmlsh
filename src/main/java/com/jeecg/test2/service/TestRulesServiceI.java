package com.jeecg.test2.service;
import com.jeecg.test2.entity.TestRulesEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TestRulesServiceI extends CommonService{
	
 	public void delete(TestRulesEntity entity) throws Exception;
 	
 	public Serializable save(TestRulesEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TestRulesEntity entity) throws Exception;
 	
}
