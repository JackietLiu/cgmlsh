package questionbank.tShHospImport.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class TShDrugInfoJsModel implements java.io.Serializable {
	/**医院编号*/
	private String hospname ;
	private Long drugcount;
	
	/**主键*/
	private String id;

	@Column(name ="hospname",nullable=true,length=40)
	public String getHospname() {
		return hospname;
	}

	public void setHospname(String hospname) {
		this.hospname = hospname;
	}

	@Column(name ="drugcount",nullable=true,length=40)
	public Long getDrugcount() {
		return drugcount;
	}

	public void setDrugcount(Long drugcount) {
		this.drugcount = drugcount;
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
}