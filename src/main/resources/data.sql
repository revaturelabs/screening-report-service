/* report service */
--------------------------------------------------------
--  SCREENER
--------------------------------------------------------
CREATE SEQUENCE    SCREENER_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

INSERT INTO SCREENER (SCREENER_ID,NAME,EMAIL) VALUES
(SCREENER_SEQUENCE.NEXTVAL, 'Smith, John', 'John.Smith@revature.com'),
(SCREENER_SEQUENCE.NEXTVAL, 'Smith, Jane', 'Jane.Smith@revature.com'),
(SCREENER_SEQUENCE.NEXTVAL, 'Walker, Paul', 'Paul.Walker@revature.com');

insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES
(1, 'Soft Skills', 1),
(2, 'Tech Skills', 1),
(3, 'Time Hacking Skills', 1),
(4, 'Basic Math Skills', 0),
(5, 'Advanced Math Skills', 0),
(6, 'Beta Skills', 0);

--------------------------------------------------------
--  CANDIDATE
--------------------------------------------------------
CREATE SEQUENCE    CANDIDATE_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 4321;

INSERT INTO CANDIDATE (CANDIDATE_ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values 
(CANDIDATE_SEQUENCE.NEXTVAL, 'dschrute@mailinator.com','Schrute, Dwight','700-864-1234',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'jhalpert@mailinator.com','Halpert, Jim','700-864-2345',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'amartin@mailinator.com','Martin, Angela','700-864-4567',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'kmalone@mailinator.com','Malone, Kevin','700-864-5678',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'abernard@mailinator.com','Bernard, Andy','700-864-6789',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'gadams@mailinator.com','Adams, Gary','700-864-7890',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'elawrence@mailinator.com','Lawrence, Elaine','700-864-8901',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'qleyton@mailinator.com','Leyton, Quinn','700-864-9012',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'dcoke@mailinator.com','Coke, Donovan','700-864-0123',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'bparish@mailinator.com','Parish, Brian','700-865-1234',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'tbrewster@mailinator.com','Brewster, Tera','700-865-2345',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'gjohnson@mailinator.com','Johnson, Garrett','700-865-3456',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'kwood@mailinator.com','Wood, Kelly','700-865-4567',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'mrose@mailinator.com','Rose, Marissa','700-865-5678',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'lhex@mailinator.com','Hex, Leonard','700-865-6789',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'sgermanotta@mailinator.com','Germanotta, Stefani','700-865-7890',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'elawrence@mailinator.com','Lawrence, Elaine','700-864-8901',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'qleyton@mailinator.com','Leyton, Quinn','700-864-9012',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'dcoke@mailinator.com','Coke, Donovan','700-864-0123',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'bparish@mailinator.com','Parish, Brian','700-865-1234',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'tbrewster@mailinator.com','Brewster, Tera','700-865-2345',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'gjohnson@mailinator.com','Johnson, Garrett','700-865-3456',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'kwood@mailinator.com','Wood, Kelly','700-865-4567',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'mrose@mailinator.com','Rose, Marissa','700-865-5678',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL,'lhex@mailinator.com','Hex, Leonard','700-865-6789',null,null),
(CANDIDATE_SEQUENCE.NEXTVAL, 'sgermanotta@mailinator.com','Germanotta, Stefani','700-865-7890',null,null);

--------------------------------------------------------
-- SCHEDULED_SCREENING
--------------------------------------------------------
CREATE SEQUENCE    SCHEDULED_SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 4321;

insert into SCHEDULED_SCREENING (SCHEDULED_SCREENING_ID, candidate_id, SKILL_TYPE_ID, status, scheduled_date) values 
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 1, 'SCREENED', (SYSDATE+13)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4325, 2, 'SCREENED', (SYSDATE+17)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 3, 'SCREENED', (SYSDATE+2)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4325, 4, 'PENDING', (SYSDATE+6)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4321, 5, 'SCREENED', (SYSDATE+35)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 6, 'PENDING', (SYSDATE+6)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4332, 1, 'PENDING', (SYSDATE+1)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4332, 2, 'PENDING', (SYSDATE+13)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4336, 3, 'SCREENED', (SYSDATE+4)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 4, 'PENDING', (SYSDATE+9)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4333, 5, 'SCREENED', (SYSDATE+12)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4333, 6, 'SCREENED', (SYSDATE+11)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4333, 1, 'PENDING', (SYSDATE+9)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4325, 2, 'PENDING', (SYSDATE+8)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4332, 3, 'PENDING', (SYSDATE+2)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4336, 4, 'PENDING', (SYSDATE+19)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 5, 'SCREENED', (SYSDATE+24)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4325, 6, 'SCREENED', (SYSDATE+20)),
(SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 4326, 1, 'SCREENED', (SYSDATE+1));

--------------------------------------------------------
-- SCREENING
--------------------------------------------------------
CREATE SEQUENCE SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 4321;

Insert into SCREENING (SCREENING_ID, SCREENER_ID, SKILL_TYPE_ID,
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) values 
(SCREENING_SEQUENCE.NEXTVAL, 3, 1, 50.0, 'intoComment','generalComment','softskillComment', '2018-03-01', '2018-03-02', 0, 'Completed', 4321),
(SCREENING_SEQUENCE.NEXTVAL, 2, 2, 80.0, 'intoComment2','generalComment2','softskillComment2', '2018-03-02', '2018-03-03', 0, 'Completed', 4322),
(SCREENING_SEQUENCE.NEXTVAL, 3, 2, 50.0, 'intoComment3','generalComment3','softskillComment3', '2018-03-04', '2018-03-05', 0, 'Completed', 4323),
(SCREENING_SEQUENCE.NEXTVAL, 2, 2, 50.0, 'intoComment4','generalComment4','softskillComment4', '2018-03-06', '2018-03-07', 0, 'Completed', 4324),
(SCREENING_SEQUENCE.NEXTVAL, 1, 3, 50.0, 'intoComment5','generalComment5','softskillComment5', '2018-03-08', '2018-03-09', 1, 'Pending', 4325),
(SCREENING_SEQUENCE.NEXTVAL, 1, 3, 50.0, 'intoComment6','generalComment6','softskillComment6', '2018-03-10', '2018-03-11', 1, 'Pending', 4326),
(SCREENING_SEQUENCE.NEXTVAL, 3, 4, 50.0, 'intoComment7','generalComment7','softskillComment7', '2018-03-11', '2018-03-12', 0, 'Pending', 4327),
(SCREENING_SEQUENCE.NEXTVAL, 3, 5, 50.0, 'intoComment8','generalComment8','softskillComment8', '2018-03-12', '2018-03-13', 1, 'Pending', 4328),
(SCREENING_SEQUENCE.NEXTVAL, 3, 5, 80.0, 'intoComment8','generalComment8','softskillComment8', '2018-03-13', '2018-03-14', 1, 'Pending', 4329),
(SCREENING_SEQUENCE.NEXTVAL, 1, 4, 50.0, 'intoComment9','generalComment9','softskillComment9', '2018-03-14', '2018-03-15', 1, 'Pending', 4330),
(SCREENING_SEQUENCE.NEXTVAL, 2, 4, 50.0, 'intoComment10','generalComment10','softskillComment10', '2018-03-15', '2018-03-16', 1, 'Completed', 4331),
(SCREENING_SEQUENCE.NEXTVAL, 3, 4, 50.0, 'intoComment11','generalComment11','softskillComment11', '2018-03-16', '2018-03-17', 0, 'Pending', 4332),
(SCREENING_SEQUENCE.NEXTVAL, 1, 5, 50.0, 'intoComment12','generalComment12','softskillComment12', '2018-03-17', '2018-03-18', 0, 'Completed', 4333),
(SCREENING_SEQUENCE.NEXTVAL, 1, 5, 50.0, 'intoComment13','generalComment13','softskillComment13', '2018-03-17', '2018-03-18', 0, 'Pending', 4334),
(SCREENING_SEQUENCE.NEXTVAL, 2, 2, 50.0, 'intoComment14','generalComment14','softskillComment14', '2018-03-18', '2018-03-19', 1, 'Completed', 4335),
(SCREENING_SEQUENCE.NEXTVAL, 3, 2, 80.0, 'intoComment15','generalComment15','softskillComment15', '2018-03-19', '2018-03-20', 1, 'Completed', 4336),
(SCREENING_SEQUENCE.NEXTVAL, 1, 2, 50.0, 'intoComment16','generalComment16','softskillComment16', '2018-03-21', '2018-03-22', 0, 'Pending', 4337),
(SCREENING_SEQUENCE.NEXTVAL, 2, 4, 50.0, 'intoComment17','generalComment17','softskillComment17', '2018-03-22', '2018-03-23', 1, 'Completed', 4338),
(SCREENING_SEQUENCE.NEXTVAL, 2, 3, 50.0, 'intoComment18','generalComment18','softskillComment18', '2018-03-23', '2018-03-24', 1, 'Pending', 4339),
(SCREENING_SEQUENCE.NEXTVAL, 3, 4, 50.0, 'intoComment19','generalComment19','softskillComment19', '2018-03-24', '2018-03-25', 1, 'Completed', 4331),
(SCREENING_SEQUENCE.NEXTVAL, 2, 1, 80.0, 'intoComment20','generalComment20','softskillComment20', '2018-03-25', '2018-03-26', 0, 'Pending', 4332),
(SCREENING_SEQUENCE.NEXTVAL, 1, 4, 50.0, 'intoComment21','generalComment21','softskillComment21', '2018-03-26', '2018-03-27', 1, 'Completed', 4333),
(SCREENING_SEQUENCE.NEXTVAL, 3, 5, 50.0, 'intoComment22','generalComment22','softskillComment22', '2018-03-27', '2018-03-28', 0, 'Completed', 4334),
(SCREENING_SEQUENCE.NEXTVAL, 3, 4, 80.0, 'intoComment23','generalComment23','softskillComment23', '2018-03-28', '2018-03-29', 1, 'Pending', 4335),
(SCREENING_SEQUENCE.NEXTVAL, 2, 3, 50.0, 'intoComment24','generalComment24','softskillComment24', '2018-03-29', '2018-03-30', 1, 'Pending', 4336),
(SCREENING_SEQUENCE.NEXTVAL, 1, 2, 50.0, 'intoComment25','generalComment25','softskillComment25', '2018-03-30', '2018-03-31', 0, 'Completed', 4337),
(SCREENING_SEQUENCE.NEXTVAL, 3, 1, 50.0, 'intoComment26','generalComment26','softskillComment26', '2018-04-01', '2018-04-02', 0, 'Pending', 4338),
(SCREENING_SEQUENCE.NEXTVAL, 1, 2, 50.0, 'intoComment27','generalComment27','softskillComment27', '2018-04-02', '2018-04-03', 1, 'Completed', 4339),
(SCREENING_SEQUENCE.NEXTVAL, 3, 5, 80.0, 'intoComment28','generalComment28','softskillComment28', '2018-04-03', '2018-04-04', 0, 'Pending', 4321),
(SCREENING_SEQUENCE.NEXTVAL, 2, 4, 50.0, 'intoComment29','generalComment29','softskillComment29', '2018-04-04', '2018-04-05', 1, 'Completed', 4322),
(SCREENING_SEQUENCE.NEXTVAL, 1, 3, 50.0, 'intoComment30','generalComment30','softskillComment30', '2018-04-05', '2018-04-06', 0, 'Pending', 4323),
(SCREENING_SEQUENCE.NEXTVAL, 2, 4, 50.0, 'intoComment31','generalComment31','softskillComment31', '2018-04-06', '2018-04-07', 1, 'Completed', 4324),
(SCREENING_SEQUENCE.NEXTVAL, 3, 5, 50.0, 'intoComment32','generalComment32','softskillComment32', '2018-04-07', '2018-04-08', 1, 'Pending', 4325),
(SCREENING_SEQUENCE.NEXTVAL, 1, 3, 50.0, 'intoComment33','generalComment33','softskillComment33', '2018-04-08', '2018-04-09', 0, 'Completed', 4326);


insert into bucket (bucket_id, screening_id, bucket_description, is_active) values
(404, 4321, 'Java Applied', true),
(407, 4322, 'Hibernate', true),
(406, 4323, 'SQL', true),
(410, 4323, 'Angular', true),
(411, 4325, 'Spring AoP', true),
(412, 4325, 'JavaScript', true),
(413, 4325, 'Java Concepts', true),
(414, 4325, 'SOAP', true),
(415, 4326, 'JDBC', true),
(416, 4326, 'REST', true);

insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, BUCKET_ID, SKILL_TYPE_ID) values 
(51404, 30, 404, 1),
(52404, 100, 404, 2),
(53404, 70, 404, 3),
(54405, 100, 406, 4),
(53405, 30, 406, 3),
(55405, 100, 412, 5),
(56406, 100, 406, 6),
(51406, 70, 406, 1);

insert into QUESTION (QUESTION_ID, BUCKET_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER_1, SAMPLE_ANSWER_2, SAMPLE_ANSWER_3, SAMPLE_ANSWER_4, SAMPLE_ANSWER_5) values 
(10010,406,1,'What joins are used in SQL?' , 'Primarily together, under me. ' , 'Only self. All joins are self joins. ' , ' Self, inner.' , ' Self, inner, outer, left , right. ' , 'Self, inner, outer, left, right, natural. ' ),
(10011,406,1,'What are the sublanguages of SQL?' , 'French, spanish, portuguese. ' , 'DML ' , ' DML, DDL' , ' DML,DDL,DQL,DCL ' , 'DML,DDL, DQL, DCL, TCL.' ),
(10012,406,1,'What is the difference between drop and truncate?' , 'There is no difference. ' , 'Truncate is faster than drop. ' ,'One is DML and the other is DDL', ' Neither can be rolled back and both and DDL. Truncate is faster than drop. ' , 'Truncate removes the data from the database but leaves the underlying table structure. Drop removes the table entirely including the schema and the associated data.' ),
(10007,414,1,'What transfer protocols are available in SOAP?' , 'No transfer protocols are required in SOAP, hence its popularity. ' , 'Http is supported by SOAP, as by most other service architectures. ' , ' SOAP supports http as well as ftp' , ' SOAP supports http, ftp, and sftp. ' , 'SOAP supports any number of transfer protocols including http, ftp, sftp, and https.' ),
(10008,414,1,'What tags are used in the WSDL?' , 'html,h1, h2. ' , 'Operation ' , ' Binding, operation, port.' , ' Binding, operation, port, port type, message, documentation. ' , 'Binding, operation, port, port type, message, documentation, definition, service.' ),
(10009,414,1,'What tags are used for a SOAP message?' , 'S,M,L, XL ' , 'Body ' , ' Body, header' , ' Body, header, envelope ' , 'Body, header, envelope, fault. Body and envelope are mandatory, the other tags are optional. The fault tag itself contains several tags, namely fault-actor, fault-string, fault-code, and fault-details.' ),
(10004,416,1,'What operations in REST are idempotent?' , 'None, no operation can grasp the power of idem, its logically impossible. ' , 'GET and PUT ' , ' GET, PUT, POST, DELETE.' , 'GET, PUT, DELETE. ' , ' GET, PUT, and DELETE. An idempotent operation can be repeated an arbitrary number of times without changing the database state. ' ),
(10005,416,1,'How many languages can be used in a REST service?' , 'One, REST only supports Java. ' , 'Two, REST is compatible with both the Java and .Net stacks. ' , ' Three. REST supports Java, C, and JavaScript in order to provide web and back end functionality. ' , 'Any amount. ' , ' REST affords interoperability which allows any number of languages to be used simultaneously to create the service. ' ),
(10006,416,1,'What data transmission formats are available in REST? ' , 'The REST format. ' , 'REST uses XML only. ' , ' REST supports XML and JSON. ' , ' REST supports XML, JSON, and plain text. ' , 'REST supports any number of data formats including XML, JSON, YAML, and plain text. ' ),
(10001, 415, 1,'What are the primary JDBC interfaces?' , 'Session, session factory ' , 'Connection ' , ' Connection, Statement' , 'Connection, Statement, Prepared Statement, Callable Statement ' , ' Connection, Statement, Prepared Statement, Callable Statement, Result Set,  Savepoint ' ),
(10002, 415, 1,'What is JDBC?' , 'Junior Dominican-Brazilian Coalition ' , 'Java DataBase Connection  ' , ' Java DataBase Connection. Used to connect Java to the database.' , 'Java DataBase Connection. Used to connect Java to a SQL database. ' , ' Java DataBase Connection. Used to connect Java to a SQL database. Uses statements, prepared statements, and callable statements to either send raw SQL to the database to be executed or execute prepared SQL statements on the java side. ' ),
(10003, 415, 1,'What is the difference between statements and prepared statements and why would we prefer one over the other?' , 'There is no difference.' , 'A statement is written using standard SQL syntax and a prepared statement is written differently' , ' Statements use raw SQL while prepared statements do not.' , 'A prepared statement has hardline requirements for the form of the data entered and executes the prepared SQL statement on the Java side. In contrast statements execute raw SQL in the SQL database itself and are therefore vulnerable to SQL injection. ' , ' A prepared statement parses the SQL statement to be executed, compiles it on the Java side, which allows more control and prevents SQL injection. Statements use raw SQL which is compiled by the database and can be SQL injected.' ),
(1007, 410, 1, 'What is angular?', 'An obtuse angle.', 'Something to do with development', 'A web framework', 'Brumley Right answer', 'Fully correct answer.'),
(1008, 410, 1, 'What are the 4 bindings?', 'Handcuffs, ball and chain, ..', 'Something to do with component and dom...', 'Names 2 of the 4.', 'Brumley Right.', 'Two way binding, event binding, interpolation, and property binding and description of each.'),
(1009, 411, 1, 'What is an Aspect?', 'A what?', 'Something about paradigmns... ', 'A class', 'Brumley Right', 'Aspects in spring AoP are a class that is used modularize cross cutting concerns. (more details...)'),
(1010, 411, 1, 'What are the ways you can advise a method?', 'Asking the instructor for advice????', '1 of 5', '3 of 5', 'Brumley Right', '@Before, @After, @AfterReturns, @AfterThrows, @Around.'),
(1011, 412, 1, 'What is JavaScript?', 'A script I use to write my starbucks order on.', 'A programming language', 'A programming language for the web!', 'Brumley Right.', 'JavaScript is a dynamicly typed interpreted programming language that runs in most major browsers as well as serverside through things like node.js... blah blah blah.'),
(1012, 412, 1, 'What values are falsey in JavaScript?', 'Anything that is not truthy!', '1 of 6', '3 of 6', 'Brumley Right', 'false, 0, empty string, NaN, ndefined, null'),
(1013, 413, 1, 'What is Java?', 'Coffee', 'A programming langauge... Richard talked about it for like a week yo.', 'Java is a C like language that does objects!!.', 'Brumley Right', 'Java is a OOP language derived from C that has garbage collection, runs on any machine a JRE can run and is strongly typed. More stuff.... '),
(1014, 413, 1, 'What are the 8 primative types in Java?', '7 monkeys?', '2 of 8', '4 of 8', 'Brumley Right', 'float, double, int, long, short, byte, char, boolean.'),
(1015, 414, 1, 'What is SOAP?', 'Something I use once a year.', 'Simple .... protocol??', 'Simple Object Access Protocol', 'Brumley Right', 'Simple Object Access Protocol that uses a WSDL file to ensure the client and server speak the same language and blah blah blah blah blah.'),
(1016, 414, 1, 'What are your WSDL tags?', 'My what?', '2 of 9', '4 of 9', 'Brumley Right', 'Definitions, types, message, operation, port type, bindings, port, services, documentation.');

--------------------------------------------------------
--  VIOLATION_TYPE
--------------------------------------------------------
CREATE SEQUENCE   VIOLATION_TYPE_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 4321;

Insert into VIOLATION_TYPE (VIOLATION_TYPE_ID, violation_type, DESCRIPTION) values
(VIOLATION_TYPE_SEQUENCE.NEXTVAL, 'Profanity', 'Expletives were used.'),
(VIOLATION_TYPE_SEQUENCE.NEXTVAL, 'Attire', 'Attire was not appropriate.'),
(VIOLATION_TYPE_SEQUENCE.NEXTVAL, 'Unfocused', 'Focus was not fully on the screening.');

--------------------------------------------------------
--  SOFT_SKILL_VIOLATION
--------------------------------------------------------
CREATE SEQUENCE   SOFT_SKILL_VIOLATION_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 4321;

Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) values 
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4321, 4321, 'After failing a question, candidate started swearing.', '2018-03-01'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4322, 4321, 'Swore when yelling out to someone else behind him.', '2018-03-02'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4323, 4322, 'Was wearing pajamas', '2018-03-04'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4325, 4322, 'Wearing a graphic t-shirt.', '2018-03-06'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4326, 4323, 'Had many people in the same room. Was drinking.', '2018-03-08'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4327, 4323, 'He kept wandering off topic, was browsing a site.', '2018-03-10'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4328, 4323, 'Wearing a nasty t-shirt', '2018-03-11'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4329, 4321, 'Distracted', '2017-03-12'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4330, 4322, 'Cheating', '2017-03-13'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4331, 4322, 'Swearing', '2017-03-14'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4332, 4321, 'Not polite', '2017-03-15'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4333, 4323, 'Rude', '2017-03-16'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4334, 4322, 'Did not take it seriously', '2017-03-17'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4335, 4322, 'Inapproprite clothing', '2016-03-18'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4336, 4321, 'Swore when yelling out to someone else behind him.', '2016-03-19'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4337, 4321, 'He kept wandering off topic, was browsing a site.', '2016-03-20'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4338, 4321, 'Had many people in the same room. Was drinking.', '2016-03-21'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4339, 4323, 'Smoking', '2016-03-22'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4340, 4323, 'After failing a question, candidate started swearing.', '2016-03-23'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4341, 4322, 'He kept wandering off topic, was browsing a site.', '2016-03-24'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4342, 4322, 'Was wearing pajamas', '2016-03-25'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4343, 4321, 'After failing a question, candidate started swearing.', '2015-03-26'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4344, 4321, 'Wearing a nasty t-shirt', '2015-03-27'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4345, 4323, 'Had many people in the same room. Was drinking.', '2015-03-28'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4346, 4322, 'Swearing', '2015-03-29'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4347, 4321, 'Distracted', '2015-03-30'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4348, 4323, 'He kept wandering off topic, was browsing a site.', '2015-03-31'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4349, 4323, 'Wearing a graphic t-shirt.', '2015-04-01'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4350, 4322, 'Swore when yelling out to someone else behind him.', '2015-04-02'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4351, 4322, 'Had many people in the same room. Was drinking.', '2015-04-03'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4352, 4322, 'Extremely distracted, was texting.', '2015-04-04'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4353, 4321, 'Had many people in the same room. Was drinking.', '2015-04-05'),
(SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 4354, 4321, 'Wearing a graphic t-shirt.', '2015-04-06');

 
COMMIT;

--------------------------------------------------------
--  QUESTION_SCORE
--------------------------------------------------------
CREATE SEQUENCE   QUESTION_SCORE_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 4321;

Insert into QUESTION_SCORE (QUESTION_SCORE_ID, QUESTION_ID, BUCKET_ID, SCREENING_ID, SCORE, COMMENT, TIME) values 
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10010, 406, 4321, 3, 'Basic knowledge, average.', '2018-03-01'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10011, 406, 4321, 2, 'some understanding.', '2018-03-02'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10012, 406, 4321, 5, 'good', '2018-03-03'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10007, 414, 4322, 5, 'good', '2018-03-04'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10008, 414, 4322, 1, 'Bad wording, not sure they understand', '2018-03-05'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10009, 414, 4323, 3, 'Basic knowledge, average.', '2018-03-06'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10004, 416, 4322, 2, 'some understanding.', '2018-03-07'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10005, 416, 4324, 5, 'good', '2018-03-08'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10004, 406, 4325, 5, 'good', '2017-03-09'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10003, 406, 4326, 1, 'good', '2017-03-10'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10012, 406, 4327, 1, 'some understanding.', '2017-03-11'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10011, 406, 4328, 1, 'some understanding.', '2017-03-12'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10010, 406, 4329, 5, 'some understanding.', '2017-03-13'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10009, 406, 4330, 5, 'Basic knowledge, average.', '2017-03-14'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10007, 415, 4331, 5, 'Basic knowledge, average.', '2017-03-15'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10006, 415, 4332, 5, 'Basic knowledge, average.', '2017-03-16'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10008, 415, 4333, 3, 'good', '2017-03-17'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10003, 415, 4334, 3, 'good', '2017-03-18'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10008, 415, 4335, 3, 'good', '2017-03-19'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10006, 415, 4336, 3, 'good', '2016-03-20'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10003, 415, 4337, 2, 'Bad wording, not sure they understand', '2016-03-21'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10002, 414, 4338, 2, 'Bad wording, not sure they understand', '2016-03-22'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10011, 414, 4339, 2, 'Bad wording, not sure they understand', '2016-03-23'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10012, 414, 4340, 2, 'Bad wording, not sure they understand', '2016-03-24'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10009, 414, 4341, 1, 'some understanding.', '2016-03-25'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10007, 414, 4342, 1, 'some understanding.', '2016-03-26'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10003, 414, 4343, 1, 'some understanding.', '2016-03-27'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10004, 415, 4344, 1, 'some understanding.', '2016-03-28'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10005, 415, 4345, 5, 'good', '2016-03-29'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10008, 415, 4346, 5, 'good', '2016-03-30'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10008, 415, 4347, 5, 'good', '2016-03-31'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10007, 415, 4348, 5, 'good', '2015-04-01'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10002, 415, 4349, 5, 'good', '2015-04-02'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10003, 406, 4350, 2, 'Bad wording, not sure they understand', '2015-04-03'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10005, 406, 4351, 2, 'Bad wording, not sure they understand', '2014-04-04'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10004, 406, 4352, 2, 'Bad wording, not sure they understand', '2014-04-05'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10006, 406, 4353, 2, 'Bad wording, not sure they understand', '2014-04-06'),
(QUESTION_SCORE_SEQUENCE.NEXTVAL, 10007, 406, 4354, 3, 'Bad wording, not sure they understand', '2014-04-07');

COMMIT;
