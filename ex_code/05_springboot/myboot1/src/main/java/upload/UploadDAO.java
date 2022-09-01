package upload;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //매퍼객체 사용 인식
@Repository("uploaddao") //new 객체생성
public interface UploadDAO {
	public int insertUpload(UploadDTO dto);
	
}
