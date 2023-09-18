package com.codegym.service;

import com.codegym.model.MailConfig;
import com.codegym.repository.IMailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailConfigService implements IMailConfigService{
    @Autowired
    private IMailConfigRepository repository;
    @Override
    public MailConfig showConfig() {
        return this.repository.showConfig();
    }

    @Override
    public void saveConfig(MailConfig mailConfig) {
        this.repository.saveConfig(mailConfig);
    }

    @Override
    public List<String> showLanguagesOption() {
        return this.repository.showLanguagesOption();
    }

    @Override
    public List<Integer> showSizeOption() {
        return this.repository.showSizeOption();
    }
}
