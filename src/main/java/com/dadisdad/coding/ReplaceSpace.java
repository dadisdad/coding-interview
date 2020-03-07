package com.dadisdad.coding;

/**
 * 替换空格
 * @author 10308
 * @date 2020/3/7
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] original = s.toCharArray();
        int numOfBlank = 0;
        for (char c : original) {
            if (c == ' ') {
                numOfBlank++;
            }
        }
        char[] newStrChar = new char[original.length + numOfBlank * 2];
        int originalLength = original.length - 1;
        int newLength = newStrChar.length - 1;
        while (originalLength >= 0 && newLength >= originalLength) {
            if (original[originalLength] == ' ') {
                newStrChar[newLength--] = '0';
                newStrChar[newLength--] = '2';
                newStrChar[newLength--] = '%';
            } else {
                newStrChar[newLength--] = original[originalLength];
            }
            originalLength--;
        }
        return new String(newStrChar);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
