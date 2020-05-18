package cn.phorcys.demo.db.generator;

import cn.phorcys.framework.database.CodeGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 3:02 下午
 */
public class Generator {
    public static void main(String[] args) {
        CodeGenerator root = new CodeGenerator(DbType.MYSQL, "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://39.100.234.80:36020/phorcys-interface?useSSL=false",
                "root", "H@ndAdmin", "cn.phorcys.demo.db");
        root.generate("sap_item_record");
    }
}
