package pers.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.ssm.po.Login;

@Mapper
public interface LoginMapper {
	public Login query(Login login) ;
}
