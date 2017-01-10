# Programmeren 3

In deze repository vind je voorbeeldcode voor het vak Programmeren 3. Elke directory bevat een afzonderlijk IntelliJ IDEA project.

Dit zijn de projecten (min of meer) gesorteerd volgens moeilijkheid:

## Week 1

- [basicservlet](basicservlet)

  Een eenvoudig servlet in een Gradle project met embedded Tomcat.

- [listeners](listeners) ![Spring Boot][spring_boot]

  Een eenvoudig voorbeeld van een servlet context listener.

- [filters](filters) ![Spring Boot][spring_boot]

  Een eenvoudig voorbeeld van filters.

- [dispatch](dispatch)

  Een eenvoudig RequestDispatcher voorbeeld.

- [thread_safety](thread_safety) ![Spring Boot][spring_boot]

  Enkele kleine servlets die de problematiek rond thread safety illustreren.

- [boot_servlet](boot_servlet) ![Spring Boot][spring_boot]

  De meest eenvoudige servlets geimplementeerd met Spring Boot.

## Week 2

- [session](session)

  Een voorbeeld van het aanmaken en raadplegen van een sessie.

- [blog_jsp](blog_jsp)

  Het [dispatch](dispatch) voorbeeld omgezet naar JSP anno 1999-2000.

- [blog_jstl](blog_jstl)

  Het [dispatch](dispatch) voorbeeld omgezet naar een eenvoudige JSP/JSTL pagina.

## Week 3

- [di](di)

  Dependency Injection voorbeelden geimplementeerd met Spring (geen Web).

- [spring_mvc_account](spring_mvc_account)

  Een heel eenvoudig Spring MVC voorbeeld waarvan de view kant is gebouwd met JSP.

- **Extra:** [smvc_thymeleaf_account](smvc_thymeleaf_account)

  Spring MVC met Thymeleaf.

## Week 4

- [controllers](controllers)

  Drie Spring MVC controllers worden gebruikt om de parameters en return types van controller-methods te illustreren.

- [cycling](cycling)

  Een spring MVC applicatie met achterliggend twee tabellen in een H2 databank.

## Week 5

- [form](form)

  Spring form met validatie. i18n wordt toegepast op het formulier (JSP/JSTL) en de validatie-berichten.

- [cycling_orika](cycling_orika)

  De cycling applicatie van week 4, uitgebreid met Orika bean mapping (en enkele extra tabellen). Eveneens omgezet naar Spring Boot.

## Geintegreerd project

- [classnotfound](classnotfound)

  Een eenvoudige website waar je vragen kan stellen, beantwoorden en up/downvoten (a la StackOverflow of reddit). Gebruikt Spring MVC met Thymeleaf en Hibernate.

[spring_boot]: images/spring-boot-logo_24_22.png