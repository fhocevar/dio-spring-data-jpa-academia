$ErrorActionPreference = 'Stop'
Set-Location (Join-Path $PSScriptRoot '..')
if (-not (Get-Command java -ErrorAction SilentlyContinue)) { throw 'Instale Java 21 e configure JAVA_HOME/PATH' }
if (-not (Get-Command mvn -ErrorAction SilentlyContinue)) { throw 'Instale Maven 3.9+ e configure PATH' }
docker compose up -d
if ($LASTEXITCODE -ne 0) { throw 'Falha ao iniciar PostgreSQL' }
mvn spring-boot:run
