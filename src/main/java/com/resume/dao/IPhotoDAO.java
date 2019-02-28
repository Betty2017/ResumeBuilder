package com.resume.dao;

import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Photo;

public interface IPhotoDAO {

	void save(Photo photo);

	void saveImage(Photo photo, MultipartFile imageFile) throws Exception;

}