package com.example.sbserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    ADMIN_NOT_ACCESSIBLE(403, "Don't have permission"),

    USER_NOT_FOUND(404, "User Not Found"),

    NOTICE_NOT_FOUND(404, "Notice Not Found"),

    FAQ_NOT_FOUND(404, "Faq Not Found"),

    TIP_NOT_FOUND(404, "Tip Not Found"),

    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    EMAIL_EXIST(409, "Email Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}