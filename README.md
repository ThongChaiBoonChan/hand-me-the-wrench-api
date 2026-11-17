# hand-me-the-wrench-api

Spring Boot (Java 21, Maven) backend for the Hand Me The Wrench Angular app.
Currently only the health endpoint used by the frontend backend-switch.

    GET /api/health  ->  { "ok": true, "version": "0.1.0", "features": [] }

## Run

    ./mvnw spring-boot:run          # local, port 8080
    docker compose up --build       # container

## Connect the frontend

Same-origin (no CORS): proxy `/api` to `http://localhost:8080` in the frontend's `proxy.conf.json`
and set `public/config.json` to `{ "apiBaseUrl": "/api" }`.

Or full URL: `{ "apiBaseUrl": "http://localhost:8080/api" }`; allowed origins come from
`APP_CORS_ALLOWED_ORIGINS` (default `http://localhost:4200`).
