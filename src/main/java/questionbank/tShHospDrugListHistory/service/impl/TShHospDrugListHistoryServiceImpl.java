package questionbank.tShHospDrugListHistory.service.impl;
import questionbank.tShHospDrugListHistory.service.TShHospDrugListHistoryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShHospDrugListHistory.entity.TShHospDrugListHistoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("tShHospDrugListHistoryService")
@Transactional
public class TShHospDrugListHistoryServiceImpl extends CommonServiceImpl implements TShHospDrugListHistoryServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(TShHospDrugListHistoryEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShHospDrugListHistoryEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShHospDrugListHistoryEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}