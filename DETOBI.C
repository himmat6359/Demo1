/*Write a program to create hangman game of at least 10 words.
@Author : Naman
@Date : 16/02/24*/
#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
void hangmanString(char *str){
		int i;
	    int len=strlen(str);

	    if(len%2==0){
	    for(i=0;i<len;i++){
	    if(i%2!=0)printf("%c",str[i]);
	    else printf("_");
		}
	    }
	    else{
	    for(i=0;i<len;i++){
	    if(i%2==0)printf("%c",str[i]);
	    else printf("_");
	     }
	    }
}
int check(char *str1){
	 char str2[10];
	 int i;
	printf("\nyou have Ten Attempt complete the word\n");
       for(i=1;i<=10;i++){
       printf("\nAttempt %d:-",i);
       scanf("%s",str2);
       if(strcmp(str2,str1)==0){
       printf("You guss the word in %d attempt ",i);
       return 1;
       }

       }
       return 0;

}

void main(){
	int i,num;
	FILE *fc;
	time_t t;
       char str[10][10]={"naman","himmat","jigar","harshit","khushi","babu","muskan","nikita","sonya","manish"},str2[10],str3[10];
       clrscr();
       srand((unsigned) time(&t) );
       num=rand()%10;
	gotoxy(35, 10);

       strcpy(str2,str[num]);
       printf("Complete the Word\n");
       gotoxy(40, 12);
       hangmanString(str2);

       printf("\n\n");
       if(check(str2)==0)printf("\nyou loss the game!");
       getch();

}
/*
#include <stdio.h>
#include <conio.h>
void main()
{
     int no,i,d,temp[20];
     clrscr();
     printf("Enter The Decimal Number :");
     scanf("%d",&no);
     d=0;
     while(no!=0)
      {
	  temp[d]=no%2;
	  no=no/2;
	  d++;
      }
      for(i=d-1;i>=0;i--)
       {
	 printf("%d",temp[i]);
       }
      getch();
}
*/