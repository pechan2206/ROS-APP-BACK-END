#!/bin/bash
# wait-for-db.sh

set -e

host="$DB_HOST"
port="$DB_PORT"

echo "Esperando a que MySQL en $host:$port esté listo..."

until nc -z "$host" "$port"; do
  echo "Esperando 2s..."
  sleep 2
done

echo "MySQL listo, iniciando aplicación..."
exec java -jar /app/back-end-0.0.1-SNAPSHOT.jar