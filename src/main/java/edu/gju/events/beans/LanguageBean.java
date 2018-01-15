/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hesham
 */
@Named(value = "langBean")
@SessionScoped
public class LanguageBean implements Serializable {

    private String locale;
    private String lang;
    private String dir;
    private String styleFloat;
    private String screenLeft;
    private String linkLabel;
    private boolean isEnglish;

    public LanguageBean() {
        locale = "en";
        lang = "en";
        dir = "ltr";
        styleFloat = "left";
        screenLeft = "left";
        linkLabel = "Arabic";
        isEnglish = true;
    }

    public void toggleLanguage() {
        this.isEnglish = !this.isEnglish;
        if (locale.equals("ar")) {
            locale = "en";
            lang = "en";
            dir = "ltr";
            styleFloat = "left";
            screenLeft = "left";
            linkLabel = "Arabic";
        } else {
            locale = "ar";
            lang = "ar";
            dir = "rtl";
            styleFloat = "right";
            screenLeft = "right";
            linkLabel = "انجليزي";
        }
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getStyleFloat() {
        return styleFloat;
    }

    public void setStyleFloat(String styleFloat) {
        this.styleFloat = styleFloat;
    }

    public String getLinkLabel() {
        return linkLabel;
    }

    public void setLinkLabel(String linkLabel) {
        this.linkLabel = linkLabel;
    }

    public boolean isIsEnglish() {
        return isEnglish;
    }

    public void setIsEnglish(boolean isEnglish) {
        this.isEnglish = isEnglish;
    }

    public String getScreenLeft() {
        return screenLeft;
    }

    public void setScreenLeft(String screenLeft) {
        this.screenLeft = screenLeft;
    }

}
