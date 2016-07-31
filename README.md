Palindrome Challenge
====================

Write an API that searches [NASA patents](https://api.nasa.gov/api.html#patents) and determines the number of [palindromic](https://en.wikipedia.org/wiki/Palindrome) strings that can be created from inventor's name.

Details
-------
The implementation should expose a service at the following entry point:
```
GET /palindromes
```
The service accepts the following parameters:

Name | Required | Default | Description
---- | -------- | ------- | -----------
`search` | yes | - | patent search text
`limit`  | no  | 1 | number of patents considered (min:1, max:5)

Request example:
```
GET /palindromes?search=electricity&limit=3
```

The service should search the NASA patents for given text and retrieve up to given number of patents. For each extracted inventor, first and last name should be concatenated into a single string (e.g. `"Graham"` and `"Bell"` becomes `"Graham Bell"`). For each such name the service should calculate the number of palindromic strings that can be created using the name letters. Name should be treated as case-insensitive (i.e. `b` and `B` is the same letter) and all white-spaces should be ignored. A valid palindromic string is one that uses only the letters in the given name, and is the same length as the given name. Each letter can be used more than once, and not every letter must be used. For example, given the name `"Graham Bell"`, `"aaahhhhaaa"` and `"bellmmlleb"` are valid, but `"aaa"` and `"hhhsagtbbb"` are not. Results should be returned in JSON format sorted by the count, highest to lowest.

Response example (with actual palindrome counts):
```
[
    { "name": "Nicola Tesla", "count": 531441 },
    { "name": "Max Planck", "count": 32768 },
    { "name": "Marie Curie", "count": 16807 },
    { "name": "Maria Mayer", "count": 7776 }
]
```

Constraints
-----------
Choice of languages, frameworks and libraries is limited to a JVM-based technology.



Solution 
========
We can find all possible palindromes of a particular string by looking up all possible permutations. However, this is a brute force solution and would cost O(N!) where n is the length of the string. 

A palindrome string must have an even number of characters and at most one odd number of characters in the center. For example: 
```
aabb
aaacbbb
```

So, we get the count  of all possible palindromes by calculating all possible premutations of half of the sting with respect to the odd number.
```
Example 1: 
let 
s = "ab" => the allowed set of charchters 
k =3 => the string size

Then possible palindromes is 4:
aaa
bbb
aba
bab

Example 2: 
let 
s = "abc" => the allowed set of charchters 
k =3 => the string size

Then possible palindromes is 9: 
aaa
bbb
ccc
aba
aca
bab
bcb
cac
cbc

Exmaple 3: 
let 
s = "abc" => the allowed set of charchters 
k =4 => the string size

Then possible palindromes is 9:
aaaa
bbbb
cccc
abba
acca
baab
bccb
caac
cbbc

```


So, for a string with length K which has N number of unique characters, the count  of all possible palindromes is  N to the power of half K 

```
Count = N^(K/2 + K%2)

```


Project Layout
=============
The project uses Spring boot to run the rest service and it has the following layout: 
```
.
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── palindrome
│   │   │           ├── common
│   │   │           │   └── PalindromeDescComparator.java
│   │   │           ├── config
│   │   │           │   └── SwaggerConfig.java
│   │   │           ├── controller
│   │   │           │   ├── ErrorController.java
│   │   │           │   └── PalindromeController.java
│   │   │           ├── dto
│   │   │           │   └── nasa
│   │   │           ├── exception
│   │   │           │   └── PalindromeException.java
│   │   │           ├── main
│   │   │           │   └── Application.java
│   │   │           ├── service
│   │   │           │   └── PalindromeService.java
│   │   │           ├── util
│   │   │           │   ├── PalindromeUtil.java
│   │   │           │   └── PalindromeValidationHelper.java
│   │   │           └── view
│   │   │               ├── BaseResponse.java
│   │   │               └── PalindromeResponse.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── palindrome
│                   └── util
│                       └── PalindromeUtilTest.java
```


You can find the actual algorithm solution in the following java class 
```
PalindromeUtil.java
```

Running the project
======================
Before running the project, make sure you have the following installed in your machine: 

* Java 1.7
* Maven

From IDE:
--------
You can start the project from IDE by running the main method from Application.java 

From Command line:
-----------------
```
mvn spring-boot:run
```


The service runs on port 8080 so you can access the service using:  

```
http://localhost:8080/palindromes?search=[Search String]&limit=[number from 1-5]
```


Additionally, you can access the service's documentation for all implemented operations thorough the following link:
 
```
http://localhost:8080/swagger-ui.htm

````


