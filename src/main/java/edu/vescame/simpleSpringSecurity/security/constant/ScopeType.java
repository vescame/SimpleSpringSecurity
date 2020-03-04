package edu.vescame.simpleSpringSecurity.security.constant;

public enum ScopeType {
    ALL("all"),
    READ("read"),
    WRITE("write"),
    TRUST("trust");

    private final String scope;

    ScopeType(final String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }
}
