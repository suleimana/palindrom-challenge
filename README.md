Palindrome Challenge
====================
Details about the challenge : [palindromic](https://github.com/ZillionGroup/coding-challenges/blob/master/palindrome/README.md).


Solution 
========
We can find the all possible palindromes of a particular string by looking up all possible permutations. However, this is a brute force solution and would cost O(N!) where n is the length of the string. 

A palindrome string must have an even number of characters and at most one odd number of characters in the centers. For example: 
```
aabb
aaacbbb
```

So we get the count  of all possible palindromes by calculating all possible premutations of half of the sting with respect to the odd number.
```
Example1 : 
let 
s = "ab" => the allowed set of charchters 
k =3 => the string size

Then possible palindromes is 4 :-
aaa
bbb
aba
bab

Example 2: 
let 
s = "abc" => the allowed set of charchters 
k =3 => the string size

Then possible palindromes is 9 :- 
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

Then possible palindromes is 9 :- 
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


So for a string with length K and has N number of unique characters, the count  of all possible palindromes is  N to the power of half K : 

```
Count = N^(K/2 +K %2)
```






Project Layout
=============
The project use Spring boot to the run rest service and it has the following layout: 
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
*Java 1.7
*Maven

From IDE:
--------
You can start project  from  IDE , by running main method in the Application.java 

From Command line:
-----------------
```
mvn spring-boot:run
```
