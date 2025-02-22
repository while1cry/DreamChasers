package top.dreamchasers.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    @Nullable
    private T data;

    public static <T> ResponseEntity<ApiResponse<T>> custom(int status, String message, @Nullable T data) {
        return ResponseEntity.status(status).body(new ApiResponse<>(message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, @Nullable T data) {
        return custom(200, message, data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(int code, String message) {
        return custom(code, message, null);
    }

}
