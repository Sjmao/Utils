package com.kkguan.earnings.earnings.ui.pinyin;

import android.text.TextUtils;

import java.util.ArrayList;

public class PinYinUtil {

    /**
     * 获取汉字全部的拼音
     */
    public static String getAllPinYin(String input) {

        ArrayList<HanziAllChar.Token> tokens = HanziAllChar.getInstance().get(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0)
        {
            for (HanziAllChar.Token token : tokens)
            {
                if (HanziAllChar.Token.PINYIN == token.type)
                {
                    sb.append(token.target);
                } else
                {
                    sb.append(token.source);
                }
            }
        }
        return sb.toString().toLowerCase();
    }
    
    
    /**
     * 获取输入字符的首字母
     */
    public static String getHeaderPinYin(String input) {
        return HanziFirstChar.getHeaderPinYin(input);
    }

    public static String getDefaultAllPinYin(String input) {
        String allCharacter;
        if (input == null) {
            allCharacter = "";
        } else {
            allCharacter = PinYinUtil.getAllPinYin(input);
        }
        return allCharacter;
    }

    /**
     * chenlong -> c
     */
    public static String getDefaultFirstHeaderCharacter(String py) {
        String firstCharacter;
        if (TextUtils.isEmpty(py) || py.length() < 1) {
            firstCharacter = "#";
        } else {
            firstCharacter = py.substring(0, 1);
            char ch = firstCharacter.charAt(0);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                firstCharacter = "#";
            }
        }
        return firstCharacter;
    }
}
