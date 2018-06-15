/**
 * Created on 2017-02-14 17:05:01
 * Copyright SinoBest, 2010-2017, All rights reserved.
 */package com.rose.kafka.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Author liuzhikai
 * @Date 2017-02-14 17:05:01
 */
@Entity
@Table(name = "B_JWRQ_APPMENU")
public class B_JWRQ_APPMENU implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
/*    @GeneratedValue(generator = "systemid-uuid")
    @GenericGenerator(name = "systemid-uuid", strategy = "uuid.hex")*/
    @Column(length = 50)
    private String systemid;
	/** 组件服务ID */
    @Column(length = 50)
    private String menuid;
	/** 应用菜单名称 */
    @Column(length = 50)
    private String menuname;
	/** 所属系统，源于b_jwrq_sysmenu的systemid */
    @Column(length = 50)
    private String parentmenuid;
	/** 所属功能，源于s_framework_function的functionid */
    @Column(length = 50)
    private String functionid;
	/** 链接的目标地址 */
    @Column(length = 1000)
    private String target;
	/** 类型： 1工具类，2应用类，3待办任务类型，4工作提醒系统（kind=JWRQ_YYLX),5tab类型 ； 变更为ptyy普通应用，gj挂件，zdyyy自定义应用,zj组件 */
    @Column(length = 1)
    private String lx;
	/** 发布人 */
    @Column(length = 50)
    private String fbr;
	/** 发布人单位 */
    @Column(length = 50)
    private String fbrdw;
	/** 发布时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date fbsj;
	/** 是否启用 */
    @Column(length = 1)
    private String sffb;
	/** 应用描述 */
    @Column(length = 2000)
    private String ms;
	/** 发布范围 */
    @Column(length = 50)
    private String fbfw;
	/** 权限等级(kind=JWRQ_QXDJ) */
    @Column(length = 10)
    private String qxdj;
	/** 排序 */
     @Column(length = 6)
    private Integer sort;
	/** 安装次数 */
     @Column(length = 6)
    private Integer azcs;
	/** 评论次数 */
     @Column(length = 6)
    private Integer plcs;
	/** 好评次数 */
     @Column(length = 6)
    private Integer hpcs;
	/** 中评次数 */
     @Column(length = 6)
    private Integer zpcs;
	/** 差评次数 */
     @Column(length = 6)
    private Integer cpcs;
	/** 图标名称 */
    @Column(length = 50)
    private String tbmc;
	/** 工具栏的高度 */
    @Column(length = 5)
    private String height;
	/** 工具栏的宽度 */
    @Column(length = 5)
    private String width;
	/** 是否遮罩：1表示遮罩，0表示不用遮罩 */
    @Column(length = 2000)
    private String bz;
	/** 创建人 */
    @Column(length = 30)
    private String creator;
	/** 创建时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdtime;
	/** 创建人单位 */
    @Column(length = 50)
    private String createddept;
	/** 最后修改人 */
    @Column(length = 50)
    private String lastupdatedby;
	/** 最后修改时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastupdatedtime;
	/** 自定义应用所属用户 */
    @Column(length = 50)
    private String userid;
	/** 创建人部门编号 */
    @Column(length = 50)
    private String departmentcode;
	/** 删除标志 */
    @Column(length = 3)
    private String deleteflag;
	/** 备用字段 */
    @Column(length = 1000)
    private String iframsrc;
	/** 备用字段 */
    @Column(length = 100)
    private String menutype;
	/** 备用字段 */
    @Column(length = 100)
    private String isjweq;
	/** 备用字段 */
    @Column(length = 50)
    private String cdfid;
	/** 应用弹窗方式，0为内部窗口，1为IE窗口(kind=JWRQ_YYTCFS) */
    @Column(length = 1)
    private String isleaf;
	/** 版本号 */
    @Column(length = 50)
    private String bbh;
	/** 简介 */
    @Column(length = 255)
    private String jj;
	/** 是否可以评论(kind(00)) */
    @Column(length = 1)
    private String sfpl;
	/** 所属模块ID直接从属于系统时值为0 */
    @Column(length = 50)
    private String modoulid;
	/** 保留字段1 */
    @Column(length = 50)
    private String sys_reserver1;
	/** 保留字段2 */
    @Column(length = 50)
    private String sys_reserver2;
	/** 保留字段3 */
    @Column(length = 50)
    private String sys_reserver3;
	/** 保留字段4 */
    @Column(length = 50)
    private String sys_reserver4;
	/** 外部接口WEBSERVICE主键（源于S_MESSAGE_TYPE_OUTER表） */
    @Column(length = 50)
    private String s_message_type_outer_id;
	/** 是否自适应 */
    @Column(length = 1)
    private String sfzsy;
	/** 授权范围，由管理员手工录入 */
    @Column(length = 100)
    private String sqfw;
	/** 联系电话 */
    @Column(length = 50)
    private String lxdh;
	/** 开发商 */
    @Column(length = 200)
    private String kfs;
	/** 传统菜单打开方式,01为iframe方式，02为IE弹窗方式，kind=JWRQ_CTCDDKFS */
    @Column(length = 2)
    private String ctcddkfs;
	/** 所属警钟(kind=JWRQ_YYSSJZ) */
    @Column(length = 50)
    private String ssjz;
	/** 所属地区(kind=JWRQ_YYSSDQ) */
    @Column(length = 50)
    private String ssdq;
	/** 所属业务(kind=JWRQ_YYSSYW) */
    @Column(length = 50)
    private String ssyw;
	/** 承建单位(kind=06) */
    @Column(length = 50)
    private String cjdw;
	/** 承建单位联系人 */
    @Column(length = 50)
    private String cjdwlxr;
	/** 承建单位联系电话 */
    @Column(length = 50)
    private String cjdwlxdh;
	/** 开发单位(源于b_jwrq_kfgs表的主键) */
    @Column(length = 50)
    private String kfdw;
	/** 开发单位联系人（源于b_jwrq_kfrr的主键） */
    @Column(length = 50)
    private String kfdwlxr;
	/** 开发单位联系电话 */
    @Column(length = 50)
    private String kfdwlxdh;
    /** 数据集成方式*/
    @Column(length = 2)
    private String sjjcfs;
    /** 应用服务器IP */
    @Column(length = 100)
    private String yyfwqip;
    /** 应用数据库服务器IP*/
    @Column(length = 200)
    private String sjkfwqip;


    /** 应用创建方式 0内部创建 1外部接入（KIND=B_JWRQ_YYCJFS） */
    @Column(length = 1)
    private String yycjfs;
	/** 审批意见 */
    @Column(length = 512)
    private String spyj;
	/** 最后审批人 */
    @Column(length = 50)
    private String zhspr;
    /** 审批状态 0待审批 1审批通过 2审批不通过（KIND=B_JWRQ_YYSPZT） */
    @Column(length = 2)
    private String spzt;
    /** 所属应用 */
    @Column(length = 50)
    private String ssyy;
    /** 界面组件专用字段*/
    @Column(length = 5)
    private  String jmzj_size;
//    界面组件类别
    @Column(length = 5)
    private  String jmzjlb;
    /** 所属地区(kind=JWRQ_YYSSDQ) */
    @Column(length = 50)
    private String szgjlb;
    @Column(length=50)
    private String yykfyy; //应用开发语言

    @Column(length=50)
    private String yykfyybb; //应用开发语言版本
	public B_JWRQ_APPMENU() {
	}


    public String getJmzj_size() {
        return jmzj_size;
    }

    public void setJmzj_size(String jmzj_size) {
        this.jmzj_size = jmzj_size;
    }

    /**
         * @param systemid the systemid to set
         */
		public void setSystemid(String value) {
			this.systemid = value;
		}

        /**
         * @return the systemid
         */
		public String getSystemid() {
			return this.systemid;
		}

        /**
         * @param menuid the menuid to set
         */
		public void setMenuid(String value) {
			this.menuid = value;
		}

        /**
         * @return the menuid
         */
		public String getMenuid() {
			return this.menuid;
		}

        /**
         * @param menuname the menuname to set
         */
		public void setMenuname(String value) {
			this.menuname = value;
		}

        /**
         * @return the menuname
         */
		public String getMenuname() {
			return this.menuname;
		}

        /**
         * @param parentmenuid the parentmenuid to set
         */
		public void setParentmenuid(String value) {
			this.parentmenuid = value;
		}

        /**
         * @return the parentmenuid
         */
		public String getParentmenuid() {
			return this.parentmenuid;
		}

        /**
         * @param functionid the functionid to set
         */
		public void setFunctionid(String value) {
			this.functionid = value;
		}

        /**
         * @return the functionid
         */
		public String getFunctionid() {
			return this.functionid;
		}

        /**
         * @param target the target to set
         */
		public void setTarget(String value) {
			this.target = value;
		}

        /**
         * @return the target
         */
		public String getTarget() {
			return this.target;
		}

        /**
         * @param lx the lx to set
         */
		public void setLx(String value) {
			this.lx = value;
		}

        /**
         * @return the lx
         */
		public String getLx() {
			return this.lx;
		}

        /**
         * @param fbr the fbr to set
         */
		public void setFbr(String value) {
			this.fbr = value;
		}

        /**
         * @return the fbr
         */
		public String getFbr() {
			return this.fbr;
		}

        /**
         * @param fbrdw the fbrdw to set
         */
		public void setFbrdw(String value) {
			this.fbrdw = value;
		}

        /**
         * @return the fbrdw
         */
		public String getFbrdw() {
			return this.fbrdw;
		}

        /**
         * @param fbsj the fbsj to set
         */
		public void setFbsj(Date value) {
			this.fbsj = value;
		}

        /**
         * @return the fbsj
         */
		public Date getFbsj() {
			return this.fbsj;
		}

        /**
         * @param sffb the sffb to set
         */
		public void setSffb(String value) {
			this.sffb = value;
		}

        /**
         * @return the sffb
         */
		public String getSffb() {
			return this.sffb;
		}

        /**
         * @param ms the ms to set
         */
		public void setMs(String value) {
			this.ms = value;
		}

        /**
         * @return the ms
         */
		public String getMs() {
			return this.ms;
		}

        /**
         * @param fbfw the fbfw to set
         */
		public void setFbfw(String value) {
			this.fbfw = value;
		}

        /**
         * @return the fbfw
         */
		public String getFbfw() {
			return this.fbfw;
		}

        /**
         * @param qxdj the qxdj to set
         */
		public void setQxdj(String value) {
			this.qxdj = value;
		}

        /**
         * @return the qxdj
         */
		public String getQxdj() {
			return this.qxdj;
		}

        /**
         * @param sort the sort to set
         */
		public void setSort(Integer value) {
			this.sort = value;
		}

        /**
         * @return the sort
         */
		public Integer getSort() {
			return this.sort;
		}

        /**
         * @param azcs the azcs to set
         */
		public void setAzcs(Integer value) {
			this.azcs = value;
		}

        /**
         * @return the azcs
         */
		public Integer getAzcs() {
			return this.azcs;
		}

        /**
         * @param plcs the plcs to set
         */
		public void setPlcs(Integer value) {
			this.plcs = value;
		}

        /**
         * @return the plcs
         */
		public Integer getPlcs() {
			return this.plcs;
		}

        /**
         * @param hpcs the hpcs to set
         */
		public void setHpcs(Integer value) {
			this.hpcs = value;
		}

        /**
         * @return the hpcs
         */
		public Integer getHpcs() {
			return this.hpcs;
		}

        /**
         * @param zpcs the zpcs to set
         */
		public void setZpcs(Integer value) {
			this.zpcs = value;
		}

        /**
         * @return the zpcs
         */
		public Integer getZpcs() {
			return this.zpcs;
		}

        /**
         * @param cpcs the cpcs to set
         */
		public void setCpcs(Integer value) {
			this.cpcs = value;
		}

        /**
         * @return the cpcs
         */
		public Integer getCpcs() {
			return this.cpcs;
		}

        /**
         * @param tbmc the tbmc to set
         */
		public void setTbmc(String value) {
			this.tbmc = value;
		}

        /**
         * @return the tbmc
         */
		public String getTbmc() {
			return this.tbmc;
		}

        /**
         * @param height the height to set
         */
		public void setHeight(String value) {
			this.height = value;
		}

        /**
         * @return the height
         */
		public String getHeight() {
			return this.height;
		}

        /**
         * @param width the width to set
         */
		public void setWidth(String value) {
			this.width = value;
		}

        /**
         * @return the width
         */
		public String getWidth() {
			return this.width;
		}

        /**
         * @param bz the bz to set
         */
		public void setBz(String value) {
			this.bz = value;
		}

        /**
         * @return the bz
         */
		public String getBz() {
			return this.bz;
		}

        /**
         * @param creator the creator to set
         */
		public void setCreator(String value) {
			this.creator = value;
		}

        /**
         * @return the creator
         */
		public String getCreator() {
			return this.creator;
		}

        /**
         * @param createdtime the createdtime to set
         */
		public void setCreatedtime(Date value) {
			this.createdtime = value;
		}

        /**
         * @return the createdtime
         */
		public Date getCreatedtime() {
			return this.createdtime;
		}

        /**
         * @param createddept the createddept to set
         */
		public void setCreateddept(String value) {
			this.createddept = value;
		}

        /**
         * @return the createddept
         */
		public String getCreateddept() {
			return this.createddept;
		}

        /**
         * @param lastupdatedby the lastupdatedby to set
         */
		public void setLastupdatedby(String value) {
			this.lastupdatedby = value;
		}

        /**
         * @return the lastupdatedby
         */
		public String getLastupdatedby() {
			return this.lastupdatedby;
		}

        /**
         * @param lastupdatedtime the lastupdatedtime to set
         */
		public void setLastupdatedtime(Date value) {
			this.lastupdatedtime = value;
		}

        /**
         * @return the lastupdatedtime
         */
		public Date getLastupdatedtime() {
			return this.lastupdatedtime;
		}

        /**
         * @param userid the userid to set
         */
		public void setUserid(String value) {
			this.userid = value;
		}

        /**
         * @return the userid
         */
		public String getUserid() {
			return this.userid;
		}

        /**
         * @param departmentcode the departmentcode to set
         */
		public void setDepartmentcode(String value) {
			this.departmentcode = value;
		}

        /**
         * @return the departmentcode
         */
		public String getDepartmentcode() {
			return this.departmentcode;
		}

        /**
         * @param deleteflag the deleteflag to set
         */
		public void setDeleteflag(String value) {
			this.deleteflag = value;
		}

        /**
         * @return the deleteflag
         */
		public String getDeleteflag() {
			return this.deleteflag;
		}

        /**
         * @param iframsrc the iframsrc to set
         */
		public void setIframsrc(String value) {
			this.iframsrc = value;
		}

        /**
         * @return the iframsrc
         */
		public String getIframsrc() {
			return this.iframsrc;
		}

        /**
         * @param menutype the menutype to set
         */
		public void setMenutype(String value) {
			this.menutype = value;
		}

        /**
         * @return the menutype
         */
		public String getMenutype() {
			return this.menutype;
		}

        /**
         * @param isjweq the isjweq to set
         */
		public void setIsjweq(String value) {
			this.isjweq = value;
		}

        /**
         * @return the isjweq
         */
		public String getIsjweq() {
			return this.isjweq;
		}

        /**
         * @param cdfid the cdfid to set
         */
		public void setCdfid(String value) {
			this.cdfid = value;
		}

        /**
         * @return the cdfid
         */
		public String getCdfid() {
			return this.cdfid;
		}

        /**
         * @param isleaf the isleaf to set
         */
		public void setIsleaf(String value) {
			this.isleaf = value;
		}

        /**
         * @return the isleaf
         */
		public String getIsleaf() {
			return this.isleaf;
		}

        /**
         * @param bbh the bbh to set
         */
		public void setBbh(String value) {
			this.bbh = value;
		}

        /**
         * @return the bbh
         */
		public String getBbh() {
			return this.bbh;
		}

        /**
         * @param jj the jj to set
         */
		public void setJj(String value) {
			this.jj = value;
		}

        /**
         * @return the jj
         */
		public String getJj() {
			return this.jj;
		}

        /**
         * @param sfpl the sfpl to set
         */
		public void setSfpl(String value) {
			this.sfpl = value;
		}

        /**
         * @return the sfpl
         */
		public String getSfpl() {
			return this.sfpl;
		}

        /**
         * @param modoulid the modoulid to set
         */
		public void setModoulid(String value) {
			this.modoulid = value;
		}

        /**
         * @return the modoulid
         */
		public String getModoulid() {
			return this.modoulid;
		}

        /**
         * @param sys_reserver1 the sys_reserver1 to set
         */
		public void setSys_reserver1(String value) {
			this.sys_reserver1 = value;
		}

        /**
         * @return the sys_reserver1
         */
		public String getSys_reserver1() {
			return this.sys_reserver1;
		}

        /**
         * @param sys_reserver2 the sys_reserver2 to set
         */
		public void setSys_reserver2(String value) {
			this.sys_reserver2 = value;
		}

        /**
         * @return the sys_reserver2
         */
		public String getSys_reserver2() {
			return this.sys_reserver2;
		}

        /**
         * @param sys_reserver3 the sys_reserver3 to set
         */
		public void setSys_reserver3(String value) {
			this.sys_reserver3 = value;
		}

        /**
         * @return the sys_reserver3
         */
		public String getSys_reserver3() {
			return this.sys_reserver3;
		}

        /**
         * @param sys_reserver4 the sys_reserver4 to set
         */
		public void setSys_reserver4(String value) {
			this.sys_reserver4 = value;
		}

        /**
         * @return the sys_reserver4
         */
		public String getSys_reserver4() {
			return this.sys_reserver4;
		}

        /**
         * @param s_message_type_outer_id the s_message_type_outer_id to set
         */
		public void setS_message_type_outer_id(String value) {
			this.s_message_type_outer_id = value;
		}

        /**
         * @return the s_message_type_outer_id
         */
		public String getS_message_type_outer_id() {
			return this.s_message_type_outer_id;
		}

        /**
         * @param sfzsy the sfzsy to set
         */
		public void setSfzsy(String value) {
			this.sfzsy = value;
		}

        /**
         * @return the sfzsy
         */
		public String getSfzsy() {
			return this.sfzsy;
		}

        /**
         * @param sqfw the sqfw to set
         */
		public void setSqfw(String value) {
			this.sqfw = value;
		}

        /**
         * @return the sqfw
         */
		public String getSqfw() {
			return this.sqfw;
		}

        /**
         * @param lxdh the lxdh to set
         */
		public void setLxdh(String value) {
			this.lxdh = value;
		}

        /**
         * @return the lxdh
         */
		public String getLxdh() {
			return this.lxdh;
		}

        /**
         * @param kfs the kfs to set
         */
		public void setKfs(String value) {
			this.kfs = value;
		}

        /**
         * @return the kfs
         */
		public String getKfs() {
			return this.kfs;
		}

        /**
         * @param ctcddkfs the ctcddkfs to set
         */
		public void setCtcddkfs(String value) {
			this.ctcddkfs = value;
		}

        /**
         * @return the ctcddkfs
         */
		public String getCtcddkfs() {
			return this.ctcddkfs;
		}

        /**
         * @param ssjz the ssjz to set
         */
		public void setSsjz(String value) {
			this.ssjz = value;
		}

        /**
         * @return the ssjz
         */
		public String getSsjz() {
			return this.ssjz;
		}

        /**
         * @param ssdq the ssdq to set
         */
		public void setSsdq(String value) {
			this.ssdq = value;
		}

        /**
         * @return the ssdq
         */
		public String getSsdq() {
			return this.ssdq;
		}

        /**
         * @param ssyw the ssyw to set
         */
		public void setSsyw(String value) {
			this.ssyw = value;
		}

        /**
         * @return the ssyw
         */
		public String getSsyw() {
			return this.ssyw;
		}

        /**
         * @param cjdw the cjdw to set
         */
		public void setCjdw(String value) {
			this.cjdw = value;
		}

        /**
         * @return the cjdw
         */
		public String getCjdw() {
			return this.cjdw;
		}

        /**
         * @param cjdwlxr the cjdwlxr to set
         */
		public void setCjdwlxr(String value) {
			this.cjdwlxr = value;
		}

        /**
         * @return the cjdwlxr
         */
		public String getCjdwlxr() {
			return this.cjdwlxr;
		}

        /**
         * @param cjdwlxdh the cjdwlxdh to set
         */
		public void setCjdwlxdh(String value) {
			this.cjdwlxdh = value;
		}

        /**
         * @return the cjdwlxdh
         */
		public String getCjdwlxdh() {
			return this.cjdwlxdh;
		}

        /**
         * @param kfdw the kfdw to set
         */
		public void setKfdw(String value) {
			this.kfdw = value;
		}

        /**
         * @return the kfdw
         */
		public String getKfdw() {
			return this.kfdw;
		}

        /**
         * @param kfdwlxr the kfdwlxr to set
         */
		public void setKfdwlxr(String value) {
			this.kfdwlxr = value;
		}

        /**
         * @return the kfdwlxr
         */
		public String getKfdwlxr() {
			return this.kfdwlxr;
		}

        /**
         * @param kfdwlxdh the kfdwlxdh to set
         */
		public void setKfdwlxdh(String value) {
			this.kfdwlxdh = value;
		}

        /**
         * @return the kfdwlxdh
         */
		public String getKfdwlxdh() {
			return this.kfdwlxdh;
		}



        public String getYycjfs() {
			return yycjfs;
		}


		public void setYycjfs(String yycjfs) {
			this.yycjfs = yycjfs;
		}


		public String getSpzt() {
			return spzt;
		}


		public void setSpzt(String spzt) {
			this.spzt = spzt;
		}


		/**
         * @param spyj the spyj to set
         */
		public void setSpyj(String value) {
			this.spyj = value;
		}

        /**
         * @return the spyj
         */
		public String getSpyj() {
			return this.spyj;
		}

        /**
         * @param zhspr the zhspr to set
         */
		public void setZhspr(String value) {
			this.zhspr = value;
		}

        /**
         * @return the zhspr
         */
		public String getZhspr() {
			return this.zhspr;
		}


		public String getSjjcfs() {
			return sjjcfs;
		}


		public void setSjjcfs(String sjjcfs) {
			this.sjjcfs = sjjcfs;
		}


		public String getYyfwqip() {
			return yyfwqip;
		}


		public void setYyfwqip(String yyfwqip) {
			this.yyfwqip = yyfwqip;
		}


		public String getSjkfwqip() {
			return sjkfwqip;
		}


		public void setSjkfwqip(String sjkfwqip) {
			this.sjkfwqip = sjkfwqip;
		}


		public String getSsyy() {
			return ssyy;
		}


    public void setSsyy(String ssyy) {
        this.ssyy = ssyy;
    }

    public String getSzgjlb() {
        return szgjlb;
    }

    public void setSzgjlb(String szgjlb) {
        this.szgjlb = szgjlb;
    }

    public String getJmzjlb() {
        return jmzjlb;
    }

    public void setJmzjlb(String jmzjlb) {
        this.jmzjlb = jmzjlb;
    }

    public String getYykfyy() {
        return yykfyy;
    }

    public void setYykfyy(String yykfyy) {
        this.yykfyy = yykfyy;
    }

    public String getYykfyybb() {
        return yykfyybb;
    }

    public void setYykfyybb(String yykfyybb) {
        this.yykfyybb = yykfyybb;
    }

}

