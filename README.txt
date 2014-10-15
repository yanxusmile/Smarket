Smarket：A smart mobile platform retailing system, 1) make shopping convenient from mobile device and 2) make shopping smarter by having choices for customers.

Group 7: Bei Liu(613792), Qingyang Hong(629379), Yanxu Zheng(575436), Rugang Yao(561747)

1. Program decomposition 
	
	Gradle: project managed by this automation tool, with flexibility of Ant and effectiveness of Maven.

	DBServlet: servlet in the server(Apache Tomcat), responsible of implementing connection to database(Mysql) and handling HttpServletRequest in doPost method and returning HttpServletResponse. Use JSONObject to encapsulate data as DAO and objects are sent back to Android device for parsing.


	Smarules: Recommendation module of Smarket. The scheme is based on association rule. For each user, the system generates a preference vector "P" according to user actions of rating, like, share. Association matrix "A" is stored in the database. Recommendation vector "Rv" can be calculated by Rv = PA. The system will return the most recommendable item to the user(1st rank in the Rv). 





2. Member responsibility
	
	Qingyang Hong(629379): Recommendation algorithm module, servlet-recommendation data module, database preparation.
