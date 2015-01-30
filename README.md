Spring Maven Java 1.8
=======================

Multi-module maven project example using SPRING 4 and java 1.8

- Simple web app spring mvc using services
- Rest Service implementation example with repository and mail access
- Repository access with spring data jpa
- Unitary and Integration test concept using hsldb and mockito (http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html)

To test web app type:  mvn install jetty:run or sort command mvn deploy (jetty:run goal is linked to maven deploy phase)

- http://localhost:8080/SpringMVC/   (spring mvc jsp model)

If you want to access to Rest Service example api then you need to type this url:

- http://localhost:8080/SpringMVC/base (get list of all bases)
- http://localhost:8080/SpringMVC/base/1 (get base info with id=1)
- http://localhost:8080/SpringMVC/base/1 (delete base info with id=1)
- http://localhost:8080/SpringMVC/base (post create new base sending json info. Example "name":"rolling pizza" )
- http://localhost:8080/SpringMVC/base (update update existing base sending json info. Example {"name":"rolling pizza 2","id":1})

You can access uploaded example:


 [https://cristianprofile.ci.cloudbees.com/?cloudbees.platform](https://cristianprofile.ci.cloudbees.com/?cloudbees.platform "https://cristianprofile.ci.cloudbees.com/?cloudbees.platform")

You can access to video course an ppt of presentation at url below:

Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven [Presentation ppt](http://www.slideshare.net/cristianromeromatesanz/maven-31576343 "Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven")

New features coming soon!!!!!Spring boot refactor code without xml config 2015!!!!