package com.hopline.WebApp.model.vo;
// default package
// Generated 3 Jan, 2017 4:42:03 PM by Hibernate Tools 5.2.0.Beta1

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hopline.WebApp.model.dao.AddOn;
import com.hopline.WebApp.model.dao.Product;

/**
 * AddonGroup generated by hbm2java
 */
public class AddonGroupVo implements java.io.Serializable {

	private Integer idaddonGroup;
	private String name;
	private String desc;
	private String radioYn;
	private Integer minSelect;
	private List<AddOnVo> addOns;

	public AddonGroupVo() {
	}

	public AddonGroupVo(String radioYn) {
		this.radioYn = radioYn;
	}

	public AddonGroupVo(String name, String desc, String radioYn, Integer minSelect, List<AddOnVo> addOns) {
		this.name = name;
		this.desc = desc;
		this.radioYn = radioYn;
		this.minSelect = minSelect;
		this.addOns = addOns;
	}

	public Integer getIdaddonGroup() {
		return this.idaddonGroup;
	}

	public void setIdaddonGroup(Integer idaddonGroup) {
		this.idaddonGroup = idaddonGroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRadioYn() {
		return this.radioYn;
	}

	public void setRadioYn(String radioYn) {
		this.radioYn = radioYn;
	}

	public Integer getMinSelect() {
		return this.minSelect;
	}

	public void setMinSelect(Integer minSelect) {
		this.minSelect = minSelect;
	}

	public List<AddOnVo> getAddOns() {
		return this.addOns;
	}

	public void setAddOns(List<AddOnVo> addOns) {
		this.addOns = addOns;
	}


}
