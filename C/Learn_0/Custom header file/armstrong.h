int isArmstrong(int n) {
	int r,sum=0,temp;
	temp=n;
	while(n>0) {
		r=n%10;
		sum=sum+(r*r*r);
		n=n/10;
	}
	if(temp==sum)
		return 1;
	else
		return 0;
}
