package com.codegym.service;

import com.codegym.model.MailConfig;
import com.codegym.repository.IMailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailConfigService implements IMailConfigService{
    @Autowired
    private IMailConfigRepository mailConfigRepository;
    @Override
    public MailConfig showConfig() {
        return this.mailConfigRepository.showConfig();
    }

    @Override
    public void saveConfig(MailConfig mailConfig) {
        this.mailConfigRepository.saveConfig(mailConfig);
    }

    @Override
    public List<String> showLanguagesOption() {
        return this.mailConfigRepository.showLanguagesOption();
    }

    @Override
    public List<Integer> showSizeOption() {
        return this.mailConfigRepository.showSizeOption();
    }
}
