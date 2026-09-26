# Guía de contribución para estudiantes

Si es tu primera vez usando Git, consulta la [guía introductoria de Git y GitHub](docs/git-guide.md), que explica la configuración y los comandos paso a paso.

## Antes de comenzar: lee las instrucciones de la tarea

Abre el [índice de actividades](assignments/README.md), selecciona la tarea asignada por el docente y lee sus requisitos, fecha límite, entregables, carpeta de destino y criterios de evaluación. Solo las actividades publicadas constituyen tareas; la plantilla no es una solicitud de entrega. Sigue los requisitos específicos de la tarea junto con este flujo de Git. Si encuentras contradicciones, consulta al docente antes de continuar.

El formato de entrega de cada tarea tiene prioridad sobre los requisitos generales del README que aparecen más adelante. Para el Quiz 03, el README de la entrega contiene únicamente la versión de Java y las instrucciones de compilación y ejecución; la autoría se documenta en el README del equipo y en el pull request, y el análisis se presenta en `analysis.pdf`.

Incluye el identificador de la tarea y un enlace a sus instrucciones en tu pull request. No modifiques archivos de `assignments/` sin autorización expresa del docente.

## 1. Elige la carpeta correcta

| Trabajo | DS3 — Grupo 03 | DS4 — Grupo 04 |
| --- | --- | --- |
| Individual | `DS3/individual/YOUR-USERNAME/` | `DS4/individual/YOUR-USERNAME/` |
| Laboratorios en equipo | `DS3/teams/team-NN/labs/` | `DS4/teams/team-NN/labs/` |
| Proyectos en equipo | `DS3/teams/team-NN/projects/` | `DS4/teams/team-NN/projects/` |

Reemplaza `YOUR-USERNAME` por tu usuario de GitHub y `team-NN` por el número de equipo asignado por el docente, por ejemplo, `team-01`. Conserva esos nombres durante el curso. Los equipos de distintos grupos pueden tener el mismo número. Para las carpetas de actividades, usa nombres en minúsculas con guiones y el identificador indicado por el docente.

Crea tu carpeta individual en tu primer pull request. Incluye un `README.md` con tu usuario de GitHub, grupo del curso e índice de entregas. Para crear una carpeta de equipo, un integrante presenta el pull request inicial con un `README.md` que indique el número de equipo, los usuarios de GitHub de sus integrantes y un índice de laboratorios y proyectos. Después de que se integre ese PR, los demás integrantes utilizan la misma carpeta.

Git registra archivos, no carpetas vacías. Crea cada carpeta con su README o sus archivos fuente cuando la necesites.

## 2. Configuración inicial: fork y clone

Abre el [repositorio del curso](https://github.com/byepesg/DS-262) y crea un fork en tu propia cuenta de GitHub. Clona **tu fork**. Reemplaza `YOUR-USERNAME` antes de ejecutar:

```bash
git clone https://github.com/YOUR-USERNAME/DS-262.git
cd DS-262
git remote add upstream https://github.com/byepesg/DS-262.git
git remote -v
```

`origin` es tu fork, donde subes tus ramas. `upstream` es el repositorio del docente, donde se integran las contribuciones aceptadas. Para hacer push, autentícate mediante tu gestor de credenciales, GitHub CLI o tu configuración SSH; nunca guardes credenciales en un archivo del repositorio.

## 3. Comienza cada contribución desde la versión actual del curso

Termina y registra con un commit el trabajo pendiente en tu rama actual antes de cambiar de rama. Después ejecuta:

```bash
git switch main
git fetch upstream
git merge --ff-only upstream/main
git push origin main
```

Reserva la rama `main` de tu fork para la sincronización. Si falla la integración por avance rápido, detente y pide ayuda; no fuerces el push ni descartes tu trabajo.

Crea una rama para una contribución concreta. Por ejemplo:

```bash
git switch -c ds3/individual/YOUR-USERNAME/linked-lists
```

Para trabajo en equipo, usa una rama como `ds4/team-01/lab-01`. Los nombres de ramas usan `ds3` o `ds4` en minúsculas; los nombres de carpetas usan `DS3` o `DS4` en mayúsculas.

## 4. Agrega el código y la documentación

Un ejercicio individual puede contener:

```text
DS3/individual/YOUR-USERNAME/exercises/linked-lists/
├── README.md
├── SinglyLinkedList.java
└── Main.java
```

Una entrega en equipo puede contener:

```text
DS4/teams/team-01/labs/lab-01/
├── README.md
├── src/
└── tests/
```

Salvo que la tarea indique un formato específico, el README de cada ejercicio, laboratorio o proyecto debe explicar:

- El identificador de la tarea y lo que se implementa.
- El usuario de GitHub del autor, o los integrantes del equipo y el aporte de cada persona.
- La versión de Java requerida y los comandos exactos para compilar y ejecutar desde la carpeta de la entrega.
- Cómo ejecutar pruebas o ejemplos reproducibles, con sus resultados esperados.
- Las complejidades temporales de las operaciones relevantes y los supuestos que las sustentan.
- Las limitaciones conocidas y las referencias, incluidas las declaraciones de ayuda que exija el curso.

Usa la estructura y las herramientas solicitadas en la tarea. Para un ejercicio sencillo de Java sin paquetes, el README podría incluir:

```bash
javac -d out SinglyLinkedList.java Main.java
java -cp out Main
```

Adapta estos comandos a tus archivos reales. Comprueba el comportamiento normal y los casos límite relevantes, como una estructura vacía, un solo elemento u operaciones inválidas. No entregues archivos `.class` generados ni carpetas de compilación.

## 5. Revisa los cambios, crea un commit y haz push

Para un ejercicio individual de DS3, reemplaza el usuario y ejecuta:

```bash
git status
git diff
git add DS3/individual/YOUR-USERNAME/exercises/linked-lists/
git diff --cached
git commit -m "feat(ds3): implement linked list exercise"
git push -u origin ds3/individual/YOUR-USERNAME/linked-lists
```

Si estás creando tu carpeta inicial, selecciona tu nuevo README personal en lugar de la ruta del ejercicio. Para trabajo en equipo, selecciona únicamente la entrega correspondiente y sube la rama de ese trabajo. Revisa los cambios seleccionados con `git diff --cached` para evitar incluir modificaciones ajenas al objetivo del commit.

## 6. Abre un pull request al repositorio del curso

En GitHub, abre un pull request con estos valores:

- **Base repository (repositorio de destino):** `byepesg/DS-262`.
- **Base branch (rama de destino):** `main`.
- **Head repository (repositorio de origen):** tu fork.
- **Compare branch (rama que contiene los cambios):** tu rama de contribución.

Usa un título como `[DS3][Individual][YOUR-USERNAME] Listas enlazadas` o `[DS4][team-01] Laboratorio 01`. Completa la plantilla del pull request indicando qué cambió y cómo lo comprobaste. Revisa la pestaña **Files changed** antes de enviarlo. Puedes abrir un pull request en borrador si necesitas comentarios sobre trabajo en desarrollo; márcalo como listo para revisión cuando esté completo.

Hacer push a tu fork no constituye por sí solo una entrega al repositorio del curso. Comparte el enlace del pull request por el canal de entrega establecido si la actividad lo exige. Las fechas límite y los criterios de calificación se encuentran en las instrucciones de la tarea.

## 7. Responde a la revisión

Realiza las correcciones solicitadas en la misma rama, ejecuta nuevamente las comprobaciones pertinentes y después:

```bash
git add DS3/individual/YOUR-USERNAME/exercises/linked-lists/
git commit -m "fix(ds3): address linked list review feedback"
git push
```

Adapta la ruta a tu entrega. El pull request existente se actualiza automáticamente. Responde a los comentarios explicando lo que cambiaste o formulando una pregunta concreta. El docente decide si integra la contribución; los estudiantes no hacen merge directamente en el repositorio del curso.

Si tu rama necesita los cambios recientes del repositorio del curso, primero registra tu trabajo actual con un commit, permanece en tu rama de contribución y ejecuta:

```bash
git fetch upstream
git merge upstream/main
```

Si aparecen conflictos, revisa y resuelve cada archivo afectado, selecciona los archivos resueltos con `git add` y registra el merge con un commit antes de hacer push. Pide ayuda si el conflicto involucra trabajo de otro estudiante; no sobrescribas sus cambios. Vuelve a ejecutar tus comprobaciones después de resolver los conflictos.

Una vez integrado tu pull request, repite el paso 3 y crea una **rama nueva** para la siguiente contribución.

## 8. Colabora con tu equipo

Cada integrante mantiene su propio fork y contribuye a la misma carpeta de equipo asignada en el repositorio del curso. Dividan el trabajo en tareas concretas y acuerden quién modifica cada archivo. Cada integrante puede presentar un pull request con su aporte; una sola persona no debería convertirse en quien siempre sube el trabajo de todos.

Para facilitar el inicio, esperen a que se integre el pull request que crea la carpeta del equipo. Después, cada integrante se sincroniza desde `upstream/main` y crea una rama para su tarea. Si una tarea depende de otra, esperen a que se integre la primera, sincronicen de nuevo y comiencen la tarea dependiente. Así no necesitan permisos de escritura en el fork de otro estudiante.

Revisen los pull requests de sus compañeros y documenten los aportes en el README de la entrega, salvo que la actividad exija otra ubicación, como ocurre en el Quiz 03. Una entrega conjunta puede tener varios pull requests de desarrollo; respeten las instrucciones de la tarea para la entrega final. Si programan en pareja, documenten ambos participantes y sus funciones. Eviten pull requests duplicados con el mismo código.

## Antes de solicitar revisión

- La contribución está en el grupo del curso correcto y en la carpeta individual o de equipo correspondiente.
- Solo se modificaron los archivos previstos; no se alteró trabajo de otros estudiantes ni archivos del docente.
- El código funciona y las comprobaciones reproducibles y sus resultados reales están documentados donde lo exige la tarea.
- La autoría, las referencias y las limitaciones conocidas están documentadas en los lugares correspondientes.
- No se incluyen credenciales, información personal de estudiantes ni archivos compilados.

Lectura complementaria: [flujo de contribución de GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project).
