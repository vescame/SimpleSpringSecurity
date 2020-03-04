package edu.vescame.simpleSpringSecurity.security.constant;

public enum GrantType {
    PASSWORD("password"),
    AUTH_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token");

    private String description;

    GrantType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
