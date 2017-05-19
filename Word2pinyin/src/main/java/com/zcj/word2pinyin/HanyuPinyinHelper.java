package com.zcj.word2pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2017/5/19.
 */
public class HanyuPinyinHelper {

    /**
     * 中文字符转拼音
     * @param chinessWord
     * @return
     */
    public String toHanyuPinyin(String chinessWord){
        char[] chnChars = chinessWord.trim().toCharArray();

        String hanyuPinyin = "";
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);  //拼音小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   //不带声调
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (int i=0;i<chnChars.length;i++) {
                //如果是中文则转成汉语拼音
                if (String.valueOf(chnChars[i]).matches("[\u4e00-\u9fa5]+")) {
                    hanyuPinyin += PinyinHelper.toHanyuPinyinStringArray(chnChars[i], format)[0];
                } else {//字符不是中文，不进行装换
                    hanyuPinyin += chnChars[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            System.out.println("字符不能转成汉语拼音");
        }

        return hanyuPinyin;
    }
}
