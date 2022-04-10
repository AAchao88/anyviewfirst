package com.chao.service.OperateImp;

import com.chao.po.Users;

public interface ModifyMineImp {
    void modifyUsername(Users users);
    void modifyPassword(Users users);
    void modifySex(Users users);
    void modifyTelephone(Users users);
    void modifyEmail(Users users);
}
