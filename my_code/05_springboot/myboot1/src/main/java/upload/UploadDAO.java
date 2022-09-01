package upload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //매퍼객체로 사용하니 인식하라. 
@Repository("uploaddao") // new 객체 생성
public interface UploadDAO {
	
//	public int uploadFile(UploadDTO dto);
	public int uploadFile(HashMap<String, String> map);
	
	public List<Map<String,String>> outputName(String name);
}
