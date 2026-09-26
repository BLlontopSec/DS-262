# Quiz 03 — Dynamic Arrays and Amortized Analysis

## Leer antes de comenzar

Lean completo el [enunciado del quiz](quiz-03.pdf). Esta guía indica cómo organizar y entregar el trabajo en el repositorio; no sustituye las preguntas ni proporciona sus soluciones.

| Aspecto | Instrucción |
| --- | --- |
| Identificador | `quiz-03` |
| Grupos del curso | DS3 (03) y DS4 (04) |
| Modalidad | Trabajo en los mismos equipos del proyecto del curso |
| Equipo | Conservar integrantes y número de `team-NN`; no crear otro equipo para este quiz |
| Entorno | Java 16 o superior |
| Preparación y sustentación | El enunciado indica 10 horas de preparación y hasta 12 minutos de sustentación |
| Fecha límite | Pendiente de anuncio del docente; la fecha del enunciado, 24 de septiembre de 2026, no se interpreta como fecha límite |

La entrega es conjunta por equipo. Cada integrante debe poder explicar y modificar la solución: el enunciado aplica un factor de sustentación por pregunta según la comprensión del estudiante. La entrega en equipo no elimina esta responsabilidad individual.

## 1. Ubicación y archivos obligatorios

Usen la carpeta del equipo que ya utilizan para el proyecto. Este quiz se organiza dentro de `labs/` como actividad colaborativa; el proyecto permanece en `projects/`.

- DS3: `DS3/teams/team-NN/labs/quiz-03/`
- DS4: `DS4/teams/team-NN/labs/quiz-03/`

Sustituyan `team-NN` por su número real. La estructura de la entrega debe ser:

```text
DS3/teams/team-NN/labs/quiz-03/     # o DS4, según su grupo
├── src/
│   ├── DynamicArray.java         # Pregunta 1
│   ├── Snake.java                # Pregunta 3
│   ├── Position.java
│   └── Main.java                 # Reproduce la traza de la Pregunta 3
├── README.md
└── analysis.pdf
```

No creen una copia por estudiante ni suban la solución a `assignments/`. Esa carpeta contiene las instrucciones compartidas. No incluyan archivos `.class`, carpetas de compilación ni un ZIP en lugar de los archivos solicitados.

## 2. Qué debe contener cada archivo

| Archivo | Contenido requerido |
| --- | --- |
| `src/DynamicArray.java` | Implementación genérica de la Pregunta 1 con la interfaz, validaciones y política de crecimiento del enunciado |
| `src/Snake.java` | Representación y operaciones de la Pregunta 3; administra directamente su arreglo, sin delegar el almacenamiento en `DynamicArray` |
| `src/Position.java` | El `record Position(int row, int column)` del enunciado |
| `src/Main.java` | Ejecución reproducible de la traza de P3, con el estado físico y las variables solicitadas después de cada movimiento |
| `README.md` | Únicamente versión de Java e instrucciones para compilar y ejecutar |
| `analysis.pdf` | Máximo cuatro páginas con las respuestas y justificaciones de análisis exigidas por el quiz |

**Excepción a la guía general:** no agreguen integrantes, análisis, referencias ni resultados de pruebas al README de esta entrega. Registren los integrantes mediante sus usuarios de GitHub en el README existente de `team-NN/`, y describan sus aportes y las validaciones en el pull request. Incluyan las referencias académicas pertinentes en `analysis.pdf`, dentro de su límite de páginas, y las declaraciones de ayuda requeridas por el curso en el pull request. No publiquen números de documento en GitHub.

El PDF de análisis debe responder los apartados teóricos de P1–P5 y cubrir representación interna, invariantes, complejidades, demostración del análisis amortizado, comparación de políticas y tabla de P5. No basta con entregar código funcional o afirmar complejidades sin justificarlas.

## 3. Restricciones que deben verificar

Consulten el enunciado completo para los detalles de cada pregunta. En particular:

- No usar `ArrayList`, `Vector`, `LinkedList`, `Stack`, `Queue`, `Deque` ni estructuras dinámicas equivalentes de la biblioteca estándar.
- Realizar la copia durante el redimensionamiento elemento por elemento; no usar `Arrays.copyOf()` ni `System.arraycopy()`.
- Mantener el índice lógico 0 para la cola y `size - 1` para la cabeza.
- Respetar el orden `addHead` y luego `removeTail` en movimientos sin comida, incluido el crecimiento transitorio.
- Considerar ocupada la cola actual al evaluar colisiones, como exige el enunciado.
- Cumplir las validaciones de P1; `removeLast()` no reduce la capacidad.
- En P3, usar un arreglo nativo y un número constante de variables auxiliares, preservar el orden lógico al redimensionar y no desplazar sistemáticamente todos los elementos en cada movimiento.
- Justificar los objetivos de P3: `addHead()` amortizado O(1) y `removeTail()` O(1) en el peor caso.

## 4. Ejecución y comprobaciones

El README debe dar comandos que funcionen desde la carpeta `quiz-03/`. Si sus clases no declaran paquetes, pueden usar este esquema, indicando la versión real de Java utilizada:

```bash
javac -d out src/DynamicArray.java src/Snake.java src/Position.java src/Main.java
java -cp out Main
```

Si declaran paquetes, adapten el comando de ejecución al nombre completo de `Main`. No suban `out/`.

Comprueben las validaciones de constructor, índices y eliminación sobre vacío de P1, además del crecimiento y la preservación de elementos. Para P3, `Main` debe reproducir exactamente la secuencia del enunciado, partiendo de cola A, cabeza B y `size = capacity = 2`:

```text
N1: no come
N2: come
N3: no come
N4: no come
N5: come
N6: no come
```

Después de cada movimiento muestren el arreglo físico completo, incluidas las celdas vacías, todas las variables de estado de su representación, `size`, `capacity` y si hubo `resize`. Hagan identificables A, B y N1–N6 en la salida. La guía no fija una representación interna ni entrega la traza resuelta: diseñarlas y justificarlas forma parte del quiz.

## 5. Contribución del equipo y entrega

Sigan la [guía de contribución](../../CONTRIBUTING.md) para configurar su fork y sincronizarlo con `upstream/main`. Todos trabajan con el mismo número de equipo del proyecto. Distribuyan tareas y documenten los aportes de cada integrante; las dependencias entre aportes pueden coordinarse mediante pull requests pequeños, como explica la guía general.

Para una entrega conjunta, acuerden un responsable de abrir el pull request que reúne los archivos completos y registra los aportes de todos. No abran varias entregas idénticas. Si hubo pull requests previos del equipo, enlácenlos en el de entrega final.

Ejemplo para **DS3, team-01**; cambien grupo y equipo según corresponda. Desde la raíz de una copia sincronizada del repositorio:

```bash
git switch -c ds3/team-01/quiz-03
```

Creen y completen los archivos en `DS3/teams/team-01/labs/quiz-03/`, ejecuten sus comprobaciones y después:

```bash
git status
git diff
git add DS3/teams/team-01/labs/quiz-03/
git diff --cached
git commit -m "feat(ds3-team01): submit quiz 03"
git push -u origin ds3/team-01/quiz-03
```

Si actualizaron el README general del equipo para identificar integrantes, agréguenlo explícitamente y revisen ese cambio también. No incluyan trabajo ajeno.

Abran el pull request desde esa rama de su fork hacia `main` de `byepesg/DS-262`, con un título como **[DS3][team-01] Quiz 03 — Dynamic Arrays**. Completen la plantilla e incluyan:

- Enlace a `assignments/quiz-03/README.md` e identificador `quiz-03`.
- Grupo del curso, equipo del proyecto e integrantes mediante usuarios de GitHub.
- Ruta de la entrega y aportes de cada integrante.
- Versión de Java, comandos ejecutados, resultados reales y casos comprobados.
- Confirmación de que `analysis.pdf` tiene como máximo cuatro páginas.
- Limitaciones conocidas y enlaces a contribuciones previas del equipo, si existen.

Respondan a la revisión en la misma rama. El código entregado debe ser exactamente el utilizado durante la sustentación; si necesitan corregirlo, actualicen el pull request y coordinen con el docente la versión que será evaluada.

## 6. Evaluación y sustentación

El enunciado asigna **1.0 a cada una de las cinco preguntas**, para un total de **5.0**, con base en código y `analysis.pdf`. La nota de cada pregunta se multiplica por un factor `f` entre 0 y 1 según la capacidad del estudiante para explicar y modificar su solución. Una pregunta que no pueda explicar recibe `f = 0`.

La sustentación contempla demostración y pruebas, representación e invariantes, análisis amortizado y comparación de políticas, y preguntas o modificaciones del docente. Todos los integrantes deben preparar la solución completa.

## Lista de verificación final

- [ ] Utilizamos los mismos integrantes y número de equipo del proyecto.
- [ ] La entrega está en el grupo correcto, dentro de `teams/team-NN/labs/quiz-03/`.
- [ ] Incluimos los cuatro archivos Java, el README y `analysis.pdf`.
- [ ] El README contiene solamente versión de Java e instrucciones de compilación y ejecución.
- [ ] `Main` reproduce la traza de P3 y muestra toda la información solicitada.
- [ ] `analysis.pdf` no supera cuatro páginas y cubre los apartados teóricos de P1–P5.
- [ ] Respetamos las restricciones del enunciado y registramos resultados reales de validación en el pull request.
- [ ] Cada integrante puede explicar la solución; la versión entregada coincide con la de la sustentación.

## Fuente y adaptación

El [PDF adjunto](quiz-03.pdf) se conserva sin modificaciones. Esta guía añade la organización de entrega en GitHub y la indicación del docente de trabajar con los mismos equipos del proyecto. No añade una fecha límite ni cambia los puntajes del enunciado.
