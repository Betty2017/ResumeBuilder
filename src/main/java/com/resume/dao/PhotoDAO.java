package com.resume.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Photo;
import com.resume.repository.PhotoRepository;

@Component
public class PhotoDAO implements IPhotoDAO {
	
	@Autowired
	private PhotoRepository photoRepo;
	
	/* (non-Javadoc)
	 * @see com.resume.dao.IPhotoDAO#saveImage(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public void saveImage(Photo photo ,MultipartFile imageFile) throws Exception {
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		photo.setPath(absolutePath + "/src/main/resources/static/photos/");
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(photo.getPath() + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		//personDAO.saveImage(imageFile);
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.resume.dao.IPhotoDAO#save(com.resume.model.Photo)
	 */
	@Override
	public void save(Photo photo) {
		photoRepo.save(photo);
		
	}
	
}
