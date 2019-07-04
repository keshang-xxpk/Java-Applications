 1. Twitter CLI App
TwitterCLI Demo
1.1. Explore Twitter REST API 1.2. Explore Twitter REST API
Install Postman app to send HTTP requests
https://developer.twitter.com/en/docs
REST API Request Demo
Get keys and tokens from APPS dashboard Send an HTTP GET request on Postman
https://api.twitter.com/1.1/statuses/user_timeli ne.json?screen_name=realDonaldTrump
Setup oauth1.0
Discuss HTTP request (params, headers, auth)
Discuss HTTP response (body, headers, status, etc)
Discuss oauth 1.0 https://developer.twitter.com/en/docs/basic s/authentication/guides/authorizing-a-request
   `java -jar java_apps-1.0-SNAPSHOT.jar post "my first
tweet" "-10:20"

 Setup Twitter API
Create a Twitter Developer Account
Create an App through the developer dashboard Obtain key and tokens
Twitter CRUD with Postman
Create an tweet on your timelines
Read tweet timelines by screen_name or user_id Update tweet(not available)
Delete a tweet by tweet ID
1.3. Java Http Client and JSON processing
Popular HTTP client libraries:
java.net package (java build-in)
Apache Http Components http://hc.apache.org/httpcomponents-client-4.5.x/index.html Jetty (eclipse)
Many others https://github.com/search?o=desc&q=java+http+client&s=star s&type=Repositories
We will be using Apache Http Components to in this app.
Apache Http Components
http://hc.apache.org/httpcomponents-client-4.5.x/index.html

 auth 1.0 https://oauth.net/1/
SignPost https://github.com/mttkay/signpost
1.3.1. HTTP Client with Oauth setup
edit pom.xml
           <!--oauth 1.0 and httpclient4-->
    <dependency>
      <groupId>oauth.signpost</groupId>
      <artifactId>signpost-core</artifactId>
      <version>1.2.1.2</version>
    </dependency>
    <dependency>
      <groupId>oauth.signpost</groupId>
      <artifactId>signpost-
commonshttp4</artifactId>
      <version>1.2.1.2</version>
    </dependency>
Discuss what has changed in IDE External Libraries
Maven Dependencies
Maven .m2/
Add ca.jrvs.apps.twitter.example.TwitterApiTest.java
        package ca.jrvs.apps.twitter.example;
import java.util.Arrays;
import oauth.signpost.OAuthConsumer;

    import
oauth.signpost.commonshttp.CommonsHttpOAuthConsumer
;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import
org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
public class TwitterApiTest {
  private static String CONSUMER_KEY = "";
  private static String CONSUMER_SECRET = "";
  private static String ACCESS_TOKEN = "";
  private static String TOKEN_SECRET = "";
  public static void main(String[] args) throws
Exception {
    //setup oauth
    OAuthConsumer consumer = new
CommonsHttpOAuthConsumer(CONSUMER_KEY,
        CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN,
TOKEN_SECRET);
    // create an HTTP GET request
    HttpGet request = new HttpGet(

   "https://api.twitter.com/1.1/users/search.json?
q=realDonaldTrump");
    // sign the request (add headers)
    consumer.sign(request);
    System.out.println("Http Request Headers:");
 Arrays.stream(request.getAllHeaders()).forEach(Sys
tem.out::println);
    // send/execute the request
    HttpClient httpClient = new
DefaultHttpClient();
    HttpResponse response =
httpClient.execute(request);
 System.out.println(EntityUtils.toString(response.g
etEntity()));
} }
 Insert your twitter key and tokens and test request
Discuss HttpGet header and HttpResponse (using IDE debug)
Discuss EntityUtils.toString source code. How to use IDE to view source code.
Discuss why hardcoding key and tokens is not a good practice Solution 1: using java arguments

 Solution 2: use environmental variable System.getEnv 1.4. Jackson JSON
     Terminology
  Definition
   Example
   Serialization
To serialize an object means to convert its state to a byte stream so that the byte stream can be reverted into a copy of the object https://docs.oracle.c om/javase/tutorial/jndi/objects/ serial.html
      Save Java Object as a JSON file.
 Deserialization
   The process of converting the serialized form of an object back into a copy of the object ht tps://docs.oracle.com/javase/tu torial/jndi/objects/serial.html
       Read a JSON file and convert to a Java Object
       Parsing
The process of analyzing a string of symbols, either in natural language, computer languages or data structures, conforming to the rules of a formal grammar https://en.wiki pedia.org/wiki/Parsing
Read some text, and find useful information based on some kind of rule you are following. Generally speaking, parsing =

       processing text.
      Marshal/Unmarshal
   The process of transforming the memory representation of an object to a data format suitable for storage or transmission, and it is typically used when data must be moved between different parts of a computer program or from one program to another.
      In most case, Marshaling and serialization are loosely synonymous in the context
 1.4.1. Jackson JSON Practice
1. Addinganewdependencyinpom.xml
  <!--Jackson JSON-->
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.9.4</version>
</dependency>
2. CheckyourIDEexternallibrariessectionandobservewhat dependencies have been added to your project
3. JSONdocument-Company
  {
   "symbol":"AAPL",

       "companyName":"Apple Inc.",
   "exchange":"Nasdaq Global Select",
   "description":"Apple Inc is designs,
manufactures and markets mobile communication and
media devices and personal computers, and sells a
variety of related software, services, accessories,
networking solutions and third-party digital
content and applications.",
   "CEO":"Timothy D. Cook",
   "sector":"Technology",
   "financials":[
      {
         "reportDate":"2018-12-31",
         "grossProfit":32031000000,
         "costOfRevenue":52279000000,
         "operatingRevenue":84310000000,
         "totalRevenue":84310000000,
         "operatingIncome":23346000000,
         "netIncome":19965000000
}, {
"reportDate":"2018-09-30",
"grossProfit":24084000000,
"costOfRevenue":38816000000,
"operatingRevenue":62900000000,
"totalRevenue":62900000000,
"operatingIncome":16118000000,
"netIncome":14125000000
} ],
"dividends":[

  } ]
}
{
   "exDate":"2018-02-09",
   "paymentDate":"2018-02-15",
   "recordDate":"2018-02-12",
   "declaredDate":"2018-02-01",
   "amount":0.63
}, {
"exDate":"2017-11-10",
"paymentDate":"2017-11-16",
"recordDate":"2017-11-13",
"declaredDate":"2017-11-02",
"amount":0.63
 5. Discusssomeofthefinancialterms
6. Readtheofficialdocumentandwritethefollowingtwo methods: https://github.com/FasterXML/jackson-databind/
   /**
 * Convert a java object to JSON string
 * @param object input object
 * @return JSON String
 * @throws JsonProcessingException
 */
public static String toJson(Object object, boolean
prettyJson, boolean includeNullValues) throws
JsonProcessingException {}

  /**
 * Parse JSON string to a object
 * @param json JSON str
 * @param clazz object class
 * @param <T> Type
 * @return Object
 * @throws IOException
 */
public static <T> T toObjectFromJson(String json,
Class clazz) throws IOException {}
 7. Samplecodewalkthrough
   ca.jrvs.apps.twitter.example.JsonParser
   !"" JsonParser.java #"" dto
!"" Company.java !"" Dividend.java #"" Financial.java
7. ExceptionRuntimeExceptionvsExceptionhttps://docs.oracle.c om/javase/tutorial/essential/exceptions/runtime.html https://h owtodoinjava.com/best-practices/java-exception-handling-bes t-practices/
Don't get frustrated if you are not sure how to design exception throwing. Start with following tips.
Throw specific exception rather than generic Exception

   public void foo() throws Exception {} //Incorrect
way
public void foo() throws SpecificException1,
SpecificException2{} //Correct way
Catch specific exception rather than generic Exception
   try {
    someMethod();
} catch (Exception e) { //Incorrect
} catch (IOException e) //Correct
DO NOT return in catch block
   catch (NoSuchMethodException e) {
    return null; //Incorrect
    System.out.println(e.getMessage());
//Incorrect (double logging)
    throw RuntimeException("failed method" +
e.getMessage()); //Incorrect
    throw RuntimeException("failed method reson",
e); //Correct
}
1.5. Twitter CLI App
Build a Twitter CLI App that can CRUD(create, read, update, delete) tweets.
Create a tweet on your timeline

   USAGE: TwitterCLI post "tweet_text"
"latitude:longitude"
Description: Create a tweet with a geotag and
output the created tweet object(simplifeid version)
in JSON  format.
Arguments:
tweet_text         - tweet_text cannot exceed 140
UTF-8 encoded characters.
latitude:longitude - Geo location.
The official tweet object is a huge document. In this app, you are required to create a simplified tweet object dto (e.g. ca.jrvs.apps.twitter.dto.Tweet)
     //Simplified Tweet Object
{
   "created_at":"Mon Feb 18 21:24:39 +0000 2019",
   "id":1097607853932564480,
   "id_str":"1097607853932564480",
   "text":"test with loc223",
   "entities":{
      "hashtags":[],      //Find the object def
in twitter docs
      "user_mentions":[]  //Find the object def
in twitter docs
},
   "coordinates":null,    //Find the object def
in twitter docs
"retweet_count":0,

     "favorite_count":0,
   "favorited":false,
   "retweeted":false
}
 People might use the following terms interchangeably (although they are slightly different):
Data model Java pojo Object mapping
NOTE: you need to enable location in setting > privacy > location. Otherwise, geo info will be ignored by the Twitter API
Hint: you are expected to create 5 models/pojos/mapping classes.
Hint: tweet object docs link
Hint: find a tool that can auto-generate Java Pojos link Read/Show a tweet by ID
              USAGE: TwitterCLI show tweet_id [field1,fields2]
e.g.
TwitterCLI show 1097607853932564480
"id,text,retweet_count"
{
    "id": 1097607853932564480,
    "text": "test with loc223",
    "retweet_count": 0

  }
Description: Lookup a tweet by ID and print the
tweet object in JSON format. Show all fields in
JSON document if [field1,fields2] is empty.
Otherwise, only show user specified [fields] in the
JSON document.
Arguments:
tweet_id  - Tweet ID. Same as id_str in the tweet
object
[field1,fields2]  - (Optional) A comma-separated
list of top-level fields from the tweet object
(similar to SELECT clause in SQL)
 Update tweet(twitter doesn't allow update) Delete a tweet by tweet ID
     USAGE: TwitterCLI delete tweet_ids
Description: Delete a list of tweets by id
Output deleted tweet id and print deleted tweet
object.
Arguments:
tweet_ids - A comma-separated list of tweets.
1.5.1. Component Design

 Discuss high-level component desgin diagram(bottom to top approach):
  Component
   Description
     HttpHelper
 Making HTTP requests (GET/PUT/DELETE) and handle auth
 Dao
    Data Access Object which handles tweet object (Dao depends on HttpHelper)
     Service
 Business logic. In other words, it depends on Dao, and manipulate twitter object according to application requirements (e.g. select certain fields when showing tweet object) Runner - Parse use input and calls corresponding service methods
     Runner
   Parse use input and calls corresponding service methods
 Main
   Create above components and start applications
   TODO diagram
1.5.1.1. Implement HttpHelper

   package ca.jrvs.apps.twitter.dao.helper;
public interface HttpHelper {
  HttpResponse httpPost(URI uri);
  HttpResponse httpPost(URI uri, StringEntity
stringEntity);
  HttpResponse httpGet(URI uri);
}
1. Discusswhyuseinterface?(Hint:HttpClientvendorsand different auth mechanisms)
2. Implement
   ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper
3. HowtouseEnvironmentVariabletopasskeyandtokens.
Setup parent env var in IntelliJ
     #put the following env var in ~/.bash_profile
export consumerKey=
export consumerSecret=
export accessToken=
export tokenSecret=
$ source ~/.bash_profile
$ idea
4. Codereviewanddiscussion:
(Optional) Discuss DefaultHttpClient source code (show how to navigate source code) (Optional)HttpEntityEnclosingRequestBase vs

        HttpGet/HttpPost
5. Unittest
ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelperIntTe st (without Mockito)
What are some limitations in this test? (Hint: environments)
Why use Mockito?
6. Introducingtheleveloftestinghttps://en.wikipedia.org/wiki/S oftware_testing#Testing_levels
              Level
    Definition
   Reality
   When
 Unit Testing
   Testing individual class/component
  Hard for poorly designed programs. Need some good practice.
Use mocking framework (e.g., Mockito) to mock dependency behaviors.
  Before coding(ideally !)
    Integration Test
 Test a group of classes/components
Require environment setup. e.g., A database, web server, some API.
It's common people confused it with system testing or end-to- end testing.
It's
   After coding
 System Test
     Test a software as a whole
    Some people call it end-to-end testing. Similar to black box testing.
    Every Sprint(Agile)
 Operational Acceptance Testing(OAT)
  Operational readiness (pre- release) of a product
 Some people may call it end2end testing too.
May involve other teams.
e.g. upstream send data > your program > deliver data to downstream
  Before release
  1.5.1.2. Implement TwitterRestDao

   package ca.jrvs.apps.twitter.dao;
public interface CrdRepository<T, ID> {
  T save(T entity);
  T findById(ID id);
  T deleteById(ID id);
}
Discuss what does <T, ID mean.
public class TwitterRestDao implements
   CrdRepository<Tweet, String>
1. Implement
   ca.jrvs.apps.twitter.dao.TwitterRestDao#findById
High-level steps
               //Construct URI
//Execute HTTP Request
//Validate response and deser response to Tweet
object
Tip: Making your code readable
Your public method should have simple logic steps. It should be read like plain english.
Seperate detailed code into protected and private logic
Lambda Challenge: Validate ID string without JDK parser (Twitter ID def: https://developer.twitter.com/en/docs/basic s/twitter-ids). (In other words, how to validate that every char in a String is a number.)

 Discuss StringBuilder vs. StringBuffer vs. String concat in #getShowUri method
Discuss EntityUtils.toString and InputStream 2. Testing
Integration Testing TwitterRestDaoIntTest (Should have done unit testing first)
Unit Testing TwitterRestDaoUnitTest
Mocking Framework concept (e.g. class dependency
DAO > HttpHelper > Twitter API) Terminology
Mock / InjectMock Spy and Stub Verify / Matcher
3. Implement#postTweetandwriteIntegrationandUnittests
What's URL percentage encoding?
Consider some edge cases when checking params
4. Implement#deleteTweetandwriteIntegrationandUnittests
1.5.1.3. Implement TwitterService

   package ca.jrvs.apps.twitter.service;
   public interface TwitterService {
     void postTweet(String text, Double latitude,
Double longitude);
     void showTweet(String id, String[] fields);
     void deleteTweets(String[] ids);
}
1. Implement(easy)
      ca.jrvs.apps.twitter.service.TwitterServiceImp.pos
     tTweet
      ca.jrvs.apps.twitter.service.TwitterServiceImp.del
     eteTweets
2. ImplementshowTweet Discuss possible solutions
(Easy) ??
(advanced) Use Java annotation and class reflection Write unit test for
Discuss pseudo code
Class reflection: todo
Annotation: todo
Implement selectFields method
                         protected Tweet selectFields(Tweet tweet, String[]
fields) throws IOException

 1.5.1.4. Implement TwitterCLI
1.5.1.4.1. Implement TwitterCLIRunner (Provided if time is
limited)
1.5.1.4.2. Discuss what is class dependency
TwitterCLIRunner > TwitterService > CrdRepository > HttpHelper
1.5.1.4.3. Traditional Dependency Management
1. DrawadiagramforTwitterCLIapp
2. Implementca.jrvs.apps.twitter.TwitterCLI#main

   //Create components
//Create Runner
//Run Application
Test the application on CLI
Discuss the disadvantage of traditional dependency management
1.5.1.4.4. Introduction to the Spring IoC container and beans

   Concept
  Definition
   Oversimplifeid Definition
 Inversion of Control(IoC)=Dependency Injection (DI)
 In IoC, custom-written portions of a computer program receive the flow of control from a generic framework. https://en.wikipedia.org/wiki/Inver sion_of_control
    Instead of traditional decency management, a framework creates components/JavaBeans/Objects ( e.g. new TwitterService() and figure out class dependency.
    JavaBean or Bean
 JavaBeans are classes that encapsulate many objects into a single object (the bean). They are serializable, have a zero-argument constructor, and allow access to properties using getter and setter methods. The name "Bean" was given to encompass this standard, which aims to create reusable software components for Java. wiki
     TiwtterRestDao , TwitterServiceImp , TwitterCLIRunner are all
JavaBeans. Generally speaking, JavaBeans are java objects that are managed by IoC. (Not all objects are beans)
     1.5.1.4.5. Spring Framework Setup
    <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-
parent</artifactId>
    <version>2.1.3.RELEASE</version>
    <relativePath/>
</parent>
    <!--spring-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>

        <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-
test</artifactId>
      <scope>test</scope>
    </dependency>
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-
plugin</artifactId>
      </plugin>
    </plugins>
  </build>
 todo: fix http client version issue after introducing starter parent
Discuss why don't Spring dependencies have version specified? (hint: inherit)
Check the external library in the IDE
Remove version from jackson-databind, mockito-core,
junit as versions are inherited from project parent
1.5.1.4.6. Spring Bean Approach
This approach show the fundamental concept of Spring IoC, and help you to understand the lower level IoC mechanism. In real development, you are unlikely to use this approach to config you entire application. However, when your application requires third- party Spring modules, this approach comes handy.

  ca.jrvs.apps.twitter.spring.TwitterCLIBean
   Code
   Usage
  org.springframework.context.ApplicationContext
   ApplicationContext create beans/components.
Basically, the application IoC is setup here. (Refer to IoC diagram) docs
      @Configuration
     It marks the current class as IoC configuration when creating ApplicationContext
     @Bean
   As part of the @Configuration , it add a bean to IoC container.
  Discussion:
Bean > Why pass interface but return a class implementation? What are advantages of this? (Hint: environments)
What are disadvantages of this?
1.5.1.4.7. Spring Annotation Approach
It's boring to create @Bean manually, especially when number of class dependencies increases. Why not using java annotation to specify class dependencies?
Instead of using @Bean to add beans to IoC, we can use in-line @Component annotations to add classes to IoC. Moreover, @Repository, @Service, and @Controller are "subset" of the @Component .

   Annotation
   Usage
      @Component
 generic stereotype for any Spring-managed component
      @Repository
   stereotype for persistence layer
      @Service
   stereotype for service layer
  @Controller
   stereotype for presentation layer (spring-mvc)
   1. Create
   ca.jrvs.apps.twitter.spring.TwitterCLIComponentScan
   Code
   Usage
     @ComponentScan(value = "ca.jrvs.apps.twitter")
  In addition to @Bean, ApplicationContext will scan
components in a package(and sub- packages).
   2. Runit,andyouareexpectedtoseeerrors.
Read error message and understand why? 3. Add @Component, @Repository, and @Service.
Please avoid field level injection. It's a very bad practice. (Discuss why?)

        @Autowired //Not recomanded - field level
      injection
      private TwitterCLIRunner runner;
      private TwitterCLIRunner runner;
      @Autowired  //Correct - constructor injection
      (makding test mocking easier)
      public TwitterCLISpringBoot(TwitterCLIRunner
      runner) {
        this.runner = runner;
      }
4. Runitagain
Read log file, and identify what beans have created by the
      ApplicationContext
5. Uncommentlasttowlinesandrunyourapplication
1.5.1.4.8. SpringBoot Approach
In the previous two approaches, we used Spring Framework or Spring Core. Generally speaking, Spring Framework is IoC that solves class dependency management issue. SpringBoot is a different project that uses Spring Framework to create web application. SpringBoot reduces configurations significantly.

 Although, our twitter app is not a web application, we can still take advantages of its auto-config feature.
ca.jrvs.apps.twitter.spring.TwitterCLISpringBoot :
Create a properties file java_apps/src/main/resources/application.properties It
will print some useful logs
   logging.level.root=INFO
   logging.level.org.springframework.beans.factory=DEBU
   G
@SpringBootApplication is a convenience annotation that adds all of the following:
      @Configuration
      @EnableAutoConfiguration
      @ComponentScan
Since SpringBoot is most popular for web app development, it comes with a embedded servlet container:
What is java servlet? Turn it off
      app.setWebApplicationType(WebApplicationType.NONE)
      ;
Run it, and find what beans have been created.
1.5.1.4.9. Spring Profile and Multiple Interface Implementation

 Make a copy of ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper and call
it JrvsHttpHelper. Make sure JrvsHttpHelper has @Componment .
Now, both ApacheHttpHelper and JrvsHttpHelper implement HttpHelper, so @Autowired in TwitterRestDao#TwitterRestDao
will be confused. You now need to tell Spring which HttpHelper implementation would like to use.
@Autowired
  public TwitterRestDao(@Qualifier("jrvsHttpHelper")
HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }
In real development, we might encounter the situation where we need to use different beans/implementation based on the environment. For instance, for some reason, you have to use
JrvsHttpHelper in production while ApacheHttpHelper must be used in development. However, we need to achieve this without code change and also minimize the config. In SpringBoot, we can take advantage of the Profile feature.
At high-level, we would like to achieve something like this:

  #Development environment
java -Dspring.profiles.active=dev target/java_apps-1.0-
SNAPSHOT.jar
#Production
java -Dspring.profiles.active=prod target/java_apps-
1.0-SNAPSHOT.jar
Without any code change, the underline java code will automatically use the correct beans based on the
spring.profiles.active you passed.
Remove @Qualifier from public TwitterRestDao(@Qualifier("jrvsHttpHelper") HttpHelper httpHelper)
   JrvsHttpHelper
   @Component
   @Profile("prod")
   public class JrvsHttpHelper implements HttpHelper {
   ApacheHttpHelper
   @Component
   @Profile("dev")
   public class ApacheHttpHelper implements HttpHelper
   {

