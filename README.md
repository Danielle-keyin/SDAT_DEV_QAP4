Search API Features

This project includes multiple search endpoints for both Members and Tournaments, allowing flexible filtering of data stored in PostgreSQL (local or AWS RDS).

Member Search Endpoints
GET /api/members/search/by-name	?name=	Search members by partial or full name.
GET /api/members/search/by-membership-type	?type=	Filter by membership type (REGULAR, PREMIUM, STUDENT).
GET /api/members/search/by-phone	?phone=	Find members using phone number.
GET /api/members/search/by-tournament-start-date	?date=	Returns all members participating in tournaments starting on a specific date.

Tournament Search Endpoints
GET /api/tournaments/search/by-start-date	?date=	Find tournaments by exact start date.
GET /api/tournaments/search/by-location	?location=	Search tournaments by location (partial match supported).
GET /api/tournaments/{id}/members	—	Returns all members participating in a specific tournament.

The project includes full Docker support with a multi-stage build and docker-compose configuration.

1. Build and run using Docker Compose
docker-compose up --build
This command will:
Build the Spring Boot application into a Docker container
Start a PostgreSQL database container
Automatically create tables via Hibernate
Start the REST API on port 8080

Connecting the API to AWS RDS
To switch from the local PostgreSQL container to AWS RDS, the application.properties file was updated to use the RDS endpoint: 
spring.datasource.url=jdbc:postgresql://sdat-db.chomwmm2y49q.us-east-1.rds.amazonaws.com:5432/postgres
When the project was restarted, and Hibernate automatically created the required tables inside the RDS instance

Issues
soooooooop much tinkering to make things work including issues with inbound rules, duplicate port, a stupid space in the endpoint and more i cant think of atm
