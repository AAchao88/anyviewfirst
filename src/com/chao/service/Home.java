package com.chao.service;

import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.po.Users;
import com.chao.service.OperateImp.HomeImp;
import com.chao.service.modify.ModifyMine;

public class Home implements HomeImp {

    @Override
    public void mine(Users users) {
        /**
         *        我的
         *先显示所有用户信息和修改界面
         */
        Menu menu = new Menu();
        Verify verify = new Verify();
        ModifyMine modifyMine = new ModifyMine();
        Select select = new Select();

        while(true){
            menu.menuModifyMine();
            int item = verify.menuItemVerify(1,7);
            switch(item){
                case 1: select.selectUsers(users.getId(),1,users);break;
                case 2: modifyMine.modifyUsername(users); break;
                case 3: modifyMine.modifyPassword(users); break;
                case 4: modifyMine.modifySex(users); break;
                case 5: modifyMine.modifyTelephone(users);break;
                case 6: modifyMine.modifyEmail(users);break;
                case 7: return;
                default:
            }
        }
    }

    @Override
    public void square(Users users) {

    }

    @Override
    public void team(Users users) {

    }

    @Override
    public void favorite(Users users) {

    }

    @Override
    public void personal_Knowledge_base(Users users) {

    }

    /**
     *   新建知识库
     *   获取知识库id，将其赋到文章信息
     *   要求输入知识库的信息（分类为个人还是协作，name,tag,）
     *   联系数据库
     */
    @Override
    public void create_knowledge_base(Users users) {

    }

    @Override
    public void cooperate_knowledge_base(Users users) {

    }

    @Override
    public void recycleBin(Users users) {

    }


}
