#include<stdio.h>
int main(){
  int n;
  char sum[101] = {0};
  int hab=0;
  scanf("%d",&n);
  scanf("%s", sum);
  for(int i=0;i<n;i++)
  {
    hab += (sum[i]-'0');
  }
  printf("%d",hab);
  return 0;
}