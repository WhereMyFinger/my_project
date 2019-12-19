package application.authen;

import application.data.model.Role;
import application.data.model.User;
import application.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class MySqlUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username);
        if(user != null) {

            List<Role> listActiveRole = userService.getListActiveRole(user.getId());
            Boolean isActive = true;

            if(listActiveRole.size() == 0)
                isActive = false;


            Set<GrantedAuthority> authoritySet = new HashSet<>();
            for(Role role : listActiveRole) {
                authoritySet.add(new SimpleGrantedAuthority(role.getName()));
            }

            org.springframework.security.core.userdetails.User userDetail =
                    new org.springframework.security.core.userdetails.User(username, user.getPasswordHash(),
                            isActive, true, true, true, authoritySet);

            return userDetail;
        }

        throw new UsernameNotFoundException(username + "not found");

    }
}
