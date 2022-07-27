package com.ssm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ssm_gallery")
public class Gallery {
	
	@Id
	@SequenceGenerator(name="gid_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gid_seq")
	private int gid;
	
	private int category;
	private String image;
	
	public Gallery() {
		super();
	}

	public Gallery(int category, String image) {
		super();
		this.category = category;
		this.image = image;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Gallery [gid=" + gid + ", category=" + category + ", image=" + image + "]";
	}
	
	
	
	
	
}
