package xyz.supersec.secmanager.codeGen;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGen {

    public static void main(String[] args) {

        String[] tableNames = { "sys_task_info" };
        
            
        List<String> list = Arrays.stream(tableNames).toList();
            
        for (String tableName : list) {
            generator(tableName);
        }


    }


    private static void generator(String tableName) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/supersec?serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\Users\\33139\\Desktop\\devCode\\SecManager\\codegen"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> builder.parent("xyz.supersec.secmanager.db") // 设置父包名
                        // .moduleName("system") // 设置父包模块名
                        .pathInfo(Collections.singletonMap(OutputFile.xml,
                                "C:\\Users\\33139\\Desktop\\devCode\\SecManager\\codegen")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder -> builder.addInclude(tableName) // 设置需要生成的表名
                        .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();


    }



}
