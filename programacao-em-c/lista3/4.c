#include <stdio.h>

void reverse(char s[]);

int main(void)
{
    char s[1000];

    scanf("%[^\n]", s);

    reverse(s);

    return 0;
}

void reverse(char s[]) {
    if (*s == '\0') {
        return;
    } else {
        reverse(s + 1);
        printf("%c", *s);
    }
}
