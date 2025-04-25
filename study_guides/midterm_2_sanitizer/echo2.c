
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
    if (argc != 2) {
        printf("Usage: echo <string_you_want_to_echo>\n");
        return 0;
    }
    char *str = argv[1];
    int len = strlen(str);
    char *buf = (char *) malloc(len);  //memory allocation error with malloc
    for (int i = 0; i < len; i++) {
        buf[i] = str[i];
    }
    printf("%s\n", buf); //use of unterminated string
    return 0;
}

/* The code allocates memory with malloc(len) where len = strlen(str) — 
this gives no room for the null terminator ('\0').
Then it:
Copies characters one-by-one (buf[i] = str[i];)
Does not manually add the null terminator
Prints it with printf("%s\n", buf);, expecting a null-terminated string
This is undefined behavior, and ASAN will throw a heap-buffer-overflow or use-after-buffer-end error.*/

//gcc -g -fsanitize=address echo2.c -o echo2.asan
//compile in WSL
//send in some input
//./echo2.asan hello

//==189==ERROR: AddressSanitizer: heap-buffer-overflow on address 0x602000000015 
//at pc 0x7f0754e0df7d bp 0x7ffe0f981850 sp 0x7ffe0f980ff8
//READ of size 6 at 0x602000000015 thread T0

/*bug location: malloc(len) (line where buffer is allocated)
problem: Didn’t allocate space for null terminator
fix: Add +1 to malloc and explicitly set buf[len] = '\0';*/

