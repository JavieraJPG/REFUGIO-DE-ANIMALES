# Refugio de Animales

## Descripción del proyecto
Este proyecto consiste en un sistema de consola desarrollado en Java para gestionar un refugio de animales.  
Permite registrar animales rescatados, asociarlos a una especie, controlar su estado de adopción y generar reportes generales.

El sistema fue diseñado para ser simple, claro y robusto, pensado para el uso diario de voluntarios del refugio.

---

## Funcionalidades
- Registrar animales
- Registrar especies
- Marcar animales como adoptados
- Mostrar animales disponibles
- Mostrar animales adoptados
- Mostrar reporte general

---

## Estructuras de datos utilizadas

### List
Se utiliza para almacenar los nombres de los animales registrados.

```java
List<String> animales;
```
## Estructuras de datos utilizadas

### Map — Estado de adopción
Se utiliza para relacionar cada animal con su estado de adopción.

```java
Map<String, String> estadoAnimal;
```

## Set — Especies

Se utiliza para almacenar las especies sin permitir duplicados.

Set<String> especies;
Map — Animal → Especie

Se utiliza para relacionar cada animal con su especie.

## Map<String, String> animalEspecie;
## Array — Estados fijos

Se utiliza para manejar los estados fijos del sistema.

String[] estados = {"Disponible", "Adoptado"};
## Cómo ejecutar el programa
  Abrir terminal en la carpeta del proyecto
  Compilar el archivo:
  javac RefugioAnimales.java
  Ejecutar el programa:
  java RefugioAnimales
## Ejemplo de menú
=== REFUGIO DE ANIMALES ===
1. Registrar animal
2. Registrar especie
3. Marcar animal como adoptado
4. Mostrar animales disponibles
5. Mostrar animales adoptados
6. Mostrar reporte general
7. Salir
## Integrantes del equipo
Javiera Godoy
Diego Contreras
Javiera Gallegos
Victor Erazo
Sherina Ponce
Alexander Hass
