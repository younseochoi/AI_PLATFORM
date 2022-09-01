package upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uploadservice1")
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	UploadDAO dao;
	
	@Override
	public int register(UploadDTO dto) {
		//업로드정책 변경- 같은 사용자가 업로드x 
		//dao.selectName(dto);
	 	return dao.insertUpload(dto);
	}

}

/*@Service("uploadservice2")
 * public class UploadServiceImpl2 implements UploadService {
 
	
	@Autowired
	UploadDAO dao;
	
	@Override
	public int register(UploadDTO dto) {
		//업로드정책 변경- 같은 사용자가 업로드x 
		dao.selectName(dto);
		if(){
	 	return dao.insertUpload(dto);
	 	}
	}

}
*/