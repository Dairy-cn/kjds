package com.cross.interfaces.phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @Author：Dairy
 * @Despriction: 手机号码验证注解
 * @Date: 2018/10/30  13:20
 */
public class PhoneValidator implements ConstraintValidator<Phone, Object> {
	private static final String PHONE_REGEX =  "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0-9])|(19[0-9]))\\d{8}$";
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
		//值不为空或者满足正则表达式时返回true
		return Objects.isNull(value) || Pattern.compile(PHONE_REGEX).matcher(value.toString()).find();
	}
}
