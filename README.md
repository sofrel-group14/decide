# DECIDE 🚀💥
A Launch Interceptor Program written in Java.

# What it is
It is as simple as it sounds. DECIDE is a program that decides, based on input data, if it should launch an intercepting missile or not.

## Tools used

Uses Java (JDK 15) with Maven as build system and JUnit for testing.

### Necessary downloads

1. [Download JDK 15](https://www.oracle.com/se/java/technologies/javase-downloads.html)
2. [Download Maven](https://maven.apache.org/download.cgi) ([installation instructions](https://maven.apache.org/install.html))

# How to contribute

## Code

Code should follow the [Google Java Styleguide](https://google.github.io/styleguide/javaguide.html).

**Each function has to be associated with at least one test** (i.e. unit testing). See the [Testing](#testing) section for details. This is one of the mandatory grading criterias.

## Issues

Issues should be categorized using the existing labels (bug, documentation, enhancement, etc.).

They should also immediately be linked to the DECIDE project board (specifically the backlog column, i.e. the one chosen by default), so that they are visible there as well.

**IMPORTANT**: Assign yourself to an issue before you start working on it. This is to avoid having two or more people accidentally doing "double work". Make sure to coordinate with the assignee of an issue before starting to work on it yourself.

## Commits

Commit messages should always be written in an editor and not the terminal. This is to avoid the pitfall of short and non-descriptive commit messages.

```
git commit -m "Short message"       # bad
git commit                          # good
```

Note that you can [change](https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration#_core_editor) which editor git will open, in case you don't like the default one. To switch to *nano*, for example, use: `git config --global core.editor nano`.

That said, if a short message suffices to explain the commit, that is perfectly fine.

Commit messages should be linked to corresponding issues where applicable (this is done by referencing the issue number as `#<issue number>`). Note that commits should almost always be related to some issue (see grading criteria). If there's no related issue, one should probably be created before committing.

Commit messages should follow a prefix-convention, with the following prefixes:
* feat - for new features/functionality
* fix - for bug fixes
* doc - for documentation
* refactor - for refactoring
* format - for changing formatting such as newlines, indentation, etc.
* test - for editing or adding new tests (to already existing features, see paragraph below)
* misc - for anything not covered by prefixes above

**Note** that each commit that adds new functionality must also contain corresponding tests for that functionality (in the same commit).

**Examples:**

```
(feat) Implement LIC 7 along with corresponding unit tests, fixing #12
```

```
(test) Add additional unit test for LIC 7

This covers a previously untested edge case where X < 0. Related to #12.
```

## Branches

Branches should be linked to issues through their names, as:  
`issue-<issue number>-short-description-of-branch`

**Example:** `issue-12-lic-7` if issue 12 is related to implementing LIC 7.

(This naming convention adheres to [widely used community conventions](https://github.com/agis/git-style-guide#branches).)

## Pull requests

* Make sure to mention the issue that a pull request targets. This will close the issue automatically, when the branch is merged ([source](https://docs.github.com/en/github/managing-your-work-on-github/linking-a-pull-request-to-an-issue#linking-a-pull-request-to-an-issue-using-a-keyword)).
* At least two people have to code review before merging.
* Merge into the `development` branch.

Example:
```
This PR implements LIC 0.

Fixes: #6
```

# Testing

* All tests **must** be accompanied by a description in natural language (grading criteria). 
* Functionality and corresponding (unit) tests should be added in the same commit.
* Take extra care to consider edge cases when constructing tests.
* Prefer several smaller tests over few but large tests.

# Statement of contribution
Axel and Andreas pair-programmed the code skeleton for CMV. Yannis set up CI with Github actions. Andreas created a draft for the README over the weekend. We split up the LICs to be three per person (two for Andreas, four for Taqui), and we all reviewed each others PR:s.
This is also where to add a note if we do something "extraordinary" worthy of P+.

## What we're proud of
We like our CI that runs tests for us. At least twice this has made us aware of curly brackets disappearing when resolving merge conflics.
Also, we estimate that >90% of our branch names, commit messages etc. are consistent with the conventions in the README.

