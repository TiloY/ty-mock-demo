package com.ty.tymockdemo.d;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/18 1:03
 * @Version : 1.0.0
 **/
public class S {

    /**
     * 开闭区间正则表达式
     */
    private static final Pattern NUM_RANGE_PATTERN = Pattern.compile("[\\[|\\(]\\s?\\d+\\s?,\\s?\\d+\\s?[\\)|\\]]");

    /**
     * 左半区间正则表达式
     */
    private static final Pattern LEFT_NUM_RANGE_PATTERN = Pattern.compile("[\\[|\\(]\\s?\\d+\\s?,\\s?[\\)|\\]]");

    /**
     * 右半区间正则表达式
     */
    private static final Pattern RIGHT_NUM_RANGE_PATTERN = Pattern.compile("[\\[|\\(],\\s?\\d+\\s?[\\)|\\]]");
    public static final String REGEX = "[(|)|\\[|\\]]";
    public static final String REGEX1 = ",";
    public static final String BLANK = "";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";

    /**
     * 判断是否为有效的数字区间范围
     *
     * @param numRange 数字区间
     * @return boolean
     */
    public static boolean isValidNumRange(String numRange) {
        return NUM_RANGE_PATTERN.matcher(numRange).matches()
                || LEFT_NUM_RANGE_PATTERN.matcher(numRange).matches()
                || RIGHT_NUM_RANGE_PATTERN.matcher(numRange).matches();
    }

    /**
     * 判断数值是否在区间范围内
     *
     * @param number   数值
     * @param numRange 开闭区间
     * @return boolean
     */
    public static boolean inNumRange(double number, String numRange) {
        Objects.requireNonNull(numRange);

        if (!isValidNumRange(numRange)) {
            return false;
        }

        String[] pairs = numRange.split(REGEX1);

        // 获取开闭区间的最小值和最大值
        List<String> rangeNums = Arrays.stream(pairs).map(str -> str.replaceAll(REGEX, BLANK).trim()).collect(Collectors.toList());
        Double minValue = "".equals(rangeNums.get(0)) ? null : Double.valueOf(rangeNums.get(0));
        Double maxValue = "".equals(rangeNums.get(1)) ? null : Double.valueOf(rangeNums.get(1));

        // 判定数值是否大于最小值
        boolean minMatched = (minValue == null) || (pairs[0].startsWith(PREFIX) ? number >= minValue : number > minValue);
        // 判定数值是否小于最大值
        boolean maxMatched = (maxValue == null) || (pairs[1].endsWith(SUFFIX) ? number <= maxValue : number < maxValue);

        return minMatched && maxMatched;
    }

    public static void main(String[] args) {

        L[] allRes = L.getAllRes();
        System.out.println(func(0, allRes));
        System.out.println(func(20.3, allRes));
        System.out.println(func(60, allRes));
        System.out.println(func(80, allRes));
        System.out.println(func(95, allRes));
        System.out.println(func(101, allRes));

    }

    private static String func(double num, L[] allRes) {
        return Arrays.stream(allRes)
                .filter(allRe -> inNumRange(num, allRe.getValue()))
                .findFirst()
                .map(L::getName)
                .orElse(null);
    }
}
