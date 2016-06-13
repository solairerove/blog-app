package com.github.solairerove.blog.repository.common;

import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.dto.PostDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 16.05.16.
 */
@Component
@Transactional
public class EntityUtils {
    private static final int MAX_STRING_LENGTH = 25;
    private static final int START_INCLUSIVE = 5000;
    private static final int END_INCLUSIVE = 100000;

    private static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    private static Long getRandomLong() {
        return RandomUtils.nextLong(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static Post generatePost() {
        return new Post(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }

    public static PostDTO generatePostDTO() {
        return new PostDTO(getRandomLong(),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }

    public static Comment generateComment() {
        return new Comment(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }
}
