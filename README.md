 # Summary
 * this Java apps contains three independent applications
 >GREP
 
 >JDBC
 
 >Twitter
 
   ## Twitter
  ### Introduction 
  - this java application interacts with the Twitter API in order to view tweets ,and allow user to do the simple CRUD operations with the user's account. 
  ### Usage
  #### Get
  Discribtion:
  <pre>Look up a tweet by ID and print the tweet object inJSON format.Show user specified [fields] in the JSON document.Show user specified [fields] in the JSON document.</pre>
  example:
 <pre><code>**TwitterCLI show <tweet_id> [field1,field2]** **tweet_id** is the tweet id,same as the **idStr** arribute
 [field1, field2] (Optional) comma-separated list of top-level fields from the tweet object (similar to the SELECT clause in SQL).</pre></code>
 #### Post
 Discribtion:
  <pre>Look up a tweet by ID and print the tweet object inJSON format.Show user specified [fields] in the JSON document.Show user specified [fields] in the JSON document.</pre>
  example:
 <pre><code>**TwitterCLI show <tweet_id> [field1,field2]** **tweet_id** is the tweet id,same as the **idStr** arribute
 [field1, field2] (Optional) comma-separated list of top-level fields from the tweet object (similar to the SELECT clause in SQL).</pre></code>
 #### Delete
 Discribtion:
  <pre>Look up a tweet by ID and print the tweet object inJSON format.Show user specified [fields] in the JSON document.Show user specified [fields] in the JSON document.</pre>
  example:
 <pre><code>**TwitterCLI show <tweet_id> [field1,field2]** **tweet_id** is the tweet id,same as the **idStr** arribute
 [field1, field2] (Optional) comma-separated list of top-level fields from the tweet object (similar to the SELECT clause in SQL).</pre></code>
 Discribtion:
  <pre>Look up a tweet by ID and print the tweet object inJSON format.Show user specified [fields] in the JSON document.Show user specified [fields] in the JSON document.</pre>
  example:
 <pre><code>**TwitterCLI show <tweet_id> [field1,field2]** **tweet_id** is the tweet id,same as the **idStr** arribute
 [field1, field2] (Optional) comma-separated list of top-level fields from the tweet object (similar to the SELECT clause in SQL).</pre></code>
 
 
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
  

  ### Enhancements and Issues
  >Build a interface **JavaGrep** and implements it by  **JavaGrepImp**.

 ## Java Grep App
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
  

  ### Enhancements and Issues
  >Build a interface **JavaGrep** and implements it by  **JavaGrepImp**.
  
  ## Java JDBC App
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
  

  ### Enhancements and Issues
  >Build a interface **JavaGrep** and implements it by  **JavaGrepImp**.
  

  
  ```dtd
  st=>start:start:>www.google.ca
  op1=>operation:my choose
  c=>condition:yes or no?
  e=>end:end

```
