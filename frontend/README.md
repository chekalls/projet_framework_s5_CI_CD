# Frontend Application - Spring Boot

## Description
Application Spring Boot frontend sans gestionnaire de dépendances.

## Structure du projet
```
frontend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/frontend/
│   │   │       ├── FrontendApplication.java
│   │   │       ├── controller/
│   │   │       │   └── HomeController.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application.yml
│   │       └── static/
│   │           └── index.html
│   └── test/
│       └── java/
│           └── com/example/frontend/
│               └── FrontendApplicationTests.java
├── lib/
└── README.md
```

## Dépendances requises (à placer dans le dossier lib/)
- spring-boot-starter-web
- spring-boot-starter-test
- spring-boot-autoconfigure
- spring-core
- spring-context
- spring-beans
- spring-web
- spring-webmvc
- Et leurs dépendances transitives

## Compilation
```bash
javac -cp "lib/*" -d build/classes $(find src/main/java -name "*.java")
```

## Exécution
```bash
java -cp "build/classes:lib/*" com.example.frontend.FrontendApplication
```

## Endpoints disponibles
- GET / - Page d'accueil
- GET /hello - Message de bienvenue

## Notes
Ce projet est configuré sans gestionnaire de dépendances (Maven/Gradle). 
Vous devrez télécharger manuellement les JARs Spring Boot et les placer dans le dossier lib/.
