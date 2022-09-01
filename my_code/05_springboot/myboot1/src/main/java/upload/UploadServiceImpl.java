package upload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("uploadservice")
public class UploadServiceImpl implements UploadService {

	@Autowired
//	@Qualifier("uplaoddao")
	@Qualifier("uploaddao")
	UploadDAO dao;
	
//	@Override
//	public int uploadFile(UploadDTO dto) {
//		return dao.uploadFile(dto);
//	}
	
	@Override
	public int uploadFile(HashMap<String, String> map) {
		return dao.uploadFile(map);
	}

	@Override
	public List<Map<String, String>> outputName(String name) {
		return  dao.outputName(name);
	}
	
	

}
