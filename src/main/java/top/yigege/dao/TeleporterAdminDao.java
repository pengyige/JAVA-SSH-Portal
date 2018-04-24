package top.yigege.dao;

import top.yigege.domain.TeleporterAdmin;

public interface TeleporterAdminDao extends BaseDao<TeleporterAdmin>{

	TeleporterAdmin findTeleporterAdminByPass(TeleporterAdmin teleporterAdmin);

}
