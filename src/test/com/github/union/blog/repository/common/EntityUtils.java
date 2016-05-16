package com.github.union.blog.repository.common;

import com.github.union.blog.domain.Post;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 16.05.16.
 */

@Component
@Transactional
public class EntityUtils {
    public static final int MAX_STRING_LENGTH = 25;
    public static final int MAX_NUMBER = 1000;
    public static final int MAX_ENTITIES_COUNT = 20;



    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static Integer getRandomInteger(int bound) {
        return RandomUtils.nextInt(1, bound);
    }

    public static Long getRandomLong(long bound) {
        return RandomUtils.nextLong(1, bound);
    }

    public Post generateAccount() {
        return new Post(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }



}
