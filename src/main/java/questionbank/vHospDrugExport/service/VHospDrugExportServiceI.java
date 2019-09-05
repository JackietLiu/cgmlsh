package questionbank.vHospDrugExport.service;
import questionbank.vHospDrugExport.entity.VHospDrugExportEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VHospDrugExportServiceI extends CommonService{
	
 	public void delete(VHospDrugExportEntity entity) throws Exception;
 	
 	public Serializable save(VHospDrugExportEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VHospDrugExportEntity entity) throws Exception;
 	
}
