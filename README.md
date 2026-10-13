# Edufy — Ratings Service

Part of Edufy, a 10+ service microservices streaming platform (see [gateway repo](link) for the system overview). This service handles ratings, genres, and media-type classification.

**What I built:** full CRUD for ratings and media metadata, genre and mediaType support, endpoints for liking and disliking media, role-based access control (`@PreAuthorize` restricting delete operations to admin), and the Keycloak security integration for this service (configs, controllers, converters, services).

**Stack:** Java, Spring Boot, Spring Security, Keycloak (OAuth2 resource server), Docker.
