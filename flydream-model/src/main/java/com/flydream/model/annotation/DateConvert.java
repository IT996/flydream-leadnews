package com.flydream.model.annotation;


import java.lang.annotation.*;

/**
 * 日期类型转换注解
 * 这是一个名为DateConvert的Java注解，它的作用是将字段的值转换为日期类型。具体来说，这个注解有以下特点：
 *
 * @Documented：表示该注解的文档注释会被包含在生成的API文档中。
 * @Retention(RetentionPolicy.RUNTIME)：表示该注解在运行时仍然可用，即可以在程序运行期间通过反射来获取和使用该注解的信息。
 * @Target({ElementType.FIELD})：表示该注解只能应用于字段（Field）类型的元素上。
 * 注解有一个名为value的属性，它的默认值为空字符串。这个属性用于指定需要转换的日期格式。
 * 使用这个注解时，可以将需要转换的字段标记为@DateConvert，并指定日期格式。例如：
 */
//用于标记一个类、方法或字段的文档注释。当使用这个注解时，相关的文档注释会被包含在生成的API文档中，以便于开发者理解和使用该类、方法或字段的功能和用法。
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DateConvert {
    String value() default "";
}
