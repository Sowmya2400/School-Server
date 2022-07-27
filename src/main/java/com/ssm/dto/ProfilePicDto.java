package com.ssm.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePicDto {
	private int admnNo;
	private MultipartFile profilePic;  //File Type
	public int getAdmnNo() {
		return admnNo;
	}
	public void setAdmnNo(int admnNo) {
		this.admnNo = admnNo;
	}
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
	

}
