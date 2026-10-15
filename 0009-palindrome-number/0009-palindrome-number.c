bool isPalindrome(int x) {
  #include <stdbool.h>
    if (x < 0) return false;

    int original = x;
    long long reversed = 0;  // 👈 changed

    while (x != 0) {
        int digit = x % 10;
        reversed = reversed * 10 + digit;
        x /= 10;
    }

    return original == reversed;
}