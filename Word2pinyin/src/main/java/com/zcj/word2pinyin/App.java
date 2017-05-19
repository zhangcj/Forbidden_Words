package com.zcj.word2pinyin;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        words.add("习大大");
        words.add("习金屏");
        words.add("庆丰包子");

        HanyuPinyinHelper helper = new HanyuPinyinHelper();
        for (String e : words) {
            System.out.println(helper.toHanyuPinyin(e));
        }
    }


    private static List<String> words = new ArrayList<String>();
}
