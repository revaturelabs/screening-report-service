# Screen Reporting Service

***

## Purpose
The screening reports service is responsible for generating and displaying reports of aggregate scores of Revature applicants given by Revature screeners during interviews. The reports contain information on overall pass rates per skill level, per bucket, and per screener for a given time period.

***
## Utils
## Time Util
Convenience class to filter reports based on the number of past weeks, months, years.
### getWeekToDate
This method accepts an int parameter represents the number of weeks and returns the start date in UTC from the number of weeks prior from now.
### getMonthToDate
This method accepts an int parameter that represents the number of months and returns the start date in UTC from the number of months prior from nom.
### getYearToDate
This method accepts no parameters and returns the start date in UTC of January 1st of the current year.
***

## Beans
This service utilizes 12 beans
- Bucket: holds a set of related Questions
- Candidate: an object representing a candidate that is being screened
- Question: an object representing a question to ask a candidate, along with 5 sample questions with varying correctness
- ScheduledScreening: an object representing a Scheduled Screening that contains information on skills and timing
- ScheduledStatus: an object representing a JSON property of either pending or screened
- Screener: an object representing the screener that is conducting the interview
- Screening: an object to record the result of screening a candidate
- SimpleQuestionScore: an object representing the score a candidate achieved on a question
- SkillType: an object representing skill type corresponding to an overall training track, associated with a number of Buckets
- SoftSkillViolation: an object representing any violations that happen during the course of a screening
- ViolationType: an object representing all of the possible types of violations
- Weight: an object representing the weights for Buckets within a SkillType, determining how a Bucket contributes to the final score
***
## Controllers
This service utilizes one controller.
## Reports Controller
This controller contains the mappings that will be utilized by the UI.
- /email: accepts a request parameter of an email and returns a JSON list with all emails that match the parameter.
- /data: accepts a request parameter of weeks and an optional email. it returns a JSON list of the five reporting metrics. If the email is passed in it returns the metrics for that specific screener if not it returns the metrics for all screeners.
## DAOs
This service utilizes nine data access objects.
The DAOs include:
- BucketDAO: DAO Repository for Bucket utilizing JpaRepository & CrudRepository interface methods used to fetch and manipulate Buckets
- QuestionDAO: DAO Repository utilizing JpaRepository & CrudRepository interface methods used to fetch and manipulate Questions
- SkillTypeDAO: DAO Repository for the SkillType utilizing JpaRepository & CrudRepository interface methods used to fetch and manipulate SkillTypes
- WeightDAO: DAO Repository for Weight utilizing JpaRepositroy & CrudRepository interface methods used to fetch and manipulate Weights
- QuestionScoreRepository: DAO Repository utilizing JpaReposity & CrudRepositry interface methods used to fetch Question Score.
- ScheduledScreeningRepository: DAO Repository utilizing JpaReposity & CrudRepositry interface methods used to fetch Scheduled Screening
- ScreeningRepository: DAO Repository utilizing JpaReposity & CrudRepositry interface methods used to fetch Screening id
- SoftSkillViolationRepository: DAO Repository utilizing JpaReposity & CrudRepositry interface methods used to fetch Soft Skill Violation type
- ViolationTypeRepository: DAO Repository utilizing JpaReposity & CrudRepositry interface methods used to fetch Violation type
