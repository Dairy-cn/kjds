package com.cross.interfaces.phone;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
/**
 * @ClassName: Phone
 * @author：dary
 * @Description: 手机号码验证注解
 * @Date: 2018/12/26  17:13
 * @Version: 1.0
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
		ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
//定义当前注解使用哪个参数校验器进行校验
@Constraint(validatedBy = PhoneValidator.class)
@Repeatable(Phone.List.class)
public @interface Phone {
	String message() default "手机号码格式错误";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
			ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		Phone[] value();
	}
}
