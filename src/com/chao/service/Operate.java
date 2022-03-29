package com.chao.service;

import com.chao.controler.Print;
import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.service.modify.ModifyMine;

public class Operate {


    public void mine(){
        /**
         *先显示所有用户信息和修改界面
         */
        Menu menu = new Menu();
        Verify verify = new Verify();
        ModifyMine modifyMine = new ModifyMine();
        Print print =new Print();

        while(true){
            menu.menuModifyMine();
            int item = verify.MenuItemVerify(1,7);
            //返回首页
            if(item==7){
                return ;
            }
            switch(item){
                case 1: print.printMine();break;
                case 2: modifyMine.modifyUsername(); break;
                case 3: modifyMine.modifyPassword(); break;
                case 4: modifyMine.modifySex(); break;
                case 5: modifyMine.modifyTelephone();break;
                case 6: modifyMine.modifyEmail();break;
                default:
            }
        }
    }
    public void square(){

    }
    public void team(){

    }
    public void favorite(){

    }
    public void personal_Knowledge_base(){

    }
    public void create_knowledge_base(){

    }
    public void cooperate_knowledge_base(){

    }
    public void recycleBin(){

    }

}
