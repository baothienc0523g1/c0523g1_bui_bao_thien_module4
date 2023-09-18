package com.codegym.repository;

import com.codegym.model.MailConfig;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailConfigRepository implements IMailConfigRepository {
    private static MailConfig mailConfigs = new MailConfig();
    private static List<String> languages;
    private static List<Integer> sizes;

    static {
        //language
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("France");
        languages.add("Wakanda");

        //sizes
        sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(20);
        sizes.add(25);
    }

    @Override
    public MailConfig showConfig() {
        return mailConfigs;
    }

    @Override
    public void saveConfig(MailConfig config) {
        mailConfigs.setLanguage(config.getLanguage());
        mailConfigs.setPageSize(config.getPageSize());
        mailConfigs.setSpam(config.getSpam());
        mailConfigs.setSignature(config.getSignature());
    }

    public List<String> showLanguagesOption() {
        return languages;
    }

    @Override
    public List<Integer> showSizeOption() {
        return sizes;
    }
}
