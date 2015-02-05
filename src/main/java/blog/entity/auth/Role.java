package blog.entity.auth;

/**
 * Created by user on 29.01.2015.
 */
public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN")
    ;

    private final String role;

    /**
     * @param role
     */
    private Role(final String role) {
        this.role = role;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return role;
    }
}
