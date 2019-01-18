package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired//는 스프링에서 제공
	//@inject 는 자바에서 제공
	private AccountDao accountDao;//Dao를 이용해 쿼리문을 동작시키기 위한 객체
	@Autowired
	BCryptPasswordEncoder passwordEncoder;//암호화 하여 저장하기 위한 객체
	
	
	//id 셀렉트 기능
	@Override
	public AccountVo getAccount(String id) {//AccountVo 타입의 게터메소드 (컨트롤러에서 파라미터로 1234를 넘겼다)
		return accountDao.getAccount(id);//1234라는 값을 Dao.getAccount에 넣어 쿼리를 실행하고 꺼내온 값을 리턴한다

	}
	
	//회원가입 기능
	@Override
	//public boolean signup(String id, String pw, String email, String gender) {
	public boolean signup(AccountVo accountVo) {//boolean인 이유는 id가 있는지 없는지 판단하기 위해서
		//가입여부 확인
		//String id = accountVo.getId();
		//AccountVo tmp = accountDao.getAccount(id);
		AccountVo tmp = accountDao.getAccount(accountVo.getId());
		if(tmp == null) {//db에서 검색된 id가 없으면
			String encPw = passwordEncoder.encode(accountVo.getPw());
			accountVo.setPw(encPw);
			
			accountVo.setAuthority("user");
			accountDao.insertAccount(accountVo);
			return true;
		}
		else
			return false;
	}
	
	//로그인 기능
	@Override
	public AccountVo login(String id, String pw) {
		AccountVo userInfo = accountDao.getAccount(id);//dao실행해서 id셀렉트문 일치하는거 가져와라
		if(userInfo != null && passwordEncoder.matches(pw,userInfo.getPw())){//아이디가 있고 비번이 맞다면
			return userInfo;//회원이면 정보를 던져줌
		}
		return null;//아니면 정보 없음
	}
}
