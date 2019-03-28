package com.jeecg.tShDrugValueInfoNew.service;
import com.jeecg.tShDrugValueInfoNew.entity.TShDrugValueInfoNewEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugValueInfoNewServiceI extends CommonService{
	
 	public void delete(TShDrugValueInfoNewEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugValueInfoNewEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugValueInfoNewEntity entity) throws Exception;
 	
}
