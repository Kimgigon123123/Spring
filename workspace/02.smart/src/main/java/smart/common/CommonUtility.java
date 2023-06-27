package smart.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import smart.member.MemberVO;

@Service
public class CommonUtility {

	//파일다운로드
	public void fileDownload(String filename,String filepath,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		filepath= filepath.replace(appURL(request), "d://app/"+request.getContextPath());
		//다운로드할 파일객체를 생성
		File file = new File(filepath);
		String mime = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(mime);
		
		//파일IO: 읽기/쓰기 - 단위 문자: reader/writer, byte: input/output
		
		//파일을 첨부해서 쓰기작업하기
		//파일명에 한글이 있다면 인코딩하기
		filename = URLEncoder.encode(filename,"utf-8").replaceAll("\\+", "%20");
		response.setHeader("content-disposition", "attachment;filename="+filename);
		FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
		
		//		PrintWriter writer = response.getWriter();
		
		
	}
	
	
	//파일업로드
	public String fileUpload(String category,MultipartFile file,HttpServletRequest request) {
		// d:\\app\smart
		String path = "D:\\app"+request.getContextPath();
		String upload = "/upload/"+category+ new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
			path += upload;
			File folder = new File(path);
			if(!folder.exists()) {
				folder.mkdirs();
				
			}
			String filename = UUID.randomUUID().toString()+"_"+ file.getOriginalFilename();
			try {
				file.transferTo(new File(path,filename));
			} catch (Exception e) {
				
			}
			// http://localhost:8080/smart/upload/profile/2023/06/22/abc.png
			return appURL(request)+upload+"/"+filename;
	}
	
	
	private void emailServerConnect(HtmlEmail email) {
		email.setHostName("smtp.naver.com"); //메일서버지정
		email.setAuthentication("kgg990321", "pw"); //아이디/비번 으로 로그인
		email.setSSLOnConnect(true); // 로그인버튼 클릭
	}
	private String EMAIL_ADDRESS = "kgg990321@naver.com";
	
	//이메일 보내기 : 회원가입 축하메세지 전송
	public void sendWelcome(MemberVO vo,String welcomFile) {
		HtmlEmail email = new HtmlEmail();
		email.setCharset("utf-8");
		email.setDebug(true);
		
		//이메일서버지정
		emailServerConnect(email);
		try {
			email.setFrom(EMAIL_ADDRESS,"스마트 웹&앱 관리자");
			email.addTo(vo.getEmail(),vo.getName());
			email.setSubject("한울스마트 웹&앱 과정 가입 축하");
			
			StringBuffer content = new StringBuffer();
			content.append("<body>");
			content.append("<h3><a target='_blank' href='http://hanuledu.co.kr/'>한울스마트 웹&앱 과정 가입 축하</a></h3>");
			content.append("<div>우리 과정 가입을 축하합니다</div>");
			content.append("<div>프로젝트까지 마무리 하시고 취업 성공하시길 바랍니다</div>");
			content.append("<div>첨부된 파일을 확인후 등교하세요</div>");
			content.append("</body>");
			email.setHtmlMsg(content.toString());

			EmailAttachment file =new EmailAttachment();
			file.setPath(welcomFile); // 파일선택
			email.attach(file); //선택한 파일 첨부
			
			email.send(); //메일 보내기 버튼 클릭
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	// 이메일 보내기 : 임시비번 전송
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
