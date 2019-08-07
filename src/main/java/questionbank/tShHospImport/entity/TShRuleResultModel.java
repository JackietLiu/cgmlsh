package questionbank.tShHospImport.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 医院导入列表
 * @author onlineGenerator
 * @date 2019-03-12 17:25:08
 * @version V1.0   
 *
 */
@Entity
@SuppressWarnings("serial")
public class TShRuleResultModel implements java.io.Serializable {
	/**医院编号*/
	private String rulename ;
	private Long thecount;
	private String resultclass;
	private String resultdesc;
	/**主键*/
	private String id;

	@Column(name ="rulename",nullable=true,length=40)
	public String getRulename() {
		return rulename;
	}

	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	@Column(name ="thecount",nullable=true,length=40)
	public Long getThecount() {
		return thecount;
	}

	public void setThecount(Long thecount) {
		this.thecount = thecount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}


	public String getResultclass() {
		return resultclass;
	}

	public void setResultclass(String resultclass) {
		this.resultclass = resultclass;
	}

	public String getResultdesc() {
		return resultdesc;
	}

	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}
}