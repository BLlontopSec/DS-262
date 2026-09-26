# Student contribution guide

## Before starting: read the task instructions

Open the [assignment index](assignments/README.md), select the task assigned by your instructor, and read its requirements, deadline, deliverables, destination folder, and evaluation criteria. Only published tasks are assignments; the template is not a submission request. Follow the task's specific requirements together with this Git workflow. If they appear inconsistent, ask the instructor before proceeding.

Task-specific submission formats take precedence over the generic README requirements below. For Quiz 03, the submission README contains only the Java version and compile/run instructions; authorship belongs in the team README and pull request, and analysis belongs in `analysis.pdf`.

Include the assignment identifier and a link to its instructions in your pull request. Do not modify files under `assignments/` unless explicitly authorized by the instructor.

## 1. Choose the correct destination

| Work | DS3 — Group 03 | DS4 — Group 04 |
| --- | --- | --- |
| Individual | `DS3/individual/YOUR-USERNAME/` | `DS4/individual/YOUR-USERNAME/` |
| Team labs | `DS3/teams/team-NN/labs/` | `DS4/teams/team-NN/labs/` |
| Team projects | `DS3/teams/team-NN/projects/` | `DS4/teams/team-NN/projects/` |

Replace `YOUR-USERNAME` with your GitHub username and `team-NN` with the instructor-assigned team number, such as `team-01`. Keep these names stable. Teams in different course groups can have the same number. Use lowercase names with hyphens for assignment folders, using the assignment identifier given by the instructor.

Create your individual folder yourself in your first pull request. Include a `README.md` with your GitHub username, course group, and an index of your submissions. For a team folder, one member submits the initial pull request with a `README.md` listing the assigned team number, members' GitHub usernames, and an index of labs and projects. Other members use that same team folder after it is merged.

Git tracks files, not empty folders. Create a folder with its README or source files when you need it.

## 2. One-time setup: fork and clone

Open [the course repository](https://github.com/byepesg/DS-262) and create a fork under your own GitHub account. Clone **your fork**. Replace `YOUR-USERNAME` before running:

```bash
git clone https://github.com/YOUR-USERNAME/DS-262.git
cd DS-262
git remote add upstream https://github.com/byepesg/DS-262.git
git remote -v
```

`origin` is your fork, where you push your branches. `upstream` is the instructor's repository, where accepted contributions are merged. Authenticate to GitHub with your configured credential manager, GitHub CLI, or SSH setup when pushing; never put credentials in a repository file.

## 3. Start every new contribution from the current course version

Finish and commit any work on your existing branch before switching branches. Then:

```bash
git switch main
git fetch upstream
git merge --ff-only upstream/main
git push origin main
```

Keep your fork's `main` branch for synchronization. If the fast-forward merge fails, stop and ask for help; do not force-push or discard your work.

Create a branch for one focused contribution. Examples:

```bash
git switch -c ds3/individual/YOUR-USERNAME/linked-lists
```

For team work, use a branch such as `ds4/team-01/lab-01`. Branch names use lowercase `ds3` or `ds4`; folder names use uppercase `DS3` or `DS4`.

## 4. Add code and documentation

An individual exercise might contain:

```text
DS3/individual/YOUR-USERNAME/exercises/linked-lists/
├── README.md
├── SinglyLinkedList.java
└── Main.java
```

A team submission might contain:

```text
DS4/teams/team-01/labs/lab-01/
├── README.md
├── src/
└── tests/
```

Each exercise, lab, or project README must explain:

- Assignment identifier and what is implemented.
- Author's GitHub username, or team members and each person's contribution.
- Required Java version and exact commands to compile and run from that submission's folder.
- How to run tests or reproducible examples, with expected results.
- Relevant operation time complexities and the assumptions behind them.
- Known limitations and references, including assistance disclosures required by the course.

Use the assignment's requested structure and tools. For a simple Java exercise without packages, a README could provide:

```bash
javac -d out SinglyLinkedList.java Main.java
java -cp out Main
```

Adapt these commands to your actual files. Test normal behavior and relevant edge cases, such as an empty structure, one element, or invalid operations. Do not submit generated `.class` files or build directories.

## 5. Review, commit, and push

For an individual DS3 exercise, replace the username and use:

```bash
git status
git diff
git add DS3/individual/YOUR-USERNAME/exercises/linked-lists/
git diff --cached
git commit -m "feat(ds3): implement linked list exercise"
git push -u origin ds3/individual/YOUR-USERNAME/linked-lists
```

For an initial folder setup, stage your new personal README instead. For team work, stage only the relevant team submission and push your team-work branch. Check the staged diff so unrelated changes do not enter your commit.

## 6. Open a pull request to the course repository

On GitHub, open a pull request with:

- **Base repository:** `byepesg/DS-262`.
- **Base branch:** `main`.
- **Head repository:** your fork.
- **Compare branch:** your contribution branch.

Use a title such as `[DS3][Individual][YOUR-USERNAME] Linked lists` or `[DS4][team-01] Lab 01`. Fill out the pull request template, including what changed and how you checked it. Inspect the Files changed view before submitting. Use a draft pull request when you want early feedback on unfinished work; mark it ready for review when complete.

A push to your fork alone is not a submission to the course repository. Share the pull request link through the course's designated submission channel if the assignment requires it. Deadlines and grading criteria come from the assignment.

## 7. Respond to review

Make requested corrections on the same branch, run the relevant checks again, then:

```bash
git add DS3/individual/YOUR-USERNAME/exercises/linked-lists/
git commit -m "fix(ds3): address linked list review feedback"
git push
```

Adapt the path for your submission. The existing pull request updates automatically. Reply to feedback with what you changed or a concrete question. The instructor decides whether to merge; students do not merge into the course repository themselves.

If your branch needs updates from the course repository, commit your current work first, stay on your contribution branch, and run:

```bash
git fetch upstream
git merge upstream/main
```

If there are conflicts, resolve each affected file deliberately, stage the resolved files, and commit the merge before pushing. Ask for help if a conflict involves another student's work; do not overwrite their changes. Run your checks again after resolving conflicts.

After your pull request is merged, repeat step 3 and create a **new branch** for the next contribution.

## 8. Collaborate as a team

Every member keeps their own fork and contributes to the same assigned team directory in the course repository. Divide work into focused tasks and agree who changes which files. Each member can submit their own pull request for their part; a single member should not be the permanent uploader for everyone.

For a beginner-friendly workflow, first merge the team setup pull request. Then each teammate synchronizes from `upstream/main` and creates a branch for their task. When one task depends on another, wait for the prerequisite to merge, synchronize again, and start the dependent task. This avoids needing write access to another student's fork.

Review teammates' pull requests and record contributions in the submission README. A joint deliverable may have several pull requests. If you pair-program, document both contributors and their roles. Avoid duplicate pull requests containing the same code.

## Before requesting review

- The contribution is in the correct course group and individual or team folder.
- Only intended files changed; no other student's work or instructor files were modified.
- Code runs and the README includes reproducible checks and actual results.
- Authors, references, and known limitations are documented.
- No credentials, personal student records, or compiled output are included.

Further reading: [GitHub's contribution workflow](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project).
