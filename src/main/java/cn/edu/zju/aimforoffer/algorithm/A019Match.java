package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/2/23 14:10
 * @strategy
 */
public class A019Match {
    public boolean match(char[] str, char[] pattern) {
        //字符串或者模式为空，则直接返回false
        if (str == null || pattern == null) {
            return false;
        }
        //字符串长度为1时
        if (str.length == 1) {
            if (pattern.length == 1) {
                if(str[0] == pattern[0] || pattern[0] == '.') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        int sindex = 0;
        int pindex = 0;
        return matchIndex(str, sindex, pattern, pindex);
    }

    public boolean matchIndex(char[] str, int sindex, char[] pattern, int pindex) {
        //str和pattern同时到达结尾，则匹配成功
        if (sindex == str.length && pindex == pattern.length) {
            return true;
        }
        //如果pattern先到尾，而str没有到达末尾，则匹配失败
        if (sindex != str.length && pindex == pattern.length) {
            return false;
        }
        //如果pattern第二个字符时*
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            if (sindex != str.length && str[sindex] == pattern[pindex] ||
            sindex != str.length && pattern[pindex] == '.') {
                return matchIndex(str, sindex, pattern, pindex + 2) ||
                        matchIndex(str,sindex + 1, pattern, pindex + 2) ||
                        matchIndex(str, sindex + 1, pattern, pindex);
            } else {
               return matchIndex(str, sindex, pattern, pindex + 2);
            }
        }
        //如果pattern第二个字符不是*
        if ( sindex != str.length && str[sindex] == pattern[pindex] ||
        sindex != str.length && pattern[pindex] == '.') {
            return matchIndex(str, sindex + 1, pattern, pindex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        A019Match A019Match = new A019Match();
        String str1 = "aaa";
        String pattern1 = "a.a";
        String pattern2 = "aa.a";
        System.out.println("result == " + A019Match.match(str1.toCharArray(), pattern1.toCharArray()));
        System.out.println("result == " + A019Match.match(str1.toCharArray(), pattern2.toCharArray()));

    }
}
