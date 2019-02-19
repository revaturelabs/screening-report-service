#### package com.revature.screenforce.util

# public class Time

### Convenience class to filter reports based on number of past weeks, months, years

#### getWeekToDate

##### public java.time.LocalDate getWeekToDate(int numWeeks)

Parameters:

*numWeeks* - The number of weeks

*Returns*:
The start date in UTC numWeeks prior from now


#### getMonthToDate

##### public java.time.LocalDate getMonthToDate(int numMonths)

Parameters:

*numMonths* - The number of months

*Returns*:
The start date in UTC numMonths prior from now


#### getYearToDate

##### public java.time.LocalDate getYearToDate()

*Returns*:
return The start date in UTC of January 1st of the current year


**Useful Links** 
- [Java LocalDate Tutorial](http://tutorials.jenkov.com/java-date-time/localdate.html)
- [Oracle Java API: LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)
