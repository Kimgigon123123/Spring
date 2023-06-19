package smart.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import smart.member.MemberVO;

@Service
public class CommonUtility {

	private void emailServerConnect(HtmlEmail email) {
		email.setHostName("smtp.naver.com"); //메일서버지정
		email.setAuthentication("kgg990321", "비밀번호"); //아이디/비번 으로 로그인
		email.setSSLOnConnect(true); // 로그인버튼 클릭
	}
	private String EMAIL_ADDRESS = "kgg990321@naver.com";
	
	// 이메일 보내기
	public boolean sendPassword(MemberVO vo, String pw) {
		boolean send = true;
		HtmlEmail email = new HtmlEmail();
		email.setCharset("utf-8");
		email.setDebug(true);  //이메일전송 과정 Console에서 로그로 확인
		
		emailServerConnect(email);
		try {
			email.setFrom( EMAIL_ADDRESS, "스마트 웹&앱 관리자 "); //관리자가 보내는이
			email.addTo( vo.getEmail(), vo.getName() );  // 받는사람 지정
			//email.addTo("박문수") // 받는사람 지정
			
			email.setSubject("스마트 웹&앱 로그인 임시 비밀번호");  // 제목쓰기
			
			StringBuffer content = new StringBuffer();
//			content.append("<h3>임시 비밀번호가 발급되었습니다</h3>");
			content.append("<h3>[").append( vo.getName() ).append("]님 임시 비밀번호가 발급되었습니다</h3>");
			content.append("<div>아이디: ").append( vo.getUserid() ) .append("</div>");
			content.append("<div>임시 비밀번호: <strong>").append( pw ).append("</strong></div>");
			content.append("<div>발급된 임시 비밀번호로 로그인한 후 비밀번호를 변경하세요</div>");
			email.setHtmlMsg(content.toString()); // 내용쓰기
			email.send();//보내기버튼클릭(전송)
			
			
		}catch(Exception e) {
			send=false;
		}
		return send;
	}
	
	
	//API 요청
			public String requestAPI(String apiURL,String property) {
				String response="";
				 try {
				      URL url = new URL(apiURL);
				      HttpURLConnection con = (HttpURLConnection)url.openConnection();
				      con.setRequestMethod("GET");
				    //Authorization: {토큰타입]{접근토큰]
				      con.setRequestProperty("Authorization", property);
				      int responseCode = con.getResponseCode();
				      BufferedReader br;
				      System.out.print("responseCode="+responseCode);
				      if(responseCode==200) { // 정상 호출
				        br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
				      } else {  // 에러 발생
				        br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
				      }
				      String inputLine;
				      StringBuffer res = new StringBuffer();
				      while ((inputLine = br.readLine()) != null) {
				        res.append(inputLine);
				      }
				      br.close();
				      response = res.toString();
				    } catch (Exception e) {
				      System.out.println(e);
				    }
				 
				 return response;
				 
			}
	
	//API 요청
		public String requestAPI(String apiURL) {
			String response="";
			 try {
			      URL url = new URL(apiURL);
			      HttpURLConnection con = (HttpURLConnection)url.openConnection();
			      con.setRequestMethod("GET");
			      
			      int responseCode = con.getResponseCode();
			      BufferedReader br;
			      System.out.print("responseCode="+responseCode);
			      if(responseCode==200) { // 정상 호출
			        br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			      } else {  // 에러 발생
			        br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"utf-8"));
			      }
			      String inputLine;
			      StringBuffer res = new StringBuffer();
			      while ((inputLine = br.readLine()) != null) {
			        res.append(inputLine);
			      }
			      br.close();
			      response = res.toString();
			    } catch (Exception e) {
			      System.out.println(e);
			    }
			 
			 return response;
			 
		}
	
	
	
	// context root url 지정
	public String appURL( HttpServletRequest request ) {
		//http://localhost:8080/smart
		StringBuffer url = new StringBuffer("http://");
		//localhost = 127.0.0.1 = 본인ip
		url.append( request.getServerName() ).append(":"); //  http://localhost:
		url.append( request.getServerPort() );  //  http://localhost:8080
		url.append( request.getContextPath() ); //  http://localhost:8080/smart
		return url.toString();
	}
}
