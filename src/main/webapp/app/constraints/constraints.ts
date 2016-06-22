export class Constraints {

    private static BASIC_PATH = 'liferay-blog-backend-0.0.1-SNAPSHOT';

    public static POSTS_PATH = this.BASIC_PATH + '/posts';
    public static ABOUT_PATH = this.BASIC_PATH + '/about';
    public static POST_DETAIL_PATH = this.BASIC_PATH + '/posts/:id';
    public static ADD_POST_PATH = this.BASIC_PATH + '/add';
    public static OTHER = this.BASIC_PATH + '/**';
    public static POST_URL = 'http://localhost:8080' + this.BASIC_PATH + '/api/posts';
    public static POST_URL_WITH_END_SLASH = 'http://localhost:8080' + this.BASIC_PATH + '/api/posts/';
}
