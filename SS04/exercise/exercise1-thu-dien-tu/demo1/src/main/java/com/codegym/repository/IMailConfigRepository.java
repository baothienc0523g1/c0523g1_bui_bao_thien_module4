package com.codegym.repository;

import com.codegym.model.MailConfig;

import java.util.List;

public interface IMailConfigRepository {
    MailConfig showConfig();
    void saveConfig(MailConfig mailConfig);
    List<String> showLanguagesOption();
    List<Integer> showSizeOption();
}
