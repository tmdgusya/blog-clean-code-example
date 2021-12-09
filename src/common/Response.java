package common;

public class Response<T> {

    private static final int OK = 200;
    private static final int SERVER_ERROR = 200;

    private final int statusCode;
    private final T Data;

    public Response(int statusCode, T data) {
        this.statusCode = statusCode;
        Data = data;
    }

    public static <T> Response<T> Ok(T data) {
        return new Response<>(OK, data);
    }

    public static <T> Response<T> Error() {
        return new Response<>(SERVER_ERROR, null);
    }

}
