Smarket：A smart mobile platform online shopping system, 1) make shopping convenient from mobile device and 2) make shopping smarter by having choices for customers.

Group 7: Bei Liu(613792), Qingyang Hong(629379), Yanxu Zheng(575436), Rugang Yao(561747)

1. Program decomposition 

>Project management	
	Gradle: project managed by this automation tool, with flexibility of Ant and effectiveness of Maven.

>Backend 
	DBServlet: servlet in the server(Apache Tomcat), responsible of implementing connection to database(Mysql) and handling HttpServletRequest in doPost method and returning HttpServletResponse. Use JSONObject to encapsulate data as DAO and objects are sent back to Android device for parsing.

	Smarules: Recommendation module of Smarket. The scheme is based on association rule. For each user, the system generates a preference vector "P" according to user actions of rating, like, share. Association matrix "A" is stored in the database. Recommendation vector "Rv" can be calculated by Rv = PA. The system will return the most recommendable item to the user(1st rank in the Rv). 

>Device-end
	
	HomeFragment: the section of listing general products catalog.
	
	DiscoverFragment: the section of listing products pushed by recommendation system
	
	CartFragment: the section of shopping cart, which can save upaid items here and check out later
	
	MeFragment: the section contains personal information and purchase history
		
	SectionsPagerAdapter: Instantiation of above four sections and show on the homepage 

	ItemAdapter: a bridge between an AdapterView and the underlying product data for that view, which related to the presentation of item list in home, discovery and history section.	
	
	NetworkCheck： check the network connection status in real time. pop notification if connection is lost	
	
	LocalData, contains the functions that retrieve data from server and send request to server, including follows:
	
	1.loadHistory: load the purchase history data from server to device 
	2.loadCatalog: load the product catalog data from server to device
	3.Login: send username and password to server and obtain access
	4.addToHistory: send local purchase history to server
	5.LoadImageFromUrl: load image from url resources

	MainActivity: define all the general actions on the device 

	ItemDetailsActivity: implements the presentation of item picture, name, price, description, item rating, user 	comments, comment, rating and add item to cart.	
	
	Item: item class 

	HttpUtil: implementation of http connection of device-end


2. Member responsibility
	
	Rugang Yao(561747): Integration of device side and server side; implementation of communication; debugging the whole system
	Qingyang Hong(629379): Recommendation algorithm module, servlet-recommendation data module, database preparation.
	Yanxu Zheng(575436): device-end main contributor; app architecture 
	Bei Liu(613792): Project Manager, debugging and final testing


