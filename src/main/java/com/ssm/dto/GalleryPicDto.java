package com.ssm.dto;

import org.springframework.web.multipart.MultipartFile;

public class GalleryPicDto {
	private int category;
	private MultipartFile galleryPic;
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public MultipartFile getGalleryPic() {
		return galleryPic;
	}
	public void setGalleryPic(MultipartFile galleryPic) {
		this.galleryPic = galleryPic;
	}
	
	
	
}
