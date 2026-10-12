# Inscripción de Asignaturas UNAL

Proyecto semestral de Estructuras de Datos (DS3, grupo 03, 2026-2) — **team-07**.

## Descripción

Sistema por consola, escrito en Java, que simula la inscripción de asignaturas en la Universidad Nacional. Permite consultar el catálogo de asignaturas y grupos, inscribir y cancelar asignaturas respetando el cupo de cada grupo, manejar una lista de espera cuando un grupo está lleno y deshacer la última acción del estudiante.

El proyecto se desarrolla en tres entregas incrementales. Esta carpeta contiene la **Entrega 1**: propuesta, diseño e implementación inicial.

## Integrantes

| Usuario de GitHub | Aporte |
|---|---|
| [@DfCastilloa](https://github.com/DfCastilloa) | Por definir |
| [@BLlontopSec](https://github.com/BLlontopSec) | Por definir |
| [@hoverwar](https://github.com/hoverwar) | Por definir |

## Estructuras de datos (Entrega 1)

| Necesidad | Estructura | Operación principal | Costo |
|---|---|---|---|
| Catálogo de asignaturas y grupos | Arreglo dinámico | agregar | O(1) amortizado |
| Lista de espera de un grupo lleno | Cola circular | encolar / desencolar | O(1) |
| Deshacer la última acción | Pila | push / pop | O(1) |
| Asignaturas inscritas por un estudiante | Lista enlazada | insertar al frente | O(1) |

## Requisitos

- Java 17 o superior.

## Compilar y ejecutar

Pendiente: se agregará junto con el primer código fuente.

## Estado

- [x] README y estructura del proyecto
- [ ] Modelo de datos (asignatura, grupo, estudiante)
- [ ] Estructuras de datos propias
- [ ] Menú por consola
