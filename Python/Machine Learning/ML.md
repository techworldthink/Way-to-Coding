## Machine Learning

### Data Types
#### 1.Numerical
#####   Discrete Data
-   numbers that are limited to integers. Example: The number of cars passing by.
    <br />
#####   Continuous Data
-   numbers that are of infinite value. Example: The price of an item, or the size of an item
#### 2.Categorical
    data are values that cannot be measured up against each other. Example: a color value, or any yes/no values.
#### 3.Ordinal
    data are like categorical data, but can be measured up against each other. Example: school grades where A is better than B and so on.

### Mean, Median, and Mode
#### 1.Mean
    The mean value is the average value.

    To calculate the mean, find the sum of all values, and divide the sum by the number of values:

    (99+86+87+88+111+86+103+87+94+78+77+85+86) / 13 = 89.77
#### 2.Median
    The median value is the value in the middle, after you have sorted all the values:

    77, 78, 85, 86, 86, 86, 87, 87, 88, 94, 99, 103, 111
#### 3.Mode
    The Mode value is the value that appears the most number of times:

    99, 86, 87, 88, 111, 86, 103, 87, 94, 78, 77, 85, 86 = 86

### Standard Deviation
    Standard deviation is a number that describes how spread out the values are.

    A low standard deviation means that most of the numbers are close to the mean (average) value.

    A high standard deviation means that the values are spread out over a wider range.

    Example: This time we have registered the speed of 7 cars:

    speed = [86,87,88,86,87,85,86]

    The standard deviation is:

    0.9

    Meaning that most of the values are within the range of 0.9 from the mean value, which is 86.4.
### Variance
    Variance is another number that indicates how spread out the values are.

    In fact, if you take the square root of the variance, you get the standard deviation!

    Or the other way around, if you multiply the standard deviation by itself, you get the variance!

    To calculate the variance you have to do as follows:

    1. Find the mean:

    (32+111+138+28+59+77+97) / 7 = 77.4

    2. For each value: find the difference from the mean:

    32 - 77.4 = -45.4
    111 - 77.4 =  33.6
    138 - 77.4 =  60.6
    28 - 77.4 = -49.4
    59 - 77.4 = -18.4
    77 - 77.4 = - 0.4
    97 - 77.4 =  19.6

    3. For each difference: find the square value:

    (-45.4)2 = 2061.16
    (33.6)2 = 1128.96
    (60.6)2 = 3672.36
    (-49.4)2 = 2440.36
    (-18.4)2 =  338.56
    (- 0.4)2 =    0.16
    (19.6)2 =  384.16
    4. The variance is the average number of these squared differences:

    (2061.16+1128.96+3672.36+2440.36+338.56+0.16+384.16) / 7 = 1432.2
    Luckily, NumPy has a method to calculate the variance:

 ###  Percentiles
    Percentiles are used in statistics to give you a number that describes the value that a given percent of the values are lower than.

    Example: Let's say we have an array of the ages of all the people that lives in a street.

    ages = [5,31,43,48,50,41,7,11,15,39,80,82,32,2,8,6,25,36,27,61,31]

    What is the 75. percentile? The answer is 43, meaning that 75% of the people are 43 or younger.

### Regression
    The term regression is used when you try to find the relationship between variables.

    In Machine Learning, and in statistical modeling, that relationship is used to predict the outcome of future events
-   Linear Regression
    Linear regression uses the relationship between the data-points to draw a straight line through all them.

    This line can be used to predict future values.