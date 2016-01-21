package com.dooioo.samples.blog.hepler;

import com.dooioo.web.common.Validations;
import org.springframework.validation.Errors;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-28
 * Time: 下午5:41
 */
public class CommentHelper {
    public static void validate(Errors errors) {
        Validations.rejectIfEmpty(errors, "content", "内容必填");
    }
}
