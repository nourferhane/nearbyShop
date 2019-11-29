First of all i'd like to thank 'United Remote' for this challenge

This application can show you a list of nearby shops , so it is built using microservice architecture (it means we create an application with independents process or services for more information you can visite :https://microservices.io )

used technologies :

Spring Boot (thanks to starters :D )
Spring security
Eureka discovery server
zuul for the api gateway(still in progess)
Java
.Net core (C#) 2.2
JPA (for data persistance )
Angular 7 (using .net core demo template)
Boostrap 4 (bootrap cards)
JWT used IDE and softwares :
Eclipse
Visual studio 2019
Gitkraken (for git reposirotries)
Visual Code
Postman (test an api )
Application architecture :

Models : User {name , username,, email ,password ...}=> user can be a normal user or an Administrator , Shop {name, description , location,image (string url) }
until now we have two microservice (spring boot):

Login & registration Ms
Shop Ms
i'll add two more(.net core ):

admin ms
click to call to build a WebRTC (using Twilio API just for fun :D)
video of the first part : https://youtu.be/xFvUUxb_XLk

second part : https://youtu.be/PsvK67Wp7yQ
