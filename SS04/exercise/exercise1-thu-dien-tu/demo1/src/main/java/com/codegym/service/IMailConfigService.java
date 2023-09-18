package com.codegym.service;

import com.codegym.model.MailConfig;
import java.util.List;

public interface IMailConfigService {
    MailConfig showConfig();
    void saveConfig(MailConfig mailConfig);
    List<String> showLanguagesOption();
    List<Integer> showSizeOption();
}
