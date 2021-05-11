package com.treasuremountain.mango.backup.service.impl;

import com.treasuremountain.mango.backup.service.MysqlBackupService;
import com.treasuremountain.mango.backup.util.MysqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

/**
 * 备份还原实现
 *
 * @author  mengyuanming
 * @date  2021/04/24 14:22
 * @version 1.0
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {


    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        return MysqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return MysqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
