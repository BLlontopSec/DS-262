# Git y GitHub: primera contribución al curso

Esta guía explica los comandos desde cero. Lean también las [reglas de contribución](../CONTRIBUTING.md) y las [instrucciones de su tarea](../assignments/README.md).

## ¿El docente debe agregar a todos como colaboradores?

**Si el repositorio es público, no.** Cada estudiante crea un fork en su propia cuenta, sube allí sus cambios y propone incorporarlos al repositorio del curso mediante un pull request (PR). No necesita permiso para escribir directamente en el repositorio del docente.

Si el repositorio es privado, el docente debe otorgar acceso y comprobar que las políticas permiten crear forks. No asuman que tener el enlace basta para acceder. Los permisos para ayudar a revisar y fusionar se reservan al docente y a los auxiliares designados.

Una carpeta `team-01/` organiza archivos; no crea un equipo de permisos en GitHub ni restringe técnicamente quién puede proponer cambios en ella. El docente revisa que cada contribución respete su carpeta.

## Conceptos básicos

| Concepto | Significado |
| --- | --- |
| Git | Herramienta que guarda el historial de cambios en el computador |
| GitHub | Servicio donde se alojan repositorios y se revisan contribuciones |
| Fork | Copia del repositorio del curso en tu cuenta de GitHub |
| Clone | Copia de un repositorio de GitHub en tu computador |
| Branch o rama | Línea de trabajo para una contribución concreta |
| Stage / `git add` | Selección de cambios para el siguiente commit |
| Commit | Registro local de los cambios seleccionados |
| Push | Envío de commits locales a GitHub |
| Pull request | Solicitud para revisar e incorporar una rama a otro repositorio o rama |
| Merge | Integración de cambios; el docente realiza la integración al repositorio del curso |

```text
Repositorio del curso (upstream)
            │ fork
            ▼
Tu repositorio en GitHub (origin)
            │ clone
            ▼
Tu computador: editar → add → commit
            │ push
            ▼
Tu rama en tu fork → pull request → revisión del docente → main del curso
```

Un commit no sube archivos a GitHub. Un push a tu fork no entrega automáticamente la tarea al docente: también debes abrir el PR.

## 1. Preparar las herramientas

Necesitas una cuenta de GitHub, Git instalado y el JDK que exija la tarea. En Windows puedes usar Git Bash; en macOS o Linux, una terminal. Comprueba:

```bash
git --version
java -version
javac -version
```

Si falta Git, consulta la [instalación oficial](https://git-scm.com/downloads). Si falta Java, instala el JDK requerido por la tarea antes de compilar. Para Quiz 03 se necesita Java 16 o superior.

## 2. Crear tu fork — una vez

1. Inicia sesión en GitHub y abre [byepesg/DS-262](https://github.com/byepesg/DS-262).
2. Selecciona **Fork**, elige tu cuenta como propietario y conserva el nombre `DS-262`.
3. Crea el fork. Si ya tienes uno, reutilízalo.

En los siguientes comandos, reemplaza `TU-USUARIO` por tu usuario real de GitHub. No escribas literalmente ese marcador.

## 3. Clonar tu fork y configurar Git — una vez por computador

Abre una terminal en la carpeta donde quieres guardar el proyecto:

```bash
git clone https://github.com/TU-USUARIO/DS-262.git
cd DS-262
git remote add upstream https://github.com/byepesg/DS-262.git
git remote -v
```

Verifica que `origin` apunta a **tu usuario** y `upstream` a **byepesg**. El clone ya crea `origin`; no debes agregarlo otra vez.

Configura la identidad de tus commits para esta copia del repositorio, reemplazando ambos valores:

```bash
git config user.name "Tu nombre"
git config user.email "TU-CORREO-DE-COMMITS"
```

Usa un correo asociado a tu cuenta o copia tu dirección `noreply` de los ajustes de correo de GitHub. Estos datos identifican al autor, pero no inician sesión en GitHub.

Para autenticar los pushes por HTTPS puedes usar Git Credential Manager o, si tienes GitHub CLI instalado, ejecutar `gh auth login`, elegir GitHub.com y HTTPS y seguir el inicio de sesión en el navegador. GitHub no admite la contraseña de la cuenta como contraseña de Git por HTTPS. No guardes tokens en archivos del proyecto ni los incluyas en comandos compartidos. Consulta la [autenticación oficial](https://docs.github.com/en/get-started/git-basics/caching-your-github-credentials-in-git).

## 4. Actualizar antes de cada nueva tarea

Ejecuta los comandos desde la raíz de `DS-262/`. Primero revisa el estado:

```bash
git status
```

Si tienes trabajo pendiente, termínalo y haz commit en su rama antes de cambiar. Con el árbol de trabajo limpio:

```bash
git switch main
git fetch upstream
git merge --ff-only upstream/main
git push origin main
```

`fetch` descarga el historial del curso; `merge --ff-only` actualiza tu `main` sin crear una mezcla de historiales divergentes; `push` actualiza tu fork. `git pull` combina descarga e integración, pero en este curso usamos los pasos separados para saber de qué repositorio vienen los cambios.

Si el avance rápido falla, pide ayuda y conserva tu trabajo. No uses `--force` ni `reset --hard` para intentar arreglarlo.

## 5. Crear una rama y trabajar

Ejemplo para Quiz 03, **DS3, equipo 01**:

```bash
git switch -c ds3/team-01/quiz-03
```

Adapta el grupo y equipo a los tuyos. Para una contribución individual puedes usar `ds4/individual/TU-USUARIO/exercise-01`. No trabajes directamente en `main`.

Crea o edita los archivos de tu entrega en un editor. En el ejemplo de Quiz 03 corresponden a `DS3/teams/team-01/labs/quiz-03/`. Respeta mayúsculas en las carpetas `DS3` y `DS4`. Lee el [formato exacto de Quiz 03](../assignments/quiz-03/README.md) y ejecuta las comprobaciones de la tarea antes de continuar.

## 6. Seleccionar archivos y crear un commit

Desde la raíz del repositorio, para el ejemplo anterior:

```bash
git status
git diff
git add DS3/teams/team-01/labs/quiz-03/
git diff --cached
git commit -m "feat(ds3-team01): implement quiz 03"
```

- `status` muestra archivos nuevos, modificados y seleccionados.
- `diff` muestra cambios aún no seleccionados en archivos que Git ya sigue; no muestra el contenido de archivos nuevos sin agregar.
- `add` selecciona los archivos de tu entrega. Usa rutas concretas para evitar incluir trabajo ajeno.
- `diff --cached` permite revisar lo seleccionado antes del commit. Revisa los PDF con un visor: el diff no muestra su contenido visual.
- `commit` guarda esa versión en tu computador. Puedes hacer varios commits con mensajes claros durante el trabajo.

## 7. Subir la rama a tu fork

Para el primer push de esta rama:

```bash
git push -u origin ds3/team-01/quiz-03
```

Después de nuevos commits en la misma rama basta con `git push`. El destino es tu fork, no el repositorio del docente.

## 8. Abrir el pull request

En GitHub, abre tu fork y selecciona la opción para comparar cambios y crear un pull request. Comprueba:

| Campo | Valor |
| --- | --- |
| Base repository | `byepesg/DS-262` |
| Base branch | `main` |
| Head repository | `TU-USUARIO/DS-262` |
| Compare branch | Tu rama, por ejemplo `ds3/team-01/quiz-03` |

Pon un título descriptivo, completa la plantilla y revisa **Files changed**. Incluye el enlace a la tarea y resultados reales de las comprobaciones. Envía el PR y comparte su enlace por el canal del curso si se solicita. No crees otro PR idéntico si ya hay uno abierto para esa entrega.

## 9. Corregir después de la revisión

Sigue trabajando en la misma rama del PR. Después de editar y probar:

```bash
git add DS3/teams/team-01/labs/quiz-03/
git commit -m "fix(ds3-team01): address quiz review feedback"
git push
```

El PR se actualiza automáticamente. Responde a los comentarios explicando las correcciones. Cuando el docente lo fusione, vuelve al paso 4 y crea una rama nueva para la siguiente contribución.

## 10. Trabajar en equipo

Cada integrante puede tener su fork; no necesitan ser colaboradores del repositorio del docente. Usen el mismo número de equipo del proyecto y coordinen quién modifica cada archivo.

Para comenzar, pueden entregar aportes pequeños: cuando se fusiona uno al curso, los demás actualizan desde `upstream` antes de construir sobre él. Si un integrante integra la entrega conjunta, los demás también pueden proponerle cambios mediante PR a su fork; revisen cuidadosamente el repositorio base para no confundir ese PR interno con la entrega al docente. Un push al fork de un compañero requiere permisos en ese fork, pero proponerle un PR en un repositorio público no los requiere.

Sigan la modalidad de la tarea: para Quiz 03, mantengan una entrega final conjunta, documenten los aportes y eviten copias idénticas por integrante. El docente o auxiliar designado revisa y fusiona en el repositorio del curso; no aprueba cada commit por separado.

## Problemas frecuentes

| Mensaje o situación | Qué revisar |
| --- | --- |
| `git: command not found` | Instala Git y abre una nueva terminal |
| `not a git repository` | Entra con `cd` a la copia clonada de `DS-262` |
| `remote upstream already exists` | Usa `git remote -v`; si ya apunta al curso, no lo agregues otra vez |
| No puedo hacer push / permiso denegado | Revisa que `origin` sea tu fork y que estés autenticado con su cuenta |
| Cloné el repositorio del docente | Crea tu fork y, tras revisar `git remote -v`, cambia `origin` con `git remote set-url origin https://github.com/TU-USUARIO/DS-262.git`; conserva o agrega `upstream` apuntando al docente |
| `nothing to commit` | Revisa si guardaste el archivo, si estás en la carpeta correcta o si ya hiciste commit |
| Rama ya existente | Usa `git switch NOMBRE-DE-RAMA` para retomarla; no intentes crearla de nuevo |
| Push rechazado por cambios remotos | No fuerces el push; revisa quién modificó la rama y pide ayuda para integrar los cambios |
| Conflicto al integrar cambios | Conserva tu trabajo y pide ayuda; no borres cambios de otro equipo. Consulta también CONTRIBUTING.md |
| Mi código aparece en mi fork, pero no en el curso | Verifica que abriste el PR hacia el curso y espera su revisión y merge |

## Referencias

- [Contribuir con forks y pull requests](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project).
- [Forks y condiciones de acceso](https://docs.github.com/en/pull-requests/reference/forks).
