//package com.ntreddy.dd.ecommerce.validator;
//
//
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.validation.ConstraintValidatorContext;
//
//public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
//    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
//        String regex =
////                represents a digit must occur at least once
//                  "^(?=.*[0-9])"
////                represents an upper case alphabet that must occur at least once.
//                + "(?=.*[A-Z])"
////                represents a special character that must occur at least once.
//                + "(?=.*[@+=!._])"
////                white spaces don’t allowed in the entire string.
//                + "(?=\\S+$)"
////                represents at least 8 characters and at most 20 characters.
//                +".{8,20}$";
//        Pattern p = Pattern.compile(regex);
//        if (password == null) {
//            return false;
//        }
//        Matcher m = p.matcher(password);
//        return m.matches();
//    }
//}
