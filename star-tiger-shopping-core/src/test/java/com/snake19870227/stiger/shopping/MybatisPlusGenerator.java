package com.snake19870227.stiger.shopping;

import java.util.stream.Stream;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mysql.cj.jdbc.Driver;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/08
 */
public class MybatisPlusGenerator {

    private static final String[] schemas = new String[] {
            "stigershoppingaccount",
            "stigershoppinggoods",
            "stigershoppingorder"
    };

    public static void main(String[] args) {

        Stream.of(schemas).forEach(schema -> {
            AutoGenerator mpg = createGenerator();

            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://localhost:13316/" + schema + "?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
            dsc.setDriverName(Driver.class.getName());
            dsc.setUsername("root");
            dsc.setPassword("123456");
            mpg.setDataSource(dsc);

            mpg.execute();
        });

    }

    private static AutoGenerator createGenerator() {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/star-tiger-shopping-core/src/main/java");
        gc.setAuthor("buhuayang");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setIdType(IdType.ASSIGN_UUID);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.snake19870227.stiger.shopping");
        pc.setEntity("entity.po");
        mpg.setPackageInfo(pc);

        TemplateConfig tc = new TemplateConfig();
        tc.setService(null).setServiceImpl(null).setController(null);
        mpg.setTemplate(tc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityBuilderModel(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setLogicDeleteFieldName("delete_flag");
        mpg.setStrategy(strategy);

        return mpg;
    }
}
