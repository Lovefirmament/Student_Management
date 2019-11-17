package pers.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ssm.mapper.LoginMapper;
import pers.ssm.po.Login;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;
	@Override
	public boolean query(Login login) {
		Login user=loginMapper.query(login);
		if(user!=null)
		{
			return true;
		}else {
		return false;
		}
	}

}
