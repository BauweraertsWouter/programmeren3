package be.kdg.prog3.classnotfound.security;

import be.kdg.prog3.classnotfound.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    UserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getName(), user.getPassword(), authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
