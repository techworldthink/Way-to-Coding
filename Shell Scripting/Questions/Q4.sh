read -p "file path : " file;

[ -w $file ] && W="Write - YES" || W="Write - NO"
[ -r $file ] && R="Read - YES" || R="Read - NO"
[ -x $file ] && X="Executable - YES" || X="Executable - NO"

echo $R
echo $W
echo $X
