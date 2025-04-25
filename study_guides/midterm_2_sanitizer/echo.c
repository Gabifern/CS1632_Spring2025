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
    char buf[5];
    strcpy(buf, str); //telling us this is the issue!
    printf("%s\n", buf);
    return 0;
}

//What it’s doing:
//Takes a single argument from the command line (argv[1]).
//Copies it into a local buffer buf[5] using strcpy.
//Prints the content.

//The buffer buf is only 5 bytes long. If the input string is longer than 4 characters 
//(plus the null terminator), you get a buffer overflow.

//gcc -g -fsanitize=address echo.c -o echo.asan 
//compile in terminal, on WSL

//./echo.asan hello
//run this command and see the buffer overflow

//==102==ERROR: AddressSanitizer: stack-buffer-overflow on address 0x7ffd7b424d35 
//at pc 0x7f2c7156e16d bp 0x7ffd7b424ce0 sp 0x7ffd7b424488
//WRITE of size 6 at 0x7ffd7b424d35 thread T0

//buf is only 5 bytes long.
//You're copying a string (str) that’s longer than that.
//strcpy does not check bounds, so it blindly writes past the end of the buffer.
//This leads to stack corruption (dangerous!) and is flagged as a stack-buffer-overflow by ASAN.
