package ru.relex.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.dao.AppUserDAO;
import ru.relex.entity.AppUser;
import ru.relex.service.UserActivationService;
import ru.relex.utils.CryptoTool;

import java.util.Optional;

@Service
public class UserActivationServiceImpl implements UserActivationService {
    private final AppUserDAO appUserDAO;
    private final CryptoTool cryptoTool;

    public UserActivationServiceImpl(AppUserDAO appUserDAO, CryptoTool cryptoTool) {
        this.appUserDAO = appUserDAO;
        this.cryptoTool = cryptoTool;
    }

    @Override
    public boolean activation(String cryptoUserId) {
       Long userId = cryptoTool.idOf(cryptoUserId);
       Optional<AppUser> optional = appUserDAO.findById(userId);
       if (optional.isPresent()) {
           AppUser user = optional.get();
           user.setIsActive(true);
           appUserDAO.save(user);
           return true;
       }
       return false;
    }
}
