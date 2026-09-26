# DS-262 — Estructuras de Datos

Repositorio del curso de Estructuras de Datos de la Universidad Nacional de Colombia, a cargo de **Sebastián Yepes García**, semestre **2026-2**.

Aquí los estudiantes de **DS3 (grupo 03)** y **DS4 (grupo 04)** entregan ejercicios individuales, laboratorios y proyectos en equipo. Además de implementar estructuras de datos en Java, practicarán contribuciones mediante Git, pull requests y revisión de código durante el semestre.

## Empieza aquí

1. **Aprende el flujo de Git.** Si es tu primera contribución, sigue la [guía de Git y GitHub paso a paso](docs/git-guide.md): configurar Git, crear un fork, clonar, hacer commits, subir cambios y abrir un pull request.
2. **Lee la tarea asignada.** Consulta el [índice de actividades](assignments/README.md). Cada enunciado define requisitos, modalidad, archivos, validaciones y fecha de entrega.
3. **Identifica tu destino.** Usa `DS3/` o `DS4/` y el área individual o de equipos según la actividad. Las rutas se explican abajo.
4. **Prepara y entrega tu contribución.** Sigue las [reglas de contribución](CONTRIBUTING.md), prueba tu código y abre un pull request hacia `main` del repositorio del curso.
5. **Atiende la revisión.** Corrige en la misma rama y responde a los comentarios. El docente o auxiliar designado revisa y fusiona la contribución.

## Actividades disponibles

| Actividad | Grupos | Modalidad | Instrucciones |
| --- | --- | --- | --- |
| Quiz 03 — Dynamic Arrays and Amortized Analysis | DS3 y DS4 | Mismos integrantes y número de equipo del proyecto | [Guía de entrega y enunciado](assignments/quiz-03/README.md) |

La fecha límite del Quiz 03 para DS3 y DS4 es el **domingo 27 de septiembre de 2026 a las 23:59, hora de Colombia (America/Bogota, UTC−5)**. Consulta el [índice de actividades](assignments/README.md) para nuevas tareas y las instrucciones de cada actividad para sus requisitos vigentes.

## Dónde guardar tu trabajo

Reemplaza `TU-USUARIO` por tu usuario de GitHub, `team-NN` por el equipo asignado y `ID-TAREA` por el identificador del enunciado. Conserva las mayúsculas de `DS3` y `DS4`.

| Trabajo | DS3 — Grupo 03 | DS4 — Grupo 04 |
| --- | --- | --- |
| Ejercicio individual | `DS3/individual/TU-USUARIO/exercises/ID-TAREA/` | `DS4/individual/TU-USUARIO/exercises/ID-TAREA/` |
| Laboratorio o quiz en equipo | `DS3/teams/team-NN/labs/ID-TAREA/` | `DS4/teams/team-NN/labs/ID-TAREA/` |
| Proyecto en equipo | `DS3/teams/team-NN/projects/ID-TAREA/` | `DS4/teams/team-NN/projects/ID-TAREA/` |

Cada estudiante crea su carpeta personal con un README en su primera contribución. Un integrante crea la carpeta del equipo y su README con los usuarios de GitHub de todos sus miembros; los demás reutilizan esa misma carpeta. Las carpetas personales y de equipos que aparecen como ejemplos no están creadas de antemano. Git conserva archivos, no carpetas vacías.

Por ejemplo, la entrega del Quiz 03 del equipo 01 de DS3 va en `DS3/teams/team-01/labs/quiz-03/`. No se crea una copia por integrante. Todos deben poder explicar la solución, como establece el enunciado.

## Mapa del repositorio

```text
DS-262/
├── DS3/
│   ├── individual/             # Una carpeta por estudiante
│   └── teams/                  # Una carpeta por equipo: labs/ y projects/
├── DS4/
│   ├── individual/
│   └── teams/
├── assignments/                # Instrucciones de cada actividad
│   ├── README.md               # Índice de actividades
│   ├── TEMPLATE.md             # Plantilla para el docente
│   └── quiz-03/                # Guía y PDF del Quiz 03
├── implementations/instructor/ # Implementaciones de referencia del docente
├── exercises/                  # Recursos complementarios del docente
├── docs/                       # Guías y material de apoyo
├── .github/                    # Plantilla de pull request
├── CONTRIBUTING.md             # Reglas de contribución
└── README.md                   # Punto de entrada al repositorio
```

Las instrucciones se consultan en `assignments/`; las soluciones se entregan en `DS3/` o `DS4/`. El `README.md` que acompaña cada solución debe respetar el formato de su tarea. Por ejemplo, **Quiz 03 exige únicamente versión de Java e instrucciones de compilación y ejecución en ese README**, y un `analysis.pdf` separado de máximo cuatro páginas. Lee su guía completa antes de empezar.

## Cómo llega tu código al repositorio del curso

```text
Fork en tu cuenta → clone en tu computador → rama de trabajo
      → editar y probar → git add → git commit → git push a tu fork
      → pull request al curso → revisión y correcciones → merge a main
```

- **Una vez:** crea tu fork y clónalo. `origin` apunta a tu fork; `upstream` apunta a `byepesg/DS-262`.
- **Antes de cada contribución:** sincroniza con `upstream/main` y crea una rama nueva. Los comandos explicados están en la [guía de Git](docs/git-guide.md).
- **Durante el trabajo:** guarda cambios con commits claros y sube tu rama a tu fork. Un commit es local; un push por sí solo no constituye una entrega al curso.
- **Al entregar:** abre el PR con repositorio base `byepesg/DS-262` y rama base `main`. Incluye el enlace a la tarea, ruta de entrega, integrantes o autor y resultados reales de las comprobaciones.
- **Durante la revisión:** sigue usando la misma rama. Los nuevos commits y pushes actualizan el PR existente.
- **Después del merge:** sincroniza de nuevo antes de comenzar la siguiente tarea.

Coordinen los aportes del equipo y eviten entregas duplicadas. Pueden hacer contribuciones pequeñas a lo largo del semestre; sigan las instrucciones específicas de cada tarea para reunir la entrega final. La cantidad de commits o PR por sí sola no demuestra aprendizaje.

## ¿Necesito una invitación del docente?

**Si el repositorio es público, no necesitas ser colaborador para contribuir mediante tu fork y un pull request.** Haces push a tu propio repositorio y el docente decide qué se incorpora al del curso. Si el repositorio es privado, necesitas acceso y que sus políticas permitan crear forks. Consulta las [condiciones de GitHub para forks](https://docs.github.com/en/pull-requests/reference/forks).

Las carpetas organizan entregas; no otorgan permisos ni impiden técnicamente editar otras carpetas. Modifica únicamente tu trabajo individual o el de tu equipo, salvo autorización expresa del docente. Los permisos de revisión y merge se reservan al docente y los auxiliares designados.

## Reglas básicas

- Lee el enunciado completo y usa el JDK que exige la actividad; Quiz 03 requiere Java 16 o superior.
- Entrega trabajo propio, identifica aportes del equipo y cita referencias o asistencia según las reglas del curso.
- No presentes código del docente o de otros equipos como propio.
- No modifiques instrucciones, implementaciones del docente ni carpetas ajenas sin autorización.
- No subas archivos compilados, credenciales, documentos de identidad ni calificaciones.
- Prueba tu entrega y documenta cómo ejecutarla en el lugar y formato exigidos por la tarea.
- Respeta las indicaciones sobre publicación: las contribuciones en repositorios y forks públicos son visibles para otros.

## Para el docente y auxiliares

Consulta la [guía del instructor](docs/instructor-guide.md) para organizar el inicio del curso, acceso, revisión y configuración de protección de `main`. Para publicar una actividad, copia la [plantilla de instrucciones](assignments/TEMPLATE.md), completa sus requisitos y agrega su enlace al [índice de actividades](assignments/README.md).

Las reglas escritas y las listas de verificación orientan la revisión; por sí solas no configuran protecciones de GitHub ni validaciones automáticas.
