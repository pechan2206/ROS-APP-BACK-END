#!/bin/bash
# Espera hasta que MySQL esté disponible antes de levantar Spring Boot

APP_JAR=$1

echo "Esperando a que la base de datos esté disponible en $DB_HOST:$DB_PORT..."

until nc -z -v -w30 $DB_HOST $DB_PORT
do
  echo "Base de datos no disponible aún, reintentando..."
  sleep 5
done

echo "Base de datos disponible, iniciando aplicación..."
java -jar $APP_JAR