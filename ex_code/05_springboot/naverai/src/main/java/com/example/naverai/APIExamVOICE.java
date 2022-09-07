package com.example.naverai;

//네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIExamVOICE {

 public static void main(String[] args) {
     String clientId = NaverInform.voice_id;//애플리케이션 클라이언트 아이디값";
     String clientSecret = NaverInform.voice_key;//애플리케이션 클라이언트 시크릿값";
     try {
    	 String text0 = "AI는 특정 형식이나 기능보다는 초강력 사고 및 데이터 분석을 위한 프로세스와 기능에 훨씬 더 가깝습니다. AI가 세상을 장악하고 있는 인간처럼 생긴 고기능 로봇의 이미지를 생각나게 하지만 AI는 인간을 대체하기 위한 것이 아닙니다. 이는 인간의 능력과 기여를 크게 향상시키기 위한 것입니다. AI는 매우 귀중한 비즈니스 자산입니다.";
         String text = URLEncoder.encode(text0, "UTF-8"); // 13자
         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
         // post request
         String postParams = "speaker=nara&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
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
             File f = new File(NaverInform.path + tempname + ".mp3");
             f.createNewFile();
             OutputStream outputStream = new FileOutputStream(f);
             while ((read =is.read(bytes)) != -1) {
                 outputStream.write(bytes, 0, read);
             }
             is.close();
             System.out.println("mp3로 변환 종료");
         } else {  // 오류 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
                 response.append(inputLine);
             }
             br.close();
             System.out.println(response.toString());
         }
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}
