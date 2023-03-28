package code.string;

/**
 * Author: xl
 * date :2020/12/29 10:06
 * description:测试String的API
 * History:
 * 方法	描述
 * public int length()	返回此字符串的长度
 * public int indexOf(int ch)	返回指定字符第一次出现的字符串内的索引
 * public int lastIndexOf(int ch)	返回指定字符的最后一次出现的字符串中的索引
 * public int indexOf(String str)	返回指定子字符串第一次出现的字符串内的索引
 * public int lastIndexOf(String str)	返回指定子字符串最后一次出现的字符串中的索引
 * public char charAt(int index)	返回char指定索引处的值
 * public char[] toCharArray()	将此字符串转换为新的字符数组
 * public static String valueOf(int i)	返回int参数的字符串int形式
 * public String trim()	返回一个删除前后空格的字符串
 * public String toString()	返回当前字符串
 * public String concat(String str)	将指定的字符串连接到该字符串的末尾
 * public String toLowerCase()	返回一个转换为小写的字符串
 * public String toUpperCase()	返回一个转换为大写的字符串
 * public String substring(int beginIndex)	返回一个以指定索引处的字符开头到该字符串的末尾的子字符串
 * public String substring(int beginIndex, int endIndex)	返回一个以指定索引处的字符开头到指定索引处的字符结尾的子字符串
 * public String replace(char oldChar, char newChar)	返回一个替换所有旧字符后的新字符串
 * public String replaceAll(String regex, String replacement)	返回一个替换所有符合正则表达式字符串后的新字符串
 * public String[] split(String regex)	根据正则表达式拆分字符串并返回拆分后的字符串数组
 * public boolean startsWith(String prefix)	判断此字符串是否以指定的前缀开头
 * public boolean endsWith(String suffix)	判断此字符串是否以指定的后缀结尾
 * public boolean matches(String regex)	根据正则表达式判断当前字符串是否符合要求
 * public boolean isEmpty()	判断当前字符串是否为空字符串
 * public boolean contains(CharSequence s)	判断当前字符串是否包含s字符
 * public boolean equals(Object anObject)	判断当前字符串是否和anObject相等
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StringTest03 {
    public static void main(String[] args) {
        System.out.println(new String("i love you").length());
    }
}
