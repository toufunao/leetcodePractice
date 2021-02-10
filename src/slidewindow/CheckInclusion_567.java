package slidewindow;

public class CheckInclusion_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length())
            return false;
        int[] count1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            count1[a - 'a']++;
        }
        int left = 0;
        int right = s1.length() - 1;
        int[] count2 = new int[26];
        for (int i = 0; i <= right; i++) {
            char b = s2.charAt(i);
            count2[b - 'a']++;
        }
        if (check(count1, count2))
            return true;

        int len = s2.length();
        right++;
        while (right < len) {
            count2[s2.charAt(right) - 'a']++;
            count2[s2.charAt(left) - 'a']--;
            if (check(count1,count2))
                return true;

            right++;
            left++;
        }
        return false;
    }

    boolean check(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i])
                return false;
        }
        return true;
    }
}
