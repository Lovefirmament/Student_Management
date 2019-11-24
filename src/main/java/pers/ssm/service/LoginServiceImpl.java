package pers.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.ssm.mapper.LoginMapper;
import pers.ssm.po.Login;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT)
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
