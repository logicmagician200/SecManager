package xyz.supersec.secmanager.db.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@TableName("bc_class_info")
@ApiModel(value = "BcClassInfo对象", description = "")
@Data
@Accessors(chain = true)
public class BcClassInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private Integer pId;

    /**
     * _internal_name 的 md5 值，也是当前类在当前项目的唯一标识
     */
    @ApiModelProperty("_internal_name 的 md5 值，也是当前类在当前项目的唯一标识")
    private String classUuid;

    /**
     * 类的名称，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("类的名称，在 Class_visitor.visit 方法中获取")
    private String className;

    /**
     * 父类的名称，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("父类的名称，在 Class_visitor.visit 方法中获取")
    private String superName;

    /**
     * 实现的接口，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("实现的接口，在 Class_visitor.visit 方法中获取")
    private String interfaces;

    /**
     * 泛型签名信息，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("泛型签名信息，在 Class_visitor.visit 方法中获取")
    private String signature;

    /**
     * 当前类的版本信息，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("当前类的版本信息，在 Class_visitor.visit 方法中获取")
    private Integer version;

    /**
     * 当前类的访问标识符，在 Class_visitor.visit 方法中获取
     */
    @ApiModelProperty("当前类的访问标识符，在 Class_visitor.visit 方法中获取")
    private String access;

    private String accessFlag;

    /**
     * 表示当前Class_file对应的源文件，和是内部类还是外部类没有关系。在 Class_visitor.visit_source 方法中获取
     */
    @ApiModelProperty("表示当前Class_file对应的源文件，和是内部类还是外部类没有关系。在 Class_visitor.visit_source 方法中获取")
    private String source;

    /**
     * 内存常常为空。用于存储额外的调试信息，比如 _j_s_p 文件，非 _java 语言编写的调试信息。在 Class_visitor.visit_source 方法中获取
     */
    @ApiModelProperty("内存常常为空。用于存储额外的调试信息，比如 _j_s_p 文件，非 _java 语言编写的调试信息。在 Class_visitor.visit_source 方法中获取")
    private String debug;

    /**
     * 模块名称，java 9 新增，在 Class_visitor.visit_module 方法中获取
     */
    @ApiModelProperty("模块名称，java 9 新增，在 Class_visitor.visit_module 方法中获取")
    private String moduleName;

    /**
     * 模块访问标识符，java 9 新增，在 Class_visitor.visit_module 方法中获取
     */
    @ApiModelProperty("模块访问标识符，java 9 新增，在 Class_visitor.visit_module 方法中获取")
    private Integer moduleAccess;

    /**
     * 模块版本，java 9 新增，在 Class_visitor.visit_module 方法中获取
     */
    @ApiModelProperty("模块版本，java 9 新增，在 Class_visitor.visit_module 方法中获取")
    private String moduleVersion;

    /**
     * 宿主类的 _internal_name，当前的 class_file 代表一个内部类时，可以在 Class_visitor.visit_nest_host 方法中获取
     */
    @ApiModelProperty("宿主类的 _internal_name，当前的 class_file 代表一个内部类时，可以在 Class_visitor.visit_nest_host 方法中获取")
    private String nestHost;

    /**
     * 获取巢穴中其他成员的 _internal_name（例如：test/demo/_nest_host_test$B ），可能存在多个，但是都以字符串的形成存放在此字段中。可以在 Class_visitor.visit_nest_host 方法中获取
     */
    @ApiModelProperty("获取巢穴中其他成员的 _internal_name（例如：test/demo/_nest_host_test$B ），可能存在多个，但是都以字符串的形成存放在此字段中。可以在 Class_visitor.visit_nest_host 方法中获取")
    private String nestMember;

    /**
     * 表示内部类所在的外部类。当一个内部类在方法中时，解析这个类的 Class_file 会使用此字段。可以在 Class_visitor.visitOuter_class 方法中获取
     */
    @ApiModelProperty("表示内部类所在的外部类。当一个内部类在方法中时，解析这个类的 Class_file 会使用此字段。可以在 Class_visitor.visitOuter_class 方法中获取")
    private String outerClassOwner;

    /**
     * 表示内部类所在的方法名称。当一个内部类在方法中时，解析这个类的 _class_file 会使用此字段。可以在 _class_visitor.visitOuter_class 方法中获取
     */
    @ApiModelProperty("表示内部类所在的方法名称。当一个内部类在方法中时，解析这个类的 _class_file 会使用此字段。可以在 _class_visitor.visitOuter_class 方法中获取")
    private String outerClassName;

    /**
     * 表示内部类所在的方法的描述符。当一个内部类在方法中时，解析这个类的 _class_file 会使用此字段。可以在 _class_visitor.visitOuter_class 方法中获取
     */
    @ApiModelProperty("表示内部类所在的方法的描述符。当一个内部类在方法中时，解析这个类的 _class_file 会使用此字段。可以在 _class_visitor.visitOuter_class 方法中获取")
    private String outerClassDescriptor;

    /**
     * 对应注解表的相关字段，结构为 typeAnn+md5，可以通过 _class_visitor.visit_typeAnnotation 方法获取
     */
    @ApiModelProperty("对应注解表的相关字段，结构为 typeAnn+md5，可以通过 _class_visitor.visit_typeAnnotation 方法获取")
    private String typeAnnotationIndex;

    /**
     *  java15 引入的特性,该方法用于访问允许的子类,，可以通过 _class_visitor.visit_permitted_subclass 方法获取
     */
    @ApiModelProperty(" java15 引入的特性,该方法用于访问允许的子类,，可以通过 _class_visitor.visit_permitted_subclass 方法获取")
    private String permittedSubclass;

    /**
     * visitAttribute 方法的内容
     */
    @ApiModelProperty("visitAttribute 方法的内容")
    private String attribute;

    /**
     * 标志位,ok 表示正常数据，deleted 表示已经删除，
     */
    @ApiModelProperty("标志位,ok 表示正常数据，deleted 表示已经删除，")
    private String dataFlag;

    /**
     * 更新次数
     */
    @ApiModelProperty("更新次数")
    private Integer numOfUpdate;

    /**
     * 备注字段
     */
    @ApiModelProperty("备注字段")
    private String remark;

    /**
     * 一个类中的方法数
     */
    @ApiModelProperty("一个类中的方法数")
    private Integer methodNum;

    /**
     * 类中属性的数目
     */
    @ApiModelProperty("类中属性的数目")
    private Integer fieldNum;

    /**
     * 代表 java 文件的 md5 值
     */
    @ApiModelProperty("代表 java 文件的 md5 值")
    private String javaMd5;

    /**
     * 代表 class 文件的 md5 值
     */
    @ApiModelProperty("代表 class 文件的 md5 值")
    private String classFileMd5;

    /**
     * 最近更新时间
     */
    @ApiModelProperty("最近更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}