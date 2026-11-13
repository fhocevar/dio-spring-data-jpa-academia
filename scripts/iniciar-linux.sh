#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
command -v java >/dev/null || { echo 'Instale Java 21'; exit 1; }
command -v mvn >/dev/null || { echo 'Instale Maven 3.9+'; exit 1; }
docker compose up -d
mvn spring-boot:run
