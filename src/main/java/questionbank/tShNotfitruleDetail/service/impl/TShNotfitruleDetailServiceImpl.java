package questionbank.tShNotfitruleDetail.service.impl;
import questionbank.tShNotfitruleDetail.service.TShNotfitruleDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShNotfitruleDetail.entity.TShNotfitruleDetailEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("tShNotfitruleDetailService")
@Transactional
public class TShNotfitruleDetailServiceImpl extends CommonServiceImpl implements TShNotfitruleDetailServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(TShNotfitruleDetailEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShNotfitruleDetailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShNotfitruleDetailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}