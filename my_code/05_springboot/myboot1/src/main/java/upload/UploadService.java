package upload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UploadService {
	//public int uploadFile(UploadDTO dto);
	public int uploadFile(HashMap<String, String> map);
	public List<Map<String, String>> outputName(String name);
}
