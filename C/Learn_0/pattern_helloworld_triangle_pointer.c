#include <stdio.h>

char *getChar();

int main () {
	char *ch;
	while(ch = getChar())
		printf("%s\n",ch);
	return 0;
}

char *getChar() {
	static int pos=0;
	char *str ="Hello world!";
	if(str[pos]==0)
		return 0;

	return &str[pos++];
}
