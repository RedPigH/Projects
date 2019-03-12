package user.member.login;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import user.member.MemberVO;

public class LoginAction  extends ActionSupport implements SessionAware { 
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	private MemberVO member;
	
	private String member_id;
	private String member_passwd1;
	private String admin_id;
	private String admin_passwd1;
	private int member_no;
	
	private int chkno;
	private int isadmin;
	
	private Map session;
	
	Calendar today = Calendar.getInstance();
	
	public LoginAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String login() throws Exception{
		if(!admin_id.equals("")) {
			member_id = getAdmin_id();
			member_passwd1 = getAdmin_passwd1();
		}
		resultClass = (MemberVO) sqlMapper.queryForObject("searchpw", member_id);
		member = (MemberVO) sqlMapper.queryForObject("checkid",member_id);
		if(resultClass != null) {
			if(resultClass.getMember_passwd1().equals(member_passwd1)) {
				
				ActionContext context = ActionContext.getContext();
				session = context.getSession();
				System.out.println("세션에 아이디 들어간다");
				session.put("member_id", resultClass.getMember_id()); // "member_id" 값을 넣어줄때 세션 따음표 확인
				session.put("member_no", resultClass.getMember_no());
				//context.setSession(session); // 왜 필요함?? 왜 필요한 코드인지 확인해볼것
				
				// 로그인하는 계정이 사용자이면????
				if(resultClass.getIsadmin() != 0 ) { // Isadmin은 default=0으로 설정되어있음
											
					return LOGIN; // login을 리턴 => 관리자 메인 페이지로 이동
				}
				return SUCCESS;  // 입력받은 아이디의 패스워드와 DB에 저장된 패스워드가 일치하면 SUCCESS를 리턴 
			}

		}
		return ERROR; // 입력받은 아이디의 패스워드와 DB에 저장된 패스워드가 일치하지 않으면 ERROR를 리턴
	
		
	}
	
	public String logout() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, String> session = (Map<String, String>) context.getSession();
		
		session.remove("member_id");
		
		context.setSession(session);
		
		return SUCCESS;	
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_passwd1() {
		return member_passwd1;
	}

	public void setMember_passwd1(String member_passwd1) {
		this.member_passwd1 = member_passwd1;
	}

	public int getChkno() {
		return chkno;
	}

	public void setChkno(int chkno) {
		this.chkno = chkno;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_passwd1() {
		return admin_passwd1;
	}

	public void setAdmin_passwd1(String admin_passwd1) {
		this.admin_passwd1 = admin_passwd1;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
}
