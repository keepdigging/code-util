package com.keepdigging.util;

import com.keepdigging.constant.FontColor;

/**
 *
 * 控制台打印彩色字体
 * 语法格式: \033[44;37;5m ME \033[0m COOL
 *
 */
public class FontColorUtil {

    private static FontColor defaultFontColor = FontColor.WHITE;

    /**
     * @param text
     */
    public static void print(String text)
    {
        print(text, defaultFontColor);
    }

    /**
     * @param text
     */
    public static void println(String text)
    {
        println(text, defaultFontColor);
    }

    /**
     * @param text
     * @param fontColor
     */
    public static void print(String text, FontColor fontColor)
    {
        printInternal(text, fontColor == null?defaultFontColor:fontColor, false);
    }

    /**
     * @param text
     * @param fontColor
     */
    public static void println(String text, FontColor fontColor)
    {
        printInternal(text, fontColor == null?defaultFontColor:fontColor, true);
    }

    /**
     * @param text
     * @param fontColor
     * @param newLine
     */
    private static void printInternal(String text, FontColor fontColor, boolean newLine)
    {
        if(text == null || text.trim().length() == 0)
        {
            throw new IllegalArgumentException("text can't empty!");
        }
        if(illegalColor(fontColor))
        {
            throw new IllegalArgumentException("illegal Color!");
        }

        String finalText = "";
        switch (fontColor)
        {
            case RED:
                finalText = "\033[31m"+text+"\033[0m";
                break;
            case GREEN:
                finalText = "\033[32m"+text+"\033[0m";
                break;
            case WHITE:
                finalText = "\033[37m"+text+"\033[0m";
                break;
            case YELLOW:
                finalText = "\033[33m"+text+"\033[0m";
        }

        if(newLine)
        {
            System.out.println(finalText);
        }
        else
        {
            System.out.print(finalText);
        }
    }

    /**
     * @param fontColor
     * @return
     */
    private static boolean illegalColor(FontColor fontColor)
    {
        for (FontColor fc : FontColor.values()) {
            if(fc.equals(fontColor))
            {
                return false;
            }
        }
        return true;
    }
}

