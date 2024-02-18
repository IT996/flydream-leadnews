package com.flydream.model.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//JacksonAnnotation是一个用于处理JSON数据的Java库，它提供了一种简单的方式来将Java对象转换为JSONJacksonAnnotation是一个用于处理JSON数据的Java库，
// 它提供了一种简单的方式来将Java对象转换为JSON字符串，以及将JSON字符串转换为Java对象。JacksonAnnotation支持多种数据类型，如字符串、数字、布尔值、数组和嵌套对象等。
@JacksonAnnotation
//是一个Java注解，用于指定该注解在运行时仍然可用。当一个类被加载到JVM时，
// 如果该类上有@Retention(RetentionPolicy.RUNTIME)注解，那么这个注解会被保留在类的字节码中，直到程序运行结束。这样，我们可以在运行时通过反射来获取和使用这个注解的信息。
@Retention(RetentionPolicy.RUNTIME)
//是一个Java注解，用于指定该注解可以应用于哪些元素。在这个例子中，它表示这个注解可以被应用于字段（Field）、方法（Method）和参数（Parameter）。
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface IdEncrypt {
}
