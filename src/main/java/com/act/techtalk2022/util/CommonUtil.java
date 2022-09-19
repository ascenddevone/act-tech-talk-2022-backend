package com.act.techtalk2022.util;


import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class CommonUtil {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    public static boolean validate(String emailStr) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr).matches();
    }

}
