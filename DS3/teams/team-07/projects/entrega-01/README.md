# SISO-UNAL — Inscripción de Asignaturas UNAL

Proyecto semestral de Estructuras de Datos (DS3, grupo 03, 2026-2) — **team-07**. Entrega 1: propuesta, diseño e implementación inicial.

## Descripción

Sistema por consola, en Java, que simula la inscripción de asignaturas por citas de la Universidad Nacional (sede Bogotá, pregrado) según los grupos de prelación de la Circular 13 de 2026. La meta del semestre es agregar una **lista de espera por prioridad** por grupo, para que los cupos liberados se asignen al estudiante de mayor prioridad y no a quien recargue primero el SIA. También se planean la sugerencia de grupos sin cruce de horario y reportes de demanda.

En esta primera versión:

- `Student` clasifica al estudiante en los grupos 1 a 4 (discapacidad, vulnerabilidad académica, avance ≥ 80 %, resto) y compara prioridades. El IPA es un dato oficial de entrada; no se recalcula.
- `LinkedQueue` atiende a los estudiantes de una cita en orden de llegada (FIFO).
- `CourseGroup` controla los cupos de un grupo.
- `LinkedStack` modela el carrito de selección con deshacer.

## Integrantes

| Usuario de GitHub | Aporte |
|---|---|
| [@BLlontopSec](https://github.com/BLlontopSec) | Versión inicial de `Node`, `LinkedQueue`, `LinkedStack`, `Student`, `CourseGroup` y `Main`. |
| [@DfCastilloa](https://github.com/DfCastilloa) | Correcciones: estructuras genéricas, `peek` en la cola, IPA como dato de entrada, `compareTo` por prioridad; README. |
| [@hoverwars](https://github.com/hoverwars) | Por definir. |

## Estructuras de datos

| Estructura | Uso en el proyecto | Operaciones | Costo |
|---|---|---|---|
| `LinkedQueue<T>` (cola FIFO enlazada) | Estudiantes de una cita, en orden de llegada | `enqueue`, `dequeue`, `peek` | O(1) |
| `LinkedStack<T>` (pila enlazada) | Carrito de selección con deshacer | `push`, `pop`, `peek` | O(1) |
| `Student.compareTo` | Orden de prioridad entre estudiantes | comparar | O(1) |

## Requisitos

- Java 17 o superior. Sin dependencias externas.

## Compilar y ejecutar

Desde esta carpeta (`DS3/teams/team-07/projects/entrega-01/`):

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Salida esperada (resumen): el estudiante del grupo 1 y el del grupo 3 obtienen los 2 cupos; los dos del grupo 4 se quedan sin cupo; luego el carrito agrega dos cursos y deshace el último.

## Estado

- [x] Estructuras base: `Node`, `LinkedQueue`, `LinkedStack`
- [x] Clasificación por grupos de prelación y comparación de prioridad
- [x] Control de cupos por grupo
- [ ] Lista de espera por prioridad y reasignación automática al cancelar
- [ ] Ordenamiento automático de estudiantes y franjas de citas
- [ ] Cruces de horario, sugerencia de grupos y reportes (entregas 2 y 3)

## Limitaciones

- El orden de la cola de citas se arma a mano en `Main`; el ordenamiento automático llega con la cola de prioridad.
- Cuando un grupo está lleno, el estudiante todavía no pasa a una lista de espera.

## Declaración de uso de IA

Se usó Claude (Anthropic) para revisar el código y proponer correcciones. Los integrantes verificaron y aceptan los cambios.
