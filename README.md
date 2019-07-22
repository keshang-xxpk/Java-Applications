 # Summary
 ### This Java apps contains three independent applications
 
 [1.Twitter](#Twitter)  
 &ensp;&ensp; [1.1Introduction](#Introdection)  
 &ensp;&ensp; [1.2Usage](#Usage)  
 &ensp;&ensp;[1.3Workflow](#Workflow)  
 
 [2.Grep](#Grep)  
 &ensp;&ensp;[2.1Introduction](#Introdection)   
 &ensp;&ensp;[2.2Usage](#Usage)   
 &ensp;&ensp;[2.3workflow](#Workflow) 
 &ensp;&ensp;[2.4Enhancements](#Enhancements)
 
 [3.JDBC](#JDBC)   
 &ensp;&ensp;[3.1Introduction](#Introdection)    
 &ensp;&ensp;[3.2Usage](#Usage)    
 &ensp;&ensp;[3.3Implementation](#Implementation)     
 
   ## Twitter
  ### Introduction 
  - this java application interacts with the Twitter API in order to view tweets ,and allow user to do the simple CRUD operations with the user's account. 
  ### Usage
  #### Get
  -Discription:
  <pre>Look up a tweet by ID and print the tweet object inJSON format.Show user specified [fields] in the JSON document.Show user specified [fields] in the JSON document.</pre>
  -Syntax:
 <pre><code>**TwitterCLI show <tweet_id> [field1,field2]** **tweet_id** is the tweet id,same as the **idStr** arribute
 [field1, field2] (Optional) comma-separated list of top-level fields from the tweet object (similar to the SELECT clause in SQL).</pre></code>
 #### Post
 -Discription:
  <pre>Create a tweet with geo-location data and output the created tweet object(simplified) in JSON format.</pre>
  -Tip:
 <pre><code> **tweet_text** cannot exceed 140 Unicode-encoded(UTF-8) characters</pre></code>
 #### Delete
 -Discription:
  <pre>Delete a list of tweets selected by id</pre>
  -Syntax:
 <pre><code>TwitterCLI delete **tweet_ids>** </pre></code>
  ### Design and Implementation
 
  ### workflow
  https://github.com/keshang-xxpk/Java-Applications/blob/master/IMAGE/Twitter_image.png    
 .
  

 

 ## Grep
  ### Introduction 
  - Implement a simple grep app in Java. The app searches for a text pattern recursively in a given directory, and output matched lines to a file. 
  ### Usage
  - Three arguments:regex,rootpath,outfile.
  >regex - a special text string for describing a search pattern
  >rootPath - root directory path
  >outFile - output file name
  
  - usage examples
  > note: regex must match entire line.
.*data.* ~/dev/jrvs/bootcamp/linux_sql /tmp/grep.out
>
>It searches all files in ~/dev/jrvs/bootcamp/linux_sql directory, and output lines contain data keyword to the output file
 /tmp/grep.out
  ### Design and Implementation
 
  - Pseudo code and workflow
  <pre><code> 
matchedLines = []
for file in listFiles(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)</code></pre>
  
  - Libraries
  >Using bufferReader and bufferWriter to dual with the input data.Also try to use Lambda and Stream API to process the input data stream.
  

  ### Enhancements
  >Build a interface **JavaGrep** and implements it by  **JavaGrepImp**.
  
  ## JDBC
  ### Introduction 
  - The JDBC app uses the Java Database Connectivity API to connect and send SQL queries to a Postgresql database. The database models a sales business. The app can create a new customer, delete a customer, update information of a customer, find customer information, and get order information
  ### Usage
  #### Three arguments:tablename,query_arguments,tablename.
  <pre>USAGE: tablename query_keyword query_arguments</pre>
  - Tablename - a specific table in the database { customer | order | salesperson | product }
  - query_keyword - { select | insert | update | delete }
  - query_arguments - row id and record arguments in order

  ### Implementation
 - https://github.com/keshang-xxpk/Java-Applications/blob/master/IMAGE/JDBC.png
 
 - The implementation of this app uses the Data Access Object (DAO) pattern to send SQL queries and process their results. The DAO pattern is used to separate low-level database access operations from high-level business operations. The DataTransferObject interface ensures that a data transfer object like customer and order have a method that returns their id. The abstract class DataAccessObject is a parameterized class where the parameter has to implement the DataTransferObject interface. It provides method signatures for create, read, update, and delete (CRUD) operations. The classes CustomerDAO and OrderDAO extend the DataAccessObject class. They contain the specific SQL queries for the CRUD operations for customer and order data.

  
  
 
  

 

  
 
