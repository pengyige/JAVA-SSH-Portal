package top.yigege.dao;

import top.yigege.domain.TeleporterAdmin;

public interface TeleporterAdminDao extends BaseDao<TeleporterAdmin>{


	TeleporterAdmin loginByTel2(String cookie_tel_str, String cookie_password_str);

	boolean telIsExist(String tel);

}
