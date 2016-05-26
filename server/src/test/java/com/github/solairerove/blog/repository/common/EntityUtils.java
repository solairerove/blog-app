package com.github.solairerove.blog.repository.common;

import com.github.solairerove.blog.domain.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 16.05.16.
 */
@Component
@Transactional
public class EntityUtils {
    private static final int MAX_STRING_LENGTH = 25;

    private static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static Post generatePost() {
        return new Post(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }
}
