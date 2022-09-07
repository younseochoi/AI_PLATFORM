package voice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Service("voiceservice")
public class VoiceService implements NaverService {

	@Override
	public String test(String image) { //text입력하면 mp3 리턴
		return test(image,"nara");
	}
	
	public String test(String image,String speaker) { //image 텍스트파일 
		  String mp3 ="";
		  String clientId = NaverInform.voice_id;//애플리케이션 클라이언트 아이디값";
		     String clientSecret =NaverInform.voice_key;//애플리케이션 클라이언트 시크릿값";
		     try {
		         String text =""; // 13자
		         text = "";
		         FileReader fr = new FileReader(NaverInform.path+image);
		         Scanner sc= new Scanner(fr);
		         while(sc.hasNextLine()) {
		        	text += sc.nextLine();
		         }
		         text = URLEncoder.encode(text, "UTF-8"); 
		         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
		         URL url = new URL(apiURL);
		         HttpURLConnection con = (HttpURLConnection)url.openConnection();
		         con.setRequestMethod("POST");
		         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
		         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
		         // post request
		         String postParams = "speaker="+speaker+"&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
		         con.setDoOutput(true);
		         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		         wr.writeBytes(postParams);
		         wr.flush();
		         wr.close();
		         int responseCode = con.getResponseCode();
		         BufferedReader br;
		         if(responseCode==200) { // 정상 호출
		             InputStream is = con.getInputStream();
		             int read = 0;
		             byte[] bytes = new byte[1024];
		             // 현재시각으로 mp3 파일 생성
		             SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		             String tempname = sdf.format(new Date());
		             //String tempname = Long.valueOf(new Date().getTime()).toString();
		             
		             File f = new File(NaverInform.path+tempname + ".mp3");
		             mp3 = tempname+".mp3";
		             f.createNewFile();
		             OutputStream outputStream = new FileOutputStream(f);
		             while ((read =is.read(bytes)) != -1) {
		                 outputStream.write(bytes, 0, read);
		             }
		             is.close();
		         } else {  // 오류 발생
		             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		             String inputLine;
		             StringBuffer response = new StringBuffer();
		             while ((inputLine = br.readLine()) != null) {
		                 response.append(inputLine);
		             }
		             br.close();
		             System.out.println("mp3로 변환 완료되었습니다.");
		             System.out.println(response.toString());
		         }
		     } catch (Exception e) {
		         System.out.println(e);
		     }
		return mp3;
	}
	
}
