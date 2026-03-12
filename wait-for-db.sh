#!/bin/bash
set -e

host="$DB_HOST"
port="$DB_PORT"

echo "Esperando a que MySQL en $host:$port esté listo..."

until (echo > /dev/tcp/$host/$port) 2>/dev/null; do
  echo "Esperando 2s..."
  sleep 2
done

echo "MySQL listo, iniciando aplicación..."
exec java -jar /app/app.jar