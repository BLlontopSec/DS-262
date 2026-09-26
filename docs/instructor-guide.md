# Instructor setup and rollout proposal

## Why this organization

DS3 and DS4 each contain `individual/` and `teams/`. Personal work belongs to a stable GitHub username; collaborative work belongs to an assigned team. Within each team, `labs/` and `projects/` separate the two submission types. The instructor's shared material stays outside these student areas.

This supports sustained practice with Git and code review. Keep pull requests focused so reviewing a whole class remains manageable. Use assignment identifiers consistently across both groups, and assess correctness, explanations, testing, and participation rather than raw contribution counts.

## Before inviting students

1. Publish this structure and guide to the course repository when ready.
2. Confirm that students can access and fork the repository. Public submissions are visible to the class; for work that must remain unseen until a deadline, use a private submission channel or separate private assignment repositories as appropriate.
3. Assign team numbers within each group and publish assignment identifiers, deadlines, collaboration rules, and grading criteria through the course channel.
4. Configure a GitHub branch protection rule or ruleset for `main` to require pull requests and instructor approval before merging. Avoid granting students bypass permissions. Check availability for the repository's visibility and GitHub plan. Documentation alone does not enforce these restrictions.
5. Keep merge authority with the instructor or designated teaching staff. Students use their forks and do not need write access to the course repository.

GitHub settings have **not** been changed by adding this guide. See [GitHub's protected branch documentation](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches).

## Student access and collaborator invitations

For a public repository, students do not need collaborator invitations: they fork, push to their own forks, and submit pull requests. Share the repository link and the [beginner Git guide](git-guide.md). Add designated teaching staff only when they need repository permissions for their duties.

For a private repository, grant the necessary access and verify that repository and organization policies allow forks before using this workflow. A `teams/team-NN/` directory is organizational structure, not a GitHub permission boundary. See [GitHub's fork documentation](https://docs.github.com/en/pull-requests/reference/forks).

## Suggested first session

- Demonstrate fork, clone, `origin`, and `upstream` with one small example.
- Have each student submit a first pull request creating their personal README.
- Have one member per team submit the team README listing members.
- Request a small correction so students practice updating an existing pull request.
- Merge accepted setup contributions before students begin dependent submissions.

## Recurring assignment cycle

Copy the [assignment template](../assignments/TEMPLATE.md) into `assignments/TASK-ID/README.md`, complete its requirements and evaluation criteria, and list the published task in the [assignment index](../assignments/README.md). Include the applicable groups, deadline, expected location, Java version, and checks. Use `exercises/` only for supplementary instructor resources and link them from the task. Students synchronize, create a branch, implement, test, and open a pull request. Encourage draft pull requests for substantive early questions. Review folder scope, correctness, complexity claims, tests, documentation, and attribution. Request changes on the existing pull request and merge once acceptable.

For group work, encourage separate focused contributions from different members and peer review within the team. Avoid assigning multiple beginners simultaneous edits to the same files. Keep grading feedback and grades in the institution's designated private system.

## Automation later

Once assignments have consistent build and test commands, consider automated checks for those commands and submission paths. There is currently no shared build/test convention or automated enforcement of folder ownership. Human review is required; the pull request checklist is guidance, not an access-control mechanism.
