# Pastebin Backend Clone

A scalable Pastebin-like backend service built with Java and Spring Boot.

Users can create text posts, share them through short links, and configure automatic expiration times. The project is designed with real-world backend engineering practices in mind, including caching, distributed storage, rate limiting, and scalable architecture.

---

# Features

## Core Features
- Create and upload text posts
- Access posts through unique short URLs
- Configurable expiration time
- Automatic post deletion after expiration

## Advanced Features
- Custom short hash generator
- Redis caching for popular posts
- Rate limiting for heavy users
- Blob storage integration (Amazon S3 compatible)
- Dockerized infrastructure

---

# Tech Stack

## Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

## Database
- PostgreSQL
- Redis

## Storage
- Amazon S3 / MinIO

## DevOps & Tools
- Docker
- Docker Compose
- Git

---

# Architecture

The system follows a layered backend architecture:

```text
Controller → Service → Repository → Database
                     ↓
                  Redis Cache
                     ↓
                 S3 Storage
