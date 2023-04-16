package kr.tenth.unreal_web_v2.user;

import lombok.Data;

@Data
public class UEUserDto {

    private String email;
    private String password;

    public enum LoginResult {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PASSWORD
    }

    // 생성자, 게터, 세터
}